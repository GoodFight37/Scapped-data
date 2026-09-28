package com.nintendo.npf.sdk.core;

import android.util.Base64;
import com.nintendo.npf.sdk.user.Mii;
import com.unity.androidnotifications.UnityNotificationManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a3 extends l0 {

    private static class b extends Mii {
        private b(String str, String str2, byte[] bArr, byte[] bArr2, String str3, String str4, String str5) {
            super(str, str2, bArr, bArr2, str3, str4, str5);
        }
    }

    @Override // com.nintendo.npf.sdk.core.l0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Mii fromJSON(JSONObject jSONObject) throws JSONException {
        byte[] bArrDecode;
        byte[] bArrDecode2 = null;
        if (jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString("imageUriTemplate");
        String string2 = jSONObject.getString(UnityNotificationManager.KEY_ID);
        String string3 = jSONObject.getString("imageOrigin");
        String string4 = jSONObject.getString("etag");
        String string5 = l0.hasField(jSONObject, "favoriteColor") ? jSONObject.getString("favoriteColor") : null;
        if (l0.hasField(jSONObject, "coreData")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("coreData");
            bArrDecode = Base64.decode(jSONObject2.getString(jSONObject2.keys().next()), 0);
        } else {
            bArrDecode = null;
        }
        if (l0.hasField(jSONObject, "storeData")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("storeData");
            bArrDecode2 = Base64.decode(jSONObject3.getString(jSONObject3.keys().next()), 0);
        }
        return new b(string, string2, bArrDecode, bArrDecode2, string3, string4, string5);
    }

    @Override // com.nintendo.npf.sdk.core.l0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JSONObject toJSON(Mii mii) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
