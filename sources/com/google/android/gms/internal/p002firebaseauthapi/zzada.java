package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzam;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzada extends zzaeg<zzahs, Void> {
    private final zzahv zzu;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final String zza() {
        return "startMfaEnrollment";
    }

    public zzada(zzam zzamVar, String str) {
        super(12);
        Preconditions.checkNotNull(zzamVar);
        this.zzu = zzahv.zza(Preconditions.checkNotEmpty(zzamVar.zzb()), str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeg
    public final void zzb() {
        zzb(this.zzt);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(TaskCompletionSource taskCompletionSource, zzado zzadoVar) {
        this.zzg = new zzaeq(this, taskCompletionSource);
        zzadoVar.zza(this.zzu, this.zzb);
    }
}
