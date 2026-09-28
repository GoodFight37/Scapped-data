package com.adjust.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatDelegate;
import com.adjust.sdk.network.ActivityPackageSender;
import com.adjust.sdk.network.UtilNetworking;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadExecutor;
import com.adjust.sdk.scheduler.TimerCycle;
import com.adjust.sdk.scheduler.TimerOnce;
import com.google.android.gms.location.LocationRequest;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler implements IActivityHandler, SystemLifecycle.SystemLifecycleCallback {
    private static final String ACTIVITY_STATE_NAME = "Activity state";
    private static final String ATTRIBUTION_NAME = "Attribution";
    private static long BACKGROUND_TIMER_INTERVAL = 0;
    private static final String BACKGROUND_TIMER_NAME = "Background timer";
    private static final String DELAY_START_TIMER_NAME = "Delay Start timer";
    private static long FOREGROUND_TIMER_INTERVAL = 0;
    private static final String FOREGROUND_TIMER_NAME = "Foreground timer";
    private static long FOREGROUND_TIMER_START = 0;
    private static final String GLOBAL_CALLBACK_PARAMETERS_NAME = "Global Callback parameters";
    private static final String GLOBAL_PARAMETERS_NAME = "Global parameters";
    private static final String GLOBAL_PARTNER_PARAMETERS_NAME = "Global Partner parameters";
    private static long SESSION_INTERVAL = 0;
    private static long SUBSESSION_INTERVAL = 0;
    private static final String TIME_TRAVEL = "Time travel!";
    private ActivityState activityState;
    private AdjustConfig adjustConfig;
    private AdjustAttribution attribution;
    private IAttributionHandler attributionHandler;
    private TimerOnce backgroundTimer;
    private String basePath;
    private ArrayList<OnAdidReadListener> cachedAdidReadCallbacks = new ArrayList<>();
    private ArrayList<OnAttributionReadListener> cachedAttributionReadCallbacks = new ArrayList<>();
    private OnDeeplinkResolvedListener cachedDeeplinkResolutionCallback;
    private DeviceInfo deviceInfo;
    private ThreadExecutor executor;
    private TimerCycle foregroundTimer;
    private String gdprPath;
    private GlobalParameters globalParameters;
    private InstallReferrer installReferrer;
    private InternalState internalState;
    private ILogger logger;
    private IPackageHandler packageHandler;
    private IPurchaseVerificationHandler purchaseVerificationHandler;
    private ISdkClickHandler sdkClickHandler;
    private String subscriptionPath;
    private SystemLifecycle systemLifecycle;

    public class InternalState {
        boolean enabled;
        boolean firstLaunch;
        boolean firstSdkStart;
        Boolean foregroundOrElseBackground;
        boolean offline;
        boolean preinstallHasBeenRead;
        boolean sessionResponseProcessed;

        public InternalState() {
        }

        public boolean hasFirstSdkStartNotOcurred() {
            return !this.firstSdkStart;
        }

        public boolean hasFirstSdkStartOcurred() {
            return this.firstSdkStart;
        }

        public boolean hasPreinstallBeenRead() {
            return this.preinstallHasBeenRead;
        }

        public boolean hasSessionResponseNotBeenProcessed() {
            return !this.sessionResponseProcessed;
        }

        public boolean isDisabled() {
            return !this.enabled;
        }

        public boolean isEnabled() {
            return this.enabled;
        }

        public boolean isFirstLaunch() {
            return this.firstLaunch;
        }

        public boolean isInBackground() {
            Boolean bool = this.foregroundOrElseBackground;
            return (bool == null || bool.booleanValue()) ? false : true;
        }

        public boolean isInForeground() {
            Boolean bool = this.foregroundOrElseBackground;
            return bool != null && bool.booleanValue();
        }

        public boolean isNotFirstLaunch() {
            return !this.firstLaunch;
        }

        public boolean isOffline() {
            return this.offline;
        }

        public boolean isOnline() {
            return !this.offline;
        }
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.sendReftagReferrerI();
        }
    }

    public class a0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnAttributionReadListener f6a;

        public a0(OnAttributionReadListener onAttributionReadListener) {
            this.f6a = onAttributionReadListener;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f6a.onAttributionRead(ActivityHandler.this.attribution);
        }
    }

    public class a1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f7a;
        public final /* synthetic */ long b;

        public a1(Uri uri, long j) {
            this.f7a = uri;
            this.b = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.processDeeplinkI(this.f7a, this.b);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.sendPreinstallReferrerI();
        }
    }

    public class b0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustPlayStorePurchase f9a;
        public final /* synthetic */ OnPurchaseVerificationFinishedListener b;

        public b0(AdjustPlayStorePurchase adjustPlayStorePurchase, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
            this.f9a = adjustPlayStorePurchase;
            this.b = onPurchaseVerificationFinishedListener;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.verifyPlayStorePurchaseI(this.f9a, this.b);
        }
    }

    public class b1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f10a;
        public final /* synthetic */ String b;

        public b1(ArrayList arrayList, String str) {
            this.f10a = arrayList;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            for (OnAdidReadListener onAdidReadListener : this.f10a) {
                if (onAdidReadListener != null) {
                    onAdidReadListener.onAdidRead(this.b);
                }
            }
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReferrerDetails f11a;
        public final /* synthetic */ String b;

        public c(ReferrerDetails referrerDetails, String str) {
            this.f11a = referrerDetails;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.sendInstallReferrerI(this.f11a, this.b);
        }
    }

    public class c0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustEvent f12a;
        public final /* synthetic */ OnPurchaseVerificationFinishedListener b;

        public c0(AdjustEvent adjustEvent, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
            this.f12a = adjustEvent;
            this.b = onPurchaseVerificationFinishedListener;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.verifyAndTrackPlayStorePurchaseI(this.f12a, this.b);
        }
    }

    public class c1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f13a;
        public final /* synthetic */ AdjustAttribution b;

        public c1(ArrayList arrayList, AdjustAttribution adjustAttribution) {
            this.f13a = arrayList;
            this.b = adjustAttribution;
        }

        @Override // java.lang.Runnable
        public final void run() {
            for (OnAttributionReadListener onAttributionReadListener : this.f13a) {
                if (onAttributionReadListener != null) {
                    onAttributionReadListener.onAttributionRead(this.b);
                }
            }
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EventResponseData f14a;

        public d(EventResponseData eventResponseData) {
            this.f14a = eventResponseData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.launchEventResponseTasksI(this.f14a);
        }
    }

    public class d0 implements IRunActivityHandler {
        public d0() {
        }

        @Override // com.adjust.sdk.IRunActivityHandler
        public final void run(ActivityHandler activityHandler) {
            activityHandler.setEnabledI(ActivityHandler.this.adjustConfig.startEnabled.booleanValue());
        }
    }

    public class d1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f16a;

        public d1(boolean z) {
            this.f16a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.setAskingAttributionI(this.f16a);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SdkClickResponseData f17a;

        public e(SdkClickResponseData sdkClickResponseData) {
            this.f17a = sdkClickResponseData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.launchSdkClickResponseTasksI(this.f17a);
        }
    }

    public class e0 implements Runnable {
        public e0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.foregroundTimerFired();
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SessionResponseData f19a;

        public f(SessionResponseData sessionResponseData) {
            this.f19a = sessionResponseData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.launchSessionResponseTasksI(this.f19a);
        }
    }

    public class f0 implements Runnable {
        public f0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.backgroundTimerFired();
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttributionResponseData f21a;

        public g(AttributionResponseData attributionResponseData) {
            this.f21a = attributionResponseData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.launchAttributionResponseTasksI(this.f21a);
        }
    }

    public class g0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f22a;

        public g0(boolean z) {
            this.f22a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.setOfflineModeI(this.f22a);
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PurchaseVerificationResponseData f23a;

        public h(PurchaseVerificationResponseData purchaseVerificationResponseData) {
            this.f23a = purchaseVerificationResponseData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.launchPurchaseVerificationResponseTasksI(this.f23a);
        }
    }

    public class h0 implements InstallReferrerReadListener {
        public h0() {
        }

        @Override // com.adjust.sdk.InstallReferrerReadListener
        public final void onFail(String str) {
            ActivityHandler.this.logger.debug(str, new Object[0]);
        }

        @Override // com.adjust.sdk.InstallReferrerReadListener
        public final void onInstallReferrerRead(ReferrerDetails referrerDetails, String str) {
            ActivityHandler.this.sendInstallReferrer(referrerDetails, str);
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f25a;
        public final /* synthetic */ String b;

        public i(String str, String str2) {
            this.f25a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.addGlobalCallbackParameterI(this.f25a, this.b);
        }
    }

    public class i0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f26a;
        public final /* synthetic */ AdjustAttribution b;

        public i0(ArrayList arrayList, AdjustAttribution adjustAttribution) {
            this.f26a = arrayList;
            this.b = adjustAttribution;
        }

        @Override // java.lang.Runnable
        public final void run() {
            for (OnAttributionReadListener onAttributionReadListener : this.f26a) {
                if (onAttributionReadListener != null) {
                    onAttributionReadListener.onAttributionRead(this.b);
                }
            }
        }
    }

    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f27a;
        public final /* synthetic */ String b;

        public j(String str, String str2) {
            this.f27a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.addGlobalPartnerParameterI(this.f27a, this.b);
        }
    }

    public class j0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f28a;
        public final /* synthetic */ String b;

        public j0(ArrayList arrayList, String str) {
            this.f28a = arrayList;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            for (OnAdidReadListener onAdidReadListener : this.f28a) {
                if (onAdidReadListener != null) {
                    onAdidReadListener.onAdidRead(this.b);
                }
            }
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustEvent f29a;

        public k(AdjustEvent adjustEvent) {
            this.f29a = adjustEvent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ActivityHandler.this.internalState.hasFirstSdkStartNotOcurred()) {
                ActivityHandler.this.logger.warn("Event tracked before first activity resumed.\nIf it was triggered in the Application class, it might timestamp or even send an install long before the user opens the app.\nPlease check https://github.com/adjust/android_sdk#can-i-trigger-an-event-at-application-launch for more information.", new Object[0]);
                ActivityHandler.this.startI();
            }
            ActivityHandler.this.trackEventI(this.f29a);
        }
    }

    public class k0 implements Runnable {
        public k0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ReferrerDetails metaReferrer = Reflection.getMetaReferrer(ActivityHandler.this.getContext(), ActivityHandler.this.adjustConfig.fbAppId, ActivityHandler.this.logger);
            if (metaReferrer != null) {
                ActivityHandler.this.sendInstallReferrer(metaReferrer, Constants.REFERRER_API_META);
            }
        }
    }

    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f31a;

        public l(String str) {
            this.f31a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.removeGlobalCallbackParameterI(this.f31a);
        }
    }

    public class l0 implements Runnable {
        public l0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ReferrerDetails huaweiAdsReferrer = Reflection.getHuaweiAdsReferrer(ActivityHandler.this.getContext(), ActivityHandler.this.logger);
            if (huaweiAdsReferrer != null) {
                ActivityHandler.this.sendInstallReferrer(huaweiAdsReferrer, Constants.REFERRER_API_HUAWEI_ADS);
            }
        }
    }

    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f33a;

        public m(String str) {
            this.f33a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.removeGlobalPartnerParameterI(this.f33a);
        }
    }

    public class m0 implements Runnable {
        public m0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ReferrerDetails huaweiAppGalleryReferrer = Reflection.getHuaweiAppGalleryReferrer(ActivityHandler.this.getContext(), ActivityHandler.this.logger);
            if (huaweiAppGalleryReferrer != null) {
                ActivityHandler.this.sendInstallReferrer(huaweiAppGalleryReferrer, Constants.REFERRER_API_HUAWEI_APP_GALLERY);
            }
        }
    }

    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.removeGlobalCallbackParametersI();
        }
    }

    public class n0 implements Runnable {
        public n0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ReferrerDetails samsungReferrer = Reflection.getSamsungReferrer(ActivityHandler.this.getContext(), ActivityHandler.this.logger);
            if (samsungReferrer != null) {
                ActivityHandler.this.sendInstallReferrer(samsungReferrer, Constants.REFERRER_API_SAMSUNG);
            }
        }
    }

    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.removeGlobalPartnerParametersI();
        }
    }

    public class o0 implements Runnable {
        public o0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ReferrerDetails xiaomiReferrer = Reflection.getXiaomiReferrer(ActivityHandler.this.getContext(), ActivityHandler.this.logger);
            if (xiaomiReferrer != null) {
                ActivityHandler.this.sendInstallReferrer(xiaomiReferrer, Constants.REFERRER_API_XIAOMI);
            }
        }
    }

    public class p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f39a;
        public final /* synthetic */ String b;

        public p(boolean z, String str) {
            this.f39a = z;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!this.f39a) {
                SharedPreferencesManager.getDefaultInstance(ActivityHandler.this.getContext()).savePushToken(this.b);
            }
            if (ActivityHandler.this.internalState.hasFirstSdkStartNotOcurred()) {
                return;
            }
            ActivityHandler.this.setPushTokenI(this.b);
        }
    }

    public class p0 implements Runnable {
        public p0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ReferrerDetails vivoReferrer = Reflection.getVivoReferrer(ActivityHandler.this.getContext(), ActivityHandler.this.logger);
            if (vivoReferrer != null) {
                ActivityHandler.this.sendInstallReferrer(vivoReferrer, Constants.REFERRER_API_VIVO);
            }
        }
    }

    public class q implements Runnable {
        public q() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.gdprForgetMeI();
        }
    }

    public class q0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EventResponseData f42a;

        public q0(EventResponseData eventResponseData) {
            this.f42a = eventResponseData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ActivityHandler.this.adjustConfig == null || ActivityHandler.this.adjustConfig.onEventTrackingSucceededListener == null) {
                return;
            }
            ActivityHandler.this.adjustConfig.onEventTrackingSucceededListener.onEventTrackingSucceeded(this.f42a.getSuccessResponseData());
        }
    }

    public class r implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustThirdPartySharing f43a;

        public r(AdjustThirdPartySharing adjustThirdPartySharing) {
            this.f43a = adjustThirdPartySharing;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.trackThirdPartySharingI(this.f43a);
        }
    }

    public class r0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnIsEnabledListener f44a;

        public r0(OnIsEnabledListener onIsEnabledListener) {
            this.f44a = onIsEnabledListener;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f44a.onIsEnabledRead(ActivityHandler.this.isEnabledI());
        }
    }

    public class s implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f45a;

        public s(boolean z) {
            this.f45a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.trackMeasurementConsentI(this.f45a);
        }
    }

    public class s0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EventResponseData f46a;

        public s0(EventResponseData eventResponseData) {
            this.f46a = eventResponseData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ActivityHandler.this.adjustConfig == null || ActivityHandler.this.adjustConfig.onEventTrackingFailedListener == null) {
                return;
            }
            ActivityHandler.this.adjustConfig.onEventTrackingFailedListener.onEventTrackingFailed(this.f46a.getFailureResponseData());
        }
    }

    public class t implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustAdRevenue f47a;

        public t(AdjustAdRevenue adjustAdRevenue) {
            this.f47a = adjustAdRevenue;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.trackAdRevenueI(this.f47a);
        }
    }

    public class t0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnDeeplinkResolvedListener f48a;
        public final /* synthetic */ SdkClickResponseData b;

        public t0(OnDeeplinkResolvedListener onDeeplinkResolvedListener, SdkClickResponseData sdkClickResponseData) {
            this.f48a = onDeeplinkResolvedListener;
            this.b = sdkClickResponseData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f48a.onDeeplinkResolved(this.b.resolvedDeeplink);
        }
    }

    public class u implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustPlayStoreSubscription f49a;

        public u(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
            this.f49a = adjustPlayStoreSubscription;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.trackPlayStoreSubscriptionI(this.f49a);
        }
    }

    public class u0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SessionResponseData f50a;

        public u0(SessionResponseData sessionResponseData) {
            this.f50a = sessionResponseData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ActivityHandler.this.adjustConfig == null || ActivityHandler.this.adjustConfig.onSessionTrackingSucceededListener == null) {
                return;
            }
            ActivityHandler.this.adjustConfig.onSessionTrackingSucceededListener.onSessionTrackingSucceeded(this.f50a.getSuccessResponseData());
        }
    }

    public class v implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f51a;

        public v(boolean z) {
            this.f51a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.setEnabledI(this.f51a);
        }
    }

    public class v0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SessionResponseData f52a;

        public v0(SessionResponseData sessionResponseData) {
            this.f52a = sessionResponseData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ActivityHandler.this.adjustConfig == null || ActivityHandler.this.adjustConfig.onSessionTrackingFailedListener == null) {
                return;
            }
            ActivityHandler.this.adjustConfig.onSessionTrackingFailedListener.onSessionTrackingFailed(this.f52a.getFailureResponseData());
        }
    }

    public class w implements Runnable {
        public w() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.gotOptOutResponseI();
        }
    }

    public class w0 implements Runnable {
        public w0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ActivityHandler.this.adjustConfig == null || ActivityHandler.this.adjustConfig.onAttributionChangedListener == null) {
                return;
            }
            ActivityHandler.this.adjustConfig.onAttributionChangedListener.onAttributionChanged(ActivityHandler.this.attribution);
        }
    }

    public class x implements Runnable {
        public x() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.foregroundTimerFiredI();
        }
    }

    public class x0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PurchaseVerificationResponseData f56a;
        public final /* synthetic */ AdjustPurchaseVerificationResult b;

        public x0(PurchaseVerificationResponseData purchaseVerificationResponseData, AdjustPurchaseVerificationResult adjustPurchaseVerificationResult) {
            this.f56a = purchaseVerificationResponseData;
            this.b = adjustPurchaseVerificationResult;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f56a.activityPackage.getPurchaseVerificationCallback().onVerificationFinished(this.b);
        }
    }

    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.backgroundTimerFiredI();
        }
    }

    public class y0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f58a;
        public final /* synthetic */ Intent b;

        public y0(Intent intent, Uri uri) {
            this.f58a = uri;
            this.b = intent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ActivityHandler.this.adjustConfig == null) {
                return;
            }
            if (ActivityHandler.this.adjustConfig.onDeferredDeeplinkResponseListener == null || ActivityHandler.this.adjustConfig.onDeferredDeeplinkResponseListener.launchReceivedDeeplink(this.f58a)) {
                ActivityHandler.this.launchDeeplinkMain(this.b, this.f58a);
            }
        }
    }

    public class z implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnAdidReadListener f59a;

        public z(OnAdidReadListener onAdidReadListener) {
            this.f59a = onAdidReadListener;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f59a.onAdidRead(ActivityHandler.this.activityState.adid);
        }
    }

    public class z0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f60a;
        public final /* synthetic */ long b;

        public z0(Uri uri, long j) {
            this.f60a = uri;
            this.b = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.processDeeplinkI(this.f60a, this.b);
        }
    }

    private ActivityHandler(AdjustConfig adjustConfig) {
        init(adjustConfig);
        ILogger logger = AdjustFactory.getLogger();
        this.logger = logger;
        logger.lockLogLevel();
        this.executor = new SingleThreadCachedScheduler("ActivityHandler");
        InternalState internalState = new InternalState();
        this.internalState = internalState;
        Boolean bool = adjustConfig.startEnabled;
        internalState.enabled = bool != null ? bool.booleanValue() : true;
        InternalState internalState2 = this.internalState;
        internalState2.offline = adjustConfig.startOffline;
        internalState2.sessionResponseProcessed = false;
        internalState2.firstSdkStart = false;
        internalState2.preinstallHasBeenRead = false;
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m69lambda$new$1$comadjustsdkActivityHandler();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void backgroundTimerFiredI() {
        if (toSendI()) {
            this.packageHandler.sendFirstPackage();
        }
    }

    private void bootstrapLifecycleI() {
        SystemLifecycle singletonInstance = SystemLifecycle.getSingletonInstance();
        this.systemLifecycle = singletonInstance;
        Iterator<String> it = singletonInstance.logMessageList.iterator();
        while (it.hasNext()) {
            this.logger.debug("Lifecycle: %s", it.next());
        }
        this.systemLifecycle.overwriteCallback(this);
        if (AdjustFactory.isSystemLifecycleBootstrapIgnored()) {
            return;
        }
        this.internalState.foregroundOrElseBackground = this.systemLifecycle.foregroundOrElseBackgroundCached();
        if (this.internalState.isInForeground()) {
            onResumeI();
        }
    }

    private boolean checkActivityStateI(ActivityState activityState) {
        if (!this.internalState.hasFirstSdkStartNotOcurred()) {
            return true;
        }
        this.logger.error("Sdk did not yet start", new Object[0]);
        return false;
    }

    private boolean checkAdjustAdRevenue(AdjustAdRevenue adjustAdRevenue) {
        if (adjustAdRevenue == null) {
            this.logger.error("Ad revenue object missing", new Object[0]);
            return false;
        }
        if (adjustAdRevenue.isValid()) {
            return true;
        }
        this.logger.error("Ad revenue object not initialized correctly", new Object[0]);
        return false;
    }

    private void checkAfterNewStartI() {
        checkAfterNewStartI(SharedPreferencesManager.getDefaultInstance(getContext()));
    }

    private void checkAttributionStateI() {
        if (checkActivityStateI(this.activityState)) {
            if (this.internalState.isFirstLaunch() && this.internalState.hasSessionResponseNotBeenProcessed()) {
                return;
            }
            if (this.attribution == null || this.activityState.askingAttribution) {
                this.attributionHandler.getAttribution();
            }
        }
    }

    private boolean checkEventI(AdjustEvent adjustEvent) {
        if (adjustEvent == null) {
            this.logger.error("Event missing", new Object[0]);
            return false;
        }
        if (adjustEvent.isValid()) {
            return true;
        }
        this.logger.error("Event not initialized correctly", new Object[0]);
        return false;
    }

    private void checkForInstallReferrerInfo(SdkClickResponseData sdkClickResponseData) {
        if (sdkClickResponseData.isInstallReferrer) {
            String str = sdkClickResponseData.referrerApi;
            if (str == null || !str.equalsIgnoreCase(Constants.REFERRER_API_HUAWEI_ADS)) {
                String str2 = sdkClickResponseData.referrerApi;
                if (str2 == null || !str2.equalsIgnoreCase(Constants.REFERRER_API_HUAWEI_APP_GALLERY)) {
                    String str3 = sdkClickResponseData.referrerApi;
                    if (str3 == null || !str3.equalsIgnoreCase(Constants.REFERRER_API_META)) {
                        String str4 = sdkClickResponseData.referrerApi;
                        if (str4 == null || !str4.equalsIgnoreCase(Constants.REFERRER_API_SAMSUNG)) {
                            String str5 = sdkClickResponseData.referrerApi;
                            if (str5 == null || !str5.equalsIgnoreCase(Constants.REFERRER_API_XIAOMI)) {
                                String str6 = sdkClickResponseData.referrerApi;
                                if (str6 == null || !str6.equalsIgnoreCase(Constants.REFERRER_API_VIVO)) {
                                    ActivityState activityState = this.activityState;
                                    activityState.clickTime = sdkClickResponseData.clickTime;
                                    activityState.installBegin = sdkClickResponseData.installBegin;
                                    activityState.installReferrer = sdkClickResponseData.installReferrer;
                                    activityState.clickTimeServer = sdkClickResponseData.clickTimeServer;
                                    activityState.installBeginServer = sdkClickResponseData.installBeginServer;
                                    activityState.installVersion = sdkClickResponseData.installVersion;
                                    activityState.googlePlayInstant = sdkClickResponseData.googlePlayInstant;
                                } else {
                                    ActivityState activityState2 = this.activityState;
                                    activityState2.clickTimeVivo = sdkClickResponseData.clickTime;
                                    activityState2.installBeginVivo = sdkClickResponseData.installBegin;
                                    activityState2.installReferrerVivo = sdkClickResponseData.installReferrer;
                                    activityState2.installVersionVivo = sdkClickResponseData.installVersion;
                                }
                            } else {
                                ActivityState activityState3 = this.activityState;
                                activityState3.clickTimeXiaomi = sdkClickResponseData.clickTime;
                                activityState3.installBeginXiaomi = sdkClickResponseData.installBegin;
                                activityState3.installReferrerXiaomi = sdkClickResponseData.installReferrer;
                                activityState3.clickTimeServerXiaomi = sdkClickResponseData.clickTimeServer;
                                activityState3.installBeginServerXiaomi = sdkClickResponseData.installBeginServer;
                                activityState3.installVersionXiaomi = sdkClickResponseData.installVersion;
                            }
                        } else {
                            ActivityState activityState4 = this.activityState;
                            activityState4.clickTimeSamsung = sdkClickResponseData.clickTime;
                            activityState4.installBeginSamsung = sdkClickResponseData.installBegin;
                            activityState4.installReferrerSamsung = sdkClickResponseData.installReferrer;
                        }
                    } else {
                        ActivityState activityState5 = this.activityState;
                        activityState5.clickTimeMeta = sdkClickResponseData.clickTime;
                        activityState5.installReferrerMeta = sdkClickResponseData.installReferrer;
                        activityState5.isClickMeta = sdkClickResponseData.isClick;
                    }
                } else {
                    ActivityState activityState6 = this.activityState;
                    activityState6.clickTimeHuawei = sdkClickResponseData.clickTime;
                    activityState6.installBeginHuawei = sdkClickResponseData.installBegin;
                    activityState6.installReferrerHuaweiAppGallery = sdkClickResponseData.installReferrer;
                }
            } else {
                ActivityState activityState7 = this.activityState;
                activityState7.clickTimeHuawei = sdkClickResponseData.clickTime;
                activityState7.installBeginHuawei = sdkClickResponseData.installBegin;
                activityState7.installReferrerHuawei = sdkClickResponseData.installReferrer;
            }
            writeActivityStateI();
        }
    }

    private void checkForPreinstallI() {
        ActivityState activityState = this.activityState;
        if (activityState == null || !activityState.enabled || activityState.isGdprForgotten) {
            return;
        }
        sendPreinstallReferrerI();
        if (this.adjustConfig.isPreinstallTrackingEnabled && !this.internalState.hasPreinstallBeenRead()) {
            String str = this.deviceInfo.packageName;
            if (str == null || str.isEmpty()) {
                this.logger.debug("Can't read preinstall payload, invalid package name", new Object[0]);
                return;
            }
            SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(getContext());
            long preinstallPayloadReadStatus = defaultInstance.getPreinstallPayloadReadStatus();
            if (PreinstallUtil.hasAllLocationsBeenRead(preinstallPayloadReadStatus)) {
                this.internalState.preinstallHasBeenRead = true;
                return;
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.SYSTEM_PROPERTIES, preinstallPayloadReadStatus)) {
                String payloadFromSystemProperty = PreinstallUtil.getPayloadFromSystemProperty(this.deviceInfo.packageName, this.logger);
                if (payloadFromSystemProperty == null || payloadFromSystemProperty.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.SYSTEM_PROPERTIES, preinstallPayloadReadStatus);
                } else {
                    this.sdkClickHandler.sendPreinstallPayload(payloadFromSystemProperty, Constants.SYSTEM_PROPERTIES);
                }
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.SYSTEM_PROPERTIES_REFLECTION, preinstallPayloadReadStatus)) {
                String payloadFromSystemPropertyReflection = PreinstallUtil.getPayloadFromSystemPropertyReflection(this.deviceInfo.packageName, this.logger);
                if (payloadFromSystemPropertyReflection == null || payloadFromSystemPropertyReflection.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.SYSTEM_PROPERTIES_REFLECTION, preinstallPayloadReadStatus);
                } else {
                    this.sdkClickHandler.sendPreinstallPayload(payloadFromSystemPropertyReflection, Constants.SYSTEM_PROPERTIES_REFLECTION);
                }
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.SYSTEM_PROPERTIES_PATH, preinstallPayloadReadStatus)) {
                String payloadFromSystemPropertyFilePath = PreinstallUtil.getPayloadFromSystemPropertyFilePath(this.deviceInfo.packageName, this.logger);
                if (payloadFromSystemPropertyFilePath == null || payloadFromSystemPropertyFilePath.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.SYSTEM_PROPERTIES_PATH, preinstallPayloadReadStatus);
                } else {
                    this.sdkClickHandler.sendPreinstallPayload(payloadFromSystemPropertyFilePath, Constants.SYSTEM_PROPERTIES_PATH);
                }
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.SYSTEM_PROPERTIES_PATH_REFLECTION, preinstallPayloadReadStatus)) {
                String payloadFromSystemPropertyFilePathReflection = PreinstallUtil.getPayloadFromSystemPropertyFilePathReflection(this.deviceInfo.packageName, this.logger);
                if (payloadFromSystemPropertyFilePathReflection == null || payloadFromSystemPropertyFilePathReflection.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.SYSTEM_PROPERTIES_PATH_REFLECTION, preinstallPayloadReadStatus);
                } else {
                    this.sdkClickHandler.sendPreinstallPayload(payloadFromSystemPropertyFilePathReflection, Constants.SYSTEM_PROPERTIES_PATH_REFLECTION);
                }
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.CONTENT_PROVIDER, preinstallPayloadReadStatus)) {
                String payloadFromContentProviderDefault = PreinstallUtil.getPayloadFromContentProviderDefault(this.adjustConfig.context, this.deviceInfo.packageName, this.logger);
                if (payloadFromContentProviderDefault == null || payloadFromContentProviderDefault.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.CONTENT_PROVIDER, preinstallPayloadReadStatus);
                } else {
                    this.sdkClickHandler.sendPreinstallPayload(payloadFromContentProviderDefault, Constants.CONTENT_PROVIDER);
                }
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.CONTENT_PROVIDER_INTENT_ACTION, preinstallPayloadReadStatus)) {
                List<String> payloadsFromContentProviderIntentAction = PreinstallUtil.getPayloadsFromContentProviderIntentAction(this.adjustConfig.context, this.deviceInfo.packageName, this.logger);
                if (payloadsFromContentProviderIntentAction == null || payloadsFromContentProviderIntentAction.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.CONTENT_PROVIDER_INTENT_ACTION, preinstallPayloadReadStatus);
                } else {
                    Iterator<String> it = payloadsFromContentProviderIntentAction.iterator();
                    while (it.hasNext()) {
                        this.sdkClickHandler.sendPreinstallPayload(it.next(), Constants.CONTENT_PROVIDER_INTENT_ACTION);
                    }
                }
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.CONTENT_PROVIDER_NO_PERMISSION, preinstallPayloadReadStatus)) {
                List<String> payloadsFromContentProviderNoPermission = PreinstallUtil.getPayloadsFromContentProviderNoPermission(this.adjustConfig.context, this.deviceInfo.packageName, this.logger);
                if (payloadsFromContentProviderNoPermission == null || payloadsFromContentProviderNoPermission.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.CONTENT_PROVIDER_NO_PERMISSION, preinstallPayloadReadStatus);
                } else {
                    Iterator<String> it2 = payloadsFromContentProviderNoPermission.iterator();
                    while (it2.hasNext()) {
                        this.sdkClickHandler.sendPreinstallPayload(it2.next(), Constants.CONTENT_PROVIDER_NO_PERMISSION);
                    }
                }
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.FILE_SYSTEM, preinstallPayloadReadStatus)) {
                String payloadFromFileSystem = PreinstallUtil.getPayloadFromFileSystem(this.deviceInfo.packageName, this.adjustConfig.preinstallFilePath, this.logger);
                if (payloadFromFileSystem == null || payloadFromFileSystem.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.FILE_SYSTEM, preinstallPayloadReadStatus);
                } else {
                    this.sdkClickHandler.sendPreinstallPayload(payloadFromFileSystem, Constants.FILE_SYSTEM);
                }
            }
            defaultInstance.setPreinstallPayloadReadStatus(preinstallPayloadReadStatus);
            this.internalState.preinstallHasBeenRead = true;
        }
    }

    private Intent createDeeplinkIntentI(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setFlags(268435456);
        intent.setPackage(this.adjustConfig.context.getPackageName());
        return intent;
    }

    public static boolean deleteActivityState(Context context) {
        return context.deleteFile(Constants.ACTIVITY_STATE_FILENAME);
    }

    public static boolean deleteAttribution(Context context) {
        return context.deleteFile(Constants.ATTRIBUTION_FILENAME);
    }

    public static boolean deleteGlobalCallbackParameters(Context context) {
        return context.deleteFile(Constants.GLOBAL_CALLBACK_PARAMETERS_FILENAME);
    }

    public static boolean deleteGlobalPartnerParameters(Context context) {
        return context.deleteFile(Constants.GLOBAL_PARTNER_PARAMETERS_FILENAME);
    }

    public static void deleteState(Context context) {
        deleteActivityState(context);
        deleteAttribution(context);
        deleteGlobalCallbackParameters(context);
        deleteGlobalPartnerParameters(context);
        SharedPreferencesManager.getDefaultInstance(context).clear();
    }

    private void disableThirdPartySharingForCoppaEnabledI() {
        if (shouldDisableThirdPartySharingWhenCoppaEnabled()) {
            this.activityState.isThirdPartySharingDisabledForCoppa = true;
            writeActivityStateI();
            this.packageHandler.addPackage(new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.globalParameters, System.currentTimeMillis()).buildThirdPartySharingPackage(new AdjustThirdPartySharing(Boolean.FALSE)));
            this.packageHandler.sendFirstPackage();
        }
    }

    private void endI() {
        if (!toSendI()) {
            pauseSendingI();
        }
        if (updateActivityStateI(System.currentTimeMillis())) {
            writeActivityStateI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void foregroundTimerFiredI() {
        if (!isEnabledI()) {
            stopForegroundTimerI();
            return;
        }
        if (toSendI()) {
            this.packageHandler.sendFirstPackage();
        }
        if (updateActivityStateI(System.currentTimeMillis())) {
            writeActivityStateI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gdprForgetMeI() {
        if (checkActivityStateI(this.activityState) && isEnabledI()) {
            ActivityState activityState = this.activityState;
            if (activityState.isGdprForgotten) {
                return;
            }
            activityState.isGdprForgotten = true;
            writeActivityStateI();
            PackageBuilder packageBuilder = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.globalParameters, System.currentTimeMillis());
            packageBuilder.internalState = this.internalState;
            this.packageHandler.addPackage(packageBuilder.buildGdprPackage());
            SharedPreferencesManager.getDefaultInstance(getContext()).removeGdprForgetMe();
            this.packageHandler.sendFirstPackage();
        }
    }

    public static ActivityHandler getInstance(AdjustConfig adjustConfig) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (adjustConfig == null) {
            AdjustFactory.getLogger().error("AdjustConfig missing", new Object[0]);
            return null;
        }
        if (!adjustConfig.isValid()) {
            AdjustFactory.getLogger().error("AdjustConfig not initialized correctly", new Object[0]);
            return null;
        }
        if (adjustConfig.processName != null) {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) adjustConfig.context.getSystemService("activity");
            if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return null;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    if (runningAppProcessInfo.processName.equalsIgnoreCase(adjustConfig.processName)) {
                        break;
                    }
                    AdjustFactory.getLogger().info("Skipping initialization in background process (%s)", runningAppProcessInfo.processName);
                    return null;
                }
            }
        }
        return new ActivityHandler(adjustConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotOptOutResponseI() {
        this.activityState.isGdprForgotten = true;
        writeActivityStateI();
        this.packageHandler.flush();
        setEnabledI(false);
    }

    private void handleAdidCallbackI() {
        ActivityState activityState;
        this.cachedAdidReadCallbacks.addAll(this.adjustConfig.cachedAdidReadCallbacks);
        this.adjustConfig.cachedAdidReadCallbacks.clear();
        if (this.cachedAdidReadCallbacks.isEmpty() || (activityState = this.activityState) == null || activityState.adid == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.cachedAdidReadCallbacks);
        String str = this.activityState.adid;
        this.cachedAdidReadCallbacks.clear();
        new Handler(this.adjustConfig.context.getMainLooper()).post(new j0(arrayList, str));
    }

    private void handleAttributionCallbackI() {
        this.cachedAttributionReadCallbacks.addAll(this.adjustConfig.cachedAttributionReadCallbacks);
        this.adjustConfig.cachedAttributionReadCallbacks.clear();
        if (this.cachedAttributionReadCallbacks.isEmpty() || this.attribution == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.cachedAttributionReadCallbacks);
        AdjustAttribution adjustAttribution = this.attribution;
        this.cachedAttributionReadCallbacks.clear();
        new Handler(this.adjustConfig.context.getMainLooper()).post(new i0(arrayList, adjustAttribution));
    }

    private boolean hasChangedStateI(boolean z2, boolean z3, String str, String str2) {
        if (z2 != z3) {
            return true;
        }
        if (z2) {
            this.logger.debug(str, new Object[0]);
        } else {
            this.logger.debug(str2, new Object[0]);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initI, reason: merged with bridge method [inline-methods] */
    public void m69lambda$new$1$comadjustsdkActivityHandler() {
        String pushToken;
        SESSION_INTERVAL = AdjustFactory.getSessionInterval();
        SUBSESSION_INTERVAL = AdjustFactory.getSubsessionInterval();
        FOREGROUND_TIMER_INTERVAL = AdjustFactory.getTimerInterval();
        FOREGROUND_TIMER_START = AdjustFactory.getTimerStart();
        BACKGROUND_TIMER_INTERVAL = AdjustFactory.getTimerInterval();
        readAttributionI(this.adjustConfig.context);
        readActivityStateI(this.adjustConfig.context);
        this.globalParameters = new GlobalParameters();
        readGlobalCallbackParametersI(this.adjustConfig.context);
        readGlobalPartnerParametersI(this.adjustConfig.context);
        ActivityState activityState = this.activityState;
        if (activityState != null) {
            activityState.setEventDeduplicationIdsMaxSize(this.adjustConfig.getEventDeduplicationIdsMaxSize());
        }
        AdjustConfig adjustConfig = this.adjustConfig;
        if (adjustConfig.startEnabled != null) {
            adjustConfig.preLaunchActions.preLaunchActionsArray.add(new d0());
        }
        if (this.internalState.hasFirstSdkStartOcurred()) {
            InternalState internalState = this.internalState;
            internalState.enabled = this.activityState.enabled;
            internalState.firstLaunch = false;
        } else {
            this.internalState.firstLaunch = true;
        }
        readConfigFile(this.adjustConfig.context);
        DeviceInfo deviceInfo = new DeviceInfo(this.adjustConfig);
        this.deviceInfo = deviceInfo;
        deviceInfo.reloadPlayIds(this.adjustConfig);
        if (this.deviceInfo.playAdId == null) {
            if (Util.canReadPlayIds(this.adjustConfig)) {
                this.logger.warn("Unable to get Google Play Services Advertising ID at start time", new Object[0]);
            } else {
                this.logger.info("Cannot read Google Play Services Advertising ID with COPPA or play store kids app enabled", new Object[0]);
            }
            if (this.deviceInfo.androidId == null) {
                if (Util.canReadNonPlayIds(this.adjustConfig)) {
                    this.logger.error("Unable to get any Device IDs. Please check if Proguard is correctly set with Adjust SDK", new Object[0]);
                } else {
                    this.logger.info("Cannot read non Play IDs with COPPA or play store kids app enabled", new Object[0]);
                }
            }
        } else {
            this.logger.info("Google Play Services Advertising ID read correctly at start time", new Object[0]);
        }
        String str = this.adjustConfig.defaultTracker;
        if (str != null) {
            this.logger.info("Default tracker: '%s'", str);
        }
        String str2 = this.adjustConfig.pushToken;
        if (str2 != null) {
            this.logger.info("Push token: '%s'", str2);
            if (this.internalState.hasFirstSdkStartOcurred()) {
                setPushToken(this.adjustConfig.pushToken, false);
            } else {
                SharedPreferencesManager.getDefaultInstance(getContext()).savePushToken(this.adjustConfig.pushToken);
            }
        } else if (this.internalState.hasFirstSdkStartOcurred() && (pushToken = SharedPreferencesManager.getDefaultInstance(getContext()).getPushToken()) != null) {
            setPushToken(pushToken, true);
        }
        if (this.cachedDeeplinkResolutionCallback == null) {
            this.cachedDeeplinkResolutionCallback = this.adjustConfig.cachedDeeplinkResolutionCallback;
        }
        handleAdidCallbackI();
        handleAttributionCallbackI();
        if (this.internalState.hasFirstSdkStartOcurred() && SharedPreferencesManager.getDefaultInstance(getContext()).getGdprForgetMe()) {
            gdprForgetMe();
        }
        this.foregroundTimer = new TimerCycle(new e0(), FOREGROUND_TIMER_START, FOREGROUND_TIMER_INTERVAL, FOREGROUND_TIMER_NAME);
        if (this.adjustConfig.isSendingInBackgroundEnabled) {
            this.logger.info("Send in background configured", new Object[0]);
            this.backgroundTimer = new TimerOnce(new f0(), BACKGROUND_TIMER_NAME);
        }
        AdjustConfig adjustConfig2 = this.adjustConfig;
        this.packageHandler = AdjustFactory.getPackageHandler(this, this.adjustConfig.context, toSendI(false), new ActivityPackageSender(adjustConfig2.urlStrategyDomains, adjustConfig2.useSubdomains, adjustConfig2.basePath, adjustConfig2.gdprPath, adjustConfig2.subscriptionPath, adjustConfig2.purchaseVerificationPath, this.deviceInfo.clientSdk, adjustConfig2.context));
        AdjustConfig adjustConfig3 = this.adjustConfig;
        this.attributionHandler = AdjustFactory.getAttributionHandler(this, toSendI(false), new ActivityPackageSender(adjustConfig3.urlStrategyDomains, adjustConfig3.useSubdomains, adjustConfig3.basePath, adjustConfig3.gdprPath, adjustConfig3.subscriptionPath, adjustConfig3.purchaseVerificationPath, this.deviceInfo.clientSdk, adjustConfig3.context));
        AdjustConfig adjustConfig4 = this.adjustConfig;
        this.sdkClickHandler = AdjustFactory.getSdkClickHandler(this, toSendI(true), new ActivityPackageSender(adjustConfig4.urlStrategyDomains, adjustConfig4.useSubdomains, adjustConfig4.basePath, adjustConfig4.gdprPath, adjustConfig4.subscriptionPath, adjustConfig4.purchaseVerificationPath, this.deviceInfo.clientSdk, adjustConfig4.context));
        AdjustConfig adjustConfig5 = this.adjustConfig;
        this.purchaseVerificationHandler = AdjustFactory.getPurchaseVerificationHandler(this, toSendI(true), new ActivityPackageSender(adjustConfig5.urlStrategyDomains, adjustConfig5.useSubdomains, adjustConfig5.basePath, adjustConfig5.gdprPath, adjustConfig5.subscriptionPath, adjustConfig5.purchaseVerificationPath, this.deviceInfo.clientSdk, adjustConfig5.context));
        this.installReferrer = new InstallReferrer(this.adjustConfig.context, new h0());
        preLaunchActionsI(this.adjustConfig.preLaunchActions.preLaunchActionsArray);
        sendReftagReferrerI();
        bootstrapLifecycleI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isEnabledI() {
        ActivityState activityState = this.activityState;
        return activityState != null ? activityState.enabled : this.internalState.isEnabled();
    }

    private boolean isValidReferrerDetails(ReferrerDetails referrerDetails) {
        String str;
        return (referrerDetails == null || (str = referrerDetails.installReferrer) == null || str.length() == 0) ? false : true;
    }

    private void launchAttributionListenerI(Handler handler) {
        if (this.adjustConfig.onAttributionChangedListener == null) {
            return;
        }
        handler.post(new w0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchAttributionResponseTasksI(AttributionResponseData attributionResponseData) {
        updateAdidI(attributionResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        if (updateAttributionI(attributionResponseData.attribution)) {
            launchAttributionListenerI(handler);
        }
        prepareDeeplinkI(attributionResponseData.deeplink, handler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchDeeplinkMain(Intent intent, Uri uri) {
        if (this.adjustConfig.context.getPackageManager().queryIntentActivities(intent, 0).size() <= 0) {
            this.logger.error("Unable to open deferred deeplink (%s)", uri);
        } else {
            this.logger.info("Open deferred deeplink (%s)", uri);
            this.adjustConfig.context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchEventResponseTasksI(EventResponseData eventResponseData) {
        Runnable s0Var;
        updateAdidI(eventResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        boolean z2 = eventResponseData.success;
        if (z2 && this.adjustConfig.onEventTrackingSucceededListener != null) {
            this.logger.debug("Launching success event tracking listener", new Object[0]);
            s0Var = new q0(eventResponseData);
        } else {
            if (z2 || this.adjustConfig.onEventTrackingFailedListener == null) {
                return;
            }
            this.logger.debug("Launching failed event tracking listener", new Object[0]);
            s0Var = new s0(eventResponseData);
        }
        handler.post(s0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchPurchaseVerificationResponseTasksI(PurchaseVerificationResponseData purchaseVerificationResponseData) {
        AdjustEvent adjustEvent;
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        JSONObject jSONObject = purchaseVerificationResponseData.jsonResponse;
        handler.post(new x0(purchaseVerificationResponseData, jSONObject == null ? new AdjustPurchaseVerificationResult("not_verified", 101, purchaseVerificationResponseData.message) : new AdjustPurchaseVerificationResult(UtilNetworking.extractJsonString(jSONObject, "verification_status"), UtilNetworking.extractJsonInt(jSONObject, "code"), UtilNetworking.extractJsonString(jSONObject, MapperConstants.NPF_ERROR_FIELD_MESSAGE))));
        ActivityPackage activityPackage = purchaseVerificationResponseData.activityPackage;
        if (activityPackage == null || (adjustEvent = activityPackage.event) == null) {
            return;
        }
        trackEventI(adjustEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchSdkClickResponseTasksI(SdkClickResponseData sdkClickResponseData) {
        updateAdidI(sdkClickResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        if (updateAttributionI(sdkClickResponseData.attribution)) {
            launchAttributionListenerI(handler);
        }
        if (TextUtils.isEmpty(sdkClickResponseData.resolvedDeeplink)) {
            return;
        }
        OnDeeplinkResolvedListener onDeeplinkResolvedListener = this.cachedDeeplinkResolutionCallback;
        this.cachedDeeplinkResolutionCallback = null;
        if (onDeeplinkResolvedListener != null) {
            handler.post(new t0(onDeeplinkResolvedListener, sdkClickResponseData));
        }
    }

    private void launchSessionResponseListenerI(SessionResponseData sessionResponseData, Handler handler) {
        Runnable v0Var;
        boolean z2 = sessionResponseData.success;
        if (z2 && this.adjustConfig.onSessionTrackingSucceededListener != null) {
            this.logger.debug("Launching success session tracking listener", new Object[0]);
            v0Var = new u0(sessionResponseData);
        } else {
            if (z2 || this.adjustConfig.onSessionTrackingFailedListener == null) {
                return;
            }
            this.logger.debug("Launching failed session tracking listener", new Object[0]);
            v0Var = new v0(sessionResponseData);
        }
        handler.post(v0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchSessionResponseTasksI(SessionResponseData sessionResponseData) {
        this.logger.debug("Launching SessionResponse tasks", new Object[0]);
        updateAdidI(sessionResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        if (updateAttributionI(sessionResponseData.attribution)) {
            launchAttributionListenerI(handler);
        }
        if (this.attribution == null && !this.activityState.askingAttribution) {
            this.attributionHandler.getAttribution();
        }
        if (sessionResponseData.success) {
            SharedPreferencesManager.getDefaultInstance(getContext()).setInstallTracked();
        }
        launchSessionResponseListenerI(sessionResponseData, handler);
        this.internalState.sessionResponseProcessed = true;
    }

    private void pauseSendingI() {
        this.attributionHandler.pauseSending();
        this.packageHandler.pauseSending();
        if (toSendI(true)) {
            this.sdkClickHandler.resumeSending();
            this.purchaseVerificationHandler.resumeSending();
        } else {
            this.sdkClickHandler.pauseSending();
            this.purchaseVerificationHandler.pauseSending();
        }
    }

    private boolean pausedI() {
        return pausedI(false);
    }

    private void preLaunchActionsI(List<IRunActivityHandler> list) {
        if (list == null) {
            return;
        }
        Iterator<IRunActivityHandler> it = list.iterator();
        while (it.hasNext()) {
            it.next().run(this);
        }
    }

    private void prepareDeeplinkI(Uri uri, Handler handler) {
        if (uri == null) {
            return;
        }
        this.logger.info("Deferred deeplink received (%s)", uri);
        handler.post(new y0(createDeeplinkIntentI(uri), uri));
    }

    private void processCachedDeeplinkI() {
        if (checkActivityStateI(this.activityState)) {
            SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(getContext());
            String deeplinkUrl = defaultInstance.getDeeplinkUrl();
            long deeplinkClickTime = defaultInstance.getDeeplinkClickTime();
            if (deeplinkUrl == null || deeplinkClickTime == -1) {
                return;
            }
            processDeeplink(Uri.parse(deeplinkUrl), deeplinkClickTime);
            defaultInstance.removeDeeplink();
        }
    }

    private void processCoppaComplianceI() {
        if (this.adjustConfig.coppaComplianceEnabled) {
            disableThirdPartySharingForCoppaEnabledI();
        } else {
            resetThirdPartySharingCoppaActivityStateI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDeeplinkI(Uri uri, long j2) {
        if (isEnabledI()) {
            if (Util.isUrlFilteredOut(uri)) {
                this.logger.debug("Deeplink (" + uri.toString() + ") processing skipped", new Object[0]);
                return;
            }
            ActivityPackage activityPackageBuildDeeplinkSdkClickPackage = PackageFactory.buildDeeplinkSdkClickPackage(uri, j2, this.activityState, this.adjustConfig, this.deviceInfo, this.globalParameters, this.internalState);
            if (activityPackageBuildDeeplinkSdkClickPackage == null) {
                return;
            }
            this.sdkClickHandler.sendSdkClick(activityPackageBuildDeeplinkSdkClickPackage);
        }
    }

    private void processSessionI() {
        if (this.activityState.isGdprForgotten) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ActivityState activityState = this.activityState;
        long j2 = jCurrentTimeMillis - activityState.lastActivity;
        if (j2 < 0) {
            this.logger.error(TIME_TRAVEL, new Object[0]);
            this.activityState.lastActivity = jCurrentTimeMillis;
            writeActivityStateI();
            return;
        }
        if (j2 > SESSION_INTERVAL) {
            trackNewSessionI(jCurrentTimeMillis);
            checkAfterNewStartI();
            return;
        }
        if (j2 <= SUBSESSION_INTERVAL) {
            this.logger.verbose("Time span since last activity too short for a new subsession", new Object[0]);
            return;
        }
        int i2 = activityState.subsessionCount + 1;
        activityState.subsessionCount = i2;
        activityState.sessionLength += j2;
        activityState.lastActivity = jCurrentTimeMillis;
        this.logger.verbose("Started subsession %d of session %d", Integer.valueOf(i2), Integer.valueOf(this.activityState.sessionCount));
        writeActivityStateI();
        checkForPreinstallI();
        this.installReferrer.startConnection();
        readInstallReferrerMeta();
        readInstallReferrerHuaweiAds();
        readInstallReferrerHuaweiAppGallery();
        readInstallReferrerSamsung();
        readInstallReferrerXiaomi();
        readInstallReferrerVivo();
    }

    private void readActivityStateI(Context context) {
        try {
            this.activityState = (ActivityState) Util.readObject(context, Constants.ACTIVITY_STATE_FILENAME, ACTIVITY_STATE_NAME, ActivityState.class);
        } catch (Exception e2) {
            this.logger.error("Failed to read %s file (%s)", ACTIVITY_STATE_NAME, e2.getMessage());
            this.activityState = null;
        }
        if (this.activityState != null) {
            this.internalState.firstSdkStart = true;
        }
    }

    private void readAttributionI(Context context) {
        try {
            this.attribution = (AdjustAttribution) Util.readObject(context, Constants.ATTRIBUTION_FILENAME, ATTRIBUTION_NAME, AdjustAttribution.class);
        } catch (Exception e2) {
            this.logger.error("Failed to read %s file (%s)", ATTRIBUTION_NAME, e2.getMessage());
            this.attribution = null;
        }
    }

    private void readConfigFile(Context context) {
        try {
            InputStream inputStreamOpen = context.getAssets().open("adjust_config.properties");
            Properties properties = new Properties();
            properties.load(inputStreamOpen);
            this.logger.verbose("adjust_config.properties file read and loaded", new Object[0]);
            String property = properties.getProperty("defaultTracker");
            if (property != null) {
                this.adjustConfig.defaultTracker = property;
            }
        } catch (Exception e2) {
            this.logger.debug("%s file not found in this app", e2.getMessage());
        }
    }

    private void readGlobalCallbackParametersI(Context context) {
        try {
            this.globalParameters.callbackParameters = (Map) Util.readObject(context, Constants.GLOBAL_CALLBACK_PARAMETERS_FILENAME, GLOBAL_CALLBACK_PARAMETERS_NAME, Map.class);
        } catch (Exception e2) {
            this.logger.error("Failed to read %s file (%s)", GLOBAL_CALLBACK_PARAMETERS_NAME, e2.getMessage());
            this.globalParameters.callbackParameters = null;
        }
    }

    private void readGlobalPartnerParametersI(Context context) {
        try {
            this.globalParameters.partnerParameters = (Map) Util.readObject(context, Constants.GLOBAL_PARTNER_PARAMETERS_FILENAME, GLOBAL_PARTNER_PARAMETERS_NAME, Map.class);
        } catch (Exception e2) {
            this.logger.error("Failed to read %s file (%s)", GLOBAL_PARTNER_PARAMETERS_NAME, e2.getMessage());
            this.globalParameters.partnerParameters = null;
        }
    }

    private void readInstallReferrerHuaweiAds() {
        this.executor.submit(new l0());
    }

    private void readInstallReferrerHuaweiAppGallery() {
        this.executor.submit(new m0());
    }

    private void readInstallReferrerMeta() {
        this.executor.submit(new k0());
    }

    private void readInstallReferrerSamsung() {
        this.executor.submit(new n0());
    }

    private void readInstallReferrerVivo() {
        this.executor.submit(new p0());
    }

    private void readInstallReferrerXiaomi() {
        this.executor.submit(new o0());
    }

    private void resetThirdPartySharingCoppaActivityStateI() {
        ActivityState activityState = this.activityState;
        if (activityState != null && activityState.isThirdPartySharingDisabledForCoppa) {
            activityState.isThirdPartySharingDisabledForCoppa = false;
            writeActivityStateI();
        }
    }

    private void resumeSendingI() {
        this.attributionHandler.resumeSending();
        this.packageHandler.resumeSending();
        this.sdkClickHandler.resumeSending();
        this.purchaseVerificationHandler.resumeSending();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendInstallReferrerI(ReferrerDetails referrerDetails, String str) {
        if (isEnabledI() && isValidReferrerDetails(referrerDetails) && !Util.isEqualReferrerDetails(referrerDetails, str, this.activityState)) {
            this.sdkClickHandler.sendSdkClick(PackageFactory.buildInstallReferrerSdkClickPackage(referrerDetails, str, this.activityState, this.adjustConfig, this.deviceInfo, this.globalParameters, this.internalState));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendPreinstallReferrerI() {
        String preinstallReferrer;
        if (!isEnabledI() || this.internalState.hasFirstSdkStartNotOcurred() || (preinstallReferrer = SharedPreferencesManager.getDefaultInstance(getContext()).getPreinstallReferrer()) == null || preinstallReferrer.isEmpty()) {
            return;
        }
        this.sdkClickHandler.sendPreinstallPayload(preinstallReferrer, Constants.SYSTEM_INSTALLER_REFERRER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendReftagReferrerI() {
        if (isEnabledI() && !this.internalState.hasFirstSdkStartNotOcurred()) {
            this.sdkClickHandler.sendReftagReferrers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAskingAttributionI(boolean z2) {
        this.activityState.askingAttribution = z2;
        writeActivityStateI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnabledI(boolean z2) {
        ActivityState activityState;
        if (hasChangedStateI(isEnabledI(), z2, "Adjust already enabled", "Adjust already disabled")) {
            if (z2 && (activityState = this.activityState) != null && activityState.isGdprForgotten) {
                this.logger.error("Re-enabling SDK not possible for forgotten user", new Object[0]);
                return;
            }
            InternalState internalState = this.internalState;
            internalState.enabled = z2;
            if (internalState.hasFirstSdkStartNotOcurred()) {
                updateStatusI(!z2, "Handlers will start as paused due to the SDK being disabled", "Handlers will still start as paused", "Handlers will start as active due to the SDK being enabled");
                return;
            }
            this.activityState.enabled = z2;
            writeActivityStateI();
            if (z2) {
                SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(getContext());
                if (defaultInstance.getGdprForgetMe()) {
                    gdprForgetMeI();
                } else {
                    processCoppaComplianceI();
                    Iterator<AdjustThirdPartySharing> it = this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray.iterator();
                    while (it.hasNext()) {
                        trackThirdPartySharingI(it.next());
                    }
                    Boolean bool = this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked;
                    if (bool != null) {
                        trackMeasurementConsentI(bool.booleanValue());
                    }
                    this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray = new ArrayList();
                    this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked = null;
                }
                if (!defaultInstance.getInstallTracked()) {
                    this.logger.debug("Detected that install was not tracked at enable time", new Object[0]);
                    trackNewSessionI(System.currentTimeMillis());
                }
                checkAfterNewStartI(defaultInstance);
            }
            updateStatusI(!z2, "Pausing handlers due to SDK being disabled", "Handlers remain paused", "Resuming handlers due to SDK being enabled");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOfflineModeI(boolean z2) {
        String str;
        String str2;
        String str3;
        if (hasChangedStateI(this.internalState.isOffline(), z2, "Adjust already in offline mode", "Adjust already in online mode")) {
            InternalState internalState = this.internalState;
            internalState.offline = z2;
            if (internalState.hasFirstSdkStartNotOcurred()) {
                str = "Handlers will still start as paused";
                str2 = "Handlers will start as active due to SDK being online";
                str3 = "Handlers will start paused due to SDK being offline";
            } else {
                str = "Handlers remain paused";
                str2 = "Resuming handlers to put SDK in online mode";
                str3 = "Pausing handlers to put SDK offline mode";
            }
            updateStatusI(z2, str3, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPushTokenI(String str) {
        if (checkActivityStateI(this.activityState) && isEnabledI()) {
            ActivityState activityState = this.activityState;
            if (activityState.isGdprForgotten || str == null || str.equals(activityState.pushToken)) {
                return;
            }
            this.activityState.pushToken = str;
            writeActivityStateI();
            PackageBuilder packageBuilder = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.globalParameters, System.currentTimeMillis());
            packageBuilder.internalState = this.internalState;
            this.packageHandler.addPackage(packageBuilder.buildInfoPackage(Constants.PUSH));
            SharedPreferencesManager.getDefaultInstance(getContext()).removePushToken();
            this.packageHandler.sendFirstPackage();
        }
    }

    private boolean shouldDisableThirdPartySharingWhenCoppaEnabled() {
        if (this.activityState == null || !isEnabledI()) {
            return false;
        }
        ActivityState activityState = this.activityState;
        if (activityState.isGdprForgotten) {
            return false;
        }
        return !activityState.isThirdPartySharingDisabledForCoppa;
    }

    private boolean shouldProcessEventI(String str) {
        if (str != null && !str.isEmpty()) {
            if (this.activityState.eventDeduplicationIdExists(str)) {
                this.logger.info("Skipping duplicate event with deduplication ID '%s'", str);
                return false;
            }
            this.activityState.addDeduplicationId(str);
            this.logger.verbose("Added deduplication ID '%s'", str);
        }
        return true;
    }

    private void startBackgroundTimerI() {
        if (this.backgroundTimer != null && toSendI() && this.backgroundTimer.getFireIn() <= 0) {
            this.backgroundTimer.startIn(BACKGROUND_TIMER_INTERVAL);
        }
    }

    private void startFirstSessionI() {
        ActivityState activityState = new ActivityState();
        this.activityState = activityState;
        this.internalState.firstSdkStart = true;
        activityState.setEventDeduplicationIdsMaxSize(this.adjustConfig.getEventDeduplicationIdsMaxSize());
        updateHandlersStatusAndSendI();
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(getContext());
        this.activityState.pushToken = defaultInstance.getPushToken();
        if (this.internalState.isEnabled()) {
            if (defaultInstance.getGdprForgetMe()) {
                gdprForgetMeI();
            } else {
                processCoppaComplianceI();
                Iterator<AdjustThirdPartySharing> it = this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray.iterator();
                while (it.hasNext()) {
                    trackThirdPartySharingI(it.next());
                }
                Boolean bool = this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked;
                if (bool != null) {
                    trackMeasurementConsentI(bool.booleanValue());
                }
                this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray = new ArrayList();
                this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked = null;
                this.activityState.sessionCount = 1;
                transferSessionPackageI(jCurrentTimeMillis);
                checkAfterNewStartI(defaultInstance);
            }
        }
        this.activityState.resetSessionAttributes(jCurrentTimeMillis);
        this.activityState.enabled = this.internalState.isEnabled();
        writeActivityStateI();
        defaultInstance.removePushToken();
        defaultInstance.removeGdprForgetMe();
        processCachedDeeplinkI();
    }

    private void startForegroundTimerI() {
        if (isEnabledI()) {
            this.foregroundTimer.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startI() {
        if (this.internalState.hasFirstSdkStartNotOcurred()) {
            AdjustSigner.onResume(this.adjustConfig.logger);
            startFirstSessionI();
            return;
        }
        Iterator<AdjustThirdPartySharing> it = this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray.iterator();
        while (it.hasNext()) {
            trackThirdPartySharingI(it.next());
        }
        Boolean bool = this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked;
        if (bool != null) {
            trackMeasurementConsentI(bool.booleanValue());
        }
        this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray = new ArrayList();
        AdjustConfig adjustConfig = this.adjustConfig;
        adjustConfig.preLaunchActions.lastMeasurementConsentTracked = null;
        if (this.activityState.enabled) {
            AdjustSigner.onResume(adjustConfig.logger);
            updateHandlersStatusAndSendI();
            processCoppaComplianceI();
            processSessionI();
            checkAttributionStateI();
            processCachedDeeplinkI();
        }
    }

    private void stopBackgroundTimerI() {
        TimerOnce timerOnce = this.backgroundTimer;
        if (timerOnce == null) {
            return;
        }
        timerOnce.cancel();
    }

    private void stopForegroundTimerI() {
        this.foregroundTimer.suspend();
    }

    private void teardownActivityStateS() {
        synchronized (ActivityState.class) {
            if (this.activityState == null) {
                return;
            }
            this.activityState = null;
        }
    }

    private void teardownAllGlobalParametersS() {
        synchronized (GlobalParameters.class) {
            if (this.globalParameters == null) {
                return;
            }
            this.globalParameters = null;
        }
    }

    private void teardownAttributionS() {
        synchronized (AdjustAttribution.class) {
            if (this.attribution == null) {
                return;
            }
            this.attribution = null;
        }
    }

    private boolean toSendI() {
        return toSendI(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackAdRevenueI(AdjustAdRevenue adjustAdRevenue) {
        if (checkActivityStateI(this.activityState) && isEnabledI() && checkAdjustAdRevenue(adjustAdRevenue) && !this.activityState.isGdprForgotten) {
            PackageBuilder packageBuilder = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.globalParameters, System.currentTimeMillis());
            packageBuilder.internalState = this.internalState;
            this.packageHandler.addPackage(packageBuilder.buildAdRevenuePackage(adjustAdRevenue));
            this.packageHandler.sendFirstPackage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackEventI(AdjustEvent adjustEvent) {
        if (checkActivityStateI(this.activityState) && isEnabledI() && checkEventI(adjustEvent) && !this.activityState.isGdprForgotten && shouldProcessEventI(adjustEvent.deduplicationId)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.activityState.eventCount++;
            updateActivityStateI(jCurrentTimeMillis);
            PackageBuilder packageBuilder = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.globalParameters, jCurrentTimeMillis);
            packageBuilder.internalState = this.internalState;
            this.packageHandler.addPackage(packageBuilder.buildEventPackage(adjustEvent));
            this.packageHandler.sendFirstPackage();
            if (this.adjustConfig.isSendingInBackgroundEnabled && this.internalState.isInBackground()) {
                startBackgroundTimerI();
            }
            writeActivityStateI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackMeasurementConsentI(boolean z2) {
        if (!checkActivityStateI(this.activityState)) {
            this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked = Boolean.valueOf(z2);
        } else if (isEnabledI() && !this.activityState.isGdprForgotten) {
            PackageBuilder packageBuilder = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.globalParameters, System.currentTimeMillis());
            packageBuilder.internalState = this.internalState;
            this.packageHandler.addPackage(packageBuilder.buildMeasurementConsentPackage(z2));
            this.packageHandler.sendFirstPackage();
        }
    }

    private void trackNewSessionI(long j2) {
        ActivityState activityState = this.activityState;
        long j3 = j2 - activityState.lastActivity;
        activityState.sessionCount++;
        activityState.lastInterval = j3;
        transferSessionPackageI(j2);
        this.activityState.resetSessionAttributes(j2);
        writeActivityStateI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackPlayStoreSubscriptionI(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        if (checkActivityStateI(this.activityState) && isEnabledI() && !this.activityState.isGdprForgotten) {
            PackageBuilder packageBuilder = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.globalParameters, System.currentTimeMillis());
            packageBuilder.internalState = this.internalState;
            this.packageHandler.addPackage(packageBuilder.buildSubscriptionPackage(adjustPlayStoreSubscription));
            this.packageHandler.sendFirstPackage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackThirdPartySharingI(AdjustThirdPartySharing adjustThirdPartySharing) {
        if (!checkActivityStateI(this.activityState)) {
            this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray.add(adjustThirdPartySharing);
            return;
        }
        if (isEnabledI() && !this.activityState.isGdprForgotten) {
            if (this.adjustConfig.coppaComplianceEnabled) {
                this.logger.warn("Calling third party sharing API not allowed when COPPA enabled", new Object[0]);
                return;
            }
            PackageBuilder packageBuilder = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.globalParameters, System.currentTimeMillis());
            packageBuilder.internalState = this.internalState;
            this.packageHandler.addPackage(packageBuilder.buildThirdPartySharingPackage(adjustThirdPartySharing));
            this.packageHandler.sendFirstPackage();
        }
    }

    private void transferSessionPackageI(long j2) {
        PackageBuilder packageBuilder = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.globalParameters, j2);
        packageBuilder.internalState = this.internalState;
        this.packageHandler.addPackage(packageBuilder.buildSessionPackage());
        this.packageHandler.sendFirstPackage();
    }

    private boolean updateActivityStateI(long j2) {
        if (!checkActivityStateI(this.activityState)) {
            return false;
        }
        ActivityState activityState = this.activityState;
        long j3 = j2 - activityState.lastActivity;
        if (j3 > SESSION_INTERVAL) {
            return false;
        }
        activityState.lastActivity = j2;
        if (j3 < 0) {
            this.logger.error(TIME_TRAVEL, new Object[0]);
            return true;
        }
        activityState.sessionLength += j3;
        activityState.timeSpent += j3;
        return true;
    }

    private void updateAdidI(String str) {
        if (str == null) {
            return;
        }
        if (!str.equals(this.activityState.adid)) {
            this.activityState.adid = str;
            writeActivityStateI();
        }
        if (this.cachedAdidReadCallbacks.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.cachedAdidReadCallbacks);
        this.cachedAdidReadCallbacks.clear();
        new Handler(this.adjustConfig.context.getMainLooper()).post(new b1(arrayList, str));
    }

    private void updateHandlersStatusAndSendI() {
        if (!toSendI()) {
            pauseSendingI();
        } else {
            resumeSendingI();
            this.packageHandler.sendFirstPackage();
        }
    }

    private void updateStatusI(boolean z2, String str, String str2, String str3) {
        if (z2) {
            this.logger.info(str, new Object[0]);
        } else if (!pausedI(false)) {
            this.logger.info(str3, new Object[0]);
        } else if (pausedI(true)) {
            this.logger.info(str2, new Object[0]);
        } else {
            this.logger.info(str2 + ", except the Sdk Click Handler", new Object[0]);
        }
        updateHandlersStatusAndSendI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verifyAndTrackPlayStorePurchaseI(AdjustEvent adjustEvent, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
        if (onPurchaseVerificationFinishedListener == null) {
            this.logger.warn("Purchase verification aborted because verification callback is null", new Object[0]);
            return;
        }
        if (this.adjustConfig.isDataResidency) {
            this.logger.warn("Purchase verification not available for data residency users right now", new Object[0]);
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, "Purchase verification not available for data residency users right now"));
            return;
        }
        if (!checkActivityStateI(this.activityState)) {
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 102, "Purchase verification aborted because SDK is still not initialized"));
            this.logger.warn("Purchase verification aborted because SDK is still not initialized", new Object[0]);
            return;
        }
        if (!isEnabledI()) {
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 103, "Purchase verification aborted because SDK is disabled"));
            this.logger.warn("Purchase verification aborted because SDK is disabled", new Object[0]);
            return;
        }
        if (this.activityState.isGdprForgotten) {
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 104, "Purchase verification aborted because user is GDPR forgotten"));
            this.logger.warn("Purchase verification aborted because user is GDPR forgotten", new Object[0]);
            return;
        }
        if (adjustEvent == null) {
            this.logger.warn("Purchase verification aborted because event instance is null", new Object[0]);
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 106, "Purchase verification aborted because event instance is null"));
            return;
        }
        ActivityPackage activityPackageBuildVerificationPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.globalParameters, System.currentTimeMillis()).buildVerificationPackage(adjustEvent, onPurchaseVerificationFinishedListener);
        if (activityPackageBuildVerificationPackage == null) {
            this.logger.warn("Purchase verification aborted because verification package is null", new Object[0]);
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 107, "Purchase verification aborted because verification package is null"));
        } else {
            activityPackageBuildVerificationPackage.event = adjustEvent;
            this.purchaseVerificationHandler.sendPurchaseVerificationPackage(activityPackageBuildVerificationPackage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verifyPlayStorePurchaseI(AdjustPlayStorePurchase adjustPlayStorePurchase, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
        if (onPurchaseVerificationFinishedListener == null) {
            this.logger.warn("Purchase verification aborted because verification callback is null", new Object[0]);
            return;
        }
        if (this.adjustConfig.isDataResidency) {
            this.logger.warn("Purchase verification not available for data residency users right now", new Object[0]);
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, "Purchase verification not available for data residency users right now"));
            return;
        }
        if (!checkActivityStateI(this.activityState)) {
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 102, "Purchase verification aborted because SDK is still not initialized"));
            this.logger.warn("Purchase verification aborted because SDK is still not initialized", new Object[0]);
            return;
        }
        if (!isEnabledI()) {
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 103, "Purchase verification aborted because SDK is disabled"));
            this.logger.warn("Purchase verification aborted because SDK is disabled", new Object[0]);
            return;
        }
        if (this.activityState.isGdprForgotten) {
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 104, "Purchase verification aborted because user is GDPR forgotten"));
            this.logger.warn("Purchase verification aborted because user is GDPR forgotten", new Object[0]);
            return;
        }
        if (adjustPlayStorePurchase == null) {
            this.logger.warn("Purchase verification aborted because purchase instance is null", new Object[0]);
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", LocationRequest.PRIORITY_NO_POWER, "Purchase verification aborted because purchase instance is null"));
            return;
        }
        PackageBuilder packageBuilder = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.globalParameters, System.currentTimeMillis());
        packageBuilder.internalState = this.internalState;
        ActivityPackage activityPackageBuildVerificationPackage = packageBuilder.buildVerificationPackage(adjustPlayStorePurchase, onPurchaseVerificationFinishedListener);
        if (activityPackageBuildVerificationPackage != null) {
            this.purchaseVerificationHandler.sendPurchaseVerificationPackage(activityPackageBuildVerificationPackage);
        } else {
            this.logger.warn("Purchase verification aborted because verification package is null", new Object[0]);
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 106, "Purchase verification aborted because verification package is null"));
        }
    }

    private void writeActivityStateI() {
        synchronized (ActivityState.class) {
            ActivityState activityState = this.activityState;
            if (activityState == null) {
                return;
            }
            Util.writeObject(activityState, this.adjustConfig.context, Constants.ACTIVITY_STATE_FILENAME, ACTIVITY_STATE_NAME);
        }
    }

    private void writeAttributionI() {
        synchronized (AdjustAttribution.class) {
            AdjustAttribution adjustAttribution = this.attribution;
            if (adjustAttribution == null) {
                return;
            }
            Util.writeObject(adjustAttribution, this.adjustConfig.context, Constants.ATTRIBUTION_FILENAME, ATTRIBUTION_NAME);
        }
    }

    private void writeGlobalCallbackParametersI() {
        synchronized (GlobalParameters.class) {
            GlobalParameters globalParameters = this.globalParameters;
            if (globalParameters == null) {
                return;
            }
            Util.writeObject(globalParameters.callbackParameters, this.adjustConfig.context, Constants.GLOBAL_CALLBACK_PARAMETERS_FILENAME, GLOBAL_CALLBACK_PARAMETERS_NAME);
        }
    }

    private void writeGlobalPartnerParametersI() {
        synchronized (GlobalParameters.class) {
            GlobalParameters globalParameters = this.globalParameters;
            if (globalParameters == null) {
                return;
            }
            Util.writeObject(globalParameters.partnerParameters, this.adjustConfig.context, Constants.GLOBAL_PARTNER_PARAMETERS_FILENAME, GLOBAL_PARTNER_PARAMETERS_NAME);
        }
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void addGlobalCallbackParameter(String str, String str2) {
        this.executor.submit(new i(str, str2));
    }

    public void addGlobalCallbackParameterI(String str, String str2) {
        if (Util.isValidParameter(str, "key", "Global Callback") && Util.isValidParameter(str2, "value", "Global Callback")) {
            GlobalParameters globalParameters = this.globalParameters;
            if (globalParameters.callbackParameters == null) {
                globalParameters.callbackParameters = new LinkedHashMap();
            }
            String str3 = this.globalParameters.callbackParameters.get(str);
            if (str2.equals(str3)) {
                this.logger.verbose("Key %s already present with the same value", str);
                return;
            }
            if (str3 != null) {
                this.logger.warn("Key %s will be overwritten", str);
            }
            this.globalParameters.callbackParameters.put(str, str2);
            writeGlobalCallbackParametersI();
        }
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void addGlobalPartnerParameter(String str, String str2) {
        this.executor.submit(new j(str, str2));
    }

    public void addGlobalPartnerParameterI(String str, String str2) {
        if (Util.isValidParameter(str, "key", "Global Partner") && Util.isValidParameter(str2, "value", "Global Partner")) {
            GlobalParameters globalParameters = this.globalParameters;
            if (globalParameters.partnerParameters == null) {
                globalParameters.partnerParameters = new LinkedHashMap();
            }
            String str3 = this.globalParameters.partnerParameters.get(str);
            if (str2.equals(str3)) {
                this.logger.verbose("Key %s already present with the same value", str);
                return;
            }
            if (str3 != null) {
                this.logger.warn("Key %s will be overwritten", str);
            }
            this.globalParameters.partnerParameters.put(str, str2);
            writeGlobalPartnerParametersI();
        }
    }

    public void backgroundTimerFired() {
        this.executor.submit(new y());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void finishedTrackingActivity(ResponseData responseData) {
        if (responseData instanceof SessionResponseData) {
            this.logger.debug("Finished tracking session", new Object[0]);
            this.attributionHandler.checkSessionResponse((SessionResponseData) responseData);
            return;
        }
        if (responseData instanceof SdkClickResponseData) {
            SdkClickResponseData sdkClickResponseData = (SdkClickResponseData) responseData;
            checkForInstallReferrerInfo(sdkClickResponseData);
            this.attributionHandler.checkSdkClickResponse(sdkClickResponseData);
        } else if (responseData instanceof EventResponseData) {
            launchEventResponseTasks((EventResponseData) responseData);
        } else if (responseData instanceof PurchaseVerificationResponseData) {
            launchPurchaseVerificationResponseTasks((PurchaseVerificationResponseData) responseData);
        }
    }

    public void foregroundTimerFired() {
        this.executor.submit(new x());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void gdprForgetMe() {
        this.executor.submit(new q());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public ActivityState getActivityState() {
        return this.activityState;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void getAdid(OnAdidReadListener onAdidReadListener) {
        ActivityState activityState = this.activityState;
        if (activityState != null && activityState.adid != null) {
            new Handler(this.adjustConfig.context.getMainLooper()).post(new z(onAdidReadListener));
            return;
        }
        if (activityState == null) {
            this.logger.warn("SDK needs to be initialized before getting adid", new Object[0]);
        }
        this.cachedAdidReadCallbacks.add(onAdidReadListener);
    }

    @Override // com.adjust.sdk.IActivityHandler
    public AdjustConfig getAdjustConfig() {
        return this.adjustConfig;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void getAttribution(OnAttributionReadListener onAttributionReadListener) {
        if (this.attribution != null) {
            new Handler(this.adjustConfig.context.getMainLooper()).post(new a0(onAttributionReadListener));
        } else {
            this.cachedAttributionReadCallbacks.add(onAttributionReadListener);
        }
    }

    @Override // com.adjust.sdk.IActivityHandler
    public Context getContext() {
        return this.adjustConfig.context;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public GlobalParameters getGlobalParameters() {
        return this.globalParameters;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public InternalState getInternalState() {
        return this.internalState;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void gotOptOutResponse() {
        this.executor.submit(new w());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void init(AdjustConfig adjustConfig) {
        this.adjustConfig = adjustConfig;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void isEnabled(OnIsEnabledListener onIsEnabledListener) {
        this.executor.submit(new r0(onIsEnabledListener));
    }

    /* JADX INFO: renamed from: lambda$onActivityLifecycle$0$com-adjust-sdk-ActivityHandler, reason: not valid java name */
    /* synthetic */ void m70lambda$onActivityLifecycle$0$comadjustsdkActivityHandler(boolean z2) {
        Boolean bool = this.internalState.foregroundOrElseBackground;
        if (bool == null || bool.booleanValue() != z2) {
            this.internalState.foregroundOrElseBackground = Boolean.valueOf(z2);
            if (z2) {
                onResumeI();
            } else {
                onPauseI();
            }
        }
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void launchAttributionResponseTasks(AttributionResponseData attributionResponseData) {
        this.executor.submit(new g(attributionResponseData));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void launchEventResponseTasks(EventResponseData eventResponseData) {
        this.executor.submit(new d(eventResponseData));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void launchPurchaseVerificationResponseTasks(PurchaseVerificationResponseData purchaseVerificationResponseData) {
        this.executor.submit(new h(purchaseVerificationResponseData));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void launchSdkClickResponseTasks(SdkClickResponseData sdkClickResponseData) {
        this.executor.submit(new e(sdkClickResponseData));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void launchSessionResponseTasks(SessionResponseData sessionResponseData) {
        this.executor.submit(new f(sessionResponseData));
    }

    @Override // com.adjust.sdk.SystemLifecycle.SystemLifecycleCallback
    public void onActivityLifecycle(final boolean z2) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m70lambda$onActivityLifecycle$0$comadjustsdkActivityHandler(z2);
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void onPause() {
        onActivityLifecycle(false);
    }

    public void onPauseI() {
        stopForegroundTimerI();
        startBackgroundTimerI();
        this.logger.verbose("Subsession end", new Object[0]);
        endI();
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void onResume() {
        onActivityLifecycle(true);
    }

    public void onResumeI() {
        stopBackgroundTimerI();
        startForegroundTimerI();
        this.logger.verbose("Subsession start", new Object[0]);
        startI();
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void processAndResolveDeeplink(Uri uri, long j2, OnDeeplinkResolvedListener onDeeplinkResolvedListener) {
        this.cachedDeeplinkResolutionCallback = onDeeplinkResolvedListener;
        this.executor.submit(new a1(uri, j2));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void processDeeplink(Uri uri, long j2) {
        this.executor.submit(new z0(uri, j2));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void removeGlobalCallbackParameter(String str) {
        this.executor.submit(new l(str));
    }

    public void removeGlobalCallbackParameterI(String str) {
        if (Util.isValidParameter(str, "key", "Session Callback")) {
            Map<String, String> map = this.globalParameters.callbackParameters;
            if (map == null) {
                this.logger.warn("Session Callback parameters are not set", new Object[0]);
            } else if (map.remove(str) == null) {
                this.logger.warn("Key %s does not exist", str);
            } else {
                this.logger.debug("Key %s will be removed", str);
                writeGlobalCallbackParametersI();
            }
        }
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void removeGlobalCallbackParameters() {
        this.executor.submit(new n());
    }

    public void removeGlobalCallbackParametersI() {
        if (this.globalParameters.callbackParameters == null) {
            this.logger.warn("Session Callback parameters are not set", new Object[0]);
        }
        this.globalParameters.callbackParameters = null;
        writeGlobalCallbackParametersI();
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void removeGlobalPartnerParameter(String str) {
        this.executor.submit(new m(str));
    }

    public void removeGlobalPartnerParameterI(String str) {
        if (Util.isValidParameter(str, "key", "Session Partner")) {
            Map<String, String> map = this.globalParameters.partnerParameters;
            if (map == null) {
                this.logger.warn("Session Partner parameters are not set", new Object[0]);
            } else if (map.remove(str) == null) {
                this.logger.warn("Key %s does not exist", str);
            } else {
                this.logger.debug("Key %s will be removed", str);
                writeGlobalPartnerParametersI();
            }
        }
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void removeGlobalPartnerParameters() {
        this.executor.submit(new o());
    }

    public void removeGlobalPartnerParametersI() {
        if (this.globalParameters.partnerParameters == null) {
            this.logger.warn("Session Partner parameters are not set", new Object[0]);
        }
        this.globalParameters.partnerParameters = null;
        writeGlobalPartnerParametersI();
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void sendInstallReferrer(ReferrerDetails referrerDetails, String str) {
        this.executor.submit(new c(referrerDetails, str));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void sendPreinstallReferrer() {
        this.executor.submit(new b());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void sendReftagReferrer() {
        this.executor.submit(new a());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void setAskingAttribution(boolean z2) {
        this.executor.submit(new d1(z2));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void setEnabled(boolean z2) {
        this.executor.submit(new v(z2));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void setOfflineMode(boolean z2) {
        this.executor.submit(new g0(z2));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void setPushToken(String str, boolean z2) {
        this.executor.submit(new p(z2, str));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void teardown() {
        TimerOnce timerOnce = this.backgroundTimer;
        if (timerOnce != null) {
            timerOnce.teardown();
        }
        TimerCycle timerCycle = this.foregroundTimer;
        if (timerCycle != null) {
            timerCycle.teardown();
        }
        ThreadExecutor threadExecutor = this.executor;
        if (threadExecutor != null) {
            threadExecutor.teardown();
        }
        IPackageHandler iPackageHandler = this.packageHandler;
        if (iPackageHandler != null) {
            iPackageHandler.teardown();
        }
        IAttributionHandler iAttributionHandler = this.attributionHandler;
        if (iAttributionHandler != null) {
            iAttributionHandler.teardown();
        }
        ISdkClickHandler iSdkClickHandler = this.sdkClickHandler;
        if (iSdkClickHandler != null) {
            iSdkClickHandler.teardown();
        }
        IPurchaseVerificationHandler iPurchaseVerificationHandler = this.purchaseVerificationHandler;
        if (iPurchaseVerificationHandler != null) {
            iPurchaseVerificationHandler.teardown();
        }
        GlobalParameters globalParameters = this.globalParameters;
        if (globalParameters != null) {
            Map<String, String> map = globalParameters.callbackParameters;
            if (map != null) {
                map.clear();
            }
            Map<String, String> map2 = this.globalParameters.partnerParameters;
            if (map2 != null) {
                map2.clear();
            }
        }
        teardownActivityStateS();
        teardownAttributionS();
        teardownAllGlobalParametersS();
        this.packageHandler = null;
        this.logger = null;
        this.foregroundTimer = null;
        this.executor = null;
        this.backgroundTimer = null;
        this.internalState = null;
        this.deviceInfo = null;
        this.adjustConfig = null;
        this.attributionHandler = null;
        this.sdkClickHandler = null;
        this.purchaseVerificationHandler = null;
        this.globalParameters = null;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void trackAdRevenue(AdjustAdRevenue adjustAdRevenue) {
        this.executor.submit(new t(adjustAdRevenue));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void trackEvent(AdjustEvent adjustEvent) {
        this.executor.submit(new k(adjustEvent));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void trackMeasurementConsent(boolean z2) {
        this.executor.submit(new s(z2));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void trackPlayStoreSubscription(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        this.executor.submit(new u(adjustPlayStoreSubscription));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void trackThirdPartySharing(AdjustThirdPartySharing adjustThirdPartySharing) {
        this.executor.submit(new r(adjustThirdPartySharing));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public boolean updateAttributionI(AdjustAttribution adjustAttribution) {
        if (adjustAttribution == null || this.activityState.askingAttribution) {
            return false;
        }
        if (!this.cachedAttributionReadCallbacks.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.cachedAttributionReadCallbacks);
            this.cachedAttributionReadCallbacks.clear();
            new Handler(this.adjustConfig.context.getMainLooper()).post(new c1(arrayList, adjustAttribution));
        }
        if (adjustAttribution.equals(this.attribution)) {
            return false;
        }
        this.attribution = adjustAttribution;
        writeAttributionI();
        return true;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void verifyAndTrackPlayStorePurchase(AdjustEvent adjustEvent, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
        this.executor.submit(new c0(adjustEvent, onPurchaseVerificationFinishedListener));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void verifyPlayStorePurchase(AdjustPlayStorePurchase adjustPlayStorePurchase, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
        this.executor.submit(new b0(adjustPlayStorePurchase, onPurchaseVerificationFinishedListener));
    }

    private void checkAfterNewStartI(SharedPreferencesManager sharedPreferencesManager) {
        String pushToken = sharedPreferencesManager.getPushToken();
        if (pushToken != null && !pushToken.equals(this.activityState.pushToken)) {
            setPushToken(pushToken, true);
        }
        if (sharedPreferencesManager.getRawReferrerArray() != null) {
            sendReftagReferrer();
        }
        checkForPreinstallI();
        this.installReferrer.startConnection();
        readInstallReferrerMeta();
        readInstallReferrerHuaweiAds();
        readInstallReferrerHuaweiAppGallery();
        readInstallReferrerSamsung();
        readInstallReferrerXiaomi();
        readInstallReferrerVivo();
    }

    private boolean pausedI(boolean z2) {
        if (z2) {
            return this.internalState.isOffline() || !isEnabledI();
        }
        return this.internalState.isOffline() || !isEnabledI();
    }

    private boolean toSendI(boolean z2) {
        if (pausedI(z2)) {
            return false;
        }
        if (this.adjustConfig.isSendingInBackgroundEnabled) {
            return true;
        }
        return this.internalState.isInForeground();
    }

    @Override // com.adjust.sdk.IActivityHandler
    public boolean isEnabled() {
        return isEnabledI();
    }
}
