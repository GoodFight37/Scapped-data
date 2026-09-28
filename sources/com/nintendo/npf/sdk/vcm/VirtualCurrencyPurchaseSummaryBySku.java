package com.nintendo.npf.sdk.vcm;

import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyPurchaseSummaryBySku;", "", "sku", "", MapperConstants.VIRTUAL_CURRENCY_FIELD_COUNT, "", MapperConstants.VIRTUAL_CURRENCY_FIELD_BRIDGE_PURCHASED_VC, MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASED_USD, "", "(Ljava/lang/String;IID)V", "getCount", "()I", "getPurchasedAmount", "getPurchasedUsd", "()D", "getSku", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VirtualCurrencyPurchaseSummaryBySku {
    private final int count;
    private final int purchasedAmount;
    private final double purchasedUsd;
    private final String sku;

    public VirtualCurrencyPurchaseSummaryBySku(String sku, int i, int i2, double d) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        this.sku = sku;
        this.count = i;
        this.purchasedAmount = i2;
        this.purchasedUsd = d;
    }

    public static /* synthetic */ VirtualCurrencyPurchaseSummaryBySku copy$default(VirtualCurrencyPurchaseSummaryBySku virtualCurrencyPurchaseSummaryBySku, String str, int i, int i2, double d, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = virtualCurrencyPurchaseSummaryBySku.sku;
        }
        if ((i3 & 2) != 0) {
            i = virtualCurrencyPurchaseSummaryBySku.count;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = virtualCurrencyPurchaseSummaryBySku.purchasedAmount;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            d = virtualCurrencyPurchaseSummaryBySku.purchasedUsd;
        }
        return virtualCurrencyPurchaseSummaryBySku.copy(str, i4, i5, d);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSku() {
        return this.sku;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPurchasedAmount() {
        return this.purchasedAmount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final double getPurchasedUsd() {
        return this.purchasedUsd;
    }

    public final VirtualCurrencyPurchaseSummaryBySku copy(String sku, int count, int purchasedAmount, double purchasedUsd) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        return new VirtualCurrencyPurchaseSummaryBySku(sku, count, purchasedAmount, purchasedUsd);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VirtualCurrencyPurchaseSummaryBySku)) {
            return false;
        }
        VirtualCurrencyPurchaseSummaryBySku virtualCurrencyPurchaseSummaryBySku = (VirtualCurrencyPurchaseSummaryBySku) other;
        return Intrinsics.areEqual(this.sku, virtualCurrencyPurchaseSummaryBySku.sku) && this.count == virtualCurrencyPurchaseSummaryBySku.count && this.purchasedAmount == virtualCurrencyPurchaseSummaryBySku.purchasedAmount && Double.compare(this.purchasedUsd, virtualCurrencyPurchaseSummaryBySku.purchasedUsd) == 0;
    }

    public final int getCount() {
        return this.count;
    }

    public final int getPurchasedAmount() {
        return this.purchasedAmount;
    }

    public final double getPurchasedUsd() {
        return this.purchasedUsd;
    }

    public final String getSku() {
        return this.sku;
    }

    public int hashCode() {
        return (((((this.sku.hashCode() * 31) + Integer.hashCode(this.count)) * 31) + Integer.hashCode(this.purchasedAmount)) * 31) + Double.hashCode(this.purchasedUsd);
    }

    public String toString() {
        return "VirtualCurrencyPurchaseSummaryBySku(sku=" + this.sku + ", count=" + this.count + ", purchasedAmount=" + this.purchasedAmount + ", purchasedUsd=" + this.purchasedUsd + ')';
    }

    public /* synthetic */ VirtualCurrencyPurchaseSummaryBySku(String str, int i, int i2, double d, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? 0.0d : d);
    }
}
