package com.nintendo.npf.sdk.internal.impl;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.nintendo.npf.sdk.core.u1;
import com.nintendo.npf.sdk.core.y4;
import com.nintendo.npf.sdk.core.z2;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001\u0016B+\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010#\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0016\u0010!\"\u0004\b\u0016\u0010\"¨\u0006%"}, d2 = {"Lcom/nintendo/npf/sdk/internal/impl/ProcessLifecycleObserver;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Lcom/nintendo/npf/sdk/core/z2;", "loginHandler", "Lcom/nintendo/npf/sdk/core/y4;", "sessionEventManager", "Lcom/nintendo/npf/sdk/core/u1;", "googleAdvertisingIdRepository", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/nintendo/npf/sdk/core/z2;Lcom/nintendo/npf/sdk/core/y4;Lcom/nintendo/npf/sdk/core/u1;Lkotlinx/coroutines/CoroutineScope;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "onCreate", "(Landroidx/lifecycle/LifecycleOwner;)V", "onStart", "onResume", "onPause", "onStop", "onDestroy", "a", "Lcom/nintendo/npf/sdk/core/z2;", "b", "Lcom/nintendo/npf/sdk/core/y4;", "c", "Lcom/nintendo/npf/sdk/core/u1;", "d", "Lkotlinx/coroutines/CoroutineScope;", "", "e", "Z", "()Z", "(Z)V", "autoInitialLoginEnabled", "f", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProcessLifecycleObserver implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final z2 loginHandler;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final y4 sessionEventManager;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final u1 googleAdvertisingIdRepository;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final CoroutineScope scope;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private boolean autoInitialLoginEnabled;

    static final class b extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f777a;

        b(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ProcessLifecycleObserver.this.new b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f777a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (ProcessLifecycleObserver.this.getAutoInitialLoginEnabled()) {
                    z2 z2Var = ProcessLifecycleObserver.this.loginHandler;
                    this.f777a = 1;
                    if (z2Var.b(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    static final class c extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f778a;

        c(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ProcessLifecycleObserver.this.new c(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f778a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                u1 u1Var = ProcessLifecycleObserver.this.googleAdvertisingIdRepository;
                this.f778a = 1;
                if (u1Var.a(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProcessLifecycleObserver(z2 loginHandler, y4 sessionEventManager, u1 googleAdvertisingIdRepository) {
        this(loginHandler, sessionEventManager, googleAdvertisingIdRepository, null, 8, null);
        Intrinsics.checkNotNullParameter(loginHandler, "loginHandler");
        Intrinsics.checkNotNullParameter(sessionEventManager, "sessionEventManager");
        Intrinsics.checkNotNullParameter(googleAdvertisingIdRepository, "googleAdvertisingIdRepository");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onCreate(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        SDKLog.i("ProcessLifecycleObserver", "Calling onCreate()");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onDestroy(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        SDKLog.i("ProcessLifecycleObserver", "Calling onDestroy()");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        SDKLog.i("ProcessLifecycleObserver", "Calling onPause()");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        SDKLog.i("ProcessLifecycleObserver", "Calling onResume()");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new b(null), 3, null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onStart(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        SDKLog.i("ProcessLifecycleObserver", "Calling onStart()");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new c(null), 3, null);
        this.sessionEventManager.d();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onStop(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        SDKLog.i("ProcessLifecycleObserver", "Calling onStop()");
        this.sessionEventManager.b();
    }

    public ProcessLifecycleObserver(z2 loginHandler, y4 sessionEventManager, u1 googleAdvertisingIdRepository, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(loginHandler, "loginHandler");
        Intrinsics.checkNotNullParameter(sessionEventManager, "sessionEventManager");
        Intrinsics.checkNotNullParameter(googleAdvertisingIdRepository, "googleAdvertisingIdRepository");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.loginHandler = loginHandler;
        this.sessionEventManager = sessionEventManager;
        this.googleAdvertisingIdRepository = googleAdvertisingIdRepository;
        this.scope = scope;
        this.autoInitialLoginEnabled = true;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final boolean getAutoInitialLoginEnabled() {
        return this.autoInitialLoginEnabled;
    }

    public final void a(boolean z) {
        this.autoInitialLoginEnabled = z;
    }

    public /* synthetic */ ProcessLifecycleObserver(z2 z2Var, y4 y4Var, u1 u1Var, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2Var, y4Var, u1Var, (i & 8) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)) : coroutineScope);
    }
}
