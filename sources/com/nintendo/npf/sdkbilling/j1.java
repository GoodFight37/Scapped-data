package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchases;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyPurchaseGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class j1 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o1 f963a;
    public final /* synthetic */ VirtualCurrencyPurchaseGoogleRepository b;
    public final /* synthetic */ List c;
    public final /* synthetic */ NPFBillingClient d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j1(o1 o1Var, VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository, List list, NPFBillingClient nPFBillingClient) {
        super(2);
        this.f963a = o1Var;
        this.b = virtualCurrencyPurchaseGoogleRepository;
        this.c = list;
        this.d = nPFBillingClient;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        VirtualCurrencyPurchases purchases = (VirtualCurrencyPurchases) obj;
        NPFError nPFError = (NPFError) obj2;
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        if (nPFError != null) {
            this.f963a.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), Boolean.TRUE, this.b.f720a.finalizePurchaseError(nPFError));
        } else if (purchases.getTransactions().isEmpty()) {
            this.f963a.invoke(purchases, Boolean.TRUE, null);
        } else {
            VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository = this.b;
            List list = this.c;
            List<String> transactions = purchases.getTransactions();
            Boolean boolIsIABNonConsumable = this.b.c.isIABNonConsumable();
            Intrinsics.checkNotNullExpressionValue(boolIsIABNonConsumable, "capabilities.isIABNonConsumable");
            List listAccess$filterPurchaseTokensOfNonConsumableProducts = VirtualCurrencyPurchaseGoogleRepository.access$filterPurchaseTokensOfNonConsumableProducts(virtualCurrencyPurchaseGoogleRepository, list, transactions, boolIsIABNonConsumable.booleanValue());
            VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository2 = this.b;
            List list2 = this.c;
            List<String> transactions2 = purchases.getTransactions();
            Boolean boolIsIABNonConsumable2 = this.b.c.isIABNonConsumable();
            Intrinsics.checkNotNullExpressionValue(boolIsIABNonConsumable2, "capabilities.isIABNonConsumable");
            List listAccess$filterPurchaseTokensOfConsumableProducts = VirtualCurrencyPurchaseGoogleRepository.access$filterPurchaseTokensOfConsumableProducts(virtualCurrencyPurchaseGoogleRepository2, list2, transactions2, boolIsIABNonConsumable2.booleanValue());
            VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository3 = this.b;
            NPFBillingClient nPFBillingClient = this.d;
            VirtualCurrencyPurchaseGoogleRepository.access$acknowledgePurchases(virtualCurrencyPurchaseGoogleRepository3, nPFBillingClient, listAccess$filterPurchaseTokensOfNonConsumableProducts, purchases, new i1(this.f963a, virtualCurrencyPurchaseGoogleRepository3, nPFBillingClient, listAccess$filterPurchaseTokensOfConsumableProducts, purchases));
        }
        return Unit.INSTANCE;
    }
}
