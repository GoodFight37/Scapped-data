package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzgt {
    private final String zza;
    private final long zzb;

    zzgt(String str, long j) {
        this.zza = str;
        this.zzb = j;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgt) {
            zzgt zzgtVar = (zzgt) obj;
            if (Objects.equal(this.zza, zzgtVar.zza) && Objects.equal(Long.valueOf(this.zzb), Long.valueOf(zzgtVar.zzb))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Long.valueOf(this.zzb));
    }

    public final String zza() {
        return this.zza;
    }
}
