package com.google.android.gms.nearby.connection;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ConnectionLifecycleCallback {
    public void onBandwidthChanged(String str, BandwidthInfo bandwidthInfo) {
    }

    public abstract void onConnectionInitiated(String str, ConnectionInfo connectionInfo);

    public abstract void onConnectionResult(String str, ConnectionResolution connectionResolution);

    public abstract void onDisconnected(String str);
}
