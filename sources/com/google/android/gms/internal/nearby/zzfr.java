package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzfr extends zzgp {
    final /* synthetic */ zzks zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfr(zzfx zzfxVar, zzks zzksVar) {
        super(null);
        this.zza = zzksVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        String strZzb = this.zza.zzb();
        com.google.android.gms.nearby.connection.zzg zzgVar = new com.google.android.gms.nearby.connection.zzg();
        zzgVar.zzc(this.zza.zzc());
        zzgVar.zza(this.zza.zza());
        zzgVar.zzf(this.zza.zzf());
        zzgVar.zze(this.zza.zze());
        zzgVar.zzb(this.zza.zzg());
        zzgVar.zzd(this.zza.zzd());
        ((ConnectionLifecycleCallback) obj).onConnectionInitiated(strZzb, zzgVar.zzg());
    }
}
