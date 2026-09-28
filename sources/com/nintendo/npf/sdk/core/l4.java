package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.notification.PushNotificationChannel;
import com.nintendo.npf.sdk.notification.PushNotificationChannelService;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l4 implements PushNotificationChannelService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f518a;

    public l4(Function0 pushNotificationChannelImplProvider) {
        Intrinsics.checkNotNullParameter(pushNotificationChannelImplProvider, "pushNotificationChannelImplProvider");
        this.f518a = pushNotificationChannelImplProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function2 tmp0, String str, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(str, nPFError);
    }

    @Override // com.nintendo.npf.sdk.notification.PushNotificationChannelService
    public void getDeviceToken(final Function2 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((m4) this.f518a.invoke()).a(new PushNotificationChannel.GetDeviceTokenCallback() { // from class: com.nintendo.npf.sdk.core.l4$$ExternalSyntheticLambda0
            @Override // com.nintendo.npf.sdk.notification.PushNotificationChannel.GetDeviceTokenCallback
            public final void onGetDeviceTokenCallbackComplete(String str, NPFError nPFError) {
                l4.a(callback, str, nPFError);
            }
        });
    }

    @Override // com.nintendo.npf.sdk.notification.PushNotificationChannelService
    public void registerDeviceToken(String str, final Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((m4) this.f518a.invoke()).a(str, new PushNotificationChannel.RegisterDeviceTokenCallback() { // from class: com.nintendo.npf.sdk.core.l4$$ExternalSyntheticLambda1
            @Override // com.nintendo.npf.sdk.notification.PushNotificationChannel.RegisterDeviceTokenCallback
            public final void onRegisterDeviceTokenComplete(NPFError nPFError) {
                l4.a(callback, nPFError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function1 tmp0, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(nPFError);
    }
}
