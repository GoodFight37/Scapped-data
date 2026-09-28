package com.google.android.gms.nearby.connection;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzg {
    private String zza;
    private String zzb;
    private byte[] zzc;
    private boolean zzd;
    private boolean zze;
    private byte[] zzf;

    @Deprecated
    public final zzg zza(String str) {
        this.zzb = str;
        return this;
    }

    public final zzg zzb(byte[] bArr) {
        this.zzf = bArr;
        return this;
    }

    public final zzg zzc(String str) {
        this.zza = str;
        return this;
    }

    @Deprecated
    public final zzg zzd(boolean z) {
        this.zze = z;
        return this;
    }

    public final zzg zze(boolean z) {
        this.zzd = z;
        return this;
    }

    public final zzg zzf(byte[] bArr) {
        this.zzc = bArr;
        return this;
    }

    public final ConnectionInfo zzg() {
        return new ConnectionInfo(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
