package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.internal.client.core.HttpClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z3 implements y3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HttpClient f644a;

    public z3(HttpClient httpClient) {
        this.f644a = httpClient;
    }

    @Override // com.nintendo.npf.sdk.core.y3
    public void a(BaaSUser baaSUser, v2 v2Var) {
        this.f644a.a(String.format(Locale.US, "%s/push_channels/%s/%s", "/notification/v1", baaSUser.getUserId(), baaSUser.getDeviceAccount()), b2.c(baaSUser.getAccessToken()), null, true, v2Var);
    }

    @Override // com.nintendo.npf.sdk.core.y3
    public void a(BaaSUser baaSUser, JSONObject jSONObject, m1 m1Var) {
        this.f644a.b(String.format(Locale.US, "%s/push_channels/%s/%s", "/notification/v1", baaSUser.getUserId(), baaSUser.getDeviceAccount()), b2.c(baaSUser.getAccessToken()), null, q4.a(jSONObject), true, m1Var);
    }
}
