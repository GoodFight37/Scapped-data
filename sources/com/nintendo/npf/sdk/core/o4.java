package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.repository.BaasAccountRepository;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class o4 {
    public static final a j = new a(null);
    private static final String k = "o4";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BaasAccountRepository f538a;
    private final n b;
    private final com.nintendo.npf.sdk.internal.impl.a c;
    private final p4 d;
    private final g e;
    private final u f;
    private int g;
    private final Object h;
    private final Set i;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f539a;

        static {
            int[] iArr = new int[i.b.values().length];
            try {
                iArr[i.b.V1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[i.b.V2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f539a = iArr;
        }
    }

    static final class c extends Lambda implements Function2 {
        c() {
            super(2);
        }

        public final void a(i iVar, NPFError nPFError) {
            o4.this.d();
            if (nPFError == null) {
                o4.this.a();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((i) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    public o4(BaasAccountRepository baasAccountRepository, n analyticsConfigRepository, com.nintendo.npf.sdk.internal.impl.a localCache, p4 reportTimer, g appEnginePublisher, u pubsubPublisher) {
        Intrinsics.checkNotNullParameter(baasAccountRepository, "baasAccountRepository");
        Intrinsics.checkNotNullParameter(analyticsConfigRepository, "analyticsConfigRepository");
        Intrinsics.checkNotNullParameter(localCache, "localCache");
        Intrinsics.checkNotNullParameter(reportTimer, "reportTimer");
        Intrinsics.checkNotNullParameter(appEnginePublisher, "appEnginePublisher");
        Intrinsics.checkNotNullParameter(pubsubPublisher, "pubsubPublisher");
        this.f538a = baasAccountRepository;
        this.b = analyticsConfigRepository;
        this.c = localCache;
        this.d = reportTimer;
        this.e = appEnginePublisher;
        this.f = pubsubPublisher;
        this.h = new Object();
        this.i = new HashSet();
    }

    public final void a() {
        if (this.d.a()) {
            String str = k;
            SDKLog.d(str, "Lock count: " + this.g);
            if (b()) {
                return;
            }
            c();
            SDKLog.i(str, "Start drainAnalyticsEvents");
            BaaSUser currentBaasUser = this.f538a.getCurrentBaasUser();
            if (!h0.c(currentBaasUser)) {
                d();
                return;
            }
            Map mapA = com.nintendo.npf.sdk.internal.impl.b.a(this.c);
            if (mapA.isEmpty()) {
                d();
                return;
            }
            i iVarA = this.b.a();
            if (iVarA.f() < System.currentTimeMillis()) {
                n.a.a(this.b, currentBaasUser, false, new c(), 2, null);
                return;
            }
            int i = b.f539a[iVarA.g().ordinal()];
            if (i == 1) {
                a(mapA, currentBaasUser);
            } else if (i != 2) {
                d();
            } else {
                b(mapA, currentBaasUser);
            }
        }
    }

    public final void b(Map events) {
        Intrinsics.checkNotNullParameter(events, "events");
        synchronized (this.i) {
            this.i.removeAll(events.keySet());
        }
        d();
    }

    public final void c(Map events) {
        Intrinsics.checkNotNullParameter(events, "events");
        a(events.keySet());
        synchronized (this.i) {
            this.i.removeAll(events.keySet());
        }
        d();
    }

    public final void d() {
        synchronized (this.h) {
            this.g--;
        }
    }

    private final boolean b() {
        boolean z;
        synchronized (this.h) {
            z = this.g > 0;
            Unit unit = Unit.INSTANCE;
        }
        return z;
    }

    private final void b(Map map, BaaSUser baaSUser) {
        boolean zContains;
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            synchronized (this.i) {
                zContains = this.i.contains(str);
                Unit unit = Unit.INSTANCE;
            }
            if (!zContains) {
                try {
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
                    JSONObject jSONObject = new JSONObject((String) value);
                    String string = jSONObject.getString("eventCategory");
                    Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(EVENT_CATEGORY)");
                    String string2 = jSONObject.getString("userId");
                    Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(EVENT_USER_ID)");
                    if (!Intrinsics.areEqual(baaSUser.getUserId(), string2)) {
                        hashSet.add(str);
                    } else {
                        if (!Intrinsics.areEqual("NPFCOMMON", string) && !Intrinsics.areEqual("NPFAUDIT", string)) {
                            if (map3.size() < 10) {
                                map3.put(str, jSONObject);
                            }
                        } else if (map2.size() < 10) {
                            map2.put(str, jSONObject);
                        }
                        if (map2.size() >= 10 && map3.size() >= 10) {
                            break;
                        }
                    }
                } catch (JSONException unused) {
                    hashSet.add(str);
                }
            }
        }
        if (hashSet.size() > 0) {
            a(hashSet);
        }
        a(this.e, map2, baaSUser);
        a(this.f, map3, baaSUser);
        d();
    }

    public final void c() {
        synchronized (this.h) {
            this.g++;
        }
    }

    public final void a(Map events) {
        Intrinsics.checkNotNullParameter(events, "events");
        Iterator it = events.entrySet().iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = (JSONObject) ((Map.Entry) it.next()).getValue();
            try {
                SDKLog.d(k, "Valid event : " + jSONObject.getString("eventCategory") + " : " + jSONObject.getString("eventId"));
            } catch (JSONException e) {
                SDKLog.w(k, "processCompletedEvents Error", e);
            }
        }
        com.nintendo.npf.sdk.internal.impl.b.a(this.c, events.keySet());
        synchronized (this.i) {
            this.i.removeAll(events.keySet());
        }
        d();
    }

    public final void a(Map cacheEntries, BaaSUser user) {
        boolean zContains;
        Intrinsics.checkNotNullParameter(cacheEntries, "cacheEntries");
        Intrinsics.checkNotNullParameter(user, "user");
        HashMap map = new HashMap();
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : cacheEntries.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            synchronized (this.i) {
                zContains = this.i.contains(str);
                Unit unit = Unit.INSTANCE;
            }
            if (!zContains) {
                try {
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
                    JSONObject jSONObject = new JSONObject((String) value);
                    String string = jSONObject.getString("userId");
                    Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(EVENT_USER_ID)");
                    if (!Intrinsics.areEqual(user.getUserId(), string)) {
                        hashSet.add(str);
                    } else {
                        map.put(str, jSONObject);
                        if (map.size() >= 10) {
                            break;
                        }
                    }
                } catch (JSONException unused) {
                    hashSet.add(str);
                }
            }
        }
        if (hashSet.size() > 0) {
            a(hashSet);
        }
        a(this.e, map, user);
        d();
    }

    private final void a(t tVar, Map map, BaaSUser baaSUser) {
        if (map.isEmpty() || !tVar.a(map, baaSUser)) {
            return;
        }
        synchronized (this.i) {
            this.i.addAll(map.keySet());
        }
        c();
    }

    public final void a(Set invalidEventKeys) {
        Intrinsics.checkNotNullParameter(invalidEventKeys, "invalidEventKeys");
        SDKLog.w(k, "drainAnalytics remove " + invalidEventKeys.size() + " invalid events");
        com.nintendo.npf.sdk.internal.impl.b.a(this.c, invalidEventKeys);
    }
}
