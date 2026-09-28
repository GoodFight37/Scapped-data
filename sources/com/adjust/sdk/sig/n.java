package com.adjust.sdk.sig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class n {
    static {
        int i = 0;
        List listAsList = Arrays.asList(h0.class, s0.class, w0.class, x0.class, y0.class, z0.class, a1.class, b1.class, c1.class, d1.class, i0.class, j0.class, k0.class, l0.class, m0.class, n0.class, o0.class, p0.class, q0.class, r0.class, t0.class, u0.class, v0.class);
        ArrayList arrayList = new ArrayList(listAsList.size());
        int i2 = 0;
        for (Object obj : listAsList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            arrayList.add(new c2((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        int size = arrayList.size();
        if (size != 0) {
            if (size == 1) {
                c2 c2Var = (c2) arrayList.get(0);
                Collections.singletonMap(c2Var.f121a, c2Var.b);
                return;
            }
            int size2 = arrayList.size();
            if (size2 >= 0) {
                size2 = size2 < 3 ? size2 + 1 : size2 < 1073741824 ? (int) ((size2 / 0.75f) + 1.0f) : Integer.MAX_VALUE;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(size2);
            int size3 = arrayList.size();
            while (i < size3) {
                Object obj2 = arrayList.get(i);
                i++;
                c2 c2Var2 = (c2) obj2;
                linkedHashMap.put(c2Var2.f121a, c2Var2.b);
            }
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof n) && r1.a(this).equals(r1.a((n) obj));
    }

    public final int hashCode() {
        return r1.a(this).hashCode();
    }

    public final String toString() {
        return "null (Kotlin reflection is not available)";
    }
}
