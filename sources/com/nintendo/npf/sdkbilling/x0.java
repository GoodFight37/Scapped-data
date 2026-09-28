package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionTransactionGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class x0 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubscriptionTransactionGoogleRepository f1002a;
    public final /* synthetic */ z0 b;
    public final /* synthetic */ NPFBillingClient c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(SubscriptionTransactionGoogleRepository subscriptionTransactionGoogleRepository, z0 z0Var, NPFBillingClient nPFBillingClient) {
        super(1);
        this.f1002a = subscriptionTransactionGoogleRepository;
        this.b = z0Var;
        this.c = nPFBillingClient;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        NPFError nPFError = (NPFError) obj;
        if (nPFError != null) {
            this.f1002a.f716a.reportError("checkUnprocessedPurchases/isFeatureSupported", nPFError);
            this.b.invoke(CollectionsKt.emptyList(), nPFError);
        } else {
            this.c.queryPurchases(new w0(this.f1002a, this.b));
        }
        return Unit.INSTANCE;
    }
}
