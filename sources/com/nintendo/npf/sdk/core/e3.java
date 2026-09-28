package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.mynintendo.MissionStatus;
import com.unity.androidnotifications.UnityNotificationManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e3 extends l0 {

    private static class b extends MissionStatus {
        private b(String str, String str2, String str3, String str4, int i, boolean z, Integer num, int i2, Integer num2, boolean z2, Long l, Map map) {
            super(str, str2, str3, str4, i, z, num, i2, num2, z2, l, map);
        }
    }

    @Override // com.nintendo.npf.sdk.core.l0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public MissionStatus fromJSON(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("mission");
        String str = UnityNotificationManager.KEY_ID;
        String string = jSONObject2.getString(UnityNotificationManager.KEY_ID);
        String string2 = jSONObject2.getString("key");
        String string3 = jSONObject2.getString("title");
        String string4 = jSONObject2.getString(MapperConstants.SUBSCRIPTION_FIELD_DESCRIPTION);
        JSONObject jSONObject3 = jSONObject2.getJSONObject("points");
        int i = jSONObject3.getInt(jSONObject3.keys().next());
        boolean zEquals = jSONObject.getString(MapperConstants.SUBSCRIPTION_FIELD_STATE).equals("completed");
        int i2 = jSONObject.getInt("numberOfCompletions");
        int i3 = jSONObject2.getInt("totalSteps");
        int i4 = jSONObject.getInt("currentSteps");
        boolean z = jSONObject.getBoolean("limited");
        long j = (z && l0.hasField(jSONObject, "limitEndsAt")) ? jSONObject.getLong("limitEndsAt") : 0L;
        JSONArray jSONArray = jSONObject.getJSONArray("gifts");
        HashMap map = new HashMap();
        int i5 = 0;
        while (i5 < jSONArray.length()) {
            JSONObject jSONObject4 = jSONArray.getJSONObject(i5);
            map.put(jSONObject4.getString(str), Long.valueOf(jSONObject4.getLong("expiresAt")));
            i5++;
            jSONArray = jSONArray;
            str = str;
        }
        return new b(string, string2, string3, string4, i, zEquals, Integer.valueOf(i2), i3, Integer.valueOf(i4), z, Long.valueOf(j), map);
    }

    @Override // com.nintendo.npf.sdk.core.l0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JSONObject toJSON(MissionStatus missionStatus) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
