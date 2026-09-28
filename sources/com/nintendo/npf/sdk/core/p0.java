package com.nintendo.npf.sdk.core;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 {
    public static final a o = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f541a;
    private final boolean b;
    private final boolean c;
    private final String d;
    private final String e;
    private final String f;
    private final boolean g;
    private final String h;
    private final boolean i;
    private final int j;
    private final int k;
    private final boolean l;
    private final boolean m;
    private final boolean n;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public p0(String baasHost, boolean z, boolean z2, String clientId, String str, String str2, boolean z3, String str3, boolean z4, int i, int i2, boolean z5, boolean z6, boolean z7) {
        Intrinsics.checkNotNullParameter(baasHost, "baasHost");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        this.f541a = baasHost;
        this.b = z;
        this.c = z2;
        this.d = clientId;
        this.e = str;
        this.f = str2;
        this.g = z3;
        this.h = str3;
        this.i = z4;
        this.j = i;
        this.k = i2;
        this.l = z5;
        this.m = z6;
        this.n = z7;
    }

    public final String a() {
        return this.f541a;
    }

    public final String b() {
        return this.f;
    }

    public final String c() {
        return this.e;
    }

    public final String d() {
        return this.d;
    }

    public final boolean e() {
        return this.n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p0)) {
            return false;
        }
        p0 p0Var = (p0) obj;
        return Intrinsics.areEqual(this.f541a, p0Var.f541a) && this.b == p0Var.b && this.c == p0Var.c && Intrinsics.areEqual(this.d, p0Var.d) && Intrinsics.areEqual(this.e, p0Var.e) && Intrinsics.areEqual(this.f, p0Var.f) && this.g == p0Var.g && Intrinsics.areEqual(this.h, p0Var.h) && this.i == p0Var.i && this.j == p0Var.j && this.k == p0Var.k && this.l == p0Var.l && this.m == p0Var.m && this.n == p0Var.n;
    }

    public final String f() {
        return this.h;
    }

    public final int g() {
        return this.j;
    }

    public final int h() {
        return this.k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25, types: [int] */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v24, types: [int] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = this.f541a.hashCode() * 31;
        boolean z = this.b;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.c;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int iHashCode2 = (((i + r2) * 31) + this.d.hashCode()) * 31;
        String str = this.e;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z3 = this.g;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (iHashCode4 + r3) * 31;
        String str3 = this.h;
        int iHashCode5 = (i2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z4 = this.i;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int iHashCode6 = (((((iHashCode5 + r4) * 31) + Integer.hashCode(this.j)) * 31) + Integer.hashCode(this.k)) * 31;
        boolean z5 = this.l;
        ?? r5 = z5;
        if (z5) {
            r5 = 1;
        }
        int i3 = (iHashCode6 + r5) * 31;
        boolean z6 = this.m;
        ?? r6 = z6;
        if (z6) {
            r6 = 1;
        }
        int i4 = (i3 + r6) * 31;
        boolean z7 = this.n;
        return i4 + (z7 ? 1 : z7);
    }

    public final boolean i() {
        return this.c;
    }

    public final boolean j() {
        return this.m;
    }

    public final boolean k() {
        return this.l;
    }

    public final boolean l() {
        return this.b;
    }

    public final boolean m() {
        return this.g;
    }

    public final boolean n() {
        return StringsKt.contains$default((CharSequence) this.f541a, (CharSequence) "-sb", false, 2, (Object) null);
    }

    public final boolean o() {
        return this.i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BuildConfiguration(baasHost=");
        sb.append(this.f541a).append(", isPrintLog=").append(this.b).append(", isDebugLog=").append(this.c).append(", clientId=").append(this.d).append(", basicAuthUser=").append(this.e).append(", basicAuthPass=").append(this.f).append(", isPurchaseMock=").append(this.g).append(", marketForSandbox=").append(this.h).append(", isUsingHttp=").append(this.i).append(", readTimeout=").append(this.j).append(", requestTimeout=").append(this.k).append(", isDisabledUsingGoogleAdvertisingId=");
        sb.append(this.l).append(", isDisabledUsingDeviceAnalyticsId=").append(this.m).append(", forceEnablePurchaseMock=").append(this.n).append(')');
        return sb.toString();
    }
}
