package com.google.firebase.auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzj implements Runnable {
    private final /* synthetic */ FirebaseAuth.IdTokenListener zza;
    private final /* synthetic */ FirebaseAuth zzb;

    zzj(FirebaseAuth firebaseAuth, FirebaseAuth.IdTokenListener idTokenListener) {
        this.zza = idTokenListener;
        this.zzb = firebaseAuth;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.onIdTokenChanged(this.zzb);
    }
}
