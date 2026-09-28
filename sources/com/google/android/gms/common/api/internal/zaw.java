package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zaw implements zabx {
    final /* synthetic */ zaz zaa;

    /* synthetic */ zaw(zaz zazVar, zay zayVar) {
        this.zaa = zazVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabx
    public final void zaa(ConnectionResult connectionResult) {
        this.zaa.zam.lock();
        try {
            this.zaa.zaj = connectionResult;
            zaz.zap(this.zaa);
        } finally {
            this.zaa.zam.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabx
    public final void zab(Bundle bundle) {
        this.zaa.zam.lock();
        try {
            zaz.zao(this.zaa, bundle);
            this.zaa.zaj = ConnectionResult.RESULT_SUCCESS;
            zaz.zap(this.zaa);
        } finally {
            this.zaa.zam.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabx
    public final void zac(int i, boolean z) {
        this.zaa.zam.lock();
        try {
            zaz zazVar = this.zaa;
            if (zazVar.zal || zazVar.zak == null || !zazVar.zak.isSuccess()) {
                this.zaa.zal = false;
                zaz.zan(this.zaa, i, z);
            } else {
                this.zaa.zal = true;
                this.zaa.zae.onConnectionSuspended(i);
            }
        } finally {
            this.zaa.zam.unlock();
        }
    }
}
