package com.nintendo.npf.sdkbilling;

import com.android.billingclient.api.Purchase;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionTransactionGoogleRepository;
import com.nintendo.npf.sdk.internal.util.PurchaseExtensionsKt;
import com.nintendo.npf.sdk.subscription.SubscriptionTransaction;
import com.nintendo.npf.sdk.subscription.SubscriptionTransactionState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubscriptionTransactionGoogleRepository f999a;
    public final /* synthetic */ z0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(SubscriptionTransactionGoogleRepository subscriptionTransactionGoogleRepository, z0 z0Var) {
        super(2);
        this.f999a = subscriptionTransactionGoogleRepository;
        this.b = z0Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        List list = (List) obj;
        NPFError nPFError = (NPFError) obj2;
        if (nPFError != null) {
            this.f999a.f716a.reportError("checkUnprocessedPurchases/queryPurchases", nPFError);
            this.b.invoke(CollectionsKt.emptyList(), nPFError);
        } else if (list == null || list.isEmpty()) {
            this.b.invoke(CollectionsKt.emptyList(), null);
        } else {
            SubscriptionTransactionGoogleRepository subscriptionTransactionGoogleRepository = this.f999a;
            ArrayList arrayList = new ArrayList();
            for (Object obj3 : list) {
                if (subscriptionTransactionGoogleRepository.f716a.isSubscription((Purchase) obj3)) {
                    arrayList.add(obj3);
                }
            }
            ArrayList<Purchase> arrayList2 = new ArrayList();
            for (Object obj4 : arrayList) {
                if (!((Purchase) obj4).isAcknowledged()) {
                    arrayList2.add(obj4);
                }
            }
            if (arrayList2.isEmpty()) {
                this.b.invoke(CollectionsKt.emptyList(), null);
            } else {
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                for (Purchase purchase : arrayList2) {
                    arrayList3.add(new SubscriptionTransaction(purchase.getOrderId(), PurchaseExtensionsKt.getSku(purchase), 1 == purchase.getPurchaseState() ? SubscriptionTransactionState.PURCHASED : SubscriptionTransactionState.PENDING));
                }
                this.b.invoke(arrayList3, null);
            }
        }
        return Unit.INSTANCE;
    }
}
