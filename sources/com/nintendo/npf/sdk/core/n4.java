package com.nintendo.npf.sdk.core;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n4 {
    private static void a(String str, String str2, NPFError nPFError) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("report", str2);
            if (nPFError == null) {
                jSONObject.put("errorType", 0);
                jSONObject.put("errorCode", 0);
                jSONObject.put("errorMessage", FirebaseAnalytics.Param.SUCCESS);
            } else {
                jSONObject.put("errorType", nPFError.getErrorType().getInt());
                jSONObject.put("errorCode", nPFError.getErrorCode());
                jSONObject.put("errorMessage", nPFError.getErrorMessage());
            }
        } catch (JSONException unused) {
        }
        NPFSDK.getAnalyticsService().reportEvent("NPFAUDIT", str, null, jSONObject);
    }

    public static void b(String str, String str2, NPFError nPFError) {
        a(str, str2, nPFError);
    }
}
