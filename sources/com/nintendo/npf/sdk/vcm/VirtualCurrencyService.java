package com.nintendo.npf.sdk.vcm;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0005H&J,\u0010\t\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0005H&J4\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\"\u0010\u0004\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0005H&J,\u0010\u000f\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0005H&J4\u0010\u0011\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\"\u0010\u0004\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0005H&J<\u0010\u0012\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\"\u0010\u0004\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0005H&J,\u0010\u0015\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0005H&J>\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\"\u0010\u0004\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0005H&J,\u0010\u0019\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0005H&J,\u0010\u001a\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0005H&¨\u0006\u001b"}, d2 = {"Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyService;", "", "checkUnprocessedPurchases", "", "block", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyTransaction;", "Lcom/nintendo/npf/sdk/NPFError;", "getBundles", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyBundle;", "getGlobalSummaries", "timezoneOffsetInMinutes", "", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyPurchasedSummary;", "getGlobalWallets", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyWallet;", "getSummaries", "getSummariesByMarket", "marketName", "", "getWallets", "purchase", "virtualCurrencyBundle", MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASE_PRODUCT_INFO, "recoverPurchases", "restorePurchases", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface VirtualCurrencyService {
    void checkUnprocessedPurchases(Function2<? super List<VirtualCurrencyTransaction>, ? super NPFError, Unit> block);

    void getBundles(Function2<? super List<VirtualCurrencyBundle>, ? super NPFError, Unit> block);

    void getGlobalSummaries(int timezoneOffsetInMinutes, Function2<? super List<VirtualCurrencyPurchasedSummary>, ? super NPFError, Unit> block);

    void getGlobalWallets(Function2<? super List<VirtualCurrencyWallet>, ? super NPFError, Unit> block);

    void getSummaries(int timezoneOffsetInMinutes, Function2<? super List<VirtualCurrencyPurchasedSummary>, ? super NPFError, Unit> block);

    void getSummariesByMarket(int timezoneOffsetInMinutes, String marketName, Function2<? super List<VirtualCurrencyPurchasedSummary>, ? super NPFError, Unit> block);

    void getWallets(Function2<? super List<VirtualCurrencyWallet>, ? super NPFError, Unit> block);

    void purchase(VirtualCurrencyBundle virtualCurrencyBundle, String purchaseProductInfo, Function2<? super List<VirtualCurrencyWallet>, ? super NPFError, Unit> block);

    void recoverPurchases(Function2<? super List<VirtualCurrencyWallet>, ? super NPFError, Unit> block);

    void restorePurchases(Function2<? super List<VirtualCurrencyWallet>, ? super NPFError, Unit> block);
}
