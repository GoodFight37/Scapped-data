package com.nintendo.npf.sdk.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class z1 implements y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n1 f634a;
    private w1 b;

    public z1(n1 fileDataSource) {
        Intrinsics.checkNotNullParameter(fileDataSource, "fileDataSource");
        this.f634a = fileDataSource;
    }

    @Override // com.nintendo.npf.sdk.core.y1
    public String a() {
        w1 w1Var = this.b;
        if (w1Var != null) {
            return w1Var.c();
        }
        return null;
    }

    @Override // com.nintendo.npf.sdk.core.y1
    public String b() {
        return this.f634a.a().f();
    }

    @Override // com.nintendo.npf.sdk.core.y1
    public int c() {
        w1 w1Var = this.b;
        if (w1Var != null) {
            return w1Var.d();
        }
        return 180000;
    }

    @Override // com.nintendo.npf.sdk.core.y1
    public String d() {
        String strA;
        w1 w1Var = this.b;
        return (w1Var == null || (strA = w1Var.a()) == null) ? "api.accounts.nintendo.com" : strA;
    }

    @Override // com.nintendo.npf.sdk.core.y1
    public String e() {
        String strB;
        w1 w1Var = this.b;
        return (w1Var == null || (strB = w1Var.b()) == null) ? "accounts.nintendo.com" : strB;
    }

    @Override // com.nintendo.npf.sdk.core.y1
    public String f() {
        return this.f634a.a().a();
    }

    @Override // com.nintendo.npf.sdk.core.y1
    public String g() {
        return this.f634a.a().d();
    }

    @Override // com.nintendo.npf.sdk.core.y1
    public boolean h() {
        return this.f634a.a().n();
    }

    @Override // com.nintendo.npf.sdk.core.y1
    public boolean i() {
        return this.f634a.a().o();
    }

    @Override // com.nintendo.npf.sdk.core.y1
    public void a(w1 hostConfiguration) {
        Intrinsics.checkNotNullParameter(hostConfiguration, "hostConfiguration");
        this.b = hostConfiguration;
    }
}
