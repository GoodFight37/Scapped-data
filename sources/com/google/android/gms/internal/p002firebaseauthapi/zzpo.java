package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.SecureRandom;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzpo extends ThreadLocal<SecureRandom> {
    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ SecureRandom initialValue() {
        return zzpp.zza();
    }

    zzpo() {
    }
}
