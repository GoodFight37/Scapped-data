package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzl;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzadj extends zzaeg<Void, zzl> {
    private final PhoneAuthCredential zzu;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final String zza() {
        return "updatePhoneNumber";
    }

    public zzadj(PhoneAuthCredential phoneAuthCredential) {
        super(2);
        this.zzu = (PhoneAuthCredential) Preconditions.checkNotNull(phoneAuthCredential);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeg
    public final void zzb() {
        ((zzl) this.zze).zza(this.zzj, zzabq.zza(this.zzc, this.zzk));
        zzb(null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(TaskCompletionSource taskCompletionSource, zzado zzadoVar) {
        this.zzg = new zzaeq(this, taskCompletionSource);
        zzadoVar.zza(new zzaha(this.zzd.zze(), zzaex.zza(this.zzu)), this.zzb);
    }
}
