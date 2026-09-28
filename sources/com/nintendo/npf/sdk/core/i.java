package com.nintendo.npf.sdk.core;

import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public static final a m = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f475a;
    private final long b;
    private final String c;
    private final boolean d;
    private final int e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final Map k;
    private final int l;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public enum b {
        NONE("NONE"),
        V1("V1"),
        V2("V2");

        public static final a Companion = new a(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f476a;

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final b a(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                for (b bVar : b.values()) {
                    if (Intrinsics.areEqual(bVar.b(), name)) {
                        return bVar;
                    }
                }
                return b.NONE;
            }

            private a() {
            }
        }

        b(String str) {
            this.f476a = str;
        }

        public final String b() {
            return this.f476a;
        }
    }

    public i() {
        this(null, 0L, null, false, 0, null, null, null, null, null, null, 2047, null);
    }

    public final i a(b mode, long j, String str, boolean z, int i, String str2, String str3, String str4, String str5, String str6, Map map) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        return new i(mode, j, str, z, i, str2, str3, str4, str5, str6, map);
    }

    public final Map b() {
        return this.k;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.j;
    }

    public final String e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f475a == iVar.f475a && this.b == iVar.b && Intrinsics.areEqual(this.c, iVar.c) && this.d == iVar.d && this.e == iVar.e && Intrinsics.areEqual(this.f, iVar.f) && Intrinsics.areEqual(this.g, iVar.g) && Intrinsics.areEqual(this.h, iVar.h) && Intrinsics.areEqual(this.i, iVar.i) && Intrinsics.areEqual(this.j, iVar.j) && Intrinsics.areEqual(this.k, iVar.k);
    }

    public final long f() {
        return this.b;
    }

    public final b g() {
        return this.f475a;
    }

    public final String h() {
        return this.i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    public int hashCode() {
        int iHashCode = ((this.f475a.hashCode() * 31) + Long.hashCode(this.b)) * 31;
        String str = this.c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z = this.d;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode3 = (((iHashCode2 + r1) * 31) + Integer.hashCode(this.e)) * 31;
        String str2 = this.f;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.g;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.h;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.i;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.j;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Map map = this.k;
        return iHashCode8 + (map != null ? map.hashCode() : 0);
    }

    public final int i() {
        return this.l;
    }

    public final String j() {
        return this.g;
    }

    public final boolean k() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AnalyticsConfig(mode=");
        sb.append(this.f475a).append(", expirationTime=").append(this.b).append(", applicationId=").append(this.c).append(", isImmediateReporting=").append(this.d).append(", _reportingPeriod=").append(this.e).append(", accessToken=").append(this.f).append(", topic=").append(this.g).append(", country=").append(this.h).append(", region=").append(this.i).append(", city=").append(this.j).append(", analyticsPermissionMap=").append(this.k).append(')');
        return sb.toString();
    }

    public i(b mode, long j, String str, boolean z, int i, String str2, String str3, String str4, String str5, String str6, Map map) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.f475a = mode;
        this.b = j;
        this.c = str;
        this.d = z;
        this.e = i;
        this.f = str2;
        this.g = str3;
        this.h = str4;
        this.i = str5;
        this.j = str6;
        this.k = map;
        this.l = i < 10000 ? 10000 : i;
    }

    public final String a() {
        return this.f;
    }

    public /* synthetic */ i(b bVar, long j, String str, boolean z, int i, String str2, String str3, String str4, String str5, String str6, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? b.NONE : bVar, (i2 & 2) != 0 ? 0L : j, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? 60000 : i, (i2 & 32) != 0 ? null : str2, (i2 & 64) != 0 ? null : str3, (i2 & 128) != 0 ? null : str4, (i2 & 256) != 0 ? null : str5, (i2 & 512) != 0 ? null : str6, (i2 & 1024) == 0 ? map : null);
    }
}
