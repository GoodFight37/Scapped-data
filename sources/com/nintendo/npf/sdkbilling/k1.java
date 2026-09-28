package com.nintendo.npf.sdkbilling;

import com.android.billingclient.api.Purchase;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchases;
import com.nintendo.npf.sdk.infrastructure.api.VirtualCurrencyApi;
import com.nintendo.npf.sdk.infrastructure.helper.VirtualCurrencyHelper;
import com.nintendo.npf.sdk.infrastructure.repository.OrderCacheRepository;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyPurchaseGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.internal.util.PurchaseExtensionsKt;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class k1 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VirtualCurrencyPurchaseGoogleRepository f967a;
    public final /* synthetic */ o1 b;
    public final /* synthetic */ BaaSUser c;
    public final /* synthetic */ NPFBillingClient d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k1(VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository, o1 o1Var, BaaSUser baaSUser, NPFBillingClient nPFBillingClient) {
        super(2);
        this.f967a = virtualCurrencyPurchaseGoogleRepository;
        this.b = o1Var;
        this.c = baaSUser;
        this.d = nPFBillingClient;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.nintendo.npf.sdk.infrastructure.helper.VirtualCurrencyHelper] */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Iterable, java.util.List] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ?? EmptyList;
        List list = (List) obj;
        NPFError nPFError = (NPFError) obj2;
        if (nPFError != null) {
            this.f967a.f720a.reportError(VirtualCurrencyHelper.REPORT_EVENT_ID, "purchase#initiatePurchaseFlow", nPFError);
            this.b.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), Boolean.FALSE, nPFError);
        } else {
            if (list != null) {
                VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository = this.f967a;
                ArrayList arrayList = new ArrayList();
                for (Object obj3 : list) {
                    if (virtualCurrencyPurchaseGoogleRepository.f720a.isVirtualCurrency((Purchase) obj3)) {
                        arrayList.add(obj3);
                    }
                }
                VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository2 = this.f967a;
                EmptyList = new ArrayList();
                for (Object obj4 : arrayList) {
                    if (virtualCurrencyPurchaseGoogleRepository2.f720a.isStatePurchased((Purchase) obj4)) {
                        EmptyList.add(obj4);
                    }
                }
            } else {
                EmptyList = CollectionsKt.emptyList();
            }
            if (EmptyList.isEmpty()) {
                NPFError nPFErrorCreate_VirtualCurrency_NoPurchaseFound_Minus1 = this.f967a.g.create_VirtualCurrency_NoPurchaseFound_Minus1();
                Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_VirtualCurrency_NoPurchaseFound_Minus1, "errorFactory.create_Virt…_NoPurchaseFound_Minus1()");
                this.f967a.f720a.reportError(VirtualCurrencyHelper.REPORT_EVENT_ID, "purchase#initiatePurchaseFlow", nPFErrorCreate_VirtualCurrency_NoPurchaseFound_Minus1);
                this.b.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), Boolean.FALSE, nPFErrorCreate_VirtualCurrency_NoPurchaseFound_Minus1);
            } else {
                VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository3 = this.f967a;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj5 : EmptyList) {
                    if (virtualCurrencyPurchaseGoogleRepository3.f720a.isMultiQuantityPurchased((Purchase) obj5)) {
                        arrayList2.add(obj5);
                    }
                }
                if (arrayList2.isEmpty()) {
                    OrderCacheRepository orderCacheRepository = this.f967a.e;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(EmptyList, 10));
                    Iterator it = EmptyList.iterator();
                    while (it.hasNext()) {
                        arrayList3.add(PurchaseExtensionsKt.getSku((Purchase) it.next()));
                    }
                    Map<String, JSONObject> mapFind = orderCacheRepository.find(arrayList3);
                    ?? r0 = this.f967a.f720a;
                    String packageName = this.f967a.c.getPackageName();
                    Intrinsics.checkNotNullExpressionValue(packageName, "capabilities.packageName");
                    ((VirtualCurrencyApi) this.f967a.d.invoke()).createPurchases(this.c, "GOOGLE", r0.makeReceipt(packageName, this.c.getUserId(), EmptyList, mapFind), new j1(this.b, this.f967a, EmptyList, this.d));
                } else {
                    NPFError nPFErrorCreate_VirtualCurrency_MultiQuantityPurchase_2051 = this.f967a.g.create_VirtualCurrency_MultiQuantityPurchase_2051();
                    Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_VirtualCurrency_MultiQuantityPurchase_2051, "errorFactory.create_Virt…tiQuantityPurchase_2051()");
                    this.f967a.f720a.reportError(VirtualCurrencyHelper.REPORT_EVENT_ID, "purchase#initiatePurchaseFlow#MultiQuantityPurchase", nPFErrorCreate_VirtualCurrency_MultiQuantityPurchase_2051);
                    this.b.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), Boolean.FALSE, nPFErrorCreate_VirtualCurrency_MultiQuantityPurchase_2051);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
