package com.nintendo.npf.sdk.infrastructure.mapper;

import com.nintendo.npf.sdk.core.l0;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.internal.billing.BillingHelper;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyBundle;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyBundleMapper;", "Lcom/nintendo/npf/sdk/core/l0;", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyBundle;", "<init>", "()V", "Lorg/json/JSONObject;", "json", "fromJSON", "(Lorg/json/JSONObject;)Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyBundle;", "item", "toJSON", "(Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyBundle;)Lorg/json/JSONObject;", "Lorg/json/JSONArray;", "jsonArray", "", "fromCustomJSON", "(Lorg/json/JSONArray;)Ljava/util/List;", "Companion", "a", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrencyBundleMapper extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f700a = {"sku", MapperConstants.VIRTUAL_CURRENCY_FIELD_USD_PRICE, MapperConstants.VIRTUAL_CURRENCY_FIELD_VIRTUAL_CURRENCY_NAME, MapperConstants.VIRTUAL_CURRENCY_FIELD_AMOUNT, MapperConstants.VIRTUAL_CURRENCY_FIELD_EXTRA_AMOUNT};

    public final List<VirtualCurrencyBundle> fromCustomJSON(JSONArray jsonArray) throws JSONException {
        if (jsonArray == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            JSONArray jSONArray = jsonArray.getJSONObject(i).getJSONArray("items");
            int length2 = jSONArray.length();
            for (int i2 = 0; i2 < length2; i2++) {
                VirtualCurrencyBundle virtualCurrencyBundleFromJSON = fromJSON(jSONArray.getJSONObject(i2));
                if (virtualCurrencyBundleFromJSON != null) {
                    arrayList.add(virtualCurrencyBundleFromJSON);
                }
            }
        }
        return arrayList;
    }

    @Override // com.nintendo.npf.sdk.core.l0
    public VirtualCurrencyBundle fromJSON(JSONObject json) throws JSONException {
        String strCreateDisplayPrice = null;
        if (json == null || !a(json, f700a)) {
            return null;
        }
        String sku = json.getString("sku");
        String virtualCurrencyName = json.getString(MapperConstants.VIRTUAL_CURRENCY_FIELD_VIRTUAL_CURRENCY_NAME);
        int i = json.getInt(MapperConstants.VIRTUAL_CURRENCY_FIELD_AMOUNT);
        int i2 = json.getInt(MapperConstants.VIRTUAL_CURRENCY_FIELD_EXTRA_AMOUNT);
        try {
            BigDecimal bigDecimal = new BigDecimal(json.getString(MapperConstants.VIRTUAL_CURRENCY_FIELD_USD_PRICE));
            String string = l0.hasField(json, "title") ? json.getString("title") : null;
            String string2 = l0.hasField(json, MapperConstants.VIRTUAL_CURRENCY_FIELD_DETAIL) ? json.getString(MapperConstants.VIRTUAL_CURRENCY_FIELD_DETAIL) : null;
            String string3 = l0.hasField(json, MapperConstants.VIRTUAL_CURRENCY_FIELD_PRICE_CODE) ? json.getString(MapperConstants.VIRTUAL_CURRENCY_FIELD_PRICE_CODE) : null;
            String string4 = l0.hasField(json, "customAttribute") ? json.getString("customAttribute") : null;
            try {
                BigDecimal bigDecimal2 = l0.hasField(json, "price") ? new BigDecimal(json.getString("price")) : null;
                if (string3 != null && bigDecimal2 != null) {
                    strCreateDisplayPrice = BillingHelper.createDisplayPrice(string3, bigDecimal2);
                }
                Intrinsics.checkNotNullExpressionValue(virtualCurrencyName, "virtualCurrencyName");
                Intrinsics.checkNotNullExpressionValue(sku, "sku");
                return new VirtualCurrencyBundle(virtualCurrencyName, sku, bigDecimal, i, i2, bigDecimal2, string3, strCreateDisplayPrice, string, string2, string4);
            } catch (NumberFormatException e) {
                throw new JSONException(e.getMessage());
            }
        } catch (NumberFormatException e2) {
            throw new JSONException(e2.getMessage());
        }
    }

    @Override // com.nintendo.npf.sdk.core.l0
    public JSONObject toJSON(VirtualCurrencyBundle item) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
