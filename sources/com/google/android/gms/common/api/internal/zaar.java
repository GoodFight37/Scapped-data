package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zaar implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    final /* synthetic */ zaau zaa;

    /* synthetic */ zaar(zaau zaauVar, zaat zaatVar) {
        this.zaa = zaauVar;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        ((com.google.android.gms.signin.zae) Preconditions.checkNotNull(this.zaa.zak)).zad(new zaaq(this.zaa));
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zaa.zab.lock();
        try {
            if (this.zaa.zaI(connectionResult)) {
                this.zaa.zaA();
                this.zaa.zaF();
            } else {
                this.zaa.zaD(connectionResult);
            }
        } finally {
            this.zaa.zab.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
