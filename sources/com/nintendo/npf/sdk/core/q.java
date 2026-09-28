package com.nintendo.npf.sdk.core;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.helper.ReportHelper;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f546a;

    public q(Function0 reportHelperProvider) {
        Intrinsics.checkNotNullParameter(reportHelperProvider, "reportHelperProvider");
        this.f546a = reportHelperProvider;
    }

    public final void a(String eventId, String report, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(report, "report");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("report", report);
            if (nPFError == null) {
                jSONObject.put("errorType", 0);
                jSONObject.put("errorCode", 0);
                jSONObject.put("errorMessage", FirebaseAnalytics.Param.SUCCESS);
            } else {
                jSONObject.put("errorType", nPFError.getErrorType().getInt());
                jSONObject.put("errorCode", nPFError.getErrorCode());
                jSONObject.put("errorMessage", nPFError.getErrorMessage());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ((ReportHelper) this.f546a.invoke()).reportEvent("NPFAUDIT", eventId, null, jSONObject);
    }
}
