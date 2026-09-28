package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzagw;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzz implements com.google.firebase.auth.internal.zzau, com.google.firebase.auth.internal.zzl {
    private final /* synthetic */ FirebaseAuth zza;

    zzz(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.zzl
    public final void zza(zzagw zzagwVar, FirebaseUser firebaseUser) {
        this.zza.zza(firebaseUser, zzagwVar, true, true);
    }

    @Override // com.google.firebase.auth.internal.zzau
    public final void zza(Status status) {
        int statusCode = status.getStatusCode();
        if (statusCode == 17011 || statusCode == 17021 || statusCode == 17005) {
            this.zza.signOut();
        }
    }
}
