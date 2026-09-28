package com.google.android.gms.nearby.uwb;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzc {
    private int zza = 0;

    public final zzc zza(int i) {
        this.zza = i;
        return this;
    }

    public final zze zzb() {
        Preconditions.checkArgument(this.zza != 0, "deviceType must be set.");
        return new zze(this.zza, false, null, hashCode(), null);
    }
}
