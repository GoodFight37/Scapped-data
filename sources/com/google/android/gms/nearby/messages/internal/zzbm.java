package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.SubscribeOptions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzbm extends zzbu {
    final /* synthetic */ ListenerHolder zza;
    final /* synthetic */ zzbw zzb;
    final /* synthetic */ SubscribeOptions zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbm(zzbx zzbxVar, GoogleApiClient googleApiClient, ListenerHolder listenerHolder, zzbw zzbwVar, SubscribeOptions subscribeOptions) {
        super(googleApiClient);
        this.zza = listenerHolder;
        this.zzb = zzbwVar;
        this.zzc = subscribeOptions;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzai) anyClient).zzx(zza(), this.zza, this.zzb, this.zzc, null);
    }
}
