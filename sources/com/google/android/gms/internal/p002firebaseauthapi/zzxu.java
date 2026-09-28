package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzxu implements zzzd {
    private static final zzij.zza zza = zzij.zza.zzb;
    private static final ThreadLocal<Cipher> zzb = new zzxx();
    private final SecretKeySpec zzc;
    private final int zzd;
    private final int zze;

    public zzxu(byte[] bArr, int i) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzzi.zza(bArr.length);
        this.zzc = new SecretKeySpec(bArr, "AES");
        int blockSize = zzb.get().getBlockSize();
        this.zze = blockSize;
        if (i < 12 || i > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.zzd = i;
    }

    private final void zza(byte[] bArr, int i, int i2, byte[] bArr2, int i3, byte[] bArr3, boolean z) throws GeneralSecurityException {
        Cipher cipher = zzb.get();
        byte[] bArr4 = new byte[this.zze];
        System.arraycopy(bArr3, 0, bArr4, 0, this.zzd);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
        if (z) {
            cipher.init(1, this.zzc, ivParameterSpec);
        } else {
            cipher.init(2, this.zzc, ivParameterSpec);
        }
        if (cipher.doFinal(bArr, i, i2, bArr2, i3) != i2) {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzzd
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzd;
        if (length < i) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        int length2 = bArr.length;
        int i2 = this.zzd;
        byte[] bArr3 = new byte[length2 - i2];
        zza(bArr, i2, bArr.length - i2, bArr3, 0, bArr2, false);
        return bArr3;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzzd
    public final byte[] zzb(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzd;
        if (length > Integer.MAX_VALUE - i) {
            throw new GeneralSecurityException("plaintext length can not exceed " + (Integer.MAX_VALUE - this.zzd));
        }
        byte[] bArr2 = new byte[bArr.length + i];
        byte[] bArrZza = zzpp.zza(i);
        System.arraycopy(bArrZza, 0, bArr2, 0, this.zzd);
        zza(bArr, 0, bArr.length, bArr2, this.zzd, bArrZza, true);
        return bArr2;
    }
}
