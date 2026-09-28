package com.google.android.gms.nearby.exposurenotification;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public class WakeUpService extends Service {
    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return new Messenger(new zzr(null)).getBinder();
    }
}
