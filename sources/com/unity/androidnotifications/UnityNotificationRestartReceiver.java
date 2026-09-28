package com.unity.androidnotifications;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UnityNotificationRestartReceiver extends BroadcastReceiver {
    private static final long EXPIRATION_TRESHOLD = 600000;

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        Log.d("UnityNotifications", "Rescheduling notifications after restart");
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            AsyncTask.execute(new Runnable() { // from class: com.unity.androidnotifications.UnityNotificationRestartReceiver$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    UnityNotificationRestartReceiver.rescheduleSavedNotifications(context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void rescheduleSavedNotifications(Context context) {
        UnityNotificationManager notificationManagerImpl = UnityNotificationManager.getNotificationManagerImpl(context);
        List<Notification.Builder> listLoadSavedNotifications = notificationManagerImpl.loadSavedNotifications();
        Date time = Calendar.getInstance().getTime();
        Iterator<Notification.Builder> it = listLoadSavedNotifications.iterator();
        while (it.hasNext()) {
            rescheduleNotification(notificationManagerImpl, time, it.next());
        }
    }

    private static boolean rescheduleNotification(UnityNotificationManager unityNotificationManager, Date date, Notification.Builder builder) {
        try {
            Bundle extras = builder.getExtras();
            long j = extras.getLong(UnityNotificationManager.KEY_REPEAT_INTERVAL, 0L);
            long j2 = extras.getLong(UnityNotificationManager.KEY_FIRE_TIME, 0L);
            Date date2 = new Date(j2);
            boolean z = j > 0;
            if (!date2.after(date) && !z) {
                if (date.getTime() - j2 < EXPIRATION_TRESHOLD) {
                    unityNotificationManager.notify(extras.getInt(UnityNotificationManager.KEY_ID), builder);
                    return true;
                }
                Log.d("UnityNotifications", "Notification expired, not rescheduling, ID: " + extras.getInt(UnityNotificationManager.KEY_ID, -1));
                return false;
            }
            unityNotificationManager.scheduleAlarmWithNotification(builder);
            return true;
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to reschedule notification", e);
            return false;
        }
    }
}
