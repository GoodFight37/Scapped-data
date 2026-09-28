package com.nintendo.npf.sdk.infrastructure.helper;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.core.f;
import com.nintendo.npf.sdk.core.h0;
import com.nintendo.npf.sdk.core.n;
import com.nintendo.npf.sdk.core.w;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.repository.BaasAccountRepository;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\u0018\u0000 #2\u00020\u0001:\u0001\u001bB'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0019\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/helper/ReportHelper;", "", "Lcom/nintendo/npf/sdk/domain/repository/BaasAccountRepository;", "baasAccountRepository", "Lcom/nintendo/npf/sdk/core/w;", "analyticsRepository", "Lcom/nintendo/npf/sdk/core/n;", "analyticsConfigRepository", "Lcom/nintendo/npf/sdk/domain/ErrorFactory;", "errorFactory", "<init>", "(Lcom/nintendo/npf/sdk/domain/repository/BaasAccountRepository;Lcom/nintendo/npf/sdk/core/w;Lcom/nintendo/npf/sdk/core/n;Lcom/nintendo/npf/sdk/domain/ErrorFactory;)V", "", "eventCategory", "eventId", "Lorg/json/JSONObject;", "playerState", "payload", "Lcom/nintendo/npf/sdk/NPFError;", "reportEvent", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)Lcom/nintendo/npf/sdk/NPFError;", "Lcom/nintendo/npf/sdk/core/f;", "action", "", "duration", "sendSessionEvent", "(Lcom/nintendo/npf/sdk/core/f;J)Lcom/nintendo/npf/sdk/NPFError;", "a", "Lcom/nintendo/npf/sdk/domain/repository/BaasAccountRepository;", "b", "Lcom/nintendo/npf/sdk/core/w;", "c", "Lcom/nintendo/npf/sdk/core/n;", "d", "Lcom/nintendo/npf/sdk/domain/ErrorFactory;", "Companion", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ReportHelper {
    private static final String e = "ReportHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final BaasAccountRepository baasAccountRepository;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final w analyticsRepository;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final n analyticsConfigRepository;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final ErrorFactory errorFactory;

    public ReportHelper(BaasAccountRepository baasAccountRepository, w analyticsRepository, n analyticsConfigRepository, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(baasAccountRepository, "baasAccountRepository");
        Intrinsics.checkNotNullParameter(analyticsRepository, "analyticsRepository");
        Intrinsics.checkNotNullParameter(analyticsConfigRepository, "analyticsConfigRepository");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.baasAccountRepository = baasAccountRepository;
        this.analyticsRepository = analyticsRepository;
        this.analyticsConfigRepository = analyticsConfigRepository;
        this.errorFactory = errorFactory;
    }

    public final NPFError reportEvent(String eventCategory, String eventId, JSONObject playerState, JSONObject payload) {
        Intrinsics.checkNotNullParameter(eventCategory, "eventCategory");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        String str = e;
        SDKLog.i(str, "Start reportEvent");
        if (eventCategory.length() == 0) {
            SDKLog.w(str, "Event category is empty");
            return this.errorFactory.create_InvalidParameters_400();
        }
        if (eventId.length() == 0) {
            SDKLog.w(str, "Event id is empty");
            return this.errorFactory.create_InvalidParameters_400();
        }
        BaaSUser currentBaasUser = this.baasAccountRepository.getCurrentBaasUser();
        if (!h0.c(currentBaasUser)) {
            SDKLog.w(str, "User is not logged in");
            return this.errorFactory.create_BaasAccount_NotLoggedIn_401();
        }
        NPFError nPFErrorA = w.a.a(this.analyticsRepository, currentBaasUser, eventCategory, eventId, playerState, payload, null, null, false, 224, null);
        if (nPFErrorA != null) {
            return nPFErrorA;
        }
        if (!this.analyticsConfigRepository.a().k()) {
            return null;
        }
        this.analyticsRepository.a();
        return null;
    }

    public final NPFError sendSessionEvent(f action, long duration) {
        Intrinsics.checkNotNullParameter(action, "action");
        SDKLog.d(e, "Analytics session : " + action + " : " + duration);
        try {
            JSONObject jSONObject = new JSONObject();
            String string = action.toString();
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = string.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            jSONObject.put("action", lowerCase);
            jSONObject.put("duration", duration);
            return reportEvent("NPFCOMMON", "SESSION", null, jSONObject);
        } catch (JSONException e2) {
            SDKLog.e(e, "sendSessionEvent error", e2);
            return this.errorFactory.create_Mapper_InvalidJson_422(e2);
        }
    }
}
