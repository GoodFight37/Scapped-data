package com.google.android.gms.nearby.connection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class BandwidthInfo {
    private final int zza;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Quality {
        public static final int HIGH = 3;
        public static final int LOW = 1;
        public static final int MEDIUM = 2;
        public static final int UNKNOWN = 0;
    }

    public int getQuality() {
        return this.zza;
    }
}
