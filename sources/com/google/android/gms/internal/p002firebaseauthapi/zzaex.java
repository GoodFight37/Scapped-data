package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.PhoneAuthCredential;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaex {
    public static zzaih zza(PhoneAuthCredential phoneAuthCredential) {
        return !TextUtils.isEmpty(phoneAuthCredential.zzd()) ? zzaih.zzb(phoneAuthCredential.zzb(), phoneAuthCredential.zzd(), phoneAuthCredential.zze()) : zzaih.zza(phoneAuthCredential.zzc(), phoneAuthCredential.getSmsCode(), phoneAuthCredential.zze());
    }
}
