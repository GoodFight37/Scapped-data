package com.nintendo.npf.sdk.subscription;

import com.nintendo.npf.sdk.NPFError;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0005H&J,\u0010\t\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0005H&J,\u0010\u000b\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0005H&J,\u0010\r\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0005H&J&\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0011H&J*\u0010\u0012\u001a\u00020\u00032 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0013H&J,\u0010\u0016\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0005H&¨\u0006\u0017"}, d2 = {"Lcom/nintendo/npf/sdk/subscription/SubscriptionService;", "", "checkUnprocessedPurchases", "", "block", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/subscription/SubscriptionTransaction;", "Lcom/nintendo/npf/sdk/NPFError;", "getGlobalPurchases", "Lcom/nintendo/npf/sdk/subscription/SubscriptionPurchase;", "getProducts", "Lcom/nintendo/npf/sdk/subscription/SubscriptionProduct;", "getPurchases", "purchase", "productId", "", "Lkotlin/Function1;", "updateOwnerships", "Lkotlin/Function3;", "", "", "updatePurchases", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SubscriptionService {
    void checkUnprocessedPurchases(Function2<? super List<SubscriptionTransaction>, ? super NPFError, Unit> block);

    void getGlobalPurchases(Function2<? super List<SubscriptionPurchase>, ? super NPFError, Unit> block);

    void getProducts(Function2<? super List<SubscriptionProduct>, ? super NPFError, Unit> block);

    void getPurchases(Function2<? super List<SubscriptionPurchase>, ? super NPFError, Unit> block);

    void purchase(String productId, Function1<? super NPFError, Unit> block);

    void updateOwnerships(Function3<? super Integer, ? super Long, ? super NPFError, Unit> block);

    void updatePurchases(Function2<? super List<SubscriptionPurchase>, ? super NPFError, Unit> block);
}
