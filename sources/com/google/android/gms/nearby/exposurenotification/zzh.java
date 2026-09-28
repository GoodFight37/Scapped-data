package com.google.android.gms.nearby.exposurenotification;

import com.google.android.gms.internal.nearby.zzto;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public enum zzh {
    LOWEST_CONFIDENCE(0),
    LOW_CONFIDENCE(1),
    MEDIUM_CONFIDENCE(2),
    HIGH_CONFIDENCE(3);

    private static final zzto zze = new zzto() { // from class: com.google.android.gms.nearby.exposurenotification.zzg
    };
    private final int zzg;

    zzh(int i) {
        this.zzg = i;
    }

    public static zzh zza(int i) {
        if (i == 0) {
            return LOWEST_CONFIDENCE;
        }
        if (i == 1) {
            return LOW_CONFIDENCE;
        }
        if (i == 2) {
            return MEDIUM_CONFIDENCE;
        }
        if (i != 3) {
            return null;
        }
        return HIGH_CONFIDENCE;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzg);
    }
}
