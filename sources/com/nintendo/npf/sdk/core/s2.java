package com.nintendo.npf.sdk.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s2 {
    public static boolean a(JSONObject jSONObject, String str) {
        return jSONObject.has(str) && !jSONObject.isNull(str);
    }

    public static Map a(JSONObject jSONObject) {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (a(jSONObject, next)) {
                map.put(next, jSONObject.getString(next));
            }
        }
        return map;
    }
}
