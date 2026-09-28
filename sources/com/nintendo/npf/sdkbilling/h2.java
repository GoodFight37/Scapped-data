package com.nintendo.npf.sdkbilling;

import com.android.billingclient.api.Purchase;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.api.VirtualCurrencyApi;
import com.nintendo.npf.sdk.infrastructure.helper.VirtualCurrencyHelper;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyTransactionGoogleRepository;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class h2 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VirtualCurrencyTransactionGoogleRepository f957a;
    public final /* synthetic */ j2 b;
    public final /* synthetic */ BaaSUser c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h2(VirtualCurrencyTransactionGoogleRepository virtualCurrencyTransactionGoogleRepository, j2 j2Var, BaaSUser baaSUser) {
        super(2);
        this.f957a = virtualCurrencyTransactionGoogleRepository;
        this.b = j2Var;
        this.c = baaSUser;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.Iterable, java.util.List] */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.util.ArrayList] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ?? EmptyList;
        String orderId;
        List list = (List) obj;
        NPFError nPFError = (NPFError) obj2;
        if (nPFError != null) {
            this.f957a.f723a.reportError(VirtualCurrencyHelper.REPORT_EVENT_ID, "checkUnprocessedPurchases#queryPurchases", nPFError);
            this.b.invoke(CollectionsKt.emptyList(), nPFError);
        } else {
            if (list != null) {
                VirtualCurrencyTransactionGoogleRepository virtualCurrencyTransactionGoogleRepository = this.f957a;
                ArrayList arrayList = new ArrayList();
                for (Object obj3 : list) {
                    if (virtualCurrencyTransactionGoogleRepository.f723a.isVirtualCurrency((Purchase) obj3)) {
                        arrayList.add(obj3);
                    }
                }
                VirtualCurrencyTransactionGoogleRepository virtualCurrencyTransactionGoogleRepository2 = this.f957a;
                EmptyList = new ArrayList();
                for (Object obj4 : arrayList) {
                    VirtualCurrencyHelper virtualCurrencyHelper = virtualCurrencyTransactionGoogleRepository2.f723a;
                    Boolean boolIsIABNonConsumable = virtualCurrencyTransactionGoogleRepository2.b.isIABNonConsumable();
                    Intrinsics.checkNotNullExpressionValue(boolIsIABNonConsumable, "capabilities.isIABNonConsumable");
                    if (virtualCurrencyHelper.isUnprocessed((Purchase) obj4, boolIsIABNonConsumable.booleanValue())) {
                        EmptyList.add(obj4);
                    }
                }
            } else {
                EmptyList = CollectionsKt.emptyList();
            }
            if (EmptyList.isEmpty()) {
                this.b.invoke(CollectionsKt.emptyList(), null);
            } else {
                VirtualCurrencyTransactionGoogleRepository virtualCurrencyTransactionGoogleRepository3 = this.f957a;
                ArrayList<Purchase> arrayList2 = new ArrayList();
                for (Object obj5 : EmptyList) {
                    if (virtualCurrencyTransactionGoogleRepository3.f723a.isStatePurchased((Purchase) obj5)) {
                        arrayList2.add(obj5);
                    }
                }
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                for (Purchase purchase : arrayList2) {
                    if (purchase.getOrderId() == null) {
                        String purchaseToken = purchase.getPurchaseToken();
                        Intrinsics.checkNotNullExpressionValue(purchaseToken, "it.purchaseToken");
                        orderId = c.a(purchaseToken);
                    } else {
                        orderId = purchase.getOrderId();
                    }
                    arrayList3.add(orderId);
                }
                VirtualCurrencyTransactionGoogleRepository virtualCurrencyTransactionGoogleRepository4 = this.f957a;
                ArrayList arrayList4 = new ArrayList();
                for (Object obj6 : arrayList3) {
                    if (!virtualCurrencyTransactionGoogleRepository4.f723a.isOrderIdEmpty((String) obj6)) {
                        arrayList4.add(obj6);
                    }
                }
                Set<String> set = CollectionsKt.toSet(arrayList4);
                VirtualCurrencyTransactionGoogleRepository virtualCurrencyTransactionGoogleRepository5 = this.f957a;
                ArrayList arrayList5 = new ArrayList();
                for (Object obj7 : arrayList3) {
                    if (virtualCurrencyTransactionGoogleRepository5.f723a.isOrderIdEmpty((String) obj7)) {
                        arrayList5.add(obj7);
                    }
                }
                if (!arrayList5.isEmpty()) {
                    this.f957a.f723a.reportError(VirtualCurrencyHelper.REPORT_EVENT_ID, "checkUnprocessedPurchases#createTransactions", this.f957a.e.create_UnknownError_9999("Order ID is empty with Purchase. PurchaseState.PURCHASED"));
                }
                if (set.isEmpty()) {
                    this.b.invoke(VirtualCurrencyTransactionGoogleRepository.access$createTransactions(this.f957a, EmptyList, null), null);
                } else {
                    ((VirtualCurrencyApi) this.f957a.c.invoke()).getOrderIds(this.c, "GOOGLE", set, new g2(this.b, this.f957a, EmptyList));
                }
            }
        }
        return Unit.INSTANCE;
    }
}
