package com.nintendo.npf.sdkbilling;

import com.android.billingclient.api.ProductDetails;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchases;
import com.nintendo.npf.sdk.infrastructure.helper.VirtualCurrencyHelper;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyPurchaseGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyBundle;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class m1 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VirtualCurrencyPurchaseGoogleRepository f973a;
    public final /* synthetic */ o1 b;
    public final /* synthetic */ NPFBillingClient c;
    public final /* synthetic */ VirtualCurrencyBundle d;
    public final /* synthetic */ String e;
    public final /* synthetic */ BaaSUser f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m1(VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository, o1 o1Var, NPFBillingClient nPFBillingClient, VirtualCurrencyBundle virtualCurrencyBundle, String str, BaaSUser baaSUser) {
        super(2);
        this.f973a = virtualCurrencyPurchaseGoogleRepository;
        this.b = o1Var;
        this.c = nPFBillingClient;
        this.d = virtualCurrencyBundle;
        this.e = str;
        this.f = baaSUser;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        List list = (List) obj;
        NPFError nPFError = (NPFError) obj2;
        if (nPFError != null) {
            this.f973a.f720a.reportError(VirtualCurrencyHelper.REPORT_EVENT_ID, "purchase#getProductDetailsList", nPFError);
            this.b.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), Boolean.FALSE, nPFError);
        } else if (list == null || list.isEmpty()) {
            NPFError nPFErrorCreate_VirtualCurrency_ProductNotAvailable_402 = this.f973a.g.create_VirtualCurrency_ProductNotAvailable_402();
            Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_VirtualCurrency_ProductNotAvailable_402, "errorFactory.create_Virt…ProductNotAvailable_402()");
            this.f973a.f720a.reportError(VirtualCurrencyHelper.REPORT_EVENT_ID, "purchase#getProductDetailsList", nPFErrorCreate_VirtualCurrency_ProductNotAvailable_402);
            this.b.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), Boolean.FALSE, nPFErrorCreate_VirtualCurrency_ProductNotAvailable_402);
        } else {
            ProductDetails productDetails = (ProductDetails) CollectionsKt.first(list);
            NPFBillingClient nPFBillingClient = this.c;
            nPFBillingClient.queryPurchases(new l1(this.f973a, this.b, this.d, this.e, nPFBillingClient, productDetails, this.f));
        }
        return Unit.INSTANCE;
    }
}
