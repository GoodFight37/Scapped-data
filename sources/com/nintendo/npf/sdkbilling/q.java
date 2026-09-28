package com.nintendo.npf.sdkbilling;

import com.android.billingclient.api.Purchase;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.api.PromoCodeApi;
import com.nintendo.npf.sdk.infrastructure.helper.PromoCodeHelper;
import com.nintendo.npf.sdk.infrastructure.repository.PromoCodeBundleGoogleRepository;
import com.nintendo.npf.sdk.internal.util.PurchaseExtensionsKt;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PromoCodeBundleGoogleRepository f983a;
    public final /* synthetic */ t b;
    public final /* synthetic */ BaaSUser c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(PromoCodeBundleGoogleRepository promoCodeBundleGoogleRepository, t tVar, BaaSUser baaSUser) {
        super(2);
        this.f983a = promoCodeBundleGoogleRepository;
        this.b = tVar;
        this.c = baaSUser;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        List list = (List) obj;
        NPFError nPFError = (NPFError) obj2;
        if (nPFError != null) {
            this.f983a.f707a.reportError(PromoCodeHelper.REPORT_EVENT_ID, "checkPromoCodes#queryPurchases", nPFError);
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
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(PurchaseExtensionsKt.getSku((Purchase) it.next()));
            }
            Set set = CollectionsKt.toSet(arrayList2);
            if (set.isEmpty()) {
                this.b.invoke(CollectionsKt.emptyList(), null);
            } else {
                ((PromoCodeApi) this.f983a.c.invoke()).getBundles(this.c, "GOOGLE", new p(this.b, set));
            }
        }
        return Unit.INSTANCE;
    }
}
