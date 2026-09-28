package com.nintendo.npf.sdk.infrastructure.repository;

import com.android.billingclient.api.ProductDetails;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.repository.VirtualCurrencyBundleRepository;
import com.nintendo.npf.sdk.infrastructure.api.VirtualCurrencyApi;
import com.nintendo.npf.sdk.infrastructure.helper.VirtualCurrencyHelper;
import com.nintendo.npf.sdk.internal.billing.BillingHelper;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyBundle;
import com.nintendo.npf.sdkbilling.c1;
import com.nintendo.npf.sdkbilling.d1;
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

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\t\u0010\nJ9\u0010\u0013\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2 \u0010\u0012\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00110\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/repository/VirtualCurrencyBundleGoogleRepository;", "Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyBundleRepository;", "Lcom/nintendo/npf/sdk/infrastructure/helper/VirtualCurrencyHelper;", "helper", "Lkotlin/Function0;", "Lcom/nintendo/npf/sdk/infrastructure/api/VirtualCurrencyApi;", "api", "Lcom/nintendo/npf/sdk/internal/billing/NPFBillingClient;", "billingClientFactory", "<init>", "(Lcom/nintendo/npf/sdk/infrastructure/helper/VirtualCurrencyHelper;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "account", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyBundle;", "Lcom/nintendo/npf/sdk/NPFError;", "", "block", "find", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Lkotlin/jvm/functions/Function2;)V", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrencyBundleGoogleRepository implements VirtualCurrencyBundleRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VirtualCurrencyHelper f717a;
    public final Function0 b;
    public final Function0 c;

    public VirtualCurrencyBundleGoogleRepository(VirtualCurrencyHelper helper, Function0<VirtualCurrencyApi> api, Function0<NPFBillingClient> billingClientFactory) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(billingClientFactory, "billingClientFactory");
        this.f717a = helper;
        this.b = api;
        this.c = billingClientFactory;
    }

    public static final List access$mergeProductDetails(VirtualCurrencyBundleGoogleRepository virtualCurrencyBundleGoogleRepository, Map map, List list) {
        virtualCurrencyBundleGoogleRepository.getClass();
        if (list == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ProductDetails productDetails = (ProductDetails) it.next();
            VirtualCurrencyBundle virtualCurrencyBundle = (VirtualCurrencyBundle) map.get(productDetails.getProductId());
            if (virtualCurrencyBundle != null) {
                Intrinsics.checkNotNullParameter(productDetails, "<this>");
                ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails = productDetails.getOneTimePurchaseOfferDetails();
                long priceAmountMicros = oneTimePurchaseOfferDetails != null ? oneTimePurchaseOfferDetails.getPriceAmountMicros() : 0L;
                Intrinsics.checkNotNullParameter(productDetails, "<this>");
                ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails2 = productDetails.getOneTimePurchaseOfferDetails();
                String priceCurrencyCode = oneTimePurchaseOfferDetails2 != null ? oneTimePurchaseOfferDetails2.getPriceCurrencyCode() : null;
                if (priceCurrencyCode == null) {
                    priceCurrencyCode = "";
                }
                String str = priceCurrencyCode;
                BigDecimal price = new BigDecimal(priceAmountMicros).movePointLeft(6);
                Intrinsics.checkNotNullExpressionValue(price, "price");
                arrayList.add(virtualCurrencyBundle.copy((1055 & 1) != 0 ? virtualCurrencyBundle.virtualCurrencyName : null, (1055 & 2) != 0 ? virtualCurrencyBundle.sku : null, (1055 & 4) != 0 ? virtualCurrencyBundle.usdPrice : null, (1055 & 8) != 0 ? virtualCurrencyBundle.amount : 0, (1055 & 16) != 0 ? virtualCurrencyBundle.extraAmount : 0, (1055 & 32) != 0 ? virtualCurrencyBundle.price : price, (1055 & 64) != 0 ? virtualCurrencyBundle.priceCode : str, (1055 & 128) != 0 ? virtualCurrencyBundle.displayPrice : BillingHelper.createDisplayPrice(str, price), (1055 & 256) != 0 ? virtualCurrencyBundle.title : productDetails.getTitle(), (1055 & 512) != 0 ? virtualCurrencyBundle.detail : productDetails.getDescription(), (1055 & 1024) != 0 ? virtualCurrencyBundle.customAttribute : null));
            }
        }
        return arrayList;
    }

    @Override // com.nintendo.npf.sdk.domain.repository.VirtualCurrencyBundleRepository
    public void find(BaaSUser account, Function2<? super List<VirtualCurrencyBundle>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(block, "block");
        NPFBillingClient nPFBillingClient = (NPFBillingClient) this.c.invoke();
        nPFBillingClient.setup(new c1(this, new d1(nPFBillingClient, block), account, nPFBillingClient));
    }
}
