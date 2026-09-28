package com.nintendo.npf.sdk.analytics;

import com.nintendo.npf.sdk.NPFError;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H&JF\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00060\u0010H&Jb\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\"\u0010\u000f\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00060\u0016H&J0\u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\b\u0010\u0018\u001a\u00020\u0006H&J\b\u0010\u0019\u001a\u00020\u0006H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/nintendo/npf/sdk/analytics/AnalyticsService;", "", "isSuspended", "", "()Z", "enableGoogleAdvertisingId", "", "enabled", "enqueueBaasUserIdEvent", "eventCategory", "", "eventId", "playerState", "Lorg/json/JSONObject;", "payload", "callback", "Lkotlin/Function1;", "Lcom/nintendo/npf/sdk/NPFError;", "enqueueResettableIdEvent", "resettableIdTypes", "", "Lcom/nintendo/npf/sdk/analytics/ResettableIdType;", "Lkotlin/Function2;", "reportEvent", "resume", "suspend", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AnalyticsService {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void enqueueBaasUserIdEvent$default(AnalyticsService analyticsService, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueueBaasUserIdEvent");
            }
            analyticsService.enqueueBaasUserIdEvent(str, str2, (i & 4) != 0 ? null : jSONObject, (i & 8) != 0 ? null : jSONObject2, function1);
        }

        public static /* synthetic */ void enqueueResettableIdEvent$default(AnalyticsService analyticsService, String str, String str2, List list, JSONObject jSONObject, JSONObject jSONObject2, Function2 function2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueueResettableIdEvent");
            }
            analyticsService.enqueueResettableIdEvent(str, str2, list, (i & 8) != 0 ? null : jSONObject, (i & 16) != 0 ? null : jSONObject2, function2);
        }

        public static /* synthetic */ void reportEvent$default(AnalyticsService analyticsService, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportEvent");
            }
            if ((i & 4) != 0) {
                jSONObject = null;
            }
            if ((i & 8) != 0) {
                jSONObject2 = null;
            }
            analyticsService.reportEvent(str, str2, jSONObject, jSONObject2);
        }
    }

    void enableGoogleAdvertisingId(boolean enabled);

    void enqueueBaasUserIdEvent(String eventCategory, String eventId, JSONObject playerState, JSONObject payload, Function1<? super NPFError, Unit> callback);

    void enqueueResettableIdEvent(String eventCategory, String eventId, List<? extends ResettableIdType> resettableIdTypes, JSONObject playerState, JSONObject payload, Function2<? super List<? extends ResettableIdType>, ? super NPFError, Unit> callback);

    boolean isSuspended();

    void reportEvent(String eventCategory, String eventId, JSONObject playerState, JSONObject payload);

    void resume();

    void suspend();
}
