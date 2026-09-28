package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.AdvertisingOptions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmq {
    private final zzms zza = new zzms(null);

    public final zzmq zza(zzjp zzjpVar) {
        this.zza.zzb = zzjpVar;
        return this;
    }

    public final zzmq zzb(zzjv zzjvVar) {
        this.zza.zzg = zzjvVar;
        return this;
    }

    public final zzmq zzc(long j) {
        this.zza.zze = j;
        return this;
    }

    public final zzmq zzd(byte[] bArr) {
        this.zza.zzh = bArr;
        return this;
    }

    public final zzmq zze(String str) {
        this.zza.zzc = str;
        return this;
    }

    public final zzmq zzf(AdvertisingOptions advertisingOptions) {
        this.zza.zzf = advertisingOptions;
        return this;
    }

    public final zzmq zzg(zzkm zzkmVar) {
        this.zza.zza = zzkmVar;
        return this;
    }

    public final zzmq zzh(String str) {
        this.zza.zzd = str;
        return this;
    }

    public final zzms zzi() {
        return this.zza;
    }
}
