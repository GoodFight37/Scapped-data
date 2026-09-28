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
public final class t1 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VirtualCurrencyPurchaseGoogleRepository f993a;
    public final /* synthetic */ v1 b;
    public final /* synthetic */ BaaSUser c;
    public final /* synthetic */ NPFBillingClient d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t1(VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository, NPFBillingClient nPFBillingClient, BaaSUser baaSUser, v1 v1Var) {
        super(2);
        this.f993a = virtualCurrencyPurchaseGoogleRepository;
        this.b = v1Var;
        this.c = baaSUser;
        this.d = nPFBillingClient;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v22, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Iterable, java.util.List] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ?? EmptyList;
        List list = (List) obj;
        NPFError nPFError = (NPFError) obj2;
        if (nPFError != null) {
            this.f993a.f720a.reportError(VirtualCurrencyHelper.REPORT_EVENT_ID, "recoverPurchases#queryPurchases", nPFError);
            this.b.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), nPFError);
        } else {
            if (list != null) {
                VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository = this.f993a;
                ArrayList arrayList = new ArrayList();
                for (Object obj3 : list) {
                    if (virtualCurrencyPurchaseGoogleRepository.f720a.isVirtualCurrency((Purchase) obj3)) {
                        arrayList.add(obj3);
                    }
                }
                VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository2 = this.f993a;
                EmptyList = new ArrayList();
                for (Object obj4 : arrayList) {
                    if (virtualCurrencyPurchaseGoogleRepository2.f720a.isStatePurchased((Purchase) obj4)) {
                        EmptyList.add(obj4);
                    }
                }
            } else {
                EmptyList = CollectionsKt.emptyList();
            }
            ?? r5 = EmptyList;
            VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository3 = this.f993a;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj5 : r5) {
                VirtualCurrencyHelper virtualCurrencyHelper = virtualCurrencyPurchaseGoogleRepository3.f720a;
                Boolean boolIsIABNonConsumable = virtualCurrencyPurchaseGoogleRepository3.c.isIABNonConsumable();
                Intrinsics.checkNotNullExpressionValue(boolIsIABNonConsumable, "capabilities.isIABNonConsumable");
                if (virtualCurrencyHelper.isUnprocessed((Purchase) obj5, boolIsIABNonConsumable.booleanValue())) {
                    arrayList2.add(obj5);
                }
            }
            if (arrayList2.isEmpty()) {
                NPFError nPFErrorCreate_VirtualCurrency_NoPurchaseToRecoverOrRestore_404 = this.f993a.g.create_VirtualCurrency_NoPurchaseToRecoverOrRestore_404();
                Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_VirtualCurrency_NoPurchaseToRecoverOrRestore_404, "errorFactory.create_Virt…eToRecoverOrRestore_404()");
                this.f993a.f720a.reportError(VirtualCurrencyHelper.REPORT_EVENT_ID, "recoverPurchases#queryPurchases#NotFoundPurchaseItemList", nPFErrorCreate_VirtualCurrency_NoPurchaseToRecoverOrRestore_404);
                this.b.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), nPFErrorCreate_VirtualCurrency_NoPurchaseToRecoverOrRestore_404);
            } else {
                VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository4 = this.f993a;
                ArrayList arrayList3 = new ArrayList();
                for (Object obj6 : arrayList2) {
                    if (virtualCurrencyPurchaseGoogleRepository4.f720a.isMultiQuantityPurchased((Purchase) obj6)) {
                        arrayList3.add(obj6);
                    }
                }
                if (arrayList3.isEmpty()) {
                    OrderCacheRepository orderCacheRepository = this.f993a.e;
                    ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        arrayList4.add(PurchaseExtensionsKt.getSku((Purchase) it.next()));
                    }
                    Map<String, JSONObject> mapFind = orderCacheRepository.find(arrayList4);
                    VirtualCurrencyHelper virtualCurrencyHelper2 = this.f993a.f720a;
                    String packageName = this.f993a.c.getPackageName();
                    Intrinsics.checkNotNullExpressionValue(packageName, "capabilities.packageName");
                    ((VirtualCurrencyApi) this.f993a.d.invoke()).createPurchases(this.c, "GOOGLE", virtualCurrencyHelper2.makeReceipt(packageName, this.c.getUserId(), arrayList2, mapFind), new s1(this.b, this.f993a, arrayList2, r5, this.d));
                } else {
                    NPFError nPFErrorCreate_VirtualCurrency_MultiQuantityPurchase_2051 = this.f993a.g.create_VirtualCurrency_MultiQuantityPurchase_2051();
                    Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_VirtualCurrency_MultiQuantityPurchase_2051, "errorFactory.create_Virt…tiQuantityPurchase_2051()");
                    this.f993a.f720a.reportError(VirtualCurrencyHelper.REPORT_EVENT_ID, "recoverPurchases#queryPurchases#MultiQuantityPurchase", nPFErrorCreate_VirtualCurrency_MultiQuantityPurchase_2051);
                    this.b.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), nPFErrorCreate_VirtualCurrency_MultiQuantityPurchase_2051);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
