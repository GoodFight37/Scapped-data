package com.nintendo.npf.sdk.internal.impl.cpp;

import android.app.Activity;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.internal.impl.NativeBridgeUtil;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.mynintendo.PointProgramService;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class PointProgramServiceEventHandler implements PointProgramService.EventCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f857a = "PointProgramServiceEventHandler";
    private static PointProgramService b;
    private static final PointProgramServiceEventHandler c = new PointProgramServiceEventHandler();

    public static void dissmiss() {
        PointProgramService pointProgramService = b;
        if (pointProgramService != null) {
            pointProgramService.dismiss();
        }
    }

    public static long getDebugCurrentTimestamp() {
        return PointProgramService.getDebugCurrentTimestamp();
    }

    public static void hide() {
        PointProgramService pointProgramService = b;
        if (pointProgramService != null) {
            pointProgramService.hide();
        }
    }

    public static boolean isShowing() {
        PointProgramService pointProgramService = b;
        if (pointProgramService != null) {
            return pointProgramService.isShowing();
        }
        return false;
    }

    private static native void onAppeared();

    private static native void onDismiss(String str);

    private static native void onHide();

    private static native void onNintendoAccountLogin();

    public static void resume(boolean z) {
        PointProgramService pointProgramService = b;
        if (pointProgramService != null) {
            pointProgramService.resume(z);
        }
    }

    public static void setDebugCurrentTimestamp(long j) {
        PointProgramService.setDebugCurrentTimestamp(j);
    }

    public static void showMissionUi(Activity activity, float f, String str) {
        SDKLog.d(f857a, "showMissionUi: widthRate=" + f + " countryCode=" + str);
        PointProgramService.showMissionUI(activity, f, str, c);
    }

    public static void showRewardUi(Activity activity, float f, String str) {
        SDKLog.d(f857a, "showRewardUi: width=" + f + " countryCode=" + str);
        PointProgramService.showRewardUI(activity, f, str, c);
    }

    @Override // com.nintendo.npf.sdk.mynintendo.PointProgramService.EventCallback
    public void onAppeared(PointProgramService pointProgramService) {
        SDKLog.d(f857a, "onAppeared");
        b = pointProgramService;
        onAppeared();
    }

    @Override // com.nintendo.npf.sdk.mynintendo.PointProgramService.EventCallback
    public void onDismiss(NPFError nPFError) {
        SDKLog.d(f857a, "onDisMiss");
        String string = null;
        b = null;
        if (nPFError != null) {
            try {
                string = NativeBridgeUtil.toJsonFromNPFError(nPFError).toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        onDismiss(string);
    }

    @Override // com.nintendo.npf.sdk.mynintendo.PointProgramService.EventCallback
    public void onHide(PointProgramService pointProgramService) {
        SDKLog.d(f857a, "onHide");
        b = pointProgramService;
        onHide();
    }

    @Override // com.nintendo.npf.sdk.mynintendo.PointProgramService.EventCallback
    public void onNintendoAccountLogin(PointProgramService pointProgramService) {
        SDKLog.d(f857a, "onNintendoAccountLogin");
        b = pointProgramService;
        onNintendoAccountLogin();
    }
}
