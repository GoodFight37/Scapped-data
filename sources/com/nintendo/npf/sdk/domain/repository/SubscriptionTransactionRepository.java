package com.nintendo.npf.sdk.domain.repository;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.subscription.SubscriptionTransaction;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052 \u0010\u0006\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00030\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/nintendo/npf/sdk/domain/repository/SubscriptionTransactionRepository;", "", "findUnprocessedList", "", "account", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "block", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/subscription/SubscriptionTransaction;", "Lcom/nintendo/npf/sdk/NPFError;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SubscriptionTransactionRepository {
    void findUnprocessedList(BaaSUser account, Function2<? super List<SubscriptionTransaction>, ? super NPFError, Unit> block);
}
