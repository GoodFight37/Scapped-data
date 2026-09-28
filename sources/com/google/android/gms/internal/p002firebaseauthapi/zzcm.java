package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcm {
    private static final zzcm zza = new zzcm();

    static zzcm zza() {
        return zza;
    }

    public static zzcm zza(@Nullable zzcm zzcmVar) throws GeneralSecurityException {
        if (zzcmVar != null) {
            return zzcmVar;
        }
        throw new GeneralSecurityException("SecretKeyAccess is required");
    }

    private zzcm() {
    }
}
