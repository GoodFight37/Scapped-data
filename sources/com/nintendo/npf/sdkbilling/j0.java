package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.SubscriptionReplacement;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionPurchaseGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubscriptionPurchaseGoogleRepository f962a;
    public final /* synthetic */ l0 b;
    public final /* synthetic */ NPFBillingClient c;
    public final /* synthetic */ String d;
    public final /* synthetic */ SubscriptionReplacement e;
    public final /* synthetic */ BaaSUser f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(SubscriptionPurchaseGoogleRepository subscriptionPurchaseGoogleRepository, l0 l0Var, NPFBillingClient nPFBillingClient, String str, SubscriptionReplacement subscriptionReplacement, BaaSUser baaSUser) {
        super(1);
        this.f962a = subscriptionPurchaseGoogleRepository;
        this.b = l0Var;
        this.c = nPFBillingClient;
        this.d = str;
        this.e = subscriptionReplacement;
        this.f = baaSUser;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        NPFError nPFError = (NPFError) obj;
        if (nPFError != null) {
            this.f962a.f712a.reportError("purchase/isFeatureSupported", nPFError);
            this.b.invoke(nPFError);
        } else {
            this.c.getProductDetailsList(CollectionsKt.listOf(this.d), new i0(this.f962a, this.b, this.e, this.c, this.f));
        }
        return Unit.INSTANCE;
    }
}
