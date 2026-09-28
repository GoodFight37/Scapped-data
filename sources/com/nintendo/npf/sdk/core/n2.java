package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.internal.client.core.HttpClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class n2 implements k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HttpClient f527a;

    public n2(HttpClient httpClient) {
        this.f527a = httpClient;
    }

    @Override // com.nintendo.npf.sdk.core.k2
    public void a(BaaSUser baaSUser, v2 v2Var) {
        this.f527a.a(String.format(Locale.US, "%s/users/%s", "/inquiry/v1", baaSUser.getUserId()), b2.c(baaSUser.getAccessToken()), null, true, v2Var);
    }
}
