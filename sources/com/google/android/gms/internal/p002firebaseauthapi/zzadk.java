package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzu;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzadk extends zzaeg<String, zzl> {
    private final String zzu;
    private final String zzv;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final String zza() {
        return "verifyPasswordResetCode";
    }

    public zzadk(String str, String str2) {
        super(4);
        Preconditions.checkNotEmpty(str, "code cannot be null or empty");
        this.zzu = str;
        this.zzv = str2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeg
    public final void zzb() {
        if (new zzu(this.zzm).getOperation() != 0) {
            zza(new Status(FirebaseError.ERROR_INTERNAL_ERROR));
        } else {
            zzb(this.zzm.zzb());
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(TaskCompletionSource taskCompletionSource, zzado zzadoVar) {
        this.zzg = new zzaeq(this, taskCompletionSource);
        zzadoVar.zzd(this.zzu, this.zzv, this.zzb);
    }
}
