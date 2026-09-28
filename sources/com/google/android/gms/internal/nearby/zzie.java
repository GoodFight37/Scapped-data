package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.BandwidthInfo;
import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzie extends ConnectionLifecycleCallback {
    final /* synthetic */ zzih zza;
    private final ConnectionLifecycleCallback zzb;

    zzie(zzih zzihVar, ConnectionLifecycleCallback connectionLifecycleCallback) {
        this.zza = zzihVar;
        this.zzb = connectionLifecycleCallback;
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onBandwidthChanged(String str, BandwidthInfo bandwidthInfo) {
        this.zzb.onBandwidthChanged(str, bandwidthInfo);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onConnectionInitiated(String str, ConnectionInfo connectionInfo) {
        if (connectionInfo.isIncomingConnection()) {
            this.zza.zzj(str);
        }
        this.zzb.onConnectionInitiated(str, connectionInfo);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onConnectionResult(String str, ConnectionResolution connectionResolution) {
        if (!connectionResolution.getStatus().isSuccess()) {
            this.zza.zzk(str);
        }
        this.zzb.onConnectionResult(str, connectionResolution);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onDisconnected(String str) {
        this.zza.zzk(str);
        this.zzb.onDisconnected(str);
    }
}
