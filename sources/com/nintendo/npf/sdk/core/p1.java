package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.user.BaaSUser;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j1 f542a;
    private final BaaSUser b;
    private final w1 c;
    private final String d;
    private final String e;

    public p1(j1 j1Var, BaaSUser user, w1 w1Var, String str, String str2) {
        Intrinsics.checkNotNullParameter(user, "user");
        this.f542a = j1Var;
        this.b = user;
        this.c = w1Var;
        this.d = str;
        this.e = str2;
    }

    public final j1 a() {
        return this.f542a;
    }

    public final w1 b() {
        return this.c;
    }

    public final String c() {
        return this.e;
    }

    public final String d() {
        return this.d;
    }

    public final BaaSUser e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p1)) {
            return false;
        }
        p1 p1Var = (p1) obj;
        return Intrinsics.areEqual(this.f542a, p1Var.f542a) && Intrinsics.areEqual(this.b, p1Var.b) && Intrinsics.areEqual(this.c, p1Var.c) && Intrinsics.areEqual(this.d, p1Var.d) && Intrinsics.areEqual(this.e, p1Var.e);
    }

    public int hashCode() {
        j1 j1Var = this.f542a;
        int iHashCode = (((j1Var == null ? 0 : j1Var.hashCode()) * 31) + this.b.hashCode()) * 31;
        w1 w1Var = this.c;
        int iHashCode2 = (iHashCode + (w1Var == null ? 0 : w1Var.hashCode())) * 31;
        String str = this.d;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.e;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "GatewaySuccessResponse(createdDeviceAccount=" + this.f542a + ", user=" + this.b + ", hostConfiguration=" + this.c + ", sessionId=" + this.d + ", market=" + this.e + ')';
    }
}
