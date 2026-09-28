package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzgd extends zzgp {
    final /* synthetic */ zzle zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgd(zzgg zzggVar, zzle zzleVar) {
        super(null);
        this.zza = zzleVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        EndpointDiscoveryCallback endpointDiscoveryCallback = (EndpointDiscoveryCallback) obj;
        if (zzgg.zzg(this.zza)) {
            com.google.android.gms.nearby.connection.zzn zznVar = new com.google.android.gms.nearby.connection.zzn();
            zznVar.zzd(this.zza.zzd());
            zznVar.zza(this.zza.zza());
            endpointDiscoveryCallback.onEndpointFound("__UNRECOGNIZED_BLUETOOTH_DEVICE__", zznVar.zze());
            return;
        }
        String strZzb = this.zza.zzb();
        com.google.android.gms.nearby.connection.zzn zznVar2 = new com.google.android.gms.nearby.connection.zzn();
        zznVar2.zzd(this.zza.zzd());
        zznVar2.zzc(this.zza.zzc());
        zznVar2.zzb(this.zza.zze());
        endpointDiscoveryCallback.onEndpointFound(strZzb, zznVar2.zze());
    }
}
