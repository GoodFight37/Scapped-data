package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchases;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyPurchaseGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class i1 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o1 f959a;
    public final /* synthetic */ VirtualCurrencyPurchaseGoogleRepository b;
    public final /* synthetic */ NPFBillingClient c;
    public final /* synthetic */ List d;
    public final /* synthetic */ VirtualCurrencyPurchases e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i1(o1 o1Var, VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository, NPFBillingClient nPFBillingClient, List list, VirtualCurrencyPurchases virtualCurrencyPurchases) {
        super(2);
        this.f959a = o1Var;
        this.b = virtualCurrencyPurchaseGoogleRepository;
        this.c = nPFBillingClient;
        this.d = list;
        this.e = virtualCurrencyPurchases;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        NPFError nPFError = (NPFError) obj2;
        if (nPFError != null) {
            this.f959a.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), Boolean.TRUE, nPFError);
        } else {
            VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository = this.b;
            NPFBillingClient nPFBillingClient = this.c;
            List list = this.d;
            VirtualCurrencyPurchases virtualCurrencyPurchases = this.e;
            VirtualCurrencyPurchaseGoogleRepository.access$consumePurchases(virtualCurrencyPurchaseGoogleRepository, nPFBillingClient, list, virtualCurrencyPurchases, new h1(this.f959a, virtualCurrencyPurchases));
        }
        return Unit.INSTANCE;
    }
}
