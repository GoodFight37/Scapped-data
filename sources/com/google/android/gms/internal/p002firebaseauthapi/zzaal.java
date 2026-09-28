package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaal implements zzaew<zzagw> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzadp zze;
    private final /* synthetic */ zzzv zzf;

    zzaal(zzzv zzzvVar, String str, String str2, String str3, String str4, zzadp zzadpVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = zzadpVar;
        this.zzf = zzzvVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaet
    public final void zza(String str) {
        this.zze.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final /* synthetic */ void zza(zzagw zzagwVar) {
        zzzv.zza(this.zzf, this.zze, new zzahn(this.zza, this.zzb, null, this.zzc, this.zzd, zzagwVar.zzc()), this);
    }
}
