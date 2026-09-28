package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Connections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzga extends zzgp {
    final /* synthetic */ zzkw zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzga(zzgb zzgbVar, zzkw zzkwVar) {
        super(null);
        this.zza = zzkwVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        Connections.ConnectionResponseCallback connectionResponseCallback = (Connections.ConnectionResponseCallback) obj;
        byte[] bArrZzc = this.zza.zzc();
        if (bArrZzc != null) {
            connectionResponseCallback.onConnectionResponse(this.zza.zzb(), zzgy.zzG(this.zza.zza()), bArrZzc);
        }
    }
}
