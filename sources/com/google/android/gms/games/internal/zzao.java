package com.google.android.gms.games.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzao {
    private static final zzao zza = new zzao();
    private volatile boolean zzb = false;

    zzao() {
    }

    public static zzao zza() {
        return zza;
    }

    public final boolean zzb() {
        return this.zzb;
    }

    public final void zzc() {
        this.zzb = true;
    }
}
