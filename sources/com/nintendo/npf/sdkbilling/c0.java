package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.api.SubscriptionApi;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionProductGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubscriptionProductGoogleRepository f937a;
    public final /* synthetic */ e0 b;
    public final /* synthetic */ BaaSUser c;
    public final /* synthetic */ NPFBillingClient d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(SubscriptionProductGoogleRepository subscriptionProductGoogleRepository, NPFBillingClient nPFBillingClient, BaaSUser baaSUser, e0 e0Var) {
        super(1);
        this.f937a = subscriptionProductGoogleRepository;
        this.b = e0Var;
        this.c = baaSUser;
        this.d = nPFBillingClient;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        NPFError nPFError = (NPFError) obj;
        if (nPFError != null) {
            this.f937a.f710a.reportError("getProducts/isFeatureSupported", nPFError);
            this.b.invoke(CollectionsKt.emptyList(), nPFError);
        } else {
            ((SubscriptionApi) this.f937a.b.invoke()).getProducts(this.c, "GOOGLE", new b0(this.b, this.d, this.f937a));
        }
        return Unit.INSTANCE;
    }
}
