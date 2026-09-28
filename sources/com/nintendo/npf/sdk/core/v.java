package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.infrastructure.helper.ReportHelper;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class v {
    public static final a e = new a(null);
    private static final String f = "v";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f586a;
    private final Function0 b;
    private final Function0 c;
    private final h4 d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i invoke() {
            return v.this.f586a.a();
        }
    }

    static final class c extends Lambda implements Function2 {

        public static final class a extends TimerTask {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ v f589a;

            a(v vVar) {
                this.f589a = vVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ((o4) this.f589a.c.invoke()).a();
            }
        }

        c() {
            super(2);
        }

        public final void a(u self, Map events) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(events, "events");
            ((o4) v.this.c.invoke()).a(events);
            self.a(false);
            self.b(0);
            self.a(0);
            new Timer().schedule(new a(v.this), 1000L);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((u) obj, (Map) obj2);
            return Unit.INSTANCE;
        }
    }

    static final class d extends Lambda implements Function5 {
        d() {
            super(5);
        }

        public final void a(u self, Map events, int i, String errorMessage, i config) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(events, "events");
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            Intrinsics.checkNotNullParameter(config, "config");
            SDKLog.w(v.f, "Publication failed. Code: " + i + " Message: " + errorMessage);
            if (i == 400) {
                ((o4) v.this.c.invoke()).c(events);
                self.a(false);
                v.this.a(self, i, errorMessage);
                return;
            }
            if (i == 401 || i == 403 || i == 404) {
                ((o4) v.this.c.invoke()).b(events);
                self.a(false);
                if (self.b() < 2) {
                    self.b(self.b() + 1);
                    v.this.f586a.a(k.a(config, 0L));
                    return;
                } else {
                    self.b(0);
                    v.this.f586a.a(k.a(config, i.b.V1));
                    v.this.a(self, i, errorMessage);
                    return;
                }
            }
            if (i == 429) {
                ((o4) v.this.c.invoke()).b(events);
                self.a(false);
                v.this.f586a.a(k.a(config, i.b.NONE));
                v.this.a(self, i, errorMessage);
                return;
            }
            if (i != 500 && i != 503) {
                ((o4) v.this.c.invoke()).b(events);
                self.a(false);
                return;
            }
            ((o4) v.this.c.invoke()).b(events);
            self.a(false);
            if (self.b() < 2) {
                self.b(self.b() + 1);
                return;
            }
            self.b(0);
            v.this.f586a.a(k.a(config, i.b.V1));
            v.this.a(self, i, errorMessage);
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            a((u) obj, (Map) obj2, ((Number) obj3).intValue(), (String) obj4, (i) obj5);
            return Unit.INSTANCE;
        }
    }

    public v(n reportConfigRepository, Function0 reportHelperProvider, Function0 reportManagerProvider, h4 publishClient) {
        Intrinsics.checkNotNullParameter(reportConfigRepository, "reportConfigRepository");
        Intrinsics.checkNotNullParameter(reportHelperProvider, "reportHelperProvider");
        Intrinsics.checkNotNullParameter(reportManagerProvider, "reportManagerProvider");
        Intrinsics.checkNotNullParameter(publishClient, "publishClient");
        this.f586a = reportConfigRepository;
        this.b = reportHelperProvider;
        this.c = reportManagerProvider;
        this.d = publishClient;
    }

    public final u b() {
        return new u(this.d, null, null, new b(), new c(), new d(), 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(u uVar, int i, String str) {
        if (uVar.a() == i) {
            return;
        }
        uVar.a(i);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errorType", "NPF_ERROR");
            jSONObject.put("errorCode", i);
            jSONObject.put("errorMessage", str);
            ((ReportHelper) this.b.invoke()).reportEvent("NPFAUDIT", "PUBSUB", null, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
