package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzaiw implements Serializable, Iterable<Byte> {
    public static final zzaiw zza = new zzajh(zzaki.zzb);
    private static final zzajd zzb = new zzajg();
    private int zzc = 0;

    static /* synthetic */ int zza(byte b) {
        return b & 255;
    }

    public abstract boolean equals(Object obj);

    public abstract byte zza(int i);

    public abstract zzaiw zza(int i, int i2);

    abstract void zza(zzaix zzaixVar) throws IOException;

    protected abstract void zza(byte[] bArr, int i, int i2, int i3);

    abstract byte zzb(int i);

    public abstract int zzb();

    protected abstract int zzb(int i, int i2, int i3);

    public abstract zzaji zzc();

    static int zza(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }

    public final int hashCode() {
        int iZzb = this.zzc;
        if (iZzb == 0) {
            int iZzb2 = zzb();
            iZzb = zzb(iZzb2, 0, iZzb2);
            if (iZzb == 0) {
                iZzb = 1;
            }
            this.zzc = iZzb;
        }
        return iZzb;
    }

    protected final int zza() {
        return this.zzc;
    }

    static zzajf zzc(int i) {
        return new zzajf(i);
    }

    public static zzaiw zza(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    public static zzaiw zza(byte[] bArr, int i, int i2) {
        zza(i, i + i2, bArr.length);
        return new zzajh(zzb.zza(bArr, i, i2));
    }

    public static zzaiw zza(String str) {
        return new zzajh(str.getBytes(zzaki.zza));
    }

    static zzaiw zzb(byte[] bArr) {
        return new zzajh(bArr);
    }

    public final String toString() {
        String strZza;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzb());
        if (zzb() <= 50) {
            strZza = zzamo.zza(this);
        } else {
            strZza = zzamo.zza(zza(0, 47)) + "...";
        }
        objArr[2] = strZza;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzaiz(this);
    }

    static {
        new zzaiy();
    }

    zzaiw() {
    }

    public final byte[] zzd() {
        int iZzb = zzb();
        if (iZzb == 0) {
            return zzaki.zzb;
        }
        byte[] bArr = new byte[iZzb];
        zza(bArr, 0, 0, iZzb);
        return bArr;
    }
}
