package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.nearby.uwb.RangingCapabilities;
import com.google.android.gms.nearby.uwb.RangingParameters;
import com.google.android.gms.nearby.uwb.RangingSessionCallback;
import com.google.android.gms.nearby.uwb.UwbAddress;
import com.google.android.gms.nearby.uwb.UwbClient;
import com.google.android.gms.nearby.uwb.UwbComplexChannel;
import com.google.android.gms.nearby.uwb.UwbDevice;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzrs extends GoogleApi implements UwbClient {
    public static final /* synthetic */ int zza = 0;
    private static final Api zzb = new Api("Nearby.UWB_API", new zzrf(), new Api.ClientKey());

    public zzrs(Context context, com.google.android.gms.nearby.uwb.zze zzeVar) {
        super(context, (Api<com.google.android.gms.nearby.uwb.zze>) zzb, zzeVar, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<Void> addControlee(final UwbAddress uwbAddress) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzrc
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzrs zzrsVar = this.zza;
                UwbAddress uwbAddress2 = uwbAddress;
                zzos zzosVar = (zzos) ((zzqs) obj).getService();
                zznx zznxVar = new zznx();
                zzqo zzqoVar = new zzqo();
                zzqoVar.zza(uwbAddress2.getAddress());
                zznxVar.zza(zzqoVar.zzb());
                zznxVar.zzb(new zzrk(zzrsVar, (TaskCompletionSource) obj2));
                zzosVar.zzd(zznxVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzN).setMethodKey(1316).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<UwbComplexChannel> getComplexChannel() {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzrd
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzos zzosVar = (zzos) ((zzqs) obj).getService();
                zzod zzodVar = new zzod();
                zzodVar.zza(new zzrj(this.zza, (TaskCompletionSource) obj2));
                zzosVar.zzf(zzodVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzM).setMethodKey(1303).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<UwbAddress> getLocalAddress() {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzqy
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzos zzosVar = (zzos) ((zzqs) obj).getService();
                zzoh zzohVar = new zzoh();
                zzohVar.zza(new zzri(this.zza, (TaskCompletionSource) obj2));
                zzosVar.zzg(zzohVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzM).setMethodKey(1302).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<RangingCapabilities> getRangingCapabilities() {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzrb
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzos zzosVar = (zzos) ((zzqs) obj).getService();
                zzol zzolVar = new zzol();
                zzolVar.zza(new zzrh(this.zza, (TaskCompletionSource) obj2));
                zzosVar.zzh(zzolVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzM).setMethodKey(1301).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<Boolean> isAvailable() {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzqz
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzos zzosVar = (zzos) ((zzqs) obj).getService();
                zzpi zzpiVar = new zzpi();
                zzpiVar.zza(new zzrg(this.zza, (TaskCompletionSource) obj2));
                zzosVar.zzi(zzpiVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzM).setMethodKey(1300).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<Void> removeControlee(final UwbAddress uwbAddress) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzra
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzrs zzrsVar = this.zza;
                UwbAddress uwbAddress2 = uwbAddress;
                zzos zzosVar = (zzos) ((zzqs) obj).getService();
                zzqc zzqcVar = new zzqc();
                zzqo zzqoVar = new zzqo();
                zzqoVar.zza(uwbAddress2.getAddress());
                zzqcVar.zza(zzqoVar.zzb());
                zzqcVar.zzb(new zzrk(zzrsVar, (TaskCompletionSource) obj2));
                zzosVar.zzj(zzqcVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzO).setMethodKey(1317).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<Void> startRanging(final RangingParameters rangingParameters, RangingSessionCallback rangingSessionCallback) {
        final zzrr zzrrVar = new zzrr(this, rangingSessionCallback);
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzqx
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzrv[] zzrvVarArr;
                zzrs zzrsVar = this.zza;
                RangingParameters rangingParameters2 = rangingParameters;
                zzrr zzrrVar2 = zzrrVar;
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                zzos zzosVar = (zzos) ((zzqs) obj).getService();
                zzqg zzqgVar = new zzqg();
                zzpw zzpwVar = new zzpw();
                zzpwVar.zzd(rangingParameters2.getSessionId());
                zzpwVar.zzf(rangingParameters2.getUwbConfigId());
                zzpwVar.zzc(rangingParameters2.getRangingUpdateRate());
                int i = 0;
                if (rangingParameters2.getPeerDevices().isEmpty()) {
                    zzrvVarArr = new zzrv[0];
                } else {
                    zzrvVarArr = new zzrv[rangingParameters2.getPeerDevices().size()];
                    for (UwbDevice uwbDevice : rangingParameters2.getPeerDevices()) {
                        zzrt zzrtVar = new zzrt();
                        zzqo zzqoVar = new zzqo();
                        zzqoVar.zza(uwbDevice.getAddress().getAddress());
                        zzrtVar.zza(zzqoVar.zzb());
                        zzrvVarArr[i] = zzrtVar.zzb();
                        i++;
                    }
                }
                zzpwVar.zzb(zzrvVarArr);
                byte[] sessionKeyInfo = rangingParameters2.getSessionKeyInfo();
                if (sessionKeyInfo != null) {
                    zzpwVar.zze(sessionKeyInfo);
                }
                UwbComplexChannel complexChannel = rangingParameters2.getComplexChannel();
                if (complexChannel != null) {
                    zzqt zzqtVar = new zzqt();
                    zzqtVar.zza(complexChannel.getChannel());
                    zzqtVar.zzb(complexChannel.getPreambleIndex());
                    zzpwVar.zza(zzqtVar.zzc());
                }
                zzqgVar.zzb(zzpwVar.zzg());
                zzqgVar.zza(zzrrVar2);
                zzqgVar.zzc(new zzrk(zzrsVar, taskCompletionSource));
                zzosVar.zzk(zzqgVar.zzd());
            }
        }).setMethodKey(1304).setFeatures(com.google.android.gms.nearby.zza.zzM).build());
    }

    @Override // com.google.android.gms.nearby.uwb.UwbClient
    public final Task<Void> stopRanging(final RangingSessionCallback rangingSessionCallback) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzre
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzrs zzrsVar = this.zza;
                RangingSessionCallback rangingSessionCallback2 = rangingSessionCallback;
                zzos zzosVar = (zzos) ((zzqs) obj).getService();
                zzqk zzqkVar = new zzqk();
                zzqkVar.zza(new zzrk(zzrsVar, (TaskCompletionSource) obj2));
                zzosVar.zzl(zzqkVar.zzb());
                zzrsVar.doUnregisterEventListener(ListenerHolders.createListenerKey(rangingSessionCallback2, RangingSessionCallback.class.getName()), 1305);
            }
        }).setMethodKey(1305).setFeatures(com.google.android.gms.nearby.zza.zzM).build());
    }
}
