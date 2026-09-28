package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth.zza;
import com.google.firebase.auth.internal.zzbo;
import com.google.firebase.auth.internal.zzcc;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzm extends zzbo<AuthResult> {
    private final /* synthetic */ FirebaseUser zza;
    private final /* synthetic */ EmailAuthCredential zzb;
    private final /* synthetic */ FirebaseAuth zzc;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.firebase.auth.FirebaseAuth$zza, com.google.firebase.auth.internal.zzcc] */
    @Override // com.google.firebase.auth.internal.zzbo
    public final Task<AuthResult> zza(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.i("FirebaseAuth", "Linking email account with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for linking email account");
        }
        return this.zzc.zze.zza(this.zzc.zza, this.zza, (AuthCredential) this.zzb, str, (zzcc) this.zzc.new zza());
    }

    zzm(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential) {
        this.zza = firebaseUser;
        this.zzb = emailAuthCredential;
        this.zzc = firebaseAuth;
    }
}
