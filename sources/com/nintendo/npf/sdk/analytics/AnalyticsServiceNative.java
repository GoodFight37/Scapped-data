package com.nintendo.npf.sdk.analytics;

import com.nintendo.npf.sdk.core.y0;
import com.nintendo.npf.sdk.core.z0;
import java.util.List;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005JK\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001a\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/nintendo/npf/sdk/analytics/AnalyticsServiceNative;", "", "Lcom/nintendo/npf/sdk/analytics/AnalyticsService;", "analyticsService", "<init>", "(Lcom/nintendo/npf/sdk/analytics/AnalyticsService;)V", "", "eventCategory", "eventId", "", "Lcom/nintendo/npf/sdk/analytics/ResettableIdType;", "resettableIdTypes", "Lorg/json/JSONObject;", "playerState", "payload", "enqueueResettableIdEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lorg/json/JSONObject;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "enqueueBaasUserIdEvent", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspend", "()V", "resume", "a", "Lcom/nintendo/npf/sdk/analytics/AnalyticsService;", "", "isSuspended", "()Z", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnalyticsServiceNative {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AnalyticsService analyticsService;

    static final class a extends Lambda implements Function1 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ JSONObject d;
        final /* synthetic */ JSONObject e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
            super(1);
            this.b = str;
            this.c = str2;
            this.d = jSONObject;
            this.e = jSONObject2;
        }

        public final void a(Function1 it) {
            Intrinsics.checkNotNullParameter(it, "it");
            AnalyticsServiceNative.this.analyticsService.enqueueBaasUserIdEvent(this.b, this.c, this.d, this.e, it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Function1) obj);
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function1 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ List d;
        final /* synthetic */ JSONObject e;
        final /* synthetic */ JSONObject f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, String str2, List list, JSONObject jSONObject, JSONObject jSONObject2) {
            super(1);
            this.b = str;
            this.c = str2;
            this.d = list;
            this.e = jSONObject;
            this.f = jSONObject2;
        }

        public final void a(Function2 it) {
            Intrinsics.checkNotNullParameter(it, "it");
            AnalyticsServiceNative.this.analyticsService.enqueueResettableIdEvent(this.b, this.c, this.d, this.e, this.f, it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Function2) obj);
            return Unit.INSTANCE;
        }
    }

    public AnalyticsServiceNative(AnalyticsService analyticsService) {
        Intrinsics.checkNotNullParameter(analyticsService, "analyticsService");
        this.analyticsService = analyticsService;
    }

    public final Object enqueueBaasUserIdEvent(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, Continuation<? super Unit> continuation) {
        a aVar = new a(str, str2, jSONObject, jSONObject2);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        aVar.invoke(new z0(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? orThrow : Unit.INSTANCE;
    }

    public final Object enqueueResettableIdEvent(String str, String str2, List<? extends ResettableIdType> list, JSONObject jSONObject, JSONObject jSONObject2, Continuation<? super List<? extends ResettableIdType>> continuation) {
        b bVar = new b(str, str2, list, jSONObject, jSONObject2);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        bVar.invoke(new y0(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final boolean isSuspended() {
        return this.analyticsService.isSuspended();
    }

    public final void resume() {
        this.analyticsService.resume();
    }

    public final void suspend() {
        this.analyticsService.suspend();
    }
}
