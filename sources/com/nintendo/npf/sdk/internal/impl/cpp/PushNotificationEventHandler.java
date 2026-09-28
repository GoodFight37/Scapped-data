package com.nintendo.npf.sdk.internal.impl.cpp;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.internal.impl.NativeBridgeUtil;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class PushNotificationEventHandler {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit a(long j, long j2, NPFError nPFError) {
        String string;
        if (nPFError != null) {
            try {
                string = NativeBridgeUtil.toJsonFromNPFError(nPFError).toString();
            } catch (JSONException e) {
                e.printStackTrace();
                string = null;
            }
        } else {
            string = null;
        }
        onRegisterDeviceTokenCompleteCallback(j, j2, string);
        return Unit.INSTANCE;
    }

    public static void getDeviceToken(final long j, final long j2) {
        NPFSDK.getPushNotificationChannelService().getDeviceToken(new Function2() { // from class: com.nintendo.npf.sdk.internal.impl.cpp.PushNotificationEventHandler$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PushNotificationEventHandler.a(j, j2, (String) obj, (NPFError) obj2);
            }
        });
    }

    private static native void onGetDeviceTokenCompleteCallback(long j, long j2, String str, String str2);

    private static native void onRegisterDeviceTokenCompleteCallback(long j, long j2, String str);

    public static void registerDeviceToken(final long j, final long j2, String str) {
        NPFSDK.getPushNotificationChannelService().registerDeviceToken(str, new Function1() { // from class: com.nintendo.npf.sdk.internal.impl.cpp.PushNotificationEventHandler$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PushNotificationEventHandler.a(j, j2, (NPFError) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit a(long j, long j2, String str, NPFError nPFError) {
        String string = null;
        String str2 = str != null ? str : null;
        if (nPFError != null) {
            try {
                string = NativeBridgeUtil.toJsonFromNPFError(nPFError).toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        onGetDeviceTokenCompleteCallback(j, j2, str2, string);
        return Unit.INSTANCE;
    }
}
