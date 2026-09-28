package com.nintendo.npf.sdk.infrastructure.repository;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchases;
import com.nintendo.npf.sdk.domain.repository.VirtualCurrencyPurchaseRepository;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.infrastructure.api.VirtualCurrencyApi;
import com.nintendo.npf.sdk.infrastructure.helper.VirtualCurrencyHelper;
import com.nintendo.npf.sdk.internal.billing.BillingHelper;
import com.nintendo.npf.sdk.internal.model.Capabilities;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyBundle;
import com.nintendo.npf.sdkbilling.f2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJZ\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132/\u0010\u001d\u001a+\u0012\u0004\u0012\u00020\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0004\u0012\u00020\u001c0\u0015H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ3\u0010!\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000f2\u001a\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0004\u0012\u00020\u001c0 H\u0016¢\u0006\u0004\b!\u0010\"J3\u0010#\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000f2\u001a\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0004\u0012\u00020\u001c0 H\u0016¢\u0006\u0004\b#\u0010\"¨\u0006%"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/repository/VirtualCurrencyPurchaseMockRepository;", "Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyPurchaseRepository;", "Lcom/nintendo/npf/sdk/infrastructure/helper/VirtualCurrencyHelper;", "helper", "Lcom/nintendo/npf/sdk/internal/model/Capabilities;", "capabilities", "Lkotlin/Function0;", "Lcom/nintendo/npf/sdk/infrastructure/api/VirtualCurrencyApi;", "api", "Lcom/nintendo/npf/sdk/infrastructure/repository/OrderCacheRepository;", "orderCacheRepository", "Lcom/nintendo/npf/sdk/domain/ErrorFactory;", "errorFactory", "<init>", "(Lcom/nintendo/npf/sdk/infrastructure/helper/VirtualCurrencyHelper;Lcom/nintendo/npf/sdk/internal/model/Capabilities;Lkotlin/jvm/functions/Function0;Lcom/nintendo/npf/sdk/infrastructure/repository/OrderCacheRepository;Lcom/nintendo/npf/sdk/domain/ErrorFactory;)V", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "account", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyBundle;", "virtualCurrencyBundle", "", MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASE_PRODUCT_INFO, "Lkotlin/Function3;", "Lcom/nintendo/npf/sdk/domain/model/VirtualCurrencyPurchases;", "", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "purchased", "Lcom/nintendo/npf/sdk/NPFError;", "", "block", "create", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyBundle;Ljava/lang/String;Lkotlin/jvm/functions/Function3;)V", "Lkotlin/Function2;", "recover", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Lkotlin/jvm/functions/Function2;)V", "restore", "Companion", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrencyPurchaseMockRepository implements VirtualCurrencyPurchaseRepository {
    public static final String f = "VirtualCurrencyPurchaseMockRepository";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VirtualCurrencyHelper f721a;
    public final Capabilities b;
    public final Function0 c;
    public final OrderCacheRepository d;
    public final ErrorFactory e;

    public VirtualCurrencyPurchaseMockRepository(VirtualCurrencyHelper helper, Capabilities capabilities, Function0<VirtualCurrencyApi> api, OrderCacheRepository orderCacheRepository, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(orderCacheRepository, "orderCacheRepository");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f721a = helper;
        this.b = capabilities;
        this.c = api;
        this.d = orderCacheRepository;
        this.e = errorFactory;
    }

    @Override // com.nintendo.npf.sdk.domain.repository.VirtualCurrencyPurchaseRepository
    public void create(BaaSUser account, VirtualCurrencyBundle virtualCurrencyBundle, String purchaseProductInfo, Function3<? super VirtualCurrencyPurchases, ? super Boolean, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(virtualCurrencyBundle, "virtualCurrencyBundle");
        Intrinsics.checkNotNullParameter(block, "block");
        NPFError nPFErrorValidateProductInfo = this.f721a.validateProductInfo(purchaseProductInfo);
        if (nPFErrorValidateProductInfo != null) {
            block.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), Boolean.FALSE, nPFErrorValidateProductInfo);
            return;
        }
        this.d.update(virtualCurrencyBundle.getSku(), virtualCurrencyBundle.getPrice(), virtualCurrencyBundle.getPriceCode(), virtualCurrencyBundle.getCustomAttribute(), purchaseProductInfo);
        String userId = account.getUserId();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = this.d.find(CollectionsKt.listOf(virtualCurrencyBundle.getSku())).get(virtualCurrencyBundle.getSku());
            if (jSONObject2 != null) {
                String packageName = this.b.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "capabilities.packageName");
                jSONObject2.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_DIGEST, BillingHelper.getDigest(userId, packageName, virtualCurrencyBundle.getSku(), virtualCurrencyBundle.getPriceCode(), virtualCurrencyBundle.getPrice()));
                jSONArray.put(jSONObject2);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_ORDERS, jSONArray);
            jSONObject3.put("purchases", new JSONArray());
            jSONObject.put("type", "purchase");
            jSONObject.put("extras", jSONObject3);
            ((VirtualCurrencyApi) this.c.invoke()).createPurchases(account, BillingHelper.getMarket(), jSONObject, new f2(block));
        } catch (JSONException e) {
            SDKLog.e(f, "Failed making receipt", e);
            throw new IllegalArgumentException(e);
        }
    }

    @Override // com.nintendo.npf.sdk.domain.repository.VirtualCurrencyPurchaseRepository
    public void recover(BaaSUser account, Function2<? super VirtualCurrencyPurchases, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), this.e.create_VirtualCurrency_NoPurchaseToRecoverOrRestore_404());
    }

    @Override // com.nintendo.npf.sdk.domain.repository.VirtualCurrencyPurchaseRepository
    public void restore(BaaSUser account, Function2<? super VirtualCurrencyPurchases, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), this.e.create_VirtualCurrency_NoPurchaseToRecoverOrRestore_404());
    }
}
