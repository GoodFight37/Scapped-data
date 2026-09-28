package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade;
import com.nintendo.npf.sdk.infrastructure.helper.ReportHelper;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import java.util.TimerTask;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes2.dex */
public final class y4 {
    public static final c l = new c(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DeviceDataFacade f622a;
    private final y1 b;
    private final ReportHelper c;
    private final z2 d;
    private final Function0 e;
    private final Function0 f;
    private final d g;
    private final CoroutineScope h;
    private d5 i;
    private final Object j;
    private Job k;

    static final class a extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f623a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Long invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }
    }

    static final class b extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f624a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i1 invoke() {
            return new i1(true);
        }
    }

    public static final class c {
        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private c() {
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f625a;
        private boolean b;
        private long c;
        private long d;
        private long e;

        public final boolean a() {
            return this.b;
        }

        public final long b() {
            return this.c;
        }

        public final boolean c() {
            return this.f625a;
        }

        public final void d(long j) {
            this.d = j;
            this.c = j;
            this.e = 0L;
        }

        public final void e(long j) {
            this.b = false;
            this.e += j - this.c;
        }

        public final long a(long j) {
            return (j - this.d) - this.e;
        }

        public final long b(long j) {
            return j - this.c;
        }

        public final void c(long j) {
            this.b = true;
            this.c = j;
        }

        public final void d() {
            this.f625a = true;
        }
    }

    public static final class e extends TimerTask {
        e() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            y4.this.f();
        }
    }

    static final class f extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f627a;
        private /* synthetic */ Object b;

        static final class a implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ y4 f628a;
            final /* synthetic */ CoroutineScope b;

            a(y4 y4Var, CoroutineScope coroutineScope) {
                this.f628a = y4Var;
                this.b = coroutineScope;
            }

            public final Object a(boolean z, Continuation continuation) {
                if (z) {
                    this.f628a.g.d();
                    this.f628a.c();
                    this.f628a.a();
                    this.f628a.c.sendSessionEvent(com.nintendo.npf.sdk.core.f.START, 0L);
                    this.f628a.e();
                    CoroutineScopeKt.cancel$default(this.b, null, 1, null);
                }
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Boolean) obj).booleanValue(), continuation);
            }
        }

        f(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            f fVar = y4.this.new f(continuation);
            fVar.b = obj;
            return fVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f627a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.b;
                StateFlow stateFlowA = y4.this.d.a();
                a aVar = new a(y4.this, coroutineScope);
                this.f627a = 1;
                if (stateFlowA.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public y4(DeviceDataFacade deviceDataFacade, y1 hostInformationDataFacade, ReportHelper reportHelper, z2 loginHandler) {
        this(deviceDataFacade, hostInformationDataFacade, reportHelper, loginHandler, null, null, null, null, 240, null);
        Intrinsics.checkNotNullParameter(deviceDataFacade, "deviceDataFacade");
        Intrinsics.checkNotNullParameter(hostInformationDataFacade, "hostInformationDataFacade");
        Intrinsics.checkNotNullParameter(reportHelper, "reportHelper");
        Intrinsics.checkNotNullParameter(loginHandler, "loginHandler");
    }

    public final void g() {
        if (this.g.c()) {
            return;
        }
        Job job = this.k;
        if (job == null || !job.isActive()) {
            this.k = BuildersKt__Builders_commonKt.launch$default(this.h, null, null, new f(null), 3, null);
        }
    }

    public y4(DeviceDataFacade deviceDataFacade, y1 hostInformationDataFacade, ReportHelper reportHelper, z2 loginHandler, Function0 currentTimeMillis, Function0 timerProvider, d state, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(deviceDataFacade, "deviceDataFacade");
        Intrinsics.checkNotNullParameter(hostInformationDataFacade, "hostInformationDataFacade");
        Intrinsics.checkNotNullParameter(reportHelper, "reportHelper");
        Intrinsics.checkNotNullParameter(loginHandler, "loginHandler");
        Intrinsics.checkNotNullParameter(currentTimeMillis, "currentTimeMillis");
        Intrinsics.checkNotNullParameter(timerProvider, "timerProvider");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f622a = deviceDataFacade;
        this.b = hostInformationDataFacade;
        this.c = reportHelper;
        this.d = loginHandler;
        this.e = currentTimeMillis;
        this.f = timerProvider;
        this.g = state;
        this.h = scope;
        this.j = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        synchronized (this.j) {
            d5 d5Var = this.i;
            if (d5Var != null) {
                d5Var.cancel();
                d5Var.a();
                this.i = null;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        synchronized (this.j) {
            if (this.i == null) {
                e eVar = new e();
                Object objInvoke = this.f.invoke();
                ((d5) objInvoke).a(eVar, this.b.c(), this.b.c());
                this.i = (d5) objInvoke;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        this.c.sendSessionEvent(com.nintendo.npf.sdk.core.f.UPDATE, this.g.a(((Number) this.e.invoke()).longValue()));
    }

    public final void b() {
        a();
        long jLongValue = ((Number) this.e.invoke()).longValue();
        this.g.c(jLongValue);
        this.c.sendSessionEvent(com.nintendo.npf.sdk.core.f.PAUSE, this.g.a(jLongValue));
    }

    public final void c() {
        this.g.d(((Number) this.e.invoke()).longValue());
    }

    public final void d() {
        if (!this.g.c()) {
            g();
            return;
        }
        SDKLog.d("SessionEventManager", "session pausedTimestamp : " + this.g.b());
        long jLongValue = ((Number) this.e.invoke()).longValue();
        if (this.g.b() == 0 || this.g.b(jLongValue) > 600000) {
            c();
            this.f622a.generateSessionId();
            this.c.sendSessionEvent(com.nintendo.npf.sdk.core.f.START, 0L);
        } else if (this.g.a()) {
            this.g.e(jLongValue);
            this.c.sendSessionEvent(com.nintendo.npf.sdk.core.f.RESUME, this.g.a(jLongValue));
        } else {
            f();
        }
        e();
    }

    public /* synthetic */ y4(DeviceDataFacade deviceDataFacade, y1 y1Var, ReportHelper reportHelper, z2 z2Var, Function0 function0, Function0 function1, d dVar, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(deviceDataFacade, y1Var, reportHelper, z2Var, (i & 16) != 0 ? a.f623a : function0, (i & 32) != 0 ? b.f624a : function1, (i & 64) != 0 ? new d() : dVar, (i & 128) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()) : coroutineScope);
    }
}
