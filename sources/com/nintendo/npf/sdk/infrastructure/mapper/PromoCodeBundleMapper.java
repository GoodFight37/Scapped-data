package com.nintendo.npf.sdk.infrastructure.mapper;

import com.nintendo.npf.sdk.core.l0;
import com.nintendo.npf.sdk.promo.PromoCodeBundle;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/mapper/PromoCodeBundleMapper;", "Lcom/nintendo/npf/sdk/core/l0;", "Lcom/nintendo/npf/sdk/promo/PromoCodeBundle;", "<init>", "()V", "Lorg/json/JSONObject;", "json", "fromJSON", "(Lorg/json/JSONObject;)Lcom/nintendo/npf/sdk/promo/PromoCodeBundle;", "Lorg/json/JSONArray;", "jsonArray", "", "fromCustomJSON", "(Lorg/json/JSONArray;)Ljava/util/List;", "item", "toJSON", "(Lcom/nintendo/npf/sdk/promo/PromoCodeBundle;)Lorg/json/JSONObject;", "Companion", "a", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PromoCodeBundleMapper extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f694a = {"sku"};

    public final List<PromoCodeBundle> fromCustomJSON(JSONArray jsonArray) throws JSONException {
        if (jsonArray == null) {
            return CollectionsKt.emptyList();
        }
        JSONArray jSONArray = new JSONArray();
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jsonArray.getJSONObject(i);
            if (l0.hasField(jSONObject, "items")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("items");
                int length2 = jSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    jSONArray.put(jSONArray2.get(i2));
                }
            }
        }
        List listFromJSON = fromJSON(jSONArray);
        Intrinsics.checkNotNullExpressionValue(listFromJSON, "fromJSON(list)");
        return listFromJSON;
    }

    @Override // com.nintendo.npf.sdk.core.l0
    public PromoCodeBundle fromJSON(JSONObject json) throws JSONException {
        if (json == null || !a(json, f694a)) {
            return null;
        }
        String sku = json.getString("sku");
        String string = l0.hasField(json, "customAttribute") ? json.getString("customAttribute") : null;
        Intrinsics.checkNotNullExpressionValue(sku, "sku");
        return new PromoCodeBundle(sku, string);
    }

    @Override // com.nintendo.npf.sdk.core.l0
    public JSONObject toJSON(PromoCodeBundle item) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
