package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzl;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzadc extends zzaeg<Void, zzl> {
    private final String zzu;
    private final String zzv;
    private final String zzw;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final String zza() {
        return "unenrollMfa";
    }

    public zzadc(String str, String str2, String str3) {
        super(2);
        this.zzu = Preconditions.checkNotEmpty(str);
        this.zzv = Preconditions.checkNotEmpty(str2);
        this.zzw = str3;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeg
    public final void zzb() {
        ((zzl) this.zze).zza(this.zzj, zzabq.zza(this.zzc, this.zzk));
        zzb(null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(TaskCompletionSource taskCompletionSource, zzado zzadoVar) {
        this.zzg = new zzaeq(this, taskCompletionSource);
        zzadoVar.zza(this.zzu, this.zzv, this.zzw, this.zzb);
    }
}
