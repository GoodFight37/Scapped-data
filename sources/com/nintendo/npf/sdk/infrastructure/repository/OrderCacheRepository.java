package com.nintendo.npf.sdk.infrastructure.repository;

import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H&J8\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H&¨\u0006\u0010"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/repository/OrderCacheRepository;", "", "find", "", "", "Lorg/json/JSONObject;", "productIds", "", "update", "", "sku", "price", "Ljava/math/BigDecimal;", MapperConstants.VIRTUAL_CURRENCY_FIELD_PRICE_CODE, "customAttribute", MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASE_PRODUCT_INFO, "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface OrderCacheRepository {
    Map<String, JSONObject> find(List<String> productIds);

    boolean update(String sku, BigDecimal price, String priceCode, String customAttribute, String purchaseProductInfo);
}
