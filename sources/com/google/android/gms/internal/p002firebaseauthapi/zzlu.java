package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzlu {
    public static final byte[] zza = zza(1, 0);
    public static final byte[] zzb;
    public static final byte[] zzc;
    public static final byte[] zzd;
    public static final byte[] zze;
    public static final byte[] zzf;
    public static final byte[] zzg;
    public static final byte[] zzh;
    public static final byte[] zzi;
    public static final byte[] zzj;
    public static final byte[] zzk;
    public static final byte[] zzl;
    private static final byte[] zzm;
    private static final byte[] zzn;
    private static final byte[] zzo;

    public static int zza(zzju.zzd zzdVar) throws GeneralSecurityException {
        if (zzdVar == zzju.zzd.zzd || zzdVar == zzju.zzd.zza) {
            return 32;
        }
        if (zzdVar == zzju.zzd.zzb) {
            return 48;
        }
        if (zzdVar == zzju.zzd.zzc) {
            return 66;
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    public static int zzb(zzju.zzd zzdVar) throws GeneralSecurityException {
        if (zzdVar == zzju.zzd.zzd) {
            return 32;
        }
        if (zzdVar == zzju.zzd.zza) {
            return 65;
        }
        if (zzdVar == zzju.zzd.zzb) {
            return 97;
        }
        if (zzdVar == zzju.zzd.zzc) {
            return 133;
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    static zzyl zzc(zzju.zzd zzdVar) throws GeneralSecurityException {
        if (zzdVar == zzju.zzd.zza) {
            return zzyl.NIST_P256;
        }
        if (zzdVar == zzju.zzd.zzb) {
            return zzyl.NIST_P384;
        }
        if (zzdVar == zzju.zzd.zzc) {
            return zzyl.NIST_P521;
        }
        throw new GeneralSecurityException("Unrecognized NIST HPKE KEM identifier");
    }

    static {
        zza(1, 2);
        zzb = zza(2, 32);
        zzc = zza(2, 16);
        zzd = zza(2, 17);
        zze = zza(2, 18);
        zzf = zza(2, 1);
        zzg = zza(2, 2);
        zzh = zza(2, 3);
        zzi = zza(2, 1);
        zzj = zza(2, 2);
        zzk = zza(2, 3);
        zzl = new byte[0];
        zzm = "KEM".getBytes(zzpy.zza);
        zzn = "HPKE".getBytes(zzpy.zza);
        zzo = "HPKE-v1".getBytes(zzpy.zza);
    }

    static byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return zzyc.zza(zzn, bArr, bArr2, bArr3);
    }

    private static byte[] zza(int i, int i2) {
        if (i > 4 || i < 0) {
            throw new IllegalArgumentException("capacity must be between 0 and 4");
        }
        if (i2 < 0 || (i < 4 && i2 >= (1 << (i << 3)))) {
            throw new IllegalArgumentException("value too large");
        }
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) (i2 >> (((i - i3) - 1) * 8));
        }
        return bArr;
    }

    static byte[] zza(byte[] bArr) throws GeneralSecurityException {
        return zzyc.zza(zzm, bArr);
    }

    static byte[] zza(String str, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzyc.zza(zzo, bArr2, str.getBytes(zzpy.zza), bArr);
    }

    static byte[] zza(String str, byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        return zzyc.zza(zza(2, i), zzo, bArr2, str.getBytes(zzpy.zza), bArr);
    }
}
