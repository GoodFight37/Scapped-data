package com.nintendo.npf.sdk.core;

import android.app.Activity;
import android.content.Intent;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer$$ExternalSyntheticBackportWithForwarding0;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFException;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.internal.app.NaAuthenticationActivity;
import com.nintendo.npf.sdk.user.NintendoAccount;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes2.dex */
public final class o3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p3 f534a;
    private final e4 b;
    private final ErrorFactory c;
    private final CoroutineScope d;
    private final AtomicReference e;

    static final class a extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f535a;
        private /* synthetic */ Object b;
        final /* synthetic */ int d;
        final /* synthetic */ k3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i, k3 k3Var, Continuation continuation) {
            super(2, continuation);
            this.d = i;
            this.e = k3Var;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            a aVar = o3.this.new a(this.d, this.e, continuation);
            aVar.b = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Function2 function2;
            Throwable th;
            Object objM248constructorimpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f535a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                o3.this.f534a.a(this.d, this.e);
                Function2 function3 = (Function2) o3.this.e.get();
                if (this.e.a() || function3 == null) {
                    ByteQuadsCanonicalizer$$ExternalSyntheticBackportWithForwarding0.m(o3.this.e, function3, null);
                    o3.this.a(this.d);
                } else {
                    o3 o3Var = o3.this;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        p3 p3Var = o3Var.f534a;
                        this.b = function3;
                        this.f535a = 1;
                        Object objA = p3Var.a(this);
                        if (objA == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function2 = function3;
                        obj = objA;
                    } catch (Throwable th2) {
                        function2 = function3;
                        th = th2;
                        Result.Companion companion2 = Result.INSTANCE;
                        objM248constructorimpl = Result.m248constructorimpl(ResultKt.createFailure(th));
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function2 = (Function2) this.b;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                Result.Companion companion3 = Result.INSTANCE;
                objM248constructorimpl = Result.m248constructorimpl(ResultKt.createFailure(th));
            }
            objM248constructorimpl = Result.m248constructorimpl((NintendoAccount) obj);
            ByteQuadsCanonicalizer$$ExternalSyntheticBackportWithForwarding0.m(o3.this.e, function2, null);
            Object obj2 = Result.m254isFailureimpl(objM248constructorimpl) ? null : objM248constructorimpl;
            Throwable thM251exceptionOrNullimpl = Result.m251exceptionOrNullimpl(objM248constructorimpl);
            NPFException nPFException = thM251exceptionOrNullimpl instanceof NPFException ? (NPFException) thM251exceptionOrNullimpl : null;
            function2.invoke(obj2, nPFException != null ? nPFException.getError() : null);
            return Unit.INSTANCE;
        }
    }

    static final class b extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f536a;
        private /* synthetic */ Object b;
        final /* synthetic */ int d;
        final /* synthetic */ k3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, k3 k3Var, Continuation continuation) {
            super(2, continuation);
            this.d = i;
            this.e = k3Var;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            b bVar = o3.this.new b(this.d, this.e, continuation);
            bVar.b = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Function2 function2;
            Throwable th;
            Object objM248constructorimpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f536a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                o3.this.f534a.a(this.d, this.e);
                Function2 function3 = (Function2) o3.this.e.get();
                if (this.e.a() || function3 == null) {
                    ByteQuadsCanonicalizer$$ExternalSyntheticBackportWithForwarding0.m(o3.this.e, function3, null);
                    e4 e4Var = o3.this.b;
                    NPFError nPFErrorCreate_NintendoAccount_AuthorizationCanceledClosedApp_Minus1 = o3.this.c.create_NintendoAccount_AuthorizationCanceledClosedApp_Minus1();
                    Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_NintendoAccount_AuthorizationCanceledClosedApp_Minus1, "errorFactory.create_Nint…anceledClosedApp_Minus1()");
                    e4Var.a(nPFErrorCreate_NintendoAccount_AuthorizationCanceledClosedApp_Minus1);
                } else {
                    o3 o3Var = o3.this;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        p3 p3Var = o3Var.f534a;
                        this.b = function3;
                        this.f536a = 1;
                        Object objA = p3Var.a(this);
                        if (objA == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function2 = function3;
                        obj = objA;
                    } catch (Throwable th2) {
                        function2 = function3;
                        th = th2;
                        Result.Companion companion2 = Result.INSTANCE;
                        objM248constructorimpl = Result.m248constructorimpl(ResultKt.createFailure(th));
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function2 = (Function2) this.b;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                Result.Companion companion3 = Result.INSTANCE;
                objM248constructorimpl = Result.m248constructorimpl(ResultKt.createFailure(th));
            }
            objM248constructorimpl = Result.m248constructorimpl((NintendoAccount) obj);
            ByteQuadsCanonicalizer$$ExternalSyntheticBackportWithForwarding0.m(o3.this.e, function2, null);
            Object obj2 = Result.m254isFailureimpl(objM248constructorimpl) ? null : objM248constructorimpl;
            Throwable thM251exceptionOrNullimpl = Result.m251exceptionOrNullimpl(objM248constructorimpl);
            NPFException nPFException = thM251exceptionOrNullimpl instanceof NPFException ? (NPFException) thM251exceptionOrNullimpl : null;
            function2.invoke(obj2, nPFException != null ? nPFException.getError() : null);
            return Unit.INSTANCE;
        }
    }

    static final class c extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f537a;
        private /* synthetic */ Object b;
        final /* synthetic */ int d;
        final /* synthetic */ Function2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i, Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.d = i;
            this.e = function2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            c cVar = o3.this.new c(this.d, this.e, continuation);
            cVar.b = obj;
            return cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            q3 q3VarB;
            Function2 function2;
            Throwable th;
            Object objM248constructorimpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f537a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (o3.this.f534a.a() == null || (q3VarB = o3.this.f534a.b()) == null || !q3.a(q3VarB.c(), this.d)) {
                    this.e.invoke(null, o3.this.c.create_NintendoAccount_AuthorizationRetryIllegalState());
                    return Unit.INSTANCE;
                }
                if (!ByteQuadsCanonicalizer$$ExternalSyntheticBackportWithForwarding0.m(o3.this.e, null, this.e)) {
                    this.e.invoke(null, o3.this.c.create_NintendoAccount_AuthorizationCantRunMultiply_Minus1());
                    return Unit.INSTANCE;
                }
                Function2 function3 = (Function2) o3.this.e.get();
                if (function3 == null) {
                    return Unit.INSTANCE;
                }
                o3 o3Var = o3.this;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    p3 p3Var = o3Var.f534a;
                    this.b = function3;
                    this.f537a = 1;
                    Object objA = p3Var.a(this);
                    if (objA == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function2 = function3;
                    obj = objA;
                } catch (Throwable th2) {
                    function2 = function3;
                    th = th2;
                    Result.Companion companion2 = Result.INSTANCE;
                    objM248constructorimpl = Result.m248constructorimpl(ResultKt.createFailure(th));
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function2 = (Function2) this.b;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th3) {
                    th = th3;
                    Result.Companion companion3 = Result.INSTANCE;
                    objM248constructorimpl = Result.m248constructorimpl(ResultKt.createFailure(th));
                }
            }
            objM248constructorimpl = Result.m248constructorimpl((NintendoAccount) obj);
            ByteQuadsCanonicalizer$$ExternalSyntheticBackportWithForwarding0.m(o3.this.e, function2, null);
            Object obj2 = Result.m254isFailureimpl(objM248constructorimpl) ? null : objM248constructorimpl;
            Throwable thM251exceptionOrNullimpl = Result.m251exceptionOrNullimpl(objM248constructorimpl);
            NPFException nPFException = thM251exceptionOrNullimpl instanceof NPFException ? (NPFException) thM251exceptionOrNullimpl : null;
            function2.invoke(obj2, nPFException != null ? nPFException.getError() : null);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o3(p3 repository, e4 eventDispatcher, ErrorFactory errorFactory) {
        this(repository, eventDispatcher, errorFactory, null, 8, null);
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
    }

    public o3(p3 repository, e4 eventDispatcher, ErrorFactory errorFactory, CoroutineScope mainScope) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        Intrinsics.checkNotNullParameter(mainScope, "mainScope");
        this.f534a = repository;
        this.b = eventDispatcher;
        this.c = errorFactory;
        this.d = mainScope;
        this.e = new AtomicReference(null);
    }

    public final void b(int i, k3 result) {
        Intrinsics.checkNotNullParameter(result, "result");
        BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new b(i, result, null), 3, null);
    }

    public final void a(final Activity activity, final int i, List list, String str, String str2, Map optionalQuery, final boolean z, final Function2 callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(optionalQuery, "optionalQuery");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!ByteQuadsCanonicalizer$$ExternalSyntheticBackportWithForwarding0.m(this.e, null, callback)) {
            callback.invoke(null, this.c.create_NintendoAccount_AuthorizationCantRunMultiply_Minus1());
            return;
        }
        String strA = b0.a(50);
        Intrinsics.checkNotNullExpressionValue(strA, "getRandomString(50)");
        String strA2 = b0.a(50);
        Intrinsics.checkNotNullExpressionValue(strA2, "getRandomString(50)");
        l3 l3Var = new l3(strA, strA2, str2);
        final Intent intentA = NaAuthenticationActivity.INSTANCE.a(activity, this.f534a.a(list, l3Var.a(), l3Var.c(), str, optionalQuery), l3Var);
        activity.runOnUiThread(new Runnable() { // from class: com.nintendo.npf.sdk.core.o3$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                o3.a(activity, i, intentA, z, this, callback);
            }
        });
    }

    public /* synthetic */ o3(p3 p3Var, e4 e4Var, ErrorFactory errorFactory, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(p3Var, e4Var, errorFactory, (i & 8) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain())) : coroutineScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Activity activity, int i, Intent intent, boolean z, o3 this$0, Function2 callback) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        k3.c cVarA = j3.e.a(activity, i, intent, z);
        if (cVarA != null) {
            ByteQuadsCanonicalizer$$ExternalSyntheticBackportWithForwarding0.m(this$0.e, callback, null);
            callback.invoke(null, cVarA.g());
        }
    }

    public final void a(int i, k3 result) {
        Intrinsics.checkNotNullParameter(result, "result");
        BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new a(i, result, null), 3, null);
    }

    public final void a(int i, Function2 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new c(i, callback, null), 3, null);
    }

    public final void a(Activity activity, int i, List list, String str, String str2, Function2 callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        a(activity, i, list, str, str2, MapsKt.emptyMap(), true, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i) {
        q3.a aVar = q3.b;
        if (q3.a(i, aVar.a())) {
            this.b.b();
        } else if (q3.a(i, aVar.b())) {
            this.b.c();
        }
    }
}
