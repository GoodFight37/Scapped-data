package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzzy implements zzaew<zzafx> {
    private final /* synthetic */ zzadp zza;
    private final /* synthetic */ zzzv zzb;

    zzzy(zzzv zzzvVar, zzadp zzadpVar) {
        this.zza = zzadpVar;
        this.zzb = zzzvVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaet
    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final /* synthetic */ void zza(zzafx zzafxVar) {
        zzafx zzafxVar2 = zzafxVar;
        if (zzafxVar2.zzf()) {
            this.zza.zza(new zzzs(zzafxVar2.zzc(), zzafxVar2.zze(), null));
        } else {
            this.zzb.zza(new zzagw(zzafxVar2.zzd(), zzafxVar2.zzb(), Long.valueOf(zzafxVar2.zza()), "Bearer"), null, null, Boolean.valueOf(zzafxVar2.zzg()), null, this.zza, this);
        }
    }
}
