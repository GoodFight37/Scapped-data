package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.internal.zzl;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzact extends zzaeg<Void, zzl> {
    private final zzagn zzu;
    private final String zzv;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final String zza() {
        return this.zzv;
    }

    public zzact(String str, ActionCodeSettings actionCodeSettings, String str2, String str3, String str4) {
        super(4);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        zzagn zzagnVar = new zzagn(actionCodeSettings.zza());
        this.zzu = zzagnVar;
        zzagnVar.zzb(str);
        zzagnVar.zza(actionCodeSettings);
        zzagnVar.zzc(str2);
        zzagnVar.zza(str3);
        this.zzv = str4;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeg
    public final void zzb() {
        zzb(null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(TaskCompletionSource taskCompletionSource, zzado zzadoVar) {
        this.zzg = new zzaeq(this, taskCompletionSource);
        zzadoVar.zzb(this.zzu, this.zzb);
    }
}
