package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzl;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzadh extends zzaeg<Void, zzl> {
    private final String zzu;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final String zza() {
        return "updateEmail";
    }

    public zzadh(String str) {
        super(2);
        this.zzu = Preconditions.checkNotEmpty(str, "email cannot be null or empty");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeg
    public final void zzb() {
        ((zzl) this.zze).zza(this.zzj, zzabq.zza(this.zzc, this.zzk));
        zzb(null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(TaskCompletionSource taskCompletionSource, zzado zzadoVar) {
        this.zzg = new zzaeq(this, taskCompletionSource);
        zzadoVar.zzb(this.zzd.zze(), this.zzu, this.zzb);
    }
}
