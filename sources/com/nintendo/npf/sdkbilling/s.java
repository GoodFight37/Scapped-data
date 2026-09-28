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
public final class s extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PromoCodeBundleGoogleRepository f988a;
    public final /* synthetic */ t b;
    public final /* synthetic */ NPFBillingClient c;
    public final /* synthetic */ BaaSUser d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(PromoCodeBundleGoogleRepository promoCodeBundleGoogleRepository, t tVar, NPFBillingClient nPFBillingClient, BaaSUser baaSUser) {
        super(1);
        this.f988a = promoCodeBundleGoogleRepository;
        this.b = tVar;
        this.c = nPFBillingClient;
        this.d = baaSUser;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        NPFError nPFError = (NPFError) obj;
        if (nPFError != null) {
            this.f988a.f707a.reportError(PromoCodeHelper.REPORT_EVENT_ID, "checkPromoCodes#setup", nPFError);
            this.b.invoke(CollectionsKt.emptyList(), nPFError);
        } else {
            this.c.queryPurchases(new q(this.f988a, this.b, this.d));
        }
        return Unit.INSTANCE;
    }
}
