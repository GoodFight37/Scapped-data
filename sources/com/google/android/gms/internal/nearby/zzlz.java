package com.google.android.gms.internal.nearby;

import android.os.ParcelFileDescriptor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzlz {
    private final zzmb zza = new zzmb(null);

    public final zzlz zza(byte[] bArr) {
        this.zza.zzc = bArr;
        return this;
    }

    public final zzlz zzb(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zzd = parcelFileDescriptor;
        return this;
    }

    public final zzlz zzc(String str) {
        this.zza.zzm = str;
        return this;
    }

    public final zzlz zzd(long j) {
        this.zza.zza = j;
        return this;
    }

    public final zzlz zze(boolean z) {
        this.zza.zzj = z;
        return this;
    }

    public final zzlz zzf(String str) {
        this.zza.zze = str;
        return this;
    }

    public final zzlz zzg(long j) {
        this.zza.zzf = j;
        return this;
    }

    public final zzlz zzh(long j) {
        this.zza.zzi = j;
        return this;
    }

    public final zzlz zzi(String str) {
        this.zza.zzn = str;
        return this;
    }

    public final zzlz zzj(long j) {
        this.zza.zzl = 0L;
        return this;
    }

    public final zzlz zzk(zzlx zzlxVar) {
        this.zza.zzk = zzlxVar;
        return this;
    }

    public final zzlz zzl(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zzg = parcelFileDescriptor;
        return this;
    }

    public final zzlz zzm(int i) {
        this.zza.zzb = i;
        return this;
    }

    public final zzmb zzn() {
        return this.zza;
    }
}
