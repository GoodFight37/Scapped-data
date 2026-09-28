package com.nintendo.npf.sdk.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f496a;
    private final String b;

    public j1(String id, String password) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(password, "password");
        this.f496a = id;
        this.b = password;
    }

    public final String a() {
        return this.f496a;
    }

    public final String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j1)) {
            return false;
        }
        j1 j1Var = (j1) obj;
        return Intrinsics.areEqual(this.f496a, j1Var.f496a) && Intrinsics.areEqual(this.b, j1Var.b);
    }

    public int hashCode() {
        return (this.f496a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "DeviceAccount(id=" + this.f496a + ", password=" + this.b + ')';
    }
}
