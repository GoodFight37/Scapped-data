package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchases;
import com.nintendo.npf.sdk.infrastructure.helper.VirtualCurrencyHelper;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyPurchaseGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class u1 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VirtualCurrencyPurchaseGoogleRepository f995a;
    public final /* synthetic */ v1 b;
    public final /* synthetic */ NPFBillingClient c;
    public final /* synthetic */ BaaSUser d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u1(VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository, NPFBillingClient nPFBillingClient, BaaSUser baaSUser, v1 v1Var) {
        super(1);
        this.f995a = virtualCurrencyPurchaseGoogleRepository;
        this.b = v1Var;
        this.c = nPFBillingClient;
        this.d = baaSUser;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        NPFError nPFError = (NPFError) obj;
        if (nPFError != null) {
            this.f995a.f720a.reportError(VirtualCurrencyHelper.REPORT_EVENT_ID, "recoverPurchases#setup", nPFError);
            this.b.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), nPFError);
        } else {
            NPFBillingClient nPFBillingClient = this.c;
            nPFBillingClient.queryPurchases(new t1(this.f995a, nPFBillingClient, this.d, this.b));
        }
        return Unit.INSTANCE;
    }
}
