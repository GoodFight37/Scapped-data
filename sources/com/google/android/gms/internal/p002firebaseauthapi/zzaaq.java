package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaaq implements zzaew<zzagw> {
    final /* synthetic */ zzzv zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzadp zzc;

    zzaaq(zzzv zzzvVar, String str, zzadp zzadpVar) {
        this.zzb = str;
        this.zzc = zzadpVar;
        this.zza = zzzvVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaet
    public final void zza(String str) {
        this.zzc.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final /* synthetic */ void zza(zzagw zzagwVar) {
        zzagw zzagwVar2 = zzagwVar;
        this.zza.zza.zza(new zzagj(zzagwVar2.zzc()), new zzaat(this, this, zzagwVar2, this.zzb, this.zzc));
    }
}
