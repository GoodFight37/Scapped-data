package com.nintendo.npf.sdkbilling;

import com.android.billingclient.api.BillingClient;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.SubscriptionOwnership;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionOwnershipGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubscriptionOwnershipGoogleRepository f1004a;
    public final /* synthetic */ z b;
    public final /* synthetic */ NPFBillingClient c;
    public final /* synthetic */ BaaSUser d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(SubscriptionOwnershipGoogleRepository subscriptionOwnershipGoogleRepository, z zVar, NPFBillingClient nPFBillingClient, BaaSUser baaSUser) {
        super(1);
        this.f1004a = subscriptionOwnershipGoogleRepository;
        this.b = zVar;
        this.c = nPFBillingClient;
        this.d = baaSUser;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        NPFError nPFError = (NPFError) obj;
        if (nPFError != null) {
            this.f1004a.f708a.reportError("updateOwnerships/setup", nPFError);
            this.b.invoke(new SubscriptionOwnership(-1, -1L), nPFError);
        } else {
            NPFBillingClient nPFBillingClient = this.c;
            nPFBillingClient.isFeatureSupported(BillingClient.FeatureType.SUBSCRIPTIONS, new x(this.f1004a, this.b, nPFBillingClient, this.d));
        }
        return Unit.INSTANCE;
    }
}
