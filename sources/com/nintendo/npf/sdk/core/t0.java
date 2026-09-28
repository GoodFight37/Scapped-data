package com.nintendo.npf.sdk.core;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes2.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f564a;
    private final Mutex b;
    private final w4 c;

    static final class a extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f565a;
        Object b;
        Object c;
        Object d;
        int e;
        private /* synthetic */ Object f;
        final /* synthetic */ Object h;
        final /* synthetic */ Function1 i;

        /* JADX INFO: renamed from: com.nintendo.npf.sdk.core.t0$a$a, reason: collision with other inner class name */
        static final class C0034a extends SuspendLambda implements Function2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f566a;
            Object b;
            Object c;
            Object d;
            int e;
            final /* synthetic */ t0 f;
            final /* synthetic */ Function1 g;
            final /* synthetic */ Object h;

            /* JADX INFO: renamed from: com.nintendo.npf.sdk.core.t0$a$a$a, reason: collision with other inner class name */
            static final class C0035a extends SuspendLambda implements Function1 {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f567a;
                final /* synthetic */ Function1 b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0035a(Function1 function1, Continuation continuation) {
                    super(1, continuation);
                    this.b = function1;
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(Continuation continuation) {
                    return ((C0035a) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Continuation continuation) {
                    return new C0035a(this.b, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.f567a;
                    if (i != 0) {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    ResultKt.throwOnFailure(obj);
                    Function1 function1 = this.b;
                    this.f567a = 1;
                    Object objInvoke = function1.invoke(this);
                    return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0034a(t0 t0Var, Function1 function1, Object obj, Continuation continuation) {
                super(2, continuation);
                this.f = t0Var;
                this.g = function1;
                this.h = obj;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C0034a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C0034a(this.f, this.g, this.h, continuation);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v11 */
            /* JADX WARN: Type inference failed for: r2v12 */
            /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, kotlinx.coroutines.sync.Mutex] */
            /* JADX WARN: Type inference failed for: r2v6, types: [kotlinx.coroutines.sync.Mutex] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Throwable th;
                t0 t0Var;
                Mutex mutex;
                Object obj2;
                t0 t0Var2;
                Object obj3;
                Object obj4;
                ?? r2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.e;
                ?? r3 = 3;
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        w4 w4Var = this.f.c;
                        C0035a c0035a = new C0035a(this.g, null);
                        this.e = 1;
                        obj = w4Var.a(c0035a, this);
                        if (obj != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            if (i != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            obj2 = this.d;
                            t0Var = (t0) this.c;
                            mutex = (Mutex) this.b;
                            th = (Throwable) this.f566a;
                            ResultKt.throwOnFailure(obj);
                            try {
                                throw th;
                            } finally {
                                mutex.unlock(null);
                            }
                        }
                        obj4 = this.d;
                        t0Var2 = (t0) this.c;
                        Mutex mutex2 = (Mutex) this.b;
                        obj3 = this.f566a;
                        ResultKt.throwOnFailure(obj);
                        r2 = mutex2;
                    }
                    try {
                        return obj3;
                    } finally {
                        r2.unlock(null);
                    }
                    r3 = this.f.b;
                    t0Var2 = this.f;
                    Object obj5 = this.h;
                    this.f566a = obj;
                    this.b = r3;
                    this.c = t0Var2;
                    this.d = obj5;
                    this.e = 2;
                    if (r3.lock(null, this) != coroutine_suspended) {
                        obj3 = obj;
                        obj4 = obj5;
                        r2 = r3;
                        return obj3;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    Mutex mutex3 = this.f.b;
                    t0Var = this.f;
                    Object obj6 = this.h;
                    this.f566a = th;
                    this.b = mutex3;
                    this.c = t0Var;
                    this.d = obj6;
                    this.e = r3;
                    if (mutex3.lock(null, this) != coroutine_suspended) {
                        mutex = mutex3;
                        obj2 = obj6;
                    }
                    return coroutine_suspended;
                }
                return coroutine_suspended;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Object obj, Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.h = obj;
            this.i = function1;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            a aVar = t0.this.new a(this.h, this.i, continuation);
            aVar.f = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Mutex mutex;
            t0 t0Var;
            Function1 function1;
            Object obj2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = (CoroutineScope) this.f;
                    mutex = t0.this.b;
                    t0Var = t0.this;
                    Object obj3 = this.h;
                    function1 = this.i;
                    this.f = coroutineScope;
                    this.f565a = mutex;
                    this.b = t0Var;
                    this.c = obj3;
                    this.d = function1;
                    this.e = 1;
                    if (mutex.lock(null, this) != coroutine_suspended) {
                        obj2 = obj3;
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                function1 = (Function1) this.d;
                obj2 = this.c;
                t0Var = (t0) this.b;
                mutex = (Mutex) this.f565a;
                coroutineScope = (CoroutineScope) this.f;
                ResultKt.throwOnFailure(obj);
                Deferred deferredAsync$default = (Deferred) t0Var.f564a.get(obj2);
                if (deferredAsync$default == null) {
                    deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new C0034a(t0Var, function1, obj2, null), 3, null);
                    t0Var.f564a.put(obj2, deferredAsync$default);
                }
                mutex.unlock(null);
                this.f = null;
                this.f565a = null;
                this.b = null;
                this.c = null;
                this.d = null;
                this.e = 2;
                Object objAwait = deferredAsync$default.await(this);
                return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
    }

    public t0(CoroutineScope scope, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.f564a = new LinkedHashMap();
        this.b = MutexKt.Mutex$default(false, 1, null);
        this.c = new w4(scope, dispatcher);
    }

    public final Object a(Object obj, Function1 function1, Continuation continuation) {
        return CoroutineScopeKt.coroutineScope(new a(obj, function1, null), continuation);
    }
}
