package com.nintendo.npf.sdk.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class z4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f645a;
    private final String b;
    private final String c;

    public z4(String str, String str2, String debugUriString) {
        Intrinsics.checkNotNullParameter(debugUriString, "debugUriString");
        this.f645a = str;
        this.b = str2;
        this.c = debugUriString;
    }

    public final String a() {
        return this.c;
    }

    public final String b() {
        return this.f645a;
    }

    public final String c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z4)) {
            return false;
        }
        z4 z4Var = (z4) obj;
        return Intrinsics.areEqual(this.f645a, z4Var.f645a) && Intrinsics.areEqual(this.b, z4Var.b) && Intrinsics.areEqual(this.c, z4Var.c);
    }

    public int hashCode() {
        String str = this.f645a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "SessionTokenCodeAndState(sessionTokenCode=" + this.f645a + ", state=" + this.b + ", debugUriString=" + this.c + ')';
    }
}
