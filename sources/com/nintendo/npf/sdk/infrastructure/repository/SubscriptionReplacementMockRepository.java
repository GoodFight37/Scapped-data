package com.nintendo.npf.sdk.infrastructure.repository;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.model.SubscriptionReplacement;
import com.nintendo.npf.sdk.domain.repository.SubscriptionReplacementRepository;
import com.nintendo.npf.sdk.infrastructure.api.SubscriptionApi;
import com.nintendo.npf.sdk.user.BaaSUser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ=\u0010\u0012\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u001c\u0010\u0011\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00100\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/repository/SubscriptionReplacementMockRepository;", "Lcom/nintendo/npf/sdk/domain/repository/SubscriptionReplacementRepository;", "Lkotlin/Function0;", "Lcom/nintendo/npf/sdk/infrastructure/api/SubscriptionApi;", "api", "Lcom/nintendo/npf/sdk/domain/ErrorFactory;", "errorFactory", "<init>", "(Lkotlin/jvm/functions/Function0;Lcom/nintendo/npf/sdk/domain/ErrorFactory;)V", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "account", "", "productId", "Lkotlin/Function2;", "Lcom/nintendo/npf/sdk/domain/model/SubscriptionReplacement;", "Lcom/nintendo/npf/sdk/NPFError;", "", "block", "find", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SubscriptionReplacementMockRepository implements SubscriptionReplacementRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f715a;
    public final ErrorFactory b;

    public SubscriptionReplacementMockRepository(Function0<SubscriptionApi> api, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f715a = api;
        this.b = errorFactory;
    }

    @Override // com.nintendo.npf.sdk.domain.repository.SubscriptionReplacementRepository
    public void find(BaaSUser account, String productId, Function2<? super SubscriptionReplacement, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(block, "block");
        if (productId.length() == 0) {
            block.invoke(null, this.b.create_InvalidParameters_400());
        } else {
            ((SubscriptionApi) this.f715a.invoke()).checkPurchaseReplacement(account, "MOCK", productId, new JSONObject(), block);
        }
    }
}
