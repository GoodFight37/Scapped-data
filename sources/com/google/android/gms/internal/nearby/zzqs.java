package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.nearby.Nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzqs extends GmsClient {
    private final com.google.android.gms.nearby.uwb.zze zze;
    private Long zzf;

    public zzqs(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings, com.google.android.gms.nearby.uwb.zze zzeVar) {
        super(context, looper, 298, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zze = zzeVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.uwb.internal.INearbyUwbService");
        return iInterfaceQueryLocalInterface instanceof zzos ? (zzos) iInterfaceQueryLocalInterface : new zzos(iBinder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        if (isConnected()) {
            try {
                ((zzos) getService()).zze(new zzob());
            } catch (RemoteException e) {
                Log.w("NearbyUwbClient", "Failed to notify client disconnect.", e);
            }
        }
        super.disconnect();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return new Feature[]{com.google.android.gms.nearby.zza.zzM, com.google.android.gms.nearby.zza.zzN, com.google.android.gms.nearby.zza.zzO};
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        if (this.zzf == null) {
            this.zzf = Long.valueOf(hashCode());
        }
        bundle.putLong("clientId", this.zzf.longValue());
        com.google.android.gms.nearby.uwb.zze zzeVar = this.zze;
        if (zzeVar != null) {
            bundle.putInt("deviceType", zzeVar.zza());
            bundle.putBoolean("isTestOnly", false);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 211600000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.nearby.uwb.internal.INearbyUwbService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.nearby.uwb.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final boolean getUseDynamicLookup() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresGooglePlayServices() {
        return Nearby.zza(getContext());
    }
}
