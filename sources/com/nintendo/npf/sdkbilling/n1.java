package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchases;
import com.nintendo.npf.sdk.infrastructure.helper.VirtualCurrencyHelper;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyPurchaseGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyBundle;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class n1 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VirtualCurrencyPurchaseGoogleRepository f976a;
    public final /* synthetic */ o1 b;
    public final /* synthetic */ NPFBillingClient c;
    public final /* synthetic */ VirtualCurrencyBundle d;
    public final /* synthetic */ String e;
    public final /* synthetic */ BaaSUser f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n1(VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository, o1 o1Var, NPFBillingClient nPFBillingClient, VirtualCurrencyBundle virtualCurrencyBundle, String str, BaaSUser baaSUser) {
        super(1);
        this.f976a = virtualCurrencyPurchaseGoogleRepository;
        this.b = o1Var;
        this.c = nPFBillingClient;
        this.d = virtualCurrencyBundle;
        this.e = str;
        this.f = baaSUser;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        NPFError nPFError = (NPFError) obj;
        if (nPFError != null) {
            this.f976a.f720a.reportError(VirtualCurrencyHelper.REPORT_EVENT_ID, "purchase#setup", nPFError);
            this.b.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), Boolean.FALSE, nPFError);
        } else {
            this.c.getProductDetailsList(CollectionsKt.listOf(this.d.getSku()), new m1(this.f976a, this.b, this.c, this.d, this.e, this.f));
        }
        return Unit.INSTANCE;
    }
}
