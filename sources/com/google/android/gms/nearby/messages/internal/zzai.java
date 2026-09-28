package com.google.android.gms.nearby.messages.internal;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.nearby.zznm;
import com.google.android.gms.internal.nearby.zzno;
import com.google.android.gms.internal.nearby.zznr;
import com.google.android.gms.internal.nearby.zzns;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.SubscribeOptions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzai extends GmsClient {
    private final zzns zze;
    private final ClientAppContext zzf;
    private final int zzg;

    private zzai(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings, MessagesOptions messagesOptions) {
        super(context, looper, 62, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zze = new zzns();
        String realClientPackageName = clientSettings.getRealClientPackageName();
        int iZzp = zzp(context);
        if (messagesOptions != null) {
            this.zzf = new ClientAppContext(1, realClientPackageName, null, false, iZzp, null);
            this.zzg = messagesOptions.zzc;
        } else {
            this.zzf = new ClientAppContext(1, realClientPackageName, null, false, iZzp, null);
            this.zzg = -1;
        }
    }

    static int zzp(Context context) {
        if (context instanceof Activity) {
            return 1;
        }
        if (context instanceof Application) {
            return 2;
        }
        return context instanceof Service ? 3 : 0;
    }

    public static zzai zzq(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings, MessagesOptions messagesOptions) {
        zzai zzaiVar = new zzai(context, looper, connectionCallbacks, onConnectionFailedListener, clientSettings, messagesOptions);
        if (zzp(context) == 1 && PlatformVersion.isAtLeastIceCreamSandwich()) {
            Activity activity = (Activity) context;
            if (Log.isLoggable("NearbyMessagesClient", 2)) {
                Log.v("NearbyMessagesClient", String.format("Registering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", activity.getPackageName()));
            }
            activity.getApplication().registerActivityLifecycleCallbacks(new zzah(activity, zzaiVar, null));
        }
        return zzaiVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
        return iInterfaceQueryLocalInterface instanceof zzs ? (zzs) iInterfaceQueryLocalInterface : new zzs(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        try {
            zzr(2);
        } catch (RemoteException e) {
            if (Log.isLoggable("NearbyMessagesClient", 2)) {
                Log.v("NearbyMessagesClient", String.format("Failed to emit CLIENT_DISCONNECTED from override of GmsClient#disconnect(): %s", e));
            }
        }
        this.zze.zzb();
        super.disconnect();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final Bundle getGetServiceRequestExtraArgs() {
        Bundle getServiceRequestExtraArgs = super.getGetServiceRequestExtraArgs();
        getServiceRequestExtraArgs.putInt("NearbyPermissions", this.zzg);
        getServiceRequestExtraArgs.putParcelable("ClientAppContext", this.zzf);
        return getServiceRequestExtraArgs;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresGooglePlayServices() {
        return Nearby.zza(getContext());
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zzA(ListenerHolder listenerHolder, ListenerHolder listenerHolder2) throws RemoteException {
        ListenerHolder.ListenerKey listenerKey = listenerHolder2.getListenerKey();
        if (listenerKey == null) {
            return;
        }
        zzno zznoVar = new zzno(listenerHolder);
        if (!this.zze.zze(listenerKey)) {
            zznoVar.zzd(new Status(0));
            return;
        }
        zzcb zzcbVar = new zzcb(zznoVar, (IBinder) this.zze.zza(listenerKey));
        zzcbVar.zzd = false;
        ((zzs) getService()).zzg(zzcbVar);
        this.zze.zzd(listenerKey);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zzB(ListenerHolder listenerHolder, PendingIntent pendingIntent) throws RemoteException {
        ((zzs) getService()).zzj(new zzcg(null, new zzno(listenerHolder), pendingIntent));
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zzC(ListenerHolder listenerHolder, ListenerHolder listenerHolder2) throws RemoteException {
        ListenerHolder.ListenerKey listenerKey = listenerHolder2.getListenerKey();
        if (listenerKey == null) {
            return;
        }
        zzno zznoVar = new zzno(listenerHolder);
        if (!this.zze.zze(listenerKey)) {
            zznoVar.zzd(new Status(0));
            return;
        }
        ((zzs) getService()).zzj(new zzcg((IBinder) this.zze.zza(listenerKey), zznoVar, null));
        this.zze.zzd(listenerKey);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zzr(int i) throws RemoteException {
        String str = i != 1 ? "CLIENT_DISCONNECTED" : "ACTIVITY_STOPPED";
        if (!isConnected()) {
            if (Log.isLoggable("NearbyMessagesClient", 3)) {
                Log.d("NearbyMessagesClient", String.format("Failed to emit client lifecycle event %s due to GmsClient being disconnected", str));
            }
        } else {
            zzj zzjVar = new zzj(1, null, i);
            if (Log.isLoggable("NearbyMessagesClient", 3)) {
                Log.d("NearbyMessagesClient", String.format("Emitting client lifecycle event %s", str));
            }
            ((zzs) getService()).zze(zzjVar);
        }
    }

    @Deprecated
    final void zzs(ListenerHolder listenerHolder, zzae zzaeVar, zzu zzuVar, PublishOptions publishOptions) throws RemoteException {
        zzt(listenerHolder, zzaeVar, zzuVar, publishOptions, this.zzf.zze);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zzt(ListenerHolder listenerHolder, zzae zzaeVar, zzu zzuVar, PublishOptions publishOptions, int i) throws RemoteException {
        ((zzs) getService()).zzf(new zzbz(2, zzaeVar, publishOptions.getStrategy(), new zzno(listenerHolder), null, null, false, zzuVar, false, null, i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zzu(ListenerHolder listenerHolder, ListenerHolder listenerHolder2) throws RemoteException {
        ListenerHolder.ListenerKey listenerKey = listenerHolder2.getListenerKey();
        if (listenerKey == null) {
            return;
        }
        if (!this.zze.zze(listenerKey)) {
            this.zze.zzc(listenerKey, new zznr(listenerHolder2));
        }
        zzcb zzcbVar = new zzcb(new zzno(listenerHolder), (IBinder) this.zze.zza(listenerKey));
        zzcbVar.zzd = true;
        ((zzs) getService()).zzg(zzcbVar);
    }

    @Deprecated
    final void zzv(ListenerHolder listenerHolder, PendingIntent pendingIntent, zzaa zzaaVar, SubscribeOptions subscribeOptions) throws RemoteException {
        zzw(listenerHolder, pendingIntent, zzaaVar, subscribeOptions, this.zzf.zze);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zzw(ListenerHolder listenerHolder, PendingIntent pendingIntent, zzaa zzaaVar, SubscribeOptions subscribeOptions, int i) throws RemoteException {
        Strategy strategy = subscribeOptions.getStrategy();
        zzno zznoVar = new zzno(listenerHolder);
        MessageFilter filter = subscribeOptions.getFilter();
        boolean z = subscribeOptions.zza;
        int i2 = subscribeOptions.zzb;
        ((zzs) getService()).zzh(new SubscribeRequest(null, strategy, zznoVar, filter, pendingIntent, null, zzaaVar, false, 0, this.zzf.zze));
    }

    @Deprecated
    final void zzx(ListenerHolder listenerHolder, ListenerHolder listenerHolder2, zzaa zzaaVar, SubscribeOptions subscribeOptions, byte[] bArr) throws RemoteException {
        zzy(listenerHolder, listenerHolder2, zzaaVar, subscribeOptions, null, this.zzf.zze);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zzy(ListenerHolder listenerHolder, ListenerHolder listenerHolder2, zzaa zzaaVar, SubscribeOptions subscribeOptions, byte[] bArr, int i) throws RemoteException {
        ListenerHolder.ListenerKey listenerKey = listenerHolder2.getListenerKey();
        if (listenerKey == null) {
            return;
        }
        if (!this.zze.zze(listenerKey)) {
            this.zze.zzc(listenerKey, new zznm(listenerHolder2));
        }
        IBinder iBinder = (IBinder) this.zze.zza(listenerKey);
        Strategy strategy = subscribeOptions.getStrategy();
        zzno zznoVar = new zzno(listenerHolder);
        MessageFilter filter = subscribeOptions.getFilter();
        boolean z = subscribeOptions.zza;
        ((zzs) getService()).zzh(new SubscribeRequest(iBinder, strategy, zznoVar, filter, null, null, zzaaVar, false, 0, i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zzz(ListenerHolder listenerHolder, zzae zzaeVar) throws RemoteException {
        ((zzs) getService()).zzi(new zzce(1, zzaeVar, new zzno(listenerHolder), null, null, false, null));
    }
}
