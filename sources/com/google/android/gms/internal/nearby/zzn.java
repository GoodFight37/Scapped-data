package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.nearby.Nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzn extends GmsClient {
    public zzn(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings) {
        super(context, looper, 236, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.INearbyExposureNotificationService");
        return iInterfaceQueryLocalInterface instanceof zzdr ? (zzdr) iInterfaceQueryLocalInterface : new zzdq(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return new Feature[]{com.google.android.gms.nearby.zza.zzh, com.google.android.gms.nearby.zza.zzi, com.google.android.gms.nearby.zza.zzj, com.google.android.gms.nearby.zza.zzk, com.google.android.gms.nearby.zza.zzl, com.google.android.gms.nearby.zza.zzn, com.google.android.gms.nearby.zza.zzm, com.google.android.gms.nearby.zza.zzo, com.google.android.gms.nearby.zza.zzp, com.google.android.gms.nearby.zza.zzq, com.google.android.gms.nearby.zza.zzr};
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 201516000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.nearby.exposurenotification.internal.INearbyExposureNotificationService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.nearby.exposurenotification.START";
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
