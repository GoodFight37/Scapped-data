package com.nintendo.npf.sdk;

import android.app.Activity;
import android.app.Application;
import com.nintendo.npf.sdk.analytics.AnalyticsServiceNative;
import com.nintendo.npf.sdk.audit.AuditServiceNative;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.notification.PushNotificationChannelServiceNative;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.BaasAccountServiceNative;
import com.nintendo.npf.sdk.user.NintendoAccountServiceNative;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyWallet;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002]\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\u000bJ\u000f\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0004\b\f\u0010\u0003R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0015\u001a\u00020\u00118FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0012\u0010\u0013R*\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00168F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010!\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00168F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b \u0010\u0003\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001a\u0010&\u001a\u00020\"8FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0003\u001a\u0004\b#\u0010$R*\u0010+\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\"8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\u0003\u001a\u0004\b'\u0010$\"\u0004\b(\u0010)R\u001a\u00100\u001a\u00020,8FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0003\u001a\u0004\b-\u0010.R\u001a\u00103\u001a\u00020,8FX\u0087\u0004¢\u0006\f\u0012\u0004\b2\u0010\u0003\u001a\u0004\b1\u0010.R\u001a\u00106\u001a\u00020\"8FX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0003\u001a\u0004\b4\u0010$R\u001a\u00109\u001a\u00020\"8FX\u0087\u0004¢\u0006\f\u0012\u0004\b8\u0010\u0003\u001a\u0004\b7\u0010$R\u001a\u0010<\u001a\u00020\"8FX\u0087\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0003\u001a\u0004\b:\u0010$R\u001a\u0010A\u001a\u00020=8FX\u0087\u0004¢\u0006\f\u0012\u0004\b@\u0010\u0003\u001a\u0004\b>\u0010?R\u001a\u0010F\u001a\u00020B8FX\u0087\u0004¢\u0006\f\u0012\u0004\bE\u0010\u0003\u001a\u0004\bC\u0010DR\u001a\u0010K\u001a\u00020G8FX\u0087\u0004¢\u0006\f\u0012\u0004\bJ\u0010\u0003\u001a\u0004\bH\u0010IR\u001a\u0010P\u001a\u00020L8FX\u0087\u0004¢\u0006\f\u0012\u0004\bO\u0010\u0003\u001a\u0004\bM\u0010NR\u001a\u0010U\u001a\u00020Q8FX\u0087\u0004¢\u0006\f\u0012\u0004\bT\u0010\u0003\u001a\u0004\bR\u0010SR\u001a\u0010X\u001a\u00020\"8FX\u0087\u0004¢\u0006\f\u0012\u0004\bW\u0010\u0003\u001a\u0004\bV\u0010$R\u0011\u0010\\\u001a\u00020Y8F¢\u0006\u0006\u001a\u0004\bZ\u0010[¨\u0006^"}, d2 = {"Lcom/nintendo/npf/sdk/NPFSDKNative;", "", "<init>", "()V", "Landroid/app/Application;", "application", "Landroid/app/Activity;", "activity", "", "init", "(Landroid/app/Application;Landroid/app/Activity;)V", "(Landroid/app/Application;)V", "enableCommunicationStatistics", "Lcom/nintendo/npf/sdk/NPFSDKNative$a;", "a", "Lcom/nintendo/npf/sdk/NPFSDKNative$a;", "eventHandlerImpl", "Lcom/nintendo/npf/sdk/NPFSDKNative$EventHandler;", "getEventHandler", "()Lcom/nintendo/npf/sdk/NPFSDKNative$EventHandler;", "getEventHandler$annotations", "eventHandler", "", "value", "getReadTimeout", "()I", "setReadTimeout", "(I)V", "getReadTimeout$annotations", "readTimeout", "getRequestTimeout", "setRequestTimeout", "getRequestTimeout$annotations", "requestTimeout", "", "getSdkVersion", "()Ljava/lang/String;", "getSdkVersion$annotations", "sdkVersion", "getLanguage", "setLanguage", "(Ljava/lang/String;)V", "getLanguage$annotations", "language", "", "getTotalRequestDataSize", "()J", "getTotalRequestDataSize$annotations", "totalRequestDataSize", "getTotalResponseDataSize", "getTotalResponseDataSize$annotations", "totalResponseDataSize", "getNintendoAccountFAQURL", "getNintendoAccountFAQURL$annotations", "nintendoAccountFAQURL", "getNintendoAccountRestartFAQURL", "getNintendoAccountRestartFAQURL$annotations", "nintendoAccountRestartFAQURL", "getNintendoAccountURL", "getNintendoAccountURL$annotations", "nintendoAccountURL", "Lcom/nintendo/npf/sdk/user/BaasAccountServiceNative;", "getBaasAccountService", "()Lcom/nintendo/npf/sdk/user/BaasAccountServiceNative;", "getBaasAccountService$annotations", "baasAccountService", "Lcom/nintendo/npf/sdk/user/NintendoAccountServiceNative;", "getNintendoAccountService", "()Lcom/nintendo/npf/sdk/user/NintendoAccountServiceNative;", "getNintendoAccountService$annotations", "nintendoAccountService", "Lcom/nintendo/npf/sdk/analytics/AnalyticsServiceNative;", "getAnalyticsService", "()Lcom/nintendo/npf/sdk/analytics/AnalyticsServiceNative;", "getAnalyticsService$annotations", "analyticsService", "Lcom/nintendo/npf/sdk/audit/AuditServiceNative;", "getAuditService", "()Lcom/nintendo/npf/sdk/audit/AuditServiceNative;", "getAuditService$annotations", "auditService", "Lcom/nintendo/npf/sdk/notification/PushNotificationChannelServiceNative;", "getPushNotificationChannelService", "()Lcom/nintendo/npf/sdk/notification/PushNotificationChannelServiceNative;", "getPushNotificationChannelService$annotations", "pushNotificationChannelService", "getCapabilities", "getCapabilities$annotations", "capabilities", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "getCurrentBaasUser", "()Lcom/nintendo/npf/sdk/user/BaaSUser;", "currentBaasUser", "EventHandler", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NPFSDKNative {
    public static final NPFSDKNative INSTANCE = new NPFSDKNative();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final a eventHandlerImpl = new a();

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006R\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006R\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006R$\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0006R\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/nintendo/npf/sdk/NPFSDKNative$EventHandler;", "", "baasAuthErrorStream", "Lkotlinx/coroutines/flow/Flow;", "Lcom/nintendo/npf/sdk/NPFError;", "getBaasAuthErrorStream", "()Lkotlinx/coroutines/flow/Flow;", "baasAuthStartStream", "", "getBaasAuthStartStream", "baasAuthUpdateStream", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "getBaasAuthUpdateStream", "nintendoAccountAuthErrorStream", "getNintendoAccountAuthErrorStream", "pendingAuthorizationByNintendoAccountStream", "getPendingAuthorizationByNintendoAccountStream", "pendingAuthorizationBySwitchableNintendoAccountStream", "getPendingAuthorizationBySwitchableNintendoAccountStream", "virtualCurrencyPurchaseProcessErrorStream", "getVirtualCurrencyPurchaseProcessErrorStream", "virtualCurrencyPurchaseProcessSuccessStream", "", "", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyWallet;", "getVirtualCurrencyPurchaseProcessSuccessStream", "virtualCurrencyPurchasesUpdatedStream", "getVirtualCurrencyPurchasesUpdatedStream", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface EventHandler {
        Flow<NPFError> getBaasAuthErrorStream();

        Flow<Unit> getBaasAuthStartStream();

        Flow<BaaSUser> getBaasAuthUpdateStream();

        Flow<NPFError> getNintendoAccountAuthErrorStream();

        Flow<Unit> getPendingAuthorizationByNintendoAccountStream();

        Flow<Unit> getPendingAuthorizationBySwitchableNintendoAccountStream();

        Flow<NPFError> getVirtualCurrencyPurchaseProcessErrorStream();

        Flow<Map<String, VirtualCurrencyWallet>> getVirtualCurrencyPurchaseProcessSuccessStream();

        Flow<Unit> getVirtualCurrencyPurchasesUpdatedStream();
    }

    private static final class a implements EventHandler, NPFSDK.EventHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Channel f397a;
        private final Channel b;
        private final Channel c;
        private final Channel d;
        private final Channel e;
        private final Channel f;
        private final Channel g;
        private final Channel h;
        private final Channel i;

        public a() {
            BufferOverflow bufferOverflow = BufferOverflow.DROP_OLDEST;
            this.f397a = ChannelKt.Channel$default(0, bufferOverflow, null, 5, null);
            this.b = ChannelKt.Channel$default(0, bufferOverflow, null, 5, null);
            this.c = ChannelKt.Channel$default(0, bufferOverflow, null, 5, null);
            this.d = ChannelKt.Channel$default(0, bufferOverflow, null, 5, null);
            this.e = ChannelKt.Channel$default(0, bufferOverflow, null, 5, null);
            this.f = ChannelKt.Channel$default(0, bufferOverflow, null, 5, null);
            this.g = ChannelKt.Channel$default(0, bufferOverflow, null, 5, null);
            this.h = ChannelKt.Channel$default(0, bufferOverflow, null, 5, null);
            this.i = ChannelKt.Channel$default(0, bufferOverflow, null, 5, null);
        }

        @Override // com.nintendo.npf.sdk.NPFSDKNative.EventHandler
        public Flow getBaasAuthErrorStream() {
            return FlowKt.receiveAsFlow(this.c);
        }

        @Override // com.nintendo.npf.sdk.NPFSDKNative.EventHandler
        public Flow getBaasAuthStartStream() {
            return FlowKt.receiveAsFlow(this.f397a);
        }

        @Override // com.nintendo.npf.sdk.NPFSDKNative.EventHandler
        public Flow getBaasAuthUpdateStream() {
            return FlowKt.receiveAsFlow(this.b);
        }

        @Override // com.nintendo.npf.sdk.NPFSDKNative.EventHandler
        public Flow getNintendoAccountAuthErrorStream() {
            return FlowKt.receiveAsFlow(this.d);
        }

        @Override // com.nintendo.npf.sdk.NPFSDKNative.EventHandler
        public Flow getPendingAuthorizationByNintendoAccountStream() {
            return FlowKt.receiveAsFlow(this.e);
        }

        @Override // com.nintendo.npf.sdk.NPFSDKNative.EventHandler
        public Flow getPendingAuthorizationBySwitchableNintendoAccountStream() {
            return FlowKt.receiveAsFlow(this.f);
        }

        @Override // com.nintendo.npf.sdk.NPFSDKNative.EventHandler
        public Flow getVirtualCurrencyPurchaseProcessErrorStream() {
            return FlowKt.receiveAsFlow(this.h);
        }

        @Override // com.nintendo.npf.sdk.NPFSDKNative.EventHandler
        public Flow getVirtualCurrencyPurchaseProcessSuccessStream() {
            return FlowKt.receiveAsFlow(this.g);
        }

        @Override // com.nintendo.npf.sdk.NPFSDKNative.EventHandler
        public Flow getVirtualCurrencyPurchasesUpdatedStream() {
            return FlowKt.receiveAsFlow(this.i);
        }

        @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
        public void onBaaSAuthError(NPFError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            SDKLog.i("FlowEventHandler", "onBaaSAuthError");
            SDKLog.i("FlowEventHandler", "onBaaSAuthError: " + ((Object) ChannelResult.m1771toStringimpl(this.c.mo1750trySendJP2dKIU(error))));
        }

        @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
        public void onBaaSAuthStart() {
            SDKLog.i("FlowEventHandler", "onBaaSAuthStart");
            SDKLog.i("FlowEventHandler", "onBaaSAuthStart: " + ((Object) ChannelResult.m1771toStringimpl(this.f397a.mo1750trySendJP2dKIU(Unit.INSTANCE))));
        }

        @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
        public void onBaaSAuthUpdate(BaaSUser user) {
            Intrinsics.checkNotNullParameter(user, "user");
            SDKLog.i("FlowEventHandler", "onBaaSAuthUpdate");
            SDKLog.i("FlowEventHandler", "onBaaSAuthUpdate: " + ((Object) ChannelResult.m1771toStringimpl(this.b.mo1750trySendJP2dKIU(user))));
        }

        @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
        public void onNintendoAccountAuthError(NPFError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            SDKLog.i("FlowEventHandler", "onNintendoAccountAuthError");
            SDKLog.i("FlowEventHandler", "onNintendoAccountAuthError: " + ((Object) ChannelResult.m1771toStringimpl(this.d.mo1750trySendJP2dKIU(error))));
        }

        @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
        public void onPendingAuthorizationByNintendoAccount2() {
            SDKLog.i("FlowEventHandler", "onPendingAuthorizationByNintendoAccount");
            SDKLog.i("FlowEventHandler", "onPendingAuthorizationByNintendoAccount: " + ((Object) ChannelResult.m1771toStringimpl(this.e.mo1750trySendJP2dKIU(Unit.INSTANCE))));
        }

        @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
        public void onPendingSwitchByNintendoAccount2() {
            SDKLog.i("FlowEventHandler", "onPendingSwitchByNintendoAccount");
            SDKLog.i("FlowEventHandler", "onPendingSwitchByNintendoAccount: " + ((Object) ChannelResult.m1771toStringimpl(this.f.mo1750trySendJP2dKIU(Unit.INSTANCE))));
        }

        @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
        public void onVirtualCurrencyPurchaseProcessError(NPFError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            SDKLog.i("FlowEventHandler", "onVirtualCurrencyPurchaseProcessError");
            SDKLog.i("FlowEventHandler", "onVirtualCurrencyPurchaseProcessError: " + ((Object) ChannelResult.m1771toStringimpl(this.h.mo1750trySendJP2dKIU(error))));
        }

        @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
        public void onVirtualCurrencyPurchaseProcessSuccess(Map wallets) {
            Intrinsics.checkNotNullParameter(wallets, "wallets");
            SDKLog.i("FlowEventHandler", "onVirtualCurrencyPurchaseProcessSuccess");
            SDKLog.i("FlowEventHandler", "onVirtualCurrencyPurchaseProcessSuccess: " + ((Object) ChannelResult.m1771toStringimpl(this.g.mo1750trySendJP2dKIU(wallets))));
        }

        @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
        public void onVirtualCurrencyPurchasesUpdated() {
            SDKLog.i("FlowEventHandler", "onVirtualCurrencyPurchasesUpdated");
            SDKLog.i("FlowEventHandler", "onVirtualCurrencyPurchasesUpdated: " + ((Object) ChannelResult.m1771toStringimpl(this.i.mo1750trySendJP2dKIU(Unit.INSTANCE))));
        }
    }

    private NPFSDKNative() {
    }

    @JvmStatic
    public static final void enableCommunicationStatistics() {
        NPFSDK.enableCommunicationStatistics();
    }

    public static final AnalyticsServiceNative getAnalyticsService() {
        return new AnalyticsServiceNative(NPFSDK.getAnalyticsService());
    }

    @JvmStatic
    public static /* synthetic */ void getAnalyticsService$annotations() {
    }

    public static final AuditServiceNative getAuditService() {
        return new AuditServiceNative(NPFSDK.getAuditService());
    }

    @JvmStatic
    public static /* synthetic */ void getAuditService$annotations() {
    }

    public static final BaasAccountServiceNative getBaasAccountService() {
        return new BaasAccountServiceNative(NPFSDK.getBaasAccountService());
    }

    @JvmStatic
    public static /* synthetic */ void getBaasAccountService$annotations() {
    }

    public static final String getCapabilities() {
        return NPFSDK.getCapabilities();
    }

    @JvmStatic
    public static /* synthetic */ void getCapabilities$annotations() {
    }

    public static final EventHandler getEventHandler() {
        return eventHandlerImpl;
    }

    @JvmStatic
    public static /* synthetic */ void getEventHandler$annotations() {
    }

    public static final String getLanguage() {
        return NPFSDK.getLanguage();
    }

    @JvmStatic
    public static /* synthetic */ void getLanguage$annotations() {
    }

    public static final String getNintendoAccountFAQURL() {
        return NPFSDK.getNintendoAccountFAQURL();
    }

    @Deprecated(message = "Use nintendoAccountRestartFAQURL instead", replaceWith = @ReplaceWith(expression = "nintendoAccountRestartFAQURL", imports = {}))
    @JvmStatic
    public static /* synthetic */ void getNintendoAccountFAQURL$annotations() {
    }

    public static final String getNintendoAccountRestartFAQURL() {
        return NPFSDK.getNintendoAccountRestartFAQURL();
    }

    @JvmStatic
    public static /* synthetic */ void getNintendoAccountRestartFAQURL$annotations() {
    }

    public static final NintendoAccountServiceNative getNintendoAccountService() {
        return new NintendoAccountServiceNative(NPFSDK.getNintendoAccountService());
    }

    @JvmStatic
    public static /* synthetic */ void getNintendoAccountService$annotations() {
    }

    public static final String getNintendoAccountURL() {
        return NPFSDK.getNintendoAccountURL();
    }

    @JvmStatic
    public static /* synthetic */ void getNintendoAccountURL$annotations() {
    }

    public static final PushNotificationChannelServiceNative getPushNotificationChannelService() {
        return new PushNotificationChannelServiceNative(NPFSDK.getPushNotificationChannelService());
    }

    @JvmStatic
    public static /* synthetic */ void getPushNotificationChannelService$annotations() {
    }

    public static final int getReadTimeout() {
        return NPFSDK.getReadTimeout();
    }

    @JvmStatic
    public static /* synthetic */ void getReadTimeout$annotations() {
    }

    public static final int getRequestTimeout() {
        return NPFSDK.getRequestTimeout();
    }

    @JvmStatic
    public static /* synthetic */ void getRequestTimeout$annotations() {
    }

    public static final String getSdkVersion() {
        return NPFSDK.getSdkVersion();
    }

    @JvmStatic
    public static /* synthetic */ void getSdkVersion$annotations() {
    }

    public static final long getTotalRequestDataSize() {
        return NPFSDK.getTotalRequestDataSize();
    }

    @JvmStatic
    public static /* synthetic */ void getTotalRequestDataSize$annotations() {
    }

    public static final long getTotalResponseDataSize() {
        return NPFSDK.getTotalResponseDataSize();
    }

    @JvmStatic
    public static /* synthetic */ void getTotalResponseDataSize$annotations() {
    }

    @Deprecated(message = "Deprecated since 3.6")
    @JvmStatic
    public static final void init(Application application, Activity activity) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(activity, "activity");
        NPFSDK.init(application, eventHandlerImpl);
        NPFSDK.setActivity(activity);
    }

    public static final void setLanguage(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        NPFSDK.setLanguage(value);
    }

    public static final void setReadTimeout(int i) {
        NPFSDK.setReadTimeout(i);
    }

    public static final void setRequestTimeout(int i) {
        NPFSDK.setRequestTimeout(i);
    }

    public final BaaSUser getCurrentBaasUser() {
        return NPFSDK.getCurrentBaaSUser();
    }

    @JvmStatic
    public static final void init(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        NPFSDK.init(application, eventHandlerImpl);
    }
}
