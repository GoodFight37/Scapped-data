package com.google.android.gms.nearby.exposurenotification;

import com.google.android.gms.internal.nearby.zzto;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public enum zzj {
    INFECTIOUSNESS_NONE(0),
    INFECTIOUSNESS_STANDARD(1),
    INFECTIOUSNESS_HIGH(2);

    private static final zzto zzd = new zzto() { // from class: com.google.android.gms.nearby.exposurenotification.zzi
    };
    private final int zzf;

    zzj(int i) {
        this.zzf = i;
    }

    public static zzj zza(int i) {
        if (i == 0) {
            return INFECTIOUSNESS_NONE;
        }
        if (i == 1) {
            return INFECTIOUSNESS_STANDARD;
        }
        if (i != 2) {
            return null;
        }
        return INFECTIOUSNESS_HIGH;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzf);
    }
}
