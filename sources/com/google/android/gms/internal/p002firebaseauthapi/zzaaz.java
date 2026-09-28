package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaaz implements zzaew<zzafz> {
    private final /* synthetic */ zzadp zza;
    private final /* synthetic */ zzaaw zzb;

    zzaaz(zzaaw zzaawVar, zzadp zzadpVar) {
        this.zza = zzadpVar;
        this.zzb = zzaawVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaet
    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final /* synthetic */ void zza(zzafz zzafzVar) {
        zzafz zzafzVar2 = zzafzVar;
        this.zzb.zza.zza(new zzagw(zzafzVar2.zzb(), zzafzVar2.zza(), Long.valueOf(zzagy.zza(zzafzVar2.zza())), "Bearer"), null, null, false, null, this.zza, this);
    }
}
