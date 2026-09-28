package com.nintendo.npf.sdk.infrastructure.repository;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.SubscriptionOwnership;
import com.nintendo.npf.sdk.domain.repository.SubscriptionOwnershipRepository;
import com.nintendo.npf.sdk.infrastructure.api.SubscriptionApi;
import com.nintendo.npf.sdk.infrastructure.helper.SubscriptionHelper;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdkbilling.y;
import com.nintendo.npf.sdkbilling.z;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\t\u0010\nJ3\u0010\u0012\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00100\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/repository/SubscriptionOwnershipGoogleRepository;", "Lcom/nintendo/npf/sdk/domain/repository/SubscriptionOwnershipRepository;", "Lcom/nintendo/npf/sdk/infrastructure/helper/SubscriptionHelper;", "helper", "Lkotlin/Function0;", "Lcom/nintendo/npf/sdk/infrastructure/api/SubscriptionApi;", "api", "Lcom/nintendo/npf/sdk/internal/billing/NPFBillingClient;", "billingClientFactory", "<init>", "(Lcom/nintendo/npf/sdk/infrastructure/helper/SubscriptionHelper;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "account", "Lkotlin/Function2;", "Lcom/nintendo/npf/sdk/domain/model/SubscriptionOwnership;", "Lcom/nintendo/npf/sdk/NPFError;", "", "block", "update", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Lkotlin/jvm/functions/Function2;)V", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SubscriptionOwnershipGoogleRepository implements SubscriptionOwnershipRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SubscriptionHelper f708a;
    public final Function0 b;
    public final Function0 c;

    public SubscriptionOwnershipGoogleRepository(SubscriptionHelper helper, Function0<SubscriptionApi> api, Function0<NPFBillingClient> billingClientFactory) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(billingClientFactory, "billingClientFactory");
        this.f708a = helper;
        this.b = api;
        this.c = billingClientFactory;
    }

    @Override // com.nintendo.npf.sdk.domain.repository.SubscriptionOwnershipRepository
    public void update(BaaSUser account, Function2<? super SubscriptionOwnership, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(block, "block");
        NPFBillingClient nPFBillingClient = (NPFBillingClient) this.c.invoke();
        nPFBillingClient.setup(new y(this, new z(nPFBillingClient, block), nPFBillingClient, account));
    }
}
