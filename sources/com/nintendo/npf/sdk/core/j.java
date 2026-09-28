package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements n {
    public static final a f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m0 f487a;
    private final p4 b;
    private final ErrorFactory c;
    private final AtomicReference d;
    private final AtomicReference e;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2 f488a;
        final /* synthetic */ boolean b;
        final /* synthetic */ boolean c;
        final /* synthetic */ j d;
        final /* synthetic */ BaaSUser e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Function2 function2, boolean z, boolean z2, j jVar, BaaSUser baaSUser) {
            super(2);
            this.f488a = function2;
            this.b = z;
            this.c = z2;
            this.d = jVar;
            this.e = baaSUser;
        }

        public final void a(i iVar, NPFError nPFError) {
            if (nPFError == null) {
                if (iVar == null || !k.a(iVar)) {
                    this.f488a.invoke(null, this.d.c.create_UnknownError_9999("Invalid config"));
                    return;
                }
                this.d.a(iVar);
                this.d.a(new m(this.e));
                this.f488a.invoke(iVar, null);
                return;
            }
            int errorCode = nPFError.getErrorCode();
            if (errorCode == 0) {
                this.f488a.invoke(null, nPFError);
                return;
            }
            if (errorCode != 500) {
                this.f488a.invoke(null, this.d.c.create_UnknownError_9999(nPFError.getErrorMessage()));
                return;
            }
            boolean z = this.b;
            if (!z || this.c) {
                this.f488a.invoke(null, this.d.c.create_Analytics_UnavailableResettableId_6500(nPFError.getErrorMessage()));
            } else {
                j.b(this.d, this.e, this.f488a, z, true);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((i) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    public j(m0 bigdataApi, p4 reportTimer, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(bigdataApi, "bigdataApi");
        Intrinsics.checkNotNullParameter(reportTimer, "reportTimer");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f487a = bigdataApi;
        this.b = reportTimer;
        this.c = errorFactory;
        this.d = new AtomicReference(new i(null, 0L, null, false, 0, null, null, null, null, null, null, 2047, null));
        this.e = new AtomicReference(new m(null, null, 3, null));
    }

    @Override // com.nintendo.npf.sdk.core.n
    public m b() {
        Object obj = this.e.get();
        Intrinsics.checkNotNullExpressionValue(obj, "configOwnerAtomicReference.get()");
        return (m) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(j jVar, BaaSUser baaSUser, Function2 function2, boolean z, boolean z2) {
        jVar.f487a.a(baaSUser, new b(function2, z, z2, jVar, baaSUser));
    }

    @Override // com.nintendo.npf.sdk.core.n
    public i a() {
        Object obj = this.d.get();
        Intrinsics.checkNotNullExpressionValue(obj, "configAtomicReference.get()");
        return (i) obj;
    }

    @Override // com.nintendo.npf.sdk.core.n
    public void a(i value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.d.set(value);
        this.b.b(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar) {
        this.e.set(mVar);
    }

    @Override // com.nintendo.npf.sdk.core.n
    public void a(BaaSUser baasUser, boolean z, Function2 callback) {
        Intrinsics.checkNotNullParameter(baasUser, "baasUser");
        Intrinsics.checkNotNullParameter(callback, "callback");
        a(new i(null, Calendar.getInstance().getTimeInMillis() + ((long) 60000), null, false, 0, null, null, null, null, null, null, 2045, null));
        a(this, baasUser, callback, z, false, 16, null);
    }

    static /* synthetic */ void a(j jVar, BaaSUser baaSUser, Function2 function2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 16) != 0) {
            z2 = false;
        }
        b(jVar, baaSUser, function2, z, z2);
    }
}
