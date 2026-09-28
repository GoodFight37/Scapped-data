package com.nintendo.npf.sdk.internal.billing;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.PendingPurchasesParams;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.QueryProductDetailsResult;
import com.android.billingclient.api.QueryPurchasesParams;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdkbilling.e;
import com.nintendo.npf.sdkbilling.f;
import com.nintendo.npf.sdkbilling.g;
import com.nintendo.npf.sdkbilling.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 V2\u00020\u0001:\u0001WB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000e\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00042\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\u0013\u0010\u0014JA\u0010\u0019\u001a\u00020\f2\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00152\"\u0010\r\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f0\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ1\u0010\u001c\u001a\u00020\f2\"\u0010\r\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f0\u0017¢\u0006\u0004\b\u001c\u0010\u001dJA\u0010\"\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00182\"\u0010!\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f0\u0017¢\u0006\u0004\b\"\u0010#JQ\u0010\"\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\"\u0010!\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f0\u0017¢\u0006\u0004\b\"\u0010'J;\u0010*\u001a\u00020\f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\u00152\u001e\u0010!\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0)\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b*\u0010+J;\u0010,\u001a\u00020\f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\u00152\u001e\u0010!\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0)\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b,\u0010+J'\u00100\u001a\u00020\f2\u0006\u0010.\u001a\u00020-2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0015H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u0002022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020-H\u0007¢\u0006\u0004\b5\u00106J\u001f\u00108\u001a\u0002072\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0015H\u0007¢\u0006\u0004\b8\u00109J\u0017\u0010;\u001a\u00020:2\u0006\u0010 \u001a\u00020\u0018H\u0007¢\u0006\u0004\b;\u0010<J\u0017\u0010?\u001a\u00020>2\u0006\u0010=\u001a\u00020\u0004H\u0007¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020A2\u0006\u0010=\u001a\u00020\u0004H\u0007¢\u0006\u0004\bB\u0010CJ\u0017\u0010F\u001a\u00020\f2\u0006\u0010E\u001a\u00020DH\u0007¢\u0006\u0004\bF\u0010GJ\u0017\u0010H\u001a\u00020\f2\u0006\u0010E\u001a\u00020DH\u0007¢\u0006\u0004\bH\u0010GR!\u0010N\u001a\u0002028FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\bI\u0010J\u0012\u0004\bM\u0010\u0011\u001a\u0004\bK\u0010LR(\u0010U\u001a\u00020-8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bO\u0010P\u0012\u0004\bT\u0010\u0011\u001a\u0004\bQ\u00106\"\u0004\bR\u0010S¨\u0006X"}, d2 = {"Lcom/nintendo/npf/sdk/internal/billing/NPFBillingClient;", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "Landroid/content/Context;", "context", "", "productType", "Lcom/nintendo/npf/sdk/internal/billing/GoogleBillingErrorFactory;", "errorFactory", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/nintendo/npf/sdk/internal/billing/GoogleBillingErrorFactory;)V", "Lkotlin/Function1;", "Lcom/nintendo/npf/sdk/NPFError;", "", "callback", "setup", "(Lkotlin/jvm/functions/Function1;)V", "teardown", "()V", "featureType", "isFeatureSupported", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "", "productIdList", "Lkotlin/Function2;", "Lcom/android/billingclient/api/ProductDetails;", "getProductDetailsList", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "Lcom/android/billingclient/api/Purchase;", "queryPurchases", "(Lkotlin/jvm/functions/Function2;)V", "Landroid/app/Activity;", "activity", "productDetails", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "initiatePurchaseFlow", "(Landroid/app/Activity;Lcom/android/billingclient/api/ProductDetails;Lkotlin/jvm/functions/Function2;)V", "oldPurchaseToken", "", MapperConstants.SUBSCRIPTION_FIELD_REPLACEMENT_MODE, "(Landroid/app/Activity;Lcom/android/billingclient/api/ProductDetails;Ljava/lang/String;ILkotlin/jvm/functions/Function2;)V", "purchaseTokens", "", "consumePurchases", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "acknowledgePurchases", "Lcom/android/billingclient/api/BillingResult;", "billingResult", "purchases", "onPurchasesUpdated", "(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V", "Lcom/android/billingclient/api/BillingClient;", "createBillingClient", "(Landroid/content/Context;)Lcom/android/billingclient/api/BillingClient;", "createBillingClientResultDisconnected", "()Lcom/android/billingclient/api/BillingResult;", "Lcom/android/billingclient/api/QueryProductDetailsParams;", "createQueryProductDetailsParams", "(Ljava/util/List;)Lcom/android/billingclient/api/QueryProductDetailsParams;", "Lcom/android/billingclient/api/BillingFlowParams;", "createBillingFlowParams", "(Lcom/android/billingclient/api/ProductDetails;)Lcom/android/billingclient/api/BillingFlowParams;", "purchaseToken", "Lcom/android/billingclient/api/ConsumeParams;", "createConsumeParams", "(Ljava/lang/String;)Lcom/android/billingclient/api/ConsumeParams;", "Lcom/android/billingclient/api/AcknowledgePurchaseParams;", "createAcknowledgePurchaseParams", "(Ljava/lang/String;)Lcom/android/billingclient/api/AcknowledgePurchaseParams;", "Ljava/lang/Runnable;", "runnable", "handlerPost", "(Ljava/lang/Runnable;)V", "autoReconnectHandlerPost", "d", "Lkotlin/Lazy;", "getBillingClient", "()Lcom/android/billingclient/api/BillingClient;", "getBillingClient$annotations", "billingClient", "g", "Lcom/android/billingclient/api/BillingResult;", "getBillingClientResult", "setBillingClientResult", "(Lcom/android/billingclient/api/BillingResult;)V", "getBillingClientResult$annotations", "billingClientResult", "Companion", "com/nintendo/npf/sdkbilling/f", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NPFBillingClient implements PurchasesUpdatedListener {
    public static final f Companion = new f();
    public static final Object[] i = {0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f729a;
    public final String b;
    public final GoogleBillingErrorFactory c;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Lazy billingClient;
    public final Handler e;
    public final e f;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public BillingResult billingClientResult;
    public Function2 h;

    public NPFBillingClient(Context context, String productType, GoogleBillingErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f729a = context;
        this.b = productType;
        this.c = errorFactory;
        this.billingClient = LazyKt.lazy(new g(this));
        this.e = new Handler(Looper.getMainLooper());
        this.billingClientResult = createBillingClientResultDisconnected();
        this.f = new e(this, Looper.getMainLooper());
    }

    public static final void a(final NPFBillingClient this$0, final Function1 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.getBillingClient().startConnection(new h(this$0, new Runnable() { // from class: com.nintendo.npf.sdk.internal.billing.NPFBillingClient$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                NPFBillingClient.b(this.f$0, callback);
            }
        }));
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return "NPFBillingClient";
    }

    public static final void b(final NPFBillingClient this$0, final Function1 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.handlerPost(new Runnable() { // from class: com.nintendo.npf.sdk.internal.billing.NPFBillingClient$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                NPFBillingClient.a(callback, this$0);
            }
        });
    }

    public final void acknowledgePurchases(final List<String> purchaseTokens, final Function1<? super Map<String, NPFError>, Unit> listener) {
        Intrinsics.checkNotNullParameter(purchaseTokens, "purchaseTokens");
        Intrinsics.checkNotNullParameter(listener, "listener");
        autoReconnectHandlerPost(new Runnable() { // from class: com.nintendo.npf.sdk.internal.billing.NPFBillingClient$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                NPFBillingClient.a(purchaseTokens, listener, this);
            }
        });
    }

    public final void autoReconnectHandlerPost(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.f.post(runnable);
    }

    public final void consumePurchases(final List<String> purchaseTokens, final Function1<? super Map<String, NPFError>, Unit> listener) {
        Intrinsics.checkNotNullParameter(purchaseTokens, "purchaseTokens");
        Intrinsics.checkNotNullParameter(listener, "listener");
        autoReconnectHandlerPost(new Runnable() { // from class: com.nintendo.npf.sdk.internal.billing.NPFBillingClient$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                NPFBillingClient.b(purchaseTokens, listener, this);
            }
        });
    }

    public final AcknowledgePurchaseParams createAcknowledgePurchaseParams(String purchaseToken) {
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        AcknowledgePurchaseParams acknowledgePurchaseParamsBuild = AcknowledgePurchaseParams.newBuilder().setPurchaseToken(purchaseToken).build();
        Intrinsics.checkNotNullExpressionValue(acknowledgePurchaseParamsBuild, "newBuilder()\n           …ken)\n            .build()");
        return acknowledgePurchaseParamsBuild;
    }

    public final BillingClient createBillingClient(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BillingClient billingClientBuild = BillingClient.newBuilder(context.getApplicationContext()).enablePendingPurchases(PendingPurchasesParams.newBuilder().enableOneTimeProducts().build()).setListener(this).enableAutoServiceReconnection().build();
        Intrinsics.checkNotNullExpressionValue(billingClientBuild, "newBuilder(context.appli…定性向上\n            .build()");
        return billingClientBuild;
    }

    public final BillingResult createBillingClientResultDisconnected() {
        BillingResult billingResultBuild = BillingResult.newBuilder().setResponseCode(-1).setDebugMessage("Disconnected").build();
        Intrinsics.checkNotNullExpressionValue(billingResultBuild, "newBuilder()\n           …ed\")\n            .build()");
        return billingResultBuild;
    }

    public final BillingFlowParams createBillingFlowParams(ProductDetails productDetails) {
        ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails;
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        BillingFlowParams.ProductDetailsParams.Builder productDetails2 = BillingFlowParams.ProductDetailsParams.newBuilder().setProductDetails(productDetails);
        Intrinsics.checkNotNullExpressionValue(productDetails2, "newBuilder()\n           …ctDetails(productDetails)");
        if (Intrinsics.areEqual(this.b, "subs")) {
            List<ProductDetails.SubscriptionOfferDetails> subscriptionOfferDetails2 = productDetails.getSubscriptionOfferDetails();
            String offerToken = (subscriptionOfferDetails2 == null || (subscriptionOfferDetails = (ProductDetails.SubscriptionOfferDetails) CollectionsKt.firstOrNull((List) subscriptionOfferDetails2)) == null) ? null : subscriptionOfferDetails.getOfferToken();
            if (offerToken != null) {
                productDetails2.setOfferToken(offerToken);
            }
        }
        BillingFlowParams billingFlowParamsBuild = BillingFlowParams.newBuilder().setProductDetailsParamsList(CollectionsKt.listOf(productDetails2.build())).setIsOfferPersonalized(false).build();
        Intrinsics.checkNotNullExpressionValue(billingFlowParamsBuild, "newBuilder()\n           …lse)\n            .build()");
        return billingFlowParamsBuild;
    }

    public final ConsumeParams createConsumeParams(String purchaseToken) {
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        ConsumeParams consumeParamsBuild = ConsumeParams.newBuilder().setPurchaseToken(purchaseToken).build();
        Intrinsics.checkNotNullExpressionValue(consumeParamsBuild, "newBuilder()\n           …ken)\n            .build()");
        return consumeParamsBuild;
    }

    public final QueryProductDetailsParams createQueryProductDetailsParams(List<String> productIdList) {
        Intrinsics.checkNotNullParameter(productIdList, "productIdList");
        List listFilterNotNull = CollectionsKt.filterNotNull(productIdList);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listFilterNotNull, 10));
        Iterator it = listFilterNotNull.iterator();
        while (it.hasNext()) {
            arrayList.add(QueryProductDetailsParams.Product.newBuilder().setProductId((String) it.next()).setProductType(this.b).build());
        }
        QueryProductDetailsParams queryProductDetailsParamsBuild = QueryProductDetailsParams.newBuilder().setProductList(arrayList).build();
        Intrinsics.checkNotNullExpressionValue(queryProductDetailsParamsBuild, "newBuilder()\n           …ist)\n            .build()");
        return queryProductDetailsParamsBuild;
    }

    public final BillingClient getBillingClient() {
        return (BillingClient) this.billingClient.getValue();
    }

    public final void getProductDetailsList(final List<String> productIdList, final Function2<? super List<ProductDetails>, ? super NPFError, Unit> callback) {
        Intrinsics.checkNotNullParameter(productIdList, "productIdList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        autoReconnectHandlerPost(new Runnable() { // from class: com.nintendo.npf.sdk.internal.billing.NPFBillingClient$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                NPFBillingClient.a(this.f$0, callback, productIdList);
            }
        });
    }

    public final void handlerPost(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.e.post(runnable);
    }

    public final void initiatePurchaseFlow(final Activity activity, final ProductDetails productDetails, final Function2<? super List<? extends Purchase>, ? super NPFError, Unit> listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        Intrinsics.checkNotNullParameter(listener, "listener");
        autoReconnectHandlerPost(new Runnable() { // from class: com.nintendo.npf.sdk.internal.billing.NPFBillingClient$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                NPFBillingClient.a(this.f$0, listener, productDetails, activity);
            }
        });
    }

    public final void isFeatureSupported(final String featureType, final Function1<? super NPFError, Unit> callback) {
        Intrinsics.checkNotNullParameter(featureType, "featureType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f.post(new Runnable() { // from class: com.nintendo.npf.sdk.internal.billing.NPFBillingClient$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                NPFBillingClient.a(this.f$0, callback, featureType);
            }
        });
    }

    @Override // com.android.billingclient.api.PurchasesUpdatedListener
    public void onPurchasesUpdated(BillingResult billingResult, List<? extends Purchase> purchases) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Function2 function2 = this.h;
        if (function2 != null) {
            function2.invoke(purchases, this.c.createBillingError(billingResult));
        }
    }

    public final void queryPurchases(final Function2<? super List<? extends Purchase>, ? super NPFError, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        autoReconnectHandlerPost(new Runnable() { // from class: com.nintendo.npf.sdk.internal.billing.NPFBillingClient$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NPFBillingClient.a(this.f$0, callback);
            }
        });
    }

    public final void setBillingClientResult(BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "<set-?>");
        this.billingClientResult = billingResult;
    }

    public final void setup(final Function1<? super NPFError, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        handlerPost(new Runnable() { // from class: com.nintendo.npf.sdk.internal.billing.NPFBillingClient$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                NPFBillingClient.a(this.f$0, callback);
            }
        });
    }

    public final void teardown() {
        handlerPost(new Runnable() { // from class: com.nintendo.npf.sdk.internal.billing.NPFBillingClient$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                NPFBillingClient.a(this.f$0);
            }
        });
    }

    public static final void b(List purchaseTokens, final Function1 listener, final NPFBillingClient this$0) {
        Intrinsics.checkNotNullParameter(purchaseTokens, "$purchaseTokens");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (purchaseTokens.isEmpty()) {
            listener.invoke(MapsKt.emptyMap());
            return;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(purchaseTokens.size());
        final HashMap map = new HashMap();
        Iterator it = purchaseTokens.iterator();
        while (it.hasNext()) {
            final String str = (String) it.next();
            this$0.getBillingClient().consumeAsync(this$0.createConsumeParams(str), new ConsumeResponseListener() { // from class: com.nintendo.npf.sdk.internal.billing.NPFBillingClient$$ExternalSyntheticLambda17
                @Override // com.android.billingclient.api.ConsumeResponseListener
                public final void onConsumeResponse(BillingResult billingResult, String str2) {
                    NPFBillingClient.a(this.f$0, atomicInteger, listener, map, str, billingResult, str2);
                }
            });
        }
    }

    public final void initiatePurchaseFlow(final Activity activity, final ProductDetails productDetails, final String oldPurchaseToken, final int replacementMode, final Function2<? super List<? extends Purchase>, ? super NPFError, Unit> listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        Intrinsics.checkNotNullParameter(oldPurchaseToken, "oldPurchaseToken");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f.post(new Runnable() { // from class: com.nintendo.npf.sdk.internal.billing.NPFBillingClient$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                NPFBillingClient.a(this.f$0, listener, oldPurchaseToken, replacementMode, productDetails, activity);
            }
        });
    }

    public static final void a(Function1 callback, NPFBillingClient this$0) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        callback.invoke(this$0.c.createBillingError(this$0.billingClientResult));
    }

    public static final void a(NPFBillingClient this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBillingClient().endConnection();
    }

    public static final void a(NPFBillingClient this$0, Function1 callback, String featureType) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(featureType, "$featureType");
        if (this$0.billingClientResult.getResponseCode() != 0) {
            callback.invoke(this$0.c.createBillingError(this$0.billingClientResult));
            return;
        }
        BillingResult billingResultIsFeatureSupported = this$0.getBillingClient().isFeatureSupported(featureType);
        Intrinsics.checkNotNullExpressionValue(billingResultIsFeatureSupported, "billingClient.isFeatureSupported(featureType)");
        this$0.billingClientResult = billingResultIsFeatureSupported;
        callback.invoke(this$0.c.createBillingError(billingResultIsFeatureSupported));
    }

    public static final void a(final NPFBillingClient this$0, final Function2 callback, List productIdList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(productIdList, "$productIdList");
        if (this$0.billingClientResult.getResponseCode() != 0) {
            callback.invoke(null, this$0.c.createBillingError(this$0.billingClientResult));
        } else {
            this$0.getBillingClient().queryProductDetailsAsync(this$0.createQueryProductDetailsParams(productIdList), new ProductDetailsResponseListener() { // from class: com.nintendo.npf.sdk.internal.billing.NPFBillingClient$$ExternalSyntheticLambda1
                @Override // com.android.billingclient.api.ProductDetailsResponseListener
                public final void onProductDetailsResponse(BillingResult billingResult, QueryProductDetailsResult queryProductDetailsResult) {
                    NPFBillingClient.a(this.f$0, callback, billingResult, queryProductDetailsResult);
                }
            });
        }
    }

    public static final void b(BillingResult billingResult, AtomicInteger lockCounter, Function1 listener, HashMap errors, NPFBillingClient this$0, String purchaseToken) {
        Intrinsics.checkNotNullParameter(billingResult, "$billingResult");
        Intrinsics.checkNotNullParameter(lockCounter, "$lockCounter");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(errors, "$errors");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(purchaseToken, "$purchaseToken");
        if (billingResult.getResponseCode() != 0) {
            synchronized (i) {
                NPFError nPFErrorCreateBillingError = this$0.c.createBillingError(billingResult);
                if (nPFErrorCreateBillingError != null) {
                }
            }
        }
        if (lockCounter.decrementAndGet() == 0) {
            listener.invoke(errors);
        }
    }

    public static final void a(final NPFBillingClient this$0, final Function2 callback, final BillingResult billingResult, final QueryProductDetailsResult productDetailsResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(productDetailsResult, "productDetailsResult");
        this$0.handlerPost(new Runnable() { // from class: com.nintendo.npf.sdk.internal.billing.NPFBillingClient$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                NPFBillingClient.a(productDetailsResult, callback, this$0, billingResult);
            }
        });
    }

    public static final void a(QueryProductDetailsResult productDetailsResult, Function2 callback, NPFBillingClient this$0, BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(productDetailsResult, "$productDetailsResult");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(billingResult, "$billingResult");
        List<ProductDetails> productDetailsList = productDetailsResult.getProductDetailsList();
        Intrinsics.checkNotNullExpressionValue(productDetailsList, "productDetailsResult.productDetailsList");
        callback.invoke(productDetailsList, this$0.c.createBillingError(billingResult));
    }

    public static final void a(final NPFBillingClient this$0, final Function2 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (this$0.billingClientResult.getResponseCode() != 0) {
            callback.invoke(null, this$0.c.createBillingError(this$0.billingClientResult));
        } else {
            this$0.getBillingClient().queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType(this$0.b).build(), new PurchasesResponseListener() { // from class: com.nintendo.npf.sdk.internal.billing.NPFBillingClient$$ExternalSyntheticLambda8
                @Override // com.android.billingclient.api.PurchasesResponseListener
                public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
                    NPFBillingClient.a(this.f$0, callback, billingResult, list);
                }
            });
        }
    }

    public static final void a(final NPFBillingClient this$0, final Function2 callback, final BillingResult billingResult, final List purchasesList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(purchasesList, "purchasesList");
        this$0.handlerPost(new Runnable() { // from class: com.nintendo.npf.sdk.internal.billing.NPFBillingClient$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                NPFBillingClient.a(callback, purchasesList, this$0, billingResult);
            }
        });
    }

    public static final void a(Function2 callback, List purchasesList, NPFBillingClient this$0, BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(purchasesList, "$purchasesList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(billingResult, "$billingResult");
        callback.invoke(purchasesList, this$0.c.createBillingError(billingResult));
    }

    public static final void a(NPFBillingClient this$0, Function2 listener, ProductDetails productDetails, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(productDetails, "$productDetails");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (this$0.billingClientResult.getResponseCode() != 0) {
            listener.invoke(null, this$0.c.createBillingError(this$0.billingClientResult));
            return;
        }
        this$0.h = listener;
        this$0.getBillingClient().launchBillingFlow(activity, this$0.createBillingFlowParams(productDetails));
    }

    public static final void a(NPFBillingClient this$0, Function2 listener, String oldPurchaseToken, int i2, ProductDetails productDetails, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(oldPurchaseToken, "$oldPurchaseToken");
        Intrinsics.checkNotNullParameter(productDetails, "$productDetails");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (this$0.billingClientResult.getResponseCode() != 0) {
            listener.invoke(null, this$0.c.createBillingError(this$0.billingClientResult));
            return;
        }
        this$0.h = listener;
        BillingFlowParams.SubscriptionUpdateParams subscriptionUpdateParamsBuild = BillingFlowParams.SubscriptionUpdateParams.newBuilder().setOldPurchaseToken(oldPurchaseToken).setSubscriptionReplacementMode(i2).build();
        Intrinsics.checkNotNullExpressionValue(subscriptionUpdateParamsBuild, "newBuilder()\n           …\n                .build()");
        BillingFlowParams billingFlowParamsBuild = BillingFlowParams.newBuilder().setProductDetailsParamsList(CollectionsKt.listOf(BillingFlowParams.ProductDetailsParams.newBuilder().setProductDetails(productDetails).build())).setSubscriptionUpdateParams(subscriptionUpdateParamsBuild).setIsOfferPersonalized(false).build();
        Intrinsics.checkNotNullExpressionValue(billingFlowParamsBuild, "newBuilder()\n           …\n                .build()");
        this$0.getBillingClient().launchBillingFlow(activity, billingFlowParamsBuild);
    }

    public static final void a(final NPFBillingClient this$0, final AtomicInteger lockCounter, final Function1 listener, final HashMap errors, final String purchaseToken, final BillingResult billingResult, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(lockCounter, "$lockCounter");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(errors, "$errors");
        Intrinsics.checkNotNullParameter(purchaseToken, "$purchaseToken");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
        this$0.handlerPost(new Runnable() { // from class: com.nintendo.npf.sdk.internal.billing.NPFBillingClient$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                NPFBillingClient.b(billingResult, lockCounter, listener, errors, this$0, purchaseToken);
            }
        });
    }

    public static final void a(List purchaseTokens, final Function1 listener, final NPFBillingClient this$0) {
        Intrinsics.checkNotNullParameter(purchaseTokens, "$purchaseTokens");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (purchaseTokens.isEmpty()) {
            listener.invoke(MapsKt.emptyMap());
            return;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(purchaseTokens.size());
        final HashMap map = new HashMap();
        Iterator it = purchaseTokens.iterator();
        while (it.hasNext()) {
            final String str = (String) it.next();
            this$0.getBillingClient().acknowledgePurchase(this$0.createAcknowledgePurchaseParams(str), new AcknowledgePurchaseResponseListener() { // from class: com.nintendo.npf.sdk.internal.billing.NPFBillingClient$$ExternalSyntheticLambda5
                @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
                public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
                    NPFBillingClient.a(this.f$0, atomicInteger, listener, map, str, billingResult);
                }
            });
        }
    }

    public static final void a(final NPFBillingClient this$0, final AtomicInteger lockCounter, final Function1 listener, final HashMap errors, final String purchaseToken, final BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(lockCounter, "$lockCounter");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(errors, "$errors");
        Intrinsics.checkNotNullParameter(purchaseToken, "$purchaseToken");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        this$0.handlerPost(new Runnable() { // from class: com.nintendo.npf.sdk.internal.billing.NPFBillingClient$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                NPFBillingClient.a(billingResult, lockCounter, listener, errors, this$0, purchaseToken);
            }
        });
    }

    public static final void a(BillingResult billingResult, AtomicInteger lockCounter, Function1 listener, HashMap errors, NPFBillingClient this$0, String purchaseToken) {
        Intrinsics.checkNotNullParameter(billingResult, "$billingResult");
        Intrinsics.checkNotNullParameter(lockCounter, "$lockCounter");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(errors, "$errors");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(purchaseToken, "$purchaseToken");
        if (billingResult.getResponseCode() != 0) {
            synchronized (i) {
                NPFError nPFErrorCreateBillingError = this$0.c.createBillingError(billingResult);
                if (nPFErrorCreateBillingError != null) {
                }
            }
        }
        if (lockCounter.decrementAndGet() == 0) {
            listener.invoke(errors);
        }
    }
}
