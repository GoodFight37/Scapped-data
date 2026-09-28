package com.nintendo.npf.sdk.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e1 implements d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n1 f438a;

    public e1(n1 fileDataSource) {
        Intrinsics.checkNotNullParameter(fileDataSource, "fileDataSource");
        this.f438a = fileDataSource;
    }

    @Override // com.nintendo.npf.sdk.core.d1
    public boolean a() {
        return this.f438a.a().l();
    }

    @Override // com.nintendo.npf.sdk.core.d1
    public boolean b() {
        return this.f438a.a().i();
    }

    @Override // com.nintendo.npf.sdk.core.d1
    public String c() {
        return this.f438a.a().b();
    }

    @Override // com.nintendo.npf.sdk.core.d1
    public boolean d() {
        return (this.f438a.a().n() && this.f438a.a().m()) || this.f438a.a().e();
    }

    @Override // com.nintendo.npf.sdk.core.d1
    public String e() {
        return this.f438a.a().c();
    }
}
