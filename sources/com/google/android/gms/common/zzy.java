package com.google.android.gms.common;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzy {
    private String zza = null;
    private Boolean zzb = null;
    private Boolean zzc = null;

    private zzy() {
    }

    /* synthetic */ zzy(zzz zzzVar) {
    }

    final zzy zza(boolean z) {
        this.zzb = Boolean.valueOf(z);
        return this;
    }

    final zzy zzb(boolean z) {
        this.zzc = Boolean.valueOf(z);
        return this;
    }

    final zzy zzc(String str) {
        this.zza = str;
        return this;
    }

    final zzaa zzd() {
        Boolean bool = this.zzb;
        if (bool == null) {
            throw new IllegalStateException("allowTestKeys must be set");
        }
        if (this.zzc != null) {
            return new zzaa(this.zza, bool.booleanValue(), false, false, this.zzc.booleanValue(), null, null);
        }
        throw new IllegalStateException("isGoogleOrPlatformOnly must be set");
    }
}
