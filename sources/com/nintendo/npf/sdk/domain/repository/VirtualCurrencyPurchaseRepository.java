package com.nintendo.npf.sdk.domain.repository;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchases;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyBundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JS\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2/\u0010\n\u001a+\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00030\u000bH&J,\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00030\u0013H&J,\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00030\u0013H&¨\u0006\u0015"}, d2 = {"Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyPurchaseRepository;", "", "create", "", "account", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "virtualCurrencyBundle", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyBundle;", MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASE_PRODUCT_INFO, "", "block", "Lkotlin/Function3;", "Lcom/nintendo/npf/sdk/domain/model/VirtualCurrencyPurchases;", "", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "purchased", "Lcom/nintendo/npf/sdk/NPFError;", "recover", "Lkotlin/Function2;", "restore", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface VirtualCurrencyPurchaseRepository {
    void create(BaaSUser account, VirtualCurrencyBundle virtualCurrencyBundle, String purchaseProductInfo, Function3<? super VirtualCurrencyPurchases, ? super Boolean, ? super NPFError, Unit> block);

    void recover(BaaSUser account, Function2<? super VirtualCurrencyPurchases, ? super NPFError, Unit> block);

    void restore(BaaSUser account, Function2<? super VirtualCurrencyPurchases, ? super NPFError, Unit> block);
}
