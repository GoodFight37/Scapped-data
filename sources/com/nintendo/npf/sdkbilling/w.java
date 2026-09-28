package com.nintendo.npf.sdkbilling;

import com.android.billingclient.api.Purchase;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.SubscriptionOwnership;
import com.nintendo.npf.sdk.infrastructure.api.SubscriptionApi;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionOwnershipGoogleRepository;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubscriptionOwnershipGoogleRepository f998a;
    public final /* synthetic */ z b;
    public final /* synthetic */ BaaSUser c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(SubscriptionOwnershipGoogleRepository subscriptionOwnershipGoogleRepository, z zVar, BaaSUser baaSUser) {
        super(2);
        this.f998a = subscriptionOwnershipGoogleRepository;
        this.b = zVar;
        this.c = baaSUser;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ArrayList arrayList;
        List list = (List) obj;
        NPFError nPFError = (NPFError) obj2;
        if (nPFError != null) {
            this.f998a.f708a.reportError("updateOwnerships/queryPurchases", nPFError);
            this.b.invoke(new SubscriptionOwnership(-1, -1L), nPFError);
        } else {
            if (list != null) {
                SubscriptionOwnershipGoogleRepository subscriptionOwnershipGoogleRepository = this.f998a;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj3 : list) {
                    if (subscriptionOwnershipGoogleRepository.f708a.isSubscription((Purchase) obj3)) {
                        arrayList2.add(obj3);
                    }
                }
                SubscriptionOwnershipGoogleRepository subscriptionOwnershipGoogleRepository2 = this.f998a;
                arrayList = new ArrayList();
                for (Object obj4 : arrayList2) {
                    if (subscriptionOwnershipGoogleRepository2.f708a.isStatePurchased((Purchase) obj4)) {
                        arrayList.add(obj4);
                    }
                }
            } else {
                arrayList = null;
            }
            ((SubscriptionApi) this.f998a.b.invoke()).updateOwnerships(this.c, "GOOGLE", this.f998a.f708a.makeReceipt(arrayList), this.b);
        }
        return Unit.INSTANCE;
    }
}
