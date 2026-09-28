package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.user.Gender;
import com.nintendo.npf.sdk.user.Mii;
import com.nintendo.npf.sdk.user.NintendoAccount;
import com.unity.androidnotifications.UnityNotificationManager;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x3 extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a3 f619a = new a3();

    public NintendoAccount a(JSONObject jSONObject, String str) throws JSONException {
        NintendoAccount nintendoAccountFromJSON = fromJSON(jSONObject);
        if (nintendoAccountFromJSON.sessionToken == null) {
            nintendoAccountFromJSON.sessionToken = str;
        }
        return nintendoAccountFromJSON;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:59:0x0116  */
    /* JADX WARN: Code duplicated, block: B:71:0x014a  */
    @Override // com.nintendo.npf.sdk.core.l0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public NintendoAccount fromJSON(JSONObject jSONObject) throws JSONException {
        String string;
        int i;
        int i2;
        String string2;
        Mii miiFromJSON;
        String string3;
        String string4 = jSONObject.getString("accessToken");
        String string5 = l0.hasField(jSONObject, "sessionToken") ? jSONObject.getString("sessionToken") : null;
        String string6 = l0.hasField(jSONObject, "idToken") ? jSONObject.getString("idToken") : null;
        long jA = l0.hasField(jSONObject, "expiresIn") ? a() + ((long) (jSONObject.getInt("expiresIn") * 1000)) : 0L;
        JSONObject jSONObject2 = jSONObject.getJSONObject("user");
        String string7 = l0.hasField(jSONObject2, UnityNotificationManager.KEY_ID) ? jSONObject2.getString(UnityNotificationManager.KEY_ID) : null;
        NintendoAccount.Type type = NintendoAccount.Type.UNKNOWN;
        if (l0.hasField(jSONObject2, "isChild")) {
            if (jSONObject2.getBoolean("isChild")) {
                type = NintendoAccount.Type.CHILD;
            } else {
                type = NintendoAccount.Type.GENERAL;
            }
        }
        NintendoAccount.Type type2 = type;
        String string8 = l0.hasField(jSONObject2, "nickname") ? jSONObject2.getString("nickname") : null;
        Gender gender = Gender.UNKNOWN;
        if (l0.hasField(jSONObject2, "gender")) {
            String string9 = jSONObject2.getString("gender");
            if (string9.equals("male")) {
                gender = Gender.MALE;
            } else if (string9.equals("female")) {
                gender = Gender.FEMALE;
            }
        }
        Gender gender2 = gender;
        String string10 = l0.hasField(jSONObject2, "language") ? jSONObject2.getString("language") : null;
        String string11 = l0.hasField(jSONObject2, "country") ? jSONObject2.getString("country") : null;
        String string12 = l0.hasField(jSONObject2, "region") ? jSONObject2.getString("region") : null;
        if (l0.hasField(jSONObject2, "timezone")) {
            JSONObject jSONObject3 = jSONObject2.getJSONObject("timezone");
            if (l0.hasField(jSONObject3, UnityNotificationManager.KEY_ID)) {
                string = jSONObject3.getString(UnityNotificationManager.KEY_ID);
            } else {
                string = null;
            }
        } else {
            string = null;
        }
        int i3 = 0;
        if (l0.hasField(jSONObject2, "birthday")) {
            String[] strArrSplit = jSONObject2.getString("birthday").split("-");
            if (strArrSplit.length >= 3) {
                i = Integer.parseInt(strArrSplit[0]);
                i3 = Integer.parseInt(strArrSplit[1]);
                i2 = Integer.parseInt(strArrSplit[2]);
            } else {
                i = 0;
                i2 = 0;
            }
        } else {
            i = 0;
            i2 = 0;
        }
        String string13 = l0.hasField(jSONObject2, "email") ? jSONObject2.getString("email") : null;
        if (l0.hasField(jSONObject2, "links")) {
            JSONObject jSONObject4 = jSONObject2.getJSONObject("links");
            if (l0.hasField(jSONObject4, "nintendoNetwork")) {
                JSONObject jSONObject5 = jSONObject4.getJSONObject("nintendoNetwork");
                if (l0.hasField(jSONObject5, UnityNotificationManager.KEY_ID)) {
                    string2 = jSONObject5.getString(UnityNotificationManager.KEY_ID);
                } else {
                    string2 = null;
                }
            } else {
                string2 = null;
            }
        } else {
            string2 = null;
        }
        if (l0.hasField(jSONObject2, "mii")) {
            miiFromJSON = this.f619a.fromJSON(jSONObject2.getJSONObject("mii"));
        } else {
            miiFromJSON = null;
        }
        if (!l0.hasField(jSONObject2, "screenName")) {
            string3 = "";
        } else {
            string3 = jSONObject2.getString("screenName");
        }
        return new NintendoAccount(string7, type2, string8, gender2, string10, string11, string12, string, i, i3, i2, string13, string2, miiFromJSON, string3, string6, string4, string5, jA, l0.hasField(jSONObject2, "iconUri") ? jSONObject2.getString("iconUri") : null);
    }

    long a() {
        return Calendar.getInstance().getTimeInMillis();
    }

    @Override // com.nintendo.npf.sdk.core.l0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JSONObject toJSON(NintendoAccount nintendoAccount) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
