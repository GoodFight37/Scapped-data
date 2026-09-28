package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g implements t {
    private static final String e = "g";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f464a;
    private final m0 b;
    private final Function2 c;
    private final Function2 d;

    public g(m0 m0Var, Function2 function2, Function2 function3) {
        this.b = m0Var;
        this.c = function2;
        this.d = function3;
    }

    private void b(Map map) {
        this.c.invoke(this, map);
    }

    @Override // com.nintendo.npf.sdk.core.t
    public boolean a(final Map map, BaaSUser baaSUser) {
        if (this.f464a) {
            return false;
        }
        if (!h0.c(baaSUser)) {
            SDKLog.w(e, "User is not logged in");
            return false;
        }
        this.f464a = true;
        JSONArray jSONArray = new JSONArray();
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            jSONArray.put((JSONObject) it.next());
        }
        this.b.a(baaSUser, jSONArray, new Function1() { // from class: com.nintendo.npf.sdk.core.g$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.a(map, (NPFError) obj);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit a(Map map, NPFError nPFError) {
        if (nPFError == null) {
            b(map);
        } else {
            a(map);
        }
        return Unit.INSTANCE;
    }

    private void a(Map map) {
        this.d.invoke(this, map);
    }
}
