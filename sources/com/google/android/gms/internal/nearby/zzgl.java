package com.google.android.gms.internal.nearby;

import android.util.Log;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.Payload;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzgl extends zzgp {
    final /* synthetic */ zzli zza;
    final /* synthetic */ zzgn zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgl(zzgn zzgnVar, zzli zzliVar) {
        super(null);
        this.zzb = zzgnVar;
        this.zza = zzliVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        byte[] bArrAsBytes;
        Connections.MessageListener messageListener = (Connections.MessageListener) obj;
        Payload payloadZza = zzmd.zza(this.zzb.zza, this.zza.zza());
        if (payloadZza == null) {
            Log.w("NearbyConnectionsClient", String.format("Failed to convert incoming ParcelablePayload %d to Payload.", Long.valueOf(this.zza.zza().zzb())));
        } else if (payloadZza.getType() == 1 && (bArrAsBytes = payloadZza.asBytes()) != null) {
            messageListener.onMessageReceived(this.zza.zzb(), bArrAsBytes, this.zza.zzc());
        }
    }
}
