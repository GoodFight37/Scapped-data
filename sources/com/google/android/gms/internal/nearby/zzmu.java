package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.DiscoveryOptions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmu {
    private final zzmw zza = new zzmw(null);

    public final zzmu zza(zzkc zzkcVar) {
        this.zza.zze = zzkcVar;
        return this;
    }

    public final zzmu zzb(long j) {
        this.zza.zzc = j;
        return this;
    }

    public final zzmu zzc(DiscoveryOptions discoveryOptions) {
        this.zza.zzd = discoveryOptions;
        return this;
    }

    public final zzmu zzd(zzkj zzkjVar) {
        this.zza.zza = zzkjVar;
        return this;
    }

    public final zzmu zze(String str) {
        this.zza.zzb = str;
        return this;
    }

    public final zzmw zzf() {
        return this.zza;
    }
}
