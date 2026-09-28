package com.nintendo.npf.sdk.infrastructure.repository;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.repository.SubscriptionTransactionRepository;
import com.nintendo.npf.sdk.infrastructure.helper.SubscriptionHelper;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.subscription.SubscriptionTransaction;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdkbilling.y0;
import com.nintendo.npf.sdkbilling.z0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2 \u0010\u0010\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u000f0\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/repository/SubscriptionTransactionGoogleRepository;", "Lcom/nintendo/npf/sdk/domain/repository/SubscriptionTransactionRepository;", "Lcom/nintendo/npf/sdk/infrastructure/helper/SubscriptionHelper;", "helper", "Lkotlin/Function0;", "Lcom/nintendo/npf/sdk/internal/billing/NPFBillingClient;", "billingClientFactory", "<init>", "(Lcom/nintendo/npf/sdk/infrastructure/helper/SubscriptionHelper;Lkotlin/jvm/functions/Function0;)V", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "account", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/subscription/SubscriptionTransaction;", "Lcom/nintendo/npf/sdk/NPFError;", "", "block", "findUnprocessedList", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Lkotlin/jvm/functions/Function2;)V", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SubscriptionTransactionGoogleRepository implements SubscriptionTransactionRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SubscriptionHelper f716a;
    public final Function0 b;

    public SubscriptionTransactionGoogleRepository(SubscriptionHelper helper, Function0<NPFBillingClient> billingClientFactory) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(billingClientFactory, "billingClientFactory");
        this.f716a = helper;
        this.b = billingClientFactory;
    }

    @Override // com.nintendo.npf.sdk.domain.repository.SubscriptionTransactionRepository
    public void findUnprocessedList(BaaSUser account, Function2<? super List<SubscriptionTransaction>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(block, "block");
        NPFBillingClient nPFBillingClient = (NPFBillingClient) this.b.invoke();
        nPFBillingClient.setup(new y0(this, new z0(nPFBillingClient, block), nPFBillingClient));
    }
}
