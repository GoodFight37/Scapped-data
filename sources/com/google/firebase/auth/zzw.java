package com.google.firebase.auth;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzw implements Runnable {
    private final /* synthetic */ FirebaseAuth zza;

    zzw(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it = this.zza.zzd.iterator();
        while (it.hasNext()) {
            ((FirebaseAuth.AuthStateListener) it.next()).onAuthStateChanged(this.zza);
        }
    }
}
