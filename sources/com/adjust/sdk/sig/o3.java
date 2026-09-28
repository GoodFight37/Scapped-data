package com.adjust.sdk.sig;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o3 {
    public static Map a(Map map) {
        if (map instanceof s1) {
            throw ((ClassCastException) i1.a((RuntimeException) new ClassCastException(map.getClass().getName().concat(" cannot be cast to kotlin.collections.MutableMap")), o3.class.getName()));
        }
        return map;
    }
}
