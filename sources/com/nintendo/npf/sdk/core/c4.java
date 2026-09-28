package com.nintendo.npf.sdk.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f424a;
    private final String b;
    private final String c;
    private final String d;

    public c4(String packageName, String appVersion, String signatureSHA1, String appName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(signatureSHA1, "signatureSHA1");
        Intrinsics.checkNotNullParameter(appName, "appName");
        this.f424a = packageName;
        this.b = appVersion;
        this.c = signatureSHA1;
        this.d = appName;
    }

    public final String a() {
        return this.d;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.f424a;
    }

    public final String d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c4)) {
            return false;
        }
        c4 c4Var = (c4) obj;
        return Intrinsics.areEqual(this.f424a, c4Var.f424a) && Intrinsics.areEqual(this.b, c4Var.b) && Intrinsics.areEqual(this.c, c4Var.c) && Intrinsics.areEqual(this.d, c4Var.d);
    }

    public int hashCode() {
        return (((((this.f424a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "PackageInformation(packageName=" + this.f424a + ", appVersion=" + this.b + ", signatureSHA1=" + this.c + ", appName=" + this.d + ')';
    }
}
