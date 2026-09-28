package com.nintendo.npf.sdkbilling;

import com.android.billingclient.api.Purchase;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.api.SubscriptionApi;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionReplacementGoogleRepository;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class s0 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubscriptionReplacementGoogleRepository f989a;
    public final /* synthetic */ v0 b;
    public final /* synthetic */ BaaSUser c;
    public final /* synthetic */ String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(SubscriptionReplacementGoogleRepository subscriptionReplacementGoogleRepository, v0 v0Var, BaaSUser baaSUser, String str) {
        super(2);
        this.f989a = subscriptionReplacementGoogleRepository;
        this.b = v0Var;
        this.c = baaSUser;
        this.d = str;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        List list = (List) obj;
        NPFError nPFError = (NPFError) obj2;
        ArrayList arrayList = null;
        if (nPFError != null) {
            this.f989a.f714a.reportError("purchase/queryPurchases", nPFError);
            this.b.invoke(null, nPFError);
        } else {
            if (list != null) {
                SubscriptionReplacementGoogleRepository subscriptionReplacementGoogleRepository = this.f989a;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj3 : list) {
                    if (subscriptionReplacementGoogleRepository.f714a.isSubscription((Purchase) obj3)) {
                        arrayList2.add(obj3);
                    }
                }
                SubscriptionReplacementGoogleRepository subscriptionReplacementGoogleRepository2 = this.f989a;
                ArrayList arrayList3 = new ArrayList();
                for (Object obj4 : arrayList2) {
                    if (subscriptionReplacementGoogleRepository2.f714a.isStatePurchased((Purchase) obj4)) {
                        arrayList3.add(obj4);
                    }
                }
                arrayList = arrayList3;
            }
            ((SubscriptionApi) this.f989a.b.invoke()).checkPurchaseReplacement(this.c, "GOOGLE", this.d, this.f989a.f714a.makeReceipt(arrayList), this.b);
        }
        return Unit.INSTANCE;
    }
}
