package com.nintendo.npf.sdk.infrastructure.repository;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.repository.VirtualCurrencyWalletRepository;
import com.nintendo.npf.sdk.infrastructure.api.VirtualCurrencyApi;
import com.nintendo.npf.sdk.internal.billing.BillingHelper;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyWallet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J9\u0010\u000f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072 \u0010\u000e\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\u0011\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072 \u0010\u000e\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/repository/VirtualCurrencyWalletDefaultRepository;", "Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyWalletRepository;", "Lkotlin/Function0;", "Lcom/nintendo/npf/sdk/infrastructure/api/VirtualCurrencyApi;", "api", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "account", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyWallet;", "Lcom/nintendo/npf/sdk/NPFError;", "", "block", "find", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Lkotlin/jvm/functions/Function2;)V", "findGlobal", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrencyWalletDefaultRepository implements VirtualCurrencyWalletRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f724a;

    public VirtualCurrencyWalletDefaultRepository(Function0<VirtualCurrencyApi> api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.f724a = api;
    }

    @Override // com.nintendo.npf.sdk.domain.repository.VirtualCurrencyWalletRepository
    public void find(BaaSUser account, Function2<? super List<VirtualCurrencyWallet>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(block, "block");
        ((VirtualCurrencyApi) this.f724a.invoke()).getWallets(account, BillingHelper.getMarket(), block);
    }

    @Override // com.nintendo.npf.sdk.domain.repository.VirtualCurrencyWalletRepository
    public void findGlobal(BaaSUser account, Function2<? super List<VirtualCurrencyWallet>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(block, "block");
        ((VirtualCurrencyApi) this.f724a.invoke()).getGlobalWallets(account, block);
    }
}
