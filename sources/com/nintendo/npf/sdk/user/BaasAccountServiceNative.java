package com.nintendo.npf.sdk.user;

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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000fJ\u0013\u0010\u0013\u001a\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/nintendo/npf/sdk/user/BaasAccountServiceNative;", "", "Lcom/nintendo/npf/sdk/user/BaasAccountService;", "baasAccountService", "<init>", "(Lcom/nintendo/npf/sdk/user/BaasAccountService;)V", "", "avoidMultipleDeviceAccounts", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "retryBaasAuth", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/nintendo/npf/sdk/user/NintendoAccount;", "nintendoAccount", "", "linkNintendoAccount", "(Lcom/nintendo/npf/sdk/user/NintendoAccount;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchableNintendoAccount", "Lcom/nintendo/npf/sdk/user/SwitchResult;", "switchByNintendoAccount", "save", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchNewBaasUser", "a", "Lcom/nintendo/npf/sdk/user/BaasAccountService;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BaasAccountServiceNative {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final BaasAccountService baasAccountService;

    static final class a extends Lambda implements Function1 {
        final /* synthetic */ NintendoAccount b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(NintendoAccount nintendoAccount) {
            super(1);
            this.b = nintendoAccount;
        }

        public final void a(Function1 it) {
            Intrinsics.checkNotNullParameter(it, "it");
            BaasAccountServiceNative.this.baasAccountService.linkNintendoAccount(this.b, it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Function1) obj);
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function1 {
        final /* synthetic */ boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z) {
            super(1);
            this.b = z;
        }

        public final void a(Function2 it) {
            Intrinsics.checkNotNullParameter(it, "it");
            BaasAccountServiceNative.this.baasAccountService.retryBaasAuth(this.b, it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Function2) obj);
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function1 {
        c() {
            super(1);
        }

        public final void a(Function1 it) {
            Intrinsics.checkNotNullParameter(it, "it");
            BaasAccountServiceNative.this.baasAccountService.save(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Function1) obj);
            return Unit.INSTANCE;
        }
    }

    static final class d extends Lambda implements Function1 {
        final /* synthetic */ NintendoAccount b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(NintendoAccount nintendoAccount) {
            super(1);
            this.b = nintendoAccount;
        }

        public final void a(Function2 it) {
            Intrinsics.checkNotNullParameter(it, "it");
            BaasAccountServiceNative.this.baasAccountService.switchByNintendoAccount(this.b, it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Function2) obj);
            return Unit.INSTANCE;
        }
    }

    static final class e extends Lambda implements Function1 {
        e() {
            super(1);
        }

        public final void a(Function2 it) {
            Intrinsics.checkNotNullParameter(it, "it");
            BaasAccountServiceNative.this.baasAccountService.switchNewBaasUser(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Function2) obj);
            return Unit.INSTANCE;
        }
    }

    public BaasAccountServiceNative(BaasAccountService baasAccountService) {
        Intrinsics.checkNotNullParameter(baasAccountService, "baasAccountService");
        this.baasAccountService = baasAccountService;
    }

    public static /* synthetic */ Object retryBaasAuth$default(BaasAccountServiceNative baasAccountServiceNative, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return baasAccountServiceNative.retryBaasAuth(z, continuation);
    }

    public final Object linkNintendoAccount(NintendoAccount nintendoAccount, Continuation<? super Unit> continuation) {
        a aVar = new a(nintendoAccount);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        aVar.invoke(new z0(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? orThrow : Unit.INSTANCE;
    }

    public final Object retryBaasAuth(boolean z, Continuation<? super BaaSUser> continuation) {
        b bVar = new b(z);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        bVar.invoke(new y0(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object save(Continuation<? super Unit> continuation) {
        c cVar = new c();
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        cVar.invoke(new z0(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? orThrow : Unit.INSTANCE;
    }

    public final Object switchByNintendoAccount(NintendoAccount nintendoAccount, Continuation<? super SwitchResult> continuation) {
        d dVar = new d(nintendoAccount);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        dVar.invoke(new y0(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object switchNewBaasUser(Continuation<? super SwitchResult> continuation) {
        e eVar = new e();
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        eVar.invoke(new y0(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
