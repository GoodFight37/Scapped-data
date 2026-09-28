package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaap implements zzaew<zzagw> {
    final /* synthetic */ zzzv zza;
    private final /* synthetic */ zzaic zzb;
    private final /* synthetic */ zzadp zzc;

    zzaap(zzzv zzzvVar, zzaic zzaicVar, zzadp zzadpVar) {
        this.zzb = zzaicVar;
        this.zzc = zzadpVar;
        this.zza = zzzvVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaet
    public final void zza(String str) {
        this.zzc.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final /* synthetic */ void zza(zzagw zzagwVar) {
        this.zzb.zzb(true);
        this.zzb.zza(zzagwVar.zzc());
        this.zza.zza.zza(this.zzb, new zzaao(this, this.zzc, this));
    }
}
