package com.google.android.gms.nearby.uwb;

import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public class RangingPosition {
    public static final int RSSI_MAX = -1;
    public static final int RSSI_MIN = -127;
    public static final int RSSI_UNKNOWN = -128;
    private final RangingMeasurement zza;
    private final RangingMeasurement zzb;
    private final RangingMeasurement zzc;
    private final long zzd;
    private final int zze;

    public RangingPosition(RangingMeasurement rangingMeasurement, RangingMeasurement rangingMeasurement2, RangingMeasurement rangingMeasurement3, long j, int i) {
        this.zza = rangingMeasurement;
        this.zzb = rangingMeasurement2;
        this.zzc = rangingMeasurement3;
        this.zzd = j;
        this.zze = i;
    }

    public RangingMeasurement getAzimuth() {
        return this.zzb;
    }

    public RangingMeasurement getDistance() {
        return this.zza;
    }

    public long getElapsedRealtimeNanos() {
        return this.zzd;
    }

    public RangingMeasurement getElevation() {
        return this.zzc;
    }

    public int getRssiDbm() {
        return this.zze;
    }

    public String toString() {
        String strConcat = String.format(Locale.US, "elapsedRealtime (ms) %d | distance (m) %f", Long.valueOf(this.zzd / 1000000), Float.valueOf(this.zza.getValue()));
        if (this.zzb != null) {
            strConcat = String.valueOf(strConcat).concat(String.valueOf(String.format(Locale.US, " | azimuth: %f", Float.valueOf(this.zzb.getValue()))));
        }
        if (this.zzc != null) {
            strConcat = String.valueOf(strConcat).concat(String.valueOf(String.format(Locale.US, " | elevation: %f", Float.valueOf(this.zzc.getValue()))));
        }
        return String.valueOf(strConcat).concat(String.valueOf(String.format(Locale.US, " | rssi: %d", Integer.valueOf(this.zze))));
    }
}
