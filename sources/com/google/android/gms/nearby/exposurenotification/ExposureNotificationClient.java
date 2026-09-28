package com.google.android.gms.nearby.exposurenotification;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import java.io.File;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public interface ExposureNotificationClient extends HasApiKey<Api.ApiOptions.NoOptions> {
    public static final String ACTION_EXPOSURE_NOTIFICATION_SETTINGS = "com.google.android.gms.settings.EXPOSURE_NOTIFICATION_SETTINGS";
    public static final String ACTION_EXPOSURE_NOT_FOUND = "com.google.android.gms.exposurenotification.ACTION_EXPOSURE_NOT_FOUND";
    public static final String ACTION_EXPOSURE_STATE_UPDATED = "com.google.android.gms.exposurenotification.ACTION_EXPOSURE_STATE_UPDATED";
    public static final String ACTION_PRE_AUTHORIZE_RELEASE_PHONE_UNLOCKED = "com.google.android.gms.exposurenotification.ACTION_PRE_AUTHORIZE_RELEASE_PHONE_UNLOCKED";
    public static final String ACTION_SERVICE_STATE_UPDATED = "com.google.android.gms.exposurenotification.ACTION_SERVICE_STATE_UPDATED";

    @Deprecated
    public static final String EXTRA_EXPOSURE_SUMMARY = "com.google.android.gms.exposurenotification.EXTRA_EXPOSURE_SUMMARY";
    public static final String EXTRA_IS_FROM_PRE_AUTHORIZATION = "com.google.android.gms.exposurenotification.EXTRA_IS_FROM_PRE_AUTHORIZATION";
    public static final String EXTRA_SERVICE_STATE = "com.google.android.gms.exposurenotification.EXTRA_SERVICE_STATE";
    public static final String EXTRA_TEMPORARY_EXPOSURE_KEY_LIST = "com.google.android.gms.exposurenotification.EXTRA_TEMPORARY_EXPOSURE_KEY_LIST";

    @Deprecated
    public static final String EXTRA_TOKEN = "com.google.android.gms.exposurenotification.EXTRA_TOKEN";

    @Deprecated
    public static final String TOKEN_A = "TYZWQ32170AXEUVCDW7A";

    @Deprecated
    boolean deviceSupportsLocationlessScanning();

    Task<Integer> getCalibrationConfidence();

    Task<List<DailySummary>> getDailySummaries(DailySummariesConfig dailySummariesConfig);

    Task<DiagnosisKeysDataMapping> getDiagnosisKeysDataMapping();

    @Deprecated
    Task<List<ExposureInformation>> getExposureInformation(String str);

    @Deprecated
    Task<ExposureSummary> getExposureSummary(String str);

    Task<List<ExposureWindow>> getExposureWindows();

    @Deprecated
    Task<List<ExposureWindow>> getExposureWindows(String str);

    Task<PackageConfiguration> getPackageConfiguration();

    Task<Set<ExposureNotificationStatus>> getStatus();

    Task<List<TemporaryExposureKey>> getTemporaryExposureKeyHistory();

    Task<Long> getVersion();

    Task<Boolean> isEnabled();

    Task<Void> provideDiagnosisKeys(DiagnosisKeyFileProvider diagnosisKeyFileProvider);

    Task<Void> provideDiagnosisKeys(List<File> list);

    @Deprecated
    Task<Void> provideDiagnosisKeys(List<File> list, ExposureConfiguration exposureConfiguration, String str);

    Task<Void> requestPreAuthorizedTemporaryExposureKeyHistory();

    Task<Void> requestPreAuthorizedTemporaryExposureKeyHistoryForSelfReport();

    Task<Void> requestPreAuthorizedTemporaryExposureKeyRelease();

    Task<Void> setDiagnosisKeysDataMapping(DiagnosisKeysDataMapping diagnosisKeysDataMapping);

    Task<Void> start();

    Task<Void> stop();
}
