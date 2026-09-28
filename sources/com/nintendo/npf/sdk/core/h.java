package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.internal.util.SDKLog;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public static final a c = new a(null);
    private static final String d = "h";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m0 f468a;
    private final Function0 b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function2 {

        public static final class a extends TimerTask {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ h f470a;

            a(h hVar) {
                this.f470a = hVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ((o4) this.f470a.b.invoke()).a();
            }
        }

        b() {
            super(2);
        }

        public final void a(g gVar, Map events) {
            o4 o4Var = (o4) h.this.b.invoke();
            Intrinsics.checkNotNullExpressionValue(events, "events");
            o4Var.a(events);
            gVar.f464a = false;
            new Timer().schedule(new a(h.this), 1000L);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((g) obj, (Map) obj2);
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function2 {
        c() {
            super(2);
        }

        public final void a(g gVar, Map events) {
            o4 o4Var = (o4) h.this.b.invoke();
            Intrinsics.checkNotNullExpressionValue(events, "events");
            o4Var.b(events);
            gVar.f464a = false;
            SDKLog.w(h.d, "drainAnalyticsEvents Error");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((g) obj, (Map) obj2);
            return Unit.INSTANCE;
        }
    }

    public h(m0 bigdataApi, Function0 reportManagerProvider) {
        Intrinsics.checkNotNullParameter(bigdataApi, "bigdataApi");
        Intrinsics.checkNotNullParameter(reportManagerProvider, "reportManagerProvider");
        this.f468a = bigdataApi;
        this.b = reportManagerProvider;
    }

    public final g b() {
        return new g(this.f468a, new b(), new c());
    }
}
