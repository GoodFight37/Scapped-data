package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzzn {
    private final byte[] zza;

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final int zza() {
        return this.zza.length;
    }

    public static zzzn zza(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("data must be non-null");
        }
        int length = bArr.length;
        if (bArr == null) {
            throw new NullPointerException("data must be non-null");
        }
        if (length > bArr.length) {
            length = bArr.length;
        }
        return new zzzn(bArr, 0, length);
    }

    public final String toString() {
        return "Bytes(" + zzza.zza(this.zza) + ")";
    }

    private zzzn(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.zza = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i2);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzzn) {
            return Arrays.equals(((zzzn) obj).zza, this.zza);
        }
        return false;
    }

    public final byte[] zzb() {
        byte[] bArr = this.zza;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}
