package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaca extends zzaeg<zzags, Void> {
    private final zzagp zzu;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final String zza() {
        return "getRecaptchaParam";
    }

    public zzaca() {
        super(11);
        this.zzu = zzagp.zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeg
    public final void zzb() {
        zzb(this.zzs);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(TaskCompletionSource<zzags> taskCompletionSource, zzado zzadoVar) {
        this.zzg = new zzaeq(this, taskCompletionSource);
        zzadoVar.zza(this.zzu, this.zzb);
    }
}
