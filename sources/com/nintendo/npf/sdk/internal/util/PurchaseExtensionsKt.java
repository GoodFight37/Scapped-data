package com.nintendo.npf.sdk.internal.util;

import com.android.billingclient.api.Purchase;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"sku", "", "Lcom/android/billingclient/api/Purchase;", "getSku", "(Lcom/android/billingclient/api/Purchase;)Ljava/lang/String;", "NPFSDKBilling_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PurchaseExtensionsKt {
    public static final String getSku(Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, "<this>");
        ArrayList<String> skus = purchase.getSkus();
        Intrinsics.checkNotNullExpressionValue(skus, "skus");
        Object objFirst = CollectionsKt.first((List<? extends Object>) skus);
        Intrinsics.checkNotNullExpressionValue(objFirst, "<get-sku>");
        return (String) objFirst;
    }
}
