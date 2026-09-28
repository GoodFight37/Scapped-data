package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class r1 extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NPFError f554a;
    private final String b;

    public r1(NPFError npfError, String sessionToken) {
        Intrinsics.checkNotNullParameter(npfError, "npfError");
        Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
        this.f554a = npfError;
        this.b = sessionToken;
    }

    public final NPFError a() {
        return this.f554a;
    }

    public final String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r1)) {
            return false;
        }
        r1 r1Var = (r1) obj;
        return Intrinsics.areEqual(this.f554a, r1Var.f554a) && Intrinsics.areEqual(this.b, r1Var.b);
    }

    public int hashCode() {
        return (this.f554a.hashCode() * 31) + this.b.hashCode();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "GetNintendoAccountException(npfError=" + this.f554a + ", sessionToken=" + this.b + ')';
    }
}
