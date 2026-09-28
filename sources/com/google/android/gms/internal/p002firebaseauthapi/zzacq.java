package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.internal.zzl;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzacq extends zzaeg<Void, zzl> {
    private final zzagn zzu;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final String zza() {
        return "sendEmailVerification";
    }

    public zzacq(String str, ActionCodeSettings actionCodeSettings) {
        super(6);
        Preconditions.checkNotEmpty(str, "token cannot be null or empty");
        zzagn zzagnVar = new zzagn(4);
        this.zzu = zzagnVar;
        zzagnVar.zzd(str);
        if (actionCodeSettings != null) {
            zzagnVar.zza(actionCodeSettings);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeg
    public final void zzb() {
        zzb(null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(TaskCompletionSource taskCompletionSource, zzado zzadoVar) {
        this.zzg = new zzaeq(this, taskCompletionSource);
        zzadoVar.zza(this.zzu, this.zzb);
    }
}
