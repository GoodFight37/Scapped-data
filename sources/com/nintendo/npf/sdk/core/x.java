package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f611a = new x();
    private static final CoroutineScope b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));

    static final class a extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f612a;
        final /* synthetic */ Function1 b;
        final /* synthetic */ Function2 c;

        /* JADX INFO: renamed from: com.nintendo.npf.sdk.core.x$a$a, reason: collision with other inner class name */
        static final class C0040a extends SuspendLambda implements Function2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f613a;
            final /* synthetic */ Function2 b;
            final /* synthetic */ Object c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0040a(Function2 function2, Object obj, Continuation continuation) {
                super(2, continuation);
                this.b = function2;
                this.c = obj;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C0040a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C0040a(this.b, this.c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f613a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.b.invoke(this.c, null);
                return Unit.INSTANCE;
            }
        }

        static final class b extends SuspendLambda implements Function2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f614a;
            final /* synthetic */ Function2 b;
            final /* synthetic */ NPFException c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Function2 function2, NPFException nPFException, Continuation continuation) {
                super(2, continuation);
                this.b = function2;
                this.c = nPFException;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new b(this.b, this.c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f614a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.b.invoke(null, this.c.getError());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Function1 function1, Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.b = function1;
            this.c = function2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new a(this.b, this.c, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r1, r5, r7) == r0) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r1, r4, r7) == r0) goto L24;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.f612a
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L28
                if (r1 == r5) goto L22
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r8)
                goto L5e
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1e:
                kotlin.ResultKt.throwOnFailure(r8)     // Catch: com.nintendo.npf.sdk.NPFException -> L26
                goto L5e
            L22:
                kotlin.ResultKt.throwOnFailure(r8)     // Catch: com.nintendo.npf.sdk.NPFException -> L26
                goto L36
            L26:
                r8 = move-exception
                goto L4a
            L28:
                kotlin.ResultKt.throwOnFailure(r8)
                kotlin.jvm.functions.Function1 r8 = r7.b     // Catch: com.nintendo.npf.sdk.NPFException -> L26
                r7.f612a = r5     // Catch: com.nintendo.npf.sdk.NPFException -> L26
                java.lang.Object r8 = r8.invoke(r7)     // Catch: com.nintendo.npf.sdk.NPFException -> L26
                if (r8 != r0) goto L36
                goto L5d
            L36:
                kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: com.nintendo.npf.sdk.NPFException -> L26
                com.nintendo.npf.sdk.core.x$a$a r5 = new com.nintendo.npf.sdk.core.x$a$a     // Catch: com.nintendo.npf.sdk.NPFException -> L26
                kotlin.jvm.functions.Function2 r6 = r7.c     // Catch: com.nintendo.npf.sdk.NPFException -> L26
                r5.<init>(r6, r8, r2)     // Catch: com.nintendo.npf.sdk.NPFException -> L26
                r7.f612a = r4     // Catch: com.nintendo.npf.sdk.NPFException -> L26
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r1, r5, r7)     // Catch: com.nintendo.npf.sdk.NPFException -> L26
                if (r8 != r0) goto L5e
                goto L5d
            L4a:
                kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
                com.nintendo.npf.sdk.core.x$a$b r4 = new com.nintendo.npf.sdk.core.x$a$b
                kotlin.jvm.functions.Function2 r5 = r7.c
                r4.<init>(r5, r8, r2)
                r7.f612a = r3
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r1, r4, r7)
                if (r8 != r0) goto L5e
            L5d:
                return r0
            L5e:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nintendo.npf.sdk.core.x.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private x() {
    }

    public final void a(Function2 callback, Function1 func) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(func, "func");
        BuildersKt__Builders_commonKt.launch$default(b, null, null, new a(func, callback, null), 3, null);
    }
}
