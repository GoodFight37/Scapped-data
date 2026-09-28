package com.nintendo.npf.sdk.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f602a;
    private final String b;
    private final String c;
    private final int d;

    public w1(String accountHost, String accountApiHost, String str, int i) {
        Intrinsics.checkNotNullParameter(accountHost, "accountHost");
        Intrinsics.checkNotNullParameter(accountApiHost, "accountApiHost");
        this.f602a = accountHost;
        this.b = accountApiHost;
        this.c = str;
        this.d = i;
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.f602a;
    }

    public final String c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w1)) {
            return false;
        }
        w1 w1Var = (w1) obj;
        return Intrinsics.areEqual(this.f602a, w1Var.f602a) && Intrinsics.areEqual(this.b, w1Var.b) && Intrinsics.areEqual(this.c, w1Var.c) && this.d == w1Var.d;
    }

    public int hashCode() {
        int iHashCode = ((this.f602a.hashCode() * 31) + this.b.hashCode()) * 31;
        String str = this.c;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.d);
    }

    public String toString() {
        return "HostConfiguration(accountHost=" + this.f602a + ", accountApiHost=" + this.b + ", pointProgramHost=" + this.c + ", sessionUpdateInterval=" + this.d + ')';
    }
}
