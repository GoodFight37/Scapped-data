package com.google.android.gms.games.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzh {
    private boolean zza = false;
    private boolean zzb = false;
    private boolean zzc = false;

    private zzh() {
    }

    /* synthetic */ zzh(byte[] bArr) {
    }

    public final zzh zza(boolean z) {
        this.zza = true;
        return this;
    }

    public final zzh zzb(boolean z) {
        this.zzb = true;
        return this;
    }

    public final zzh zzc(boolean z) {
        this.zzc = true;
        return this;
    }

    public final zzi zzd() {
        return new zzi(this, null);
    }

    final /* synthetic */ boolean zze() {
        return this.zza;
    }

    final /* synthetic */ boolean zzf() {
        return this.zzb;
    }

    final /* synthetic */ boolean zzg() {
        return this.zzc;
    }
}
