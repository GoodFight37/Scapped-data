package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthCredential;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaam implements zzaew<zzaik> {
    private final /* synthetic */ zzadp zza;
    private final /* synthetic */ zzaew zzb;
    private final /* synthetic */ zzaan zzc;

    zzaam(zzaan zzaanVar, zzadp zzadpVar, zzaew zzaewVar) {
        this.zza = zzadpVar;
        this.zzb = zzaewVar;
        this.zzc = zzaanVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaet
    public final void zza(String str) {
        this.zzb.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final /* synthetic */ void zza(zzaik zzaikVar) {
        zzaik zzaikVar2 = zzaikVar;
        if (!TextUtils.isEmpty(zzaikVar2.zze())) {
            this.zza.zza(new Status(FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE), PhoneAuthCredential.zzb(zzaikVar2.zzc(), zzaikVar2.zze()));
        } else {
            this.zzc.zza.zza(new zzagw(zzaikVar2.zzd(), zzaikVar2.zzb(), Long.valueOf(zzaikVar2.zza()), "Bearer"), null, "phone", Boolean.valueOf(zzaikVar2.zzf()), null, this.zza, this.zzb);
        }
    }
}
