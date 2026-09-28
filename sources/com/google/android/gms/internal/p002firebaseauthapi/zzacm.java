package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzaf;
import com.google.firebase.auth.internal.zzl;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzacm extends zzaeg<Void, zzl> {
    private final zzzr zzu;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final String zza() {
        return "reauthenticateWithPhoneCredential";
    }

    public zzacm(PhoneAuthCredential phoneAuthCredential, String str) {
        super(2);
        Preconditions.checkNotNull(phoneAuthCredential, "credential cannot be null");
        phoneAuthCredential.zza(false);
        this.zzu = new zzzr(phoneAuthCredential, str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeg
    public final void zzb() {
        zzaf zzafVarZza = zzabq.zza(this.zzc, this.zzk);
        if (this.zzd.getUid().equalsIgnoreCase(zzafVarZza.getUid())) {
            ((zzl) this.zze).zza(this.zzj, zzafVarZza);
            zzb(null);
        } else {
            zza(new Status(FirebaseError.ERROR_USER_MISMATCH));
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(TaskCompletionSource taskCompletionSource, zzado zzadoVar) {
        this.zzg = new zzaeq(this, taskCompletionSource);
        zzadoVar.zza(this.zzu, this.zzb);
    }
}
