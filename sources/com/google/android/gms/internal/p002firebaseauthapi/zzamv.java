package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
abstract class zzamv<T, B> {
    private static volatile int zza = 100;

    abstract int zza(T t);

    abstract B zza();

    abstract T zza(T t, T t2);

    abstract void zza(B b, int i, int i2);

    abstract void zza(B b, int i, long j);

    abstract void zza(B b, int i, zzaiw zzaiwVar);

    abstract void zza(B b, int i, T t);

    abstract void zza(T t, zzanm zzanmVar) throws IOException;

    abstract boolean zza(zzamd zzamdVar);

    abstract int zzb(T t);

    abstract void zzb(B b, int i, long j);

    abstract void zzb(T t, zzanm zzanmVar) throws IOException;

    abstract void zzb(Object obj, B b);

    abstract B zzc(Object obj);

    abstract void zzc(Object obj, T t);

    abstract T zzd(Object obj);

    abstract T zze(B b);

    abstract void zzf(Object obj);

    zzamv() {
    }

    final boolean zza(B b, zzamd zzamdVar, int i) throws IOException {
        int iZzd = zzamdVar.zzd();
        int i2 = iZzd >>> 3;
        int i3 = iZzd & 7;
        if (i3 == 0) {
            zzb(b, i2, zzamdVar.zzl());
            return true;
        }
        if (i3 == 1) {
            zza(b, i2, zzamdVar.zzk());
            return true;
        }
        if (i3 == 2) {
            zza((Object) b, i2, zzamdVar.zzp());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                if (i != 0) {
                    return false;
                }
                throw zzakm.zzb();
            }
            if (i3 == 5) {
                zza((Object) b, i2, zzamdVar.zzf());
                return true;
            }
            throw zzakm.zza();
        }
        B bZza = zza();
        int i4 = 4 | (i2 << 3);
        int i5 = i + 1;
        if (i5 >= zza) {
            throw zzakm.zzh();
        }
        while (zzamdVar.zzc() != Integer.MAX_VALUE && zza(bZza, zzamdVar, i5)) {
        }
        if (i4 != zzamdVar.zzd()) {
            throw zzakm.zzb();
        }
        zza(b, i2, zze(bZza));
        return true;
    }
}
