package com.nintendo.npf.sdk.core;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f439a;
    private final Map b;
    private final String c;

    public e2(int i, Map map, String str) {
        this.f439a = i;
        this.b = map;
        this.c = str;
    }

    public final String a() {
        return this.c;
    }

    public final int b() {
        return this.f439a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e2)) {
            return false;
        }
        e2 e2Var = (e2) obj;
        return this.f439a == e2Var.f439a && Intrinsics.areEqual(this.b, e2Var.b) && Intrinsics.areEqual(this.c, e2Var.c);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.f439a) * 31;
        Map map = this.b;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        String str = this.c;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "HttpResponse(statusCode=" + this.f439a + ", headers=" + this.b + ", body=" + this.c + ')';
    }
}
