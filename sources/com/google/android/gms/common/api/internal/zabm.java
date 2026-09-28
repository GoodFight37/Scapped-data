package com.google.android.gms.common.api.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zabm implements Runnable {
    final /* synthetic */ zabn zaa;

    zabm(zabn zabnVar) {
        this.zaa = zabnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zabo zaboVar = this.zaa.zaa;
        zaboVar.zac.disconnect(String.valueOf(zaboVar.zac.getClass().getName()).concat(" disconnecting because it was signed out."));
    }
}
