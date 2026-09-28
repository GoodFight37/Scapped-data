package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.PhoneAuthProvider;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaek implements zzaen {
    private final /* synthetic */ String zza;

    zzaek(zzaei zzaeiVar, String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaen
    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onCodeSent(this.zza, PhoneAuthProvider.ForceResendingToken.zza());
    }
}
