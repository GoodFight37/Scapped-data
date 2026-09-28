package com.nintendo.npf.sdk.infrastructure.repository;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.SubscriptionReplacement;
import com.nintendo.npf.sdk.domain.repository.SubscriptionPurchaseRepository;
import com.nintendo.npf.sdk.infrastructure.api.SubscriptionApi;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.subscription.SubscriptionPurchase;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J9\u0010\u000f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072 \u0010\u000e\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\u0011\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072 \u0010\u000e\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J?\u0010\u0017\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J9\u0010\u0019\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072 \u0010\u000e\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\tH\u0016¢\u0006\u0004\b\u0019\u0010\u0010J\u0015\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/repository/SubscriptionPurchaseMockRepository;", "Lcom/nintendo/npf/sdk/domain/repository/SubscriptionPurchaseRepository;", "Lkotlin/Function0;", "Lcom/nintendo/npf/sdk/infrastructure/api/SubscriptionApi;", "api", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "account", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/subscription/SubscriptionPurchase;", "Lcom/nintendo/npf/sdk/NPFError;", "", "block", "find", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Lkotlin/jvm/functions/Function2;)V", "findGlobal", "", "productId", "Lcom/nintendo/npf/sdk/domain/model/SubscriptionReplacement;", "replacement", "Lkotlin/Function1;", "create", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Ljava/lang/String;Lcom/nintendo/npf/sdk/domain/model/SubscriptionReplacement;Lkotlin/jvm/functions/Function1;)V", "update", "Lorg/json/JSONObject;", "makeReceipt", "(Ljava/lang/String;)Lorg/json/JSONObject;", "Companion", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SubscriptionPurchaseMockRepository implements SubscriptionPurchaseRepository {
    public static final String b = "SubscriptionPurchaseMockRepository";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f713a;

    public SubscriptionPurchaseMockRepository(Function0<SubscriptionApi> api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.f713a = api;
    }

    @Override // com.nintendo.npf.sdk.domain.repository.SubscriptionPurchaseRepository
    public void create(BaaSUser account, String productId, SubscriptionReplacement replacement, Function1<? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(block, "block");
        ((SubscriptionApi) this.f713a.invoke()).createPurchases(account, "MOCK", makeReceipt(productId), block);
    }

    @Override // com.nintendo.npf.sdk.domain.repository.SubscriptionPurchaseRepository
    public void find(BaaSUser account, Function2<? super List<SubscriptionPurchase>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(block, "block");
        ((SubscriptionApi) this.f713a.invoke()).getPurchases(account, "MOCK", block);
    }

    @Override // com.nintendo.npf.sdk.domain.repository.SubscriptionPurchaseRepository
    public void findGlobal(BaaSUser account, Function2<? super List<SubscriptionPurchase>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(block, "block");
        ((SubscriptionApi) this.f713a.invoke()).getGlobalPurchases(account, "MOCK", block);
    }

    public final JSONObject makeReceipt(String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("productId", productId);
            return jSONObject;
        } catch (JSONException e) {
            SDKLog.e(b, "makeReceipt", e);
            return jSONObject;
        }
    }

    @Override // com.nintendo.npf.sdk.domain.repository.SubscriptionPurchaseRepository
    public void update(BaaSUser account, Function2<? super List<SubscriptionPurchase>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(block, "block");
        ((SubscriptionApi) this.f713a.invoke()).updatePurchases(account, "MOCK", new JSONObject(), block);
    }
}
