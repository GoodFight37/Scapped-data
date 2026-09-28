package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zaba extends com.google.android.gms.internal.base.zaq {
    final /* synthetic */ zabc zaa;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zaba(zabc zabcVar, Looper looper) {
        super(looper);
        this.zaa = zabcVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            zabc.zaj(this.zaa);
            return;
        }
        if (i == 2) {
            zabc.zai(this.zaa);
            return;
        }
        Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
    }
}
