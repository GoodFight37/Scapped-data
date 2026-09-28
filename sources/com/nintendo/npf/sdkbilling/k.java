package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.PromoCodePurchases;
import com.nintendo.npf.sdk.infrastructure.repository.PromoCodeBundleGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f965a;
    public final /* synthetic */ PromoCodeBundleGoogleRepository b;
    public final /* synthetic */ NPFBillingClient c;
    public final /* synthetic */ ArrayList d;
    public final /* synthetic */ Map e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(o oVar, PromoCodeBundleGoogleRepository promoCodeBundleGoogleRepository, NPFBillingClient nPFBillingClient, ArrayList arrayList, Map map) {
        super(2);
        this.f965a = oVar;
        this.b = promoCodeBundleGoogleRepository;
        this.c = nPFBillingClient;
        this.d = arrayList;
        this.e = map;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        PromoCodePurchases purchases = (PromoCodePurchases) obj;
        NPFError nPFError = (NPFError) obj2;
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        if (nPFError != null) {
            this.f965a.invoke(CollectionsKt.emptyList(), this.b.f707a.finalizePurchaseError(nPFError));
        } else if (purchases.getTransactions().isEmpty()) {
            this.f965a.invoke(CollectionsKt.emptyList(), null);
        } else {
            this.c.consumePurchases(purchases.getTransactions(), new j(this.b, purchases, this.f965a, this.d, this.e));
        }
        return Unit.INSTANCE;
    }
}
