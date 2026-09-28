package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.audit.ProfanityWord;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class f4 extends l0 {
    @Override // com.nintendo.npf.sdk.core.l0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ProfanityWord fromJSON(JSONObject jSONObject) throws JSONException {
        ProfanityWord.ProfanityDictionaryType profanityDictionaryType;
        if (jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString("language");
        String string2 = jSONObject.getString("text");
        if (jSONObject.has("dictionaryType")) {
            String string3 = jSONObject.getString("dictionaryType");
            if (string3.equals("nickname")) {
                profanityDictionaryType = ProfanityWord.ProfanityDictionaryType.NICKNAME;
            } else if (string3.equals("common")) {
                profanityDictionaryType = ProfanityWord.ProfanityDictionaryType.COMMON;
            }
            return new ProfanityWord(string, string2, profanityDictionaryType, jSONObject.getBoolean("valid") ? ProfanityWord.ProfanityCheckStatus.VALID : ProfanityWord.ProfanityCheckStatus.INVALID);
        }
        return null;
    }

    @Override // com.nintendo.npf.sdk.core.l0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JSONObject toJSON(ProfanityWord profanityWord) {
        if (profanityWord == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("language", profanityWord.getLanguage());
            jSONObject.put("text", profanityWord.getText());
            if (profanityWord.getDictionaryType() == ProfanityWord.ProfanityDictionaryType.NICKNAME) {
                jSONObject.put("dictionaryType", "nickname");
                return jSONObject;
            }
            if (profanityWord.getDictionaryType() == ProfanityWord.ProfanityDictionaryType.COMMON) {
                jSONObject.put("dictionaryType", "common");
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
