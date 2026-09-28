package com.nintendo.npf.sdk.core;

import android.app.Activity;
import android.app.Application;
import android.util.Log;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.analytics.AnalyticsService;
import com.nintendo.npf.sdk.audit.AuditService;
import com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade;
import com.nintendo.npf.sdk.inquiry.InquiryService;
import com.nintendo.npf.sdk.internal.client.core.HttpClient;
import com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling;
import com.nintendo.npf.sdk.internal.model.Capabilities;
import com.nintendo.npf.sdk.notification.PushNotificationChannelService;
import com.nintendo.npf.sdk.promo.PromoCodeService;
import com.nintendo.npf.sdk.subscription.SubscriptionController;
import com.nintendo.npf.sdk.subscription.SubscriptionService;
import com.nintendo.npf.sdk.user.BaasAccountService;
import com.nintendo.npf.sdk.user.LinkedAccountService;
import com.nintendo.npf.sdk.user.NintendoAccountService;
import com.nintendo.npf.sdk.user.OtherUserService;
import com.nintendo.npf.sdk.user.TransferAccountService;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyService;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public interface x4 {
    HttpClient getAccountApiClient();

    HttpClient getAccountClient();

    AnalyticsService getAnalyticsService();

    AuditService getAuditService();

    BaasAccountService getBaasAccountService();

    HttpClient getBaasHttpClient();

    j0 getBaasUser();

    Capabilities getCapabilities();

    u0 getConfigurationDataFacade();

    a1 getCredentialsDataFacade();

    DeviceDataFacade getDeviceDataFacade();

    e4 getEventDispatcher();

    y1 getHostInformationDataFacade();

    InquiryService getInquiryService();

    LinkedAccountService getLinkedAppleAccountService();

    LinkedAccountService getLinkedFacebookAccountService();

    LinkedAccountService getLinkedGoogleAccountService();

    z2 getLoginHandler();

    c3 getMiiStudioService();

    d3 getMissionStatus();

    i3 getNPFSDK();

    o3 getNaAuthorizationHandler();

    NintendoAccountService getNintendoAccountService();

    OtherUserService getOtherUserService();

    PromoCodeService getPromoCodeService();

    PushNotificationChannelService getPushNotificationChannelService();

    v4 getSdkWebViewManager();

    SubscriptionController getSubscriptionController();

    SubscriptionService getSubscriptionService();

    TransferAccountService getTransferAccountService();

    VirtualCurrencyService getVirtualCurrencyService();

    void setActivity(Activity activity);

    void setEventHandler(NPFSDK.EventHandler eventHandler);

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static x4 f620a;

        public static synchronized void a(Application application) {
            if (f620a == null) {
                try {
                    f620a = (x4) Class.forName("com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling").getConstructor(Application.class).newInstance(application);
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                    Log.d("ServiceLocator", "ServiceLocator Exception", e);
                    f620a = new ServiceLocatorNoBilling(application);
                }
            }
        }

        public static synchronized x4 a() {
            x4 x4Var;
            x4Var = f620a;
            if (x4Var == null) {
                throw new IllegalStateException();
            }
            return x4Var;
        }
    }
}
