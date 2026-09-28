package com.google.android.gms.nearby.messages;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface NearbyPermissions {
    public static final int BLE = 2;
    public static final int BLUETOOTH = 6;
    public static final int DEFAULT = -1;

    @Deprecated
    public static final int MICROPHONE = 1;
    public static final int NONE = 0;
}
