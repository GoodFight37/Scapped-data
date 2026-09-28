package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.SubscriptionOwnership;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NPFBillingClient f1007a;
    public final /* synthetic */ Function2 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(NPFBillingClient nPFBillingClient, Function2 function2) {
        super(2);
        this.f1007a = nPFBillingClient;
        this.b = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        SubscriptionOwnership ownership = (SubscriptionOwnership) obj;
        Intrinsics.checkNotNullParameter(ownership, "ownership");
        this.f1007a.teardown();
        this.b.invoke(ownership, (NPFError) obj2);
        return Unit.INSTANCE;
    }
}
