package com.nintendo.npf.sdk.infrastructure.repository;

import com.android.billingclient.api.ProductDetails;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.repository.SubscriptionProductRepository;
import com.nintendo.npf.sdk.infrastructure.api.SubscriptionApi;
import com.nintendo.npf.sdk.infrastructure.helper.SubscriptionHelper;
import com.nintendo.npf.sdk.internal.billing.BillingHelper;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.subscription.SubscriptionProduct;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdkbilling.d0;
import com.nintendo.npf.sdkbilling.e0;
import com.nintendo.npf.sdkbilling.i;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\t\u0010\nJ9\u0010\u0013\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2 \u0010\u0012\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00110\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/repository/SubscriptionProductGoogleRepository;", "Lcom/nintendo/npf/sdk/domain/repository/SubscriptionProductRepository;", "Lcom/nintendo/npf/sdk/infrastructure/helper/SubscriptionHelper;", "helper", "Lkotlin/Function0;", "Lcom/nintendo/npf/sdk/infrastructure/api/SubscriptionApi;", "api", "Lcom/nintendo/npf/sdk/internal/billing/NPFBillingClient;", "billingClientFactory", "<init>", "(Lcom/nintendo/npf/sdk/infrastructure/helper/SubscriptionHelper;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "account", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/subscription/SubscriptionProduct;", "Lcom/nintendo/npf/sdk/NPFError;", "", "block", "find", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Lkotlin/jvm/functions/Function2;)V", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SubscriptionProductGoogleRepository implements SubscriptionProductRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SubscriptionHelper f710a;
    public final Function0 b;
    public final Function0 c;

    public SubscriptionProductGoogleRepository(SubscriptionHelper helper, Function0<SubscriptionApi> api, Function0<NPFBillingClient> billingClientFactory) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(billingClientFactory, "billingClientFactory");
        this.f710a = helper;
        this.b = api;
        this.c = billingClientFactory;
    }

    public static final List access$mergeProductDetails(SubscriptionProductGoogleRepository subscriptionProductGoogleRepository, Map map, List list) {
        ProductDetails.PricingPhase pricingPhase;
        Object next;
        ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails;
        ProductDetails.PricingPhases pricingPhases;
        subscriptionProductGoogleRepository.getClass();
        if (list == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ProductDetails productDetails = (ProductDetails) it.next();
            SubscriptionProduct subscriptionProduct = (SubscriptionProduct) map.get(productDetails.getProductId());
            if (subscriptionProduct != null) {
                Intrinsics.checkNotNullParameter(productDetails, "<this>");
                ProductDetails.PricingPhase pricingPhaseB = i.b(productDetails);
                long priceAmountMicros = pricingPhaseB != null ? pricingPhaseB.getPriceAmountMicros() : 0L;
                Intrinsics.checkNotNullParameter(productDetails, "<this>");
                ProductDetails.PricingPhase pricingPhaseB2 = i.b(productDetails);
                String priceCurrencyCode = pricingPhaseB2 != null ? pricingPhaseB2.getPriceCurrencyCode() : null;
                String str = priceCurrencyCode == null ? "" : priceCurrencyCode;
                BigDecimal priceAmount = new BigDecimal(priceAmountMicros).movePointLeft(6);
                Intrinsics.checkNotNullExpressionValue(priceAmount, "priceAmount");
                String strCreateDisplayPrice = BillingHelper.createDisplayPrice(str, priceAmount);
                Intrinsics.checkNotNullParameter(productDetails, "<this>");
                ProductDetails.PricingPhase pricingPhaseB3 = i.b(productDetails);
                String billingPeriod = pricingPhaseB3 != null ? pricingPhaseB3.getBillingPeriod() : null;
                String str2 = billingPeriod == null ? "" : billingPeriod;
                Intrinsics.checkNotNullParameter(productDetails, "<this>");
                List<ProductDetails.SubscriptionOfferDetails> subscriptionOfferDetails2 = productDetails.getSubscriptionOfferDetails();
                List<ProductDetails.PricingPhase> pricingPhaseList = (subscriptionOfferDetails2 == null || (subscriptionOfferDetails = (ProductDetails.SubscriptionOfferDetails) CollectionsKt.firstOrNull((List) subscriptionOfferDetails2)) == null || (pricingPhases = subscriptionOfferDetails.getPricingPhases()) == null) ? null : pricingPhases.getPricingPhaseList();
                if (pricingPhaseList != null) {
                    Iterator<T> it2 = pricingPhaseList.iterator();
                    do {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                    } while (((ProductDetails.PricingPhase) next).getPriceAmountMicros() != 0);
                    pricingPhase = (ProductDetails.PricingPhase) next;
                } else {
                    pricingPhase = null;
                }
                String billingPeriod2 = pricingPhase != null ? pricingPhase.getBillingPeriod() : null;
                String str3 = billingPeriod2 == null ? "" : billingPeriod2;
                Intrinsics.checkNotNullParameter(productDetails, "<this>");
                ProductDetails.PricingPhase pricingPhaseA = i.a(productDetails);
                String billingPeriod3 = pricingPhaseA != null ? pricingPhaseA.getBillingPeriod() : null;
                Intrinsics.checkNotNullParameter(productDetails, "<this>");
                ProductDetails.PricingPhase pricingPhaseA2 = i.a(productDetails);
                int billingCycleCount = pricingPhaseA2 != null ? pricingPhaseA2.getBillingCycleCount() : 0;
                Intrinsics.checkNotNullParameter(productDetails, "<this>");
                ProductDetails.PricingPhase pricingPhaseA3 = i.a(productDetails);
                String formattedPrice = pricingPhaseA3 != null ? pricingPhaseA3.getFormattedPrice() : null;
                Intrinsics.checkNotNullParameter(productDetails, "<this>");
                ProductDetails.PricingPhase pricingPhaseA4 = i.a(productDetails);
                arrayList.add(subscriptionProduct.copy((WorkQueueKt.MASK & 1) != 0 ? subscriptionProduct.subscriptionId : null, (WorkQueueKt.MASK & 2) != 0 ? subscriptionProduct.productId : null, (WorkQueueKt.MASK & 4) != 0 ? subscriptionProduct.startsAt : 0L, (WorkQueueKt.MASK & 8) != 0 ? subscriptionProduct.endsAt : 0L, (WorkQueueKt.MASK & 16) != 0 ? subscriptionProduct.group : null, (WorkQueueKt.MASK & 32) != 0 ? subscriptionProduct.level : 0, (WorkQueueKt.MASK & 64) != 0 ? subscriptionProduct.attributes : null, (WorkQueueKt.MASK & 128) != 0 ? subscriptionProduct.subscriptionPeriod : str2, (WorkQueueKt.MASK & 256) != 0 ? subscriptionProduct.freeTrialPeriod : str3, (WorkQueueKt.MASK & 512) != 0 ? subscriptionProduct.introductoryPricePeriod : billingPeriod3, (WorkQueueKt.MASK & 1024) != 0 ? subscriptionProduct.introductoryPriceCycles : String.valueOf(billingCycleCount), (WorkQueueKt.MASK & 2048) != 0 ? subscriptionProduct.title : productDetails.getTitle(), (WorkQueueKt.MASK & 4096) != 0 ? subscriptionProduct.description : productDetails.getDescription(), (WorkQueueKt.MASK & 8192) != 0 ? subscriptionProduct.price : strCreateDisplayPrice, (WorkQueueKt.MASK & 16384) != 0 ? subscriptionProduct.priceCurrencyCode : str, (WorkQueueKt.MASK & 32768) != 0 ? subscriptionProduct.priceAmountMicros : priceAmountMicros, (WorkQueueKt.MASK & 65536) != 0 ? subscriptionProduct.introductoryPrice : formattedPrice, (WorkQueueKt.MASK & 131072) != 0 ? subscriptionProduct.introductoryPriceAmountMicros : pricingPhaseA4 != null ? pricingPhaseA4.getPriceAmountMicros() : 0L));
            }
        }
        return arrayList;
    }

    @Override // com.nintendo.npf.sdk.domain.repository.SubscriptionProductRepository
    public void find(BaaSUser account, Function2<? super List<SubscriptionProduct>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(block, "block");
        NPFBillingClient nPFBillingClient = (NPFBillingClient) this.c.invoke();
        nPFBillingClient.setup(new d0(this, nPFBillingClient, account, new e0(nPFBillingClient, block)));
    }
}
