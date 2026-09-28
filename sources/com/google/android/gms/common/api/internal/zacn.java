package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zacn implements Runnable {
    final /* synthetic */ zacq zaa;

    zacn(zacq zacqVar) {
        this.zaa = zacqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zaa.zah.zae(new ConnectionResult(4));
    }
}
