package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.internal.client.core.HttpClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class o0 implements n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HttpClient f531a;

    public o0(HttpClient httpClient) {
        this.f531a = httpClient;
    }

    @Override // com.nintendo.npf.sdk.core.n0
    public void a(BaaSUser baaSUser, JSONArray jSONArray, m1 m1Var) throws Throwable {
        String str = String.format(Locale.US, "%s/analytics/events", "/bigdata/v1");
        HashMap map = new HashMap();
        map.putAll(b2.c(baaSUser.getAccessToken()));
        map.putAll(b2.d("gzip"));
        this.f531a.a(str, (Map) map, (Map) null, q4.b(jSONArray), "application/json", true, (r4) m1Var);
    }

    @Override // com.nintendo.npf.sdk.core.n0
    public void a(BaaSUser baaSUser, v2 v2Var) {
        this.f531a.a(String.format(Locale.US, "%s/analytics/events/config", "/bigdata/v1"), b2.c(baaSUser.getAccessToken()), null, true, v2Var);
    }
}
