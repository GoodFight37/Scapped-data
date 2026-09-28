package com.nintendo.npf.sdk.infrastructure.helper;

import com.android.billingclient.api.Purchase;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.internal.billing.BillingHelper;
import com.nintendo.npf.sdk.internal.util.PurchaseExtensionsKt;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\b\u0016\u0018\u0000 12\u00020\u0001:\u00011B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u000bJ\u0015\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u000bJ?\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00182\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b!\u0010\"J)\u0010'\u001a\u00020&2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b'\u0010(J7\u0010,\u001a\u00020&2\u0006\u0010)\u001a\u00020\u000e2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00182\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020 0\u001a¢\u0006\u0004\b,\u0010-J7\u0010.\u001a\u00020&2\u0006\u0010)\u001a\u00020\u000e2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00182\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020 0\u001a¢\u0006\u0004\b.\u0010-J\u001b\u0010/\u001a\u0004\u0018\u00010 2\b\u0010%\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/helper/VirtualCurrencyHelper;", "", "Lkotlin/Function0;", "Lcom/nintendo/npf/sdk/infrastructure/helper/ReportHelper;", "reportHelperProvider", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/android/billingclient/api/Purchase;", "purchase", "", "isVirtualCurrency", "(Lcom/android/billingclient/api/Purchase;)Z", "isNonConsumable", "isStatePurchased", "", "orderId", "isOrderIdEmpty", "(Ljava/lang/String;)Z", "isIabNonConsumable", "isUnprocessed", "(Lcom/android/billingclient/api/Purchase;Z)Z", "isMultiQuantityPurchased", "packageName", "userId", "", "purchases", "", "Lorg/json/JSONObject;", "cachedOrders", "makeReceipt", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)Lorg/json/JSONObject;", "value", "Lcom/nintendo/npf/sdk/NPFError;", "validateProductInfo", "(Ljava/lang/String;)Lcom/nintendo/npf/sdk/NPFError;", "eventId", "report", "error", "", "reportError", "(Ljava/lang/String;Ljava/lang/String;Lcom/nintendo/npf/sdk/NPFError;)V", "methodName", "purchaseTokens", "errors", "reportPurchaseConsumptionResults", "(Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)V", "reportPurchaseAcknowledgementResults", "finalizePurchaseError", "(Lcom/nintendo/npf/sdk/NPFError;)Lcom/nintendo/npf/sdk/NPFError;", "Companion", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class VirtualCurrencyHelper {
    public static final String FILTER_KEYWORD_NON_CONSUMABLE = ".nonconsumable.";
    public static final String FILTER_KEYWORD_PROMO_CODE = ".promo.";
    public static final String REPORT_EVENT_ID = "virtual_currency_error";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f693a;
    public final ErrorFactory b;
    public static final String c = "VirtualCurrencyHelper";

    public VirtualCurrencyHelper(Function0<ReportHelper> reportHelperProvider) {
        Intrinsics.checkNotNullParameter(reportHelperProvider, "reportHelperProvider");
        this.f693a = reportHelperProvider;
        this.b = new ErrorFactory();
    }

    public static /* synthetic */ void reportError$default(VirtualCurrencyHelper virtualCurrencyHelper, String str, String str2, NPFError nPFError, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportError");
        }
        if ((i & 4) != 0) {
            nPFError = null;
        }
        virtualCurrencyHelper.reportError(str, str2, nPFError);
    }

    public NPFError finalizePurchaseError(NPFError error) {
        if (error == null) {
            return null;
        }
        return error.getErrorType() == NPFError.ErrorType.NETWORK_ERROR ? error.copy(NPFError.ErrorType.NPF_ERROR, 2053, "Purchase completed, but a subsequent network error occurred") : error;
    }

    public final boolean isMultiQuantityPurchased(Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        return purchase.getQuantity() > 1;
    }

    public final boolean isNonConsumable(Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        return StringsKt.contains$default((CharSequence) PurchaseExtensionsKt.getSku(purchase), (CharSequence) FILTER_KEYWORD_NON_CONSUMABLE, false, 2, (Object) null);
    }

    public final boolean isOrderIdEmpty(String orderId) {
        return orderId != null && orderId.length() == 0;
    }

    public final boolean isStatePurchased(Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        return 1 == purchase.getPurchaseState();
    }

    public final boolean isUnprocessed(Purchase purchase, boolean isIabNonConsumable) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        return ((isIabNonConsumable || isNonConsumable(purchase)) && purchase.isAcknowledged()) ? false : true;
    }

    public final boolean isVirtualCurrency(Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        return !StringsKt.contains$default((CharSequence) PurchaseExtensionsKt.getSku(purchase), (CharSequence) FILTER_KEYWORD_PROMO_CODE, false, 2, (Object) null);
    }

    public final JSONObject makeReceipt(String packageName, String userId, List<? extends Purchase> purchases, Map<String, ? extends JSONObject> cachedOrders) {
        Map<String, ? extends JSONObject> cachedOrders2 = cachedOrders;
        String str = "packageName";
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(userId, "userId");
        String str2 = "purchases";
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        Intrinsics.checkNotNullParameter(cachedOrders2, "cachedOrders");
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            Iterator<? extends Purchase> it = purchases.iterator();
            while (it.hasNext()) {
                Purchase next = it.next();
                JSONObject jSONObject2 = new JSONObject();
                Iterator<? extends Purchase> it2 = it;
                jSONObject2.put("purchaseToken", next.getPurchaseToken());
                jSONObject2.put(str, next.getPackageName());
                jSONObject2.put("productId", PurchaseExtensionsKt.getSku(next));
                String orderId = next.getOrderId();
                if (orderId == null) {
                    orderId = "";
                }
                jSONObject2.put("orderId", orderId);
                JSONObject jSONObject3 = cachedOrders2.get(PurchaseExtensionsKt.getSku(next));
                if (jSONObject3 != null) {
                    String string = jSONObject3.getString("sku");
                    Intrinsics.checkNotNullExpressionValue(string, "cachedOrder.getString(Ma…RTUAL_CURRENCY_FIELD_SKU)");
                    String string2 = jSONObject3.getString(MapperConstants.VIRTUAL_CURRENCY_FIELD_PRICE_CODE);
                    String string3 = jSONObject3.getString("price");
                    String string4 = jSONObject3.getString(MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASE_PRODUCT_INFO);
                    String string5 = jSONObject3.getString("customAttribute");
                    BigDecimal bigDecimal = string3 != null ? new BigDecimal(string3) : null;
                    jSONObject3.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_DIGEST, BillingHelper.getDigest(userId, packageName, string, string2, bigDecimal));
                    if (string4 != null) {
                        jSONObject2.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASE_PRODUCT_INFO, string4);
                    }
                    if (string2 != null) {
                        jSONObject2.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_PRICE_CODE, string2);
                    }
                    if (bigDecimal != null) {
                        jSONObject2.put("price", bigDecimal);
                    }
                    if (string5 != null) {
                        jSONObject2.put("customAttribute", string5);
                    }
                    jSONArray2.put(jSONObject3);
                } else {
                    str2 = str2;
                }
                jSONArray.put(jSONObject2);
                it = it2;
                cachedOrders2 = cachedOrders;
                str = str;
                jSONObject = jSONObject;
                str2 = str2;
            }
            JSONObject jSONObject4 = jSONObject;
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_ORDERS, jSONArray2);
            jSONObject5.put(str2, jSONArray);
            jSONObject4.put("type", "purchase");
            jSONObject4.put("extras", jSONObject5);
            return jSONObject4;
        } catch (JSONException e) {
            SDKLog.e(c, "Failed making request JSON object", e);
            throw new IllegalArgumentException(e);
        }
    }

    public final void reportError(String eventId, String report, NPFError error) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(report, "report");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("report", report);
            if (error != null) {
                jSONObject.put("errorType", error.getErrorType().getInt());
                jSONObject.put("errorCode", error.getErrorCode());
                jSONObject.put("errorMessage", error.getErrorMessage());
            }
            ((ReportHelper) this.f693a.invoke()).reportEvent("NPFAUDIT", eventId, null, jSONObject);
        } catch (JSONException unused) {
        }
    }

    public final void reportPurchaseAcknowledgementResults(String methodName, List<String> purchaseTokens, Map<String, NPFError> errors) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(purchaseTokens, "purchaseTokens");
        Intrinsics.checkNotNullParameter(errors, "errors");
        for (String str : purchaseTokens) {
            NPFError nPFError = errors.get(str);
            int errorCode = nPFError != null ? nPFError.getErrorCode() : 0;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str2 = String.format(Locale.US, "%s#%s#result response_code: %d purchaseToken: %s", Arrays.copyOf(new Object[]{methodName, "acknowledgePurchase", Integer.valueOf(errorCode), str}, 4));
            Intrinsics.checkNotNullExpressionValue(str2, "format(locale, format, *args)");
            reportError("close_receipt_response", str2, nPFError);
        }
    }

    public final void reportPurchaseConsumptionResults(String methodName, List<String> purchaseTokens, Map<String, NPFError> errors) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(purchaseTokens, "purchaseTokens");
        Intrinsics.checkNotNullParameter(errors, "errors");
        for (String str : purchaseTokens) {
            NPFError nPFError = errors.get(str);
            int errorCode = nPFError != null ? nPFError.getErrorCode() : 0;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str2 = String.format(Locale.US, "%s#%s#result response_code: %d purchaseToken: %s", Arrays.copyOf(new Object[]{methodName, "consumePurchase", Integer.valueOf(errorCode), str}, 4));
            Intrinsics.checkNotNullExpressionValue(str2, "format(locale, format, *args)");
            reportError("close_receipt_response", str2, nPFError);
        }
    }

    public final NPFError validateProductInfo(String value) {
        if (value == null) {
            return null;
        }
        if (!Pattern.matches("^[a-zA-Z0-9_\\.]+$", value) || value.length() > 255) {
            return this.b.create_VirtualCurrency_InvalidProductInfo_0();
        }
        return null;
    }
}
