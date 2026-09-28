package com.google.android.gms.common;

import android.util.Log;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
class zzad {
    private static final zzad zzf = new zzad(true, 3, 1, null, null, -1, null);
    final boolean zza;

    @Nullable
    final String zzb;

    @Nullable
    final Throwable zzc;

    @Nullable
    final zzad zzd;
    final int zze;

    private zzad(boolean z, int i, int i2, @Nullable String str, @Nullable Throwable th, long j, @Nullable zzad zzadVar) {
        this.zza = z;
        this.zze = i;
        this.zzb = str;
        this.zzc = th;
        this.zzd = zzadVar;
    }

    @Deprecated
    static zzad zzb() {
        return zzf;
    }

    static zzad zzc(String str) {
        return new zzad(false, 1, 5, str, null, -1L, null);
    }

    static zzad zzd(String str, Throwable th) {
        return new zzad(false, 1, 5, str, th, -1L, null);
    }

    static zzad zzf(int i, long j, @Nullable zzad zzadVar) {
        return new zzad(true, i, 1, null, null, j, zzadVar);
    }

    static zzad zzg(int i, int i2, String str, @Nullable Throwable th) {
        return new zzad(false, i, i2, str, th, -1L, null);
    }

    @Nullable
    String zza() {
        return this.zzb;
    }

    final void zze() {
        if (this.zza || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.zzc != null) {
            Log.d("GoogleCertificatesRslt", zza(), this.zzc);
        } else {
            Log.d("GoogleCertificatesRslt", zza());
        }
    }
}
