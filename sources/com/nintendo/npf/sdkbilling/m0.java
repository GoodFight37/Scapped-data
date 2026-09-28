package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionPurchaseGoogleRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class m0 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubscriptionPurchaseGoogleRepository f972a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ r0 c;
    public final /* synthetic */ List d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(SubscriptionPurchaseGoogleRepository subscriptionPurchaseGoogleRepository, ArrayList arrayList, r0 r0Var, List list) {
        super(1);
        this.f972a = subscriptionPurchaseGoogleRepository;
        this.b = arrayList;
        this.c = r0Var;
        this.d = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Map<String, NPFError> errors = (Map) obj;
        Intrinsics.checkNotNullParameter(errors, "errors");
        this.f972a.f712a.reportPurchaseAcknowledgementResults("purchase", this.b, errors);
        if (errors.isEmpty()) {
            this.c.invoke(this.d, null);
        } else {
            this.c.invoke(CollectionsKt.emptyList(), errors.values().iterator().next());
        }
        return Unit.INSTANCE;
    }
}
