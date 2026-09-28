package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.analytics.ResettableIdType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ResettableIdType f556a;
    private final boolean b;
    private final String c;

    public s(ResettableIdType resettableIdType, boolean z, String str) {
        Intrinsics.checkNotNullParameter(resettableIdType, "resettableIdType");
        this.f556a = resettableIdType;
        this.b = z;
        this.c = str;
    }

    public final String a() {
        return this.c;
    }

    public final ResettableIdType b() {
        return this.f556a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f556a == sVar.f556a && this.b == sVar.b && Intrinsics.areEqual(this.c, sVar.c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = this.f556a.hashCode() * 31;
        boolean z = this.b;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        String str = this.c;
        return i + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "AnalyticsPermission(resettableIdType=" + this.f556a + ", permitted=" + this.b + ", resettableId=" + this.c + ')';
    }
}
