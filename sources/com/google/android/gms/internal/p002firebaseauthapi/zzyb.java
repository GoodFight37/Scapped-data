package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzyb implements zzbe {
    private static final zzij.zza zza = zzij.zza.zzb;
    private final SecretKey zzb;
    private final byte[] zzc;

    public static zzbe zza(zzdm zzdmVar) throws GeneralSecurityException {
        if (zzdmVar.zzc().zzb() != 12) {
            throw new GeneralSecurityException("Expected IV Size 12, got " + zzdmVar.zzc().zzb());
        }
        if (zzdmVar.zzc().zzd() == 16) {
            return new zzyb(zzdmVar.zze().zza(zzbl.zza()), zzdmVar.zzd());
        }
        throw new GeneralSecurityException("Expected tag Size 16, got " + zzdmVar.zzc().zzd());
    }

    private zzyb(byte[] bArr, zzzn zzznVar) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.zzb = zzgl.zzb(bArr);
        this.zzc = zzznVar.zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("ciphertext is null");
        }
        int length = bArr.length;
        byte[] bArr3 = this.zzc;
        if (length < bArr3.length + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!zzpy.zza(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        AlgorithmParameterSpec algorithmParameterSpecZza = zzgl.zza(bArr, this.zzc.length, 12);
        Cipher cipherZza = zzgl.zza();
        cipherZza.init(2, this.zzb, algorithmParameterSpecZza);
        if (bArr2 != null && bArr2.length != 0) {
            cipherZza.updateAAD(bArr2);
        }
        byte[] bArr4 = this.zzc;
        return cipherZza.doFinal(bArr, bArr4.length + 12, (bArr.length - bArr4.length) - 12);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("plaintext is null");
        }
        byte[] bArrZza = zzpp.zza(12);
        AlgorithmParameterSpec algorithmParameterSpecZza = zzgl.zza(bArrZza);
        Cipher cipherZza = zzgl.zza();
        cipherZza.init(1, this.zzb, algorithmParameterSpecZza);
        if (bArr2 != null && bArr2.length != 0) {
            cipherZza.updateAAD(bArr2);
        }
        int outputSize = cipherZza.getOutputSize(bArr.length);
        byte[] bArr3 = this.zzc;
        if (outputSize > 2147483635 - bArr3.length) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr3, bArr3.length + 12 + outputSize);
        System.arraycopy(bArrZza, 0, bArrCopyOf, this.zzc.length, 12);
        if (cipherZza.doFinal(bArr, 0, bArr.length, bArrCopyOf, this.zzc.length + 12) == outputSize) {
            return bArrCopyOf;
        }
        throw new GeneralSecurityException("not enough data written");
    }
}
