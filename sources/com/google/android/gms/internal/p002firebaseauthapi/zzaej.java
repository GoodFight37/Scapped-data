package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaej implements zzaen {
    private final /* synthetic */ PhoneAuthCredential zza;

    zzaej(zzaei zzaeiVar, PhoneAuthCredential phoneAuthCredential) {
        this.zza = phoneAuthCredential;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaen
    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onVerificationCompleted(this.zza);
    }
}
