package com.nintendo.npf.sdkbilling;

import com.android.billingclient.api.Purchase;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.api.PromoCodeApi;
import com.nintendo.npf.sdk.infrastructure.helper.PromoCodeHelper;
import com.nintendo.npf.sdk.infrastructure.repository.OrderCacheRepository;
import com.nintendo.npf.sdk.infrastructure.repository.PromoCodeBundleGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.internal.util.PurchaseExtensionsKt;
import com.nintendo.npf.sdk.promo.PromoCodeBundle;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f968a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ PromoCodeBundleGoogleRepository c;
    public final /* synthetic */ BaaSUser d;
    public final /* synthetic */ NPFBillingClient e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(o oVar, ArrayList arrayList, PromoCodeBundleGoogleRepository promoCodeBundleGoogleRepository, BaaSUser baaSUser, NPFBillingClient nPFBillingClient) {
        super(2);
        this.f968a = oVar;
        this.b = arrayList;
        this.c = promoCodeBundleGoogleRepository;
        this.d = baaSUser;
        this.e = nPFBillingClient;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        List<PromoCodeBundle> bundles = (List) obj;
        NPFError nPFError = (NPFError) obj2;
        Intrinsics.checkNotNullParameter(bundles, "bundles");
        if (nPFError != null) {
            this.f968a.invoke(CollectionsKt.emptyList(), nPFError);
        } else if (bundles.isEmpty()) {
            this.f968a.invoke(CollectionsKt.emptyList(), null);
        } else {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(bundles, 10));
            for (PromoCodeBundle promoCodeBundle : bundles) {
                arrayList.add(TuplesKt.to(promoCodeBundle.getSku(), promoCodeBundle));
            }
            Map map = MapsKt.toMap(arrayList);
            ArrayList arrayList2 = this.b;
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : arrayList2) {
                if (map.containsKey(PurchaseExtensionsKt.getSku((Purchase) obj3))) {
                    arrayList3.add(obj3);
                }
            }
            if (arrayList3.isEmpty()) {
                this.f968a.invoke(CollectionsKt.emptyList(), null);
            } else {
                OrderCacheRepository orderCacheRepository = this.c.e;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    arrayList4.add(PurchaseExtensionsKt.getSku((Purchase) it.next()));
                }
                Map<String, JSONObject> mapFind = orderCacheRepository.find(arrayList4);
                PromoCodeHelper promoCodeHelper = this.c.f707a;
                String packageName = this.c.b.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "capabilities.packageName");
                ((PromoCodeApi) this.c.c.invoke()).createPurchases(this.d, "GOOGLE", promoCodeHelper.makeReceipt(packageName, this.d.getUserId(), arrayList3, mapFind), new k(this.f968a, this.c, this.e, arrayList3, map));
            }
        }
        return Unit.INSTANCE;
    }
}
