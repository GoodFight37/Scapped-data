package com.nintendo.npf.sdk.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l0 {
    public static boolean hasField(JSONObject jSONObject, String str) {
        return jSONObject.has(str) && !jSONObject.isNull(str);
    }

    protected boolean a(JSONObject jSONObject, String[] strArr) {
        for (String str : strArr) {
            if (!hasField(jSONObject, str)) {
                return false;
            }
        }
        return true;
    }

    public abstract Object fromJSON(JSONObject jSONObject);

    public List<Object> fromJSON(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object objFromJSON = fromJSON(jSONArray.getJSONObject(i));
            if (objFromJSON != null) {
                arrayList.add(objFromJSON);
            }
        }
        return arrayList;
    }

    public List<Object> fromPagedJSON(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return Collections.EMPTY_LIST;
        }
        return !hasField(jSONObject, "items") ? Collections.EMPTY_LIST : fromJSON(jSONObject.getJSONArray("items"));
    }

    public JSONArray toJSON(List<Object> list) {
        if (list == null) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            JSONObject json = toJSON(it.next());
            if (json != null) {
                jSONArray.put(json);
            }
        }
        return jSONArray;
    }

    public abstract JSONObject toJSON(Object obj);
}
