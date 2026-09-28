package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Connections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzgm extends zzgp {
    final /* synthetic */ zzla zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgm(zzgn zzgnVar, zzla zzlaVar) {
        super(null);
        this.zza = zzlaVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((Connections.MessageListener) obj).onDisconnected(this.zza.zza());
    }
}
