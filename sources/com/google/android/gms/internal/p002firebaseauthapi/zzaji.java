package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzaji {
    private static volatile int zzd = 100;
    int zza;
    int zzb;
    zzajm zzc;
    private int zze;
    private int zzf;

    public static int zza(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long zza(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public abstract double zza() throws IOException;

    public abstract float zzb() throws IOException;

    public abstract int zzb(int i) throws zzakm;

    public abstract int zzc();

    public abstract void zzc(int i) throws zzakm;

    public abstract int zzd() throws IOException;

    public abstract void zzd(int i);

    public abstract int zze() throws IOException;

    public abstract boolean zze(int i) throws IOException;

    public abstract int zzf() throws IOException;

    public abstract int zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract int zzi() throws IOException;

    public abstract int zzj() throws IOException;

    public abstract long zzk() throws IOException;

    public abstract long zzl() throws IOException;

    abstract long zzm() throws IOException;

    public abstract long zzn() throws IOException;

    public abstract long zzo() throws IOException;

    public abstract long zzp() throws IOException;

    public abstract zzaiw zzq() throws IOException;

    public abstract String zzr() throws IOException;

    public abstract String zzs() throws IOException;

    public abstract boolean zzw() throws IOException;

    public abstract boolean zzx() throws IOException;

    static zzaji zza(byte[] bArr, int i, int i2, boolean z) {
        zzajl zzajlVar = new zzajl(bArr, i, i2, z);
        try {
            zzajlVar.zzb(i2);
            return zzajlVar;
        } catch (zzakm e) {
            throw new IllegalArgumentException(e);
        }
    }

    private zzaji() {
        this.zzf = zzd;
        this.zzb = Integer.MAX_VALUE;
    }

    public final void zzt() throws zzakm {
        if (this.zza + this.zze >= this.zzf) {
            throw zzakm.zzh();
        }
    }

    public final void zzu() throws zzakm {
        if (this.zze == 0) {
            zzc(0);
        }
    }

    public final void zzv() throws IOException {
        boolean zZze;
        do {
            int iZzi = zzi();
            if (iZzi == 0) {
                return;
            }
            zzt();
            this.zze++;
            zZze = zze(iZzi);
            this.zze--;
        } while (zZze);
    }
}
