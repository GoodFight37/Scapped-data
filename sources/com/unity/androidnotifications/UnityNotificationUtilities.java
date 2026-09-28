package com.unity.androidnotifications;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes2.dex */
class UnityNotificationUtilities {
    private static final int INTENT_SERIALIZATION_VERSION = 0;
    private static final int NOTIFICATION_SERIALIZATION_VERSION = 3;
    static final String SAVED_NOTIFICATION_FALLBACK_KEY = "fallback.data";
    static final String SAVED_NOTIFICATION_PRIMARY_KEY = "data";
    static final byte[] UNITY_MAGIC_NUMBER = {85, 77, 78, 78};
    private static final byte[] UNITY_MAGIC_NUMBER_PARCELLED = {85, 77, 78, 80};

    UnityNotificationUtilities() {
    }

    protected static int findResourceIdInContextByName(Context context, String str) {
        if (str == null) {
            return 0;
        }
        try {
            Resources resources = context.getResources();
            if (resources != null) {
                int identifier = resources.getIdentifier(str, "mipmap", context.getPackageName());
                return identifier == 0 ? resources.getIdentifier(str, "drawable", context.getPackageName()) : identifier;
            }
        } catch (Resources.NotFoundException unused) {
        }
        return 0;
    }

    protected static void serializeNotification(SharedPreferences sharedPreferences, Notification notification, boolean z) {
        String strEncodeToString;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (z) {
                Intent intent = new Intent();
                intent.putExtra(UnityNotificationManager.KEY_NOTIFICATION, notification);
                if (!serializeNotificationParcel(intent, dataOutputStream)) {
                    return;
                }
                dataOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                strEncodeToString = Base64.encodeToString(byteArray, 0, byteArray.length, 0);
            } else {
                if (!serializeNotificationCustom(notification, dataOutputStream)) {
                    return;
                }
                dataOutputStream.flush();
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                strEncodeToString = Base64.encodeToString(byteArray2, 0, byteArray2.length, 0);
            }
            SharedPreferences.Editor editorClear = sharedPreferences.edit().clear();
            editorClear.putString("data", strEncodeToString);
            editorClear.apply();
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to serialize notification", e);
        }
    }

    static boolean serializeNotificationParcel(Intent intent, DataOutputStream dataOutputStream) {
        try {
            byte[] bArrSerializeParcelable = serializeParcelable(intent);
            if (bArrSerializeParcelable != null && bArrSerializeParcelable.length != 0) {
                dataOutputStream.write(UNITY_MAGIC_NUMBER_PARCELLED);
                dataOutputStream.writeInt(0);
                dataOutputStream.writeInt(bArrSerializeParcelable.length);
                dataOutputStream.write(bArrSerializeParcelable);
                return true;
            }
            return false;
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to serialize notification as Parcel", e);
            return false;
        } catch (OutOfMemoryError e2) {
            Log.e("UnityNotifications", "Failed to serialize notification as Parcel", e2);
            return false;
        }
    }

    private static boolean serializeNotificationCustom(Notification notification, DataOutputStream dataOutputStream) {
        String channelId;
        try {
            dataOutputStream.write(UNITY_MAGIC_NUMBER);
            dataOutputStream.writeInt(3);
            boolean z = notification.extras.getBoolean(NotificationCompat.EXTRA_SHOW_WHEN, false);
            dataOutputStream.writeInt(notification.extras.getInt(UnityNotificationManager.KEY_ID));
            serializeString(dataOutputStream, notification.extras.getString(NotificationCompat.EXTRA_TITLE));
            serializeString(dataOutputStream, notification.extras.getString(NotificationCompat.EXTRA_TEXT));
            serializeString(dataOutputStream, notification.extras.getString(UnityNotificationManager.KEY_SMALL_ICON));
            serializeString(dataOutputStream, notification.extras.getString(UnityNotificationManager.KEY_LARGE_ICON));
            dataOutputStream.writeLong(notification.extras.getLong(UnityNotificationManager.KEY_FIRE_TIME, -1L));
            dataOutputStream.writeLong(notification.extras.getLong(UnityNotificationManager.KEY_REPEAT_INTERVAL, -1L));
            serializeString(dataOutputStream, notification.extras.getString(NotificationCompat.EXTRA_BIG_TEXT));
            dataOutputStream.writeBoolean(notification.extras.getBoolean(NotificationCompat.EXTRA_SHOW_CHRONOMETER, false));
            dataOutputStream.writeBoolean(z);
            serializeString(dataOutputStream, notification.extras.getString("data"));
            dataOutputStream.writeBoolean(notification.extras.getBoolean(UnityNotificationManager.KEY_SHOW_IN_FOREGROUND, true));
            String string = notification.extras.getString(UnityNotificationManager.KEY_BIG_PICTURE);
            serializeString(dataOutputStream, string);
            if (string != null && string.length() > 0) {
                serializeString(dataOutputStream, notification.extras.getString(UnityNotificationManager.KEY_BIG_LARGE_ICON));
                serializeString(dataOutputStream, notification.extras.getString(UnityNotificationManager.KEY_BIG_CONTENT_TITLE));
                serializeString(dataOutputStream, notification.extras.getString(UnityNotificationManager.KEY_BIG_CONTENT_DESCRIPTION));
                serializeString(dataOutputStream, notification.extras.getString(UnityNotificationManager.KEY_BIG_SUMMARY_TEXT));
                dataOutputStream.writeBoolean(notification.extras.getBoolean(UnityNotificationManager.KEY_BIG_SHOW_WHEN_COLLAPSED, false));
            }
            if (Build.VERSION.SDK_INT < 26) {
                channelId = notification.extras.getString(UnityNotificationManager.KEY_CHANNEL_ID);
            } else {
                channelId = notification.getChannelId();
            }
            serializeString(dataOutputStream, channelId);
            Integer notificationColor = UnityNotificationManager.getNotificationColor(notification);
            dataOutputStream.writeBoolean(notificationColor != null);
            if (notificationColor != null) {
                dataOutputStream.writeInt(notificationColor.intValue());
            }
            dataOutputStream.writeInt(notification.number);
            dataOutputStream.writeBoolean((notification.flags & 16) != 0);
            serializeString(dataOutputStream, notification.getGroup());
            dataOutputStream.writeBoolean((notification.flags & 512) != 0);
            dataOutputStream.writeInt(UnityNotificationManager.getNotificationGroupAlertBehavior(notification));
            serializeString(dataOutputStream, notification.getSortKey());
            if (z) {
                dataOutputStream.writeLong(notification.when);
            }
            return true;
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to serialize notification", e);
            return false;
        }
    }

    static void serializeString(DataOutputStream dataOutputStream, String str) throws IOException {
        if (str == null || str.length() == 0) {
            dataOutputStream.writeInt(0);
            return;
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(bytes);
    }

    static byte[] serializeParcelable(Parcelable parcelable) {
        try {
            Parcel parcelObtain = Parcel.obtain();
            Bundle bundle = new Bundle();
            bundle.putParcelable("obj", parcelable);
            parcelObtain.writeParcelable(bundle, 0);
            byte[] bArrMarshall = parcelObtain.marshall();
            parcelObtain.recycle();
            return bArrMarshall;
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to serialize Parcelable", e);
            return null;
        } catch (OutOfMemoryError e2) {
            Log.e("UnityNotifications", "Failed to serialize Parcelable", e2);
            return null;
        }
    }

    protected static Object deserializeNotification(Context context, SharedPreferences sharedPreferences) throws IOException {
        String string = sharedPreferences.getString("data", "");
        if (string != null && string.length() > 0) {
            Object objDeserializeNotification = deserializeNotification(context, Base64.decode(string, 0));
            if (objDeserializeNotification != null) {
                return objDeserializeNotification;
            }
            String string2 = sharedPreferences.getString(SAVED_NOTIFICATION_FALLBACK_KEY, "");
            if (string2 != null && string2.length() > 0) {
                return deserializeNotification(context, Base64.decode(string2, 0));
            }
        }
        return null;
    }

    private static Object deserializeNotification(Context context, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        Notification notificationDeserializeNotificationParcelable = deserializeNotificationParcelable(dataInputStream);
        if (notificationDeserializeNotificationParcelable != null) {
            return notificationDeserializeNotificationParcelable;
        }
        byteArrayInputStream.reset();
        Notification.Builder builderDeserializeNotificationCustom = deserializeNotificationCustom(context, dataInputStream);
        return builderDeserializeNotificationCustom == null ? deserializedFromOldIntent(context, bArr) : builderDeserializeNotificationCustom;
    }

    private static boolean readAndCheckMagicNumber(DataInputStream dataInputStream, byte[] bArr) {
        for (byte b : bArr) {
            try {
                if (dataInputStream.readByte() != b) {
                    return false;
                }
            } catch (Exception unused) {
                return false;
            }
        }
        return true;
    }

    private static Notification deserializeNotificationParcelable(DataInputStream dataInputStream) {
        int i;
        try {
            if (readAndCheckMagicNumber(dataInputStream, UNITY_MAGIC_NUMBER_PARCELLED) && (i = dataInputStream.readInt()) >= 0 && i <= 0) {
                return (Notification) ((Intent) deserializeParcelable(dataInputStream)).getParcelableExtra(UnityNotificationManager.KEY_NOTIFICATION);
            }
            return null;
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to deserialize notification intent", e);
            return null;
        } catch (OutOfMemoryError e2) {
            Log.e("UnityNotifications", "Failed to deserialize notification intent", e2);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0146 A[Catch: OutOfMemoryError -> 0x023b, Exception -> 0x023d, TryCatch #6 {Exception -> 0x023d, OutOfMemoryError -> 0x023b, blocks: (B:39:0x013c, B:41:0x0146, B:43:0x014d, B:45:0x0171, B:47:0x0178, B:49:0x0186, B:61:0x01d1, B:63:0x01d6, B:66:0x01dd, B:70:0x01f5, B:72:0x01fc, B:73:0x0201, B:75:0x020d, B:77:0x0213, B:78:0x0218, B:80:0x0224, B:82:0x022a, B:84:0x0231, B:68:0x01ec, B:50:0x018c, B:52:0x01a3, B:55:0x01b2, B:58:0x01bd, B:59:0x01c4), top: B:109:0x013c }] */
    /* JADX WARN: Code duplicated, block: B:42:0x014b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0171 A[Catch: OutOfMemoryError -> 0x023b, Exception -> 0x023d, TryCatch #6 {Exception -> 0x023d, OutOfMemoryError -> 0x023b, blocks: (B:39:0x013c, B:41:0x0146, B:43:0x014d, B:45:0x0171, B:47:0x0178, B:49:0x0186, B:61:0x01d1, B:63:0x01d6, B:66:0x01dd, B:70:0x01f5, B:72:0x01fc, B:73:0x0201, B:75:0x020d, B:77:0x0213, B:78:0x0218, B:80:0x0224, B:82:0x022a, B:84:0x0231, B:68:0x01ec, B:50:0x018c, B:52:0x01a3, B:55:0x01b2, B:58:0x01bd, B:59:0x01c4), top: B:109:0x013c }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0176  */
    /* JADX WARN: Code duplicated, block: B:49:0x0186 A[Catch: OutOfMemoryError -> 0x023b, Exception -> 0x023d, TryCatch #6 {Exception -> 0x023d, OutOfMemoryError -> 0x023b, blocks: (B:39:0x013c, B:41:0x0146, B:43:0x014d, B:45:0x0171, B:47:0x0178, B:49:0x0186, B:61:0x01d1, B:63:0x01d6, B:66:0x01dd, B:70:0x01f5, B:72:0x01fc, B:73:0x0201, B:75:0x020d, B:77:0x0213, B:78:0x0218, B:80:0x0224, B:82:0x022a, B:84:0x0231, B:68:0x01ec, B:50:0x018c, B:52:0x01a3, B:55:0x01b2, B:58:0x01bd, B:59:0x01c4), top: B:109:0x013c }] */
    /* JADX WARN: Code duplicated, block: B:50:0x018c A[Catch: OutOfMemoryError -> 0x023b, Exception -> 0x023d, TryCatch #6 {Exception -> 0x023d, OutOfMemoryError -> 0x023b, blocks: (B:39:0x013c, B:41:0x0146, B:43:0x014d, B:45:0x0171, B:47:0x0178, B:49:0x0186, B:61:0x01d1, B:63:0x01d6, B:66:0x01dd, B:70:0x01f5, B:72:0x01fc, B:73:0x0201, B:75:0x020d, B:77:0x0213, B:78:0x0218, B:80:0x0224, B:82:0x022a, B:84:0x0231, B:68:0x01ec, B:50:0x018c, B:52:0x01a3, B:55:0x01b2, B:58:0x01bd, B:59:0x01c4), top: B:109:0x013c }] */
    /* JADX WARN: Code duplicated, block: B:52:0x01a3 A[Catch: OutOfMemoryError -> 0x023b, Exception -> 0x023d, TryCatch #6 {Exception -> 0x023d, OutOfMemoryError -> 0x023b, blocks: (B:39:0x013c, B:41:0x0146, B:43:0x014d, B:45:0x0171, B:47:0x0178, B:49:0x0186, B:61:0x01d1, B:63:0x01d6, B:66:0x01dd, B:70:0x01f5, B:72:0x01fc, B:73:0x0201, B:75:0x020d, B:77:0x0213, B:78:0x0218, B:80:0x0224, B:82:0x022a, B:84:0x0231, B:68:0x01ec, B:50:0x018c, B:52:0x01a3, B:55:0x01b2, B:58:0x01bd, B:59:0x01c4), top: B:109:0x013c }] */
    /* JADX WARN: Code duplicated, block: B:55:0x01b2 A[Catch: OutOfMemoryError -> 0x023b, Exception -> 0x023d, TryCatch #6 {Exception -> 0x023d, OutOfMemoryError -> 0x023b, blocks: (B:39:0x013c, B:41:0x0146, B:43:0x014d, B:45:0x0171, B:47:0x0178, B:49:0x0186, B:61:0x01d1, B:63:0x01d6, B:66:0x01dd, B:70:0x01f5, B:72:0x01fc, B:73:0x0201, B:75:0x020d, B:77:0x0213, B:78:0x0218, B:80:0x0224, B:82:0x022a, B:84:0x0231, B:68:0x01ec, B:50:0x018c, B:52:0x01a3, B:55:0x01b2, B:58:0x01bd, B:59:0x01c4), top: B:109:0x013c }] */
    /* JADX WARN: Code duplicated, block: B:58:0x01bd A[Catch: OutOfMemoryError -> 0x023b, Exception -> 0x023d, TryCatch #6 {Exception -> 0x023d, OutOfMemoryError -> 0x023b, blocks: (B:39:0x013c, B:41:0x0146, B:43:0x014d, B:45:0x0171, B:47:0x0178, B:49:0x0186, B:61:0x01d1, B:63:0x01d6, B:66:0x01dd, B:70:0x01f5, B:72:0x01fc, B:73:0x0201, B:75:0x020d, B:77:0x0213, B:78:0x0218, B:80:0x0224, B:82:0x022a, B:84:0x0231, B:68:0x01ec, B:50:0x018c, B:52:0x01a3, B:55:0x01b2, B:58:0x01bd, B:59:0x01c4), top: B:109:0x013c }] */
    /* JADX WARN: Code duplicated, block: B:61:0x01d1 A[Catch: OutOfMemoryError -> 0x023b, Exception -> 0x023d, TryCatch #6 {Exception -> 0x023d, OutOfMemoryError -> 0x023b, blocks: (B:39:0x013c, B:41:0x0146, B:43:0x014d, B:45:0x0171, B:47:0x0178, B:49:0x0186, B:61:0x01d1, B:63:0x01d6, B:66:0x01dd, B:70:0x01f5, B:72:0x01fc, B:73:0x0201, B:75:0x020d, B:77:0x0213, B:78:0x0218, B:80:0x0224, B:82:0x022a, B:84:0x0231, B:68:0x01ec, B:50:0x018c, B:52:0x01a3, B:55:0x01b2, B:58:0x01bd, B:59:0x01c4), top: B:109:0x013c }] */
    /* JADX WARN: Code duplicated, block: B:63:0x01d6 A[Catch: OutOfMemoryError -> 0x023b, Exception -> 0x023d, TryCatch #6 {Exception -> 0x023d, OutOfMemoryError -> 0x023b, blocks: (B:39:0x013c, B:41:0x0146, B:43:0x014d, B:45:0x0171, B:47:0x0178, B:49:0x0186, B:61:0x01d1, B:63:0x01d6, B:66:0x01dd, B:70:0x01f5, B:72:0x01fc, B:73:0x0201, B:75:0x020d, B:77:0x0213, B:78:0x0218, B:80:0x0224, B:82:0x022a, B:84:0x0231, B:68:0x01ec, B:50:0x018c, B:52:0x01a3, B:55:0x01b2, B:58:0x01bd, B:59:0x01c4), top: B:109:0x013c }] */
    /* JADX WARN: Code duplicated, block: B:66:0x01dd A[Catch: OutOfMemoryError -> 0x023b, Exception -> 0x023d, TryCatch #6 {Exception -> 0x023d, OutOfMemoryError -> 0x023b, blocks: (B:39:0x013c, B:41:0x0146, B:43:0x014d, B:45:0x0171, B:47:0x0178, B:49:0x0186, B:61:0x01d1, B:63:0x01d6, B:66:0x01dd, B:70:0x01f5, B:72:0x01fc, B:73:0x0201, B:75:0x020d, B:77:0x0213, B:78:0x0218, B:80:0x0224, B:82:0x022a, B:84:0x0231, B:68:0x01ec, B:50:0x018c, B:52:0x01a3, B:55:0x01b2, B:58:0x01bd, B:59:0x01c4), top: B:109:0x013c }] */
    /* JADX WARN: Code duplicated, block: B:67:0x01ea A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x01ec A[Catch: OutOfMemoryError -> 0x023b, Exception -> 0x023d, TryCatch #6 {Exception -> 0x023d, OutOfMemoryError -> 0x023b, blocks: (B:39:0x013c, B:41:0x0146, B:43:0x014d, B:45:0x0171, B:47:0x0178, B:49:0x0186, B:61:0x01d1, B:63:0x01d6, B:66:0x01dd, B:70:0x01f5, B:72:0x01fc, B:73:0x0201, B:75:0x020d, B:77:0x0213, B:78:0x0218, B:80:0x0224, B:82:0x022a, B:84:0x0231, B:68:0x01ec, B:50:0x018c, B:52:0x01a3, B:55:0x01b2, B:58:0x01bd, B:59:0x01c4), top: B:109:0x013c }] */
    /* JADX WARN: Code duplicated, block: B:70:0x01f5 A[Catch: OutOfMemoryError -> 0x023b, Exception -> 0x023d, TryCatch #6 {Exception -> 0x023d, OutOfMemoryError -> 0x023b, blocks: (B:39:0x013c, B:41:0x0146, B:43:0x014d, B:45:0x0171, B:47:0x0178, B:49:0x0186, B:61:0x01d1, B:63:0x01d6, B:66:0x01dd, B:70:0x01f5, B:72:0x01fc, B:73:0x0201, B:75:0x020d, B:77:0x0213, B:78:0x0218, B:80:0x0224, B:82:0x022a, B:84:0x0231, B:68:0x01ec, B:50:0x018c, B:52:0x01a3, B:55:0x01b2, B:58:0x01bd, B:59:0x01c4), top: B:109:0x013c }] */
    /* JADX WARN: Code duplicated, block: B:72:0x01fc A[Catch: OutOfMemoryError -> 0x023b, Exception -> 0x023d, TryCatch #6 {Exception -> 0x023d, OutOfMemoryError -> 0x023b, blocks: (B:39:0x013c, B:41:0x0146, B:43:0x014d, B:45:0x0171, B:47:0x0178, B:49:0x0186, B:61:0x01d1, B:63:0x01d6, B:66:0x01dd, B:70:0x01f5, B:72:0x01fc, B:73:0x0201, B:75:0x020d, B:77:0x0213, B:78:0x0218, B:80:0x0224, B:82:0x022a, B:84:0x0231, B:68:0x01ec, B:50:0x018c, B:52:0x01a3, B:55:0x01b2, B:58:0x01bd, B:59:0x01c4), top: B:109:0x013c }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0231 A[Catch: OutOfMemoryError -> 0x023b, Exception -> 0x023d, TRY_LEAVE, TryCatch #6 {Exception -> 0x023d, OutOfMemoryError -> 0x023b, blocks: (B:39:0x013c, B:41:0x0146, B:43:0x014d, B:45:0x0171, B:47:0x0178, B:49:0x0186, B:61:0x01d1, B:63:0x01d6, B:66:0x01dd, B:70:0x01f5, B:72:0x01fc, B:73:0x0201, B:75:0x020d, B:77:0x0213, B:78:0x0218, B:80:0x0224, B:82:0x022a, B:84:0x0231, B:68:0x01ec, B:50:0x018c, B:52:0x01a3, B:55:0x01b2, B:58:0x01bd, B:59:0x01c4), top: B:109:0x013c }] */
    private static Notification.Builder deserializeNotificationCustom(Context context, DataInputStream dataInputStream) throws IOException {
        String str;
        String str2;
        String str3;
        String str4;
        Bundle bundle;
        long j;
        boolean z;
        String str5;
        String str6;
        String str7;
        String strDeserializeString;
        String strDeserializeString2;
        int i;
        boolean z2;
        String str8;
        String str9;
        String str10;
        String str11;
        long j2;
        String str12;
        boolean z3;
        String string;
        boolean z4;
        long j3;
        boolean z5;
        int i2;
        int i3;
        String strDeserializeString3;
        String strDeserializeString4;
        long j4;
        long j5;
        UnityNotificationManager notificationManagerImpl;
        Notification.Builder builderCreateNotificationBuilder;
        long j6;
        String str13;
        String str14;
        String str15 = "Failed to deserialize notification";
        String str16 = "UnityNotifications";
        try {
            try {
                try {
                    if (!readAndCheckMagicNumber(dataInputStream, UNITY_MAGIC_NUMBER)) {
                        return null;
                    }
                    int i4 = dataInputStream.readInt();
                    if (i4 < 0 || i4 > 3) {
                        return null;
                    }
                    if (i4 < 2) {
                        try {
                            bundle = (Bundle) deserializeParcelable(dataInputStream);
                        } catch (OutOfMemoryError e) {
                            e = e;
                            str3 = "Failed to deserialize notification";
                            str4 = "UnityNotifications";
                            Log.e(str4, str3, e);
                            return null;
                        }
                    } else {
                        bundle = null;
                    }
                    try {
                        if (bundle == null) {
                            int i5 = dataInputStream.readInt();
                            String strDeserializeString5 = deserializeString(dataInputStream);
                            String strDeserializeString6 = deserializeString(dataInputStream);
                            String strDeserializeString7 = deserializeString(dataInputStream);
                            String strDeserializeString8 = deserializeString(dataInputStream);
                            j = dataInputStream.readLong();
                            long j7 = dataInputStream.readLong();
                            String strDeserializeString9 = deserializeString(dataInputStream);
                            boolean z6 = dataInputStream.readBoolean();
                            z = dataInputStream.readBoolean();
                            String strDeserializeString10 = deserializeString(dataInputStream);
                            boolean z7 = i4 > 0 ? dataInputStream.readBoolean() : true;
                            if (i4 >= 3) {
                                String strDeserializeString11 = deserializeString(dataInputStream);
                                if (strDeserializeString11 == null || strDeserializeString11.length() <= 0) {
                                    str6 = strDeserializeString11;
                                    str5 = null;
                                    str7 = null;
                                } else {
                                    String strDeserializeString12 = deserializeString(dataInputStream);
                                    String strDeserializeString13 = deserializeString(dataInputStream);
                                    str9 = strDeserializeString6;
                                    str10 = strDeserializeString7;
                                    str11 = strDeserializeString8;
                                    j2 = j7;
                                    str12 = strDeserializeString9;
                                    z3 = z6;
                                    string = strDeserializeString10;
                                    z4 = z7;
                                    strDeserializeString = deserializeString(dataInputStream);
                                    strDeserializeString2 = deserializeString(dataInputStream);
                                    z2 = dataInputStream.readBoolean();
                                    str6 = strDeserializeString11;
                                    str5 = strDeserializeString12;
                                    i = i5;
                                    str8 = strDeserializeString5;
                                    j3 = j;
                                    str7 = strDeserializeString13;
                                }
                                String strDeserializeString14 = deserializeString(dataInputStream);
                                z5 = dataInputStream.readBoolean();
                                if (z5) {
                                    i2 = dataInputStream.readInt();
                                } else {
                                    i2 = 0;
                                }
                                i3 = dataInputStream.readInt();
                                boolean z8 = dataInputStream.readBoolean();
                                strDeserializeString3 = deserializeString(dataInputStream);
                                boolean z9 = dataInputStream.readBoolean();
                                int i6 = dataInputStream.readInt();
                                strDeserializeString4 = deserializeString(dataInputStream);
                                if (z) {
                                    j4 = dataInputStream.readLong();
                                } else {
                                    j4 = 0;
                                }
                                j5 = j4;
                                notificationManagerImpl = UnityNotificationManager.getNotificationManagerImpl(context);
                                builderCreateNotificationBuilder = notificationManagerImpl.createNotificationBuilder(strDeserializeString14);
                                if (bundle != null) {
                                    builderCreateNotificationBuilder.setExtras(bundle);
                                } else {
                                    builderCreateNotificationBuilder.getExtras().putInt(UnityNotificationManager.KEY_ID, i);
                                    UnityNotificationManager.setNotificationIcon(builderCreateNotificationBuilder, UnityNotificationManager.KEY_SMALL_ICON, str10);
                                    UnityNotificationManager.setNotificationIcon(builderCreateNotificationBuilder, UnityNotificationManager.KEY_LARGE_ICON, str11);
                                    if (j3 != -1) {
                                        builderCreateNotificationBuilder.getExtras().putLong(UnityNotificationManager.KEY_FIRE_TIME, j3);
                                    }
                                    j6 = j2;
                                    if (j6 != -1) {
                                        builderCreateNotificationBuilder.getExtras().putLong(UnityNotificationManager.KEY_REPEAT_INTERVAL, j6);
                                    }
                                    str13 = string;
                                    if (str13 != null) {
                                        builderCreateNotificationBuilder.getExtras().putString("data", str13);
                                    }
                                    builderCreateNotificationBuilder.getExtras().putBoolean(UnityNotificationManager.KEY_SHOW_IN_FOREGROUND, z4);
                                }
                                if (str8 != null) {
                                    builderCreateNotificationBuilder.setContentTitle(str8);
                                }
                                if (str9 != null) {
                                    builderCreateNotificationBuilder.setContentText(str9);
                                }
                                str14 = str12;
                                if (str14 != null) {
                                    builderCreateNotificationBuilder.setStyle(new Notification.BigTextStyle().bigText(str14));
                                } else if (str6 != null) {
                                    notificationManagerImpl.setupBigPictureStyle(builderCreateNotificationBuilder, str5, str6, str7, strDeserializeString, strDeserializeString2, z2);
                                }
                                if (z5) {
                                    UnityNotificationManager.setNotificationColor(builderCreateNotificationBuilder, i2);
                                }
                                if (i3 >= 0) {
                                    builderCreateNotificationBuilder.setNumber(i3);
                                }
                                builderCreateNotificationBuilder.setAutoCancel(z8);
                                UnityNotificationManager.setNotificationUsesChronometer(builderCreateNotificationBuilder, z3);
                                if (strDeserializeString3 != null && strDeserializeString3.length() > 0) {
                                    builderCreateNotificationBuilder.setGroup(strDeserializeString3);
                                }
                                builderCreateNotificationBuilder.setGroupSummary(z9);
                                UnityNotificationManager.setNotificationGroupAlertBehavior(builderCreateNotificationBuilder, i6);
                                if (strDeserializeString4 != null && strDeserializeString4.length() > 0) {
                                    builderCreateNotificationBuilder.setSortKey(strDeserializeString4);
                                }
                                if (z) {
                                    builderCreateNotificationBuilder.setShowWhen(true);
                                    builderCreateNotificationBuilder.setWhen(j5);
                                }
                                return builderCreateNotificationBuilder;
                            }
                            str5 = null;
                            str6 = null;
                            str7 = null;
                            strDeserializeString = str7;
                            strDeserializeString2 = strDeserializeString;
                            z2 = false;
                            i = i5;
                            str8 = strDeserializeString5;
                            str9 = strDeserializeString6;
                            str10 = strDeserializeString7;
                            str11 = strDeserializeString8;
                            j2 = j7;
                            str12 = strDeserializeString9;
                            z3 = z6;
                            string = strDeserializeString10;
                            z4 = z7;
                        } else {
                            String string2 = bundle.getString(NotificationCompat.EXTRA_TITLE);
                            String string3 = bundle.getString(NotificationCompat.EXTRA_TEXT);
                            String string4 = bundle.getString(UnityNotificationManager.KEY_SMALL_ICON);
                            String string5 = bundle.getString(UnityNotificationManager.KEY_LARGE_ICON);
                            j = bundle.getLong(UnityNotificationManager.KEY_FIRE_TIME, -1L);
                            long j8 = bundle.getLong(UnityNotificationManager.KEY_REPEAT_INTERVAL, -1L);
                            String string6 = bundle.getString(NotificationCompat.EXTRA_BIG_TEXT);
                            boolean z10 = bundle.getBoolean(NotificationCompat.EXTRA_SHOW_CHRONOMETER, false);
                            z = bundle.getBoolean(NotificationCompat.EXTRA_SHOW_WHEN, false);
                            str5 = null;
                            str6 = null;
                            str7 = null;
                            strDeserializeString = null;
                            strDeserializeString2 = null;
                            i = 0;
                            z2 = false;
                            str8 = string2;
                            str9 = string3;
                            str10 = string4;
                            str11 = string5;
                            j2 = j8;
                            str12 = string6;
                            z3 = z10;
                            string = bundle.getString("data");
                            z4 = true;
                        }
                        String strDeserializeString15 = deserializeString(dataInputStream);
                        z5 = dataInputStream.readBoolean();
                        if (z5) {
                            i2 = dataInputStream.readInt();
                        } else {
                            i2 = 0;
                        }
                        i3 = dataInputStream.readInt();
                        boolean z11 = dataInputStream.readBoolean();
                        strDeserializeString3 = deserializeString(dataInputStream);
                        boolean z12 = dataInputStream.readBoolean();
                        int i7 = dataInputStream.readInt();
                        strDeserializeString4 = deserializeString(dataInputStream);
                        if (z) {
                            j4 = dataInputStream.readLong();
                        } else {
                            j4 = 0;
                        }
                        j5 = j4;
                        notificationManagerImpl = UnityNotificationManager.getNotificationManagerImpl(context);
                        builderCreateNotificationBuilder = notificationManagerImpl.createNotificationBuilder(strDeserializeString15);
                        if (bundle != null) {
                            builderCreateNotificationBuilder.setExtras(bundle);
                        } else {
                            builderCreateNotificationBuilder.getExtras().putInt(UnityNotificationManager.KEY_ID, i);
                            UnityNotificationManager.setNotificationIcon(builderCreateNotificationBuilder, UnityNotificationManager.KEY_SMALL_ICON, str10);
                            UnityNotificationManager.setNotificationIcon(builderCreateNotificationBuilder, UnityNotificationManager.KEY_LARGE_ICON, str11);
                            if (j3 != -1) {
                                builderCreateNotificationBuilder.getExtras().putLong(UnityNotificationManager.KEY_FIRE_TIME, j3);
                            }
                            j6 = j2;
                            if (j6 != -1) {
                                builderCreateNotificationBuilder.getExtras().putLong(UnityNotificationManager.KEY_REPEAT_INTERVAL, j6);
                            }
                            str13 = string;
                            if (str13 != null) {
                                builderCreateNotificationBuilder.getExtras().putString("data", str13);
                            }
                            builderCreateNotificationBuilder.getExtras().putBoolean(UnityNotificationManager.KEY_SHOW_IN_FOREGROUND, z4);
                        }
                        if (str8 != null) {
                            builderCreateNotificationBuilder.setContentTitle(str8);
                        }
                        if (str9 != null) {
                            builderCreateNotificationBuilder.setContentText(str9);
                        }
                        str14 = str12;
                        if (str14 != null) {
                            builderCreateNotificationBuilder.setStyle(new Notification.BigTextStyle().bigText(str14));
                        } else if (str6 != null) {
                            notificationManagerImpl.setupBigPictureStyle(builderCreateNotificationBuilder, str5, str6, str7, strDeserializeString, strDeserializeString2, z2);
                        }
                        if (z5) {
                            UnityNotificationManager.setNotificationColor(builderCreateNotificationBuilder, i2);
                        }
                        if (i3 >= 0) {
                            builderCreateNotificationBuilder.setNumber(i3);
                        }
                        builderCreateNotificationBuilder.setAutoCancel(z11);
                        UnityNotificationManager.setNotificationUsesChronometer(builderCreateNotificationBuilder, z3);
                        if (strDeserializeString3 != null) {
                            builderCreateNotificationBuilder.setGroup(strDeserializeString3);
                        }
                        builderCreateNotificationBuilder.setGroupSummary(z12);
                        UnityNotificationManager.setNotificationGroupAlertBehavior(builderCreateNotificationBuilder, i7);
                        if (strDeserializeString4 != null) {
                            builderCreateNotificationBuilder.setSortKey(strDeserializeString4);
                        }
                        if (z) {
                            builderCreateNotificationBuilder.setShowWhen(true);
                            builderCreateNotificationBuilder.setWhen(j5);
                        }
                        return builderCreateNotificationBuilder;
                    } catch (Exception e2) {
                        e = e2;
                    } catch (OutOfMemoryError e3) {
                        e = e3;
                        str3 = str15;
                        str4 = str16;
                        Log.e(str4, str3, e);
                        return null;
                    }
                    j3 = j;
                } catch (Exception e4) {
                    e = e4;
                    str15 = "Failed to deserialize notification";
                    str16 = "UnityNotifications";
                }
                str = str15;
                str2 = str16;
            } catch (Exception e5) {
                e = e5;
                str = "Failed to deserialize notification";
                str2 = "UnityNotifications";
            }
        } catch (OutOfMemoryError e6) {
            e = e6;
            str15 = "Failed to deserialize notification";
            str16 = "UnityNotifications";
        }
        Log.e(str2, str, e);
        return null;
    }

    private static Notification.Builder deserializedFromOldIntent(Context context, byte[] bArr) {
        String str;
        String str2;
        String str3;
        String str4;
        try {
            try {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.unmarshall(bArr, 0, bArr.length);
                    parcelObtain.setDataPosition(0);
                    Bundle bundle = new Bundle();
                    bundle.readFromParcel(parcelObtain);
                    int i = bundle.getInt(UnityNotificationManager.KEY_ID, -1);
                    String string = bundle.getString(UnityNotificationManager.KEY_CHANNEL_ID);
                    String string2 = bundle.getString("textTitle");
                    String string3 = bundle.getString("textContent");
                    String string4 = bundle.getString("smallIconStr");
                    boolean z = bundle.getBoolean("autoCancel", false);
                    boolean z2 = bundle.getBoolean("usesChronometer", false);
                    long j = bundle.getLong(UnityNotificationManager.KEY_FIRE_TIME, -1L);
                    long j2 = bundle.getLong(UnityNotificationManager.KEY_REPEAT_INTERVAL, -1L);
                    str = "Failed to deserialize old style notification";
                    try {
                        String string5 = bundle.getString("largeIconStr");
                        str4 = "UnityNotifications";
                        try {
                            int i2 = bundle.getInt("style", -1);
                            int i3 = bundle.getInt("color", 0);
                            int i4 = bundle.getInt("number", 0);
                            String string6 = bundle.getString("data");
                            String string7 = bundle.getString(MapperConstants.SUBSCRIPTION_FIELD_GROUP);
                            boolean z3 = bundle.getBoolean("groupSummary", false);
                            String string8 = bundle.getString("sortKey");
                            int i5 = bundle.getInt("groupAlertBehaviour", -1);
                            boolean z4 = bundle.getBoolean("showTimestamp", false);
                            Notification.Builder builderCreateNotificationBuilder = UnityNotificationManager.getNotificationManagerImpl(context).createNotificationBuilder(string);
                            builderCreateNotificationBuilder.getExtras().putInt(UnityNotificationManager.KEY_ID, i);
                            builderCreateNotificationBuilder.setContentTitle(string2);
                            builderCreateNotificationBuilder.setContentText(string3);
                            UnityNotificationManager.setNotificationIcon(builderCreateNotificationBuilder, UnityNotificationManager.KEY_SMALL_ICON, string4);
                            builderCreateNotificationBuilder.setAutoCancel(z);
                            builderCreateNotificationBuilder.setUsesChronometer(z2);
                            builderCreateNotificationBuilder.getExtras().putLong(UnityNotificationManager.KEY_FIRE_TIME, j);
                            builderCreateNotificationBuilder.getExtras().putLong(UnityNotificationManager.KEY_REPEAT_INTERVAL, j2);
                            UnityNotificationManager.setNotificationIcon(builderCreateNotificationBuilder, UnityNotificationManager.KEY_LARGE_ICON, string5);
                            if (i2 == 2) {
                                builderCreateNotificationBuilder.setStyle(new Notification.BigTextStyle().bigText(string3));
                            }
                            if (i3 != 0) {
                                UnityNotificationManager.setNotificationColor(builderCreateNotificationBuilder, i3);
                            }
                            if (i4 >= 0) {
                                builderCreateNotificationBuilder.setNumber(i4);
                            }
                            if (string6 != null) {
                                builderCreateNotificationBuilder.getExtras().putString("data", string6);
                            }
                            if (string7 != null && string7.length() > 0) {
                                builderCreateNotificationBuilder.setGroup(string7);
                            }
                            builderCreateNotificationBuilder.setGroupSummary(z3);
                            if (string8 != null && string8.length() > 0) {
                                builderCreateNotificationBuilder.setSortKey(string8);
                            }
                            UnityNotificationManager.setNotificationGroupAlertBehavior(builderCreateNotificationBuilder, i5);
                            builderCreateNotificationBuilder.setShowWhen(z4);
                            return builderCreateNotificationBuilder;
                        } catch (Exception e) {
                            e = e;
                            str2 = str;
                            str3 = str4;
                            Log.e(str3, str2, e);
                            return null;
                        } catch (OutOfMemoryError e2) {
                            e = e2;
                            Log.e(str4, str, e);
                            return null;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str4 = "UnityNotifications";
                        str2 = str;
                        str3 = str4;
                        Log.e(str3, str2, e);
                        return null;
                    } catch (OutOfMemoryError e4) {
                        e = e4;
                        str4 = "UnityNotifications";
                        Log.e(str4, str, e);
                        return null;
                    }
                } catch (Exception e5) {
                    e = e5;
                    str = "Failed to deserialize old style notification";
                }
            } catch (OutOfMemoryError e6) {
                e = e6;
                str = "Failed to deserialize old style notification";
            }
        } catch (Exception e7) {
            e = e7;
            str2 = "Failed to deserialize old style notification";
            str3 = "UnityNotifications";
        }
    }

    private static String deserializeString(DataInputStream dataInputStream) throws IOException {
        int i = dataInputStream.readInt();
        if (i <= 0) {
            return null;
        }
        byte[] bArr = new byte[i];
        if (dataInputStream.read(bArr) != i) {
            throw new IOException("Insufficient amount of bytes read");
        }
        return new String(bArr, StandardCharsets.UTF_8);
    }

    private static <T extends Parcelable> T deserializeParcelable(DataInputStream dataInputStream) throws IOException {
        int i = dataInputStream.readInt();
        if (i <= 0) {
            return null;
        }
        byte[] bArr = new byte[i];
        if (dataInputStream.read(bArr) != i) {
            throw new IOException("Insufficient amount of bytes read");
        }
        try {
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.unmarshall(bArr, 0, i);
            parcelObtain.setDataPosition(0);
            Bundle bundle = (Bundle) parcelObtain.readParcelable(UnityNotificationUtilities.class.getClassLoader());
            parcelObtain.recycle();
            if (bundle != null) {
                return (T) bundle.getParcelable("obj");
            }
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to deserialize parcelable", e);
        } catch (OutOfMemoryError e2) {
            Log.e("UnityNotifications", "Failed to deserialize parcelable", e2);
        }
        return null;
    }

    protected static Class<?> getOpenAppActivity(Context context) {
        try {
            try {
                PackageManager packageManager = context.getPackageManager();
                Bundle bundle = packageManager.getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle.containsKey("custom_notification_android_activity")) {
                    try {
                        return Class.forName(bundle.getString("custom_notification_android_activity"));
                    } catch (ClassNotFoundException e) {
                        Log.e("UnityNotifications", "Specified activity class for notifications not found: " + e.getMessage());
                    }
                }
                Log.w("UnityNotifications", "No custom_notification_android_activity found, attempting to find app activity class");
                ActivityInfo[] activityInfoArr = packageManager.getPackageInfo(context.getPackageName(), 1).activities;
                if (activityInfoArr == null) {
                    Log.e("UnityNotifications", "Could not get package activities");
                    return null;
                }
                String str = null;
                boolean z = false;
                boolean z2 = false;
                for (ActivityInfo activityInfo : activityInfoArr) {
                    if (activityInfo.enabled && activityInfo.targetActivity == null) {
                        boolean zIsUnityActivity = isUnityActivity(activityInfo.name);
                        if (str == null) {
                            str = activityInfo.name;
                        } else if (z == zIsUnityActivity) {
                            if (z && zIsUnityActivity) {
                                Log.e("UnityNotifications", "Multiple choices for activity for notifications, set activity explicitly in Notification Settings");
                                return null;
                            }
                            z2 = true;
                        } else if (zIsUnityActivity) {
                            str = activityInfo.name;
                            z2 = false;
                        }
                        z = zIsUnityActivity;
                    }
                }
                if (!z2) {
                    if (str != null) {
                        return Class.forName(str);
                    }
                    Log.e("UnityNotifications", "Activity class for notifications not found");
                    return null;
                }
                Log.e("UnityNotifications", "Multiple choices for activity for notifications, set activity explicitly in Notification Settings");
                return null;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return null;
            }
        } catch (ClassNotFoundException e3) {
            Log.e("UnityNotifications", "Failed to find activity class: " + e3.getMessage());
            return null;
        }
    }

    private static boolean isUnityActivity(String str) {
        return str.endsWith(".UnityPlayerActivity") || str.endsWith(".UnityPlayerGameActivity");
    }

    protected static Notification.Builder recoverBuilder(Context context, Notification notification) {
        try {
            Notification.Builder builderRecoverBuilder = Notification.Builder.recoverBuilder(context, notification);
            builderRecoverBuilder.setExtras(notification.extras);
            return builderRecoverBuilder;
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to recover builder for notification!", e);
            return recoverBuilderCustom(context, notification);
        } catch (OutOfMemoryError e2) {
            Log.e("UnityNotifications", "Failed to recover builder for notification!", e2);
            return recoverBuilderCustom(context, notification);
        }
    }

    private static Notification.Builder recoverBuilderCustom(Context context, Notification notification) {
        Notification.Builder builderCreateNotificationBuilder = UnityNotificationManager.getNotificationManagerImpl(context).createNotificationBuilder(notification.extras.getString(UnityNotificationManager.KEY_CHANNEL_ID));
        UnityNotificationManager.setNotificationIcon(builderCreateNotificationBuilder, UnityNotificationManager.KEY_SMALL_ICON, notification.extras.getString(UnityNotificationManager.KEY_SMALL_ICON));
        String string = notification.extras.getString(UnityNotificationManager.KEY_LARGE_ICON);
        if (string != null && !string.isEmpty()) {
            UnityNotificationManager.setNotificationIcon(builderCreateNotificationBuilder, UnityNotificationManager.KEY_LARGE_ICON, string);
        }
        builderCreateNotificationBuilder.setContentTitle(notification.extras.getString(NotificationCompat.EXTRA_TITLE));
        builderCreateNotificationBuilder.setContentText(notification.extras.getString(NotificationCompat.EXTRA_TEXT));
        builderCreateNotificationBuilder.setAutoCancel((notification.flags & 16) != 0);
        if (notification.number >= 0) {
            builderCreateNotificationBuilder.setNumber(notification.number);
        }
        String string2 = notification.extras.getString(NotificationCompat.EXTRA_BIG_TEXT);
        if (string2 != null) {
            builderCreateNotificationBuilder.setStyle(new Notification.BigTextStyle().bigText(string2));
        }
        builderCreateNotificationBuilder.setWhen(notification.when);
        String group = notification.getGroup();
        if (group != null && !group.isEmpty()) {
            builderCreateNotificationBuilder.setGroup(group);
        }
        builderCreateNotificationBuilder.setGroupSummary((notification.flags & 512) != 0);
        String sortKey = notification.getSortKey();
        if (sortKey != null && !sortKey.isEmpty()) {
            builderCreateNotificationBuilder.setSortKey(sortKey);
        }
        builderCreateNotificationBuilder.setShowWhen(notification.extras.getBoolean(NotificationCompat.EXTRA_SHOW_WHEN, false));
        Integer notificationColor = UnityNotificationManager.getNotificationColor(notification);
        if (notificationColor != null) {
            UnityNotificationManager.setNotificationColor(builderCreateNotificationBuilder, notificationColor.intValue());
        }
        UnityNotificationManager.setNotificationUsesChronometer(builderCreateNotificationBuilder, notification.extras.getBoolean(NotificationCompat.EXTRA_SHOW_CHRONOMETER, false));
        UnityNotificationManager.setNotificationGroupAlertBehavior(builderCreateNotificationBuilder, UnityNotificationManager.getNotificationGroupAlertBehavior(notification));
        builderCreateNotificationBuilder.getExtras().putInt(UnityNotificationManager.KEY_ID, notification.extras.getInt(UnityNotificationManager.KEY_ID, 0));
        builderCreateNotificationBuilder.getExtras().putLong(UnityNotificationManager.KEY_REPEAT_INTERVAL, notification.extras.getLong(UnityNotificationManager.KEY_REPEAT_INTERVAL, 0L));
        builderCreateNotificationBuilder.getExtras().putLong(UnityNotificationManager.KEY_FIRE_TIME, notification.extras.getLong(UnityNotificationManager.KEY_FIRE_TIME, 0L));
        String string3 = notification.extras.getString("data");
        if (string3 != null && !string3.isEmpty()) {
            builderCreateNotificationBuilder.getExtras().putString("data", string3);
        }
        return builderCreateNotificationBuilder;
    }
}
