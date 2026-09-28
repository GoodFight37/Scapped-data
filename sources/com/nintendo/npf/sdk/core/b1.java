package com.nintendo.npf.sdk.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b1 implements a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b5 f414a;

    public b1(b5 sharedPreferencesDataSource) {
        Intrinsics.checkNotNullParameter(sharedPreferencesDataSource, "sharedPreferencesDataSource");
        this.f414a = sharedPreferencesDataSource;
    }

    @Override // com.nintendo.npf.sdk.core.a1
    public String a() {
        return this.f414a.b();
    }

    @Override // com.nintendo.npf.sdk.core.a1
    public String b() {
        return this.f414a.e();
    }

    @Override // com.nintendo.npf.sdk.core.a1
    public String c() {
        return this.f414a.a();
    }

    @Override // com.nintendo.npf.sdk.core.a1
    public String d() {
        return this.f414a.c();
    }

    @Override // com.nintendo.npf.sdk.core.a1
    public void a(String str) {
        this.f414a.c(str);
    }

    @Override // com.nintendo.npf.sdk.core.a1
    public void b(String str) {
        this.f414a.e(str);
    }

    @Override // com.nintendo.npf.sdk.core.a1
    public void a(String str, String str2) {
        this.f414a.a(str);
        this.f414a.b(str2);
    }
}
