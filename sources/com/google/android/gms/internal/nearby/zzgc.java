package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzgc extends zzgp {
    final /* synthetic */ zzlc zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgc(zzgg zzggVar, zzlc zzlcVar) {
        super(null);
        this.zza = zzlcVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        this.zza.zzc();
        this.zza.zza();
        this.zza.zzb();
    }
}
