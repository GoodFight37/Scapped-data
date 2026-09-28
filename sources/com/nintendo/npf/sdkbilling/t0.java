package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionReplacementGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class t0 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubscriptionReplacementGoogleRepository f992a;
    public final /* synthetic */ v0 b;
    public final /* synthetic */ NPFBillingClient c;
    public final /* synthetic */ BaaSUser d;
    public final /* synthetic */ String e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(SubscriptionReplacementGoogleRepository subscriptionReplacementGoogleRepository, v0 v0Var, NPFBillingClient nPFBillingClient, BaaSUser baaSUser, String str) {
        super(1);
        this.f992a = subscriptionReplacementGoogleRepository;
        this.b = v0Var;
        this.c = nPFBillingClient;
        this.d = baaSUser;
        this.e = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        NPFError nPFError = (NPFError) obj;
        if (nPFError != null) {
            this.f992a.f714a.reportError("purchase/isFeatureSupported", nPFError);
            this.b.invoke(null, nPFError);
        } else {
            this.c.queryPurchases(new s0(this.f992a, this.b, this.d, this.e));
        }
        return Unit.INSTANCE;
    }
}
