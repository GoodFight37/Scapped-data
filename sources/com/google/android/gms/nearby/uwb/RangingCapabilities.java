package com.google.android.gms.nearby.uwb;

import com.google.android.gms.internal.nearby.zzsq;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public class RangingCapabilities {
    public static final float FIRA_DEFAULT_MIN_SLOT_DURATION_MS = 2.0f;
    public static final int FIRA_DEFAULT_RANGING_INTERVAL_MS = 200;
    public static final int FIRA_DEFAULT_SUPPORTED_CHANNEL = 9;
    public static final zzsq<Integer> FIRA_DEFAULT_SUPPORTED_CONFIG_IDS = zzsq.zzo(1, 2, 3);
    private final boolean zza;
    private final boolean zzb;
    private final boolean zzc;
    private final int zzd;
    private final List zze;
    private final List zzf;

    public RangingCapabilities(boolean z, boolean z2, boolean z3, int i, List list, List list2, float f) {
        this.zza = z;
        this.zzb = z2;
        this.zzc = z3;
        this.zzd = i;
        this.zze = list;
        this.zzf = list2;
    }

    public int getMinRangingInterval() {
        return this.zzd;
    }

    public List<Integer> getSupportedChannels() {
        return this.zze;
    }

    public List<Integer> getSupportedConfigIds() {
        return this.zzf;
    }

    public boolean supportsAzimuthalAngle() {
        return this.zzb;
    }

    public boolean supportsDistance() {
        return this.zza;
    }

    public boolean supportsElevationAngle() {
        return this.zzc;
    }
}
