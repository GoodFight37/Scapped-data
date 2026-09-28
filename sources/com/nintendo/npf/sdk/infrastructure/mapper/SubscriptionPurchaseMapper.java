package com.nintendo.npf.sdk.infrastructure.mapper;

import com.nintendo.npf.sdk.core.l0;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.subscription.SubscriptionMarket;
import com.nintendo.npf.sdk.subscription.SubscriptionPurchase;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/mapper/SubscriptionPurchaseMapper;", "Lcom/nintendo/npf/sdk/core/l0;", "Lcom/nintendo/npf/sdk/subscription/SubscriptionPurchase;", "<init>", "()V", "Lorg/json/JSONObject;", "json", "fromJSON", "(Lorg/json/JSONObject;)Lcom/nintendo/npf/sdk/subscription/SubscriptionPurchase;", "item", "toJSON", "(Lcom/nintendo/npf/sdk/subscription/SubscriptionPurchase;)Lorg/json/JSONObject;", "Companion", "a", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SubscriptionPurchaseMapper extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f698a = {MapperConstants.SUBSCRIPTION_FIELD_SUBSCRIPTION_ID, "productId", MapperConstants.SUBSCRIPTION_FIELD_STARTS_AT, MapperConstants.SUBSCRIPTION_FIELD_ENDS_AT, "market"};

    @Override // com.nintendo.npf.sdk.core.l0
    public SubscriptionPurchase fromJSON(JSONObject json) throws JSONException {
        if (json == null || !a(json, f698a)) {
            return null;
        }
        String subscriptionId = json.getString(MapperConstants.SUBSCRIPTION_FIELD_SUBSCRIPTION_ID);
        String productId = json.getString("productId");
        long j = json.getLong(MapperConstants.SUBSCRIPTION_FIELD_STARTS_AT);
        long j2 = json.getLong(MapperConstants.SUBSCRIPTION_FIELD_ENDS_AT);
        String marketString = json.getString("market");
        SubscriptionMarket.Companion companion = SubscriptionMarket.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(marketString, "marketString");
        String upperCase = marketString.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        SubscriptionMarket subscriptionMarketFromValue = companion.fromValue(upperCase);
        if (subscriptionMarketFromValue == null) {
            return null;
        }
        boolean z = l0.hasField(json, MapperConstants.SUBSCRIPTION_FIELD_IN_FREE_TRIAL_PERIOD) ? json.getBoolean(MapperConstants.SUBSCRIPTION_FIELD_IN_FREE_TRIAL_PERIOD) : false;
        long j3 = l0.hasField(json, MapperConstants.SUBSCRIPTION_FIELD_REVOKED_AT) ? json.getLong(MapperConstants.SUBSCRIPTION_FIELD_REVOKED_AT) : 0L;
        boolean z2 = l0.hasField(json, MapperConstants.SUBSCRIPTION_FIELD_AUTO_RENEWING) ? json.getBoolean(MapperConstants.SUBSCRIPTION_FIELD_AUTO_RENEWING) : false;
        long j4 = l0.hasField(json, MapperConstants.SUBSCRIPTION_FIELD_AUTO_RENEWING_UPDATED_AT) ? json.getLong(MapperConstants.SUBSCRIPTION_FIELD_AUTO_RENEWING_UPDATED_AT) : 0L;
        Intrinsics.checkNotNullExpressionValue(subscriptionId, "subscriptionId");
        Intrinsics.checkNotNullExpressionValue(productId, "productId");
        return new SubscriptionPurchase(subscriptionId, productId, j, j2, subscriptionMarketFromValue, z, j3, z2, j4);
    }

    @Override // com.nintendo.npf.sdk.core.l0
    public JSONObject toJSON(SubscriptionPurchase item) {
        if (item == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_SUBSCRIPTION_ID, item.getSubscriptionId());
            jSONObject.put("productId", item.getProductId());
            jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_STARTS_AT, item.getStartsAt());
            jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_ENDS_AT, item.getEndsAt());
            jSONObject.put("market", item.getMarket().getValue());
            jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_IN_FREE_TRIAL_PERIOD, item.getInFreeTrialPeriod());
            jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_REVOKED_AT, item.getRevokedAt());
            jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_AUTO_RENEWING, item.getAutoRenewing());
            jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_AUTO_RENEWING_UPDATED_AT, item.getAutoRenewingUpdatedAt());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
