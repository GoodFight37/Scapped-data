package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.helper.VirtualCurrencyHelper;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyTransactionGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class i2 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VirtualCurrencyTransactionGoogleRepository f960a;
    public final /* synthetic */ j2 b;
    public final /* synthetic */ NPFBillingClient c;
    public final /* synthetic */ BaaSUser d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i2(VirtualCurrencyTransactionGoogleRepository virtualCurrencyTransactionGoogleRepository, j2 j2Var, NPFBillingClient nPFBillingClient, BaaSUser baaSUser) {
        super(1);
        this.f960a = virtualCurrencyTransactionGoogleRepository;
        this.b = j2Var;
        this.c = nPFBillingClient;
        this.d = baaSUser;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        NPFError nPFError = (NPFError) obj;
        if (nPFError != null) {
            this.f960a.f723a.reportError(VirtualCurrencyHelper.REPORT_EVENT_ID, "checkUnprocessedPurchases#setup", nPFError);
            this.b.invoke(CollectionsKt.emptyList(), nPFError);
        } else {
            this.c.queryPurchases(new h2(this.f960a, this.b, this.d));
        }
        return Unit.INSTANCE;
    }
}
