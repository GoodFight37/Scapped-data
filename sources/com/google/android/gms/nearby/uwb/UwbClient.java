package com.google.android.gms.nearby.uwb;

import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public interface UwbClient extends HasApiKey<zze> {
    Task<Void> addControlee(UwbAddress uwbAddress);

    Task<UwbComplexChannel> getComplexChannel();

    Task<UwbAddress> getLocalAddress();

    Task<RangingCapabilities> getRangingCapabilities();

    Task<Boolean> isAvailable();

    Task<Void> removeControlee(UwbAddress uwbAddress);

    Task<Void> startRanging(RangingParameters rangingParameters, RangingSessionCallback rangingSessionCallback);

    Task<Void> stopRanging(RangingSessionCallback rangingSessionCallback);
}
