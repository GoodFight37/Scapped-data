package com.unity.androidnotifications;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.unity3d.player.UnityPlayer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class UnityNotificationManager extends BroadcastReceiver {
    public static final String KEY_BIG_CONTENT_DESCRIPTION = "com.unity.BigContentDescription";
    public static final String KEY_BIG_CONTENT_TITLE = "com.unity.BigContentTytle";
    public static final String KEY_BIG_LARGE_ICON = "com.unity.BigLargeIcon";
    public static final String KEY_BIG_PICTURE = "com.unity.BigPicture";
    public static final String KEY_BIG_SHOW_WHEN_COLLAPSED = "com.unity.BigShowWhenCollapsed";
    public static final String KEY_BIG_SUMMARY_TEXT = "com.unity.BigSummaryText";
    public static final String KEY_CHANNEL_ID = "channelID";
    public static final String KEY_FIRE_TIME = "fireTime";
    public static final String KEY_ID = "id";
    public static final String KEY_INTENT_DATA = "data";
    public static final String KEY_LARGE_ICON = "largeIcon";
    public static final String KEY_NOTIFICATION = "unityNotification";
    public static final String KEY_NOTIFICATION_DISMISSED = "com.unity.NotificationDismissed";
    public static final String KEY_NOTIFICATION_ID = "com.unity.NotificationID";
    public static final String KEY_REPEAT_INTERVAL = "repeatInterval";
    public static final String KEY_SHOW_IN_FOREGROUND = "com.unity.showInForeground";
    public static final String KEY_SMALL_ICON = "smallIcon";
    static final String NOTIFICATION_CHANNELS_SHARED_PREFS = "UNITY_NOTIFICATIONS";
    static final String NOTIFICATION_CHANNELS_SHARED_PREFS_KEY = "ChannelIDs";
    private static final int NOTIFICATION_DEFAULT_INIT = 0;
    static final String NOTIFICATION_IDS_SHARED_PREFS = "UNITY_STORED_NOTIFICATION_IDS";
    static final String NOTIFICATION_IDS_SHARED_PREFS_KEY = "UNITY_NOTIFICATION_IDS";
    private static final int PERMISSION_STATUS_ALLOWED = 1;
    private static final int PERMISSION_STATUS_DENIED = 2;
    private static final int PERMISSION_STATUS_NOTIFICATIONS_BLOCKED_FOR_APP = 5;
    static final String TAG_UNITY = "UnityNotifications";
    static UnityNotificationManager mUnityNotificationManager;
    private UnityNotificationBackgroundThread mBackgroundThread;
    private NotificationCallback mNotificationCallback;
    private Random mRandom;
    private ConcurrentHashMap<Integer, Notification.Builder> mScheduledNotifications;
    private HashSet<Integer> mVisibleNotifications;
    private Context mContext = null;
    private Activity mActivity = null;
    private Class mOpenActivity = null;
    private int mExactSchedulingSetting = -1;

    private void initialize(Activity activity, NotificationCallback notificationCallback) {
        this.mContext = activity.getApplicationContext();
        this.mActivity = activity;
        this.mNotificationCallback = notificationCallback;
        if (this.mScheduledNotifications == null) {
            this.mScheduledNotifications = new ConcurrentHashMap<>();
        }
        UnityNotificationBackgroundThread unityNotificationBackgroundThread = this.mBackgroundThread;
        if (unityNotificationBackgroundThread == null || !unityNotificationBackgroundThread.isAlive()) {
            this.mBackgroundThread = new UnityNotificationBackgroundThread(this, this.mScheduledNotifications);
        }
        if (this.mRandom == null) {
            this.mRandom = new Random();
        }
        if (this.mVisibleNotifications == null) {
            this.mVisibleNotifications = new HashSet<>();
        }
        Bundle appMetadata = getAppMetadata();
        Boolean boolValueOf = false;
        if (appMetadata != null) {
            boolValueOf = Boolean.valueOf(appMetadata.getBoolean("reschedule_notifications_on_restart", false));
        }
        if (boolValueOf.booleanValue()) {
            this.mContext.getPackageManager().setComponentEnabledSetting(new ComponentName(this.mContext, (Class<?>) UnityNotificationRestartReceiver.class), 1, 1);
        }
        Class<?> openAppActivity = UnityNotificationUtilities.getOpenAppActivity(this.mContext);
        this.mOpenActivity = openAppActivity;
        if (openAppActivity == null) {
            throw new RuntimeException("Failed to determine Activity to be opened when tapping notification");
        }
        if (this.mBackgroundThread.isAlive()) {
            return;
        }
        this.mBackgroundThread.start();
    }

    static synchronized UnityNotificationManager getNotificationManagerImpl(Context context) {
        if (mUnityNotificationManager == null) {
            UnityNotificationManager unityNotificationManager = new UnityNotificationManager();
            mUnityNotificationManager = unityNotificationManager;
            unityNotificationManager.mVisibleNotifications = new HashSet<>();
            mUnityNotificationManager.mScheduledNotifications = new ConcurrentHashMap<>();
        }
        mUnityNotificationManager.mContext = context.getApplicationContext();
        return mUnityNotificationManager;
    }

    public static synchronized UnityNotificationManager getNotificationManagerImpl(Activity activity, NotificationCallback notificationCallback) {
        if (mUnityNotificationManager == null) {
            mUnityNotificationManager = new UnityNotificationManager();
        }
        mUnityNotificationManager.initialize(activity, notificationCallback);
        return mUnityNotificationManager;
    }

    private Bundle getAppMetadata() {
        try {
            return this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public NotificationManager getNotificationManager() {
        return (NotificationManager) this.mContext.getSystemService("notification");
    }

    public int getTargetSdk() {
        return this.mContext.getApplicationInfo().targetSdkVersion;
    }

    public int areNotificationsEnabled() {
        boolean z = Build.VERSION.SDK_INT < 33 || this.mContext.checkCallingOrSelfPermission("android.permission.POST_NOTIFICATIONS") == 0;
        boolean zAreNotificationsEnabled = getNotificationManager().areNotificationsEnabled();
        if (z) {
            return zAreNotificationsEnabled ? 1 : 5;
        }
        return 2;
    }

    public void registerNotificationChannelGroup(String str, String str2, String str3) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannelGroup notificationChannelGroup = new NotificationChannelGroup(str, str2);
            if (Build.VERSION.SDK_INT >= 28) {
                notificationChannelGroup.setDescription(str3);
            }
            getNotificationManager().createNotificationChannelGroup(notificationChannelGroup);
        }
    }

    public void deleteNotificationChannelGroup(String str) {
        if (str == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            getNotificationManager().deleteNotificationChannelGroup(str);
            return;
        }
        for (NotificationChannelWrapper notificationChannelWrapper : getNotificationChannels()) {
            if (str.equals(notificationChannelWrapper.group)) {
                deleteNotificationChannel(notificationChannelWrapper.id);
            }
        }
    }

    private Uri getAndroidResourceUri(String str) {
        int identifier;
        if (str == null || str.isEmpty() || (identifier = this.mContext.getResources().getIdentifier(str, "raw", this.mContext.getPackageName())) == 0) {
            return null;
        }
        return Uri.parse(("android.resource://" + this.mContext.getPackageName() + DomExceptionUtils.SEPARATOR) + identifier);
    }

    public void registerNotificationChannel(String str, String str2, int i, String str3, boolean z, boolean z2, boolean z3, boolean z4, long[] jArr, int i2, String str4, String str5) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(str, str2, i);
            notificationChannel.setDescription(str3);
            notificationChannel.enableLights(z);
            notificationChannel.enableVibration(z2);
            notificationChannel.setBypassDnd(z3);
            notificationChannel.setShowBadge(z4);
            notificationChannel.setVibrationPattern(jArr);
            notificationChannel.setLockscreenVisibility(i2);
            notificationChannel.setGroup(str4);
            Uri androidResourceUri = getAndroidResourceUri(str5);
            if (androidResourceUri != null) {
                notificationChannel.setSound(androidResourceUri, new AudioAttributes.Builder().setUsage(5).setContentType(4).build());
            }
            getNotificationManager().createNotificationChannel(notificationChannel);
            return;
        }
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(NOTIFICATION_CHANNELS_SHARED_PREFS, 0);
        HashSet hashSet = new HashSet(sharedPreferences.getStringSet(NOTIFICATION_CHANNELS_SHARED_PREFS_KEY, new HashSet()));
        hashSet.add(str);
        SharedPreferences.Editor editorClear = sharedPreferences.edit().clear();
        editorClear.putStringSet(NOTIFICATION_CHANNELS_SHARED_PREFS_KEY, hashSet);
        editorClear.apply();
        SharedPreferences.Editor editorEdit = this.mContext.getSharedPreferences(getSharedPrefsNameByChannelId(str), 0).edit();
        editorEdit.putString("title", str2);
        editorEdit.putInt("importance", i);
        editorEdit.putString(MapperConstants.SUBSCRIPTION_FIELD_DESCRIPTION, str3);
        editorEdit.putBoolean("enableLights", z);
        editorEdit.putBoolean("enableVibration", z2);
        editorEdit.putBoolean("canBypassDnd", z3);
        editorEdit.putBoolean("canShowBadge", z4);
        editorEdit.putString("vibrationPattern", Arrays.toString(jArr));
        editorEdit.putInt("lockscreenVisibility", i2);
        editorEdit.putString(MapperConstants.SUBSCRIPTION_FIELD_GROUP, str4);
        Uri androidResourceUri2 = getAndroidResourceUri(str5);
        if (androidResourceUri2 != null) {
            editorEdit.putString("sound", androidResourceUri2.toString());
        } else {
            editorEdit.putString("sound", "");
        }
        editorEdit.apply();
    }

    private static String getSharedPrefsNameByChannelId(String str) {
        return String.format("unity_notification_channel_%s", str);
    }

    public NotificationChannelWrapper getNotificationChannel(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = getNotificationManagerImpl(this.mContext).getNotificationManager().getNotificationChannel(str);
            if (notificationChannel == null) {
                return null;
            }
            return notificationChannelToWrapper(notificationChannel);
        }
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(getSharedPrefsNameByChannelId(str), 0);
        NotificationChannelWrapper notificationChannelWrapper = new NotificationChannelWrapper();
        notificationChannelWrapper.id = str;
        notificationChannelWrapper.name = sharedPreferences.getString("title", "undefined");
        notificationChannelWrapper.importance = sharedPreferences.getInt("importance", 3);
        notificationChannelWrapper.description = sharedPreferences.getString(MapperConstants.SUBSCRIPTION_FIELD_DESCRIPTION, "undefined");
        notificationChannelWrapper.enableLights = sharedPreferences.getBoolean("enableLights", false);
        notificationChannelWrapper.enableVibration = sharedPreferences.getBoolean("enableVibration", false);
        notificationChannelWrapper.canBypassDnd = sharedPreferences.getBoolean("canBypassDnd", false);
        notificationChannelWrapper.canShowBadge = sharedPreferences.getBoolean("canShowBadge", false);
        notificationChannelWrapper.lockscreenVisibility = sharedPreferences.getInt("lockscreenVisibility", 1);
        notificationChannelWrapper.group = sharedPreferences.getString(MapperConstants.SUBSCRIPTION_FIELD_GROUP, null);
        notificationChannelWrapper.sound = sharedPreferences.getString("sound", "");
        String[] strArrSplit = sharedPreferences.getString("vibrationPattern", "[]").split(",");
        int length = strArrSplit.length;
        long[] jArr = new long[length];
        if (length > 1) {
            for (int i = 0; i < strArrSplit.length; i++) {
                try {
                    jArr[i] = Long.parseLong(strArrSplit[i]);
                } catch (NumberFormatException unused) {
                    jArr[i] = 1;
                }
            }
        }
        notificationChannelWrapper.vibrationPattern = length > 1 ? jArr : null;
        return notificationChannelWrapper;
    }

    private static NotificationChannelWrapper notificationChannelToWrapper(Object obj) {
        NotificationChannel notificationChannel = (NotificationChannel) obj;
        NotificationChannelWrapper notificationChannelWrapper = new NotificationChannelWrapper();
        notificationChannelWrapper.id = notificationChannel.getId();
        notificationChannelWrapper.name = notificationChannel.getName().toString();
        notificationChannelWrapper.importance = notificationChannel.getImportance();
        notificationChannelWrapper.description = notificationChannel.getDescription();
        notificationChannelWrapper.enableLights = notificationChannel.shouldShowLights();
        notificationChannelWrapper.enableVibration = notificationChannel.shouldVibrate();
        notificationChannelWrapper.canBypassDnd = notificationChannel.canBypassDnd();
        notificationChannelWrapper.canShowBadge = notificationChannel.canShowBadge();
        notificationChannelWrapper.vibrationPattern = notificationChannel.getVibrationPattern();
        notificationChannelWrapper.lockscreenVisibility = notificationChannel.getLockscreenVisibility();
        notificationChannelWrapper.group = notificationChannel.getGroup();
        notificationChannelWrapper.sound = notificationChannel.getSound().toString();
        return notificationChannelWrapper;
    }

    public void deleteNotificationChannel(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            getNotificationManager().deleteNotificationChannel(str);
            return;
        }
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(NOTIFICATION_CHANNELS_SHARED_PREFS, 0);
        Set<String> stringSet = sharedPreferences.getStringSet(NOTIFICATION_CHANNELS_SHARED_PREFS_KEY, new HashSet());
        if (stringSet.contains(str)) {
            HashSet hashSet = new HashSet(stringSet);
            hashSet.remove(str);
            SharedPreferences.Editor editorClear = sharedPreferences.edit().clear();
            editorClear.putStringSet(NOTIFICATION_CHANNELS_SHARED_PREFS_KEY, hashSet);
            editorClear.apply();
            this.mContext.getSharedPreferences(getSharedPrefsNameByChannelId(str), 0).edit().clear().apply();
        }
    }

    public NotificationChannelWrapper[] getNotificationChannels() {
        int i = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            List<NotificationChannel> notificationChannels = getNotificationManager().getNotificationChannels();
            if (notificationChannels.size() == 0) {
                return null;
            }
            NotificationChannelWrapper[] notificationChannelWrapperArr = new NotificationChannelWrapper[notificationChannels.size()];
            Iterator<NotificationChannel> it = notificationChannels.iterator();
            while (it.hasNext()) {
                notificationChannelWrapperArr[i] = notificationChannelToWrapper(it.next());
                i++;
            }
            return notificationChannelWrapperArr;
        }
        Set<String> stringSet = this.mContext.getSharedPreferences(NOTIFICATION_CHANNELS_SHARED_PREFS, 0).getStringSet(NOTIFICATION_CHANNELS_SHARED_PREFS_KEY, new HashSet());
        if (stringSet.size() == 0) {
            return null;
        }
        NotificationChannelWrapper[] notificationChannelWrapperArr2 = new NotificationChannelWrapper[stringSet.size()];
        Iterator<String> it2 = stringSet.iterator();
        while (it2.hasNext()) {
            notificationChannelWrapperArr2[i] = getNotificationChannel(it2.next());
            i++;
        }
        return notificationChannelWrapperArr2;
    }

    private int generateUniqueId() {
        int iNextInt = 0;
        do {
            iNextInt += this.mRandom.nextInt(1000);
        } while (this.mScheduledNotifications.containsKey(Integer.valueOf(iNextInt)));
        return iNextInt;
    }

    public int scheduleNotification(Notification.Builder builder, boolean z) {
        int i;
        Bundle extras = builder.getExtras();
        if (extras.containsKey(KEY_ID)) {
            i = builder.getExtras().getInt(KEY_ID, -1);
        } else {
            int iGenerateUniqueId = generateUniqueId();
            extras.putInt(KEY_ID, iGenerateUniqueId);
            i = iGenerateUniqueId;
        }
        this.mBackgroundThread.enqueueNotification(i, builder, z, this.mScheduledNotifications.putIfAbsent(Integer.valueOf(i), builder) == null);
        return i;
    }

    void performNotificationScheduling(int i, Notification.Builder builder, boolean z) {
        Bundle extras = builder.getExtras();
        long j = extras.getLong(KEY_REPEAT_INTERVAL, -1L);
        long j2 = extras.getLong(KEY_FIRE_TIME, -1L);
        boolean z2 = j2 - Calendar.getInstance().getTime().getTime() < 1000;
        if (!z2 || j > 0) {
            if (z2) {
                j2 += j;
            }
            Intent intentBuildNotificationIntent = buildNotificationIntent();
            if (intentBuildNotificationIntent != null) {
                saveNotification(builder.build(), z);
                scheduleAlarmWithNotification(builder, intentBuildNotificationIntent, j2);
            }
        }
        if (z2) {
            notify(i, buildNotificationForSending(this.mOpenActivity, builder));
        }
    }

    void scheduleAlarmWithNotification(Notification.Builder builder, Intent intent, long j) {
        Bundle extras = builder.getExtras();
        int i = extras.getInt(KEY_ID, -1);
        long j2 = extras.getLong(KEY_REPEAT_INTERVAL, -1L);
        this.mScheduledNotifications.put(Integer.valueOf(i), builder);
        intent.putExtra(KEY_NOTIFICATION_ID, i);
        scheduleNotificationIntentAlarm(j2, j, getBroadcastPendingIntent(i, intent, 134217728));
    }

    void scheduleAlarmWithNotification(Notification.Builder builder) {
        scheduleAlarmWithNotification(builder, buildNotificationIntent(), builder.getExtras().getLong(KEY_FIRE_TIME, 0L));
    }

    private Notification buildNotificationForSending(Class cls, Notification.Builder builder) {
        int i = builder.getExtras().getInt(KEY_ID, -1);
        Intent intent = new Intent(this.mContext, (Class<?>) cls);
        intent.addFlags(805306368);
        intent.putExtra(KEY_NOTIFICATION_ID, i);
        builder.setContentIntent(getActivityPendingIntent(i, intent, 0));
        finalizeNotificationForDisplay(builder);
        return builder.build();
    }

    void performNotificationHousekeeping(Set<String> set) {
        Log.d(TAG_UNITY, "Checking for invalid notification IDs still hanging around");
        Set<String> setFindInvalidNotificationIds = findInvalidNotificationIds(set);
        HashSet hashSet = new HashSet(set);
        for (String str : setFindInvalidNotificationIds) {
            hashSet.remove(str);
            this.mScheduledNotifications.remove(str);
        }
        Iterator<String> it = setFindInvalidNotificationIds.iterator();
        while (it.hasNext()) {
            deleteExpiredNotificationIntent(it.next());
        }
    }

    private Set<String> findInvalidNotificationIds(Set<String> set) {
        Intent intentBuildNotificationIntent = buildNotificationIntent();
        HashSet hashSet = new HashSet();
        for (String str : set) {
            if (getBroadcastPendingIntent(Integer.valueOf(str).intValue(), intentBuildNotificationIntent, 536870912) == null) {
                hashSet.add(str);
            }
        }
        for (StatusBarNotification statusBarNotification : getNotificationManager().getActiveNotifications()) {
            hashSet.remove(String.valueOf(statusBarNotification.getId()));
        }
        if (UnityPlayer.currentActivity != null) {
            Intent intent = UnityPlayer.currentActivity.getIntent();
            if (intent.hasExtra(KEY_NOTIFICATION_ID)) {
                hashSet.remove(String.valueOf(intent.getExtras().getInt(KEY_NOTIFICATION_ID)));
            }
        }
        return hashSet;
    }

    private Intent buildNotificationIntent() {
        Intent intent = new Intent(this.mContext, (Class<?>) UnityNotificationManager.class);
        intent.setFlags(268468224);
        return intent;
    }

    private PendingIntent getActivityPendingIntent(int i, Intent intent, int i2) {
        return PendingIntent.getActivity(this.mContext, i, intent, i2 | 67108864);
    }

    private PendingIntent getBroadcastPendingIntent(int i, Intent intent, int i2) {
        return PendingIntent.getBroadcast(this.mContext, i, intent, i2 | 67108864);
    }

    synchronized void saveNotification(Notification notification, boolean z) {
        UnityNotificationUtilities.serializeNotification(this.mContext.getSharedPreferences(getSharedPrefsNameByNotificationId(Integer.toString(notification.extras.getInt(KEY_ID, -1))), 0), notification, z);
    }

    static String getSharedPrefsNameByNotificationId(String str) {
        return String.format("u_notification_data_%s", str);
    }

    synchronized List<Notification.Builder> loadSavedNotifications() {
        ArrayList arrayList;
        Notification.Builder builderRecoverBuilder;
        Set<String> scheduledNotificationIDs = getScheduledNotificationIDs();
        arrayList = new ArrayList();
        HashSet<String> hashSet = new HashSet();
        for (String str : scheduledNotificationIDs) {
            Object objDeserializeNotification = UnityNotificationUtilities.deserializeNotification(this.mContext, this.mContext.getSharedPreferences(getSharedPrefsNameByNotificationId(str), 0));
            if (objDeserializeNotification == null) {
                builderRecoverBuilder = null;
            } else if (objDeserializeNotification instanceof Notification.Builder) {
                builderRecoverBuilder = (Notification.Builder) objDeserializeNotification;
            } else {
                builderRecoverBuilder = UnityNotificationUtilities.recoverBuilder(this.mContext, (Notification) objDeserializeNotification);
            }
            if (builderRecoverBuilder != null) {
                arrayList.add(builderRecoverBuilder);
            } else {
                hashSet.add(str);
            }
        }
        if (hashSet.size() > 0) {
            HashSet hashSet2 = new HashSet(scheduledNotificationIDs);
            for (String str2 : hashSet) {
                hashSet2.remove(str2);
                deleteExpiredNotificationIntent(str2);
            }
            saveScheduledNotificationIDs(hashSet2);
        }
        return arrayList;
    }

    private boolean canScheduleExactAlarms(AlarmManager alarmManager) {
        Bundle appMetadata;
        if (this.mExactSchedulingSetting < 0 && (appMetadata = getAppMetadata()) != null) {
            this.mExactSchedulingSetting = appMetadata.getInt("com.unity.androidnotifications.exact_scheduling", 1);
        }
        if (this.mExactSchedulingSetting == 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 31) {
            return true;
        }
        return alarmManager.canScheduleExactAlarms();
    }

    public boolean canScheduleExactAlarms() {
        return canScheduleExactAlarms((AlarmManager) this.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM));
    }

    private void scheduleNotificationIntentAlarm(long j, long j2, PendingIntent pendingIntent) {
        AlarmManager alarmManager = (AlarmManager) this.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (j <= 0) {
            if (canScheduleExactAlarms(alarmManager)) {
                alarmManager.setExactAndAllowWhileIdle(0, j2, pendingIntent);
                return;
            } else {
                alarmManager.set(0, j2, pendingIntent);
                return;
            }
        }
        alarmManager.setInexactRepeating(0, j2, j, pendingIntent);
    }

    public int checkNotificationStatus(int i) {
        for (StatusBarNotification statusBarNotification : getNotificationManager().getActiveNotifications()) {
            if (i == statusBarNotification.getId()) {
                return 2;
            }
        }
        return (this.mScheduledNotifications.containsKey(Integer.valueOf(i)) || checkIfPendingNotificationIsRegistered(i)) ? 1 : 0;
    }

    public boolean checkIfPendingNotificationIsRegistered(int i) {
        return getBroadcastPendingIntent(i, new Intent(this.mActivity, (Class<?>) UnityNotificationManager.class), 536870912) != null;
    }

    public void cancelAllPendingNotificationIntents() {
        this.mBackgroundThread.enqueueCancelAllNotifications();
    }

    private synchronized Set<String> getScheduledNotificationIDs() {
        return this.mContext.getSharedPreferences(NOTIFICATION_IDS_SHARED_PREFS, 0).getStringSet(NOTIFICATION_IDS_SHARED_PREFS_KEY, new HashSet());
    }

    synchronized void saveScheduledNotificationIDs(Set<String> set) {
        SharedPreferences.Editor editorClear = this.mContext.getSharedPreferences(NOTIFICATION_IDS_SHARED_PREFS, 0).edit().clear();
        editorClear.putStringSet(NOTIFICATION_IDS_SHARED_PREFS_KEY, set);
        editorClear.apply();
    }

    public void cancelPendingNotification(int i) {
        this.mBackgroundThread.enqueueCancelNotification(i);
    }

    void cancelPendingNotificationIntent(int i) {
        PendingIntent broadcastPendingIntent = getBroadcastPendingIntent(i, new Intent(this.mContext, (Class<?>) UnityNotificationManager.class), 536870912);
        if (broadcastPendingIntent != null) {
            ((AlarmManager) this.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(broadcastPendingIntent);
            broadcastPendingIntent.cancel();
        }
    }

    synchronized void deleteExpiredNotificationIntent(String str) {
        this.mContext.getSharedPreferences(getSharedPrefsNameByNotificationId(str), 0).edit().clear().apply();
    }

    public void cancelDisplayedNotification(int i) {
        getNotificationManager().cancel(i);
    }

    public void cancelAllNotifications() {
        getNotificationManager().cancelAll();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        getNotificationManagerImpl(context).onReceive(intent);
    }

    public void onReceive(Intent intent) {
        showNotification(intent);
    }

    private void showNotification(Intent intent) {
        Object notificationOrIdForIntent = getNotificationOrIdForIntent(intent);
        if (notificationOrIdForIntent == null) {
            return;
        }
        if (notificationOrIdForIntent instanceof Notification) {
            Notification notification = (Notification) notificationOrIdForIntent;
            notify(notification.extras.getInt(KEY_ID, -1), notification);
            return;
        }
        final Integer num = (Integer) notificationOrIdForIntent;
        Notification.Builder builder = this.mScheduledNotifications.get(num);
        if (builder != null) {
            notify(num.intValue(), builder);
        } else {
            AsyncTask.execute(new Runnable() { // from class: com.unity.androidnotifications.UnityNotificationManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    this.f$0.m182x329bd7ea(num);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$showNotification$0$com-unity-androidnotifications-UnityNotificationManager, reason: not valid java name */
    /* synthetic */ void m182x329bd7ea(Integer num) throws IOException {
        Notification.Builder builderDeserializeNotificationBuilder = deserializeNotificationBuilder(num);
        if (builderDeserializeNotificationBuilder == null) {
            Log.e(TAG_UNITY, "Failed to recover builder, can't send notification");
        } else {
            notify(num.intValue(), builderDeserializeNotificationBuilder);
        }
    }

    void notify(int i, Notification.Builder builder) {
        Class<?> openAppActivity = this.mOpenActivity;
        if (openAppActivity == null && (openAppActivity = UnityNotificationUtilities.getOpenAppActivity(this.mContext)) == null) {
            Log.e(TAG_UNITY, "Activity not found, cannot show notification");
            return;
        }
        Notification notificationBuildNotificationForSending = buildNotificationForSending(openAppActivity, builder);
        if (notificationBuildNotificationForSending != null) {
            notify(i, notificationBuildNotificationForSending);
        }
    }

    private void notify(int i, Notification notification) {
        boolean z = notification.extras.getBoolean(KEY_SHOW_IN_FOREGROUND, true);
        if (!isInForeground() || z) {
            getNotificationManager().notify(i, notification);
        }
        if (notification.extras.getLong(KEY_REPEAT_INTERVAL, -1L) <= 0) {
            this.mScheduledNotifications.remove(Integer.valueOf(i));
            cancelPendingNotificationIntent(i);
        }
        try {
            NotificationCallback notificationCallback = this.mNotificationCallback;
            if (notificationCallback != null) {
                notificationCallback.onSentNotification(notification);
            }
        } catch (RuntimeException unused) {
            Log.w(TAG_UNITY, "Can not invoke OnNotificationReceived event when the app is not running!");
        }
    }

    public static Integer getNotificationColor(Notification notification) {
        if (Build.VERSION.SDK_INT < 26 || notification.extras.containsKey(NotificationCompat.EXTRA_COLORIZED)) {
            return Integer.valueOf(notification.color);
        }
        return null;
    }

    public static int getNotificationGroupAlertBehavior(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getGroupAlertBehavior();
        }
        return 0;
    }

    private void finalizeNotificationForDisplay(Notification.Builder builder) {
        String string = builder.getExtras().getString(KEY_SMALL_ICON);
        Object iconForUri = getIconForUri(string);
        if (iconForUri != null) {
            builder.setSmallIcon((Icon) iconForUri);
        } else {
            int iFindResourceIdInContextByName = UnityNotificationUtilities.findResourceIdInContextByName(this.mContext, string);
            if (iFindResourceIdInContextByName == 0) {
                iFindResourceIdInContextByName = this.mContext.getApplicationInfo().icon;
            }
            builder.setSmallIcon(iFindResourceIdInContextByName);
        }
        Object icon = getIcon(builder.getExtras().getString(KEY_LARGE_ICON));
        if (icon != null) {
            if (icon instanceof Icon) {
                builder.setLargeIcon((Icon) icon);
            } else {
                builder.setLargeIcon((Bitmap) icon);
            }
        }
        setupBigPictureStyle(builder);
    }

    private Object getIcon(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return BitmapFactory.decodeFile(str);
        }
        Object iconForUri = getIconForUri(str);
        return iconForUri != null ? iconForUri : getIconFromResources(str, false);
    }

    private Object getIconForUri(String str) {
        if (str == null || str.length() == 0 || str.indexOf("://") <= 0) {
            return null;
        }
        return Icon.createWithContentUri(str);
    }

    private Object getIconFromResources(String str, boolean z) {
        int iFindResourceIdInContextByName = UnityNotificationUtilities.findResourceIdInContextByName(this.mContext, str);
        if (iFindResourceIdInContextByName == 0) {
            return null;
        }
        if (!z) {
            return Icon.createWithResource(this.mContext, iFindResourceIdInContextByName);
        }
        return BitmapFactory.decodeResource(this.mContext.getResources(), iFindResourceIdInContextByName);
    }

    private Bitmap loadBitmap(String str) {
        try {
            return BitmapFactory.decodeStream(this.mContext.getContentResolver().openInputStream(Uri.parse(str)));
        } catch (Exception e) {
            Log.e(TAG_UNITY, "Failed to load image " + str, e);
            return null;
        }
    }

    public Notification.Builder createNotificationBuilder(String str) {
        int i;
        int i2;
        if (Build.VERSION.SDK_INT < 26) {
            Notification.Builder builder = new Notification.Builder(this.mContext);
            NotificationChannelWrapper notificationChannel = getNotificationChannel(str);
            if (notificationChannel.vibrationPattern == null || notificationChannel.vibrationPattern.length <= 0) {
                i = 6;
            } else {
                builder.setVibrate(notificationChannel.vibrationPattern);
                i = 4;
            }
            if (notificationChannel.sound == null || notificationChannel.sound.isEmpty()) {
                i |= 1;
            } else {
                builder.setSound(Uri.parse(notificationChannel.sound), new AudioAttributes.Builder().setUsage(5).setContentType(4).build());
            }
            builder.setDefaults(i);
            builder.setVisibility(notificationChannel.lockscreenVisibility);
            int i3 = notificationChannel.importance;
            if (i3 != 0) {
                i2 = 2;
                if (i3 == 2) {
                    i2 = -1;
                } else if (i3 == 3 || i3 != 4) {
                    i2 = 0;
                }
            } else {
                i2 = -2;
            }
            builder.setPriority(i2);
            builder.getExtras().putString(KEY_CHANNEL_ID, str);
            return builder;
        }
        return new Notification.Builder(this.mContext, str);
    }

    public static void setNotificationIcon(Notification.Builder builder, String str, String str2) {
        if (str2 == null || (str2.length() == 0 && builder.getExtras().getString(str) != null)) {
            builder.getExtras().remove(str);
        } else {
            builder.getExtras().putString(str, str2);
        }
    }

    public void setupBigPictureStyle(Notification.Builder builder, String str, String str2, String str3, String str4, String str5, boolean z) {
        Bundle extras = builder.getExtras();
        if (str2 == null || str2.length() == 0) {
            return;
        }
        extras.putString(KEY_BIG_LARGE_ICON, str);
        extras.putString(KEY_BIG_PICTURE, str2);
        extras.putString(KEY_BIG_CONTENT_TITLE, str3);
        extras.putString(KEY_BIG_SUMMARY_TEXT, str5);
        extras.putString(KEY_BIG_CONTENT_DESCRIPTION, str4);
        extras.putBoolean(KEY_BIG_SHOW_WHEN_COLLAPSED, z);
    }

    private void setupBigPictureStyle(Notification.Builder builder) {
        Bundle extras = builder.getExtras();
        String string = extras.getString(KEY_BIG_PICTURE);
        if (string == null) {
            return;
        }
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
        Object icon = getIcon(extras.getString(KEY_BIG_LARGE_ICON));
        if (icon != null) {
            if (icon instanceof Icon) {
                bigPictureStyle.bigLargeIcon((Icon) icon);
            } else {
                bigPictureStyle.bigLargeIcon((Bitmap) icon);
            }
        }
        if (string.charAt(0) == '/') {
            bigPictureStyle.bigPicture(BitmapFactory.decodeFile(string));
        } else if (string.indexOf("://") > 0) {
            if (Build.VERSION.SDK_INT >= 31) {
                bigPictureStyle.bigPicture(Icon.createWithContentUri(string));
            } else {
                Bitmap bitmapLoadBitmap = loadBitmap(string);
                if (bitmapLoadBitmap != null) {
                    bigPictureStyle.bigPicture(bitmapLoadBitmap);
                }
            }
        } else {
            Object iconFromResources = getIconFromResources(string, Build.VERSION.SDK_INT < 31);
            if (Build.VERSION.SDK_INT >= 31 && (iconFromResources instanceof Icon)) {
                bigPictureStyle.bigPicture((Icon) iconFromResources);
            } else if (iconFromResources instanceof Bitmap) {
                bigPictureStyle.bigPicture((Bitmap) iconFromResources);
            }
        }
        bigPictureStyle.setBigContentTitle(extras.getString(KEY_BIG_CONTENT_TITLE));
        bigPictureStyle.setSummaryText(extras.getString(KEY_BIG_SUMMARY_TEXT));
        if (Build.VERSION.SDK_INT >= 31) {
            bigPictureStyle.setContentDescription(extras.getString(KEY_BIG_CONTENT_DESCRIPTION));
            bigPictureStyle.showBigPictureWhenCollapsed(extras.getBoolean(KEY_BIG_SHOW_WHEN_COLLAPSED, false));
        }
        builder.setStyle(bigPictureStyle);
    }

    public static void setNotificationColor(Notification.Builder builder, int i) {
        if (i != 0) {
            builder.setColor(i);
            if (Build.VERSION.SDK_INT >= 26) {
                builder.setColorized(true);
            }
        }
    }

    public static void setNotificationUsesChronometer(Notification.Builder builder, boolean z) {
        builder.setUsesChronometer(z);
    }

    public static void setNotificationGroupAlertBehavior(Notification.Builder builder, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setGroupAlertBehavior(i);
        }
    }

    public static String getNotificationChannelId(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getChannelId();
        }
        return null;
    }

    private static boolean isInForeground() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == 200;
    }

    public Notification getNotificationFromIntent(Intent intent) {
        if (intent.hasExtra(KEY_NOTIFICATION_ID)) {
            int i = intent.getExtras().getInt(KEY_NOTIFICATION_ID);
            for (StatusBarNotification statusBarNotification : getNotificationManager().getActiveNotifications()) {
                if (statusBarNotification.getId() == i) {
                    return statusBarNotification.getNotification();
                }
            }
        }
        Object notificationOrBuilderForIntent = getNotificationOrBuilderForIntent(intent);
        if (notificationOrBuilderForIntent == null) {
            return null;
        }
        if (notificationOrBuilderForIntent instanceof Notification) {
            return (Notification) notificationOrBuilderForIntent;
        }
        return ((Notification.Builder) notificationOrBuilderForIntent).build();
    }

    private Object getNotificationOrIdForIntent(Intent intent) {
        if (intent.hasExtra(KEY_NOTIFICATION_ID)) {
            return Integer.valueOf(intent.getExtras().getInt(KEY_NOTIFICATION_ID));
        }
        if (intent.hasExtra(KEY_NOTIFICATION)) {
            return intent.getParcelableExtra(KEY_NOTIFICATION);
        }
        return null;
    }

    private Object getNotificationOrBuilderForIntent(Intent intent) {
        Object notificationOrIdForIntent = getNotificationOrIdForIntent(intent);
        if (!(notificationOrIdForIntent instanceof Integer)) {
            return notificationOrIdForIntent;
        }
        Integer num = (Integer) notificationOrIdForIntent;
        Notification.Builder builder = this.mScheduledNotifications.get(num);
        return builder == null ? deserializeNotificationBuilder(num) : builder;
    }

    private Notification.Builder deserializeNotificationBuilder(Integer num) throws IOException {
        Object objDeserializeNotification = UnityNotificationUtilities.deserializeNotification(this.mContext, this.mContext.getSharedPreferences(getSharedPrefsNameByNotificationId(num.toString()), 0));
        if (objDeserializeNotification == null) {
            return null;
        }
        if (objDeserializeNotification instanceof Notification) {
            return UnityNotificationUtilities.recoverBuilder(this.mContext, (Notification) objDeserializeNotification);
        }
        return (Notification.Builder) objDeserializeNotification;
    }

    public void showNotificationSettings(String str) {
        Intent intent;
        if (Build.VERSION.SDK_INT < 26) {
            intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", this.mContext.getPackageName(), null));
        } else {
            if (str != null && str.length() > 0) {
                Intent intent2 = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
                intent2.putExtra("android.provider.extra.CHANNEL_ID", str);
                intent = intent2;
            } else {
                intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            }
            intent.putExtra("android.provider.extra.APP_PACKAGE", this.mContext.getPackageName());
        }
        intent.addFlags(268435456);
        this.mActivity.startActivity(intent);
    }
}
