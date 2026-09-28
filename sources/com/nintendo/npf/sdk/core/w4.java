package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.internal.util.SDKLog;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: classes2.dex */
public final class w4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f607a;
    private final Channel b;
    private final CoroutineExceptionHandler c;
    private final CoroutineContext d;

    static final class a extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f608a;
        int b;

        a(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return w4.this.new a(continuation);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0033 A[PHI: r1
  0x0033: PHI (r1v3 kotlinx.coroutines.channels.ChannelIterator) = 
  (r1v8 kotlinx.coroutines.channels.ChannelIterator)
  (r1v9 kotlinx.coroutines.channels.ChannelIterator)
  (r1v10 kotlinx.coroutines.channels.ChannelIterator)
 binds: [B:10:0x0026, B:17:0x0054, B:6:0x000e] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:14:0x003e A[PHI: r1 r5
  0x003e: PHI (r1v2 kotlinx.coroutines.channels.ChannelIterator) = (r1v11 kotlinx.coroutines.channels.ChannelIterator), (r1v12 kotlinx.coroutines.channels.ChannelIterator) binds: [B:12:0x003b, B:9:0x001e] A[DONT_GENERATE, DONT_INLINE]
  0x003e: PHI (r5v3 java.lang.Object) = (r5v10 java.lang.Object), (r5v0 java.lang.Object) binds: [B:12:0x003b, B:9:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:16:0x0046  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0054 -> B:11:0x0033). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L26
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r1 = r4.f608a
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.ResultKt.throwOnFailure(r5)
                goto L33
            L16:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1e:
                java.lang.Object r1 = r4.f608a
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.ResultKt.throwOnFailure(r5)
                goto L3e
            L26:
                kotlin.ResultKt.throwOnFailure(r5)
                com.nintendo.npf.sdk.core.w4 r5 = com.nintendo.npf.sdk.core.w4.this
                kotlinx.coroutines.channels.Channel r5 = com.nintendo.npf.sdk.core.w4.a(r5)
                kotlinx.coroutines.channels.ChannelIterator r1 = r5.iterator()
            L33:
                r4.f608a = r1
                r4.b = r3
                java.lang.Object r5 = r1.hasNext(r4)
                if (r5 != r0) goto L3e
                goto L56
            L3e:
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                if (r5 == 0) goto L57
                java.lang.Object r5 = r1.next()
                kotlinx.coroutines.Job r5 = (kotlinx.coroutines.Job) r5
                r4.f608a = r1
                r4.b = r2
                java.lang.Object r5 = r5.join(r4)
                if (r5 != r0) goto L33
            L56:
                return r0
            L57:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nintendo.npf.sdk.core.w4.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f609a;
        /* synthetic */ Object b;
        int d;

        b(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return w4.this.a(null, this);
        }
    }

    static final class c extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f610a;
        final /* synthetic */ Function1 b;
        final /* synthetic */ CompletableDeferred c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Function1 function1, CompletableDeferred completableDeferred, Continuation continuation) {
            super(2, continuation);
            this.b = function1;
            this.c = completableDeferred;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new c(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f610a;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function1 function1 = this.b;
                    this.f610a = 1;
                    obj = function1.invoke(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.c.complete(obj);
            } catch (CancellationException e) {
                throw e;
            } catch (Throwable th) {
                this.c.completeExceptionally(th);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class d extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public d(CoroutineExceptionHandler.Companion companion) {
            super(companion);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext coroutineContext, Throwable th) {
            SDKLog.e("SerialQueue", "uncaught exception", th);
        }
    }

    public w4(CoroutineScope scope, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.f607a = scope;
        this.b = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        d dVar = new d(CoroutineExceptionHandler.INSTANCE);
        this.c = dVar;
        CoroutineContext coroutineContextPlus = dispatcher.plus(dVar).plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));
        this.d = coroutineContextPlus;
        BuildersKt.launch(scope, coroutineContextPlus, CoroutineStart.UNDISPATCHED, new a(null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Function1 function1, Continuation continuation) {
        b bVar;
        CompletableDeferred completableDeferred;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.d = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object obj = bVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            Job jobLaunch = BuildersKt.launch(this.f607a, this.d, CoroutineStart.LAZY, new c(function1, completableDeferredCompletableDeferred$default, null));
            Channel channel = this.b;
            bVar.f609a = completableDeferredCompletableDeferred$default;
            bVar.d = 1;
            if (channel.send(jobLaunch, bVar) != coroutine_suspended) {
                completableDeferred = completableDeferredCompletableDeferred$default;
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        completableDeferred = (CompletableDeferred) bVar.f609a;
        ResultKt.throwOnFailure(obj);
        bVar.f609a = null;
        bVar.d = 2;
        Object objAwait = completableDeferred.await(bVar);
        return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
    }
}
