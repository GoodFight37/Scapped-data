package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.helper.PromoCodeHelper;
import com.nintendo.npf.sdk.infrastructure.repository.PromoCodeBundleGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PromoCodeBundleGoogleRepository f974a;
    public final /* synthetic */ o b;
    public final /* synthetic */ NPFBillingClient c;
    public final /* synthetic */ BaaSUser d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(PromoCodeBundleGoogleRepository promoCodeBundleGoogleRepository, NPFBillingClient nPFBillingClient, BaaSUser baaSUser, o oVar) {
        super(1);
        this.f974a = promoCodeBundleGoogleRepository;
        this.b = oVar;
        this.c = nPFBillingClient;
        this.d = baaSUser;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        NPFError nPFError = (NPFError) obj;
        if (nPFError != null) {
            this.f974a.f707a.reportError(PromoCodeHelper.REPORT_EVENT_ID, "exchangePromoCodes#setup", nPFError);
            this.b.invoke(CollectionsKt.emptyList(), nPFError);
        } else {
            NPFBillingClient nPFBillingClient = this.c;
            nPFBillingClient.queryPurchases(new m(this.f974a, nPFBillingClient, this.d, this.b));
        }
        return Unit.INSTANCE;
    }
}
