package com.nintendo.npf.sdk.infrastructure.repository;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.repository.VirtualCurrencyTransactionRepository;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyTransaction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062 \u0010\u0007\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00040\bH\u0016¨\u0006\f"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/repository/VirtualCurrencyTransactionMockRepository;", "Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyTransactionRepository;", "()V", "findUnprocessedList", "", "account", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "block", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyTransaction;", "Lcom/nintendo/npf/sdk/NPFError;", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrencyTransactionMockRepository implements VirtualCurrencyTransactionRepository {
    @Override // com.nintendo.npf.sdk.domain.repository.VirtualCurrencyTransactionRepository
    public void findUnprocessedList(BaaSUser account, Function2<? super List<VirtualCurrencyTransaction>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(CollectionsKt.emptyList(), null);
    }
}
