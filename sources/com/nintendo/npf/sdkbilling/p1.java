package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchases;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyPurchaseGoogleRepository;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class p1 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VirtualCurrencyPurchaseGoogleRepository f982a;
    public final /* synthetic */ Function2 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p1(VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository, Function2 function2) {
        super(2);
        this.f982a = virtualCurrencyPurchaseGoogleRepository;
        this.b = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        VirtualCurrencyPurchases purchases = (VirtualCurrencyPurchases) obj;
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        this.f982a.i = false;
        this.b.invoke(purchases, (NPFError) obj2);
        return Unit.INSTANCE;
    }
}
