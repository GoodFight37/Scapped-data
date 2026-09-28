package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.common.base.Ascii;
import java.io.IOException;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzais {
    private static volatile int zza = 100;

    static double zza(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzd(bArr, i));
    }

    static float zzb(byte[] bArr, int i) {
        return Float.intBitsToFloat(zzc(bArr, i));
    }

    static int zza(byte[] bArr, int i, zzaiv zzaivVar) throws zzakm {
        int iZzc = zzc(bArr, i, zzaivVar);
        int i2 = zzaivVar.zza;
        if (i2 < 0) {
            throw zzakm.zzf();
        }
        if (i2 > bArr.length - iZzc) {
            throw zzakm.zzj();
        }
        if (i2 == 0) {
            zzaivVar.zzc = zzaiw.zza;
            return iZzc;
        }
        zzaivVar.zzc = zzaiw.zza(bArr, iZzc, i2);
        return iZzc + i2;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, Object obj, zzaln zzalnVar, zzamv<zzamy, zzamy> zzamvVar, zzaiv zzaivVar) throws IOException {
        if (zzaivVar.zzd.zza(zzalnVar, i >>> 3) == null) {
            return zza(i, bArr, i2, i3, zzalr.zzc(obj), zzaivVar);
        }
        zzakg.zzd zzdVar = (zzakg.zzd) obj;
        zzdVar.zza();
        zzajy<zzakg.zzc> zzajyVar = zzdVar.zzc;
        throw new NoSuchMethodError();
    }

    static int zzc(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private static <T> int zza(zzamc<T> zzamcVar, byte[] bArr, int i, int i2, int i3, zzaiv zzaivVar) throws IOException {
        T tZza = zzamcVar.zza();
        int iZza = zza(tZza, zzamcVar, bArr, i, i2, i3, zzaivVar);
        zzamcVar.zzd(tZza);
        zzaivVar.zzc = tZza;
        return iZza;
    }

    static int zza(zzamc<?> zzamcVar, int i, byte[] bArr, int i2, int i3, zzakn<Object> zzaknVar, zzaiv zzaivVar) throws IOException {
        int i4 = (i & (-8)) | 4;
        int iZza = zza(zzamcVar, bArr, i2, i3, i4, zzaivVar);
        zzaknVar.add(zzaivVar.zzc);
        while (iZza < i3) {
            int iZzc = zzc(bArr, iZza, zzaivVar);
            if (i != zzaivVar.zza) {
                break;
            }
            iZza = zza(zzamcVar, bArr, iZzc, i3, i4, zzaivVar);
            zzaknVar.add(zzaivVar.zzc);
        }
        return iZza;
    }

    static <T> int zza(zzamc<T> zzamcVar, byte[] bArr, int i, int i2, zzaiv zzaivVar) throws IOException {
        T tZza = zzamcVar.zza();
        int iZza = zza(tZza, zzamcVar, bArr, i, i2, zzaivVar);
        zzamcVar.zzd(tZza);
        zzaivVar.zzc = tZza;
        return iZza;
    }

    static int zzb(zzamc<?> zzamcVar, int i, byte[] bArr, int i2, int i3, zzakn<?> zzaknVar, zzaiv zzaivVar) throws IOException {
        int iZza = zza(zzamcVar, bArr, i2, i3, zzaivVar);
        zzaknVar.add(zzaivVar.zzc);
        while (iZza < i3) {
            int iZzc = zzc(bArr, iZza, zzaivVar);
            if (i != zzaivVar.zza) {
                break;
            }
            iZza = zza(zzamcVar, bArr, iZzc, i3, zzaivVar);
            zzaknVar.add(zzaivVar.zzc);
        }
        return iZza;
    }

    static int zza(byte[] bArr, int i, zzakn<?> zzaknVar, zzaiv zzaivVar) throws IOException {
        zzakj zzakjVar = (zzakj) zzaknVar;
        int iZzc = zzc(bArr, i, zzaivVar);
        int i2 = zzaivVar.zza + iZzc;
        while (iZzc < i2) {
            iZzc = zzc(bArr, iZzc, zzaivVar);
            zzakjVar.zzc(zzaivVar.zza);
        }
        if (iZzc == i2) {
            return iZzc;
        }
        throw zzakm.zzj();
    }

    static int zzb(byte[] bArr, int i, zzaiv zzaivVar) throws zzakm {
        int iZzc = zzc(bArr, i, zzaivVar);
        int i2 = zzaivVar.zza;
        if (i2 < 0) {
            throw zzakm.zzf();
        }
        if (i2 == 0) {
            zzaivVar.zzc = "";
            return iZzc;
        }
        zzaivVar.zzc = zzanb.zzb(bArr, iZzc, i2);
        return iZzc + i2;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzamy zzamyVar, zzaiv zzaivVar) throws zzakm {
        if ((i >>> 3) == 0) {
            throw zzakm.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzd = zzd(bArr, i2, zzaivVar);
            zzamyVar.zza(i, Long.valueOf(zzaivVar.zzb));
            return iZzd;
        }
        if (i4 == 1) {
            zzamyVar.zza(i, Long.valueOf(zzd(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzc = zzc(bArr, i2, zzaivVar);
            int i5 = zzaivVar.zza;
            if (i5 < 0) {
                throw zzakm.zzf();
            }
            if (i5 > bArr.length - iZzc) {
                throw zzakm.zzj();
            }
            if (i5 == 0) {
                zzamyVar.zza(i, zzaiw.zza);
            } else {
                zzamyVar.zza(i, zzaiw.zza(bArr, iZzc, i5));
            }
            return iZzc + i5;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                zzamyVar.zza(i, Integer.valueOf(zzc(bArr, i2)));
                return i2 + 4;
            }
            throw zzakm.zzc();
        }
        zzamy zzamyVarZzd = zzamy.zzd();
        int i6 = (i & (-8)) | 4;
        zzaivVar.zze++;
        zza(zzaivVar.zze);
        int i7 = 0;
        while (i2 < i3) {
            int iZzc2 = zzc(bArr, i2, zzaivVar);
            int i8 = zzaivVar.zza;
            i7 = i8;
            if (i8 == i6) {
                i2 = iZzc2;
                break;
            }
            int iZza = zza(i7, bArr, iZzc2, i3, zzamyVarZzd, zzaivVar);
            i7 = i8;
            i2 = iZza;
        }
        zzaivVar.zze--;
        if (i2 > i3 || i7 != i6) {
            throw zzakm.zzg();
        }
        zzamyVar.zza(i, zzamyVarZzd);
        return i2;
    }

    static int zzc(byte[] bArr, int i, zzaiv zzaivVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            zzaivVar.zza = b;
            return i2;
        }
        return zza(b, bArr, i2, zzaivVar);
    }

    static int zza(int i, byte[] bArr, int i2, zzaiv zzaivVar) {
        int i3 = i & WorkQueueKt.MASK;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzaivVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzaivVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzaivVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzaivVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzaivVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzakn<?> zzaknVar, zzaiv zzaivVar) {
        zzakj zzakjVar = (zzakj) zzaknVar;
        int iZzc = zzc(bArr, i2, zzaivVar);
        zzakjVar.zzc(zzaivVar.zza);
        while (iZzc < i3) {
            int iZzc2 = zzc(bArr, iZzc, zzaivVar);
            if (i != zzaivVar.zza) {
                break;
            }
            iZzc = zzc(bArr, iZzc2, zzaivVar);
            zzakjVar.zzc(zzaivVar.zza);
        }
        return iZzc;
    }

    static int zzd(byte[] bArr, int i, zzaiv zzaivVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzaivVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & 127)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & 127)) << i4;
            b = b2;
            i3 = i5;
        }
        zzaivVar.zzb = j2;
        return i3;
    }

    static <T> int zza(Object obj, zzamc<T> zzamcVar, byte[] bArr, int i, int i2, int i3, zzaiv zzaivVar) throws IOException {
        zzaivVar.zze++;
        zza(zzaivVar.zze);
        int iZza = ((zzalr) zzamcVar).zza(obj, bArr, i, i2, i3, zzaivVar);
        zzaivVar.zze--;
        zzaivVar.zzc = obj;
        return iZza;
    }

    static <T> int zza(Object obj, zzamc<T> zzamcVar, byte[] bArr, int i, int i2, zzaiv zzaivVar) throws IOException {
        int iZza = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZza = zza(i3, bArr, iZza, zzaivVar);
            i3 = zzaivVar.zza;
        }
        int i4 = iZza;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzakm.zzj();
        }
        zzaivVar.zze++;
        zza(zzaivVar.zze);
        int i5 = i3 + i4;
        zzamcVar.zza(obj, bArr, i4, i5, zzaivVar);
        zzaivVar.zze--;
        zzaivVar.zzc = obj;
        return i5;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzaiv zzaivVar) throws zzakm {
        if ((i >>> 3) == 0) {
            throw zzakm.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzd(bArr, i2, zzaivVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zzc(bArr, i2, zzaivVar) + zzaivVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzakm.zzc();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zzc(bArr, i2, zzaivVar);
            i6 = zzaivVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zza(i6, bArr, i2, i3, zzaivVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzakm.zzg();
        }
        return i2;
    }

    static long zzd(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private static void zza(int i) throws zzakm {
        if (i >= zza) {
            throw zzakm.zzh();
        }
    }
}
