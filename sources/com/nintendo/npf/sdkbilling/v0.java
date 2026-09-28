package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.SubscriptionReplacement;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NPFBillingClient f996a;
    public final /* synthetic */ Function2 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(NPFBillingClient nPFBillingClient, Function2 function2) {
        super(2);
        this.f996a = nPFBillingClient;
        this.b = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        this.f996a.teardown();
        this.b.invoke((SubscriptionReplacement) obj, (NPFError) obj2);
        return Unit.INSTANCE;
    }
}
