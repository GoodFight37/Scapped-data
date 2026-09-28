package com.google.android.gms.internal.nearby;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionOptions;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.ConnectionsOptions;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzih extends GoogleApi implements ConnectionsClient {
    public static final /* synthetic */ int zza = 0;
    private static final Api.ClientKey zzb;
    private static final Api.AbstractClientBuilder zzc;
    private static final Api zzd;
    private zzfg zze;
    private final zzkp zzf;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zzb = clientKey;
        zzhy zzhyVar = new zzhy();
        zzc = zzhyVar;
        zzd = new Api("Nearby.CONNECTIONS_API", zzhyVar, clientKey);
    }

    private zzih(Activity activity, ConnectionsOptions connectionsOptions) {
        super(activity, (Api<Api.ApiOptions>) zzd, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zzf = zzkp.zza(activity);
    }

    public static zzih zza(Activity activity, ConnectionsOptions connectionsOptions) {
        zzih zzihVar = new zzih(activity, (ConnectionsOptions) null);
        zzihVar.zze = zzfg.zzd(zzihVar, null);
        return zzihVar;
    }

    public static zzih zzb(Context context, ConnectionsOptions connectionsOptions) {
        zzih zzihVar = new zzih(context, (ConnectionsOptions) null);
        zzihVar.zze = zzfg.zzd(zzihVar, null);
        return zzihVar;
    }

    static /* bridge */ /* synthetic */ void zzd(zzih zzihVar, String str) {
        zzihVar.zzk(str);
    }

    private final Task zzh(final zzid zzidVar) {
        return doWrite(TaskApiCall.builder().setMethodKey(1229).run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzgz
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzidVar.zza((zzgy) obj, new zzif(this.zza, (TaskCompletionSource) obj2));
            }
        }).build());
    }

    private final Task zzi(final zzig zzigVar) {
        return doWrite(TaskApiCall.builder().setMethodKey(1229).run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhx
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                int i = zzih.zza;
                zzigVar.zza((zzgy) obj);
                ((TaskCompletionSource) obj2).setResult(null);
            }
        }).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzj(String str) {
        this.zze.zze(this, RegistrationMethods.builder().withHolder(this.zze.zzc(this, str, "connection")).register(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhq
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                int i = zzih.zza;
                ((TaskCompletionSource) obj2).setResult(null);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhr
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((TaskCompletionSource) obj2).setResult(true);
            }
        }).setMethodKey(1268).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzk(String str) {
        zzfg zzfgVar = this.zze;
        zzfgVar.zzg(this, zzfgVar.zza(str, "connection"));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> acceptConnection(final String str, PayloadCallback payloadCallback) {
        final ListenerHolder listenerHolderRegisterListener = registerListener(payloadCallback, PayloadCallback.class.getName());
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhe
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzih zzihVar = this.zza;
                ((zzgy) obj).zzr(new zzif(zzihVar, (TaskCompletionSource) obj2), str, listenerHolderRegisterListener);
            }
        }).setMethodKey(1227).build());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> cancelPayload(final long j) {
        return zzh(new zzid() { // from class: com.google.android.gms.internal.nearby.zzhs
            @Override // com.google.android.gms.internal.nearby.zzid
            public final void zza(zzgy zzgyVar, BaseImplementation.ResultHolder resultHolder) throws RemoteException {
                long j2 = j;
                int i = zzih.zza;
                zzgyVar.zzs(resultHolder, j2);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void disconnectFromEndpoint(final String str) {
        zzi(new zzig() { // from class: com.google.android.gms.internal.nearby.zzhp
            @Override // com.google.android.gms.internal.nearby.zzig
            public final void zza(zzgy zzgyVar) throws RemoteException {
                String str2 = str;
                int i = zzih.zza;
                zzgyVar.zzt(str2);
            }
        });
        zzk(str);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> rejectConnection(final String str) {
        return zzh(new zzid() { // from class: com.google.android.gms.internal.nearby.zzhw
            @Override // com.google.android.gms.internal.nearby.zzid
            public final void zza(zzgy zzgyVar, BaseImplementation.ResultHolder resultHolder) throws RemoteException {
                String str2 = str;
                int i = zzih.zza;
                zzgyVar.zzu(resultHolder, str2);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> requestConnection(final String str, final String str2, ConnectionLifecycleCallback connectionLifecycleCallback) {
        final ListenerHolder listenerHolderRegisterListener = registerListener(new zzie(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        zzj(str2);
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhf
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzih zzihVar = this.zza;
                ((zzgy) obj).zzv(new zzif(zzihVar, (TaskCompletionSource) obj2), str, str2, listenerHolderRegisterListener);
            }
        }).setMethodKey(1226).build()).addOnFailureListener(new zzic(this, str2));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> sendPayload(final String str, final Payload payload) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzht
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzih zzihVar = this.zza;
                String str2 = str;
                ((zzgy) obj).zzz(new zzif(zzihVar, (TaskCompletionSource) obj2), new String[]{str2}, payload, false);
            }
        }).setMethodKey(1228).build());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> startAdvertising(final String str, final String str2, ConnectionLifecycleCallback connectionLifecycleCallback, final AdvertisingOptions advertisingOptions) {
        final ListenerHolder listenerHolderRegisterListener = registerListener(new zzie(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        return this.zze.zze(this, RegistrationMethods.builder().withHolder(this.zze.zzb(this, new Object(), "advertising")).register(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhb
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzih zzihVar = this.zza;
                ((zzgy) obj).zzA(new zzif(zzihVar, (TaskCompletionSource) obj2), str, str2, listenerHolderRegisterListener, advertisingOptions);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhc
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                int i = zzih.zza;
                ((zzgy) obj).zzD();
                ((TaskCompletionSource) obj2).setResult(true);
            }
        }).setMethodKey(1266).build());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> startDiscovery(final String str, EndpointDiscoveryCallback endpointDiscoveryCallback, final DiscoveryOptions discoveryOptions) {
        final ListenerHolder listenerHolderZzb = this.zze.zzb(this, endpointDiscoveryCallback, "discovery");
        return this.zze.zze(this, RegistrationMethods.builder().withHolder(listenerHolderZzb).register(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhi
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzih zzihVar = this.zza;
                ((zzgy) obj).zzC(new zzif(zzihVar, (TaskCompletionSource) obj2), str, listenerHolderZzb, discoveryOptions);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhj
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                int i = zzih.zza;
                ((zzgy) obj).zzF();
                ((TaskCompletionSource) obj2).setResult(true);
            }
        }).setMethodKey(1267).build()).addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.gms.internal.nearby.zzhk
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.zza.zze(discoveryOptions, (Void) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.google.android.gms.internal.nearby.zzhl
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                Log.w("NearbyConnections", "Failed to start discovery.", exc);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopAdvertising() {
        this.zze.zzf(this, "advertising");
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopAllEndpoints() {
        this.zze.zzf(this, "advertising");
        this.zze.zzf(this, "discovery").addOnSuccessListener(new zzho(this));
        zzi(new zzig() { // from class: com.google.android.gms.internal.nearby.zzhm
            @Override // com.google.android.gms.internal.nearby.zzig
            public final void zza(zzgy zzgyVar) throws RemoteException {
                int i = zzih.zza;
                zzgyVar.zzE();
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.internal.nearby.zzhn
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.zza.zzf(task);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopDiscovery() {
        this.zze.zzf(this, "discovery").addOnSuccessListener(new zzho(this));
    }

    final /* synthetic */ void zze(DiscoveryOptions discoveryOptions, Void r2) {
        if (discoveryOptions.zzE()) {
            zzkp zzkpVar = this.zzf;
            if (zzkpVar == null) {
                Log.d("NearbyConnections", "Discovery started with NFC requested, but there is no NfcDispatcher available. Discovery will continue over other mediums instead. To use NFC discovery, pass in an Activity when calling Nearby.getConnectionsClient().");
            } else {
                zzkpVar.zze();
            }
        }
    }

    final /* synthetic */ void zzf(Task task) {
        this.zze.zzf(this, "connection");
        disconnectService();
    }

    final /* synthetic */ void zzg(Void r1) {
        zzkp zzkpVar = this.zzf;
        if (zzkpVar != null) {
            zzkpVar.zzf();
        }
    }

    private zzih(Context context, ConnectionsOptions connectionsOptions) {
        super(context, (Api<Api.ApiOptions>) zzd, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zzf = null;
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> sendPayload(final List<String> list, final Payload payload) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhh
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzih zzihVar = this.zza;
                List list2 = list;
                ((zzgy) obj).zzz(new zzif(zzihVar, (TaskCompletionSource) obj2), (String[]) list2.toArray(new String[0]), payload, false);
            }
        }).setMethodKey(1228).build());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> requestConnection(final String str, final String str2, ConnectionLifecycleCallback connectionLifecycleCallback, final ConnectionOptions connectionOptions) {
        final ListenerHolder listenerHolderRegisterListener = registerListener(new zzie(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        zzj(str2);
        return doWrite(TaskApiCall.builder().setFeatures(com.google.android.gms.nearby.zza.zzf).run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhg
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzih zzihVar = this.zza;
                ((zzgy) obj).zzx(new zzif(zzihVar, (TaskCompletionSource) obj2), str, str2, listenerHolderRegisterListener, connectionOptions);
            }
        }).setMethodKey(1226).build()).addOnFailureListener(new zzhz(this, str2));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> startAdvertising(final byte[] bArr, final String str, ConnectionLifecycleCallback connectionLifecycleCallback, final AdvertisingOptions advertisingOptions) {
        final ListenerHolder listenerHolderRegisterListener = registerListener(new zzie(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        return this.zze.zze(this, RegistrationMethods.builder().withHolder(this.zze.zzb(this, new Object(), "advertising")).setFeatures(com.google.android.gms.nearby.zza.zzf).register(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhu
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzih zzihVar = this.zza;
                ((zzgy) obj).zzB(new zzif(zzihVar, (TaskCompletionSource) obj2), bArr, str, listenerHolderRegisterListener, advertisingOptions);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhv
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                int i = zzih.zza;
                ((zzgy) obj).zzD();
                ((TaskCompletionSource) obj2).setResult(true);
            }
        }).setMethodKey(1266).build());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> requestConnection(final byte[] bArr, final String str, ConnectionLifecycleCallback connectionLifecycleCallback) {
        final ListenerHolder listenerHolderRegisterListener = registerListener(new zzie(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        zzj(str);
        return doWrite(TaskApiCall.builder().setFeatures(com.google.android.gms.nearby.zza.zzf).run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzhd
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzih zzihVar = this.zza;
                ((zzgy) obj).zzw(new zzif(zzihVar, (TaskCompletionSource) obj2), bArr, str, listenerHolderRegisterListener);
            }
        }).setMethodKey(1226).build()).addOnFailureListener(new zzib(this, str));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> requestConnection(final byte[] bArr, final String str, ConnectionLifecycleCallback connectionLifecycleCallback, final ConnectionOptions connectionOptions) {
        final ListenerHolder listenerHolderRegisterListener = registerListener(new zzie(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        zzj(str);
        return doWrite(TaskApiCall.builder().setFeatures(com.google.android.gms.nearby.zza.zzf).run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzha
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzih zzihVar = this.zza;
                ((zzgy) obj).zzy(new zzif(zzihVar, (TaskCompletionSource) obj2), bArr, str, listenerHolderRegisterListener, connectionOptions);
            }
        }).setMethodKey(1226).build()).addOnFailureListener(new zzia(this, str));
    }
}
