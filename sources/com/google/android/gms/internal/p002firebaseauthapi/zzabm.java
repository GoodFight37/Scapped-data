package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzabm implements zzaew<zzagw> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzadp zzb;
    private final /* synthetic */ zzzv zzc;

    zzabm(zzzv zzzvVar, String str, zzadp zzadpVar) {
        this.zza = str;
        this.zzb = zzadpVar;
        this.zzc = zzzvVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaet
    public final void zza(String str) {
        this.zzb.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final /* synthetic */ void zza(zzagw zzagwVar) {
        zzagw zzagwVar2 = zzagwVar;
        String strZzc = zzagwVar2.zzc();
        zzahm zzahmVar = new zzahm();
        zzahmVar.zzd(strZzc).zzf(this.zza);
        zzzv.zza(this.zzc, this.zzb, zzagwVar2, zzahmVar, this);
    }
}
