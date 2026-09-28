package com.google.android.gms.internal.p002firebaseauthapi;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbt {
    private boolean zza;
    private zzbq zzb;

    @Nullable
    private final zzcg zzc;
    private zzbw zzd;

    @Nullable
    private zzbu zze;

    public final zzbt zza() {
        zzbu zzbuVar = this.zze;
        if (zzbuVar != null) {
            zzbuVar.zzb();
        }
        this.zza = true;
        return this;
    }

    public final zzbt zzb() {
        this.zzd = zzbw.zza;
        return this;
    }

    private zzbt(zzcg zzcgVar) {
        this.zzb = zzbq.zza;
        this.zzd = null;
        this.zze = null;
        this.zzc = zzcgVar;
    }
}
