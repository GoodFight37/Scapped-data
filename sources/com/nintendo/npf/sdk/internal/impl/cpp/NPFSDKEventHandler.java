package com.nintendo.npf.sdk.internal.impl.cpp;

import android.app.Activity;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.core.x4;
import com.nintendo.npf.sdk.internal.impl.NativeBridgeUtil;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyWallet;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NPFSDKEventHandler implements NPFSDK.EventHandler, BaaSUser.AuthorizationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f853a;
    private long b;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final x4 f854a = x4.a.a();
    }

    public NPFSDKEventHandler() {
        this.f853a = -1L;
        this.b = -1L;
    }

    public static void enableGoogleAdvertisingId(boolean z) {
        NPFSDK.getAnalyticsService().enableGoogleAdvertisingId(z);
    }

    public static String getAppVersion() {
        return a.f854a.getCapabilities().getAppVersion();
    }

    public static String getDeviceName() {
        return a.f854a.getCapabilities().getDeviceName();
    }

    public static String getMarket() {
        return NativeBridgeUtil.getMarket();
    }

    public static String getRuntimeOSVersion() {
        return NativeBridgeUtil.getRuntimeOSVersion();
    }

    public static String getTargetedOS() {
        return NativeBridgeUtil.getTargetedOS();
    }

    public static String getTimeZone() {
        return a.f854a.getCapabilities().getTimeZoneName();
    }

    public static int getTimeZoneOffsetMin() {
        return NativeBridgeUtil.getTimeZoneOffsetMin();
    }

    public static void init(Activity activity, int i) {
        NPFSDK.init(activity.getApplication(), new NPFSDKEventHandler(), i > 0);
        NPFSDK.setActivity(activity);
    }

    public static boolean isSuspended() {
        return NPFSDK.getAnalyticsService().isSuspended();
    }

    private static native void onAuthorizationCallback(long j, long j2, String str, String str2);

    private static native void onBaaSAuthError(String str);

    private static native void onBaaSAuthStart(String str);

    private static native void onBaaSAuthUpdate(String str);

    private static native void onNintendoAccountAuthError(String str);

    private static native void onPendingAuthorizationByNintendoAccount2Jni();

    private static native void onPendingSwitchByNintendoAccount2Jni();

    private static native void onVirtualCurrencyPurchaseProcessError(String str);

    private static native void onVirtualCurrencyPurchaseProcessSuccess(String str);

    private static native void onVirtualCurrencyPurchasesUpdatedJni();

    public static void reportEvent(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        JSONObject jSONObject;
        String str = new String(bArr);
        String str2 = new String(bArr2);
        JSONObject jSONObject2 = null;
        if (bArr3.length > 0) {
            try {
                jSONObject = new JSONObject(new String(bArr3));
            } catch (JSONException e) {
                SDKLog.w("NPFSDKEventHandler", e.getMessage());
                jSONObject = null;
            }
        } else {
            jSONObject = null;
        }
        if (bArr4.length > 0) {
            try {
                jSONObject2 = new JSONObject(new String(bArr4));
            } catch (JSONException e2) {
                SDKLog.w("NPFSDKEventHandler", e2.getMessage());
            }
        }
        NPFSDK.getAnalyticsService().reportEvent(str, str2, jSONObject, jSONObject2);
    }

    public static void resume() {
        NPFSDK.getAnalyticsService().resume();
    }

    public static void retryBaaSAuth(long j, long j2, boolean z) {
        NPFSDK.retryBaaSAuth(z, new NPFSDKEventHandler(j, j2));
    }

    public static void suspend() {
        NPFSDK.getAnalyticsService().suspend();
    }

    @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
    public void onBaaSAuthError(NPFError nPFError) {
        try {
            onBaaSAuthError(NativeBridgeUtil.toJsonFromNPFError(nPFError).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
    public void onBaaSAuthStart() {
        onBaaSAuthStart("");
    }

    @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
    public void onBaaSAuthUpdate(BaaSUser baaSUser) {
        try {
            onBaaSAuthUpdate(NativeBridgeUtil.toJsonFromBaaSUser(baaSUser).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.nintendo.npf.sdk.user.BaaSUser.AuthorizationCallback
    public void onComplete(BaaSUser baaSUser, NPFError nPFError) {
        String str;
        String string;
        String str2;
        String string2 = null;
        if (baaSUser != null) {
            try {
                string = NativeBridgeUtil.toJsonFromBaaSUser(baaSUser).toString();
            } catch (JSONException e) {
                e = e;
                str = null;
                e.printStackTrace();
                str2 = str;
                onAuthorizationCallback(this.f853a, this.b, str2, string2);
            }
        } else {
            string = null;
        }
        if (nPFError != null) {
            try {
                string2 = NativeBridgeUtil.toJsonFromNPFError(nPFError).toString();
            } catch (JSONException e2) {
                str = string;
                e = e2;
                e.printStackTrace();
                str2 = str;
            }
        }
        str2 = string;
        onAuthorizationCallback(this.f853a, this.b, str2, string2);
    }

    @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
    public void onNintendoAccountAuthError(NPFError nPFError) {
        try {
            onNintendoAccountAuthError(NativeBridgeUtil.toJsonFromNPFError(nPFError).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
    public void onPendingAuthorizationByNintendoAccount2() {
        onPendingAuthorizationByNintendoAccount2Jni();
    }

    @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
    public void onPendingSwitchByNintendoAccount2() {
        onPendingSwitchByNintendoAccount2Jni();
    }

    @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
    public void onVirtualCurrencyPurchaseProcessError(NPFError nPFError) {
        try {
            onVirtualCurrencyPurchaseProcessError(NativeBridgeUtil.toJsonFromNPFError(nPFError).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
    public void onVirtualCurrencyPurchaseProcessSuccess(Map<String, VirtualCurrencyWallet> map) {
        try {
            onVirtualCurrencyPurchaseProcessSuccess(NativeBridgeUtil.toJsonFromVCWallets(map.values()).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
    public void onVirtualCurrencyPurchasesUpdated() {
        onVirtualCurrencyPurchasesUpdatedJni();
    }

    public static void retryBaaSAuth(long j, long j2, byte[] bArr, byte[] bArr2) {
        NPFSDK.retryBaaSAuth(new String(bArr), new String(bArr2), new NPFSDKEventHandler(j, j2));
    }

    public NPFSDKEventHandler(long j, long j2) {
        this.f853a = j;
        this.b = j2;
    }
}
