package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzao;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzabk implements zzaew<zzagw> {
    private final /* synthetic */ UserProfileChangeRequest zza;
    private final /* synthetic */ zzadp zzb;
    private final /* synthetic */ zzzv zzc;

    zzabk(zzzv zzzvVar, UserProfileChangeRequest userProfileChangeRequest, zzadp zzadpVar) {
        this.zza = userProfileChangeRequest;
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
        zzahm zzahmVar = new zzahm();
        zzahmVar.zzd(zzagwVar2.zzc());
        if (this.zza.zzb() || this.zza.getDisplayName() != null) {
            zzahmVar.zzb(this.zza.getDisplayName());
        }
        if (this.zza.zzc() || this.zza.getPhotoUri() != null) {
            zzahmVar.zzg(this.zza.zza());
        }
        zzzv.zza(this.zzc, this.zzb, zzagwVar2, zzahmVar, this);
    }
}
