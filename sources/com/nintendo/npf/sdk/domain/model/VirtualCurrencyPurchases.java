package com.nintendo.npf.sdk.domain.model;

import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyWallet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ0\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\nR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u001b\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/nintendo/npf/sdk/domain/model/VirtualCurrencyPurchases;", "", "", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyWallet;", MapperConstants.VIRTUAL_CURRENCY_FIELD_WALLETS, "", "transactions", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "component1", "()Ljava/util/List;", "component2", "copy", "(Ljava/util/List;Ljava/util/List;)Lcom/nintendo/npf/sdk/domain/model/VirtualCurrencyPurchases;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/util/List;", "getWallets", "b", "getTransactions", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VirtualCurrencyPurchases {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List wallets;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final List transactions;

    public VirtualCurrencyPurchases(List<VirtualCurrencyWallet> wallets, List<String> transactions) {
        Intrinsics.checkNotNullParameter(wallets, "wallets");
        Intrinsics.checkNotNullParameter(transactions, "transactions");
        this.wallets = wallets;
        this.transactions = transactions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VirtualCurrencyPurchases copy$default(VirtualCurrencyPurchases virtualCurrencyPurchases, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = virtualCurrencyPurchases.wallets;
        }
        if ((i & 2) != 0) {
            list2 = virtualCurrencyPurchases.transactions;
        }
        return virtualCurrencyPurchases.copy(list, list2);
    }

    public final List<VirtualCurrencyWallet> component1() {
        return this.wallets;
    }

    public final List<String> component2() {
        return this.transactions;
    }

    public final VirtualCurrencyPurchases copy(List<VirtualCurrencyWallet> wallets, List<String> transactions) {
        Intrinsics.checkNotNullParameter(wallets, "wallets");
        Intrinsics.checkNotNullParameter(transactions, "transactions");
        return new VirtualCurrencyPurchases(wallets, transactions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VirtualCurrencyPurchases)) {
            return false;
        }
        VirtualCurrencyPurchases virtualCurrencyPurchases = (VirtualCurrencyPurchases) other;
        return Intrinsics.areEqual(this.wallets, virtualCurrencyPurchases.wallets) && Intrinsics.areEqual(this.transactions, virtualCurrencyPurchases.transactions);
    }

    public final List<String> getTransactions() {
        return this.transactions;
    }

    public final List<VirtualCurrencyWallet> getWallets() {
        return this.wallets;
    }

    public int hashCode() {
        return (this.wallets.hashCode() * 31) + this.transactions.hashCode();
    }

    public String toString() {
        return "VirtualCurrencyPurchases(wallets=" + this.wallets + ", transactions=" + this.transactions + ')';
    }
}
