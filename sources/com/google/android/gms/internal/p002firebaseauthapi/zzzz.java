package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzao;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzzz implements zzaew<zzagw> {
    private final /* synthetic */ EmailAuthCredential zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzadp zzc;
    private final /* synthetic */ zzzv zzd;

    zzzz(zzzv zzzvVar, EmailAuthCredential emailAuthCredential, String str, zzadp zzadpVar) {
        this.zza = emailAuthCredential;
        this.zzb = str;
        this.zzc = zzadpVar;
        this.zzd = zzzvVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaet
    public final void zza(String str) {
        this.zzc.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final /* synthetic */ void zza(zzagw zzagwVar) {
        this.zzd.zza(new zzafy(this.zza, zzagwVar.zzc(), this.zzb), this.zzc);
    }
}
