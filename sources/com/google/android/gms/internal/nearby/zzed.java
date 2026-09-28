package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzed {
    private final zzef zza = new zzef(null);

    public final zzed zza(zzcv zzcvVar) {
        this.zza.zzf = zzcvVar;
        return this;
    }

    public final zzed zzb(ExposureConfiguration exposureConfiguration) {
        this.zza.zzd = exposureConfiguration;
        return this;
    }

    public final zzed zzc(List list) {
        this.zza.zzc = list;
        return this;
    }

    public final zzed zzd(IStatusCallback iStatusCallback) {
        this.zza.zzb = iStatusCallback;
        return this;
    }

    public final zzed zze(String str) {
        this.zza.zze = str;
        return this;
    }

    public final zzef zzf() {
        return this.zza;
    }
}
