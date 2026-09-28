package com.nintendo.npf.sdk.domain.repository;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.SubscriptionReplacement;
import com.nintendo.npf.sdk.user.BaaSUser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00030\tH&¨\u0006\f"}, d2 = {"Lcom/nintendo/npf/sdk/domain/repository/SubscriptionReplacementRepository;", "", "find", "", "account", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "productId", "", "block", "Lkotlin/Function2;", "Lcom/nintendo/npf/sdk/domain/model/SubscriptionReplacement;", "Lcom/nintendo/npf/sdk/NPFError;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SubscriptionReplacementRepository {
    void find(BaaSUser account, String productId, Function2<? super SubscriptionReplacement, ? super NPFError, Unit> block);
}
