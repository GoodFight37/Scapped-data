package com.nintendo.npf.sdkbilling;

import com.android.billingclient.api.BillingClient;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionPurchaseGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubscriptionPurchaseGoogleRepository f984a;
    public final /* synthetic */ r0 b;
    public final /* synthetic */ NPFBillingClient c;
    public final /* synthetic */ BaaSUser d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(SubscriptionPurchaseGoogleRepository subscriptionPurchaseGoogleRepository, NPFBillingClient nPFBillingClient, BaaSUser baaSUser, r0 r0Var) {
        super(1);
        this.f984a = subscriptionPurchaseGoogleRepository;
        this.b = r0Var;
        this.c = nPFBillingClient;
        this.d = baaSUser;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        NPFError nPFError = (NPFError) obj;
        if (nPFError != null) {
            this.f984a.f712a.reportError("updatePurchases/setup", nPFError);
            this.b.invoke(CollectionsKt.emptyList(), nPFError);
        } else {
            NPFBillingClient nPFBillingClient = this.c;
            nPFBillingClient.isFeatureSupported(BillingClient.FeatureType.SUBSCRIPTIONS, new p0(this.f984a, nPFBillingClient, this.d, this.b));
        }
        return Unit.INSTANCE;
    }
}
