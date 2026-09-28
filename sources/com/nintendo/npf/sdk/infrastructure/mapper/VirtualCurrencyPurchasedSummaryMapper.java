package com.nintendo.npf.sdk.infrastructure.mapper;

import com.nintendo.npf.sdk.core.l0;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyMarket;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyPurchaseSummaryBySku;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyPurchasedSummary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyPurchasedSummaryMapper;", "Lcom/nintendo/npf/sdk/core/l0;", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyPurchasedSummary;", "<init>", "()V", "Lorg/json/JSONObject;", "json", "", "", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyPurchaseSummaryBySku;", "a", "(Lorg/json/JSONObject;)Ljava/util/Map;", "fromJSON", "(Lorg/json/JSONObject;)Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyPurchasedSummary;", "item", "toJSON", "(Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyPurchasedSummary;)Lorg/json/JSONObject;", "Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyPurchaseSummaryBySkuMapper;", "Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyPurchaseSummaryBySkuMapper;", "mapper", "Companion", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrencyPurchasedSummaryMapper extends l0 {
    private static final String[] b = {"market", MapperConstants.VIRTUAL_CURRENCY_FIELD_VIRTUAL_CURRENCY_NAME, MapperConstants.VIRTUAL_CURRENCY_FIELD_LIFETIME, MapperConstants.VIRTUAL_CURRENCY_FIELD_THIS_DAY, MapperConstants.VIRTUAL_CURRENCY_FIELD_THIS_MONTH};
    private static final String[] c = {MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASED_USD, MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASED_VC};

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final VirtualCurrencyPurchaseSummaryBySkuMapper mapper = new VirtualCurrencyPurchaseSummaryBySkuMapper();

    private final Map a(JSONObject json) throws JSONException {
        if (json == null) {
            return MapsKt.emptyMap();
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = json.keys();
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            VirtualCurrencyPurchaseSummaryBySku virtualCurrencyPurchaseSummaryBySkuFromJSON = this.mapper.fromJSON(json.getJSONObject(key));
            if (virtualCurrencyPurchaseSummaryBySkuFromJSON != null) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                map.put(key, virtualCurrencyPurchaseSummaryBySkuFromJSON);
            }
        }
        return map;
    }

    @Override // com.nintendo.npf.sdk.core.l0
    public VirtualCurrencyPurchasedSummary fromJSON(JSONObject json) throws JSONException {
        if (json == null || !a(json, b)) {
            return null;
        }
        String marketString = json.getString("market");
        VirtualCurrencyMarket.Companion companion = VirtualCurrencyMarket.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(marketString, "marketString");
        String upperCase = marketString.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        VirtualCurrencyMarket virtualCurrencyMarketFromValue = companion.fromValue(upperCase);
        if (virtualCurrencyMarketFromValue == null) {
            return null;
        }
        String virtualCurrencyName = json.getString(MapperConstants.VIRTUAL_CURRENCY_FIELD_VIRTUAL_CURRENCY_NAME);
        JSONObject jSONObject = json.getJSONObject(MapperConstants.VIRTUAL_CURRENCY_FIELD_LIFETIME);
        JSONObject jSONObject2 = json.getJSONObject(MapperConstants.VIRTUAL_CURRENCY_FIELD_THIS_DAY);
        JSONObject jSONObject3 = json.getJSONObject(MapperConstants.VIRTUAL_CURRENCY_FIELD_THIS_MONTH);
        String[] strArr = c;
        if (!a(jSONObject, strArr) || !a(jSONObject2, strArr) || !a(jSONObject3, strArr)) {
            return null;
        }
        double d = jSONObject.getDouble(MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASED_USD);
        int i = jSONObject.getInt(MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASED_VC);
        double d2 = jSONObject2.getDouble(MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASED_USD);
        int i2 = jSONObject2.getInt(MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASED_VC);
        double d3 = jSONObject3.getDouble(MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASED_USD);
        int i3 = jSONObject3.getInt(MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASED_VC);
        Map mapEmptyMap = jSONObject.isNull(MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASES_BY_SKU) ? MapsKt.emptyMap() : a(jSONObject.getJSONObject(MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASES_BY_SKU));
        Map mapEmptyMap2 = jSONObject2.isNull(MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASES_BY_SKU) ? MapsKt.emptyMap() : a(jSONObject2.getJSONObject(MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASES_BY_SKU));
        Map mapEmptyMap3 = jSONObject3.isNull(MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASES_BY_SKU) ? MapsKt.emptyMap() : a(jSONObject3.getJSONObject(MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASES_BY_SKU));
        Intrinsics.checkNotNullExpressionValue(virtualCurrencyName, "virtualCurrencyName");
        return new VirtualCurrencyPurchasedSummary(virtualCurrencyMarketFromValue, virtualCurrencyName, d, i, mapEmptyMap, d2, i2, mapEmptyMap2, d3, i3, mapEmptyMap3);
    }

    @Override // com.nintendo.npf.sdk.core.l0
    public JSONObject toJSON(VirtualCurrencyPurchasedSummary item) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
