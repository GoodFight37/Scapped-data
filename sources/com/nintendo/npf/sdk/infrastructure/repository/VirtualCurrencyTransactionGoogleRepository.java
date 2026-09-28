package com.nintendo.npf.sdk.infrastructure.repository;

import com.android.billingclient.api.Purchase;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.repository.VirtualCurrencyTransactionRepository;
import com.nintendo.npf.sdk.infrastructure.api.VirtualCurrencyApi;
import com.nintendo.npf.sdk.infrastructure.helper.VirtualCurrencyHelper;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.internal.model.Capabilities;
import com.nintendo.npf.sdk.internal.util.PurchaseExtensionsKt;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyTransaction;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyTransactionState;
import com.nintendo.npf.sdkbilling.c;
import com.nintendo.npf.sdkbilling.i2;
import com.nintendo.npf.sdkbilling.j2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ9\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2 \u0010\u0016\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00150\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/repository/VirtualCurrencyTransactionGoogleRepository;", "Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyTransactionRepository;", "Lcom/nintendo/npf/sdk/infrastructure/helper/VirtualCurrencyHelper;", "helper", "Lcom/nintendo/npf/sdk/internal/model/Capabilities;", "capabilities", "Lkotlin/Function0;", "Lcom/nintendo/npf/sdk/infrastructure/api/VirtualCurrencyApi;", "api", "Lcom/nintendo/npf/sdk/internal/billing/NPFBillingClient;", "billingClientFactory", "Lcom/nintendo/npf/sdk/domain/ErrorFactory;", "errorFactory", "<init>", "(Lcom/nintendo/npf/sdk/infrastructure/helper/VirtualCurrencyHelper;Lcom/nintendo/npf/sdk/internal/model/Capabilities;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/nintendo/npf/sdk/domain/ErrorFactory;)V", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "account", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyTransaction;", "Lcom/nintendo/npf/sdk/NPFError;", "", "block", "findUnprocessedList", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Lkotlin/jvm/functions/Function2;)V", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrencyTransactionGoogleRepository implements VirtualCurrencyTransactionRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VirtualCurrencyHelper f723a;
    public final Capabilities b;
    public final Function0 c;
    public final Function0 d;
    public final ErrorFactory e;

    public VirtualCurrencyTransactionGoogleRepository(VirtualCurrencyHelper helper, Capabilities capabilities, Function0<VirtualCurrencyApi> api, Function0<NPFBillingClient> billingClientFactory, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(billingClientFactory, "billingClientFactory");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f723a = helper;
        this.b = capabilities;
        this.c = api;
        this.d = billingClientFactory;
        this.e = errorFactory;
    }

    public static final List access$createTransactions(VirtualCurrencyTransactionGoogleRepository virtualCurrencyTransactionGoogleRepository, List list, Set set) {
        VirtualCurrencyTransactionState virtualCurrencyTransactionState;
        virtualCurrencyTransactionGoogleRepository.getClass();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Purchase purchase = (Purchase) it.next();
            String orderId = purchase.getOrderId();
            if (orderId == null && purchase.getPurchaseState() == 1) {
                String purchaseToken = purchase.getPurchaseToken();
                Intrinsics.checkNotNullExpressionValue(purchaseToken, "purchase.purchaseToken");
                orderId = c.a(purchaseToken);
            }
            String sku = PurchaseExtensionsKt.getSku(purchase);
            if (purchase.getPurchaseState() == 1) {
                virtualCurrencyTransactionState = (set == null || !CollectionsKt.contains(set, orderId)) ? VirtualCurrencyTransactionState.PURCHASED : VirtualCurrencyTransactionState.REGISTERED;
            } else {
                virtualCurrencyTransactionState = VirtualCurrencyTransactionState.PENDING;
            }
            arrayList.add(new VirtualCurrencyTransaction(orderId, sku, virtualCurrencyTransactionState));
        }
        return arrayList;
    }

    @Override // com.nintendo.npf.sdk.domain.repository.VirtualCurrencyTransactionRepository
    public void findUnprocessedList(BaaSUser account, Function2<? super List<VirtualCurrencyTransaction>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(block, "block");
        NPFBillingClient nPFBillingClient = (NPFBillingClient) this.d.invoke();
        nPFBillingClient.setup(new i2(this, new j2(nPFBillingClient, block), nPFBillingClient, account));
    }
}
