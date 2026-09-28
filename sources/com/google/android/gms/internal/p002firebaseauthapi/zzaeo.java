package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaeo implements Runnable {
    private final /* synthetic */ zzaen zza;
    private final /* synthetic */ zzaei zzb;

    zzaeo(zzaei zzaeiVar, zzaen zzaenVar) {
        this.zza = zzaenVar;
        this.zzb = zzaeiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb.zza.zzh) {
            if (!this.zzb.zza.zzh.isEmpty()) {
                this.zza.zza(this.zzb.zza.zzh.get(0), new Object[0]);
            }
        }
    }
}
