package com.nintendo.npf.sdk.infrastructure.mapper;

import com.nintendo.npf.sdk.core.l0;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyMarket;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyWallet;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyWalletMapper;", "Lcom/nintendo/npf/sdk/core/l0;", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyWallet;", "<init>", "()V", "Lorg/json/JSONObject;", "json", "fromJSON", "(Lorg/json/JSONObject;)Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyWallet;", "item", "toJSON", "(Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyWallet;)Lorg/json/JSONObject;", "Companion", "a", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrencyWalletMapper extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f705a = {"market", MapperConstants.VIRTUAL_CURRENCY_FIELD_VIRTUAL_CURRENCY_NAME, MapperConstants.VIRTUAL_CURRENCY_FIELD_BALANCE};
    private static final String[] b = {MapperConstants.VIRTUAL_CURRENCY_FIELD_TOTAL_BALANCE, MapperConstants.VIRTUAL_CURRENCY_FIELD_FREE_BALANCE, MapperConstants.VIRTUAL_CURRENCY_FIELD_PAID_BALANCE};
    private static final String[] c = {"code", MapperConstants.VIRTUAL_CURRENCY_FIELD_TOTAL_BALANCE};

    @Override // com.nintendo.npf.sdk.core.l0
    public VirtualCurrencyWallet fromJSON(JSONObject json) throws JSONException {
        if (json == null || !a(json, f705a)) {
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
        JSONObject jSONObject = json.getJSONObject(MapperConstants.VIRTUAL_CURRENCY_FIELD_BALANCE);
        if (!a(jSONObject, b)) {
            return null;
        }
        int i = jSONObject.getInt(MapperConstants.VIRTUAL_CURRENCY_FIELD_TOTAL_BALANCE);
        int i2 = jSONObject.getInt(MapperConstants.VIRTUAL_CURRENCY_FIELD_FREE_BALANCE);
        JSONArray jSONArray = jSONObject.getJSONArray(MapperConstants.VIRTUAL_CURRENCY_FIELD_PAID_BALANCE);
        HashMap map = new HashMap();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            if (a(jSONObject2, c)) {
                String paidCurrencyCode = jSONObject2.getString("code");
                Integer numValueOf = Integer.valueOf(jSONObject2.getInt(MapperConstants.VIRTUAL_CURRENCY_FIELD_TOTAL_BALANCE));
                Intrinsics.checkNotNullExpressionValue(paidCurrencyCode, "paidCurrencyCode");
                map.put(paidCurrencyCode, numValueOf);
            }
        }
        Intrinsics.checkNotNullExpressionValue(virtualCurrencyName, "virtualCurrencyName");
        return new VirtualCurrencyWallet(virtualCurrencyMarketFromValue, virtualCurrencyName, i, i2, map);
    }

    @Override // com.nintendo.npf.sdk.core.l0
    public JSONObject toJSON(VirtualCurrencyWallet item) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
