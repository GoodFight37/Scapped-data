package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionPurchaseGoogleRepository;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubscriptionPurchaseGoogleRepository f947a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ l0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(SubscriptionPurchaseGoogleRepository subscriptionPurchaseGoogleRepository, ArrayList arrayList, l0 l0Var) {
        super(1);
        this.f947a = subscriptionPurchaseGoogleRepository;
        this.b = arrayList;
        this.c = l0Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Map<String, NPFError> errors = (Map) obj;
        Intrinsics.checkNotNullParameter(errors, "errors");
        this.f947a.f712a.reportPurchaseAcknowledgementResults("purchase", this.b, errors);
        if (errors.isEmpty()) {
            this.c.invoke(null);
        } else {
            this.c.invoke(errors.values().iterator().next());
        }
        return Unit.INSTANCE;
    }
}
