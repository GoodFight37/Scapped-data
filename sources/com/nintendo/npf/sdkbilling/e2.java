package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchases;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class e2 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NPFBillingClient f946a;
    public final /* synthetic */ w1 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e2(NPFBillingClient nPFBillingClient, w1 w1Var) {
        super(2);
        this.f946a = nPFBillingClient;
        this.b = w1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        VirtualCurrencyPurchases purchases = (VirtualCurrencyPurchases) obj;
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        this.f946a.teardown();
        this.b.invoke(purchases, (NPFError) obj2);
        return Unit.INSTANCE;
    }
}
