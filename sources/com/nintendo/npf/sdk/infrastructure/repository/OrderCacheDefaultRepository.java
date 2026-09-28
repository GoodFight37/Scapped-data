package com.nintendo.npf.sdk.infrastructure.repository;

import android.app.Application;
import android.content.SharedPreferences;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ?\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/repository/OrderCacheDefaultRepository;", "Lcom/nintendo/npf/sdk/infrastructure/repository/OrderCacheRepository;", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "", "", "productIds", "", "Lorg/json/JSONObject;", "find", "(Ljava/util/List;)Ljava/util/Map;", "sku", "Ljava/math/BigDecimal;", "price", MapperConstants.VIRTUAL_CURRENCY_FIELD_PRICE_CODE, "customAttribute", MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASE_PRODUCT_INFO, "", "update", "(Ljava/lang/String;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "a", "Landroid/app/Application;", "Companion", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OrderCacheDefaultRepository implements OrderCacheRepository {
    private static final String b = "OrderCacheDefaultRepository";

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Application application;

    public OrderCacheDefaultRepository(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
    }

    @Override // com.nintendo.npf.sdk.infrastructure.repository.OrderCacheRepository
    public Map<String, JSONObject> find(List<String> productIds) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        SharedPreferences sharedPreferences = this.application.getSharedPreferences("transactionData", 0);
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : productIds) {
            if (sharedPreferences.contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            Pair pair = null;
            try {
                pair = TuplesKt.to(str, new JSONObject(sharedPreferences.getString(str, null)));
            } catch (JSONException unused) {
            }
            if (pair != null) {
                arrayList2.add(pair);
            }
        }
        return MapsKt.toMap(arrayList2);
    }

    @Override // com.nintendo.npf.sdk.infrastructure.repository.OrderCacheRepository
    public boolean update(String sku, BigDecimal price, String priceCode, String customAttribute, String purchaseProductInfo) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        SharedPreferences.Editor editorEdit = this.application.getSharedPreferences("transactionData", 0).edit();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sku", sku);
            Object obj = price;
            if (price == null) {
                obj = JSONObject.NULL;
            }
            jSONObject.put("price", obj);
            Object obj2 = priceCode;
            if (priceCode == null) {
                obj2 = JSONObject.NULL;
            }
            jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_PRICE_CODE, obj2);
            Object obj3 = customAttribute;
            if (customAttribute == null) {
                obj3 = JSONObject.NULL;
            }
            jSONObject.put("customAttribute", obj3);
            Object obj4 = purchaseProductInfo;
            if (purchaseProductInfo == null) {
                obj4 = JSONObject.NULL;
            }
            jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASE_PRODUCT_INFO, obj4);
            editorEdit.putString(sku, jSONObject.toString());
            editorEdit.apply();
            return true;
        } catch (JSONException e) {
            SDKLog.e(b, e.getMessage());
            return false;
        }
    }
}
