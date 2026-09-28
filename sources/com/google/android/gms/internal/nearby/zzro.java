package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.uwb.RangingSessionCallback;
import com.google.android.gms.nearby.uwb.UwbDevice;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzro extends zznp {
    final /* synthetic */ zzpm zza;
    final /* synthetic */ zzrr zzb;

    zzro(zzrr zzrrVar, zzpm zzpmVar) {
        this.zzb = zzrrVar;
        this.zza = zzpmVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        zzrr zzrrVar = this.zzb;
        ((RangingSessionCallback) obj).onRangingInitialized(UwbDevice.createForAddress(this.zza.zza().zza().zzb()));
    }
}
