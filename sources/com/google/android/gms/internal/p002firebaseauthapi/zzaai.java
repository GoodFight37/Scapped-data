package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaai implements zzaew<zzaik> {
    private final /* synthetic */ zzadp zza;
    private final /* synthetic */ zzzv zzb;

    zzaai(zzzv zzzvVar, zzadp zzadpVar) {
        this.zza = zzadpVar;
        this.zzb = zzzvVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaet
    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final /* synthetic */ void zza(zzaik zzaikVar) {
        zzaik zzaikVar2 = zzaikVar;
        this.zzb.zza(new zzagw(zzaikVar2.zzd(), zzaikVar2.zzb(), Long.valueOf(zzaikVar2.zza()), "Bearer"), null, null, Boolean.valueOf(zzaikVar2.zzf()), null, this.zza, this);
    }
}
