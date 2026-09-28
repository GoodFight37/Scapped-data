package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchases;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyPurchaseGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class b2 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e2 f936a;
    public final /* synthetic */ VirtualCurrencyPurchaseGoogleRepository b;
    public final /* synthetic */ ArrayList c;
    public final /* synthetic */ List d;
    public final /* synthetic */ NPFBillingClient e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b2(e2 e2Var, VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository, ArrayList arrayList, List list, NPFBillingClient nPFBillingClient) {
        super(2);
        this.f936a = e2Var;
        this.b = virtualCurrencyPurchaseGoogleRepository;
        this.c = arrayList;
        this.d = list;
        this.e = nPFBillingClient;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        VirtualCurrencyPurchases purchases = (VirtualCurrencyPurchases) obj;
        NPFError nPFError = (NPFError) obj2;
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        if (nPFError != null) {
            this.f936a.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), nPFError);
        } else if (purchases.getTransactions().isEmpty()) {
            this.f936a.invoke(purchases, null);
        } else {
            VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository = this.b;
            ArrayList arrayList = this.c;
            List<String> transactions = purchases.getTransactions();
            Boolean boolIsIABNonConsumable = this.b.c.isIABNonConsumable();
            Intrinsics.checkNotNullExpressionValue(boolIsIABNonConsumable, "capabilities.isIABNonConsumable");
            List listAccess$filterPurchaseTokensOfNonConsumableProducts = VirtualCurrencyPurchaseGoogleRepository.access$filterPurchaseTokensOfNonConsumableProducts(virtualCurrencyPurchaseGoogleRepository, arrayList, transactions, boolIsIABNonConsumable.booleanValue());
            VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository2 = this.b;
            List list = this.d;
            List<String> transactions2 = purchases.getTransactions();
            Boolean boolIsIABNonConsumable2 = this.b.c.isIABNonConsumable();
            Intrinsics.checkNotNullExpressionValue(boolIsIABNonConsumable2, "capabilities.isIABNonConsumable");
            List listAccess$filterPurchaseTokensOfConsumableProducts = VirtualCurrencyPurchaseGoogleRepository.access$filterPurchaseTokensOfConsumableProducts(virtualCurrencyPurchaseGoogleRepository2, list, transactions2, boolIsIABNonConsumable2.booleanValue());
            VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository3 = this.b;
            NPFBillingClient nPFBillingClient = this.e;
            VirtualCurrencyPurchaseGoogleRepository.access$restoreAcknowledgePurchases(virtualCurrencyPurchaseGoogleRepository3, nPFBillingClient, listAccess$filterPurchaseTokensOfNonConsumableProducts, purchases, new a2(this.f936a, virtualCurrencyPurchaseGoogleRepository3, nPFBillingClient, listAccess$filterPurchaseTokensOfConsumableProducts, purchases));
        }
        return Unit.INSTANCE;
    }
}
