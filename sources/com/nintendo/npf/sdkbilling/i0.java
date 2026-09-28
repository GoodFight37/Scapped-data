package com.nintendo.npf.sdkbilling;

import android.app.Activity;
import com.android.billingclient.api.ProductDetails;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.SubscriptionReplacement;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionPurchaseGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubscriptionPurchaseGoogleRepository f958a;
    public final /* synthetic */ l0 b;
    public final /* synthetic */ SubscriptionReplacement c;
    public final /* synthetic */ NPFBillingClient d;
    public final /* synthetic */ BaaSUser e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(SubscriptionPurchaseGoogleRepository subscriptionPurchaseGoogleRepository, l0 l0Var, SubscriptionReplacement subscriptionReplacement, NPFBillingClient nPFBillingClient, BaaSUser baaSUser) {
        super(2);
        this.f958a = subscriptionPurchaseGoogleRepository;
        this.b = l0Var;
        this.c = subscriptionReplacement;
        this.d = nPFBillingClient;
        this.e = baaSUser;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        List list = (List) obj;
        NPFError nPFError = (NPFError) obj2;
        if (nPFError != null) {
            this.f958a.f712a.reportError("purchase/getProductDetailsList", nPFError);
            this.b.invoke(nPFError);
        } else if (list == null || list.isEmpty()) {
            NPFError nPFErrorCreate_Subscription_ProductNotAvailable_1009 = this.f958a.e.create_Subscription_ProductNotAvailable_1009();
            Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_Subscription_ProductNotAvailable_1009, "errorFactory.create_Subs…roductNotAvailable_1009()");
            this.f958a.f712a.reportError("purchase/getProductDetailsList", nPFErrorCreate_Subscription_ProductNotAvailable_1009);
            this.b.invoke(nPFErrorCreate_Subscription_ProductNotAvailable_1009);
        } else {
            ProductDetails productDetails = (ProductDetails) CollectionsKt.first(list);
            h0 h0Var = new h0(this.f958a, this.b, this.e, this.d);
            if (this.c == null) {
                this.d.initiatePurchaseFlow((Activity) this.f958a.b.invoke(), productDetails, h0Var);
            } else {
                this.d.initiatePurchaseFlow((Activity) this.f958a.b.invoke(), productDetails, this.c.getOriginalOrderId(), this.c.getReplacementMode(), h0Var);
            }
        }
        return Unit.INSTANCE;
    }
}
