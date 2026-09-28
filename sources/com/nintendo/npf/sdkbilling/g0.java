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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l0 f951a;
    public final /* synthetic */ List b;
    public final /* synthetic */ NPFBillingClient c;
    public final /* synthetic */ SubscriptionPurchaseGoogleRepository d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(l0 l0Var, List list, NPFBillingClient nPFBillingClient, SubscriptionPurchaseGoogleRepository subscriptionPurchaseGoogleRepository) {
        super(1);
        this.f951a = l0Var;
        this.b = list;
        this.c = nPFBillingClient;
        this.d = subscriptionPurchaseGoogleRepository;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        NPFError nPFError = (NPFError) obj;
        if (nPFError != null) {
            this.f951a.invoke(nPFError);
        } else {
            List list = this.b;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((Purchase) it.next()).getPurchaseToken());
            }
            this.c.acknowledgePurchases(arrayList, new f0(this.d, arrayList, this.f951a));
        }
        return Unit.INSTANCE;
    }
}
