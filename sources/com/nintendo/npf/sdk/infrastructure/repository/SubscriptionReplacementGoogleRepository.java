package com.nintendo.npf.sdk.infrastructure.repository;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.model.SubscriptionReplacement;
import com.nintendo.npf.sdk.domain.repository.SubscriptionReplacementRepository;
import com.nintendo.npf.sdk.infrastructure.api.SubscriptionApi;
import com.nintendo.npf.sdk.infrastructure.helper.SubscriptionHelper;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdkbilling.u0;
import com.nintendo.npf.sdkbilling.v0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ=\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u001c\u0010\u0015\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00140\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/repository/SubscriptionReplacementGoogleRepository;", "Lcom/nintendo/npf/sdk/domain/repository/SubscriptionReplacementRepository;", "Lcom/nintendo/npf/sdk/infrastructure/helper/SubscriptionHelper;", "helper", "Lkotlin/Function0;", "Lcom/nintendo/npf/sdk/infrastructure/api/SubscriptionApi;", "api", "Lcom/nintendo/npf/sdk/internal/billing/NPFBillingClient;", "billingClientFactory", "Lcom/nintendo/npf/sdk/domain/ErrorFactory;", "errorFactory", "<init>", "(Lcom/nintendo/npf/sdk/infrastructure/helper/SubscriptionHelper;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/nintendo/npf/sdk/domain/ErrorFactory;)V", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "account", "", "productId", "Lkotlin/Function2;", "Lcom/nintendo/npf/sdk/domain/model/SubscriptionReplacement;", "Lcom/nintendo/npf/sdk/NPFError;", "", "block", "find", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SubscriptionReplacementGoogleRepository implements SubscriptionReplacementRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SubscriptionHelper f714a;
    public final Function0 b;
    public final Function0 c;
    public final ErrorFactory d;

    public SubscriptionReplacementGoogleRepository(SubscriptionHelper helper, Function0<SubscriptionApi> api, Function0<NPFBillingClient> billingClientFactory, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(billingClientFactory, "billingClientFactory");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f714a = helper;
        this.b = api;
        this.c = billingClientFactory;
        this.d = errorFactory;
    }

    @Override // com.nintendo.npf.sdk.domain.repository.SubscriptionReplacementRepository
    public void find(BaaSUser account, String productId, Function2<? super SubscriptionReplacement, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(block, "block");
        if (productId.length() == 0) {
            block.invoke(null, this.d.create_InvalidParameters_400());
        } else {
            NPFBillingClient nPFBillingClient = (NPFBillingClient) this.c.invoke();
            nPFBillingClient.setup(new u0(this, new v0(nPFBillingClient, block), nPFBillingClient, account, productId));
        }
    }
}
