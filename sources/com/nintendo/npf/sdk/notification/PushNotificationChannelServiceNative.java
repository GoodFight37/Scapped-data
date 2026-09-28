package com.nintendo.npf.sdk.notification;

import com.nintendo.npf.sdk.core.y0;
import com.nintendo.npf.sdk.core.z0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/nintendo/npf/sdk/notification/PushNotificationChannelServiceNative;", "", "Lcom/nintendo/npf/sdk/notification/PushNotificationChannelService;", "pushNotificationChannelService", "<init>", "(Lcom/nintendo/npf/sdk/notification/PushNotificationChannelService;)V", "", "getDeviceToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deviceToken", "", "registerDeviceToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Lcom/nintendo/npf/sdk/notification/PushNotificationChannelService;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PushNotificationChannelServiceNative {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final PushNotificationChannelService pushNotificationChannelService;

    static final class a extends Lambda implements Function1 {
        a() {
            super(1);
        }

        public final void a(Function2 it) {
            Intrinsics.checkNotNullParameter(it, "it");
            PushNotificationChannelServiceNative.this.pushNotificationChannelService.getDeviceToken(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Function2) obj);
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function1 {
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.b = str;
        }

        public final void a(Function1 it) {
            Intrinsics.checkNotNullParameter(it, "it");
            PushNotificationChannelServiceNative.this.pushNotificationChannelService.registerDeviceToken(this.b, it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Function1) obj);
            return Unit.INSTANCE;
        }
    }

    public PushNotificationChannelServiceNative(PushNotificationChannelService pushNotificationChannelService) {
        Intrinsics.checkNotNullParameter(pushNotificationChannelService, "pushNotificationChannelService");
        this.pushNotificationChannelService = pushNotificationChannelService;
    }

    public final Object getDeviceToken(Continuation<? super String> continuation) {
        a aVar = new a();
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        aVar.invoke(new y0(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object registerDeviceToken(String str, Continuation<? super Unit> continuation) {
        b bVar = new b(str);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        bVar.invoke(new z0(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? orThrow : Unit.INSTANCE;
    }
}
