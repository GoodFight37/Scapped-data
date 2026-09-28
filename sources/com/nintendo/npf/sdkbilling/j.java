package com.nintendo.npf.sdkbilling;

import com.android.billingclient.api.Purchase;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.PromoCodePurchases;
import com.nintendo.npf.sdk.infrastructure.repository.PromoCodeBundleGoogleRepository;
import com.nintendo.npf.sdk.internal.util.PurchaseExtensionsKt;
import com.nintendo.npf.sdk.promo.PromoCodeBundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PromoCodeBundleGoogleRepository f961a;
    public final /* synthetic */ PromoCodePurchases b;
    public final /* synthetic */ o c;
    public final /* synthetic */ ArrayList d;
    public final /* synthetic */ Map e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(PromoCodeBundleGoogleRepository promoCodeBundleGoogleRepository, PromoCodePurchases promoCodePurchases, o oVar, ArrayList arrayList, Map map) {
        super(1);
        this.f961a = promoCodeBundleGoogleRepository;
        this.b = promoCodePurchases;
        this.c = oVar;
        this.d = arrayList;
        this.e = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Map<String, NPFError> errors = (Map) obj;
        Intrinsics.checkNotNullParameter(errors, "errors");
        this.f961a.f707a.reportPurchaseConsumptionResults("exchangePromoCodes", this.b.getTransactions(), errors);
        if (errors.isEmpty()) {
            ArrayList arrayList = this.d;
            Map map = this.e;
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                PromoCodeBundle promoCodeBundle = (PromoCodeBundle) map.get(PurchaseExtensionsKt.getSku((Purchase) it.next()));
                if (promoCodeBundle != null) {
                    arrayList2.add(promoCodeBundle);
                }
            }
            this.c.invoke(arrayList2, null);
        } else {
            this.c.invoke(CollectionsKt.emptyList(), this.f961a.f707a.finalizePurchaseError(errors.values().iterator().next()));
        }
        return Unit.INSTANCE;
    }
}
