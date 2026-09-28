package com.nintendo.npf.sdk.infrastructure.mapper;

import com.nintendo.npf.sdk.core.l0;
import com.nintendo.npf.sdk.core.s2;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.subscription.SubscriptionProduct;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/mapper/SubscriptionProductMapper;", "Lcom/nintendo/npf/sdk/core/l0;", "Lcom/nintendo/npf/sdk/subscription/SubscriptionProduct;", "", "isPurchaseMock", "<init>", "(Z)V", "Lorg/json/JSONObject;", "json", "fromJSON", "(Lorg/json/JSONObject;)Lcom/nintendo/npf/sdk/subscription/SubscriptionProduct;", "item", "toJSON", "(Lcom/nintendo/npf/sdk/subscription/SubscriptionProduct;)Lorg/json/JSONObject;", "a", "Z", "Companion", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SubscriptionProductMapper extends l0 {
    private static final String[] b = {MapperConstants.SUBSCRIPTION_FIELD_SUBSCRIPTION_ID, "productId", MapperConstants.SUBSCRIPTION_FIELD_STARTS_AT, MapperConstants.SUBSCRIPTION_FIELD_ENDS_AT};

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isPurchaseMock;

    public SubscriptionProductMapper(boolean z) {
        this.isPurchaseMock = z;
    }

    @Override // com.nintendo.npf.sdk.core.l0
    public SubscriptionProduct fromJSON(JSONObject json) throws JSONException {
        Map mapA;
        String str;
        String str2;
        String str3;
        String str4;
        if (json == null || !a(json, b)) {
            return null;
        }
        String subscriptionId = json.getString(MapperConstants.SUBSCRIPTION_FIELD_SUBSCRIPTION_ID);
        String productId = json.getString("productId");
        long j = json.getLong(MapperConstants.SUBSCRIPTION_FIELD_STARTS_AT);
        long j2 = json.getLong(MapperConstants.SUBSCRIPTION_FIELD_ENDS_AT);
        String string = l0.hasField(json, MapperConstants.SUBSCRIPTION_FIELD_GROUP) ? json.getString(MapperConstants.SUBSCRIPTION_FIELD_GROUP) : null;
        int i = l0.hasField(json, "level") ? json.getInt("level") : 0;
        if (l0.hasField(json, MapperConstants.SUBSCRIPTION_FIELD_ATTRIBUTES)) {
            mapA = s2.a(json.getJSONObject(MapperConstants.SUBSCRIPTION_FIELD_ATTRIBUTES));
            if (this.isPurchaseMock) {
                String str5 = mapA.containsKey(MapperConstants.SUBSCRIPTION_FIELD_ATTRIBUTES_PERIOD) ? (String) mapA.get(MapperConstants.SUBSCRIPTION_FIELD_ATTRIBUTES_PERIOD) : null;
                String str6 = mapA.containsKey("freeTrialPeriod") ? (String) mapA.get("freeTrialPeriod") : null;
                str3 = mapA.containsKey(MapperConstants.SUBSCRIPTION_FIELD_ATTRIBUTES_INTRODUCTORY_OFFER_PERIOD) ? (String) mapA.get(MapperConstants.SUBSCRIPTION_FIELD_ATTRIBUTES_INTRODUCTORY_OFFER_PERIOD) : null;
                str4 = mapA.containsKey(MapperConstants.SUBSCRIPTION_FIELD_ATTRIBUTES_INTRODUCTORY_OFFER_CYCLES) ? (String) mapA.get(MapperConstants.SUBSCRIPTION_FIELD_ATTRIBUTES_INTRODUCTORY_OFFER_CYCLES) : null;
                str2 = str6;
                str = str5;
            }
            Intrinsics.checkNotNullExpressionValue(subscriptionId, "subscriptionId");
            Intrinsics.checkNotNullExpressionValue(productId, "productId");
            return new SubscriptionProduct(subscriptionId, productId, j, j2, string, i, mapA, str, str2, str3, str4, null, null, null, null, 0L, null, 0L);
        }
        mapA = null;
        str = null;
        str2 = null;
        str3 = null;
        str4 = null;
        Intrinsics.checkNotNullExpressionValue(subscriptionId, "subscriptionId");
        Intrinsics.checkNotNullExpressionValue(productId, "productId");
        return new SubscriptionProduct(subscriptionId, productId, j, j2, string, i, mapA, str, str2, str3, str4, null, null, null, null, 0L, null, 0L);
    }

    @Override // com.nintendo.npf.sdk.core.l0
    public JSONObject toJSON(SubscriptionProduct item) {
        if (item == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_SUBSCRIPTION_ID, item.getSubscriptionId());
            jSONObject.put("productId", item.getProductId());
            jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_GROUP, item.getGroup());
            jSONObject.put("level", item.getLevel());
            jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_STARTS_AT, item.getStartsAt());
            jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_ENDS_AT, item.getEndsAt());
            if (item.getAttributes() != null) {
                jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_ATTRIBUTES, new JSONObject(item.getAttributes()));
            }
            jSONObject.put("title", item.getTitle());
            jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_DESCRIPTION, item.getDescription());
            jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_SUBSCRIPTION_PERIOD, item.getSubscriptionPeriod());
            jSONObject.put("price", item.getPrice());
            jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_PRICE_CURRENCY_CODE, item.getPriceCurrencyCode());
            jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_PRICE_AMOUNT_MICROS, item.getPriceAmountMicros());
            jSONObject.put("freeTrialPeriod", item.getFreeTrialPeriod());
            jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_INTRODUCTORY_PRICE_PERIOD, item.getIntroductoryPricePeriod());
            jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_INTRODUCTORY_PRICE_CYCLES, item.getIntroductoryPriceCycles());
            jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_INTRODUCTORY_PRICE, item.getIntroductoryPrice());
            jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_INTRODUCTORY_PRICE_AMOUNT_MICROS, item.getIntroductoryPriceAmountMicros());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
