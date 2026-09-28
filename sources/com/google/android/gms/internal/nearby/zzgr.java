package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.PayloadCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzgr extends zzgp {
    final /* synthetic */ zzlk zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgr(zzgu zzguVar, zzlk zzlkVar) {
        super(null);
        this.zza = zzlkVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((PayloadCallback) obj).onPayloadTransferUpdate(this.zza.zzb(), this.zza.zza());
    }
}
