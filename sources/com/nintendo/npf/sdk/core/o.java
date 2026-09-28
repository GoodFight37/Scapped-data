package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.analytics.ResettableIdType;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.internal.billing.BillingHelper;
import com.nintendo.npf.sdk.internal.model.Capabilities;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.LinkedAccount;
import java.util.Calendar;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements w {
    public static final a f = new a(null);
    private static final String g = "o";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f530a;
    private final com.nintendo.npf.sdk.internal.impl.a b;
    private final o4 c;
    private final p4 d;
    private final ErrorFactory e;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public o(Function0 capabilitiesProvider, com.nintendo.npf.sdk.internal.impl.a localCache, o4 reportManager, p4 reportTimer, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(capabilitiesProvider, "capabilitiesProvider");
        Intrinsics.checkNotNullParameter(localCache, "localCache");
        Intrinsics.checkNotNullParameter(reportManager, "reportManager");
        Intrinsics.checkNotNullParameter(reportTimer, "reportTimer");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f530a = capabilitiesProvider;
        this.b = localCache;
        this.c = reportManager;
        this.d = reportTimer;
        this.e = errorFactory;
    }

    @Override // com.nintendo.npf.sdk.core.w
    public NPFError a(BaaSUser user, String eventCategory, String eventId, JSONObject jSONObject, JSONObject jSONObject2, s sVar, Set permittedAnalyticsTypes, boolean z) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(eventCategory, "eventCategory");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(permittedAnalyticsTypes, "permittedAnalyticsTypes");
        try {
            JSONObject jSONObjectA = a(user, eventCategory, eventId, jSONObject, jSONObject2, z);
            if (sVar != null) {
                a(jSONObjectA, sVar, permittedAnalyticsTypes);
            }
            if (com.nintendo.npf.sdk.internal.impl.b.a(this.b, jSONObjectA)) {
                return null;
            }
            return this.e.create_ProcessCancel_Minus1("Local cache is full");
        } catch (JSONException e) {
            SDKLog.e(g, "create analytics event failed: ", e);
            return this.e.create_UnknownError_9999(e.getMessage());
        }
    }

    @Override // com.nintendo.npf.sdk.core.w
    public boolean isSuspended() {
        return !this.d.a();
    }

    @Override // com.nintendo.npf.sdk.core.w
    public void suspend() {
        if (isSuspended()) {
            return;
        }
        this.d.b();
    }

    @Override // com.nintendo.npf.sdk.core.w
    public void a() {
        this.c.a();
    }

    @Override // com.nintendo.npf.sdk.core.w
    public void a(i config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (isSuspended()) {
            this.d.c(config);
            if (config.k()) {
                a();
            }
        }
    }

    private final JSONObject a(BaaSUser baaSUser, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, boolean z) throws JSONException {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        JSONObject deviceInfo = ((Capabilities) this.f530a.invoke()).getDeviceInfo();
        for (LinkedAccount linkedAccount : baaSUser.getLinkedAccounts$NPFSDK_release().values()) {
            deviceInfo.put(linkedAccount.getProviderId() + "Id", linkedAccount.getFederatedId());
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("eventTimestamp", timeInMillis);
        jSONObject3.put("eventCategory", str);
        jSONObject3.put("eventId", str2);
        jSONObject3.put("userId", baaSUser.getUserId());
        jSONObject3.put("market", BillingHelper.getMarket());
        jSONObject3.put("deviceAccount", baaSUser.getDeviceAccount());
        jSONObject3.put("playerState", jSONObject);
        jSONObject3.put("payload", jSONObject2);
        jSONObject3.put("forceSaveUserInfo", z);
        jSONObject3.put("cacheInfo", deviceInfo);
        return jSONObject3;
    }

    private final JSONObject a(JSONObject jSONObject, s sVar, Set set) throws JSONException {
        String value = sVar.b().getValue();
        jSONObject.put("resettableId", sVar.a());
        jSONObject.put("resettableIdType", value);
        jSONObject.put("internalAnalysisOptInFlag", set.contains(ResettableIdType.INTERNAL_ANALYSIS) ? 1 : 0);
        jSONObject.put("targetMarketingOptInFlag", set.contains(ResettableIdType.TARGET_MARKETING) ? 1 : 0);
        return jSONObject;
    }
}
