package com.nintendo.npf.sdk.domain.repository;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.SubscriptionReplacement;
import com.nintendo.npf.sdk.subscription.SubscriptionPurchase;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00030\u000bH&J2\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052 \u0010\n\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00030\u000eH&J2\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052 \u0010\n\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00030\u000eH&J2\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052 \u0010\n\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00030\u000eH&¨\u0006\u0013"}, d2 = {"Lcom/nintendo/npf/sdk/domain/repository/SubscriptionPurchaseRepository;", "", "create", "", "account", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "productId", "", "replacement", "Lcom/nintendo/npf/sdk/domain/model/SubscriptionReplacement;", "block", "Lkotlin/Function1;", "Lcom/nintendo/npf/sdk/NPFError;", "find", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/subscription/SubscriptionPurchase;", "findGlobal", "update", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SubscriptionPurchaseRepository {
    void create(BaaSUser account, String productId, SubscriptionReplacement replacement, Function1<? super NPFError, Unit> block);

    void find(BaaSUser account, Function2<? super List<SubscriptionPurchase>, ? super NPFError, Unit> block);

    void findGlobal(BaaSUser account, Function2<? super List<SubscriptionPurchase>, ? super NPFError, Unit> block);

    void update(BaaSUser account, Function2<? super List<SubscriptionPurchase>, ? super NPFError, Unit> block);
}
