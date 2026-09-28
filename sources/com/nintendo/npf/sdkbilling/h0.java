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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubscriptionPurchaseGoogleRepository f955a;
    public final /* synthetic */ l0 b;
    public final /* synthetic */ BaaSUser c;
    public final /* synthetic */ NPFBillingClient d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(SubscriptionPurchaseGoogleRepository subscriptionPurchaseGoogleRepository, l0 l0Var, BaaSUser baaSUser, NPFBillingClient nPFBillingClient) {
        super(2);
        this.f955a = subscriptionPurchaseGoogleRepository;
        this.b = l0Var;
        this.c = baaSUser;
        this.d = nPFBillingClient;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.util.List] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ?? EmptyList;
        ArrayList arrayList;
        List list = (List) obj;
        NPFError nPFError = (NPFError) obj2;
        if (nPFError != null) {
            this.f955a.f712a.reportError("purchase/initiatePurchaseFlow", nPFError);
            this.b.invoke(nPFError);
        } else {
            if (list != null) {
                SubscriptionPurchaseGoogleRepository subscriptionPurchaseGoogleRepository = this.f955a;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj3 : list) {
                    if (subscriptionPurchaseGoogleRepository.f712a.isSubscription((Purchase) obj3)) {
                        arrayList2.add(obj3);
                    }
                }
                SubscriptionPurchaseGoogleRepository subscriptionPurchaseGoogleRepository2 = this.f955a;
                ArrayList arrayList3 = new ArrayList();
                for (Object obj4 : arrayList2) {
                    if (subscriptionPurchaseGoogleRepository2.f712a.isStatePurchased((Purchase) obj4)) {
                        arrayList3.add(obj4);
                    }
                }
                EmptyList = new ArrayList();
                for (Object obj5 : arrayList3) {
                    if (!((Purchase) obj5).isAcknowledged()) {
                        EmptyList.add(obj5);
                    }
                }
            } else {
                EmptyList = CollectionsKt.emptyList();
            }
            if (EmptyList.isEmpty()) {
                NPFError nPFErrorCreate_Subscription_NoPurchaseFound_1010 = this.f955a.e.create_Subscription_NoPurchaseFound_1010();
                Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_Subscription_NoPurchaseFound_1010, "errorFactory.create_Subs…on_NoPurchaseFound_1010()");
                this.f955a.f712a.reportError("purchase/initiatePurchaseFlow", nPFErrorCreate_Subscription_NoPurchaseFound_1010);
                this.b.invoke(nPFErrorCreate_Subscription_NoPurchaseFound_1010);
            } else {
                if (list != null) {
                    SubscriptionPurchaseGoogleRepository subscriptionPurchaseGoogleRepository3 = this.f955a;
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj6 : list) {
                        if (subscriptionPurchaseGoogleRepository3.f712a.isSubscription((Purchase) obj6)) {
                            arrayList4.add(obj6);
                        }
                    }
                    SubscriptionPurchaseGoogleRepository subscriptionPurchaseGoogleRepository4 = this.f955a;
                    arrayList = new ArrayList();
                    for (Object obj7 : arrayList4) {
                        if (subscriptionPurchaseGoogleRepository4.f712a.isStatePurchased((Purchase) obj7)) {
                            arrayList.add(obj7);
                        }
                    }
                } else {
                    arrayList = null;
                }
                ((SubscriptionApi) this.f955a.c.invoke()).createPurchases(this.c, "GOOGLE", this.f955a.f712a.makeReceipt(arrayList), new g0(this.b, EmptyList, this.d, this.f955a));
            }
        }
        return Unit.INSTANCE;
    }
}
