package com.google.android.gms.nearby.connection;

import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionInfo {
    private final String zza;
    private final String zzb;
    private final byte[] zzc;
    private final boolean zzd;
    private final boolean zze;
    private final byte[] zzf;

    @Deprecated
    public ConnectionInfo(String str, String str2, boolean z) {
        this(str, str2, str2.getBytes(), z, false, str.getBytes());
    }

    private ConnectionInfo(String str, String str2, byte[] bArr, boolean z, boolean z2, byte[] bArr2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bArr;
        this.zzd = z;
        this.zze = z2;
        this.zzf = bArr2;
    }

    public String getAuthenticationDigits() {
        int i = 1;
        int i2 = 0;
        for (byte b : this.zzc) {
            int i3 = i2 + (b * i);
            i = (i * 31) % 9973;
            i2 = i3 % 9973;
        }
        return String.format(Locale.US, "%04d", Integer.valueOf(Math.abs(i2)));
    }

    @Deprecated
    public String getAuthenticationToken() {
        return this.zzb;
    }

    public byte[] getEndpointInfo() {
        return this.zzf;
    }

    public String getEndpointName() {
        return this.zza;
    }

    public byte[] getRawAuthenticationToken() {
        return this.zzc;
    }

    @Deprecated
    public boolean isConnectionVerified() {
        return this.zze;
    }

    public boolean isIncomingConnection() {
        return this.zzd;
    }
}
