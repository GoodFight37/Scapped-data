package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzaf;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzz;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzace extends zzaeg<AuthResult, zzl> {
    private final PhoneAuthCredential zzu;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final String zza() {
        return "linkPhoneAuthCredential";
    }

    public zzace(PhoneAuthCredential phoneAuthCredential) {
        super(2);
        Preconditions.checkNotNull(phoneAuthCredential, "credential cannot be null");
        this.zzu = phoneAuthCredential;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeg
    public final void zzb() {
        zzaf zzafVarZza = zzabq.zza(this.zzc, this.zzk);
        ((zzl) this.zze).zza(this.zzj, zzafVarZza);
        zzb(new zzz(zzafVarZza));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(TaskCompletionSource taskCompletionSource, zzado zzadoVar) {
        this.zzg = new zzaeq(this, taskCompletionSource);
        zzadoVar.zza(new zzaha(this.zzd.zze(), zzaex.zza(this.zzu)), this.zzb);
    }
}
