package com.nintendo.npf.sdk.core;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f513a;
    private final Map b;

    public k4(String data, Map attributes) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.f513a = data;
        this.b = attributes;
    }

    public final Map a() {
        return this.b;
    }

    public final String b() {
        return this.f513a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k4)) {
            return false;
        }
        k4 k4Var = (k4) obj;
        return Intrinsics.areEqual(this.f513a, k4Var.f513a) && Intrinsics.areEqual(this.b, k4Var.b);
    }

    public int hashCode() {
        return (this.f513a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "PublishMessage(data=" + this.f513a + ", attributes=" + this.b + ')';
    }
}
