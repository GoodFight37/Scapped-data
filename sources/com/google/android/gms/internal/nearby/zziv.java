package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.connection.AdvertisingOptions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zziv extends zzjf {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ ListenerHolder zzc;
    final /* synthetic */ AdvertisingOptions zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zziv(zzji zzjiVar, GoogleApiClient googleApiClient, String str, String str2, ListenerHolder listenerHolder, AdvertisingOptions advertisingOptions) {
        super(googleApiClient, null);
        this.zza = str;
        this.zzb = str2;
        this.zzc = listenerHolder;
        this.zzd = advertisingOptions;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzgy) anyClient).zzA(this, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
