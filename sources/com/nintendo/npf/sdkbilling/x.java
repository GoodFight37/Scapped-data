package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.SubscriptionOwnership;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionOwnershipGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubscriptionOwnershipGoogleRepository f1001a;
    public final /* synthetic */ z b;
    public final /* synthetic */ NPFBillingClient c;
    public final /* synthetic */ BaaSUser d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(SubscriptionOwnershipGoogleRepository subscriptionOwnershipGoogleRepository, z zVar, NPFBillingClient nPFBillingClient, BaaSUser baaSUser) {
        super(1);
        this.f1001a = subscriptionOwnershipGoogleRepository;
        this.b = zVar;
        this.c = nPFBillingClient;
        this.d = baaSUser;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        NPFError nPFError = (NPFError) obj;
        if (nPFError != null) {
            this.f1001a.f708a.reportError("updateOwnerships/isFeatureSupported", nPFError);
            this.b.invoke(new SubscriptionOwnership(-1, -1L), nPFError);
        } else {
            this.c.queryPurchases(new w(this.f1001a, this.b, this.d));
        }
        return Unit.INSTANCE;
    }
}
