package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.IStatusCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzeh {
    private final zzej zza = new zzej(null);

    public final zzeh zza(boolean z) {
        this.zza.zzb = z;
        return this;
    }

    public final zzeh zzb(IStatusCallback iStatusCallback) {
        this.zza.zza = iStatusCallback;
        return this;
    }

    public final zzej zzc() {
        return this.zza;
    }
}
