package com.nintendo.npf.sdk.infrastructure.repository;

import android.app.Activity;
import com.android.billingclient.api.Purchase;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchases;
import com.nintendo.npf.sdk.domain.repository.VirtualCurrencyPurchaseRepository;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.infrastructure.api.VirtualCurrencyApi;
import com.nintendo.npf.sdk.infrastructure.helper.VirtualCurrencyHelper;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.internal.model.Capabilities;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyBundle;
import com.nintendo.npf.sdkbilling.d2;
import com.nintendo.npf.sdkbilling.e2;
import com.nintendo.npf.sdkbilling.f1;
import com.nintendo.npf.sdkbilling.g1;
import com.nintendo.npf.sdkbilling.n1;
import com.nintendo.npf.sdkbilling.o1;
import com.nintendo.npf.sdkbilling.p1;
import com.nintendo.npf.sdkbilling.u1;
import com.nintendo.npf.sdkbilling.v1;
import com.nintendo.npf.sdkbilling.w1;
import com.nintendo.npf.sdkbilling.x1;
import com.nintendo.npf.sdkbilling.y1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 (2\u00020\u0001:\u0001(BQ\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012JZ\u0010\"\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172/\u0010!\u001a+\u0012\u0004\u0012\u00020\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020 0\u0019H\u0016¢\u0006\u0004\b\"\u0010#J3\u0010%\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u00132\u001a\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020 0$H\u0016¢\u0006\u0004\b%\u0010&J3\u0010'\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u00132\u001a\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020 0$H\u0016¢\u0006\u0004\b'\u0010&¨\u0006)"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/repository/VirtualCurrencyPurchaseGoogleRepository;", "Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyPurchaseRepository;", "Lcom/nintendo/npf/sdk/infrastructure/helper/VirtualCurrencyHelper;", "helper", "Lkotlin/Function0;", "Landroid/app/Activity;", "activityProvider", "Lcom/nintendo/npf/sdk/internal/model/Capabilities;", "capabilities", "Lcom/nintendo/npf/sdk/infrastructure/api/VirtualCurrencyApi;", "api", "Lcom/nintendo/npf/sdk/infrastructure/repository/OrderCacheRepository;", "orderCacheRepository", "Lcom/nintendo/npf/sdk/internal/billing/NPFBillingClient;", "billingClientFactory", "Lcom/nintendo/npf/sdk/domain/ErrorFactory;", "errorFactory", "<init>", "(Lcom/nintendo/npf/sdk/infrastructure/helper/VirtualCurrencyHelper;Lkotlin/jvm/functions/Function0;Lcom/nintendo/npf/sdk/internal/model/Capabilities;Lkotlin/jvm/functions/Function0;Lcom/nintendo/npf/sdk/infrastructure/repository/OrderCacheRepository;Lkotlin/jvm/functions/Function0;Lcom/nintendo/npf/sdk/domain/ErrorFactory;)V", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "account", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyBundle;", "virtualCurrencyBundle", "", MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASE_PRODUCT_INFO, "Lkotlin/Function3;", "Lcom/nintendo/npf/sdk/domain/model/VirtualCurrencyPurchases;", "", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "purchased", "Lcom/nintendo/npf/sdk/NPFError;", "", "block", "create", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyBundle;Ljava/lang/String;Lkotlin/jvm/functions/Function3;)V", "Lkotlin/Function2;", "recover", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Lkotlin/jvm/functions/Function2;)V", "restore", "Companion", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrencyPurchaseGoogleRepository implements VirtualCurrencyPurchaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VirtualCurrencyHelper f720a;
    public final Function0 b;
    public final Capabilities c;
    public final Function0 d;
    public final OrderCacheRepository e;
    public final Function0 f;
    public final ErrorFactory g;
    public boolean h;
    public boolean i;
    public boolean j;

    public VirtualCurrencyPurchaseGoogleRepository(VirtualCurrencyHelper helper, Function0<? extends Activity> activityProvider, Capabilities capabilities, Function0<VirtualCurrencyApi> api, OrderCacheRepository orderCacheRepository, Function0<NPFBillingClient> billingClientFactory, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(activityProvider, "activityProvider");
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(orderCacheRepository, "orderCacheRepository");
        Intrinsics.checkNotNullParameter(billingClientFactory, "billingClientFactory");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f720a = helper;
        this.b = activityProvider;
        this.c = capabilities;
        this.d = api;
        this.e = orderCacheRepository;
        this.f = billingClientFactory;
        this.g = errorFactory;
    }

    public static final void access$acknowledgePurchases(VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository, NPFBillingClient nPFBillingClient, List list, VirtualCurrencyPurchases virtualCurrencyPurchases, Function2 function2) {
        virtualCurrencyPurchaseGoogleRepository.getClass();
        if (list.isEmpty()) {
            function2.invoke(virtualCurrencyPurchases, null);
        } else {
            nPFBillingClient.acknowledgePurchases(list, new f1(virtualCurrencyPurchaseGoogleRepository, list, function2, virtualCurrencyPurchases));
        }
    }

    public static final void access$consumePurchases(VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository, NPFBillingClient nPFBillingClient, List list, VirtualCurrencyPurchases virtualCurrencyPurchases, Function2 function2) {
        virtualCurrencyPurchaseGoogleRepository.getClass();
        if (list.isEmpty()) {
            function2.invoke(virtualCurrencyPurchases, null);
        } else {
            nPFBillingClient.consumePurchases(list, new g1(virtualCurrencyPurchaseGoogleRepository, list, function2, virtualCurrencyPurchases));
        }
    }

    public static final List access$filterPurchaseTokensOfConsumableProducts(VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository, List list, List list2, boolean z) {
        virtualCurrencyPurchaseGoogleRepository.getClass();
        if (z) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            Purchase purchase = (Purchase) obj;
            if (list2.contains(purchase.getPurchaseToken()) && !virtualCurrencyPurchaseGoogleRepository.f720a.isNonConsumable(purchase)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Purchase) it.next()).getPurchaseToken());
        }
        return arrayList2;
    }

    public static final List access$filterPurchaseTokensOfNonConsumableProducts(VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository, List list, List list2, boolean z) {
        virtualCurrencyPurchaseGoogleRepository.getClass();
        if (z) {
            return list2;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            Purchase purchase = (Purchase) obj;
            if (list2.contains(purchase.getPurchaseToken()) && virtualCurrencyPurchaseGoogleRepository.f720a.isNonConsumable(purchase)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Purchase) it.next()).getPurchaseToken());
        }
        return arrayList2;
    }

    public static final void access$restoreAcknowledgePurchases(VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository, NPFBillingClient nPFBillingClient, List list, VirtualCurrencyPurchases virtualCurrencyPurchases, Function2 function2) {
        virtualCurrencyPurchaseGoogleRepository.getClass();
        if (list.isEmpty()) {
            function2.invoke(virtualCurrencyPurchases, null);
        } else {
            nPFBillingClient.acknowledgePurchases(list, new x1(virtualCurrencyPurchaseGoogleRepository, list, function2, virtualCurrencyPurchases));
        }
    }

    public static final void access$restoreConsumePurchases(VirtualCurrencyPurchaseGoogleRepository virtualCurrencyPurchaseGoogleRepository, NPFBillingClient nPFBillingClient, List list, VirtualCurrencyPurchases virtualCurrencyPurchases, Function2 function2) {
        virtualCurrencyPurchaseGoogleRepository.getClass();
        if (list.isEmpty()) {
            function2.invoke(virtualCurrencyPurchases, null);
        } else {
            nPFBillingClient.consumePurchases(list, new y1(virtualCurrencyPurchaseGoogleRepository, list, function2, virtualCurrencyPurchases));
        }
    }

    @Override // com.nintendo.npf.sdk.domain.repository.VirtualCurrencyPurchaseRepository
    public void create(BaaSUser account, VirtualCurrencyBundle virtualCurrencyBundle, String purchaseProductInfo, Function3<? super VirtualCurrencyPurchases, ? super Boolean, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(virtualCurrencyBundle, "virtualCurrencyBundle");
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.h) {
            block.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), Boolean.FALSE, this.g.create_VirtualCurrency_Purchasing_Minus1());
            return;
        }
        this.h = true;
        NPFError nPFErrorValidateProductInfo = this.f720a.validateProductInfo(purchaseProductInfo);
        if (nPFErrorValidateProductInfo != null) {
            block.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), Boolean.FALSE, nPFErrorValidateProductInfo);
            this.h = false;
        } else {
            NPFBillingClient nPFBillingClient = (NPFBillingClient) this.f.invoke();
            nPFBillingClient.setup(new n1(this, new o1(nPFBillingClient, block, this), nPFBillingClient, virtualCurrencyBundle, purchaseProductInfo, account));
        }
    }

    @Override // com.nintendo.npf.sdk.domain.repository.VirtualCurrencyPurchaseRepository
    public void recover(BaaSUser account, Function2<? super VirtualCurrencyPurchases, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.i) {
            NPFError nPFErrorCreate_VirtualCurrency_Recovering_Minus1 = this.g.create_VirtualCurrency_Recovering_Minus1();
            Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_VirtualCurrency_Recovering_Minus1, "errorFactory.create_Virt…rency_Recovering_Minus1()");
            block.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), nPFErrorCreate_VirtualCurrency_Recovering_Minus1);
        } else {
            this.i = true;
            p1 p1Var = new p1(this, block);
            NPFBillingClient nPFBillingClient = (NPFBillingClient) this.f.invoke();
            nPFBillingClient.setup(new u1(this, nPFBillingClient, account, new v1(nPFBillingClient, p1Var)));
        }
    }

    @Override // com.nintendo.npf.sdk.domain.repository.VirtualCurrencyPurchaseRepository
    public void restore(BaaSUser account, Function2<? super VirtualCurrencyPurchases, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.j) {
            NPFError nPFErrorCreate_VirtualCurrency_Restoring_Minus1 = this.g.create_VirtualCurrency_Restoring_Minus1();
            Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_VirtualCurrency_Restoring_Minus1, "errorFactory.create_Virt…rrency_Restoring_Minus1()");
            block.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), nPFErrorCreate_VirtualCurrency_Restoring_Minus1);
        } else {
            this.j = true;
            w1 w1Var = new w1(this, block);
            NPFBillingClient nPFBillingClient = (NPFBillingClient) this.f.invoke();
            nPFBillingClient.setup(new d2(this, nPFBillingClient, account, new e2(nPFBillingClient, w1Var)));
        }
    }
}
