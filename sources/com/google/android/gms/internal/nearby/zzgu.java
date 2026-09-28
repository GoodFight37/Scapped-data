package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzgu extends zzkf implements zzgk {
    private final Context zza;
    private final ListenerHolder zzb;
    private final Map zzc = new ArrayMap();
    private final zzlt zzd;

    zzgu(Context context, ListenerHolder listenerHolder, zzlt zzltVar) {
        this.zza = (Context) Preconditions.checkNotNull(context);
        this.zzb = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        this.zzd = zzltVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzkg
    public final synchronized void zzb(zzli zzliVar) {
        Payload payloadZza = zzmd.zza(this.zza, zzliVar.zza());
        if (payloadZza == null) {
            Log.w("NearbyConnectionsClient", String.format("Failed to convert incoming ParcelablePayload %d to Payload.", Long.valueOf(zzliVar.zza().zzb())));
            return;
        }
        Map map = this.zzc;
        zzgt zzgtVar = new zzgt(zzliVar.zzb(), zzliVar.zza().zzb());
        PayloadTransferUpdate.Builder builder = new PayloadTransferUpdate.Builder();
        builder.setPayloadId(zzliVar.zza().zzb());
        map.put(zzgtVar, builder.build());
        this.zzb.notifyListener(new zzgq(this, zzliVar, payloadZza));
    }

    @Override // com.google.android.gms.internal.nearby.zzkg
    public final synchronized void zzc(zzlk zzlkVar) {
        if (zzlkVar.zza().getStatus() == 3) {
            this.zzc.put(new zzgt(zzlkVar.zzb(), zzlkVar.zza().getPayloadId()), zzlkVar.zza());
        } else {
            this.zzc.remove(new zzgt(zzlkVar.zzb(), zzlkVar.zza().getPayloadId()));
            zzlt zzltVar = this.zzd;
            if (zzltVar != null) {
                zzltVar.zzb(zzlkVar.zza().getPayloadId());
            }
        }
        this.zzb.notifyListener(new zzgr(this, zzlkVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzgk
    public final synchronized void zzf() {
        for (Map.Entry entry : this.zzc.entrySet()) {
            this.zzb.notifyListener(new zzgs(this, ((zzgt) entry.getKey()).zza(), (PayloadTransferUpdate) entry.getValue()));
        }
        this.zzc.clear();
    }
}
