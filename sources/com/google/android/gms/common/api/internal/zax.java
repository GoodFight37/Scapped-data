package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zax implements zabx {
    final /* synthetic */ zaz zaa;

    /* synthetic */ zax(zaz zazVar, zay zayVar) {
        this.zaa = zazVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabx
    public final void zaa(ConnectionResult connectionResult) {
        this.zaa.zam.lock();
        try {
            this.zaa.zak = connectionResult;
            zaz.zap(this.zaa);
        } finally {
            this.zaa.zam.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabx
    public final void zab(Bundle bundle) {
        this.zaa.zam.lock();
        try {
            this.zaa.zak = ConnectionResult.RESULT_SUCCESS;
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
            if (zazVar.zal) {
                zazVar.zal = false;
                zaz.zan(this.zaa, i, z);
            } else {
                zazVar.zal = true;
                this.zaa.zad.onConnectionSuspended(i);
            }
        } finally {
            this.zaa.zam.unlock();
        }
    }
}
