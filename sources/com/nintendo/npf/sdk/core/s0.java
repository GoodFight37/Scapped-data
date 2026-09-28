package com.nintendo.npf.sdk.core;

import android.content.Context;
import com.adjust.sdk.AdjustConfig;
import com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.internal.model.Capabilities;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f557a;

    public s0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f557a = context;
    }

    public final JSONObject a(DeviceDataFacade deviceDataFacade, Capabilities capabilities, JSONObject deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceDataFacade, "deviceDataFacade");
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("baasHost", capabilities.getBaasHost());
            jSONObject.put(AdjustConfig.ENVIRONMENT_SANDBOX, capabilities.isSandbox());
            Boolean boolIsPrintLog = capabilities.isPrintLog();
            Intrinsics.checkNotNullExpressionValue(boolIsPrintLog, "capabilities.isPrintLog");
            jSONObject.put("printLog", boolIsPrintLog.booleanValue());
            jSONObject.put("debugLog", capabilities.isDebugLog());
            jSONObject.put("clientId", capabilities.getClientId());
            jSONObject.put("basicAuthUser", capabilities.getBasicAuthUser());
            jSONObject.put("basicAuthPass", capabilities.getBasicAuthPass());
            jSONObject.put("purchaseMock", capabilities.isPurchaseMock());
            jSONObject.put("marketForSandbox", capabilities.getMarketSandbox());
            jSONObject.put("accountHost", capabilities.getAccountHost());
            jSONObject.put("accountApiHost", capabilities.getAccountApiHost());
            jSONObject.put("pointProgramHost", capabilities.getPointProgramHost());
            jSONObject.put("sessionUpdateInterval", capabilities.getSessionUpdateInterval());
            jSONObject.put("useHttp", capabilities.isUsingHttp());
            jSONObject.put("readTimeout", capabilities.getReadTimeout());
            jSONObject.put("requestTimeout", capabilities.getRequestTimeout());
            jSONObject.put(MapperConstants.CAPABILITIES_FIELD_IS_DISABLED_USING_GOOGLE_ADVERTISING_ID, deviceDataFacade.isDisabledUsingGoogleAdvertisingId());
            jSONObject.put(MapperConstants.CAPABILITIES_FIELD_IS_DISABLED_USING_DEVICE_ANALYTICS_ID, deviceDataFacade.isDisabledUsingDeviceAnalyticsId());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("sdkVersion", deviceDataFacade.getSdkVersion());
            jSONObject2.put("buildType", "release");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("packageName", this.f557a.getPackageName());
            jSONObject3.put("signatureSHA1", deviceDataFacade.getSignatureSHA1());
            jSONObject3.put("appVersion", deviceDataFacade.getAppVersion());
            deviceInfo.remove("appVersion");
            deviceInfo.remove("sdkVersion");
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("npf", jSONObject);
            jSONObject4.put("sdk", jSONObject2);
            jSONObject4.put("application", jSONObject3);
            jSONObject4.put("device", deviceInfo);
            return jSONObject4;
        } catch (JSONException unused) {
            return null;
        }
    }
}
