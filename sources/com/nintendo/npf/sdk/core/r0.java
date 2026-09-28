package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 {
    public static final a b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function2 f550a;

    public static final class a {

        /* JADX INFO: renamed from: com.nintendo.npf.sdk.core.r0$a$a, reason: collision with other inner class name */
        static final class C0033a extends Lambda implements Function2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Function1 f551a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0033a(Function1 function1) {
                super(2);
                this.f551a = function1;
            }

            public final void a(Void r1, NPFError nPFError) {
                this.f551a.invoke(nPFError);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((Void) obj, (NPFError) obj2);
                return Unit.INSTANCE;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final r0 a(Function2 responseAndErrorBlock) {
            Intrinsics.checkNotNullParameter(responseAndErrorBlock, "responseAndErrorBlock");
            return new r0(responseAndErrorBlock, null);
        }

        private a() {
        }

        public final r0 a(Function1 errorOnlyBlock) {
            Intrinsics.checkNotNullParameter(errorOnlyBlock, "errorOnlyBlock");
            return new r0(new C0033a(errorOnlyBlock), null);
        }
    }

    static final class b extends Lambda implements Function2 {
        b() {
            super(2);
        }

        public final void a(Object obj, NPFError nPFError) {
            r0.this.a(obj, nPFError);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function2 {
        final /* synthetic */ Function1 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Function1 function1) {
            super(2);
            this.b = function1;
        }

        public final void a(Object obj, NPFError nPFError) {
            r0.this.a(obj, nPFError, this.b);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ r0(Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2);
    }

    public final void a(Object obj, NPFError nPFError) {
        if (nPFError != null) {
            this.f550a.invoke(null, nPFError);
        } else {
            this.f550a.invoke(obj, null);
        }
    }

    private r0(Function2 function2) {
        this.f550a = function2;
    }

    public final Function2 a() {
        return new b();
    }

    public final void a(Object obj, NPFError nPFError, Function1 runWhenSuccess) {
        Intrinsics.checkNotNullParameter(runWhenSuccess, "runWhenSuccess");
        if (nPFError != null) {
            this.f550a.invoke(null, nPFError);
        } else {
            runWhenSuccess.invoke(obj);
        }
    }

    public final Function2 a(Function1 runWhenSuccess) {
        Intrinsics.checkNotNullParameter(runWhenSuccess, "runWhenSuccess");
        return new c(runWhenSuccess);
    }

    public final void a(NPFError nPFError, Function0 runWhenSuccess) {
        Intrinsics.checkNotNullParameter(runWhenSuccess, "runWhenSuccess");
        if (nPFError != null) {
            this.f550a.invoke(null, nPFError);
        } else {
            runWhenSuccess.invoke();
        }
    }
}
