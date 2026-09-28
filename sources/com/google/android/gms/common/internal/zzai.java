package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzai extends Exception {
    public final ConnectionResult zza;

    public zzai(ConnectionResult connectionResult) {
        Preconditions.checkArgument(connectionResult.hasResolution(), "ResolvableConnectionException can only be created with a connection result containing a resolution.");
        this.zza = connectionResult;
    }
}
