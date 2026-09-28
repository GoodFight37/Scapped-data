package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneMultiFactorInfo;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzadd extends zzaeg<Void, PhoneAuthProvider.OnVerificationStateChangedCallbacks> {
    private final zzzq zzu;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final String zza() {
        return "startMfaSignInWithPhoneNumber";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeg
    public final void zzb() {
    }

    public zzadd(PhoneMultiFactorInfo phoneMultiFactorInfo, String str, String str2, long j, boolean z, boolean z2, String str3, String str4, String str5, boolean z3) {
        super(8);
        Preconditions.checkNotNull(phoneMultiFactorInfo);
        Preconditions.checkNotEmpty(str);
        this.zzu = new zzzq(phoneMultiFactorInfo, str, str2, j, z, z2, str3, str4, str5, z3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(TaskCompletionSource taskCompletionSource, zzado zzadoVar) {
        this.zzg = new zzaeq(this, taskCompletionSource);
        zzadoVar.zza(this.zzu, this.zzb);
    }
}
