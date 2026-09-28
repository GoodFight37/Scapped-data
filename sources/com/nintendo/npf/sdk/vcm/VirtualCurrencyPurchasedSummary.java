package com.nintendo.npf.sdk.vcm;

import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\u0015\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\u0015\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003J\u0015\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\u009b\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\t2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\t2\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\tHÖ\u0001J\t\u00104\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00065"}, d2 = {"Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyPurchasedSummary;", "", "market", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyMarket;", MapperConstants.VIRTUAL_CURRENCY_FIELD_VIRTUAL_CURRENCY_NAME, "", "lifeTimePurchasedUsd", "", MapperConstants.VIRTUAL_CURRENCY_FIELD_BRIDGE_LIFETIME_PURCHASED_VC, "", "lifeTimePurchasesBySku", "", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyPurchaseSummaryBySku;", "thisDayPurchasedUsd", MapperConstants.VIRTUAL_CURRENCY_FIELD_BRIDGE_THIS_DAY_PURCHASED_VC, "thisDayPurchasesBySku", "thisMonthPurchasedUsd", MapperConstants.VIRTUAL_CURRENCY_FIELD_BRIDGE_THIS_MONTH_PURCHASED_VC, "thisMonthPurchasesBySku", "(Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyMarket;Ljava/lang/String;DILjava/util/Map;DILjava/util/Map;DILjava/util/Map;)V", "getLifeTimePurchasedAmount", "()I", "getLifeTimePurchasedUsd", "()D", "getLifeTimePurchasesBySku", "()Ljava/util/Map;", "getMarket", "()Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyMarket;", "getThisDayPurchasedAmount", "getThisDayPurchasedUsd", "getThisDayPurchasesBySku", "getThisMonthPurchasedAmount", "getThisMonthPurchasedUsd", "getThisMonthPurchasesBySku", "getVirtualCurrencyName", "()Ljava/lang/String;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VirtualCurrencyPurchasedSummary {
    private final int lifeTimePurchasedAmount;
    private final double lifeTimePurchasedUsd;
    private final Map<String, VirtualCurrencyPurchaseSummaryBySku> lifeTimePurchasesBySku;
    private final VirtualCurrencyMarket market;
    private final int thisDayPurchasedAmount;
    private final double thisDayPurchasedUsd;
    private final Map<String, VirtualCurrencyPurchaseSummaryBySku> thisDayPurchasesBySku;
    private final int thisMonthPurchasedAmount;
    private final double thisMonthPurchasedUsd;
    private final Map<String, VirtualCurrencyPurchaseSummaryBySku> thisMonthPurchasesBySku;
    private final String virtualCurrencyName;

    public VirtualCurrencyPurchasedSummary(VirtualCurrencyMarket market, String virtualCurrencyName, double d, int i, Map<String, VirtualCurrencyPurchaseSummaryBySku> lifeTimePurchasesBySku, double d2, int i2, Map<String, VirtualCurrencyPurchaseSummaryBySku> thisDayPurchasesBySku, double d3, int i3, Map<String, VirtualCurrencyPurchaseSummaryBySku> thisMonthPurchasesBySku) {
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(virtualCurrencyName, "virtualCurrencyName");
        Intrinsics.checkNotNullParameter(lifeTimePurchasesBySku, "lifeTimePurchasesBySku");
        Intrinsics.checkNotNullParameter(thisDayPurchasesBySku, "thisDayPurchasesBySku");
        Intrinsics.checkNotNullParameter(thisMonthPurchasesBySku, "thisMonthPurchasesBySku");
        this.market = market;
        this.virtualCurrencyName = virtualCurrencyName;
        this.lifeTimePurchasedUsd = d;
        this.lifeTimePurchasedAmount = i;
        this.lifeTimePurchasesBySku = lifeTimePurchasesBySku;
        this.thisDayPurchasedUsd = d2;
        this.thisDayPurchasedAmount = i2;
        this.thisDayPurchasesBySku = thisDayPurchasesBySku;
        this.thisMonthPurchasedUsd = d3;
        this.thisMonthPurchasedAmount = i3;
        this.thisMonthPurchasesBySku = thisMonthPurchasesBySku;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final VirtualCurrencyMarket getMarket() {
        return this.market;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getThisMonthPurchasedAmount() {
        return this.thisMonthPurchasedAmount;
    }

    public final Map<String, VirtualCurrencyPurchaseSummaryBySku> component11() {
        return this.thisMonthPurchasesBySku;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVirtualCurrencyName() {
        return this.virtualCurrencyName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getLifeTimePurchasedUsd() {
        return this.lifeTimePurchasedUsd;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getLifeTimePurchasedAmount() {
        return this.lifeTimePurchasedAmount;
    }

    public final Map<String, VirtualCurrencyPurchaseSummaryBySku> component5() {
        return this.lifeTimePurchasesBySku;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final double getThisDayPurchasedUsd() {
        return this.thisDayPurchasedUsd;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getThisDayPurchasedAmount() {
        return this.thisDayPurchasedAmount;
    }

    public final Map<String, VirtualCurrencyPurchaseSummaryBySku> component8() {
        return this.thisDayPurchasesBySku;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final double getThisMonthPurchasedUsd() {
        return this.thisMonthPurchasedUsd;
    }

    public final VirtualCurrencyPurchasedSummary copy(VirtualCurrencyMarket market, String virtualCurrencyName, double lifeTimePurchasedUsd, int lifeTimePurchasedAmount, Map<String, VirtualCurrencyPurchaseSummaryBySku> lifeTimePurchasesBySku, double thisDayPurchasedUsd, int thisDayPurchasedAmount, Map<String, VirtualCurrencyPurchaseSummaryBySku> thisDayPurchasesBySku, double thisMonthPurchasedUsd, int thisMonthPurchasedAmount, Map<String, VirtualCurrencyPurchaseSummaryBySku> thisMonthPurchasesBySku) {
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(virtualCurrencyName, "virtualCurrencyName");
        Intrinsics.checkNotNullParameter(lifeTimePurchasesBySku, "lifeTimePurchasesBySku");
        Intrinsics.checkNotNullParameter(thisDayPurchasesBySku, "thisDayPurchasesBySku");
        Intrinsics.checkNotNullParameter(thisMonthPurchasesBySku, "thisMonthPurchasesBySku");
        return new VirtualCurrencyPurchasedSummary(market, virtualCurrencyName, lifeTimePurchasedUsd, lifeTimePurchasedAmount, lifeTimePurchasesBySku, thisDayPurchasedUsd, thisDayPurchasedAmount, thisDayPurchasesBySku, thisMonthPurchasedUsd, thisMonthPurchasedAmount, thisMonthPurchasesBySku);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VirtualCurrencyPurchasedSummary)) {
            return false;
        }
        VirtualCurrencyPurchasedSummary virtualCurrencyPurchasedSummary = (VirtualCurrencyPurchasedSummary) other;
        return this.market == virtualCurrencyPurchasedSummary.market && Intrinsics.areEqual(this.virtualCurrencyName, virtualCurrencyPurchasedSummary.virtualCurrencyName) && Double.compare(this.lifeTimePurchasedUsd, virtualCurrencyPurchasedSummary.lifeTimePurchasedUsd) == 0 && this.lifeTimePurchasedAmount == virtualCurrencyPurchasedSummary.lifeTimePurchasedAmount && Intrinsics.areEqual(this.lifeTimePurchasesBySku, virtualCurrencyPurchasedSummary.lifeTimePurchasesBySku) && Double.compare(this.thisDayPurchasedUsd, virtualCurrencyPurchasedSummary.thisDayPurchasedUsd) == 0 && this.thisDayPurchasedAmount == virtualCurrencyPurchasedSummary.thisDayPurchasedAmount && Intrinsics.areEqual(this.thisDayPurchasesBySku, virtualCurrencyPurchasedSummary.thisDayPurchasesBySku) && Double.compare(this.thisMonthPurchasedUsd, virtualCurrencyPurchasedSummary.thisMonthPurchasedUsd) == 0 && this.thisMonthPurchasedAmount == virtualCurrencyPurchasedSummary.thisMonthPurchasedAmount && Intrinsics.areEqual(this.thisMonthPurchasesBySku, virtualCurrencyPurchasedSummary.thisMonthPurchasesBySku);
    }

    public final int getLifeTimePurchasedAmount() {
        return this.lifeTimePurchasedAmount;
    }

    public final double getLifeTimePurchasedUsd() {
        return this.lifeTimePurchasedUsd;
    }

    public final Map<String, VirtualCurrencyPurchaseSummaryBySku> getLifeTimePurchasesBySku() {
        return this.lifeTimePurchasesBySku;
    }

    public final VirtualCurrencyMarket getMarket() {
        return this.market;
    }

    public final int getThisDayPurchasedAmount() {
        return this.thisDayPurchasedAmount;
    }

    public final double getThisDayPurchasedUsd() {
        return this.thisDayPurchasedUsd;
    }

    public final Map<String, VirtualCurrencyPurchaseSummaryBySku> getThisDayPurchasesBySku() {
        return this.thisDayPurchasesBySku;
    }

    public final int getThisMonthPurchasedAmount() {
        return this.thisMonthPurchasedAmount;
    }

    public final double getThisMonthPurchasedUsd() {
        return this.thisMonthPurchasedUsd;
    }

    public final Map<String, VirtualCurrencyPurchaseSummaryBySku> getThisMonthPurchasesBySku() {
        return this.thisMonthPurchasesBySku;
    }

    public final String getVirtualCurrencyName() {
        return this.virtualCurrencyName;
    }

    public int hashCode() {
        return (((((((((((((((((((this.market.hashCode() * 31) + this.virtualCurrencyName.hashCode()) * 31) + Double.hashCode(this.lifeTimePurchasedUsd)) * 31) + Integer.hashCode(this.lifeTimePurchasedAmount)) * 31) + this.lifeTimePurchasesBySku.hashCode()) * 31) + Double.hashCode(this.thisDayPurchasedUsd)) * 31) + Integer.hashCode(this.thisDayPurchasedAmount)) * 31) + this.thisDayPurchasesBySku.hashCode()) * 31) + Double.hashCode(this.thisMonthPurchasedUsd)) * 31) + Integer.hashCode(this.thisMonthPurchasedAmount)) * 31) + this.thisMonthPurchasesBySku.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("VirtualCurrencyPurchasedSummary(market=");
        sb.append(this.market).append(", virtualCurrencyName=").append(this.virtualCurrencyName).append(", lifeTimePurchasedUsd=").append(this.lifeTimePurchasedUsd).append(", lifeTimePurchasedAmount=").append(this.lifeTimePurchasedAmount).append(", lifeTimePurchasesBySku=").append(this.lifeTimePurchasesBySku).append(", thisDayPurchasedUsd=").append(this.thisDayPurchasedUsd).append(", thisDayPurchasedAmount=").append(this.thisDayPurchasedAmount).append(", thisDayPurchasesBySku=").append(this.thisDayPurchasesBySku).append(", thisMonthPurchasedUsd=").append(this.thisMonthPurchasedUsd).append(", thisMonthPurchasedAmount=").append(this.thisMonthPurchasedAmount).append(", thisMonthPurchasesBySku=").append(this.thisMonthPurchasesBySku).append(')');
        return sb.toString();
    }

    public /* synthetic */ VirtualCurrencyPurchasedSummary(VirtualCurrencyMarket virtualCurrencyMarket, String str, double d, int i, Map map, double d2, int i2, Map map2, double d3, int i3, Map map3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(virtualCurrencyMarket, str, (i4 & 4) != 0 ? 0.0d : d, (i4 & 8) != 0 ? 0 : i, map, (i4 & 32) != 0 ? 0.0d : d2, (i4 & 64) != 0 ? 0 : i2, map2, (i4 & 256) != 0 ? 0.0d : d3, (i4 & 512) != 0 ? 0 : i3, map3);
    }
}
