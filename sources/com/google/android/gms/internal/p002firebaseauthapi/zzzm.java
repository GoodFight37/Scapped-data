package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzzm {
    private final BigInteger zza;

    public static zzzm zza(BigInteger bigInteger, zzcm zzcmVar) {
        if (zzcmVar != null) {
            return new zzzm(bigInteger);
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    public final BigInteger zza(zzcm zzcmVar) {
        if (zzcmVar == null) {
            throw new NullPointerException("SecretKeyAccess required");
        }
        return this.zza;
    }

    private zzzm(BigInteger bigInteger) {
        this.zza = bigInteger;
    }
}
