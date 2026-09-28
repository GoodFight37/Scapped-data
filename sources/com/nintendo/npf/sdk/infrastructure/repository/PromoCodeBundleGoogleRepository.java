package com.nintendo.npf.sdk.infrastructure.repository;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.repository.PromoCodeBundleRepository;
import com.nintendo.npf.sdk.infrastructure.api.PromoCodeApi;
import com.nintendo.npf.sdk.infrastructure.helper.PromoCodeHelper;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.internal.model.Capabilities;
import com.nintendo.npf.sdk.promo.PromoCodeBundle;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdkbilling.n;
import com.nintendo.npf.sdkbilling.o;
import com.nintendo.npf.sdkbilling.s;
import com.nintendo.npf.sdkbilling.t;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112 \u0010\u0018\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00170\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ9\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112 \u0010\u0018\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00170\u0013H\u0016¢\u0006\u0004\b\u001b\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/repository/PromoCodeBundleGoogleRepository;", "Lcom/nintendo/npf/sdk/domain/repository/PromoCodeBundleRepository;", "Lcom/nintendo/npf/sdk/infrastructure/helper/PromoCodeHelper;", "helper", "Lcom/nintendo/npf/sdk/internal/model/Capabilities;", "capabilities", "Lkotlin/Function0;", "Lcom/nintendo/npf/sdk/infrastructure/api/PromoCodeApi;", "api", "Lcom/nintendo/npf/sdk/internal/billing/NPFBillingClient;", "billingClientFactory", "Lcom/nintendo/npf/sdk/infrastructure/repository/OrderCacheRepository;", "orderCacheRepository", "Lcom/nintendo/npf/sdk/domain/ErrorFactory;", "errorFactory", "<init>", "(Lcom/nintendo/npf/sdk/infrastructure/helper/PromoCodeHelper;Lcom/nintendo/npf/sdk/internal/model/Capabilities;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/nintendo/npf/sdk/infrastructure/repository/OrderCacheRepository;Lcom/nintendo/npf/sdk/domain/ErrorFactory;)V", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "account", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/promo/PromoCodeBundle;", "Lcom/nintendo/npf/sdk/NPFError;", "", "block", "find", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Lkotlin/jvm/functions/Function2;)V", "exchange", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PromoCodeBundleGoogleRepository implements PromoCodeBundleRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PromoCodeHelper f707a;
    public final Capabilities b;
    public final Function0 c;
    public final Function0 d;
    public final OrderCacheRepository e;
    public final ErrorFactory f;
    public boolean g;

    public PromoCodeBundleGoogleRepository(PromoCodeHelper helper, Capabilities capabilities, Function0<PromoCodeApi> api, Function0<NPFBillingClient> billingClientFactory, OrderCacheRepository orderCacheRepository, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(billingClientFactory, "billingClientFactory");
        Intrinsics.checkNotNullParameter(orderCacheRepository, "orderCacheRepository");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f707a = helper;
        this.b = capabilities;
        this.c = api;
        this.d = billingClientFactory;
        this.e = orderCacheRepository;
        this.f = errorFactory;
    }

    @Override // com.nintendo.npf.sdk.domain.repository.PromoCodeBundleRepository
    public void exchange(BaaSUser account, Function2<? super List<PromoCodeBundle>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.g) {
            block.invoke(CollectionsKt.emptyList(), this.f.create_PromoCode_Exchanging_Minus1());
            return;
        }
        this.g = true;
        NPFBillingClient nPFBillingClient = (NPFBillingClient) this.d.invoke();
        nPFBillingClient.setup(new n(this, nPFBillingClient, account, new o(nPFBillingClient, block, this)));
    }

    @Override // com.nintendo.npf.sdk.domain.repository.PromoCodeBundleRepository
    public void find(BaaSUser account, Function2<? super List<PromoCodeBundle>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(block, "block");
        NPFBillingClient nPFBillingClient = (NPFBillingClient) this.d.invoke();
        nPFBillingClient.setup(new s(this, new t(nPFBillingClient, block), nPFBillingClient, account));
    }
}
