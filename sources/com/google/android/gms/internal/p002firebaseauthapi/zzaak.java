package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaak implements zzaew<zzahq> {
    private final /* synthetic */ zzadp zza;
    private final /* synthetic */ zzaet zzb;
    private final /* synthetic */ zzzv zzc;

    zzaak(zzzv zzzvVar, zzadp zzadpVar, zzaet zzaetVar) {
        this.zza = zzadpVar;
        this.zzb = zzaetVar;
        this.zzc = zzzvVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaet
    public final void zza(String str) {
        this.zzb.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final /* synthetic */ void zza(zzahq zzahqVar) {
        zzahq zzahqVar2 = zzahqVar;
        this.zzc.zza(new zzagw(zzahqVar2.zzc(), zzahqVar2.zzb(), Long.valueOf(zzahqVar2.zza()), "Bearer"), null, "password", false, null, this.zza, this);
    }
}
