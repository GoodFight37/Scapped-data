package com.nintendo.npf.sdk;

import android.app.Activity;
import android.app.Application;
import com.nintendo.npf.sdk.analytics.AnalyticsService;
import com.nintendo.npf.sdk.audit.AuditService;
import com.nintendo.npf.sdk.core.i3;
import com.nintendo.npf.sdk.core.x4;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.inquiry.InquiryService;
import com.nintendo.npf.sdk.notification.PushNotificationChannelService;
import com.nintendo.npf.sdk.promo.PromoCodeService;
import com.nintendo.npf.sdk.subscription.SubscriptionController;
import com.nintendo.npf.sdk.subscription.SubscriptionService;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.BaasAccountService;
import com.nintendo.npf.sdk.user.LinkedAccountService;
import com.nintendo.npf.sdk.user.NintendoAccount;
import com.nintendo.npf.sdk.user.NintendoAccountService;
import com.nintendo.npf.sdk.user.TransferAccountService;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyService;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyWallet;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004©\u0001ª\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\t\u0010\rJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u001aJ]\u0010\"\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001b2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001d2\u001e\u0010\u0014\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020\b\u0018\u00010\u001fH\u0007¢\u0006\u0004\b\"\u0010#J]\u0010$\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001b2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001d2\u001e\u0010\u0014\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020\b\u0018\u00010\u001fH\u0007¢\u0006\u0004\b$\u0010#J/\u0010%\u001a\u00020\b2\u001e\u0010\u0014\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020\b\u0018\u00010\u001fH\u0007¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\bH\u0007¢\u0006\u0004\b'\u0010\u0003J\u000f\u0010(\u001a\u00020\bH\u0007¢\u0006\u0004\b(\u0010\u0003R\u001c\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001a\u00108\u001a\u0002048FX\u0087\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0003\u001a\u0004\b5\u00106R\u001a\u0010<\u001a\u00020\u00178FX\u0087\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0003\u001a\u0004\b9\u0010:R\u001a\u0010?\u001a\u00020\u00178FX\u0087\u0004¢\u0006\f\u0012\u0004\b>\u0010\u0003\u001a\u0004\b=\u0010:R\u001a\u0010B\u001a\u00020\u00178FX\u0087\u0004¢\u0006\f\u0012\u0004\bA\u0010\u0003\u001a\u0004\b@\u0010:R*\u0010D\u001a\u00020C2\u0006\u0010D\u001a\u00020C8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\bI\u0010\u0003\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR*\u0010J\u001a\u00020C2\u0006\u0010J\u001a\u00020C8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\bM\u0010\u0003\u001a\u0004\bK\u0010F\"\u0004\bL\u0010HR\u001a\u0010P\u001a\u00020\u00178FX\u0087\u0004¢\u0006\f\u0012\u0004\bO\u0010\u0003\u001a\u0004\bN\u0010:R\u001a\u0010Q\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\bS\u0010\u0003\u001a\u0004\bQ\u0010RR*\u0010T\u001a\u00020\u00172\u0006\u0010T\u001a\u00020\u00178F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\bX\u0010\u0003\u001a\u0004\bU\u0010:\"\u0004\bV\u0010WR\u001a\u0010[\u001a\u00020\u00178FX\u0087\u0004¢\u0006\f\u0012\u0004\bZ\u0010\u0003\u001a\u0004\bY\u0010:R\u001a\u0010`\u001a\u00020\\8FX\u0087\u0004¢\u0006\f\u0012\u0004\b_\u0010\u0003\u001a\u0004\b]\u0010^R\u001a\u0010c\u001a\u00020\\8FX\u0087\u0004¢\u0006\f\u0012\u0004\bb\u0010\u0003\u001a\u0004\ba\u0010^R\u001a\u0010f\u001a\u00020\u00178FX\u0087\u0004¢\u0006\f\u0012\u0004\be\u0010\u0003\u001a\u0004\bd\u0010:R\u001a\u0010k\u001a\u00020g8FX\u0087\u0004¢\u0006\f\u0012\u0004\bj\u0010\u0003\u001a\u0004\bh\u0010iR\u001a\u0010n\u001a\u00020g8FX\u0087\u0004¢\u0006\f\u0012\u0004\bm\u0010\u0003\u001a\u0004\bl\u0010iR\u001a\u0010q\u001a\u00020g8FX\u0087\u0004¢\u0006\f\u0012\u0004\bp\u0010\u0003\u001a\u0004\bo\u0010iR\u001a\u0010v\u001a\u00020r8FX\u0087\u0004¢\u0006\f\u0012\u0004\bu\u0010\u0003\u001a\u0004\bs\u0010tR\u001a\u0010{\u001a\u00020w8FX\u0087\u0004¢\u0006\f\u0012\u0004\bz\u0010\u0003\u001a\u0004\bx\u0010yR\u001b\u0010\u0080\u0001\u001a\u00020|8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u007f\u0010\u0003\u001a\u0004\b}\u0010~R\u001f\u0010\u0085\u0001\u001a\u00030\u0081\u00018FX\u0087\u0004¢\u0006\u000f\u0012\u0005\b\u0084\u0001\u0010\u0003\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001f\u0010\u008a\u0001\u001a\u00030\u0086\u00018FX\u0087\u0004¢\u0006\u000f\u0012\u0005\b\u0089\u0001\u0010\u0003\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001f\u0010\u008f\u0001\u001a\u00030\u008b\u00018FX\u0087\u0004¢\u0006\u000f\u0012\u0005\b\u008e\u0001\u0010\u0003\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001f\u0010\u0094\u0001\u001a\u00030\u0090\u00018FX\u0087\u0004¢\u0006\u000f\u0012\u0005\b\u0093\u0001\u0010\u0003\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001f\u0010\u0099\u0001\u001a\u00030\u0095\u00018FX\u0087\u0004¢\u0006\u000f\u0012\u0005\b\u0098\u0001\u0010\u0003\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001f\u0010\u009e\u0001\u001a\u00030\u009a\u00018FX\u0087\u0004¢\u0006\u000f\u0012\u0005\b\u009d\u0001\u0010\u0003\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001f\u0010£\u0001\u001a\u00030\u009f\u00018FX\u0087\u0004¢\u0006\u000f\u0012\u0005\b¢\u0001\u0010\u0003\u001a\u0006\b \u0001\u0010¡\u0001R\u001f\u0010¨\u0001\u001a\u00030¤\u00018FX\u0087\u0004¢\u0006\u000f\u0012\u0005\b§\u0001\u0010\u0003\u001a\u0006\b¥\u0001\u0010¦\u0001¨\u0006«\u0001"}, d2 = {"Lcom/nintendo/npf/sdk/NPFSDK;", "", "<init>", "()V", "Landroid/app/Application;", "application", "Lcom/nintendo/npf/sdk/NPFSDK$EventHandler;", "eventHandler", "", "init", "(Landroid/app/Application;Lcom/nintendo/npf/sdk/NPFSDK$EventHandler;)V", "", "immediateLogin", "(Landroid/app/Application;Lcom/nintendo/npf/sdk/NPFSDK$EventHandler;Z)V", "Landroid/app/Activity;", "activity", "setActivity", "(Landroid/app/Activity;)V", "avoidMultipleDeviceAccounts", "Lcom/nintendo/npf/sdk/user/BaaSUser$AuthorizationCallback;", "callback", "retryBaaSAuth", "(ZLcom/nintendo/npf/sdk/user/BaaSUser$AuthorizationCallback;)V", "", "deviceAccount", "devicePassword", "(Ljava/lang/String;Ljava/lang/String;Lcom/nintendo/npf/sdk/user/BaaSUser$AuthorizationCallback;)V", "", "scope", "", "profileSource", "Lkotlin/Function2;", "Lcom/nintendo/npf/sdk/user/NintendoAccount;", "Lcom/nintendo/npf/sdk/NPFError;", "authorizeByNintendoAccount", "(Landroid/app/Activity;Ljava/util/List;Ljava/util/Map;Lkotlin/jvm/functions/Function2;)V", "authorizeByNintendoAccount2", "retryPendingAuthorizationByNintendoAccount2", "(Lkotlin/jvm/functions/Function2;)V", "resetDeviceAccount", "enableCommunicationStatistics", "", "a", "[Ljava/lang/Object;", "LOCK", "Lcom/nintendo/npf/sdk/core/i3;", "b", "Lcom/nintendo/npf/sdk/core/i3;", "instance", "c", "Z", "isInitialized", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "getCurrentBaaSUser", "()Lcom/nintendo/npf/sdk/user/BaaSUser;", "getCurrentBaaSUser$annotations", "currentBaaSUser", "getNintendoAccountFAQURL", "()Ljava/lang/String;", "getNintendoAccountFAQURL$annotations", "nintendoAccountFAQURL", "getNintendoAccountRestartFAQURL", "getNintendoAccountRestartFAQURL$annotations", "nintendoAccountRestartFAQURL", "getNintendoAccountURL", "getNintendoAccountURL$annotations", "nintendoAccountURL", "", "readTimeout", "getReadTimeout", "()I", "setReadTimeout", "(I)V", "getReadTimeout$annotations", "requestTimeout", "getRequestTimeout", "setRequestTimeout", "getRequestTimeout$annotations", "getSdkVersion", "getSdkVersion$annotations", "sdkVersion", "isSandbox", "()Z", "isSandbox$annotations", "language", "getLanguage", "setLanguage", "(Ljava/lang/String;)V", "getLanguage$annotations", "getMarket", "getMarket$annotations", "market", "", "getTotalRequestDataSize", "()J", "getTotalRequestDataSize$annotations", "totalRequestDataSize", "getTotalResponseDataSize", "getTotalResponseDataSize$annotations", "totalResponseDataSize", "getCapabilities", "getCapabilities$annotations", "capabilities", "Lcom/nintendo/npf/sdk/user/LinkedAccountService;", "getLinkedAppleAccountService", "()Lcom/nintendo/npf/sdk/user/LinkedAccountService;", "getLinkedAppleAccountService$annotations", "linkedAppleAccountService", "getLinkedGoogleAccountService", "getLinkedGoogleAccountService$annotations", "linkedGoogleAccountService", "getLinkedFacebookAccountService", "getLinkedFacebookAccountService$annotations", "linkedFacebookAccountService", "Lcom/nintendo/npf/sdk/subscription/SubscriptionService;", "getSubscriptionService", "()Lcom/nintendo/npf/sdk/subscription/SubscriptionService;", "getSubscriptionService$annotations", "subscriptionService", "Lcom/nintendo/npf/sdk/subscription/SubscriptionController;", "getSubscriptionController", "()Lcom/nintendo/npf/sdk/subscription/SubscriptionController;", "getSubscriptionController$annotations", "subscriptionController", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyService;", "getVirtualCurrencyService", "()Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyService;", "getVirtualCurrencyService$annotations", "virtualCurrencyService", "Lcom/nintendo/npf/sdk/promo/PromoCodeService;", "getPromoCodeService", "()Lcom/nintendo/npf/sdk/promo/PromoCodeService;", "getPromoCodeService$annotations", "promoCodeService", "Lcom/nintendo/npf/sdk/audit/AuditService;", "getAuditService", "()Lcom/nintendo/npf/sdk/audit/AuditService;", "getAuditService$annotations", "auditService", "Lcom/nintendo/npf/sdk/user/BaasAccountService;", "getBaasAccountService", "()Lcom/nintendo/npf/sdk/user/BaasAccountService;", "getBaasAccountService$annotations", "baasAccountService", "Lcom/nintendo/npf/sdk/user/NintendoAccountService;", "getNintendoAccountService", "()Lcom/nintendo/npf/sdk/user/NintendoAccountService;", "getNintendoAccountService$annotations", "nintendoAccountService", "Lcom/nintendo/npf/sdk/analytics/AnalyticsService;", "getAnalyticsService", "()Lcom/nintendo/npf/sdk/analytics/AnalyticsService;", "getAnalyticsService$annotations", "analyticsService", "Lcom/nintendo/npf/sdk/notification/PushNotificationChannelService;", "getPushNotificationChannelService", "()Lcom/nintendo/npf/sdk/notification/PushNotificationChannelService;", "getPushNotificationChannelService$annotations", "pushNotificationChannelService", "Lcom/nintendo/npf/sdk/inquiry/InquiryService;", "getInquiryService", "()Lcom/nintendo/npf/sdk/inquiry/InquiryService;", "getInquiryService$annotations", "inquiryService", "Lcom/nintendo/npf/sdk/user/TransferAccountService;", "getTransferAccountService", "()Lcom/nintendo/npf/sdk/user/TransferAccountService;", "getTransferAccountService$annotations", "transferAccountService", "EventHandler", "NPFErrorCallback", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NPFSDK {
    public static final NPFSDK INSTANCE = new NPFSDK();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Object[] LOCK = new Object[0];

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static i3 instance;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static boolean isInitialized;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u000e\u001a\u00020\u00032\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010H&J\b\u0010\u0013\u001a\u00020\u0003H&¨\u0006\u0014"}, d2 = {"Lcom/nintendo/npf/sdk/NPFSDK$EventHandler;", "", "onBaaSAuthError", "", "error", "Lcom/nintendo/npf/sdk/NPFError;", "onBaaSAuthStart", "onBaaSAuthUpdate", "user", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "onNintendoAccountAuthError", "onPendingAuthorizationByNintendoAccount2", "onPendingSwitchByNintendoAccount2", "onVirtualCurrencyPurchaseProcessError", "onVirtualCurrencyPurchaseProcessSuccess", MapperConstants.VIRTUAL_CURRENCY_FIELD_WALLETS, "", "", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyWallet;", "onVirtualCurrencyPurchasesUpdated", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface EventHandler {
        void onBaaSAuthError(NPFError error);

        void onBaaSAuthStart();

        void onBaaSAuthUpdate(BaaSUser user);

        void onNintendoAccountAuthError(NPFError error);

        void onPendingAuthorizationByNintendoAccount2();

        void onPendingSwitchByNintendoAccount2();

        void onVirtualCurrencyPurchaseProcessError(NPFError error);

        void onVirtualCurrencyPurchaseProcessSuccess(Map<String, VirtualCurrencyWallet> wallets);

        void onVirtualCurrencyPurchasesUpdated();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/nintendo/npf/sdk/NPFSDK$NPFErrorCallback;", "", "onComplete", "", "error", "Lcom/nintendo/npf/sdk/NPFError;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface NPFErrorCallback {
        void onComplete(NPFError error);
    }

    static final class a extends Lambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2 f390a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Function2 function2) {
            super(2);
            this.f390a = function2;
        }

        public final void a(NintendoAccount nintendoAccount, NPFError nPFError) {
            Function2 function2 = this.f390a;
            if (function2 != null) {
                function2.invoke(nintendoAccount, nPFError);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((NintendoAccount) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2 f391a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Function2 function2) {
            super(2);
            this.f391a = function2;
        }

        public final void a(NintendoAccount nintendoAccount, NPFError nPFError) {
            Function2 function2 = this.f391a;
            if (function2 != null) {
                function2.invoke(nintendoAccount, nPFError);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((NintendoAccount) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2 f392a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Function2 function2) {
            super(2);
            this.f392a = function2;
        }

        public final void a(NintendoAccount nintendoAccount, NPFError nPFError) {
            Function2 function2 = this.f392a;
            if (function2 != null) {
                function2.invoke(nintendoAccount, nPFError);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((NintendoAccount) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    private NPFSDK() {
    }

    @JvmStatic
    public static final void authorizeByNintendoAccount(Activity activity, List<String> scope, Map<String, String> profileSource, Function2<? super NintendoAccount, ? super NPFError, Unit> callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        i3Var.a(activity, scope, new a(callback));
    }

    @JvmStatic
    public static final void authorizeByNintendoAccount2(Activity activity, List<String> scope, Map<String, String> profileSource, Function2<? super NintendoAccount, ? super NPFError, Unit> callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        i3Var.b(activity, scope, new b(callback));
    }

    @JvmStatic
    public static final void enableCommunicationStatistics() {
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        i3Var.a();
    }

    public static final AnalyticsService getAnalyticsService() {
        AnalyticsService analyticsService = x4.a.a().getAnalyticsService();
        Intrinsics.checkNotNullExpressionValue(analyticsService, "getInstance().analyticsService");
        return analyticsService;
    }

    @JvmStatic
    public static /* synthetic */ void getAnalyticsService$annotations() {
    }

    public static final AuditService getAuditService() {
        AuditService auditService = x4.a.a().getAuditService();
        Intrinsics.checkNotNullExpressionValue(auditService, "getInstance().auditService");
        return auditService;
    }

    @JvmStatic
    public static /* synthetic */ void getAuditService$annotations() {
    }

    public static final BaasAccountService getBaasAccountService() {
        BaasAccountService baasAccountService = x4.a.a().getBaasAccountService();
        Intrinsics.checkNotNullExpressionValue(baasAccountService, "getInstance().baasAccountService");
        return baasAccountService;
    }

    @JvmStatic
    public static /* synthetic */ void getBaasAccountService$annotations() {
    }

    public static final String getCapabilities() {
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        return i3Var.b();
    }

    @JvmStatic
    public static /* synthetic */ void getCapabilities$annotations() {
    }

    public static final BaaSUser getCurrentBaaSUser() {
        return getBaasAccountService().getCurrentBaasUser();
    }

    @JvmStatic
    public static /* synthetic */ void getCurrentBaaSUser$annotations() {
    }

    public static final InquiryService getInquiryService() {
        InquiryService inquiryService = x4.a.a().getInquiryService();
        Intrinsics.checkNotNullExpressionValue(inquiryService, "getInstance().inquiryService");
        return inquiryService;
    }

    @JvmStatic
    public static /* synthetic */ void getInquiryService$annotations() {
    }

    public static final String getLanguage() {
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        return i3Var.e();
    }

    @JvmStatic
    public static /* synthetic */ void getLanguage$annotations() {
    }

    public static final LinkedAccountService getLinkedAppleAccountService() {
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        return i3Var.f();
    }

    @JvmStatic
    public static /* synthetic */ void getLinkedAppleAccountService$annotations() {
    }

    public static final LinkedAccountService getLinkedFacebookAccountService() {
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        return i3Var.g();
    }

    @JvmStatic
    public static /* synthetic */ void getLinkedFacebookAccountService$annotations() {
    }

    public static final LinkedAccountService getLinkedGoogleAccountService() {
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        return i3Var.h();
    }

    @JvmStatic
    public static /* synthetic */ void getLinkedGoogleAccountService$annotations() {
    }

    public static final String getMarket() {
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        return i3Var.i();
    }

    @JvmStatic
    public static /* synthetic */ void getMarket$annotations() {
    }

    public static final String getNintendoAccountFAQURL() {
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        return i3Var.j();
    }

    @Deprecated(message = "Use nintendoAccountRestartFAQURL instead", replaceWith = @ReplaceWith(expression = "nintendoAccountRestartFAQURL", imports = {}))
    @JvmStatic
    public static /* synthetic */ void getNintendoAccountFAQURL$annotations() {
    }

    public static final String getNintendoAccountRestartFAQURL() {
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        return i3Var.k();
    }

    @JvmStatic
    public static /* synthetic */ void getNintendoAccountRestartFAQURL$annotations() {
    }

    public static final NintendoAccountService getNintendoAccountService() {
        NintendoAccountService nintendoAccountService = x4.a.a().getNintendoAccountService();
        Intrinsics.checkNotNullExpressionValue(nintendoAccountService, "getInstance().nintendoAccountService");
        return nintendoAccountService;
    }

    @JvmStatic
    public static /* synthetic */ void getNintendoAccountService$annotations() {
    }

    public static final String getNintendoAccountURL() {
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        return i3Var.l();
    }

    @JvmStatic
    public static /* synthetic */ void getNintendoAccountURL$annotations() {
    }

    public static final PromoCodeService getPromoCodeService() {
        PromoCodeService promoCodeService = x4.a.a().getPromoCodeService();
        Intrinsics.checkNotNullExpressionValue(promoCodeService, "getInstance().promoCodeService");
        return promoCodeService;
    }

    @JvmStatic
    public static /* synthetic */ void getPromoCodeService$annotations() {
    }

    public static final PushNotificationChannelService getPushNotificationChannelService() {
        PushNotificationChannelService pushNotificationChannelService = x4.a.a().getPushNotificationChannelService();
        Intrinsics.checkNotNullExpressionValue(pushNotificationChannelService, "getInstance().pushNotificationChannelService");
        return pushNotificationChannelService;
    }

    @JvmStatic
    public static /* synthetic */ void getPushNotificationChannelService$annotations() {
    }

    public static final int getReadTimeout() {
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        return i3Var.m();
    }

    @JvmStatic
    public static /* synthetic */ void getReadTimeout$annotations() {
    }

    public static final int getRequestTimeout() {
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        return i3Var.n();
    }

    @JvmStatic
    public static /* synthetic */ void getRequestTimeout$annotations() {
    }

    public static final String getSdkVersion() {
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        return i3Var.o();
    }

    @JvmStatic
    public static /* synthetic */ void getSdkVersion$annotations() {
    }

    public static final SubscriptionController getSubscriptionController() {
        SubscriptionController subscriptionController = x4.a.a().getSubscriptionController();
        Intrinsics.checkNotNullExpressionValue(subscriptionController, "getInstance().subscriptionController");
        return subscriptionController;
    }

    @JvmStatic
    public static /* synthetic */ void getSubscriptionController$annotations() {
    }

    public static final SubscriptionService getSubscriptionService() {
        SubscriptionService subscriptionService = x4.a.a().getSubscriptionService();
        Intrinsics.checkNotNullExpressionValue(subscriptionService, "getInstance().subscriptionService");
        return subscriptionService;
    }

    @JvmStatic
    public static /* synthetic */ void getSubscriptionService$annotations() {
    }

    public static final long getTotalRequestDataSize() {
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        return i3Var.p();
    }

    @JvmStatic
    public static /* synthetic */ void getTotalRequestDataSize$annotations() {
    }

    public static final long getTotalResponseDataSize() {
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        return i3Var.q();
    }

    @JvmStatic
    public static /* synthetic */ void getTotalResponseDataSize$annotations() {
    }

    public static final TransferAccountService getTransferAccountService() {
        TransferAccountService transferAccountService = x4.a.a().getTransferAccountService();
        Intrinsics.checkNotNullExpressionValue(transferAccountService, "getInstance().transferAccountService");
        return transferAccountService;
    }

    @JvmStatic
    public static /* synthetic */ void getTransferAccountService$annotations() {
    }

    public static final VirtualCurrencyService getVirtualCurrencyService() {
        VirtualCurrencyService virtualCurrencyService = x4.a.a().getVirtualCurrencyService();
        Intrinsics.checkNotNullExpressionValue(virtualCurrencyService, "getInstance().virtualCurrencyService");
        return virtualCurrencyService;
    }

    @JvmStatic
    public static /* synthetic */ void getVirtualCurrencyService$annotations() {
    }

    @JvmStatic
    public static final void init(Application application, EventHandler eventHandler) {
        Intrinsics.checkNotNullParameter(application, "application");
        init(application, eventHandler, true);
    }

    public static final boolean isSandbox() {
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        return i3Var.r();
    }

    @JvmStatic
    public static /* synthetic */ void isSandbox$annotations() {
    }

    @JvmStatic
    public static final void resetDeviceAccount() {
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        i3Var.s();
    }

    @JvmStatic
    public static final void retryBaaSAuth(boolean avoidMultipleDeviceAccounts, final BaaSUser.AuthorizationCallback callback) {
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        i3Var.a(avoidMultipleDeviceAccounts, new BaaSUser.AuthorizationCallback() { // from class: com.nintendo.npf.sdk.NPFSDK.retryBaaSAuth.1
            @Override // com.nintendo.npf.sdk.user.BaaSUser.AuthorizationCallback
            public void onComplete(BaaSUser user, NPFError error) {
                BaaSUser.AuthorizationCallback authorizationCallback = callback;
                if (authorizationCallback != null) {
                    authorizationCallback.onComplete(user, error);
                }
            }
        });
    }

    @JvmStatic
    public static final void retryPendingAuthorizationByNintendoAccount2(Function2<? super NintendoAccount, ? super NPFError, Unit> callback) {
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        i3Var.a(new c(callback));
    }

    @JvmStatic
    public static final void setActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        x4.a.a().setActivity(activity);
    }

    public static final void setLanguage(String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        i3Var.a(language);
    }

    public static final void setReadTimeout(int i) {
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        i3Var.a(i);
    }

    public static final void setRequestTimeout(int i) {
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        i3Var.b(i);
    }

    @JvmStatic
    public static final void init(Application application, final EventHandler eventHandler, boolean immediateLogin) {
        Intrinsics.checkNotNullParameter(application, "application");
        synchronized (LOCK) {
            if (!isInitialized) {
                isInitialized = true;
                x4.a.a(application);
                i3 npfsdk = x4.a.a().getNPFSDK();
                Intrinsics.checkNotNullExpressionValue(npfsdk, "getInstance().npfsdk");
                instance = npfsdk;
            }
            Unit unit = Unit.INSTANCE;
        }
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        i3Var.a(new EventHandler() { // from class: com.nintendo.npf.sdk.NPFSDK.init.2
            @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
            public void onBaaSAuthError(NPFError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                EventHandler eventHandler2 = eventHandler;
                if (eventHandler2 != null) {
                    eventHandler2.onBaaSAuthError(error);
                }
            }

            @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
            public void onBaaSAuthStart() {
                EventHandler eventHandler2 = eventHandler;
                if (eventHandler2 != null) {
                    eventHandler2.onBaaSAuthStart();
                }
            }

            @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
            public void onBaaSAuthUpdate(BaaSUser user) {
                Intrinsics.checkNotNullParameter(user, "user");
                EventHandler eventHandler2 = eventHandler;
                if (eventHandler2 != null) {
                    eventHandler2.onBaaSAuthUpdate(user);
                }
            }

            @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
            public void onNintendoAccountAuthError(NPFError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                EventHandler eventHandler2 = eventHandler;
                if (eventHandler2 != null) {
                    eventHandler2.onNintendoAccountAuthError(error);
                }
            }

            @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
            public void onPendingAuthorizationByNintendoAccount2() {
                EventHandler eventHandler2 = eventHandler;
                if (eventHandler2 != null) {
                    eventHandler2.onPendingAuthorizationByNintendoAccount2();
                }
            }

            @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
            public void onPendingSwitchByNintendoAccount2() {
                EventHandler eventHandler2 = eventHandler;
                if (eventHandler2 != null) {
                    eventHandler2.onPendingSwitchByNintendoAccount2();
                }
            }

            @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
            public void onVirtualCurrencyPurchaseProcessError(NPFError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                EventHandler eventHandler2 = eventHandler;
                if (eventHandler2 != null) {
                    eventHandler2.onVirtualCurrencyPurchaseProcessError(error);
                }
            }

            @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
            public void onVirtualCurrencyPurchaseProcessSuccess(Map<String, VirtualCurrencyWallet> wallets) {
                Intrinsics.checkNotNullParameter(wallets, "wallets");
                EventHandler eventHandler2 = eventHandler;
                if (eventHandler2 != null) {
                    eventHandler2.onVirtualCurrencyPurchaseProcessSuccess(wallets);
                }
            }

            @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
            public void onVirtualCurrencyPurchasesUpdated() {
                EventHandler eventHandler2 = eventHandler;
                if (eventHandler2 != null) {
                    eventHandler2.onVirtualCurrencyPurchasesUpdated();
                }
            }
        }, immediateLogin);
    }

    @JvmStatic
    public static final void retryBaaSAuth(String deviceAccount, String devicePassword, final BaaSUser.AuthorizationCallback callback) {
        Intrinsics.checkNotNullParameter(deviceAccount, "deviceAccount");
        Intrinsics.checkNotNullParameter(devicePassword, "devicePassword");
        i3 i3Var = instance;
        if (i3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            i3Var = null;
        }
        i3Var.a(deviceAccount, devicePassword, new BaaSUser.AuthorizationCallback() { // from class: com.nintendo.npf.sdk.NPFSDK.retryBaaSAuth.2
            @Override // com.nintendo.npf.sdk.user.BaaSUser.AuthorizationCallback
            public void onComplete(BaaSUser user, NPFError error) {
                BaaSUser.AuthorizationCallback authorizationCallback = callback;
                if (authorizationCallback != null) {
                    authorizationCallback.onComplete(user, error);
                }
            }
        });
    }
}
