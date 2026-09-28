package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.Strategy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzin extends zzjf {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ ListenerHolder zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzin(zzji zzjiVar, GoogleApiClient googleApiClient, String str, long j, ListenerHolder listenerHolder) {
        super(googleApiClient, null);
        this.zza = str;
        this.zzb = j;
        this.zzc = listenerHolder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        String str = this.zza;
        long j = this.zzb;
        ListenerHolder listenerHolder = this.zzc;
        AdvertisingOptions.Builder builder = new AdvertisingOptions.Builder();
        builder.setStrategy(Strategy.P2P_CLUSTER);
        AdvertisingOptions advertisingOptionsBuild = builder.build();
        zzkd zzkdVar = (zzkd) ((zzgy) anyClient).getService();
        zzmq zzmqVar = new zzmq();
        zzmqVar.zzg(new zzgx(this));
        zzmqVar.zze(str);
        zzmqVar.zzh("__LEGACY_SERVICE_ID__");
        zzmqVar.zzc(j);
        zzmqVar.zza(new zzfz(listenerHolder));
        zzmqVar.zzf(advertisingOptionsBuild);
        zzkdVar.zzk(zzmqVar.zzi());
    }
}
