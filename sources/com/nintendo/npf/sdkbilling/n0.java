package com.nintendo.npf.sdkbilling;

import com.android.billingclient.api.Purchase;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionPurchaseGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r0 f975a;
    public final /* synthetic */ List b;
    public final /* synthetic */ NPFBillingClient c;
    public final /* synthetic */ SubscriptionPurchaseGoogleRepository d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(r0 r0Var, List list, NPFBillingClient nPFBillingClient, SubscriptionPurchaseGoogleRepository subscriptionPurchaseGoogleRepository) {
        super(2);
        this.f975a = r0Var;
        this.b = list;
        this.c = nPFBillingClient;
        this.d = subscriptionPurchaseGoogleRepository;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Iterable] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ?? EmptyList;
        List list = (List) obj;
        NPFError nPFError = (NPFError) obj2;
        Intrinsics.checkNotNullParameter(list, "list");
        if (nPFError != null) {
            this.f975a.invoke(CollectionsKt.emptyList(), nPFError);
        } else {
            List list2 = this.b;
            if (list2 != null) {
                SubscriptionPurchaseGoogleRepository subscriptionPurchaseGoogleRepository = this.d;
                ArrayList arrayList = new ArrayList();
                for (Object obj3 : list2) {
                    if (subscriptionPurchaseGoogleRepository.f712a.isSubscription((Purchase) obj3)) {
                        arrayList.add(obj3);
                    }
                }
                SubscriptionPurchaseGoogleRepository subscriptionPurchaseGoogleRepository2 = this.d;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj4 : arrayList) {
                    if (subscriptionPurchaseGoogleRepository2.f712a.isStatePurchased((Purchase) obj4)) {
                        arrayList2.add(obj4);
                    }
                }
                EmptyList = new ArrayList();
                for (Object obj5 : arrayList2) {
                    if (!((Purchase) obj5).isAcknowledged()) {
                        EmptyList.add(obj5);
                    }
                }
            } else {
                EmptyList = CollectionsKt.emptyList();
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(EmptyList, 10));
            Iterator it = EmptyList.iterator();
            while (it.hasNext()) {
                arrayList3.add(((Purchase) it.next()).getPurchaseToken());
            }
            if (arrayList3.isEmpty()) {
                this.f975a.invoke(list, null);
            } else {
                this.c.acknowledgePurchases(arrayList3, new m0(this.d, arrayList3, this.f975a, list));
            }
        }
        return Unit.INSTANCE;
    }
}
