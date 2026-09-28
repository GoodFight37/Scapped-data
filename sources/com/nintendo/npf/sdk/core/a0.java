package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.internal.client.core.HttpClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class a0 implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HttpClient f406a;

    public a0(HttpClient httpClient) {
        this.f406a = httpClient;
    }

    @Override // com.nintendo.npf.sdk.core.y
    public void a(BaaSUser baaSUser, JSONArray jSONArray, u2 u2Var) {
        this.f406a.a(String.format(Locale.US, "%s/profanity_inspect", "/audit/v1"), b2.c(baaSUser.getAccessToken()), (Map) null, q4.a(jSONArray), "application/json", true, (r4) u2Var);
    }
}
