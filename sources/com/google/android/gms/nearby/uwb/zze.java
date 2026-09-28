package com.google.android.gms.nearby.uwb;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zze implements Api.ApiOptions.HasOptions {
    private final int zzb;
    private final int zzd;
    private final boolean zzc = false;
    private final String zza = null;

    /* synthetic */ zze(int i, boolean z, String str, int i2, zzd zzdVar) {
        this.zzb = i;
        this.zzd = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zze)) {
            return false;
        }
        zze zzeVar = (zze) obj;
        boolean z = zzeVar.zzc;
        if (Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzeVar.zzb))) {
            String str = zzeVar.zza;
            if (Objects.equal(null, null) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(zzeVar.zzd))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb), false, null, Integer.valueOf(this.zzd));
    }

    public final int zza() {
        return this.zzb;
    }
}
