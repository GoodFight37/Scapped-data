package com.google.firebase.auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzs implements Runnable {
    private final /* synthetic */ FirebaseAuth.AuthStateListener zza;
    private final /* synthetic */ FirebaseAuth zzb;

    zzs(FirebaseAuth firebaseAuth, FirebaseAuth.AuthStateListener authStateListener) {
        this.zza = authStateListener;
        this.zzb = firebaseAuth;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.onAuthStateChanged(this.zzb);
    }
}
