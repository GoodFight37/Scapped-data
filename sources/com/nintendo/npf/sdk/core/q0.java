package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 extends l0 {
    /* JADX WARN: Code duplicated, block: B:36:0x00a4  */
    @Override // com.nintendo.npf.sdk.core.l0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public p0 fromJSON(JSONObject jSONObject) throws JSONException {
        String str;
        String str2;
        if (jSONObject == null) {
            throw new JSONException("jsonObject is null.");
        }
        String string = "";
        if (l0.hasField(jSONObject, "baasHost")) {
            String string2 = jSONObject.getString("baasHost");
            Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(Con…onstants.FIELD_BAAS_HOST)");
            str = string2;
        } else {
            str = "";
        }
        boolean z = l0.hasField(jSONObject, "printLog") ? jSONObject.getBoolean("printLog") : false;
        boolean z2 = l0.hasField(jSONObject, "debugLog") ? jSONObject.getBoolean("debugLog") : false;
        if (l0.hasField(jSONObject, "clientId")) {
            string = jSONObject.getString("clientId");
            Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(Con…onstants.FIELD_CLIENT_ID)");
        }
        String str3 = string;
        String string3 = l0.hasField(jSONObject, "basicAuthUser") ? jSONObject.getString("basicAuthUser") : null;
        String string4 = l0.hasField(jSONObject, "basicAuthPass") ? jSONObject.getString("basicAuthPass") : null;
        boolean z3 = l0.hasField(jSONObject, "purchaseMock") ? jSONObject.getBoolean("purchaseMock") : false;
        if (l0.hasField(jSONObject, "marketForSandbox")) {
            String string5 = jSONObject.getString("marketForSandbox");
            Intrinsics.checkNotNullExpressionValue(string5, "jsonObject.getString(Con…FIELD_MARKET_FOR_SANDBOX)");
            if (string5.length() > 0) {
                String string6 = jSONObject.getString("marketForSandbox");
                Intrinsics.checkNotNullExpressionValue(string6, "jsonObject.getString(Con…FIELD_MARKET_FOR_SANDBOX)");
                String upperCase = string6.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                str2 = upperCase;
            } else {
                str2 = null;
            }
        } else {
            str2 = null;
        }
        return new p0(str, z, z2, str3, string3, string4, z3, str2, l0.hasField(jSONObject, "useHttp") ? jSONObject.getBoolean("useHttp") : false, l0.hasField(jSONObject, "readTimeout") ? jSONObject.getInt("readTimeout") : 180000, l0.hasField(jSONObject, "requestTimeout") ? jSONObject.getInt("requestTimeout") : 180000, l0.hasField(jSONObject, MapperConstants.CAPABILITIES_FIELD_IS_DISABLED_USING_GOOGLE_ADVERTISING_ID) ? jSONObject.getBoolean(MapperConstants.CAPABILITIES_FIELD_IS_DISABLED_USING_GOOGLE_ADVERTISING_ID) : false, l0.hasField(jSONObject, MapperConstants.CAPABILITIES_FIELD_IS_DISABLED_USING_DEVICE_ANALYTICS_ID) ? jSONObject.getBoolean(MapperConstants.CAPABILITIES_FIELD_IS_DISABLED_USING_DEVICE_ANALYTICS_ID) : false, l0.hasField(jSONObject, "forceEnablePurchaseMock") ? jSONObject.getBoolean("forceEnablePurchaseMock") : false);
    }

    @Override // com.nintendo.npf.sdk.core.l0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JSONObject toJSON(p0 p0Var) {
        throw new UnsupportedOperationException("BuildConfigurationMapper does not have toJSON() functionality");
    }
}
