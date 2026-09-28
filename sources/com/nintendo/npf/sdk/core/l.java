package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.analytics.ResettableIdType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f514a = new a(null);
    private static final String[] b = {"permitted", "resettableId"};

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    /* JADX WARN: Code duplicated, block: B:61:0x00fa  */
    @Override // com.nintendo.npf.sdk.core.l0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public i fromJSON(JSONObject jSONObject) throws JSONException {
        i.b bVarA;
        Map map;
        if (jSONObject == null) {
            return null;
        }
        if (l0.hasField(jSONObject, "mode")) {
            i.b.a aVar = i.b.Companion;
            String string = jSONObject.getString("mode");
            Intrinsics.checkNotNullExpressionValue(string, "json.getString(FIELD_MODE)");
            bVarA = aVar.a(string);
        } else {
            bVarA = i.b.NONE;
        }
        i.b bVar = bVarA;
        long j = l0.hasField(jSONObject, "expirationTime") ? jSONObject.getLong("expirationTime") : 0L;
        String string2 = l0.hasField(jSONObject, "applicationId") ? jSONObject.getString("applicationId") : null;
        boolean z = l0.hasField(jSONObject, "immediateReporting") ? jSONObject.getBoolean("immediateReporting") : true;
        int i = l0.hasField(jSONObject, "reportingPeriod") ? jSONObject.getInt("reportingPeriod") : 60000;
        String string3 = l0.hasField(jSONObject, "accessToken") ? jSONObject.getString("accessToken") : null;
        String string4 = l0.hasField(jSONObject, "topic") ? jSONObject.getString("topic") : null;
        String string5 = l0.hasField(jSONObject, "country") ? jSONObject.getString("country") : null;
        String string6 = l0.hasField(jSONObject, "region") ? jSONObject.getString("region") : null;
        String string7 = l0.hasField(jSONObject, "city") ? jSONObject.getString("city") : null;
        if (l0.hasField(jSONObject, "analyticsPermissions")) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            JSONObject jSONObject2 = jSONObject.getJSONObject("analyticsPermissions");
            if (l0.hasField(jSONObject2, "internalAnalysis")) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("internalAnalysis");
                ResettableIdType resettableIdType = ResettableIdType.INTERNAL_ANALYSIS;
                s sVarA = a(jSONObject3, resettableIdType);
                if (sVarA != null) {
                    linkedHashMap.put(resettableIdType, sVarA);
                }
            }
            if (l0.hasField(jSONObject2, "targetMarketing")) {
                JSONObject jSONObject4 = jSONObject2.getJSONObject("targetMarketing");
                ResettableIdType resettableIdType2 = ResettableIdType.TARGET_MARKETING;
                s sVarA2 = a(jSONObject4, resettableIdType2);
                if (sVarA2 != null) {
                    linkedHashMap.put(resettableIdType2, sVarA2);
                }
            }
            Map map2 = MapsKt.toMap(linkedHashMap);
            if (map2.isEmpty()) {
                map = null;
            } else {
                map = map2;
            }
        } else {
            map = null;
        }
        return new i(bVar, j, string2, z, i, string3, string4, string5, string6, string7, map);
    }

    @Override // com.nintendo.npf.sdk.core.l0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JSONObject toJSON(i iVar) {
        throw new UnsupportedOperationException("Not implemented");
    }

    private final s a(JSONObject jSONObject, ResettableIdType resettableIdType) {
        if (jSONObject != null && a(jSONObject, b)) {
            return new s(resettableIdType, jSONObject.getBoolean("permitted"), jSONObject.getString("resettableId"));
        }
        return null;
    }
}
