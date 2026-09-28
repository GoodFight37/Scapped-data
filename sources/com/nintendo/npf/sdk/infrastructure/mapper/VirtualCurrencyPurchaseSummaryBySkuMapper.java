package com.nintendo.npf.sdk.infrastructure.mapper;

import com.nintendo.npf.sdk.core.l0;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyPurchaseSummaryBySku;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyPurchaseSummaryBySkuMapper;", "Lcom/nintendo/npf/sdk/core/l0;", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyPurchaseSummaryBySku;", "<init>", "()V", "Lorg/json/JSONObject;", "json", "fromJSON", "(Lorg/json/JSONObject;)Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyPurchaseSummaryBySku;", "item", "toJSON", "(Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyPurchaseSummaryBySku;)Lorg/json/JSONObject;", "Companion", "a", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrencyPurchaseSummaryBySkuMapper extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f702a = {"sku", MapperConstants.VIRTUAL_CURRENCY_FIELD_COUNT, MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASED_VC, MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASED_USD};

    @Override // com.nintendo.npf.sdk.core.l0
    public VirtualCurrencyPurchaseSummaryBySku fromJSON(JSONObject json) throws JSONException {
        if (json == null || !a(json, f702a)) {
            return null;
        }
        String sku = json.getString("sku");
        int i = json.getInt(MapperConstants.VIRTUAL_CURRENCY_FIELD_COUNT);
        int i2 = json.getInt(MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASED_VC);
        double d = json.getDouble(MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASED_USD);
        Intrinsics.checkNotNullExpressionValue(sku, "sku");
        return new VirtualCurrencyPurchaseSummaryBySku(sku, i, i2, d);
    }

    @Override // com.nintendo.npf.sdk.core.l0
    public JSONObject toJSON(VirtualCurrencyPurchaseSummaryBySku item) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
