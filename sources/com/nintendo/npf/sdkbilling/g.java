package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NPFBillingClient f950a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(NPFBillingClient nPFBillingClient) {
        super(0);
        this.f950a = nPFBillingClient;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        NPFBillingClient nPFBillingClient = this.f950a;
        return nPFBillingClient.createBillingClient(nPFBillingClient.f729a);
    }
}
