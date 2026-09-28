package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzkx implements zzll {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzll
    public final int zza() {
        return 32;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzll
    public final int zzb() {
        return 12;
    }

    zzkx() {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzll
    public final byte[] zzc() {
        return zzlu.zzk;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzll
    public final byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4) throws GeneralSecurityException {
        if (bArr.length != 32) {
            throw new InvalidAlgorithmParameterException("Unexpected key length: 32");
        }
        if (zzhn.zza()) {
            return zzhn.zza(bArr).zza(bArr2, bArr3, i, bArr4);
        }
        return new zzhl(bArr).zza(bArr2, Arrays.copyOfRange(bArr3, i, bArr3.length), bArr4);
    }
}
