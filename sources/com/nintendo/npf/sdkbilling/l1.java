package com.nintendo.npf.sdkbilling;

import android.app.Activity;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.Purchase;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchases;
import com.nintendo.npf.sdk.infrastructure.helper.VirtualCurrencyHelper;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyPurchaseGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyBundle;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class l1 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VirtualCurrencyPurchaseGoogleRepository f970a;
    public final /* synthetic */ o1 b;
    public final /* synthetic */ VirtualCurrencyBundle c;
    public final /* synthetic */ String d;
    public final /* synthetic */ NPFBillingClient e;
    public final /* synthetic */ ProductDetails f;
    public final /* synthetic */ BaaSUser g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l1(VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository, o1 o1Var, VirtualCurrencyBundle virtualCurrencyBundle, String str, NPFBillingClient nPFBillingClient, ProductDetails productDetails, BaaSUser baaSUser) {
        super(2);
        this.f970a = virtualCurrencyPurchaseGoogleRepository;
        this.b = o1Var;
        this.c = virtualCurrencyBundle;
        this.d = str;
        this.e = nPFBillingClient;
        this.f = productDetails;
        this.g = baaSUser;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.util.Collection] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ?? EmptyList;
        List list = (List) obj;
        NPFError nPFError = (NPFError) obj2;
        if (nPFError != null) {
            this.f970a.f720a.reportError(VirtualCurrencyHelper.REPORT_EVENT_ID, "purchase#queryPurchases", nPFError);
            this.b.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), Boolean.FALSE, nPFError);
        } else {
            if (list != null) {
                VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository = this.f970a;
                ArrayList arrayList = new ArrayList();
                for (Object obj3 : list) {
                    if (virtualCurrencyPurchaseGoogleRepository.f720a.isVirtualCurrency((Purchase) obj3)) {
                        arrayList.add(obj3);
                    }
                }
                VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository2 = this.f970a;
                EmptyList = new ArrayList();
                for (Object obj4 : arrayList) {
                    VirtualCurrencyHelper virtualCurrencyHelper = virtualCurrencyPurchaseGoogleRepository2.f720a;
                    Boolean boolIsIABNonConsumable = virtualCurrencyPurchaseGoogleRepository2.c.isIABNonConsumable();
                    Intrinsics.checkNotNullExpressionValue(boolIsIABNonConsumable, "capabilities.isIABNonConsumable");
                    if (virtualCurrencyHelper.isUnprocessed((Purchase) obj4, boolIsIABNonConsumable.booleanValue())) {
                        EmptyList.add(obj4);
                    }
                }
            } else {
                EmptyList = CollectionsKt.emptyList();
            }
            if (EmptyList.isEmpty()) {
                this.f970a.e.update(this.c.getSku(), this.c.getPrice(), this.c.getPriceCode(), this.c.getCustomAttribute(), this.d);
                this.e.initiatePurchaseFlow((Activity) this.f970a.b.invoke(), this.f, new k1(this.f970a, this.b, this.g, this.e));
            } else {
                NPFError nPFErrorCreate_VirtualCurrency_UnprocessedPurchaseFound_409 = this.f970a.g.create_VirtualCurrency_UnprocessedPurchaseFound_409();
                Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_VirtualCurrency_UnprocessedPurchaseFound_409, "errorFactory.create_Virt…cessedPurchaseFound_409()");
                this.f970a.f720a.reportError(VirtualCurrencyHelper.REPORT_EVENT_ID, "purchase#purchased#AlreadyBought", nPFErrorCreate_VirtualCurrency_UnprocessedPurchaseFound_409);
                this.b.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), Boolean.FALSE, nPFErrorCreate_VirtualCurrency_UnprocessedPurchaseFound_409);
            }
        }
        return Unit.INSTANCE;
    }
}
