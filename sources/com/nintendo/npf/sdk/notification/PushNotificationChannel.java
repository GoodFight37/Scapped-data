package com.nintendo.npf.sdk.notification;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public class PushNotificationChannel {

    public interface GetDeviceTokenCallback {
        void onGetDeviceTokenCallbackComplete(String str, NPFError nPFError);
    }

    public interface RegisterDeviceTokenCallback {
        void onRegisterDeviceTokenComplete(NPFError nPFError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit a(GetDeviceTokenCallback getDeviceTokenCallback, String str, NPFError nPFError) {
        if (getDeviceTokenCallback != null) {
            getDeviceTokenCallback.onGetDeviceTokenCallbackComplete(str, nPFError);
        }
        return Unit.INSTANCE;
    }

    public static void getDeviceToken(final GetDeviceTokenCallback getDeviceTokenCallback) {
        NPFSDK.getPushNotificationChannelService().getDeviceToken(new Function2() { // from class: com.nintendo.npf.sdk.notification.PushNotificationChannel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PushNotificationChannel.a(getDeviceTokenCallback, (String) obj, (NPFError) obj2);
            }
        });
    }

    public static void registerDeviceToken(String str, final RegisterDeviceTokenCallback registerDeviceTokenCallback) {
        NPFSDK.getPushNotificationChannelService().registerDeviceToken(str, new Function1() { // from class: com.nintendo.npf.sdk.notification.PushNotificationChannel$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PushNotificationChannel.a(registerDeviceTokenCallback, (NPFError) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit a(RegisterDeviceTokenCallback registerDeviceTokenCallback, NPFError nPFError) {
        if (registerDeviceTokenCallback != null) {
            registerDeviceTokenCallback.onRegisterDeviceTokenComplete(nPFError);
        }
        return Unit.INSTANCE;
    }
}
