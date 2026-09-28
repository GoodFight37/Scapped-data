package com.unity3d.player;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.unity3d.player.a.AbstractC0086t;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ApplicationExitInfoProvider {
    public static ApplicationExitInfoBase[] getHistoricalProcessExitReasons(Activity activity, String str, int i, int i2) {
        ActivityManager activityManager = (ActivityManager) activity.getSystemService(ActivityManager.class);
        if (PlatformSupport.RED_VELVET_CAKE_SUPPORT) {
            List<ApplicationExitInfo> historicalProcessExitReasons = activityManager.getHistoricalProcessExitReasons(str, i, i2);
            int size = historicalProcessExitReasons.size();
            ApplicationExitInfoBase[] applicationExitInfoBaseArr = new ApplicationExitInfoBase[size];
            for (int i3 = 0; i3 < size; i3++) {
                applicationExitInfoBaseArr[i3] = new ApplicationExitInfoWrapper(historicalProcessExitReasons.get(i3));
            }
            return applicationExitInfoBaseArr;
        }
        AbstractC0086t.Log(5, "ApplicationExitInfoProvider: ApplicationExitInfo is only available from api 30 (Android 11)");
        return null;
    }

    public static void setProcessStateSummary(Activity activity, byte[] bArr) {
        if (PlatformSupport.RED_VELVET_CAKE_SUPPORT) {
            ((ActivityManager) activity.getSystemService(ActivityManager.class)).setProcessStateSummary(bArr);
        }
    }

    public static String getANRRecordsJson(int i) {
        ApplicationExitInfoBase[] historicalProcessExitReasons;
        Activity activity = UnityPlayer.currentActivity;
        return (activity == null || (historicalProcessExitReasons = getHistoricalProcessExitReasons(activity, UnityPlayer.currentContext.getPackageName(), 0, i)) == null) ? "" : toJson(historicalProcessExitReasons).toString();
    }

    public static JSONArray toJson(ApplicationExitInfoBase[] applicationExitInfoBaseArr) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        int i = -1;
        for (ApplicationExitInfoBase applicationExitInfoBase : applicationExitInfoBaseArr) {
            i++;
            if (applicationExitInfoBase.getReason() == 6) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_DESCRIPTION, applicationExitInfoBase.getDescription());
                jSONObject.put("trace", applicationExitInfoBase.getTraceString());
                jSONObject.put("timestamp", applicationExitInfoBase.getTimestamp() * 1000000);
                jSONObject.put(FirebaseAnalytics.Param.INDEX, i);
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }
}
