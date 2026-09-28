package com.nintendo.npf.sdk.infrastructure.mapper;

import com.nintendo.npf.sdk.core.l0;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchases;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyPurchasesMapper;", "Lcom/nintendo/npf/sdk/core/l0;", "Lcom/nintendo/npf/sdk/domain/model/VirtualCurrencyPurchases;", "<init>", "()V", "Lorg/json/JSONArray;", "jsonArray", "", "expectedType", "", "a", "(Lorg/json/JSONArray;Ljava/lang/String;)Ljava/util/List;", "Lorg/json/JSONObject;", "jsonObject", "fromJSON", "(Lorg/json/JSONObject;)Lcom/nintendo/npf/sdk/domain/model/VirtualCurrencyPurchases;", "item", "toJSON", "(Lcom/nintendo/npf/sdk/domain/model/VirtualCurrencyPurchases;)Lorg/json/JSONObject;", "", "orderIdsFromJSON", "(Lorg/json/JSONArray;)Ljava/util/Set;", "Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyWalletMapper;", "Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyWalletMapper;", "walletMapper", "Companion", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrencyPurchasesMapper extends l0 {
    private static final String[] b = {MapperConstants.VIRTUAL_CURRENCY_FIELD_WALLETS, "transactions"};

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final VirtualCurrencyWalletMapper walletMapper = new VirtualCurrencyWalletMapper();

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

    public final Set<String> orderIdsFromJSON(JSONArray jsonArray) throws JSONException {
        String string;
        if (jsonArray == null) {
            return SetsKt.emptySet();
        }
        HashSet hashSet = new HashSet();
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jsonArray.getJSONObject(i);
            if (l0.hasField(jSONObject, "extras")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("extras");
                if (l0.hasField(jSONObject2, "orderId") && (string = jSONObject2.getString("orderId")) != null) {
                    hashSet.add(string);
                }
            }
        }
        return hashSet;
    }

    @Override // com.nintendo.npf.sdk.core.l0
    public JSONObject toJSON(VirtualCurrencyPurchases item) {
        return null;
    }

    @Override // com.nintendo.npf.sdk.core.l0
    public VirtualCurrencyPurchases fromJSON(JSONObject jsonObject) throws JSONException {
        if (jsonObject == null || !a(jsonObject, b)) {
            return null;
        }
        List<Object> listFromJSON = this.walletMapper.fromJSON(jsonObject.getJSONArray(MapperConstants.VIRTUAL_CURRENCY_FIELD_WALLETS));
        Intrinsics.checkNotNullExpressionValue(listFromJSON, "walletMapper.fromJSON(js…_CURRENCY_FIELD_WALLETS))");
        return new VirtualCurrencyPurchases(listFromJSON, a(jsonObject.getJSONArray("transactions"), "purchase"));
    }
}
