package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zaax implements GoogleApiClient.ConnectionCallbacks {
    final /* synthetic */ AtomicReference zaa;
    final /* synthetic */ StatusPendingResult zab;
    final /* synthetic */ zabc zac;

    zaax(zabc zabcVar, AtomicReference atomicReference, StatusPendingResult statusPendingResult) {
        this.zaa = atomicReference;
        this.zab = statusPendingResult;
        this.zac = zabcVar;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.zac.zam((GoogleApiClient) Preconditions.checkNotNull((GoogleApiClient) this.zaa.get()), this.zab, true);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
