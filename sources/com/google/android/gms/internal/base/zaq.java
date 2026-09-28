package com.google.android.gms.internal.base;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
public class zaq extends Handler {
    private final Looper zaa;

    public zaq() {
        this.zaa = Looper.getMainLooper();
    }

    public zaq(Looper looper) {
        super(looper);
        this.zaa = Looper.getMainLooper();
    }

    public zaq(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.zaa = Looper.getMainLooper();
    }
}
