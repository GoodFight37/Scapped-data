package com.nintendo.npf.sdkbilling;

import com.android.billingclient.api.Purchase;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.api.SubscriptionApi;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionPurchaseGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class o0 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubscriptionPurchaseGoogleRepository f978a;
    public final /* synthetic */ r0 b;
    public final /* synthetic */ BaaSUser c;
    public final /* synthetic */ NPFBillingClient d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(SubscriptionPurchaseGoogleRepository subscriptionPurchaseGoogleRepository, NPFBillingClient nPFBillingClient, BaaSUser baaSUser, r0 r0Var) {
        super(2);
        this.f978a = subscriptionPurchaseGoogleRepository;
        this.b = r0Var;
        this.c = baaSUser;
        this.d = nPFBillingClient;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ArrayList arrayList;
        List list = (List) obj;
        NPFError nPFError = (NPFError) obj2;
        if (nPFError != null) {
            this.f978a.f712a.reportError("updatePurchases/queryPurchases", nPFError);
            this.b.invoke(CollectionsKt.emptyList(), nPFError);
        } else {
            if (list != null) {
                SubscriptionPurchaseGoogleRepository subscriptionPurchaseGoogleRepository = this.f978a;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj3 : list) {
                    if (subscriptionPurchaseGoogleRepository.f712a.isSubscription((Purchase) obj3)) {
                        arrayList2.add(obj3);
                    }
                }
                SubscriptionPurchaseGoogleRepository subscriptionPurchaseGoogleRepository2 = this.f978a;
                arrayList = new ArrayList();
                for (Object obj4 : arrayList2) {
                    if (subscriptionPurchaseGoogleRepository2.f712a.isStatePurchased((Purchase) obj4)) {
                        arrayList.add(obj4);
                    }
                }
            } else {
                arrayList = null;
            }
            ((SubscriptionApi) this.f978a.c.invoke()).updatePurchases(this.c, "GOOGLE", this.f978a.f712a.makeReceipt(arrayList), new n0(this.b, list, this.d, this.f978a));
        }
        return Unit.INSTANCE;
    }
}
