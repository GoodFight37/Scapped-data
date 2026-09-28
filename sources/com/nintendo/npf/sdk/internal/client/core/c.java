package com.nintendo.npf.sdk.internal.client.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f767a;
    public final String b;
    public final String c;
    public final Integer d;
    public final String e;
    public final Map f;
    public final Map g;
    public final String h;
    public final byte[] i;
    public final boolean j;

    public static final class a {
        private Integer d;
        private byte[] i;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f768a = "";
        private String b = "";
        private String c = "";
        private String e = "";
        private Map f = MapsKt.emptyMap();
        private Map g = MapsKt.emptyMap();
        private String h = "";
        private boolean j = true;

        public final a a(Map map) {
            if (map != null) {
                this.f = map;
            }
            return this;
        }

        public final a b(String str) {
            if (str != null) {
                this.c = str;
            }
            return this;
        }

        public final a c(String str) {
            if (str != null) {
                this.f768a = str;
            }
            return this;
        }

        public final a d(String str) {
            if (str != null) {
                this.e = str;
            }
            return this;
        }

        public final a e(String str) {
            if (str != null) {
                this.b = str;
            }
            return this;
        }

        public final a a(String str) {
            if (str != null) {
                this.h = str;
            }
            return this;
        }

        public final a b(Map map) {
            if (map != null) {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    Pair pair = str2 != null ? TuplesKt.to(str, str2) : null;
                    if (pair != null) {
                        arrayList.add(pair);
                    }
                }
                this.g = MapsKt.toMap(arrayList);
            }
            return this;
        }

        public final a a(byte[] bArr) {
            this.i = bArr;
            return this;
        }

        public final a a(boolean z) {
            this.j = z;
            return this;
        }

        public final c a() {
            return new c(this.f768a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, null);
        }
    }

    public /* synthetic */ c(String str, String str2, String str3, Integer num, String str4, Map map, Map map2, String str5, byte[] bArr, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, num, str4, map, map2, str5, bArr, z);
    }

    public final c a(String method, String scheme, String host, Integer num, String path, Map headers, Map queryParams, String contentType, byte[] bArr, boolean z) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(queryParams, "queryParams");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        return new c(method, scheme, host, num, path, headers, queryParams, contentType, bArr, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(c.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.nintendo.npf.sdk.internal.client.core.RequestParams");
        c cVar = (c) obj;
        if (!Intrinsics.areEqual(this.f767a, cVar.f767a) || !Intrinsics.areEqual(this.b, cVar.b) || !Intrinsics.areEqual(this.c, cVar.c) || !Intrinsics.areEqual(this.d, cVar.d) || !Intrinsics.areEqual(this.e, cVar.e) || !Intrinsics.areEqual(this.f, cVar.f) || !Intrinsics.areEqual(this.g, cVar.g) || !Intrinsics.areEqual(this.h, cVar.h)) {
            return false;
        }
        byte[] bArr = this.i;
        if (bArr != null) {
            byte[] bArr2 = cVar.i;
            if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } else if (cVar.i != null) {
            return false;
        }
        return this.j == cVar.j;
    }

    public int hashCode() {
        int iHashCode = ((((this.f767a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        Integer num = this.d;
        int iIntValue = (((((((((iHashCode + (num != null ? num.intValue() : 0)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        byte[] bArr = this.i;
        return ((iIntValue + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31) + Boolean.hashCode(this.j);
    }

    public String toString() {
        return "RequestParams(method=" + this.f767a + ", scheme=" + this.b + ", host=" + this.c + ", port=" + this.d + ", path=" + this.e + ", headers=" + this.f + ", queryParams=" + this.g + ", contentType=" + this.h + ", data=" + Arrays.toString(this.i) + ", retry=" + this.j + ')';
    }

    private c(String str, String str2, String str3, Integer num, String str4, Map map, Map map2, String str5, byte[] bArr, boolean z) {
        this.f767a = str;
        this.b = str2;
        this.c = str3;
        this.d = num;
        this.e = str4;
        this.f = map;
        this.g = map2;
        this.h = str5;
        this.i = bArr;
        this.j = z;
    }
}
