package com.google.android.gms.common.api.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zav implements Runnable {
    final /* synthetic */ zaz zaa;

    zav(zaz zazVar) {
        this.zaa = zazVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zaa.zam.lock();
        try {
            zaz.zap(this.zaa);
        } finally {
            this.zaa.zam.unlock();
        }
    }
}
