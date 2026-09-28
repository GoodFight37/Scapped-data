package com.nintendo.npf.sdkbilling;

import com.android.billingclient.api.Purchase;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.api.PromoCodeApi;
import com.nintendo.npf.sdk.infrastructure.helper.PromoCodeHelper;
import com.nintendo.npf.sdk.infrastructure.repository.PromoCodeBundleGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PromoCodeBundleGoogleRepository f971a;
    public final /* synthetic */ o b;
    public final /* synthetic */ BaaSUser c;
    public final /* synthetic */ NPFBillingClient d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(PromoCodeBundleGoogleRepository promoCodeBundleGoogleRepository, NPFBillingClient nPFBillingClient, BaaSUser baaSUser, o oVar) {
        super(2);
        this.f971a = promoCodeBundleGoogleRepository;
        this.b = oVar;
        this.c = baaSUser;
        this.d = nPFBillingClient;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        List list = (List) obj;
        NPFError nPFError = (NPFError) obj2;
        if (nPFError != null) {
            this.f971a.f707a.reportError(PromoCodeHelper.REPORT_EVENT_ID, "exchangePromoCodes#queryPurchases", nPFError);
            this.b.invoke(CollectionsKt.emptyList(), nPFError);
        } else if (list == null || list.isEmpty()) {
            this.b.invoke(CollectionsKt.emptyList(), null);
        } else {
            ArrayList arrayList = new ArrayList();
            for (Object obj3 : list) {
                if (1 == ((Purchase) obj3).getPurchaseState()) {
                    arrayList.add(obj3);
                }
            }
            if (arrayList.isEmpty()) {
                this.b.invoke(CollectionsKt.emptyList(), null);
            } else {
                PromoCodeApi promoCodeApi = (PromoCodeApi) this.f971a.c.invoke();
                BaaSUser baaSUser = this.c;
                promoCodeApi.getBundles(baaSUser, "GOOGLE", new l(this.b, arrayList, this.f971a, baaSUser, this.d));
            }
        }
        return Unit.INSTANCE;
    }
}
