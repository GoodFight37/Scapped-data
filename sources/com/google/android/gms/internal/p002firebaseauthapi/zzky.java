package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzky implements zzla {
    private final int zza;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzla
    public final int zza() {
        return this.zza;
    }

    public zzky(zzdr zzdrVar) throws GeneralSecurityException {
        if (zzdrVar.zzb() != 12) {
            throw new GeneralSecurityException("invalid IV size");
        }
        if (zzdrVar.zzd() != 16) {
            throw new GeneralSecurityException("invalid tag size");
        }
        if (zzdrVar.zzf() != zzdr.zza.zzc) {
            throw new GeneralSecurityException("invalid variant");
        }
        this.zza = zzdrVar.zzc();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzla
    public final byte[] zza(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        if (bArr2.length < i) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (bArr.length != this.zza) {
            throw new GeneralSecurityException("invalid key size");
        }
        SecretKey secretKeyZzb = zzgl.zzb(bArr);
        int i2 = i + 12;
        if (bArr2.length < i + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        AlgorithmParameterSpec algorithmParameterSpecZza = zzgl.zza(bArr2, i, 12);
        Cipher cipherZza = zzgl.zza();
        cipherZza.init(2, secretKeyZzb, algorithmParameterSpecZza);
        return cipherZza.doFinal(bArr2, i2, (bArr2.length - i) - 12);
    }
}
