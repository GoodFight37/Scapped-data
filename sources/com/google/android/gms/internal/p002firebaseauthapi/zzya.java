package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzya implements zzbk {
    private static final zzij.zza zza = zzij.zza.zza;
    private static final Collection<Integer> zzb = Arrays.asList(64);
    private static final byte[] zzc = new byte[16];
    private static final ThreadLocal<Cipher> zzd = new zzyd();
    private final zzzc zze;
    private final byte[] zzf;
    private final byte[] zzg;

    public static zzbk zza(zzio zzioVar) throws GeneralSecurityException {
        return new zzya(zzioVar.zze().zza(zzbl.zza()), zzioVar.zzd());
    }

    private zzya(byte[] bArr, zzzn zzznVar) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
        }
        if (!zzb.contains(Integer.valueOf(bArr.length))) {
            throw new InvalidKeyException("invalid key size: " + bArr.length + " bytes; key must have 64 bytes");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
        this.zzf = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
        this.zze = new zzzc(bArrCopyOfRange);
        this.zzg = zzznVar.zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbk
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArrZza;
        int length = bArr.length;
        byte[] bArr3 = this.zzg;
        if (length < bArr3.length + 16) {
            throw new GeneralSecurityException("Ciphertext too short.");
        }
        if (!zzpy.zza(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        Cipher cipher = zzd.get();
        byte[] bArr4 = this.zzg;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, bArr4.length, bArr4.length + 16);
        byte[] bArr5 = (byte[]) bArrCopyOfRange.clone();
        bArr5[8] = (byte) (bArr5[8] & 127);
        bArr5[12] = (byte) (bArr5[12] & 127);
        cipher.init(2, new SecretKeySpec(this.zzf, "AES"), new IvParameterSpec(bArr5));
        int length2 = this.zzg.length + 16;
        int length3 = bArr.length - length2;
        byte[] bArrDoFinal = cipher.doFinal(bArr, length2, length3);
        if (length3 == 0 && bArrDoFinal == null && zzzj.zza()) {
            bArrDoFinal = new byte[0];
        }
        byte[][] bArr6 = {bArr2, bArrDoFinal};
        byte[] bArrZza2 = this.zze.zza(zzc, 16);
        for (int i = 0; i <= 0; i++) {
            byte[] bArr7 = bArr6[i];
            if (bArr7 == null) {
                bArr7 = new byte[0];
            }
            bArrZza2 = zzyc.zza(zzrn.zzb(bArrZza2), this.zze.zza(bArr7, 16));
        }
        byte[] bArr8 = bArr6[1];
        if (bArr8.length >= 16) {
            if (bArr8.length < bArrZza2.length) {
                throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
            }
            int length4 = bArr8.length - bArrZza2.length;
            bArrZza = Arrays.copyOf(bArr8, bArr8.length);
            for (int i2 = 0; i2 < bArrZza2.length; i2++) {
                int i3 = length4 + i2;
                bArrZza[i3] = (byte) (bArrZza[i3] ^ bArrZza2[i2]);
            }
        } else {
            bArrZza = zzyc.zza(zzrn.zza(bArr8), zzrn.zzb(bArrZza2));
        }
        if (MessageDigest.isEqual(bArrCopyOfRange, this.zze.zza(bArrZza, 16))) {
            return bArrDoFinal;
        }
        throw new AEADBadTagException("Integrity check failed.");
    }
}
