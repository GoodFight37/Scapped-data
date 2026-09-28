package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyBundleGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyBundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class b1 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d1 f935a;
    public final /* synthetic */ NPFBillingClient b;
    public final /* synthetic */ VirtualCurrencyBundleGoogleRepository c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b1(d1 d1Var, NPFBillingClient nPFBillingClient, VirtualCurrencyBundleGoogleRepository virtualCurrencyBundleGoogleRepository) {
        super(2);
        this.f935a = d1Var;
        this.b = nPFBillingClient;
        this.c = virtualCurrencyBundleGoogleRepository;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        List<VirtualCurrencyBundle> bundles = (List) obj;
        NPFError nPFError = (NPFError) obj2;
        Intrinsics.checkNotNullParameter(bundles, "bundles");
        if (nPFError != null) {
            this.f935a.invoke(CollectionsKt.emptyList(), nPFError);
        } else if (bundles.isEmpty()) {
            this.f935a.invoke(CollectionsKt.emptyList(), null);
        } else {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(bundles, 10));
            for (VirtualCurrencyBundle virtualCurrencyBundle : bundles) {
                arrayList.add(TuplesKt.to(virtualCurrencyBundle.getSku(), virtualCurrencyBundle));
            }
            Map map = MapsKt.toMap(arrayList);
            this.b.getProductDetailsList(new ArrayList(map.keySet()), new a1(this.c, this.f935a, map));
        }
        return Unit.INSTANCE;
    }
}
