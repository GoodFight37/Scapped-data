package com.nintendo.npf.sdk.infrastructure.helper;

import com.android.billingclient.api.Purchase;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.internal.util.PurchaseExtensionsKt;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.subscription.SubscriptionProduct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001%B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u000eJ\u001d\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001a\u0010\u001eJ7\u0010#\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00152\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00170!¢\u0006\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/helper/SubscriptionHelper;", "", "Lkotlin/Function0;", "Lcom/nintendo/npf/sdk/infrastructure/helper/ReportHelper;", "reportHelperProvider", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/nintendo/npf/sdk/subscription/SubscriptionProduct;", "product", "", "isSubscription", "(Lcom/nintendo/npf/sdk/subscription/SubscriptionProduct;)Z", "Lcom/android/billingclient/api/Purchase;", "purchase", "(Lcom/android/billingclient/api/Purchase;)Z", "isStatePurchased", "", "purchases", "Lorg/json/JSONObject;", "makeReceipt", "(Ljava/util/List;)Lorg/json/JSONObject;", "", "origin", "Lcom/nintendo/npf/sdk/NPFError;", "error", "", "reportError", "(Ljava/lang/String;Lcom/nintendo/npf/sdk/NPFError;)V", "eventId", "report", "(Ljava/lang/String;Ljava/lang/String;Lcom/nintendo/npf/sdk/NPFError;)V", "methodName", "purchaseTokens", "", "errors", "reportPurchaseAcknowledgementResults", "(Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)V", "Companion", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SubscriptionHelper {
    public static final String FILTER_KEYWORD_SUBSCRIPTION = ".subs.";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f692a;
    public static final String b = "SubscriptionHelper";

    public SubscriptionHelper(Function0<ReportHelper> reportHelperProvider) {
        Intrinsics.checkNotNullParameter(reportHelperProvider, "reportHelperProvider");
        this.f692a = reportHelperProvider;
    }

    public static /* synthetic */ void reportError$default(SubscriptionHelper subscriptionHelper, String str, String str2, NPFError nPFError, int i, Object obj) {
        if ((i & 4) != 0) {
            nPFError = null;
        }
        subscriptionHelper.reportError(str, str2, nPFError);
    }

    public final boolean isStatePurchased(Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        return 1 == purchase.getPurchaseState();
    }

    public final boolean isSubscription(SubscriptionProduct product) {
        Intrinsics.checkNotNullParameter(product, "product");
        return StringsKt.contains$default((CharSequence) product.getProductId(), (CharSequence) FILTER_KEYWORD_SUBSCRIPTION, false, 2, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0052 A[Catch: JSONException -> 0x005d, TryCatch #0 {JSONException -> 0x005d, blocks: (B:4:0x0007, B:5:0x0016, B:7:0x001c, B:8:0x0046, B:10:0x004c, B:12:0x0057, B:11:0x0052), top: B:17:0x0007 }] */
    public final JSONObject makeReceipt(List<? extends Purchase> purchases) {
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        if (purchases != null) {
            try {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(purchases, 10));
                for (Purchase purchase : purchases) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("purchaseToken", purchase.getPurchaseToken());
                    jSONObject2.put("packageName", purchase.getPackageName());
                    jSONObject2.put("productId", PurchaseExtensionsKt.getSku(purchase));
                    arrayList.add(jSONObject2);
                }
                List list = CollectionsKt.toList(arrayList);
                if (list != null) {
                    jSONArray = new JSONArray((Collection) list);
                } else {
                    jSONArray = new JSONArray();
                }
            } catch (JSONException e) {
                SDKLog.e(b, "makeReceipt", e);
                return jSONObject;
            }
        } else {
            jSONArray = new JSONArray();
        }
        jSONObject.put("purchases", jSONArray);
        return jSONObject;
    }

    public final void reportError(String origin, NPFError error) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(error, "error");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("origin", origin);
            jSONObject.put("type", error.getErrorType().getInt());
            jSONObject.put("code", error.getErrorCode());
            jSONObject.put(MapperConstants.NPF_ERROR_FIELD_MESSAGE, error.getErrorMessage());
            ((ReportHelper) this.f692a.invoke()).reportEvent("NPFAUDIT", "subs", null, jSONObject);
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

    public final boolean isSubscription(Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        return StringsKt.contains$default((CharSequence) PurchaseExtensionsKt.getSku(purchase), (CharSequence) FILTER_KEYWORD_SUBSCRIPTION, false, 2, (Object) null);
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
            ((ReportHelper) this.f692a.invoke()).reportEvent("NPFAUDIT", eventId, null, jSONObject);
        } catch (JSONException unused) {
        }
    }
}
