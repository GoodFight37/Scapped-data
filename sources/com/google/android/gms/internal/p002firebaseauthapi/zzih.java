package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzih implements zzbe {
    private static final byte[] zza = zzza.zza("7a806c");
    private static final byte[] zzb = zzza.zza("46bb91c3c5");
    private static final byte[] zzc = zzza.zza("36864200e0eaf5284d884a0e77d31646");
    private static final byte[] zzd = zzza.zza("bae8e37fc83441b16034566b");
    private static final byte[] zze = zzza.zza("af60eb711bd85bc1e4d3e0a462e074eea428a8");
    private static final ThreadLocal<Cipher> zzf = new zzik();
    private final SecretKey zzg;
    private final byte[] zzh;

    public static zzbe zza(zzdt zzdtVar) throws GeneralSecurityException {
        return new zzih(zzdtVar.zze().zza(zzbl.zza()), zzdtVar.zzd().zzb());
    }

    private static AlgorithmParameterSpec zza(byte[] bArr, int i, int i2) throws GeneralSecurityException {
        return new GCMParameterSpec(128, bArr, 0, i2);
    }

    private static Cipher zza() throws GeneralSecurityException {
        Cipher cipher = zzf.get();
        if (cipher != null) {
            return cipher;
        }
        throw new GeneralSecurityException("AES GCM SIV cipher is not available or is invalid.");
    }

    private zzih(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        this.zzh = bArr2;
        zzzi.zza(bArr.length);
        this.zzg = new SecretKeySpec(bArr, "AES");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzb(Cipher cipher) {
        try {
            byte[] bArr = zzd;
            cipher.init(2, new SecretKeySpec(zzc, "AES"), zza(bArr, 0, bArr.length));
            cipher.updateAAD(zzb);
            byte[] bArr2 = zze;
            return MessageDigest.isEqual(cipher.doFinal(bArr2, 0, bArr2.length), zza);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzh;
        if (bArr3.length == 0) {
            return zzc(bArr, bArr2);
        }
        if (!zzpy.zza(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        return zzc(Arrays.copyOfRange(bArr, this.zzh.length, bArr.length), bArr2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher cipherZza = zza();
        if (bArr.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + 28];
        byte[] bArrZza = zzpp.zza(12);
        System.arraycopy(bArrZza, 0, bArr3, 0, 12);
        cipherZza.init(1, this.zzg, zza(bArrZza, 0, bArrZza.length));
        if (bArr2 != null && bArr2.length != 0) {
            cipherZza.updateAAD(bArr2);
        }
        int iDoFinal = cipherZza.doFinal(bArr, 0, bArr.length, bArr3, 12);
        if (iDoFinal != bArr.length + 16) {
            throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", 16, Integer.valueOf(iDoFinal - bArr.length)));
        }
        byte[] bArr4 = this.zzh;
        return bArr4.length == 0 ? bArr3 : zzyc.zza(bArr4, bArr3);
    }

    private final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher cipherZza = zza();
        if (bArr.length < 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        cipherZza.init(2, this.zzg, zza(bArr, 0, 12));
        if (bArr2 != null && bArr2.length != 0) {
            cipherZza.updateAAD(bArr2);
        }
        return cipherZza.doFinal(bArr, 12, bArr.length - 12);
    }
}
