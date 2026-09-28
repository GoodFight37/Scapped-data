package com.google.android.gms.common.internal;

import android.content.ComponentName;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzo {
    private final String zza;
    private final String zzb;
    private final ComponentName zzc;
    private final int zzd;
    private final boolean zze;

    public zzo(ComponentName componentName, int i) {
        this.zza = null;
        this.zzb = null;
        Preconditions.checkNotNull(componentName);
        this.zzc = componentName;
        this.zzd = 4225;
        this.zze = false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzo)) {
            return false;
        }
        zzo zzoVar = (zzo) obj;
        if (Objects.equal(this.zza, zzoVar.zza) && Objects.equal(this.zzb, zzoVar.zzb) && Objects.equal(this.zzc, zzoVar.zzc)) {
            int i = zzoVar.zzd;
            if (this.zze == zzoVar.zze) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, 4225, Boolean.valueOf(this.zze));
    }

    public final String toString() {
        String str = this.zza;
        if (str != null) {
            return str;
        }
        Preconditions.checkNotNull(this.zzc);
        return this.zzc.flattenToString();
    }

    public final ComponentName zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final boolean zzd() {
        return this.zze;
    }

    public zzo(String str, int i, boolean z) {
        this(str, "com.google.android.gms", 4225, false);
    }

    public zzo(String str, String str2, int i, boolean z) {
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        Preconditions.checkNotEmpty(str2);
        this.zzb = str2;
        this.zzc = null;
        this.zzd = 4225;
        this.zze = z;
    }
}
