package com.google.android.gms.common.api.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zabl implements Runnable {
    final /* synthetic */ int zaa;
    final /* synthetic */ zabo zab;

    zabl(zabo zaboVar, int i) {
        this.zaa = i;
        this.zab = zaboVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zab.zaI(this.zaa);
    }
}
