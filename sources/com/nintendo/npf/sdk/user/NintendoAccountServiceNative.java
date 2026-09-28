package com.nintendo.npf.sdk.user;

import android.app.Activity;
import com.nintendo.npf.sdk.core.y0;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005JC\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJC\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000fJ\u0013\u0010\u0011\u001a\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/nintendo/npf/sdk/user/NintendoAccountServiceNative;", "", "Lcom/nintendo/npf/sdk/user/NintendoAccountService;", "nintendoAccountService", "<init>", "(Lcom/nintendo/npf/sdk/user/NintendoAccountService;)V", "Landroid/app/Activity;", "activity", "", "", "scope", "", "optionalQuery", "Lcom/nintendo/npf/sdk/user/NintendoAccount;", "authorizeByNintendoAccount", "(Landroid/app/Activity;Ljava/util/List;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authorizeBySwitchableNintendoAccount", "retryPendingAuthorizationByNintendoAccount", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retryPendingAuthorizationBySwitchableNintendoAccount", "a", "Lcom/nintendo/npf/sdk/user/NintendoAccountService;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NintendoAccountServiceNative {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final NintendoAccountService nintendoAccountService;

    static final class a extends Lambda implements Function1 {
        final /* synthetic */ Activity b;
        final /* synthetic */ List c;
        final /* synthetic */ Map d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Activity activity, List list, Map map) {
            super(1);
            this.b = activity;
            this.c = list;
            this.d = map;
        }

        public final void a(Function2 it) {
            Intrinsics.checkNotNullParameter(it, "it");
            NintendoAccountServiceNative.this.nintendoAccountService.authorizeByNintendoAccount(this.b, this.c, this.d, it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Function2) obj);
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function1 {
        final /* synthetic */ Activity b;
        final /* synthetic */ List c;
        final /* synthetic */ Map d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Activity activity, List list, Map map) {
            super(1);
            this.b = activity;
            this.c = list;
            this.d = map;
        }

        public final void a(Function2 it) {
            Intrinsics.checkNotNullParameter(it, "it");
            NintendoAccountServiceNative.this.nintendoAccountService.authorizeBySwitchableNintendoAccount(this.b, this.c, this.d, it);
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

        public final void a(Function2 it) {
            Intrinsics.checkNotNullParameter(it, "it");
            NintendoAccountServiceNative.this.nintendoAccountService.retryPendingAuthorizationByNintendoAccount(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Function2) obj);
            return Unit.INSTANCE;
        }
    }

    static final class d extends Lambda implements Function1 {
        d() {
            super(1);
        }

        public final void a(Function2 it) {
            Intrinsics.checkNotNullParameter(it, "it");
            NintendoAccountServiceNative.this.nintendoAccountService.retryPendingAuthorizationBySwitchableNintendoAccount(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Function2) obj);
            return Unit.INSTANCE;
        }
    }

    public NintendoAccountServiceNative(NintendoAccountService nintendoAccountService) {
        Intrinsics.checkNotNullParameter(nintendoAccountService, "nintendoAccountService");
        this.nintendoAccountService = nintendoAccountService;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object authorizeByNintendoAccount$default(NintendoAccountServiceNative nintendoAccountServiceNative, Activity activity, List list, Map map, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        return nintendoAccountServiceNative.authorizeByNintendoAccount(activity, list, map, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object authorizeBySwitchableNintendoAccount$default(NintendoAccountServiceNative nintendoAccountServiceNative, Activity activity, List list, Map map, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        return nintendoAccountServiceNative.authorizeBySwitchableNintendoAccount(activity, list, map, continuation);
    }

    public final Object authorizeByNintendoAccount(Activity activity, List<String> list, Map<String, String> map, Continuation<? super NintendoAccount> continuation) {
        a aVar = new a(activity, list, map);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        aVar.invoke(new y0(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object authorizeBySwitchableNintendoAccount(Activity activity, List<String> list, Map<String, String> map, Continuation<? super NintendoAccount> continuation) {
        b bVar = new b(activity, list, map);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        bVar.invoke(new y0(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object retryPendingAuthorizationByNintendoAccount(Continuation<? super NintendoAccount> continuation) {
        c cVar = new c();
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        cVar.invoke(new y0(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object retryPendingAuthorizationBySwitchableNintendoAccount(Continuation<? super NintendoAccount> continuation) {
        d dVar = new d();
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        dVar.invoke(new y0(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
