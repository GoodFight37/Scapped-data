package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionProductGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.subscription.SubscriptionProduct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e0 f934a;
    public final /* synthetic */ NPFBillingClient b;
    public final /* synthetic */ SubscriptionProductGoogleRepository c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(e0 e0Var, NPFBillingClient nPFBillingClient, SubscriptionProductGoogleRepository subscriptionProductGoogleRepository) {
        super(2);
        this.f934a = e0Var;
        this.b = nPFBillingClient;
        this.c = subscriptionProductGoogleRepository;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        List products = (List) obj;
        NPFError nPFError = (NPFError) obj2;
        Intrinsics.checkNotNullParameter(products, "products");
        if (nPFError != null) {
            this.f934a.invoke(CollectionsKt.emptyList(), nPFError);
        } else if (products.isEmpty()) {
            this.f934a.invoke(CollectionsKt.emptyList(), null);
        } else {
            SubscriptionProductGoogleRepository subscriptionProductGoogleRepository = this.c;
            ArrayList<SubscriptionProduct> arrayList = new ArrayList();
            for (Object obj3 : products) {
                if (subscriptionProductGoogleRepository.f710a.isSubscription((SubscriptionProduct) obj3)) {
                    arrayList.add(obj3);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            for (SubscriptionProduct subscriptionProduct : arrayList) {
                arrayList2.add(TuplesKt.to(subscriptionProduct.getProductId(), subscriptionProduct));
            }
            Map map = MapsKt.toMap(arrayList2);
            this.b.getProductDetailsList(new ArrayList(map.keySet()), new a0(this.c, this.f934a, map));
        }
        return Unit.INSTANCE;
    }
}
