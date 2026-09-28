package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.nearby.uwb.RangingPosition;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzajo extends zzaix {
    private static final Logger zzb = Logger.getLogger(zzajo.class.getName());
    private static final boolean zzc = zzana.zzc();
    zzajq zza;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    private static class zza extends zzajo {
        private final byte[] zzb;
        private final int zzc;
        private int zzd;

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final int zza() {
            return this.zzc - this.zzd;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzc() {
        }

        zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if (((bArr.length - i2) | i2) < 0) {
                throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
            }
            this.zzb = bArr;
            this.zzd = 0;
            this.zzc = i2;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zza(byte b) throws IOException {
            int i = this.zzd;
            try {
                int i2 = i + 1;
                try {
                    this.zzb[i] = b;
                    this.zzd = i2;
                } catch (IndexOutOfBoundsException e) {
                    e = e;
                    i = i2;
                    throw new zzd(i, this.zzc, 1, (Throwable) e);
                }
            } catch (IndexOutOfBoundsException e2) {
                e = e2;
            }
        }

        private final void zzc(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.zzb, this.zzd, i2);
                this.zzd += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(this.zzd, this.zzc, i2, (Throwable) e);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzb(int i, boolean z) throws IOException {
            zzj(i, 0);
            zza(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            zzl(i2);
            zzc(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzc(int i, zzaiw zzaiwVar) throws IOException {
            zzj(i, 2);
            zzb(zzaiwVar);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzb(zzaiw zzaiwVar) throws IOException {
            zzl(zzaiwVar.zzb());
            zzaiwVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzg(int i, int i2) throws IOException {
            zzj(i, 5);
            zzi(i2);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzi(int i) throws IOException {
            int i2 = this.zzd;
            try {
                byte[] bArr = this.zzb;
                bArr[i2] = (byte) i;
                bArr[i2 + 1] = (byte) (i >> 8);
                bArr[i2 + 2] = (byte) (i >> 16);
                bArr[i2 + 3] = i >> Ascii.CAN;
                this.zzd = i2 + 4;
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(i2, this.zzc, 4, (Throwable) e);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzf(int i, long j) throws IOException {
            zzj(i, 1);
            zzf(j);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzf(long j) throws IOException {
            int i = this.zzd;
            try {
                byte[] bArr = this.zzb;
                bArr[i] = (byte) j;
                bArr[i + 1] = (byte) (j >> 8);
                bArr[i + 2] = (byte) (j >> 16);
                bArr[i + 3] = (byte) (j >> 24);
                bArr[i + 4] = (byte) (j >> 32);
                bArr[i + 5] = (byte) (j >> 40);
                bArr[i + 6] = (byte) (j >> 48);
                bArr[i + 7] = (byte) (j >> 56);
                this.zzd = i + 8;
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(i, this.zzc, 8, (Throwable) e);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzh(int i, int i2) throws IOException {
            zzj(i, 0);
            zzj(i2);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzj(int i) throws IOException {
            if (i >= 0) {
                zzl(i);
            } else {
                zzh(i);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaix
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            zzc(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        final void zzc(int i, zzaln zzalnVar, zzamc zzamcVar) throws IOException {
            zzj(i, 2);
            zzl(((zzain) zzalnVar).zza(zzamcVar));
            zzamcVar.zza(zzalnVar, this.zza);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzc(zzaln zzalnVar) throws IOException {
            zzl(zzalnVar.zzl());
            zzalnVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        final void zzb(zzaln zzalnVar, zzamc zzamcVar) throws IOException {
            zzl(((zzain) zzalnVar).zza(zzamcVar));
            zzamcVar.zza(zzalnVar, this.zza);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzb(int i, zzaln zzalnVar) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzj(3, 2);
            zzc(zzalnVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzd(int i, zzaiw zzaiwVar) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzc(3, zzaiwVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzb(int i, String str) throws IOException {
            zzj(i, 2);
            zzb(str);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzb(String str) throws IOException {
            int i = this.zzd;
            try {
                int iZzh = zzh(str.length() * 3);
                int iZzh2 = zzh(str.length());
                if (iZzh2 == iZzh) {
                    int i2 = i + iZzh2;
                    this.zzd = i2;
                    int iZza = zzanb.zza(str, this.zzb, i2, zza());
                    this.zzd = i;
                    zzl((iZza - i) - iZzh2);
                    this.zzd = iZza;
                    return;
                }
                zzl(zzanb.zza(str));
                this.zzd = zzanb.zza(str, this.zzb, this.zzd, zza());
            } catch (zzane e) {
                this.zzd = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzd(e2);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzj(int i, int i2) throws IOException {
            zzl((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzk(int i, int i2) throws IOException {
            zzj(i, 0);
            zzl(i2);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzl(int i) throws IOException {
            int i2;
            int i3 = this.zzd;
            while ((i & RangingPosition.RSSI_UNKNOWN) != 0) {
                try {
                    i2 = i3 + 1;
                    try {
                        this.zzb[i3] = (byte) (i | 128);
                        i >>>= 7;
                        i3 = i2;
                    } catch (IndexOutOfBoundsException e) {
                        e = e;
                        i3 = i2;
                        throw new zzd(i3, this.zzc, 1, (Throwable) e);
                    }
                } catch (IndexOutOfBoundsException e2) {
                    e = e2;
                    throw new zzd(i3, this.zzc, 1, (Throwable) e);
                }
            }
            i2 = i3 + 1;
            this.zzb[i3] = (byte) i;
            this.zzd = i2;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzh(int i, long j) throws IOException {
            zzj(i, 0);
            zzh(j);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzh(long j) throws IOException {
            int i;
            int i2 = this.zzd;
            if (zzajo.zzc && zza() >= 10) {
                while ((j & (-128)) != 0) {
                    zzana.zza(this.zzb, i2, (byte) (((int) j) | 128));
                    j >>>= 7;
                    i2++;
                }
                i = i2 + 1;
                zzana.zza(this.zzb, i2, (byte) j);
            } else {
                while ((j & (-128)) != 0) {
                    try {
                        int i3 = i2 + 1;
                        try {
                            this.zzb[i2] = (byte) (((int) j) | 128);
                            j >>>= 7;
                            i2 = i3;
                        } catch (IndexOutOfBoundsException e) {
                            e = e;
                            i2 = i3;
                            throw new zzd(i2, this.zzc, 1, (Throwable) e);
                        }
                    } catch (IndexOutOfBoundsException e2) {
                        e = e2;
                    }
                }
                i = i2 + 1;
                try {
                    this.zzb[i2] = (byte) j;
                } catch (IndexOutOfBoundsException e3) {
                    e = e3;
                    i2 = i;
                    throw new zzd(i2, this.zzc, 1, (Throwable) e);
                }
            }
            this.zzd = i;
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    private static abstract class zzb extends zzajo {
        final byte[] zzb;
        final int zzc;
        int zzd;
        int zze;

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final int zza() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        zzb(int i) {
            super();
            if (i < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i, 20)];
            this.zzb = bArr;
            this.zzc = bArr.length;
        }

        final void zzb(byte b) {
            int i = this.zzd;
            this.zzb[i] = b;
            this.zzd = i + 1;
            this.zze++;
        }

        final void zzm(int i) {
            int i2 = this.zzd;
            byte[] bArr = this.zzb;
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >> 8);
            bArr[i2 + 2] = (byte) (i >> 16);
            bArr[i2 + 3] = i >> Ascii.CAN;
            this.zzd = i2 + 4;
            this.zze += 4;
        }

        final void zzi(long j) {
            int i = this.zzd;
            byte[] bArr = this.zzb;
            bArr[i] = (byte) j;
            bArr[i + 1] = (byte) (j >> 8);
            bArr[i + 2] = (byte) (j >> 16);
            bArr[i + 3] = (byte) (j >> 24);
            bArr[i + 4] = (byte) (j >> 32);
            bArr[i + 5] = (byte) (j >> 40);
            bArr[i + 6] = (byte) (j >> 48);
            bArr[i + 7] = (byte) (j >> 56);
            this.zzd = i + 8;
            this.zze += 8;
        }

        final void zzl(int i, int i2) {
            zzn((i << 3) | i2);
        }

        final void zzn(int i) {
            if (zzajo.zzc) {
                long j = this.zzd;
                while ((i & RangingPosition.RSSI_UNKNOWN) != 0) {
                    byte[] bArr = this.zzb;
                    int i2 = this.zzd;
                    this.zzd = i2 + 1;
                    zzana.zza(bArr, i2, (byte) (i | 128));
                    i >>>= 7;
                }
                byte[] bArr2 = this.zzb;
                int i3 = this.zzd;
                this.zzd = i3 + 1;
                zzana.zza(bArr2, i3, (byte) i);
                this.zze += (int) (((long) this.zzd) - j);
                return;
            }
            while ((i & RangingPosition.RSSI_UNKNOWN) != 0) {
                byte[] bArr3 = this.zzb;
                int i4 = this.zzd;
                this.zzd = i4 + 1;
                bArr3[i4] = (byte) (i | 128);
                this.zze++;
                i >>>= 7;
            }
            byte[] bArr4 = this.zzb;
            int i5 = this.zzd;
            this.zzd = i5 + 1;
            bArr4[i5] = (byte) i;
            this.zze++;
        }

        final void zzj(long j) {
            if (zzajo.zzc) {
                long j2 = this.zzd;
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.zzb;
                    int i = this.zzd;
                    this.zzd = i + 1;
                    zzana.zza(bArr, i, (byte) (((int) j) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.zzb;
                int i2 = this.zzd;
                this.zzd = i2 + 1;
                zzana.zza(bArr2, i2, (byte) j);
                this.zze += (int) (((long) this.zzd) - j2);
                return;
            }
            while ((j & (-128)) != 0) {
                byte[] bArr3 = this.zzb;
                int i3 = this.zzd;
                this.zzd = i3 + 1;
                bArr3[i3] = (byte) (((int) j) | 128);
                this.zze++;
                j >>>= 7;
            }
            byte[] bArr4 = this.zzb;
            int i4 = this.zzd;
            this.zzd = i4 + 1;
            bArr4[i4] = (byte) j;
            this.zze++;
        }
    }

    public static int zza(double d) {
        return 8;
    }

    public static int zza(float f) {
        return 4;
    }

    public static int zza(long j) {
        return 8;
    }

    public static int zza(boolean z) {
        return 1;
    }

    public static int zzb(int i) {
        return 4;
    }

    public static int zzc(long j) {
        return 8;
    }

    static int zzd(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int zze(int i) {
        return 4;
    }

    private static long zzi(long j) {
        return (j >> 63) ^ (j << 1);
    }

    private static int zzm(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract int zza();

    public abstract void zza(byte b) throws IOException;

    public abstract void zzb(int i, zzaln zzalnVar) throws IOException;

    public abstract void zzb(int i, String str) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public abstract void zzb(zzaiw zzaiwVar) throws IOException;

    abstract void zzb(zzaln zzalnVar, zzamc zzamcVar) throws IOException;

    public abstract void zzb(String str) throws IOException;

    abstract void zzb(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzc() throws IOException;

    public abstract void zzc(int i, zzaiw zzaiwVar) throws IOException;

    abstract void zzc(int i, zzaln zzalnVar, zzamc zzamcVar) throws IOException;

    public abstract void zzc(zzaln zzalnVar) throws IOException;

    public abstract void zzd(int i, zzaiw zzaiwVar) throws IOException;

    public abstract void zzf(int i, long j) throws IOException;

    public abstract void zzf(long j) throws IOException;

    public abstract void zzg(int i, int i2) throws IOException;

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzh(long j) throws IOException;

    public abstract void zzi(int i) throws IOException;

    public abstract void zzj(int i) throws IOException;

    public abstract void zzj(int i, int i2) throws IOException;

    public abstract void zzk(int i, int i2) throws IOException;

    public abstract void zzl(int i) throws IOException;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static class zzd extends IOException {
        zzd() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzd(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        private zzd(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }

        zzd(int i, int i2, int i3, Throwable th) {
            this(i, i2, i3, th);
        }

        private zzd(long j, long j2, int i, Throwable th) {
            this(String.format(Locale.US, "Pos: %d, limit: %d, len: %d", Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)), th);
        }
    }

    public static int zza(int i, boolean z) {
        return zzh(i << 3) + 1;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    private static final class zzc extends zzb {
        private final OutputStream zzf;

        zzc(OutputStream outputStream, int i) {
            super(i);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.zzf = outputStream;
        }

        private final void zze() throws IOException {
            this.zzf.write(this.zzb, 0, this.zzd);
            this.zzd = 0;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzc() throws IOException {
            if (this.zzd > 0) {
                zze();
            }
        }

        private final void zzo(int i) throws IOException {
            if (this.zzc - this.zzd < i) {
                zze();
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zza(byte b) throws IOException {
            if (this.zzd == this.zzc) {
                zze();
            }
            zzb(b);
        }

        private final void zzc(byte[] bArr, int i, int i2) throws IOException {
            if (this.zzc - this.zzd >= i2) {
                System.arraycopy(bArr, i, this.zzb, this.zzd, i2);
                this.zzd += i2;
            } else {
                int i3 = this.zzc - this.zzd;
                System.arraycopy(bArr, i, this.zzb, this.zzd, i3);
                int i4 = i + i3;
                i2 -= i3;
                this.zzd = this.zzc;
                this.zze += i3;
                zze();
                if (i2 <= this.zzc) {
                    System.arraycopy(bArr, i4, this.zzb, 0, i2);
                    this.zzd = i2;
                } else {
                    this.zzf.write(bArr, i4, i2);
                }
            }
            this.zze += i2;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzb(int i, boolean z) throws IOException {
            zzo(11);
            zzl(i, 0);
            zzb(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            zzl(i2);
            zzc(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzc(int i, zzaiw zzaiwVar) throws IOException {
            zzj(i, 2);
            zzb(zzaiwVar);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzb(zzaiw zzaiwVar) throws IOException {
            zzl(zzaiwVar.zzb());
            zzaiwVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzg(int i, int i2) throws IOException {
            zzo(14);
            zzl(i, 5);
            zzm(i2);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzi(int i) throws IOException {
            zzo(4);
            zzm(i);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzf(int i, long j) throws IOException {
            zzo(18);
            zzl(i, 1);
            zzi(j);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzf(long j) throws IOException {
            zzo(8);
            zzi(j);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzh(int i, int i2) throws IOException {
            zzo(20);
            zzl(i, 0);
            if (i2 >= 0) {
                zzn(i2);
            } else {
                zzj(i2);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzj(int i) throws IOException {
            if (i >= 0) {
                zzl(i);
            } else {
                zzh(i);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaix
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            zzc(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        final void zzc(int i, zzaln zzalnVar, zzamc zzamcVar) throws IOException {
            zzj(i, 2);
            zzb(zzalnVar, zzamcVar);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzc(zzaln zzalnVar) throws IOException {
            zzl(zzalnVar.zzl());
            zzalnVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        final void zzb(zzaln zzalnVar, zzamc zzamcVar) throws IOException {
            zzl(((zzain) zzalnVar).zza(zzamcVar));
            zzamcVar.zza(zzalnVar, this.zza);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzb(int i, zzaln zzalnVar) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzj(3, 2);
            zzc(zzalnVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzd(int i, zzaiw zzaiwVar) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzc(3, zzaiwVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzb(int i, String str) throws IOException {
            zzj(i, 2);
            zzb(str);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzb(String str) throws IOException {
            int iZza;
            try {
                int length = str.length() * 3;
                int iZzh = zzh(length);
                int i = iZzh + length;
                if (i > this.zzc) {
                    byte[] bArr = new byte[length];
                    int iZza2 = zzanb.zza(str, bArr, 0, length);
                    zzl(iZza2);
                    zza(bArr, 0, iZza2);
                    return;
                }
                if (i > this.zzc - this.zzd) {
                    zze();
                }
                int iZzh2 = zzh(str.length());
                int i2 = this.zzd;
                try {
                    if (iZzh2 == iZzh) {
                        this.zzd = i2 + iZzh2;
                        int iZza3 = zzanb.zza(str, this.zzb, this.zzd, this.zzc - this.zzd);
                        this.zzd = i2;
                        iZza = (iZza3 - i2) - iZzh2;
                        zzn(iZza);
                        this.zzd = iZza3;
                    } else {
                        iZza = zzanb.zza(str);
                        zzn(iZza);
                        this.zzd = zzanb.zza(str, this.zzb, this.zzd, iZza);
                    }
                    this.zze += iZza;
                } catch (zzane e) {
                    this.zze -= this.zzd - i2;
                    this.zzd = i2;
                    throw e;
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new zzd(e2);
                }
            } catch (zzane e3) {
                zza(str, e3);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzj(int i, int i2) throws IOException {
            zzl((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzk(int i, int i2) throws IOException {
            zzo(20);
            zzl(i, 0);
            zzn(i2);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzl(int i) throws IOException {
            zzo(5);
            zzn(i);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzh(int i, long j) throws IOException {
            zzo(20);
            zzl(i, 0);
            zzj(j);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public final void zzh(long j) throws IOException {
            zzo(10);
            zzj(j);
        }
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        return zzh(length) + length;
    }

    public static int zza(int i, zzaiw zzaiwVar) {
        int iZzh = zzh(i << 3);
        int iZzb = zzaiwVar.zzb();
        return iZzh + zzh(iZzb) + iZzb;
    }

    public static int zza(zzaiw zzaiwVar) {
        int iZzb = zzaiwVar.zzb();
        return zzh(iZzb) + iZzb;
    }

    public static int zza(int i, double d) {
        return zzh(i << 3) + 8;
    }

    public static int zza(int i, int i2) {
        return zzh(i << 3) + zze(i2);
    }

    public static int zza(int i) {
        return zze(i);
    }

    public static int zzb(int i, int i2) {
        return zzh(i << 3) + 4;
    }

    public static int zza(int i, long j) {
        return zzh(i << 3) + 8;
    }

    public static int zza(int i, float f) {
        return zzh(i << 3) + 4;
    }

    @Deprecated
    static int zza(int i, zzaln zzalnVar, zzamc zzamcVar) {
        return (zzh(i << 3) << 1) + ((zzain) zzalnVar).zza(zzamcVar);
    }

    @Deprecated
    public static int zza(zzaln zzalnVar) {
        return zzalnVar.zzl();
    }

    public static int zzc(int i, int i2) {
        return zzh(i << 3) + zze(i2);
    }

    public static int zzc(int i) {
        return zze(i);
    }

    public static int zzb(int i, long j) {
        return zzh(i << 3) + zze(j);
    }

    public static int zzb(long j) {
        return zze(j);
    }

    public static int zza(int i, zzakv zzakvVar) {
        return (zzh(8) << 1) + zzf(2, i) + zzb(3, zzakvVar);
    }

    public static int zzb(int i, zzakv zzakvVar) {
        int iZzh = zzh(i << 3);
        int iZza = zzakvVar.zza();
        return iZzh + zzh(iZza) + iZza;
    }

    public static int zza(zzakv zzakvVar) {
        int iZza = zzakvVar.zza();
        return zzh(iZza) + iZza;
    }

    public static int zza(int i, zzaln zzalnVar) {
        return (zzh(8) << 1) + zzf(2, i) + zzh(24) + zzb(zzalnVar);
    }

    static int zzb(int i, zzaln zzalnVar, zzamc zzamcVar) {
        return zzh(i << 3) + zza(zzalnVar, zzamcVar);
    }

    public static int zzb(zzaln zzalnVar) {
        int iZzl = zzalnVar.zzl();
        return zzh(iZzl) + iZzl;
    }

    static int zza(zzaln zzalnVar, zzamc zzamcVar) {
        int iZza = ((zzain) zzalnVar).zza(zzamcVar);
        return zzh(iZza) + iZza;
    }

    public static int zzb(int i, zzaiw zzaiwVar) {
        return (zzh(8) << 1) + zzf(2, i) + zza(3, zzaiwVar);
    }

    public static int zzd(int i, int i2) {
        return zzh(i << 3) + 4;
    }

    public static int zzc(int i, long j) {
        return zzh(i << 3) + 8;
    }

    public static int zze(int i, int i2) {
        return zzh(i << 3) + zzh(zzm(i2));
    }

    public static int zzf(int i) {
        return zzh(zzm(i));
    }

    public static int zzd(int i, long j) {
        return zzh(i << 3) + zze(zzi(j));
    }

    public static int zzd(long j) {
        return zze(zzi(j));
    }

    public static int zza(int i, String str) {
        return zzh(i << 3) + zza(str);
    }

    public static int zza(String str) {
        int length;
        try {
            length = zzanb.zza(str);
        } catch (zzane unused) {
            length = str.getBytes(zzaki.zza).length;
        }
        return zzh(length) + length;
    }

    public static int zzg(int i) {
        return zzh(i << 3);
    }

    public static int zzf(int i, int i2) {
        return zzh(i << 3) + zzh(i2);
    }

    public static int zzh(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zze(int i, long j) {
        return zzh(i << 3) + zze(j);
    }

    public static int zze(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static zzajo zzb(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static zzajo zza(OutputStream outputStream, int i) {
        return new zzc(outputStream, i);
    }

    private zzajo() {
    }

    public final void zzb() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void zza(String str, zzane zzaneVar) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzaneVar);
        byte[] bytes = str.getBytes(zzaki.zza);
        try {
            zzl(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzd(e);
        }
    }

    public final void zzb(boolean z) throws IOException {
        zza(z ? (byte) 1 : (byte) 0);
    }

    public final void zzb(int i, double d) throws IOException {
        zzf(i, Double.doubleToRawLongBits(d));
    }

    public final void zzb(double d) throws IOException {
        zzf(Double.doubleToRawLongBits(d));
    }

    public final void zzb(int i, float f) throws IOException {
        zzg(i, Float.floatToRawIntBits(f));
    }

    public final void zzb(float f) throws IOException {
        zzi(Float.floatToRawIntBits(f));
    }

    public final void zzi(int i, int i2) throws IOException {
        zzk(i, zzm(i2));
    }

    public final void zzk(int i) throws IOException {
        zzl(zzm(i));
    }

    public final void zzg(int i, long j) throws IOException {
        zzh(i, zzi(j));
    }

    public final void zzg(long j) throws IOException {
        zzh(zzi(j));
    }
}
