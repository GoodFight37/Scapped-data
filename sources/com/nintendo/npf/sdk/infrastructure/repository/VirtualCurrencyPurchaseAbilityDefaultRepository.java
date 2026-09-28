package com.nintendo.npf.sdk.infrastructure.repository;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchaseAbility;
import com.nintendo.npf.sdk.domain.repository.VirtualCurrencyPurchaseAbilityRepository;
import com.nintendo.npf.sdk.infrastructure.api.VirtualCurrencyApi;
import com.nintendo.npf.sdk.user.BaaSUser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\u000e\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f0\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/repository/VirtualCurrencyPurchaseAbilityDefaultRepository;", "Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyPurchaseAbilityRepository;", "Lkotlin/Function0;", "Lcom/nintendo/npf/sdk/infrastructure/api/VirtualCurrencyApi;", "api", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "account", "Lkotlin/Function2;", "Lcom/nintendo/npf/sdk/domain/model/VirtualCurrencyPurchaseAbility;", "Lcom/nintendo/npf/sdk/NPFError;", "", "block", "find", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Lkotlin/jvm/functions/Function2;)V", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrencyPurchaseAbilityDefaultRepository implements VirtualCurrencyPurchaseAbilityRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f719a;

    public VirtualCurrencyPurchaseAbilityDefaultRepository(Function0<VirtualCurrencyApi> api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.f719a = api;
    }

    @Override // com.nintendo.npf.sdk.domain.repository.VirtualCurrencyPurchaseAbilityRepository
    public void find(BaaSUser account, Function2<? super VirtualCurrencyPurchaseAbility, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(block, "block");
        ((VirtualCurrencyApi) this.f719a.invoke()).getPurchaseAbility(account, block);
    }
}
