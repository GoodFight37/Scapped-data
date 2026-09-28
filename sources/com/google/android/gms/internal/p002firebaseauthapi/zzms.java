package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzms {
    static final zzms zza = new zzms(BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO);
    BigInteger zzb;
    BigInteger zzc;
    BigInteger zzd;

    zzms(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.zzb = bigInteger;
        this.zzc = bigInteger2;
        this.zzd = bigInteger3;
    }

    final boolean zza() {
        return this.zzd.equals(BigInteger.ZERO);
    }
}
