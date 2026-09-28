package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.connection.Connections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzfy extends zzgp {
    final /* synthetic */ zzku zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfy(zzfz zzfzVar, zzku zzkuVar) {
        super(null);
        this.zza = zzkuVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((Connections.ConnectionRequestListener) obj).onConnectionRequest(this.zza.zza(), this.zza.zzb(), (byte[]) Preconditions.checkNotNull(this.zza.zzc()));
    }
}
