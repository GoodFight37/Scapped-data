package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zabf extends com.google.android.gms.internal.base.zaq {
    final /* synthetic */ zabg zaa;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zabf(zabg zabgVar, Looper looper) {
        super(looper);
        this.zaa = zabgVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            ((zabe) message.obj).zab(this.zaa);
        } else {
            if (i == 2) {
                throw ((RuntimeException) message.obj);
            }
            Log.w("GACStateManager", "Unknown message id: " + message.what);
        }
    }
}
