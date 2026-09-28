package com.google.android.gms.nearby.connection;

import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionResolution {
    private final Status zza;

    @Deprecated
    public ConnectionResolution(Status status) {
        this.zza = status;
    }

    public Status getStatus() {
        return this.zza;
    }
}
