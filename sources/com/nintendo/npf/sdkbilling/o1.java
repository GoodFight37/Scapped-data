package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchases;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyPurchaseGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class o1 extends Lambda implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NPFBillingClient f979a;
    public final /* synthetic */ Function3 b;
    public final /* synthetic */ VirtualCurrencyPurchaseGoogleRepository c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o1(NPFBillingClient nPFBillingClient, Function3 function3, VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository) {
        super(3);
        this.f979a = nPFBillingClient;
        this.b = function3;
        this.c = virtualCurrencyPurchaseGoogleRepository;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        VirtualCurrencyPurchases purchases = (VirtualCurrencyPurchases) obj;
        Boolean bool = (Boolean) obj2;
        bool.booleanValue();
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        this.f979a.teardown();
        this.b.invoke(purchases, bool, (NPFError) obj3);
        this.c.h = false;
        return Unit.INSTANCE;
    }
}
