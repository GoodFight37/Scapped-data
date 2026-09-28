package com.nintendo.npf.sdkbilling;

import com.android.billingclient.api.ProductDetails;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {
    public static final ProductDetails.PricingPhase a(ProductDetails productDetails) {
        ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails;
        ProductDetails.PricingPhases pricingPhases;
        List<ProductDetails.SubscriptionOfferDetails> subscriptionOfferDetails2 = productDetails.getSubscriptionOfferDetails();
        Object obj = null;
        List<ProductDetails.PricingPhase> pricingPhaseList = (subscriptionOfferDetails2 == null || (subscriptionOfferDetails = (ProductDetails.SubscriptionOfferDetails) CollectionsKt.firstOrNull((List) subscriptionOfferDetails2)) == null || (pricingPhases = subscriptionOfferDetails.getPricingPhases()) == null) ? null : pricingPhases.getPricingPhaseList();
        if (pricingPhaseList == null) {
            return null;
        }
        for (Object obj2 : pricingPhaseList) {
            ProductDetails.PricingPhase pricingPhase = (ProductDetails.PricingPhase) obj2;
            if (pricingPhase.getPriceAmountMicros() > 0 && pricingPhase.getRecurrenceMode() == 2) {
                obj = obj2;
                break;
            }
        }
        return (ProductDetails.PricingPhase) obj;
    }

    public static final ProductDetails.PricingPhase b(ProductDetails productDetails) {
        ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails;
        ProductDetails.PricingPhases pricingPhases;
        List<ProductDetails.SubscriptionOfferDetails> subscriptionOfferDetails2 = productDetails.getSubscriptionOfferDetails();
        Object obj = null;
        List<ProductDetails.PricingPhase> pricingPhaseList = (subscriptionOfferDetails2 == null || (subscriptionOfferDetails = (ProductDetails.SubscriptionOfferDetails) CollectionsKt.firstOrNull((List) subscriptionOfferDetails2)) == null || (pricingPhases = subscriptionOfferDetails.getPricingPhases()) == null) ? null : pricingPhases.getPricingPhaseList();
        if (pricingPhaseList == null) {
            return null;
        }
        for (Object obj2 : pricingPhaseList) {
            if (((ProductDetails.PricingPhase) obj2).getRecurrenceMode() == 1) {
                obj = obj2;
                break;
            }
        }
        ProductDetails.PricingPhase pricingPhase = (ProductDetails.PricingPhase) obj;
        return pricingPhase == null ? (ProductDetails.PricingPhase) CollectionsKt.lastOrNull((List) pricingPhaseList) : pricingPhase;
    }
}
