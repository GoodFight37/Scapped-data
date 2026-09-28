package com.google.android.gms.internal.p002firebaseauthapi;

import com.fasterxml.jackson.core.base.GeneratorBase;
import com.google.common.base.Ascii;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzand {
    private static boolean zza(byte b) {
        return b > -65;
    }

    static /* synthetic */ void zza(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws zzakm {
        if (zza(b2) || (((b << Ascii.FS) + (b2 + 112)) >> 30) != 0 || zza(b3) || zza(b4)) {
            throw zzakm.zzd();
        }
        int i2 = ((b & 7) << 18) | ((b2 & 63) << 12) | ((b3 & 63) << 6) | (b4 & 63);
        cArr[i] = (char) ((i2 >>> 10) + 55232);
        cArr[i + 1] = (char) ((i2 & 1023) + GeneratorBase.SURR2_FIRST);
    }

    static /* synthetic */ void zza(byte b, char[] cArr, int i) {
        cArr[i] = (char) b;
    }

    static /* synthetic */ void zza(byte b, byte b2, byte b3, char[] cArr, int i) throws zzakm {
        if (zza(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || zza(b3)))) {
            throw zzakm.zzd();
        }
        cArr[i] = (char) (((b & Ascii.SI) << 12) | ((b2 & 63) << 6) | (b3 & 63));
    }

    static /* synthetic */ void zza(byte b, byte b2, char[] cArr, int i) throws zzakm {
        if (b < -62 || zza(b2)) {
            throw zzakm.zzd();
        }
        cArr[i] = (char) (((b & Ascii.US) << 6) | (b2 & 63));
    }
}
