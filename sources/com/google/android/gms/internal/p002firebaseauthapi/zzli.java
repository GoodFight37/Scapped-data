package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzli implements zzlp {
    private final String zza;

    final int zza() throws GeneralSecurityException {
        return Mac.getInstance(this.zza).getMacLength();
    }

    zzli(String str) {
        this.zza = str;
    }

    private final byte[] zza(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        Mac macZza = zzym.zzb.zza(this.zza);
        if (i > macZza.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        byte[] bArr3 = new byte[i];
        macZza.init(new SecretKeySpec(bArr, this.zza));
        byte[] bArrDoFinal = new byte[0];
        int i2 = 1;
        int length = 0;
        while (true) {
            macZza.update(bArrDoFinal);
            macZza.update(bArr2);
            macZza.update((byte) i2);
            bArrDoFinal = macZza.doFinal();
            if (bArrDoFinal.length + length < i) {
                System.arraycopy(bArrDoFinal, 0, bArr3, length, bArrDoFinal.length);
                length += bArrDoFinal.length;
                i2++;
            } else {
                System.arraycopy(bArrDoFinal, 0, bArr3, length, i - length);
                return bArr3;
            }
        }
    }

    private final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Mac macZza = zzym.zzb.zza(this.zza);
        if (bArr2 == null || bArr2.length == 0) {
            macZza.init(new SecretKeySpec(new byte[macZza.getMacLength()], this.zza));
        } else {
            macZza.init(new SecretKeySpec(bArr2, this.zza));
        }
        return macZza.doFinal(bArr);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, String str2, byte[] bArr4, int i) throws GeneralSecurityException {
        return zza(zza(zzlu.zza(str, bArr2, bArr4), null), zzlu.zza(str2, bArr3, bArr4, i), i);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlp
    public final byte[] zzb() throws GeneralSecurityException {
        String str = this.zza;
        str.hashCode();
        switch (str) {
            case "HmacSha256":
                return zzlu.zzf;
            case "HmacSha384":
                return zzlu.zzg;
            case "HmacSha512":
                return zzlu.zzh;
            default:
                throw new GeneralSecurityException("Could not determine HPKE KDF ID");
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlp
    public final byte[] zza(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, int i) throws GeneralSecurityException {
        return zza(bArr, zzlu.zza(str, bArr2, bArr3, i), i);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlp
    public final byte[] zza(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) throws GeneralSecurityException {
        return zza(zzlu.zza(str, bArr2, bArr3), bArr);
    }
}
