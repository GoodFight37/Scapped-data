package com.nintendo.npf.sdk.internal.impl.cpp;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.audit.ProfanityWord;
import com.nintendo.npf.sdk.internal.impl.NativeBridgeUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ProfanityWordEventHandler implements Function2<List<ProfanityWord>, NPFError, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f858a;
    private long b;

    public ProfanityWordEventHandler() {
        this.f858a = -1L;
        this.b = -1L;
    }

    public static void checkProfanityWord(long j, long j2, byte[] bArr) {
        NPFSDK.getAuditService().checkProfanityWord(parseWordList(new String(bArr)), new ProfanityWordEventHandler(j, j2));
    }

    private static native void onRetrieveCallback(long j, long j2, String str, String str2);

    public static List<ProfanityWord> parseWordList(String str) {
        ProfanityWord.ProfanityDictionaryType profanityDictionaryType;
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("language");
                String string2 = jSONObject.getString("text");
                if (jSONObject.has("dictionaryType")) {
                    String string3 = jSONObject.getString("dictionaryType");
                    if (string3.equals("nickname")) {
                        profanityDictionaryType = ProfanityWord.ProfanityDictionaryType.NICKNAME;
                    } else if (string3.equals("common")) {
                        profanityDictionaryType = ProfanityWord.ProfanityDictionaryType.COMMON;
                    }
                    arrayList.add(new ProfanityWord(string, string2, profanityDictionaryType));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(List<ProfanityWord> list, NPFError nPFError) {
        String str;
        String string;
        String str2;
        String string2 = null;
        if (list != null) {
            try {
                string = NativeBridgeUtil.toJsonFromWordList(list).toString();
            } catch (JSONException e) {
                e = e;
                str = null;
                e.printStackTrace();
                str2 = str;
                onRetrieveCallback(this.f858a, this.b, str2, string2);
                return Unit.INSTANCE;
            }
        } else {
            string = null;
        }
        if (nPFError != null) {
            try {
                string2 = NativeBridgeUtil.toJsonFromNPFError(nPFError).toString();
            } catch (JSONException e2) {
                str = string;
                e = e2;
                e.printStackTrace();
                str2 = str;
            }
        }
        str2 = string;
        onRetrieveCallback(this.f858a, this.b, str2, string2);
        return Unit.INSTANCE;
    }

    public ProfanityWordEventHandler(long j, long j2) {
        this.f858a = j;
        this.b = j2;
    }
}
