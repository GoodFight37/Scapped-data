package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.collection.ArraySet;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionOptions;
import com.google.android.gms.nearby.connection.ConnectionsOptions;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.Payload;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzgy extends GmsClient {
    private long zze;
    private final Set zzf;
    private final Set zzg;
    private final Set zzh;
    private final Set zzi;
    private final Set zzj;
    private zzlt zzk;

    protected zzgy(Context context, Looper looper, ClientSettings clientSettings, ConnectionsOptions connectionsOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 54, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzf = new ArraySet();
        this.zzg = new ArraySet();
        this.zzh = new ArraySet();
        this.zzi = new ArraySet();
        this.zzj = new ArraySet();
        zzmd.zzc(context.getCacheDir());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status zzG(int i) {
        return new Status(i, ConnectionsStatusCodes.getStatusCodeString(i));
    }

    private final void zzH() {
        Iterator it = this.zzf.iterator();
        while (it.hasNext()) {
            ((zzgg) it.next()).zze();
        }
        Iterator it2 = this.zzg.iterator();
        while (it2.hasNext()) {
            ((zzgk) it2.next()).zzf();
        }
        Iterator it3 = this.zzh.iterator();
        while (it3.hasNext()) {
            ((zzgk) it3.next()).zzf();
        }
        Iterator it4 = this.zzi.iterator();
        while (it4.hasNext()) {
            ((zzgk) it4.next()).zzf();
        }
        Iterator it5 = this.zzj.iterator();
        while (it5.hasNext()) {
            ((zzgk) it5.next()).zzf();
        }
        this.zzf.clear();
        this.zzg.clear();
        this.zzh.clear();
        this.zzi.clear();
        this.zzj.clear();
        zzlt zzltVar = this.zzk;
        if (zzltVar != null) {
            zzltVar.zzd();
            this.zzk = null;
        }
    }

    public static zzgy zzq(Context context, Looper looper, ClientSettings clientSettings, ConnectionsOptions connectionsOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzgy zzgyVar = new zzgy(context, looper, clientSettings, connectionsOptions, connectionCallbacks, onConnectionFailedListener);
        zzgyVar.zze = zzgyVar.hashCode();
        return zzgyVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        return iInterfaceQueryLocalInterface instanceof zzkd ? (zzkd) iInterfaceQueryLocalInterface : new zzkd(iBinder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        if (isConnected()) {
            try {
                ((zzkd) getService()).zzf(new zzfp());
            } catch (RemoteException e) {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", e);
            }
        }
        zzH();
        super.disconnect();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return new Feature[]{com.google.android.gms.nearby.zza.zzf, com.google.android.gms.nearby.zza.zzD, com.google.android.gms.nearby.zza.zzH, com.google.android.gms.nearby.zza.zzF, com.google.android.gms.nearby.zza.zzI, com.google.android.gms.nearby.zza.zzE, com.google.android.gms.nearby.zza.zzg, com.google.android.gms.nearby.zza.zzG};
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        bundle.putLong("clientId", this.zze);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* bridge */ /* synthetic */ void onConnectedLocked(IInterface iInterface) {
        super.onConnectedLocked((zzkd) iInterface);
        this.zzk = new zzlt();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionSuspended(int i) {
        if (i == 1) {
            zzH();
            i = 1;
        }
        super.onConnectionSuspended(i);
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
    public final void zzA(BaseImplementation.ResultHolder resultHolder, String str, String str2, ListenerHolder listenerHolder, AdvertisingOptions advertisingOptions) throws RemoteException {
        zzfx zzfxVar = new zzfx(listenerHolder);
        this.zzi.add(zzfxVar);
        zzkd zzkdVar = (zzkd) getService();
        zzmq zzmqVar = new zzmq();
        zzmqVar.zzg(new zzgx(resultHolder));
        zzmqVar.zze(str);
        zzmqVar.zzh(str2);
        zzmqVar.zzf(advertisingOptions);
        zzmqVar.zzb(zzfxVar);
        zzkdVar.zzk(zzmqVar.zzi());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzB(BaseImplementation.ResultHolder resultHolder, byte[] bArr, String str, ListenerHolder listenerHolder, AdvertisingOptions advertisingOptions) throws RemoteException {
        zzfx zzfxVar = new zzfx(listenerHolder);
        this.zzi.add(zzfxVar);
        zzkd zzkdVar = (zzkd) getService();
        zzmq zzmqVar = new zzmq();
        zzmqVar.zzg(new zzgx(resultHolder));
        zzmqVar.zzd(bArr);
        zzmqVar.zzh(str);
        zzmqVar.zzf(advertisingOptions);
        zzmqVar.zzb(zzfxVar);
        zzkdVar.zzk(zzmqVar.zzi());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzC(BaseImplementation.ResultHolder resultHolder, String str, ListenerHolder listenerHolder, DiscoveryOptions discoveryOptions) throws RemoteException {
        zzgg zzggVar = new zzgg(listenerHolder);
        this.zzf.add(zzggVar);
        zzkd zzkdVar = (zzkd) getService();
        zzmu zzmuVar = new zzmu();
        zzmuVar.zzd(new zzgv(resultHolder));
        zzmuVar.zze(str);
        zzmuVar.zzc(discoveryOptions);
        zzmuVar.zza(zzggVar);
        zzkdVar.zzl(zzmuVar.zzf());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzD() throws RemoteException {
        ((zzkd) getService()).zzm(new zzmy());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzE() throws RemoteException {
        ((zzkd) getService()).zzn(new zzna());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzF() throws RemoteException {
        ((zzkd) getService()).zzo(new zznc());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzr(BaseImplementation.ResultHolder resultHolder, String str, ListenerHolder listenerHolder) throws RemoteException {
        zzgu zzguVar = new zzgu(getContext(), listenerHolder, this.zzk);
        this.zzg.add(zzguVar);
        zzkd zzkdVar = (zzkd) getService();
        zzfh zzfhVar = new zzfh();
        zzfhVar.zze(new zzgv(resultHolder));
        zzfhVar.zzd(str);
        zzfhVar.zzc(zzguVar);
        zzkdVar.zzd(zzfhVar.zzf());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzs(BaseImplementation.ResultHolder resultHolder, long j) throws RemoteException {
        zzkd zzkdVar = (zzkd) getService();
        zzfl zzflVar = new zzfl();
        zzflVar.zzb(new zzgv(resultHolder));
        zzflVar.zza(j);
        zzkdVar.zze(zzflVar.zzc());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzt(String str) throws RemoteException {
        zzkd zzkdVar = (zzkd) getService();
        zzjj zzjjVar = new zzjj();
        zzjjVar.zza(str);
        zzkdVar.zzg(zzjjVar.zzb());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzu(BaseImplementation.ResultHolder resultHolder, String str) throws RemoteException {
        zzkd zzkdVar = (zzkd) getService();
        zzme zzmeVar = new zzme();
        zzmeVar.zzb(new zzgv(resultHolder));
        zzmeVar.zza(str);
        zzkdVar.zzh(zzmeVar.zzc());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzv(BaseImplementation.ResultHolder resultHolder, String str, String str2, ListenerHolder listenerHolder) throws RemoteException {
        zzfx zzfxVar = new zzfx(listenerHolder);
        this.zzi.add(zzfxVar);
        zzkd zzkdVar = (zzkd) getService();
        zzmi zzmiVar = new zzmi();
        zzmiVar.zzi(new zzgv(resultHolder));
        zzmiVar.zzf(str);
        zzmiVar.zzh(str2);
        zzmiVar.zzb(zzfxVar);
        zzkdVar.zzi(zzmiVar.zzj());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzw(BaseImplementation.ResultHolder resultHolder, byte[] bArr, String str, ListenerHolder listenerHolder) throws RemoteException {
        zzfx zzfxVar = new zzfx(listenerHolder);
        this.zzi.add(zzfxVar);
        zzkd zzkdVar = (zzkd) getService();
        zzmi zzmiVar = new zzmi();
        zzmiVar.zzi(new zzgv(resultHolder));
        zzmiVar.zzd(bArr);
        zzmiVar.zzh(str);
        zzmiVar.zzb(zzfxVar);
        zzkdVar.zzi(zzmiVar.zzj());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzx(BaseImplementation.ResultHolder resultHolder, String str, String str2, ListenerHolder listenerHolder, ConnectionOptions connectionOptions) throws RemoteException {
        zzfx zzfxVar = new zzfx(listenerHolder);
        this.zzi.add(zzfxVar);
        zzkd zzkdVar = (zzkd) getService();
        zzmi zzmiVar = new zzmi();
        zzmiVar.zzi(new zzgv(resultHolder));
        zzmiVar.zzf(str);
        zzmiVar.zzh(str2);
        zzmiVar.zzb(zzfxVar);
        zzmiVar.zzg(connectionOptions);
        zzkdVar.zzi(zzmiVar.zzj());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzy(BaseImplementation.ResultHolder resultHolder, byte[] bArr, String str, ListenerHolder listenerHolder, ConnectionOptions connectionOptions) throws RemoteException {
        zzfx zzfxVar = new zzfx(listenerHolder);
        this.zzi.add(zzfxVar);
        zzkd zzkdVar = (zzkd) getService();
        zzmi zzmiVar = new zzmi();
        zzmiVar.zzi(new zzgv(resultHolder));
        zzmiVar.zzd(bArr);
        zzmiVar.zzh(str);
        zzmiVar.zzb(zzfxVar);
        zzmiVar.zzg(connectionOptions);
        zzkdVar.zzi(zzmiVar.zzj());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzz(BaseImplementation.ResultHolder resultHolder, String[] strArr, Payload payload, boolean z) throws RemoteException {
        Pair pairCreate;
        try {
            int type = payload.getType();
            if (type == 1) {
                zzlz zzlzVar = new zzlz();
                zzlzVar.zzd(payload.getId());
                zzlzVar.zzm(payload.getType());
                byte[] bArrAsBytes = payload.asBytes();
                if (bArrAsBytes == null || bArrAsBytes.length <= 32768) {
                    zzlzVar.zza(bArrAsBytes);
                } else {
                    zzlv zzlvVar = new zzlv();
                    zzlvVar.zza(bArrAsBytes);
                    zzlzVar.zzk(zzlvVar.zzb());
                    zzlzVar.zza(Arrays.copyOf(bArrAsBytes, 32768));
                }
                pairCreate = Pair.create(zzlzVar.zzn(), zzsc.zzc());
            } else if (type == 2) {
                Payload.File fileAsFile = payload.asFile();
                zzsg.zzc(fileAsFile, "File cannot be null for Payload.Type.FILE");
                File fileAsJavaFile = fileAsFile.asJavaFile();
                String absolutePath = fileAsJavaFile == null ? null : fileAsJavaFile.getAbsolutePath();
                zzlz zzlzVar2 = new zzlz();
                zzlzVar2.zzd(payload.getId());
                zzlzVar2.zzm(payload.getType());
                zzlzVar2.zzb(fileAsFile.asParcelFileDescriptor());
                zzlzVar2.zzf(absolutePath);
                zzlzVar2.zzg(fileAsFile.getSize());
                zzlzVar2.zzh(payload.getOffset());
                zzlzVar2.zze(payload.zzf());
                zzlzVar2.zzj(0L);
                zzlzVar2.zzc(payload.zzd());
                zzlzVar2.zzi(payload.zze());
                pairCreate = Pair.create(zzlzVar2.zzn(), zzsc.zzc());
            } else {
                if (type != 3) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Outgoing Payload %d has unknown type %d", Long.valueOf(payload.getId()), Integer.valueOf(payload.getType())));
                    Log.wtf("NearbyConnections", "Unknown payload type!", illegalArgumentException);
                    throw illegalArgumentException;
                }
                try {
                    ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
                    ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe2 = ParcelFileDescriptor.createPipe();
                    zzlz zzlzVar3 = new zzlz();
                    zzlzVar3.zzd(payload.getId());
                    zzlzVar3.zzm(payload.getType());
                    zzlzVar3.zzb(parcelFileDescriptorArrCreatePipe[0]);
                    zzlzVar3.zzl(parcelFileDescriptorArrCreatePipe2[0]);
                    zzlzVar3.zzh(payload.getOffset());
                    zzlzVar3.zzj(0L);
                    pairCreate = Pair.create(zzlzVar3.zzn(), zzsc.zzd(Pair.create(parcelFileDescriptorArrCreatePipe[1], parcelFileDescriptorArrCreatePipe2[1])));
                } catch (IOException e) {
                    Log.e("NearbyConnections", String.format("Unable to create PFD pipe for streaming payload %d from client to service.", Long.valueOf(payload.getId())), e);
                    throw e;
                }
            }
            zzkd zzkdVar = (zzkd) getService();
            zzmm zzmmVar = new zzmm();
            zzmmVar.zzc(new zzgv(resultHolder));
            zzmmVar.zzb(strArr);
            zzmmVar.zza((zzmb) pairCreate.first);
            zzkdVar.zzj(zzmmVar.zzd());
            if (((zzsc) pairCreate.second).zzb()) {
                Object objZza = ((zzsc) pairCreate.second).zza();
                zzlt zzltVar = this.zzk;
                if (zzltVar != null) {
                    Pair pair = (Pair) objZza;
                    zzltVar.zzc(((Payload.Stream) Preconditions.checkNotNull(payload.asStream())).asInputStream(), new ParcelFileDescriptor.AutoCloseOutputStream((ParcelFileDescriptor) pair.first), new ParcelFileDescriptor.AutoCloseOutputStream((ParcelFileDescriptor) pair.second), (zzmb) pairCreate.first, payload.getId());
                }
            }
        } catch (IOException e2) {
            Log.w("NearbyConnectionsClient", "Failed to create a Parcelable Payload.", e2);
            resultHolder.setResult(zzG(ConnectionsStatusCodes.STATUS_PAYLOAD_IO_ERROR));
        }
    }
}
