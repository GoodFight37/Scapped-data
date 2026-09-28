package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzacd extends zzaeg<zzagt, Void> {
    private final zzagu zzu;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final String zza() {
        return "getRecaptchaConfig";
    }

    public zzacd(String str, String str2) {
        super(10);
        Preconditions.checkNotEmpty(str2);
        this.zzu = zzagu.zza(str, str2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeg
    public final void zzb() {
        zzb(this.zzr);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(TaskCompletionSource taskCompletionSource, zzado zzadoVar) {
        this.zzg = new zzaeq(this, taskCompletionSource);
        zzadoVar.zza(this.zzu, this.zzb);
    }
}
