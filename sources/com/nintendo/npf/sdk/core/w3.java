package com.nintendo.npf.sdk.core;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.helper.ReportHelper;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class w3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f606a;

    public w3(Function0 reportHelperProvider) {
        Intrinsics.checkNotNullParameter(reportHelperProvider, "reportHelperProvider");
        this.f606a = reportHelperProvider;
    }

    public final void a(String eventId, String str, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("report", str);
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
        ((ReportHelper) this.f606a.invoke()).reportEvent("NPFAUDIT", eventId, null, jSONObject);
    }
}
