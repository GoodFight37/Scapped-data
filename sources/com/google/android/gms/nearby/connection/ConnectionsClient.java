package com.google.android.gms.nearby.connection;

import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public interface ConnectionsClient extends HasApiKey<ConnectionsOptions> {
    public static final int MAX_BYTES_DATA_SIZE = 1047552;

    Task<Void> acceptConnection(String str, PayloadCallback payloadCallback);

    Task<Void> cancelPayload(long j);

    void disconnectFromEndpoint(String str);

    Task<Void> rejectConnection(String str);

    Task<Void> requestConnection(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback);

    Task<Void> requestConnection(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback, ConnectionOptions connectionOptions);

    Task<Void> requestConnection(byte[] bArr, String str, ConnectionLifecycleCallback connectionLifecycleCallback);

    Task<Void> requestConnection(byte[] bArr, String str, ConnectionLifecycleCallback connectionLifecycleCallback, ConnectionOptions connectionOptions);

    Task<Void> sendPayload(String str, Payload payload);

    Task<Void> sendPayload(List<String> list, Payload payload);

    Task<Void> startAdvertising(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback, AdvertisingOptions advertisingOptions);

    Task<Void> startAdvertising(byte[] bArr, String str, ConnectionLifecycleCallback connectionLifecycleCallback, AdvertisingOptions advertisingOptions);

    Task<Void> startDiscovery(String str, EndpointDiscoveryCallback endpointDiscoveryCallback, DiscoveryOptions discoveryOptions);

    void stopAdvertising();

    void stopAllEndpoints();

    void stopDiscovery();
}
