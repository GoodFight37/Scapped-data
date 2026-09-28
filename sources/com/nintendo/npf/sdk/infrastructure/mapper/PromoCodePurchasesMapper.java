package com.nintendo.npf.sdk.infrastructure.mapper;

import com.nintendo.npf.sdk.core.l0;
import com.nintendo.npf.sdk.domain.model.PromoCodePurchases;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/mapper/PromoCodePurchasesMapper;", "Lcom/nintendo/npf/sdk/core/l0;", "Lcom/nintendo/npf/sdk/domain/model/PromoCodePurchases;", "<init>", "()V", "Lorg/json/JSONArray;", "jsonArray", "", "expectedType", "", "a", "(Lorg/json/JSONArray;Ljava/lang/String;)Ljava/util/List;", "Lorg/json/JSONObject;", "jsonObject", "fromJSON", "(Lorg/json/JSONObject;)Lcom/nintendo/npf/sdk/domain/model/PromoCodePurchases;", "item", "toJSON", "(Lcom/nintendo/npf/sdk/domain/model/PromoCodePurchases;)Lorg/json/JSONObject;", "Companion", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PromoCodePurchasesMapper extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f695a = {"transactions"};

    private final List a(JSONArray jsonArray, String expectedType) throws JSONException {
        String string;
        if (jsonArray == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jsonArray.getJSONObject(i);
            if (l0.hasField(jSONObject, "type") && StringsKt.equals(expectedType, jSONObject.getString("type"), true) && l0.hasField(jSONObject, "extras")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("extras");
                if (l0.hasField(jSONObject2, "token") && (string = jSONObject2.getString("token")) != null) {
                    arrayList.add(string);
                }
            }
        }
        return arrayList;
    }

    @Override // com.nintendo.npf.sdk.core.l0
    public JSONObject toJSON(PromoCodePurchases item) {
        return null;
    }

    @Override // com.nintendo.npf.sdk.core.l0
    public PromoCodePurchases fromJSON(JSONObject jsonObject) throws JSONException {
        if (jsonObject != null && a(jsonObject, f695a)) {
            return new PromoCodePurchases(a(jsonObject.getJSONArray("transactions"), MapperConstants.PROMO_CODE_VALUE_TYPE_PROMOTION));
        }
        return null;
    }
}
