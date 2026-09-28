package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzacr extends zzaeg<Void, Void> {
    private final zzahf zzu;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final String zza() {
        return "revokeAccessToken";
    }

    public zzacr(String str, String str2, String str3, String str4) {
        super(15);
        this.zzu = zzahf.zzg().zzd(str).zza(str2).zzc(str4).zzb(str3).zza(zzagh.ACCESS_TOKEN).zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeg
    public final void zzb() {
        zzb(null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(TaskCompletionSource<Void> taskCompletionSource, zzado zzadoVar) {
        this.zzg = new zzaeq(this, taskCompletionSource);
        zzadoVar.zza(this.zzu, this.zzb);
    }
}
