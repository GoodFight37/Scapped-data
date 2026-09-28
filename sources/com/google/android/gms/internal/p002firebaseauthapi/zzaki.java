package com.google.android.gms.internal.p002firebaseauthapi;

import com.adjust.sdk.Constants;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaki {
    static final Charset zza;
    public static final byte[] zzb;

    public static int zza(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        int iZza = zza(length, bArr, 0, length);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static <T> T zza(T t) {
        t.getClass();
        return t;
    }

    static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static {
        Charset.forName("US-ASCII");
        zza = Charset.forName(Constants.ENCODING);
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        zzb = bArr;
        ByteBuffer.wrap(bArr);
        zzaji.zza(bArr, 0, bArr.length, false);
    }

    static boolean zza(zzaln zzalnVar) {
        if (!(zzalnVar instanceof zzaio)) {
            return false;
        }
        return false;
    }
}
