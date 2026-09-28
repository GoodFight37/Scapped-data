package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchases;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyPurchaseGoogleRepository;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class f1 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VirtualCurrencyPurchaseGoogleRepository f948a;
    public final /* synthetic */ List b;
    public final /* synthetic */ Function2 c;
    public final /* synthetic */ VirtualCurrencyPurchases d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f1(VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository, List list, Function2 function2, VirtualCurrencyPurchases virtualCurrencyPurchases) {
        super(1);
        this.f948a = virtualCurrencyPurchaseGoogleRepository;
        this.b = list;
        this.c = function2;
        this.d = virtualCurrencyPurchases;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Map<String, NPFError> errors = (Map) obj;
        Intrinsics.checkNotNullParameter(errors, "errors");
        this.f948a.f720a.reportPurchaseAcknowledgementResults("purchase", this.b, errors);
        if (errors.isEmpty()) {
            this.c.invoke(this.d, null);
        } else {
            this.c.invoke(null, this.f948a.f720a.finalizePurchaseError(errors.values().iterator().next()));
        }
        return Unit.INSTANCE;
    }
}
