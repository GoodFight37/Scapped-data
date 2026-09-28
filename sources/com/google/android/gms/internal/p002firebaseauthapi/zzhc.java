package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzhc extends ThreadLocal<Cipher> {
    @Override // java.lang.ThreadLocal
    @Nullable
    protected final /* synthetic */ Cipher initialValue() {
        return zza();
    }

    @Nullable
    private static Cipher zza() {
        try {
            Cipher cipherZza = zzym.zza.zza("ChaCha20-Poly1305");
            if (zzgz.zzb(cipherZza)) {
                return cipherZza;
            }
            return null;
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    zzhc() {
    }
}
