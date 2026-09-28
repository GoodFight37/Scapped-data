package com.google.android.gms.internal.nearby;

import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zztb {
    final int zza;
    final int zzb;
    final int zzc;
    final int zzd;
    private final String zze;
    private final char[] zzf;
    private final byte[] zzg;
    private final boolean[] zzh;
    private final boolean zzi;

    /* JADX WARN: Illegal instructions before constructor call */
    zztb(String str, char[] cArr) {
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        for (int i = 0; i < cArr.length; i++) {
            char c = cArr[i];
            boolean z = true;
            zzsg.zze(c < 128, "Non-ASCII character: %s", c);
            if (bArr[c] != -1) {
                z = false;
            }
            zzsg.zze(z, "Duplicate character: %s", c);
            bArr[c] = (byte) i;
        }
        this(str, cArr, bArr, false);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zztb) {
            zztb zztbVar = (zztb) obj;
            boolean z = zztbVar.zzi;
            if (Arrays.equals(this.zzf, zztbVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzf) + 1237;
    }

    public final String toString() {
        return this.zze;
    }

    final char zza(int i) {
        return this.zzf[i];
    }

    final int zzb(char c) throws zzte {
        if (c > 127) {
            throw new zzte("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c))));
        }
        byte b = this.zzg[c];
        if (b != -1) {
            return b;
        }
        if (c <= ' ' || c == 127) {
            throw new zzte("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c))));
        }
        throw new zzte("Unrecognized character: " + c);
    }

    final boolean zzc(int i) {
        return this.zzh[i % this.zzc];
    }

    public final boolean zzd(char c) {
        return c < 128 && this.zzg[c] != -1;
    }

    private zztb(String str, char[] cArr, byte[] bArr, boolean z) {
        this.zze = str;
        cArr.getClass();
        this.zzf = cArr;
        try {
            int length = cArr.length;
            int iZzb = zztj.zzb(length, RoundingMode.UNNECESSARY);
            this.zzb = iZzb;
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iZzb);
            int i = 1 << (3 - iNumberOfTrailingZeros);
            this.zzc = i;
            this.zzd = iZzb >> iNumberOfTrailingZeros;
            this.zza = length - 1;
            this.zzg = bArr;
            boolean[] zArr = new boolean[i];
            for (int i2 = 0; i2 < this.zzd; i2++) {
                zArr[zztj.zza(i2 * 8, this.zzb, RoundingMode.CEILING)] = true;
            }
            this.zzh = zArr;
            this.zzi = false;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e);
        }
    }
}
