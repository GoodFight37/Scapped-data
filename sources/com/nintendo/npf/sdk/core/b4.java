package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.user.Mii;
import com.nintendo.npf.sdk.user.OtherUser;
import com.unity.androidnotifications.UnityNotificationManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b4 extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a3 f419a = new a3();

    private static class b extends OtherUser {
        private b(String str, String str2, String str3, Mii mii) {
            super(str, str2, str3, mii);
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0072  */
    @Override // com.nintendo.npf.sdk.core.l0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public OtherUser fromJSON(JSONObject jSONObject) throws JSONException {
        String str;
        Mii mii;
        Mii miiFromJSON = null;
        if (jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString(UnityNotificationManager.KEY_ID);
        String string2 = (!l0.hasField(jSONObject, "nickname") || jSONObject.getString("nickname").length() <= 0) ? null : jSONObject.getString("nickname");
        JSONObject jSONObject2 = jSONObject.getJSONObject("links");
        if (l0.hasField(jSONObject2, "nintendoAccount")) {
            JSONObject jSONObject3 = jSONObject2.getJSONObject("nintendoAccount");
            if (!jSONObject3.has("userinfo") || jSONObject3.isNull("userinfo")) {
                str = null;
                mii = null;
            } else {
                JSONObject jSONObject4 = jSONObject3.getJSONObject("userinfo");
                String string3 = (!l0.hasField(jSONObject4, "nickname") || jSONObject4.getString("nickname").length() <= 0) ? null : jSONObject4.getString("nickname");
                if (l0.hasField(jSONObject4, "mii")) {
                    miiFromJSON = this.f419a.fromJSON(jSONObject4.getJSONObject("mii"));
                }
                mii = miiFromJSON;
                str = string3;
            }
        } else {
            str = null;
            mii = null;
        }
        return new b(string, string2, str, mii);
    }

    @Override // com.nintendo.npf.sdk.core.l0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JSONObject toJSON(OtherUser otherUser) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
