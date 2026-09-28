package com.nintendo.npf.sdk.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 implements u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n1 f591a;
    private Integer b;
    private Integer c;
    private Boolean d;

    public v0(n1 fileDataSource) {
        Intrinsics.checkNotNullParameter(fileDataSource, "fileDataSource");
        this.f591a = fileDataSource;
    }

    @Override // com.nintendo.npf.sdk.core.u0
    public int a() {
        Integer num = this.b;
        return num != null ? num.intValue() : this.f591a.a().g();
    }

    @Override // com.nintendo.npf.sdk.core.u0
    public void b(int i) {
        this.b = Integer.valueOf(i);
    }

    @Override // com.nintendo.npf.sdk.core.u0
    public boolean c() {
        Boolean bool = this.d;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.nintendo.npf.sdk.core.u0
    public void a(int i) {
        this.c = Integer.valueOf(i);
    }

    @Override // com.nintendo.npf.sdk.core.u0
    public int b() {
        Integer num = this.c;
        return num != null ? num.intValue() : this.f591a.a().h();
    }

    @Override // com.nintendo.npf.sdk.core.u0
    public void a(boolean z) {
        this.d = Boolean.valueOf(z);
    }
}
