package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class j2 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NPFBillingClient f964a;
    public final /* synthetic */ Function2 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j2(NPFBillingClient nPFBillingClient, Function2 function2) {
        super(2);
        this.f964a = nPFBillingClient;
        this.b = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        List transactions = (List) obj;
        Intrinsics.checkNotNullParameter(transactions, "transactions");
        this.f964a.teardown();
        this.b.invoke(transactions, (NPFError) obj2);
        return Unit.INSTANCE;
    }
}
