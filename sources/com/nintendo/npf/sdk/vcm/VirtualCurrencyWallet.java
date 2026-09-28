package com.nintendo.npf.sdk.vcm;

import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\nHÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyWallet;", "", "market", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyMarket;", MapperConstants.VIRTUAL_CURRENCY_FIELD_VIRTUAL_CURRENCY_NAME, "", MapperConstants.VIRTUAL_CURRENCY_FIELD_BRIDGE_TOTAL_BALANCE, "", MapperConstants.VIRTUAL_CURRENCY_FIELD_BRIDGE_FREE_BALANCE, MapperConstants.VIRTUAL_CURRENCY_FIELD_BRIDGE_PAID_BALANCE, "", "(Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyMarket;Ljava/lang/String;IILjava/util/Map;)V", "getFreeBalance", "()I", "getMarket", "()Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyMarket;", "getPaidBalance", "()Ljava/util/Map;", "getTotalBalance", "getVirtualCurrencyName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VirtualCurrencyWallet {
    private final int freeBalance;
    private final VirtualCurrencyMarket market;
    private final Map<String, Integer> paidBalance;
    private final int totalBalance;
    private final String virtualCurrencyName;

    public VirtualCurrencyWallet(VirtualCurrencyMarket market, String virtualCurrencyName, int i, int i2, Map<String, Integer> paidBalance) {
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(virtualCurrencyName, "virtualCurrencyName");
        Intrinsics.checkNotNullParameter(paidBalance, "paidBalance");
        this.market = market;
        this.virtualCurrencyName = virtualCurrencyName;
        this.totalBalance = i;
        this.freeBalance = i2;
        this.paidBalance = paidBalance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VirtualCurrencyWallet copy$default(VirtualCurrencyWallet virtualCurrencyWallet, VirtualCurrencyMarket virtualCurrencyMarket, String str, int i, int i2, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            virtualCurrencyMarket = virtualCurrencyWallet.market;
        }
        if ((i3 & 2) != 0) {
            str = virtualCurrencyWallet.virtualCurrencyName;
        }
        String str2 = str;
        if ((i3 & 4) != 0) {
            i = virtualCurrencyWallet.totalBalance;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = virtualCurrencyWallet.freeBalance;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            map = virtualCurrencyWallet.paidBalance;
        }
        return virtualCurrencyWallet.copy(virtualCurrencyMarket, str2, i4, i5, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final VirtualCurrencyMarket getMarket() {
        return this.market;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVirtualCurrencyName() {
        return this.virtualCurrencyName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getTotalBalance() {
        return this.totalBalance;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getFreeBalance() {
        return this.freeBalance;
    }

    public final Map<String, Integer> component5() {
        return this.paidBalance;
    }

    public final VirtualCurrencyWallet copy(VirtualCurrencyMarket market, String virtualCurrencyName, int totalBalance, int freeBalance, Map<String, Integer> paidBalance) {
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(virtualCurrencyName, "virtualCurrencyName");
        Intrinsics.checkNotNullParameter(paidBalance, "paidBalance");
        return new VirtualCurrencyWallet(market, virtualCurrencyName, totalBalance, freeBalance, paidBalance);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VirtualCurrencyWallet)) {
            return false;
        }
        VirtualCurrencyWallet virtualCurrencyWallet = (VirtualCurrencyWallet) other;
        return this.market == virtualCurrencyWallet.market && Intrinsics.areEqual(this.virtualCurrencyName, virtualCurrencyWallet.virtualCurrencyName) && this.totalBalance == virtualCurrencyWallet.totalBalance && this.freeBalance == virtualCurrencyWallet.freeBalance && Intrinsics.areEqual(this.paidBalance, virtualCurrencyWallet.paidBalance);
    }

    public final int getFreeBalance() {
        return this.freeBalance;
    }

    public final VirtualCurrencyMarket getMarket() {
        return this.market;
    }

    public final Map<String, Integer> getPaidBalance() {
        return this.paidBalance;
    }

    public final int getTotalBalance() {
        return this.totalBalance;
    }

    public final String getVirtualCurrencyName() {
        return this.virtualCurrencyName;
    }

    public int hashCode() {
        return (((((((this.market.hashCode() * 31) + this.virtualCurrencyName.hashCode()) * 31) + Integer.hashCode(this.totalBalance)) * 31) + Integer.hashCode(this.freeBalance)) * 31) + this.paidBalance.hashCode();
    }

    public String toString() {
        return "VirtualCurrencyWallet(market=" + this.market + ", virtualCurrencyName=" + this.virtualCurrencyName + ", totalBalance=" + this.totalBalance + ", freeBalance=" + this.freeBalance + ", paidBalance=" + this.paidBalance + ')';
    }

    public /* synthetic */ VirtualCurrencyWallet(VirtualCurrencyMarket virtualCurrencyMarket, String str, int i, int i2, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(virtualCurrencyMarket, str, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2, map);
    }
}
