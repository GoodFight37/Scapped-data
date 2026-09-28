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
public final class d2 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VirtualCurrencyPurchaseGoogleRepository f943a;
    public final /* synthetic */ e2 b;
    public final /* synthetic */ NPFBillingClient c;
    public final /* synthetic */ BaaSUser d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d2(VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository, NPFBillingClient nPFBillingClient, BaaSUser baaSUser, e2 e2Var) {
        super(1);
        this.f943a = virtualCurrencyPurchaseGoogleRepository;
        this.b = e2Var;
        this.c = nPFBillingClient;
        this.d = baaSUser;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        NPFError nPFError = (NPFError) obj;
        if (nPFError != null) {
            this.f943a.f720a.reportError(VirtualCurrencyHelper.REPORT_EVENT_ID, "restorePurchases#setup", nPFError);
            this.b.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), nPFError);
        } else {
            NPFBillingClient nPFBillingClient = this.c;
            nPFBillingClient.queryPurchases(new c2(this.f943a, nPFBillingClient, this.d, this.b));
        }
        return Unit.INSTANCE;
    }
}
