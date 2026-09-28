package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzgs extends zzgp {
    final /* synthetic */ String zza;
    final /* synthetic */ PayloadTransferUpdate zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgs(zzgu zzguVar, String str, PayloadTransferUpdate payloadTransferUpdate) {
        super(null);
        this.zza = str;
        this.zzb = payloadTransferUpdate;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        String str = this.zza;
        PayloadTransferUpdate.Builder builder = new PayloadTransferUpdate.Builder(this.zzb);
        builder.setStatus(2);
        ((PayloadCallback) obj).onPayloadTransferUpdate(str, builder.build());
    }
}
