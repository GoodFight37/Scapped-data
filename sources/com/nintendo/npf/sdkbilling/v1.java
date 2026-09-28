package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchases;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class v1 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NPFBillingClient f997a;
    public final /* synthetic */ p1 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v1(NPFBillingClient nPFBillingClient, p1 p1Var) {
        super(2);
        this.f997a = nPFBillingClient;
        this.b = p1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        VirtualCurrencyPurchases purchases = (VirtualCurrencyPurchases) obj;
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        this.f997a.teardown();
        this.b.invoke(purchases, (NPFError) obj2);
        return Unit.INSTANCE;
    }
}
