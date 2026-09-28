package com.adjust.sdk;

import android.net.Uri;
import com.adjust.sdk.network.IActivityPackageSender;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadScheduler;
import com.adjust.sdk.scheduler.TimerOnce;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AttributionHandler implements IAttributionHandler, IActivityPackageSender.ResponseDataCallbackSubscriber {
    private static final String ATTRIBUTION_TIMER_NAME = "Attribution timer";
    private WeakReference<IActivityHandler> activityHandlerWeakRef;
    private IActivityPackageSender activityPackageSender;
    private String lastInitiatedBy;
    private boolean paused;
    private ILogger logger = AdjustFactory.getLogger();
    private ThreadScheduler scheduler = new SingleThreadCachedScheduler("AttributionHandler");
    private TimerOnce timer = new TimerOnce(new a(), ATTRIBUTION_TIMER_NAME);

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AttributionHandler.this.sendAttributionRequest();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AttributionHandler.this.lastInitiatedBy = "sdk";
            AttributionHandler.this.getAttributionI(0L);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SessionResponseData f73a;

        public c(SessionResponseData sessionResponseData) {
            this.f73a = sessionResponseData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IActivityHandler iActivityHandler = (IActivityHandler) AttributionHandler.this.activityHandlerWeakRef.get();
            if (iActivityHandler == null) {
                return;
            }
            AttributionHandler.this.checkSessionResponseI(iActivityHandler, this.f73a);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SdkClickResponseData f74a;

        public d(SdkClickResponseData sdkClickResponseData) {
            this.f74a = sdkClickResponseData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IActivityHandler iActivityHandler = (IActivityHandler) AttributionHandler.this.activityHandlerWeakRef.get();
            if (iActivityHandler == null) {
                return;
            }
            AttributionHandler.this.checkSdkClickResponseI(iActivityHandler, this.f74a);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttributionResponseData f75a;

        public e(AttributionResponseData attributionResponseData) {
            this.f75a = attributionResponseData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IActivityHandler iActivityHandler = (IActivityHandler) AttributionHandler.this.activityHandlerWeakRef.get();
            if (iActivityHandler == null) {
                return;
            }
            AttributionHandler.this.checkAttributionResponseI(iActivityHandler, this.f75a);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AttributionHandler.this.sendAttributionRequestI();
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ResponseData f77a;

        public g(ResponseData responseData) {
            this.f77a = responseData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IActivityHandler iActivityHandler = (IActivityHandler) AttributionHandler.this.activityHandlerWeakRef.get();
            if (iActivityHandler == null) {
                return;
            }
            ResponseData responseData = this.f77a;
            if (responseData.trackingState == TrackingState.OPTED_OUT) {
                iActivityHandler.gotOptOutResponse();
            } else if (responseData instanceof AttributionResponseData) {
                AttributionHandler.this.checkAttributionResponseI(iActivityHandler, (AttributionResponseData) responseData);
            }
        }
    }

    public AttributionHandler(IActivityHandler iActivityHandler, boolean z, IActivityPackageSender iActivityPackageSender) {
        init(iActivityHandler, z, iActivityPackageSender);
    }

    private ActivityPackage buildAndGetAttributionPackage(ActivityHandler.InternalState internalState) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        PackageBuilder packageBuilder = new PackageBuilder(iActivityHandler.getAdjustConfig(), iActivityHandler.getDeviceInfo(), iActivityHandler.getActivityState(), iActivityHandler.getGlobalParameters(), jCurrentTimeMillis);
        packageBuilder.internalState = internalState;
        ActivityPackage activityPackageBuildAttributionPackage = packageBuilder.buildAttributionPackage(this.lastInitiatedBy);
        this.lastInitiatedBy = null;
        return activityPackageBuildAttributionPackage;
    }

    private void checkAttributionI(IActivityHandler iActivityHandler, ResponseData responseData) {
        if (responseData.jsonResponse == null) {
            return;
        }
        Long l = responseData.askIn;
        if (l == null || l.longValue() < 0) {
            iActivityHandler.setAskingAttribution(false);
            return;
        }
        iActivityHandler.setAskingAttribution(true);
        this.lastInitiatedBy = "backend";
        getAttributionI(l.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAttributionResponseI(IActivityHandler iActivityHandler, AttributionResponseData attributionResponseData) {
        checkAttributionI(iActivityHandler, attributionResponseData);
        checkDeeplinkI(attributionResponseData);
        iActivityHandler.launchAttributionResponseTasks(attributionResponseData);
    }

    private void checkDeeplinkI(AttributionResponseData attributionResponseData) {
        JSONObject jSONObjectOptJSONObject;
        String strOptString;
        JSONObject jSONObject = attributionResponseData.jsonResponse;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("attribution")) == null || (strOptString = jSONObjectOptJSONObject.optString(Constants.DEEPLINK, null)) == null) {
            return;
        }
        attributionResponseData.deeplink = Uri.parse(strOptString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkSdkClickResponseI(IActivityHandler iActivityHandler, SdkClickResponseData sdkClickResponseData) {
        checkAttributionI(iActivityHandler, sdkClickResponseData);
        iActivityHandler.launchSdkClickResponseTasks(sdkClickResponseData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkSessionResponseI(IActivityHandler iActivityHandler, SessionResponseData sessionResponseData) {
        checkAttributionI(iActivityHandler, sessionResponseData);
        iActivityHandler.launchSessionResponseTasks(sessionResponseData);
    }

    private Map<String, String> generateSendingParametersI() {
        HashMap map = new HashMap();
        PackageBuilder.addString(map, "sent_at", Util.dateFormatter.format(Long.valueOf(System.currentTimeMillis())));
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAttributionI(long j) {
        if (this.timer.getFireIn() > j) {
            return;
        }
        if (j != 0) {
            this.logger.debug("Waiting to query attribution in %s seconds", Util.SecondsDisplayFormat.format(j / 1000.0d));
        }
        this.timer.startIn(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAttributionRequest() {
        this.scheduler.submit(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAttributionRequestI() {
        if (this.activityHandlerWeakRef.get().getActivityState().isGdprForgotten) {
            return;
        }
        if (this.paused) {
            this.logger.debug("Attribution handler is paused", new Object[0]);
            return;
        }
        ActivityPackage activityPackageBuildAndGetAttributionPackage = buildAndGetAttributionPackage(this.activityHandlerWeakRef.get().getInternalState());
        this.logger.verbose("%s", activityPackageBuildAndGetAttributionPackage.getExtendedString());
        this.activityPackageSender.sendActivityPackage(activityPackageBuildAndGetAttributionPackage, generateSendingParametersI(), this);
    }

    public void checkAttributionResponse(AttributionResponseData attributionResponseData) {
        this.scheduler.submit(new e(attributionResponseData));
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void checkSdkClickResponse(SdkClickResponseData sdkClickResponseData) {
        this.scheduler.submit(new d(sdkClickResponseData));
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void checkSessionResponse(SessionResponseData sessionResponseData) {
        this.scheduler.submit(new c(sessionResponseData));
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void getAttribution() {
        this.scheduler.submit(new b());
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void init(IActivityHandler iActivityHandler, boolean z, IActivityPackageSender iActivityPackageSender) {
        this.activityHandlerWeakRef = new WeakReference<>(iActivityHandler);
        this.paused = !z;
        this.activityPackageSender = iActivityPackageSender;
    }

    @Override // com.adjust.sdk.network.IActivityPackageSender.ResponseDataCallbackSubscriber
    public void onResponseDataCallback(ResponseData responseData) {
        this.scheduler.submit(new g(responseData));
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void pauseSending() {
        this.paused = true;
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void resumeSending() {
        this.paused = false;
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void teardown() {
        this.logger.verbose("AttributionHandler teardown", new Object[0]);
        TimerOnce timerOnce = this.timer;
        if (timerOnce != null) {
            timerOnce.teardown();
        }
        ThreadScheduler threadScheduler = this.scheduler;
        if (threadScheduler != null) {
            threadScheduler.teardown();
        }
        WeakReference<IActivityHandler> weakReference = this.activityHandlerWeakRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.timer = null;
        this.logger = null;
        this.scheduler = null;
        this.activityHandlerWeakRef = null;
    }
}
