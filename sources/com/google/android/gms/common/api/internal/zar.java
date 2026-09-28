package com.google.android.gms.common.api.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zar {
    final /* synthetic */ BasePendingResult zaa;

    /* synthetic */ zar(BasePendingResult basePendingResult, zas zasVar) {
        this.zaa = basePendingResult;
    }

    protected final void finalize() throws Throwable {
        BasePendingResult.zal(this.zaa.zaj);
        super.finalize();
    }
}
