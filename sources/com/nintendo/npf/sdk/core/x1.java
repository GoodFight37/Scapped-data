package com.nintendo.npf.sdk.core;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class x1 extends l0 {
    @Override // com.nintendo.npf.sdk.core.l0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public w1 fromJSON(JSONObject jSONObject) throws JSONException {
        String string;
        String string2;
        if (jSONObject == null) {
            throw new JSONException("jsonObject is null.");
        }
        if (l0.hasField(jSONObject, "accountHost")) {
            string = jSONObject.getString("accountHost");
            Intrinsics.checkNotNullExpressionValue(string, "{\n            jsonObject…D_ACCOUNT_HOST)\n        }");
        } else {
            string = "accounts.nintendo.com";
        }
        if (l0.hasField(jSONObject, "accountApiHost")) {
            string2 = jSONObject.getString("accountApiHost");
            Intrinsics.checkNotNullExpressionValue(string2, "{\n            jsonObject…COUNT_API_HOST)\n        }");
        } else {
            string2 = "api.accounts.nintendo.com";
        }
        String string3 = l0.hasField(jSONObject, "pointProgramHost") ? jSONObject.getString("pointProgramHost") : null;
        int i = l0.hasField(jSONObject, "sessionUpdateInterval") ? jSONObject.getInt("sessionUpdateInterval") : 180000;
        return new w1(string, string2, string3, i >= 180000 ? i : 180000);
    }

    @Override // com.nintendo.npf.sdk.core.l0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JSONObject toJSON(w1 w1Var) {
        throw new UnsupportedOperationException("HostConfigurationMapper does not have toJSON() functionality");
    }
}
