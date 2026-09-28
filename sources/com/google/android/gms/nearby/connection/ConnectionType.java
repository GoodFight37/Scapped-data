package com.google.android.gms.nearby.connection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ConnectionType {
    public static final int BALANCED = 0;
    public static final int DISRUPTIVE = 1;
    public static final int NON_DISRUPTIVE = 2;
}
