package com.nintendo.npf.sdk.mynintendo;

import android.app.Activity;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.core.h0;
import com.nintendo.npf.sdk.core.x4;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.Calendar;
import java.util.Locale;
import javax.annotation.Nullable;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public class PointProgramService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f889a = "PointProgramService";
    private static long b = 60000;
    private static long c;

    public interface EventCallback {
        void onAppeared(PointProgramService pointProgramService);

        void onDismiss(@Nullable NPFError nPFError);

        void onHide(PointProgramService pointProgramService);

        void onNintendoAccountLogin(PointProgramService pointProgramService);
    }

    class a implements EventCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ EventCallback f890a;

        a(EventCallback eventCallback) {
            this.f890a = eventCallback;
        }

        @Override // com.nintendo.npf.sdk.mynintendo.PointProgramService.EventCallback
        public void onAppeared(PointProgramService pointProgramService) {
            EventCallback eventCallback = this.f890a;
            if (eventCallback != null) {
                eventCallback.onAppeared(pointProgramService);
            }
        }

        @Override // com.nintendo.npf.sdk.mynintendo.PointProgramService.EventCallback
        public void onDismiss(NPFError nPFError) {
            EventCallback eventCallback = this.f890a;
            if (eventCallback != null) {
                eventCallback.onDismiss(nPFError);
            }
        }

        @Override // com.nintendo.npf.sdk.mynintendo.PointProgramService.EventCallback
        public void onHide(PointProgramService pointProgramService) {
            EventCallback eventCallback = this.f890a;
            if (eventCallback != null) {
                eventCallback.onHide(pointProgramService);
            }
        }

        @Override // com.nintendo.npf.sdk.mynintendo.PointProgramService.EventCallback
        public void onNintendoAccountLogin(PointProgramService pointProgramService) {
            EventCallback eventCallback = this.f890a;
            if (eventCallback != null) {
                eventCallback.onNintendoAccountLogin(pointProgramService);
            }
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final x4 f891a = x4.a.a();
    }

    private static void a(final Activity activity, final float f, final String str, final String str2, EventCallback eventCallback) {
        final a aVar = new a(eventCallback);
        x4 x4Var = b.f891a;
        if (x4Var.getCapabilities().getPointProgramHost() == null || x4Var.getCapabilities().getPointProgramHost().length() == 0) {
            aVar.onDismiss(new NPFError(NPFError.ErrorType.PROCESS_CANCEL, -1, "not set pointProgramHost"));
            return;
        }
        SDKLog.d(f889a, "fragment : " + str2);
        BaaSUser baaSUserC = x4Var.getNPFSDK().c();
        boolean z = h0.c(baaSUserC) && baaSUserC.getNintendoAccount() != null;
        final String language = x4Var.getDeviceDataFacade().getLanguage();
        if (!z) {
            x4Var.getSdkWebViewManager().b(activity, f, a(str, str2, null), language, aVar);
            return;
        }
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        long j = x4Var.getNPFSDK().d().expiresTime;
        if (j == 0 || j - timeInMillis >= b) {
            x4Var.getSdkWebViewManager().b(activity, f, a(str, str2, x4Var.getNPFSDK().c().getNintendoAccount().getAccessToken()), language, aVar);
        } else {
            x4Var.getLoginHandler().a(false, new Function2() { // from class: com.nintendo.npf.sdk.mynintendo.PointProgramService$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PointProgramService.a(str, str2, activity, f, language, aVar, (BaaSUser) obj, (NPFError) obj2);
                }
            });
        }
    }

    public static long getDebugCurrentTimestamp() {
        return c;
    }

    public static long getRetryAuthLimitTime() {
        return b;
    }

    public static void setDebugCurrentTimestamp(long j) {
        if (b.f891a.getCapabilities().isSandbox()) {
            c = j;
        }
    }

    public static void setRetryAuthLimitTime(long j) {
        b = j;
    }

    public static void showMissionUI(Activity activity, float f, String str, EventCallback eventCallback) {
        a(activity, f, str, "mission", eventCallback);
    }

    public static void showRewardUI(Activity activity, float f, String str, EventCallback eventCallback) {
        a(activity, f, str, "reward", eventCallback);
    }

    public void dismiss() {
    }

    public void hide() {
    }

    public boolean isShowing() {
        return false;
    }

    public void resume(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit a(String str, String str2, Activity activity, float f, String str3, EventCallback eventCallback, BaaSUser baaSUser, NPFError nPFError) {
        x4 x4Var = b.f891a;
        x4Var.getSdkWebViewManager().b(activity, f, a(str, str2, x4Var.getNPFSDK().c().getNintendoAccount().getAccessToken()), str3, eventCallback);
        return Unit.INSTANCE;
    }

    private static String a(String str, String str2, String str3) {
        String str4;
        String str5 = "";
        if (str3 == null) {
            str4 = "";
        } else {
            str4 = "&access_token=" + str3;
        }
        x4 x4Var = b.f891a;
        if (x4Var.getCapabilities().isSandbox() && c > 0) {
            str5 = "&debug_current_timestamp=" + c;
        }
        return String.format(Locale.US, "https://%s/inapp?platform=google&client_id=%s&country=%s&page=%s%s%s", x4Var.getCapabilities().getPointProgramHost(), x4Var.getCapabilities().getClientId(), str, str2, str4, str5);
    }
}
