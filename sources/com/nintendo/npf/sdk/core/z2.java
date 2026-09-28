package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade;
import com.nintendo.npf.sdk.domain.repository.BaasAccountRepository;
import com.nintendo.npf.sdk.user.BaaSUser;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes2.dex */
public final class z2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c0 f635a;
    private final DeviceDataFacade b;
    private final BaasAccountRepository c;
    private final ErrorFactory d;
    private final CoroutineScope e;
    private final CoroutineDispatcher f;
    private final CoroutineDispatcher g;
    private final MutableStateFlow h;
    private final StateFlow i;
    private int j;
    private final Mutex k;

    public interface a {

        /* JADX INFO: renamed from: com.nintendo.npf.sdk.core.z2$a$a, reason: collision with other inner class name */
        public interface InterfaceC0041a extends a {
            NPFError b();
        }

        public interface b extends a {
            BaaSUser a();

            String getSessionId();
        }
    }

    public static final class b implements a.InterfaceC0041a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NPFError f636a;

        public b(NPFError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            this.f636a = error;
        }

        @Override // com.nintendo.npf.sdk.core.z2.a.InterfaceC0041a
        public NPFError b() {
            return this.f636a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.areEqual(this.f636a, ((b) obj).f636a);
        }

        public int hashCode() {
            return this.f636a.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.f636a + ')';
        }
    }

    public static final class c implements a.b, a.InterfaceC0041a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BaaSUser f637a;
        private final String b;
        private final NPFError c;

        public c(BaaSUser user, String str, NPFError error) {
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(error, "error");
            this.f637a = user;
            this.b = str;
            this.c = error;
        }

        @Override // com.nintendo.npf.sdk.core.z2.a.b
        public BaaSUser a() {
            return this.f637a;
        }

        @Override // com.nintendo.npf.sdk.core.z2.a.InterfaceC0041a
        public NPFError b() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Intrinsics.areEqual(this.f637a, cVar.f637a) && Intrinsics.areEqual(this.b, cVar.b) && Intrinsics.areEqual(this.c, cVar.c);
        }

        @Override // com.nintendo.npf.sdk.core.z2.a.b
        public String getSessionId() {
            return this.b;
        }

        public int hashCode() {
            int iHashCode = this.f637a.hashCode() * 31;
            String str = this.b;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "NaError(user=" + this.f637a + ", sessionId=" + this.b + ", error=" + this.c + ')';
        }
    }

    public static final class d implements a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BaaSUser f638a;
        private final String b;

        public d(BaaSUser user, String str) {
            Intrinsics.checkNotNullParameter(user, "user");
            this.f638a = user;
            this.b = str;
        }

        @Override // com.nintendo.npf.sdk.core.z2.a.b
        public BaaSUser a() {
            return this.f638a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return Intrinsics.areEqual(this.f638a, dVar.f638a) && Intrinsics.areEqual(this.b, dVar.b);
        }

        @Override // com.nintendo.npf.sdk.core.z2.a.b
        public String getSessionId() {
            return this.b;
        }

        public int hashCode() {
            int iHashCode = this.f638a.hashCode() * 31;
            String str = this.b;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Success(user=" + this.f638a + ", sessionId=" + this.b + ')';
        }
    }

    static final class e extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f639a;
        int b;

        static final class a implements c0.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Continuation f640a;

            a(Continuation continuation) {
                this.f640a = continuation;
            }

            @Override // com.nintendo.npf.sdk.core.c0.a
            public final void a(BaaSUser user, String str, NPFError nPFError) {
                Object bVar;
                if (nPFError == null) {
                    Intrinsics.checkNotNullExpressionValue(user, "user");
                    bVar = new d(user, str);
                } else if (g3.a(nPFError)) {
                    Intrinsics.checkNotNullExpressionValue(user, "user");
                    bVar = new c(user, str, nPFError);
                } else {
                    bVar = new b(nPFError);
                }
                Continuation continuation = this.f640a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m248constructorimpl(bVar));
            }
        }

        e(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return z2.this.new e(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            z2 z2Var = z2.this;
            this.f639a = z2Var;
            this.b = 1;
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(this));
            z2Var.f635a.a(null, null, new a(safeContinuation));
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            return orThrow == coroutine_suspended ? coroutine_suspended : orThrow;
        }
    }

    static final class f extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f641a;
        final /* synthetic */ boolean c;
        final /* synthetic */ Function2 d;

        static final class a extends SuspendLambda implements Function2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f642a;
            final /* synthetic */ Function2 b;
            final /* synthetic */ BaaSUser c;
            final /* synthetic */ NPFError d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Function2 function2, BaaSUser baaSUser, NPFError nPFError, Continuation continuation) {
                super(2, continuation);
                this.b = function2;
                this.c = baaSUser;
                this.d = nPFError;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.b, this.c, this.d, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f642a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.b.invoke(this.c, this.d);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(boolean z, Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.c = z;
            this.d = function2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return z2.this.new f(this.c, this.d, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0065, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r4, r5, r7) == r0) goto L29;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.f641a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r8)
                goto L68
            L12:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1a:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L2e
            L1e:
                kotlin.ResultKt.throwOnFailure(r8)
                com.nintendo.npf.sdk.core.z2 r8 = com.nintendo.npf.sdk.core.z2.this
                boolean r1 = r7.c
                r7.f641a = r3
                java.lang.Object r8 = r8.a(r1, r7)
                if (r8 != r0) goto L2e
                goto L67
            L2e:
                com.nintendo.npf.sdk.core.z2$a r8 = (com.nintendo.npf.sdk.core.z2.a) r8
                boolean r1 = r8 instanceof com.nintendo.npf.sdk.core.z2.a.b
                r3 = 0
                if (r1 == 0) goto L39
                r1 = r8
                com.nintendo.npf.sdk.core.z2$a$b r1 = (com.nintendo.npf.sdk.core.z2.a.b) r1
                goto L3a
            L39:
                r1 = r3
            L3a:
                if (r1 == 0) goto L41
                com.nintendo.npf.sdk.user.BaaSUser r1 = r1.a()
                goto L42
            L41:
                r1 = r3
            L42:
                boolean r4 = r8 instanceof com.nintendo.npf.sdk.core.z2.a.InterfaceC0041a
                if (r4 == 0) goto L49
                com.nintendo.npf.sdk.core.z2$a$a r8 = (com.nintendo.npf.sdk.core.z2.a.InterfaceC0041a) r8
                goto L4a
            L49:
                r8 = r3
            L4a:
                if (r8 == 0) goto L51
                com.nintendo.npf.sdk.NPFError r8 = r8.b()
                goto L52
            L51:
                r8 = r3
            L52:
                com.nintendo.npf.sdk.core.z2 r4 = com.nintendo.npf.sdk.core.z2.this
                kotlinx.coroutines.CoroutineDispatcher r4 = com.nintendo.npf.sdk.core.z2.b(r4)
                com.nintendo.npf.sdk.core.z2$f$a r5 = new com.nintendo.npf.sdk.core.z2$f$a
                kotlin.jvm.functions.Function2 r6 = r7.d
                r5.<init>(r6, r1, r8, r3)
                r7.f641a = r2
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r4, r5, r7)
                if (r8 != r0) goto L68
            L67:
                return r0
            L68:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nintendo.npf.sdk.core.z2.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    static final class g extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f643a;
        Object b;
        Object c;
        boolean d;
        /* synthetic */ Object e;
        int g;

        g(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return z2.this.a(false, (Continuation) this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public z2(c0 baasAuth, DeviceDataFacade deviceDataFacade, BaasAccountRepository baasAccountRepository, ErrorFactory errorFactory) {
        this(baasAuth, deviceDataFacade, baasAccountRepository, errorFactory, null, null, null, 112, null);
        Intrinsics.checkNotNullParameter(baasAuth, "baasAuth");
        Intrinsics.checkNotNullParameter(deviceDataFacade, "deviceDataFacade");
        Intrinsics.checkNotNullParameter(baasAccountRepository, "baasAccountRepository");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
    }

    public z2(c0 baasAuth, DeviceDataFacade deviceDataFacade, BaasAccountRepository baasAccountRepository, ErrorFactory errorFactory, CoroutineScope scope, CoroutineDispatcher mainDispatcher, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(baasAuth, "baasAuth");
        Intrinsics.checkNotNullParameter(deviceDataFacade, "deviceDataFacade");
        Intrinsics.checkNotNullParameter(baasAccountRepository, "baasAccountRepository");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.f635a = baasAuth;
        this.b = deviceDataFacade;
        this.c = baasAccountRepository;
        this.d = errorFactory;
        this.e = scope;
        this.f = mainDispatcher;
        this.g = ioDispatcher;
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.h = MutableStateFlow;
        this.i = FlowKt.asStateFlow(MutableStateFlow);
        this.k = MutexKt.Mutex$default(false, 1, null);
    }

    public final StateFlow a() {
        return this.i;
    }

    public final Object b(Continuation continuation) throws Throwable {
        if (((Boolean) this.h.getValue()).booleanValue()) {
            return Unit.INSTANCE;
        }
        Object objA = a(false, continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    public final void a(boolean z, Function2 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(this.e, null, null, new f(z, callback, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x009c A[Catch: all -> 0x0157, TRY_LEAVE, TryCatch #3 {all -> 0x0157, blocks: (B:29:0x008a, B:31:0x0096, B:34:0x009c), top: B:86:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00e6 A[Catch: all -> 0x0061, TryCatch #1 {all -> 0x0061, blocks: (B:19:0x005d, B:44:0x00c9, B:46:0x00cf, B:48:0x00dd, B:50:0x00e6, B:52:0x00f8, B:53:0x00fa, B:51:0x00ec), top: B:82:0x005d }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00ec A[Catch: all -> 0x0061, TryCatch #1 {all -> 0x0061, blocks: (B:19:0x005d, B:44:0x00c9, B:46:0x00cf, B:48:0x00dd, B:50:0x00e6, B:52:0x00f8, B:53:0x00fa, B:51:0x00ec), top: B:82:0x005d }] */
    /* JADX WARN: Code duplicated, block: B:58:0x011f  */
    /* JADX WARN: Code duplicated, block: B:70:0x0145  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(boolean z, Continuation continuation) throws Throwable {
        g gVar;
        Mutex mutex;
        z2 z2Var;
        boolean z2;
        Throwable th;
        z2 z2Var2;
        Mutex mutex2;
        z2 z2Var3;
        Throwable th2;
        Mutex mutex3;
        a aVar;
        Mutex mutex4;
        z2 z2Var4;
        a aVar2;
        Mutex mutex5;
        MutableStateFlow mutableStateFlow;
        Object value;
        if (continuation instanceof g) {
            gVar = (g) continuation;
            int i = gVar.g;
            if ((i & Integer.MIN_VALUE) != 0) {
                gVar.g = i - Integer.MIN_VALUE;
            } else {
                gVar = new g(continuation);
            }
        } else {
            gVar = new g(continuation);
        }
        Object objA = gVar.e;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = gVar.g;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            mutex = this.k;
            gVar.f643a = this;
            gVar.b = mutex;
            gVar.d = z;
            gVar.g = 1;
            if (mutex.lock(null, gVar) != coroutine_suspended) {
                z2Var = this;
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                z2Var2 = (z2) gVar.f643a;
                try {
                    ResultKt.throwOnFailure(objA);
                    aVar = (a) objA;
                    if ((aVar instanceof a.b) && !((Boolean) z2Var2.h.getValue()).booleanValue()) {
                        if (((a.b) aVar).getSessionId() == null) {
                            z2Var2.b.generateSessionId();
                        } else {
                            z2Var2.b.setSessionId(((a.b) aVar).getSessionId());
                        }
                        mutableStateFlow = z2Var2.h;
                        do {
                            value = mutableStateFlow.getValue();
                            ((Boolean) value).getClass();
                        } while (!mutableStateFlow.compareAndSet(value, Boxing.boxBoolean(true)));
                    }
                    mutex4 = z2Var2.k;
                    gVar.f643a = z2Var2;
                    gVar.b = aVar;
                    gVar.c = mutex4;
                    gVar.g = 3;
                    if (mutex4.lock(null, gVar) != coroutine_suspended) {
                        z2Var4 = z2Var2;
                        aVar2 = aVar;
                        mutex5 = mutex4;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    mutex2 = z2Var2.k;
                    gVar.f643a = z2Var2;
                    gVar.b = th;
                    gVar.c = mutex2;
                    gVar.g = 4;
                    if (mutex2.lock(null, gVar) != coroutine_suspended) {
                        z2Var3 = z2Var2;
                        th2 = th;
                        mutex3 = mutex2;
                        z2Var3.j--;
                        throw th2;
                    }
                }
                return coroutine_suspended;
            }
            if (i2 != 3) {
                if (i2 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutex3 = (Mutex) gVar.c;
                th2 = (Throwable) gVar.b;
                z2Var3 = (z2) gVar.f643a;
                ResultKt.throwOnFailure(objA);
                try {
                    z2Var3.j--;
                    throw th2;
                } finally {
                    mutex3.unlock(null);
                }
            }
            mutex5 = (Mutex) gVar.c;
            aVar2 = (a) gVar.b;
            z2Var4 = (z2) gVar.f643a;
            ResultKt.throwOnFailure(objA);
            try {
                z2Var4.j--;
                return aVar2;
            } finally {
                mutex5.unlock(null);
            }
        }
        z = gVar.d;
        mutex = (Mutex) gVar.b;
        z2Var = (z2) gVar.f643a;
        ResultKt.throwOnFailure(objA);
        if (z) {
            try {
                if (h0.b(z2Var.c.getCurrentBaasUser()) || z2Var.j <= 0) {
                    z2Var.j++;
                    z2 = false;
                } else {
                    z2 = true;
                }
            } finally {
                mutex.unlock(null);
            }
        } else {
            z2Var.j++;
            z2 = false;
        }
        if (z2) {
            NPFError nPFErrorCreate_ProcessCancel_Minus1 = z2Var.d.create_ProcessCancel_Minus1("RetryBaaSAuth is processing.");
            Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_ProcessCancel_Minus1, "errorFactory.create_Proc…BaaSAuth is processing.\")");
            return new b(nPFErrorCreate_ProcessCancel_Minus1);
        }
        try {
            gVar.f643a = z2Var;
            gVar.b = null;
            gVar.g = 2;
            objA = z2Var.a(gVar);
            if (objA != coroutine_suspended) {
                z2Var2 = z2Var;
                aVar = (a) objA;
                if (aVar instanceof a.b) {
                    if (((a.b) aVar).getSessionId() == null) {
                        z2Var2.b.generateSessionId();
                    } else {
                        z2Var2.b.setSessionId(((a.b) aVar).getSessionId());
                    }
                    mutableStateFlow = z2Var2.h;
                    do {
                        value = mutableStateFlow.getValue();
                        ((Boolean) value).getClass();
                    } while (!mutableStateFlow.compareAndSet(value, Boxing.boxBoolean(true)));
                }
                mutex4 = z2Var2.k;
                gVar.f643a = z2Var2;
                gVar.b = aVar;
                gVar.c = mutex4;
                gVar.g = 3;
                if (mutex4.lock(null, gVar) != coroutine_suspended) {
                    z2Var4 = z2Var2;
                    aVar2 = aVar;
                    mutex5 = mutex4;
                    z2Var4.j--;
                    return aVar2;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            z2Var2 = z2Var;
            mutex2 = z2Var2.k;
            gVar.f643a = z2Var2;
            gVar.b = th;
            gVar.c = mutex2;
            gVar.g = 4;
            if (mutex2.lock(null, gVar) != coroutine_suspended) {
                z2Var3 = z2Var2;
                th2 = th;
                mutex3 = mutex2;
                z2Var3.j--;
                throw th2;
            }
        }
        return coroutine_suspended;
    }

    public /* synthetic */ z2(c0 c0Var, DeviceDataFacade deviceDataFacade, BaasAccountRepository baasAccountRepository, ErrorFactory errorFactory, CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(c0Var, deviceDataFacade, baasAccountRepository, errorFactory, (i & 16) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)) : coroutineScope, (i & 32) != 0 ? Dispatchers.getMain() : coroutineDispatcher, (i & 64) != 0 ? Dispatchers.getIO() : coroutineDispatcher2);
    }

    public static /* synthetic */ Object a(z2 z2Var, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return z2Var.a(z, continuation);
    }

    private final Object a(Continuation continuation) {
        return BuildersKt.withContext(this.g, new e(null), continuation);
    }
}
