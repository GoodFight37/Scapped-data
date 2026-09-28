package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzxz extends ThreadLocal<Cipher> {
    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ Cipher initialValue() {
        return zza();
    }

    private static Cipher zza() {
        try {
            return zzym.zza.zza("AES/ECB/NOPADDING");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    zzxz() {
    }
}
