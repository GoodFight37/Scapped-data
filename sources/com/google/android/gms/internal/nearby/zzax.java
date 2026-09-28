package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.provider.Settings;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeyFileProvider;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.nearby.exposurenotification.ExposureInformation;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationStatus;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationStatusCodes;
import com.google.android.gms.nearby.exposurenotification.ExposureSummary;
import com.google.android.gms.nearby.exposurenotification.ExposureWindow;
import com.google.android.gms.nearby.exposurenotification.PackageConfiguration;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzax extends GoogleApi implements ExposureNotificationClient {
    public static final /* synthetic */ int zza = 0;
    private static final Api zzb = new Api("Nearby.EXPOSURE_NOTIFICATION_API", new zzap(), new Api.ClientKey());
    private static final long zzc = TimeUnit.MINUTES.toMillis(2);
    private static final long zzd = TimeUnit.MINUTES.toMillis(60);

    public zzax(Context context) {
        super(context, (Api<Api.ApiOptions>) zzb, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    private final Task zzb(final DiagnosisKeyFileProvider diagnosisKeyFileProvider, final ExposureConfiguration exposureConfiguration, final String str) {
        return zzfd.zza(doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzaf
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzax zzaxVar = this.zza;
                ExposureConfiguration exposureConfiguration2 = exposureConfiguration;
                DiagnosisKeyFileProvider diagnosisKeyFileProvider2 = diagnosisKeyFileProvider;
                String str2 = str;
                zzdr zzdrVar = (zzdr) ((zzn) obj).getService();
                zzed zzedVar = new zzed();
                zzedVar.zzb(exposureConfiguration2);
                zzedVar.zza(new zzat(zzaxVar, diagnosisKeyFileProvider2));
                zzedVar.zzd(new zzao((TaskCompletionSource) obj2));
                zzedVar.zze(str2);
                zzdrVar.zzo(zzedVar.zzf());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzo).build()), zzd);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final boolean deviceSupportsLocationlessScanning() {
        return Settings.Global.getInt(getApplicationContext().getContentResolver(), "bluetooth_sanitized_exposure_notification_supported", 0) == 1;
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Integer> getCalibrationConfidence() {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzz
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzak zzakVar = new zzak(this.zza, (TaskCompletionSource) obj2);
                zzdr zzdrVar = (zzdr) ((zzn) obj).getService();
                zzay zzayVar = new zzay();
                zzayVar.zza(zzakVar);
                zzdrVar.zzd(zzayVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzk).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<List<DailySummary>> getDailySummaries(final DailySummariesConfig dailySummariesConfig) {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzs
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzax zzaxVar = this.zza;
                DailySummariesConfig dailySummariesConfig2 = dailySummariesConfig;
                zzaj zzajVar = new zzaj(zzaxVar, (TaskCompletionSource) obj2);
                zzdr zzdrVar = (zzdr) ((zzn) obj).getService();
                zzbc zzbcVar = new zzbc();
                zzbcVar.zzb(zzajVar);
                zzbcVar.zza(dailySummariesConfig2);
                zzdrVar.zze(zzbcVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzl).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<DiagnosisKeysDataMapping> getDiagnosisKeysDataMapping() {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzab
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzal zzalVar = new zzal(this.zza, (TaskCompletionSource) obj2);
                zzdr zzdrVar = (zzdr) ((zzn) obj).getService();
                zzbg zzbgVar = new zzbg();
                zzbgVar.zza(zzalVar);
                zzdrVar.zzf(zzbgVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzn).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<List<ExposureInformation>> getExposureInformation(final String str) {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzaa
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzax zzaxVar = this.zza;
                String str2 = str;
                zzaw zzawVar = new zzaw(zzaxVar, (TaskCompletionSource) obj2);
                zzdr zzdrVar = (zzdr) ((zzn) obj).getService();
                zzbk zzbkVar = new zzbk();
                zzbkVar.zza(zzawVar);
                zzbkVar.zzb(str2);
                zzdrVar.zzg(zzbkVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzh).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<ExposureSummary> getExposureSummary(final String str) {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzad
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzax zzaxVar = this.zza;
                String str2 = str;
                zzav zzavVar = new zzav(zzaxVar, (TaskCompletionSource) obj2);
                zzdr zzdrVar = (zzdr) ((zzn) obj).getService();
                zzbo zzboVar = new zzbo();
                zzboVar.zza(zzavVar);
                zzboVar.zzb(str2);
                zzdrVar.zzh(zzboVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzh).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<List<ExposureWindow>> getExposureWindows() {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new zzac(this, ExposureNotificationClient.TOKEN_A)).setFeatures(com.google.android.gms.nearby.zza.zzh).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<PackageConfiguration> getPackageConfiguration() {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzag
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzan zzanVar = new zzan(this.zza, (TaskCompletionSource) obj2);
                zzdr zzdrVar = (zzdr) ((zzn) obj).getService();
                zzbw zzbwVar = new zzbw();
                zzbwVar.zza(zzanVar);
                zzdrVar.zzj(zzbwVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzp).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Set<ExposureNotificationStatus>> getStatus() {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzq
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzam zzamVar = new zzam(this.zza, (TaskCompletionSource) obj2);
                zzdr zzdrVar = (zzdr) ((zzn) obj).getService();
                zzca zzcaVar = new zzca();
                zzcaVar.zza(zzamVar);
                zzdrVar.zzk(zzcaVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzm).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<List<TemporaryExposureKey>> getTemporaryExposureKeyHistory() {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzae
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzar zzarVar = new zzar(this.zza, (TaskCompletionSource) obj2);
                zzdr zzdrVar = (zzdr) ((zzn) obj).getService();
                zzce zzceVar = new zzce();
                zzceVar.zza(zzarVar);
                zzdrVar.zzl(zzceVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzh).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Long> getVersion() {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new zzr(this)).setFeatures(com.google.android.gms.nearby.zza.zzj).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Boolean> isEnabled() {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzu
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzaq zzaqVar = new zzaq(this.zza, (TaskCompletionSource) obj2);
                zzdr zzdrVar = (zzdr) ((zzn) obj).getService();
                zzdz zzdzVar = new zzdz();
                zzdzVar.zza(zzaqVar);
                zzdrVar.zzn(zzdzVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzh).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Void> provideDiagnosisKeys(DiagnosisKeyFileProvider diagnosisKeyFileProvider) {
        return zzb(diagnosisKeyFileProvider, new ExposureConfiguration.ExposureConfigurationBuilder().build(), ExposureNotificationClient.TOKEN_A);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Void> requestPreAuthorizedTemporaryExposureKeyHistory() {
        return zzfd.zza(doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzy
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                int i = zzax.zza;
                zzdr zzdrVar = (zzdr) ((zzn) obj).getService();
                zzeh zzehVar = new zzeh();
                zzehVar.zza(false);
                zzehVar.zzb(new zzao((TaskCompletionSource) obj2));
                zzdrVar.zzp(zzehVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzq).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Void> requestPreAuthorizedTemporaryExposureKeyHistoryForSelfReport() {
        return zzfd.zza(doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzt
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                int i = zzax.zza;
                zzdr zzdrVar = (zzdr) ((zzn) obj).getService();
                zzeh zzehVar = new zzeh();
                zzehVar.zza(true);
                zzehVar.zzb(new zzao((TaskCompletionSource) obj2));
                zzdrVar.zzp(zzehVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzr).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Void> requestPreAuthorizedTemporaryExposureKeyRelease() {
        return zzfd.zza(doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzo
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                int i = zzax.zza;
                zzdr zzdrVar = (zzdr) ((zzn) obj).getService();
                zzel zzelVar = new zzel();
                zzelVar.zza(new zzao((TaskCompletionSource) obj2));
                zzdrVar.zzq(zzelVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzq).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Void> setDiagnosisKeysDataMapping(final DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        return zzfd.zza(doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzx
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                DiagnosisKeysDataMapping diagnosisKeysDataMapping2 = diagnosisKeysDataMapping;
                int i = zzax.zza;
                zzdr zzdrVar = (zzdr) ((zzn) obj).getService();
                zzep zzepVar = new zzep();
                zzepVar.zzb(new zzao((TaskCompletionSource) obj2));
                zzepVar.zza(diagnosisKeysDataMapping2);
                zzdrVar.zzr(zzepVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzn).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Void> start() {
        return zzfd.zza(doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzw
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                int i = zzax.zza;
                zzdr zzdrVar = (zzdr) ((zzn) obj).getService();
                zzet zzetVar = new zzet();
                zzetVar.zza(new zzao((TaskCompletionSource) obj2));
                zzdrVar.zzs(zzetVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzh).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Void> stop() {
        return zzfd.zza(doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzp
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                int i = zzax.zza;
                zzdr zzdrVar = (zzdr) ((zzn) obj).getService();
                zzex zzexVar = new zzex();
                zzexVar.zza(new zzao((TaskCompletionSource) obj2));
                zzdrVar.zzt(zzexVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzh).build()), zzc);
    }

    final /* synthetic */ Task zza(final List list, final ExposureConfiguration exposureConfiguration, final String str, Task task) throws Exception {
        return ((Long) task.getResult()).longValue() >= 17203704004L ? zzb(new DiagnosisKeyFileProvider(list), exposureConfiguration, str) : doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzah
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzax zzaxVar = this.zza;
                List list2 = list;
                ExposureConfiguration exposureConfiguration2 = exposureConfiguration;
                String str2 = str;
                zzn zznVar = (zzn) obj;
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                ArrayList arrayList = new ArrayList(list2.size());
                try {
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(ParcelFileDescriptor.open((File) it.next(), 268435456));
                    }
                    zzdr zzdrVar = (zzdr) zznVar.getService();
                    zzed zzedVar = new zzed();
                    zzedVar.zzc(arrayList);
                    zzedVar.zzb(exposureConfiguration2);
                    zzedVar.zzd(new zzas(zzaxVar, arrayList, taskCompletionSource));
                    zzedVar.zze(str2);
                    zzdrVar.zzo(zzedVar.zzf());
                } catch (FileNotFoundException e) {
                    TaskUtil.setResultOrApiException(new Status(ExposureNotificationStatusCodes.FAILED_DISK_IO, e.getMessage()), taskCompletionSource);
                }
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzh).build());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Void> provideDiagnosisKeys(List<File> list) {
        return zzfd.zza(zzfd.zza(doRead(TaskApiCall.builder().run(new zzr(this)).setFeatures(com.google.android.gms.nearby.zza.zzj).build()), zzc).continueWithTask(new zzv(this, list, new ExposureConfiguration.ExposureConfigurationBuilder().build(), ExposureNotificationClient.TOKEN_A)), zzd);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<List<ExposureWindow>> getExposureWindows(String str) {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new zzac(this, str)).setFeatures(com.google.android.gms.nearby.zza.zzh).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Void> provideDiagnosisKeys(List<File> list, ExposureConfiguration exposureConfiguration, String str) {
        return zzfd.zza(zzfd.zza(doRead(TaskApiCall.builder().run(new zzr(this)).setFeatures(com.google.android.gms.nearby.zza.zzj).build()), zzc).continueWithTask(new zzv(this, list, exposureConfiguration, str)), zzd);
    }
}
