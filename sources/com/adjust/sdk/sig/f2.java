package com.adjust.sdk.sig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class f2 implements p2, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f129a;
    public int b = -1;
    public final String[] c;
    public final List[] d;
    public final boolean[] e;
    public Map f;
    public final w1 g;
    public final w1 h;
    public final w1 i;

    public f2(a0 a0Var) {
        this.f129a = a0Var;
        String[] strArr = new String[2];
        for (int i = 0; i < 2; i++) {
            strArr[i] = "[UNINITIALIZED]";
        }
        this.c = strArr;
        this.d = new List[2];
        this.e = new boolean[2];
        this.f = e0.f124a;
        this.g = x1.a(new h0() { // from class: com.adjust.sdk.sig.f2$$ExternalSyntheticLambda0
            @Override // com.adjust.sdk.sig.h0
            public final Object a() {
                return f2.b(this.f$0);
            }
        });
        this.h = x1.a(new h0() { // from class: com.adjust.sdk.sig.f2$$ExternalSyntheticLambda1
            @Override // com.adjust.sdk.sig.h0
            public final Object a() {
                return f2.c(this.f$0);
            }
        });
        this.i = x1.a(new h0() { // from class: com.adjust.sdk.sig.f2$$ExternalSyntheticLambda2
            @Override // com.adjust.sdk.sig.h0
            public final Object a() {
                return Integer.valueOf(f2.a(this.f$0));
            }
        });
    }

    public static final int a(f2 f2Var) {
        int iHashCode = Arrays.hashCode((p2[]) f2Var.h.getValue()) + 1231163861;
        int iHashCode2 = 1;
        int i = 2;
        int i2 = 1;
        int i3 = 2;
        while (true) {
            int iHashCode3 = 0;
            if (i3 <= 0) {
                break;
            }
            int i4 = i3 - 1;
            int i5 = i2 * 31;
            String strB = f2Var.b(2 - i3).b();
            if (strB != null) {
                iHashCode3 = strB.hashCode();
            }
            i2 = i5 + iHashCode3;
            i3 = i4;
        }
        while (i > 0) {
            int i6 = i - 1;
            int i7 = iHashCode2 * 31;
            t2 t2VarE = f2Var.b(f2Var.f() - i).e();
            iHashCode2 = i7 + (t2VarE != null ? t2VarE.toString().hashCode() : 0);
            i = i6;
        }
        return (((iHashCode * 31) + i2) * 31) + iHashCode2;
    }

    @Override // com.adjust.sdk.sig.p2
    public final String b() {
        return "com.adjust.sdk.sig.755f89ae93acbe52c30f8a09";
    }

    @Override // com.adjust.sdk.sig.i
    public final Set c() {
        return this.f.keySet();
    }

    @Override // com.adjust.sdk.sig.p2
    public final t2 e() {
        return i3.f137a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f2)) {
            return false;
        }
        p2 p2Var = (p2) obj;
        if (!"com.adjust.sdk.sig.755f89ae93acbe52c30f8a09".equals(p2Var.b()) || !Arrays.equals((p2[]) this.h.getValue(), (p2[]) ((f2) obj).h.getValue()) || 2 != p2Var.f()) {
            return false;
        }
        for (int i = 0; i < 2; i++) {
            if (!i1.a(b(i).b(), p2Var.b(i).b()) || !i1.a(b(i).e(), p2Var.b(i).e())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.adjust.sdk.sig.p2
    public final int f() {
        return 2;
    }

    @Override // com.adjust.sdk.sig.p2
    public final List getAnnotations() {
        return d0.f122a;
    }

    public final int hashCode() {
        return ((Number) this.i.getValue()).intValue();
    }

    public final String toString() {
        return g2.a(this);
    }

    public static final t1[] b(f2 f2Var) {
        a0 a0Var = f2Var.f129a;
        b3 b3Var = b3.f118a;
        b3 b3Var2 = b3.f118a;
        b2 b2Var = new b2(b3Var);
        h1 h1Var = h1.f134a;
        h1 h1Var2 = h1.f134a;
        return new t1[]{b2Var, new b2(h1Var)};
    }

    public static final p2[] c(f2 f2Var) {
        p2[] p2VarArr;
        a0 a0Var = f2Var.f129a;
        ArrayList arrayList = new ArrayList(0);
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return (arrayList == null || (p2VarArr = (p2[]) arrayList.toArray(new p2[0])) == null) ? e2.f125a : p2VarArr;
    }

    @Override // com.adjust.sdk.sig.p2
    public final p2 b(int i) {
        return ((t1[]) this.g.getValue())[i].a();
    }

    public final void a(String str) {
        String[] strArr = this.c;
        int i = this.b + 1;
        this.b = i;
        strArr[i] = str;
        this.e[i] = true;
        this.d[i] = null;
        if (i == 1) {
            HashMap map = new HashMap();
            int length = this.c.length;
            for (int i2 = 0; i2 < length; i2++) {
                map.put(this.c[i2], Integer.valueOf(i2));
            }
            this.f = map;
        }
    }

    @Override // com.adjust.sdk.sig.p2
    public final String a(int i) {
        return this.c[i];
    }
}
