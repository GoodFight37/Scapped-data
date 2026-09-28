package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaas implements zzaew<zzagw> {
    final /* synthetic */ zzzv zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzadp zzd;

    zzaas(zzzv zzzvVar, String str, String str2, zzadp zzadpVar) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzadpVar;
        this.zza = zzzvVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaet
    public final void zza(String str) {
        this.zzd.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final /* synthetic */ void zza(zzagw zzagwVar) {
        this.zza.zza.zza(new zzaij(zzagwVar.zzc(), this.zzb, this.zzc), new zzaav(this, this.zzd));
    }
}
