package com.nintendo.npf.sdk.infrastructure.repository;

import android.app.Activity;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.model.SubscriptionReplacement;
import com.nintendo.npf.sdk.domain.repository.SubscriptionPurchaseRepository;
import com.nintendo.npf.sdk.infrastructure.api.SubscriptionApi;
import com.nintendo.npf.sdk.infrastructure.helper.SubscriptionHelper;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.subscription.SubscriptionPurchase;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdkbilling.k0;
import com.nintendo.npf.sdkbilling.l0;
import com.nintendo.npf.sdkbilling.q0;
import com.nintendo.npf.sdkbilling.r0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ9\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2 \u0010\u0016\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00150\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J9\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2 \u0010\u0016\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00150\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J?\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0014\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00150\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J9\u0010!\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2 \u0010\u0016\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00150\u0011H\u0016¢\u0006\u0004\b!\u0010\u0018¨\u0006\""}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/repository/SubscriptionPurchaseGoogleRepository;", "Lcom/nintendo/npf/sdk/domain/repository/SubscriptionPurchaseRepository;", "Lcom/nintendo/npf/sdk/infrastructure/helper/SubscriptionHelper;", "helper", "Lkotlin/Function0;", "Landroid/app/Activity;", "activityProvider", "Lcom/nintendo/npf/sdk/infrastructure/api/SubscriptionApi;", "api", "Lcom/nintendo/npf/sdk/internal/billing/NPFBillingClient;", "billingClientFactory", "Lcom/nintendo/npf/sdk/domain/ErrorFactory;", "errorFactory", "<init>", "(Lcom/nintendo/npf/sdk/infrastructure/helper/SubscriptionHelper;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/nintendo/npf/sdk/domain/ErrorFactory;)V", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "account", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/subscription/SubscriptionPurchase;", "Lcom/nintendo/npf/sdk/NPFError;", "", "block", "find", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Lkotlin/jvm/functions/Function2;)V", "findGlobal", "", "productId", "Lcom/nintendo/npf/sdk/domain/model/SubscriptionReplacement;", "replacement", "Lkotlin/Function1;", "create", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Ljava/lang/String;Lcom/nintendo/npf/sdk/domain/model/SubscriptionReplacement;Lkotlin/jvm/functions/Function1;)V", "update", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SubscriptionPurchaseGoogleRepository implements SubscriptionPurchaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SubscriptionHelper f712a;
    public final Function0 b;
    public final Function0 c;
    public final Function0 d;
    public final ErrorFactory e;

    public SubscriptionPurchaseGoogleRepository(SubscriptionHelper helper, Function0<? extends Activity> activityProvider, Function0<SubscriptionApi> api, Function0<NPFBillingClient> billingClientFactory, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(activityProvider, "activityProvider");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(billingClientFactory, "billingClientFactory");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f712a = helper;
        this.b = activityProvider;
        this.c = api;
        this.d = billingClientFactory;
        this.e = errorFactory;
    }

    @Override // com.nintendo.npf.sdk.domain.repository.SubscriptionPurchaseRepository
    public void create(BaaSUser account, String productId, SubscriptionReplacement replacement, Function1<? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(block, "block");
        NPFBillingClient nPFBillingClient = (NPFBillingClient) this.d.invoke();
        nPFBillingClient.setup(new k0(this, new l0(nPFBillingClient, block), nPFBillingClient, productId, replacement, account));
    }

    @Override // com.nintendo.npf.sdk.domain.repository.SubscriptionPurchaseRepository
    public void find(BaaSUser account, Function2<? super List<SubscriptionPurchase>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(block, "block");
        ((SubscriptionApi) this.c.invoke()).getPurchases(account, "GOOGLE", block);
    }

    @Override // com.nintendo.npf.sdk.domain.repository.SubscriptionPurchaseRepository
    public void findGlobal(BaaSUser account, Function2<? super List<SubscriptionPurchase>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(block, "block");
        ((SubscriptionApi) this.c.invoke()).getGlobalPurchases(account, "GOOGLE", block);
    }

    @Override // com.nintendo.npf.sdk.domain.repository.SubscriptionPurchaseRepository
    public void update(BaaSUser account, Function2<? super List<SubscriptionPurchase>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(block, "block");
        NPFBillingClient nPFBillingClient = (NPFBillingClient) this.d.invoke();
        nPFBillingClient.setup(new q0(this, nPFBillingClient, account, new r0(nPFBillingClient, block)));
    }
}
