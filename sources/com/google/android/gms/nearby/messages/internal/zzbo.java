package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzbo extends zzbu {
    final /* synthetic */ ListenerHolder zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbo(zzbx zzbxVar, GoogleApiClient googleApiClient, ListenerHolder listenerHolder) {
        super(googleApiClient);
        this.zza = listenerHolder;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzai) anyClient).zzC(zza(), this.zza);
    }
}
