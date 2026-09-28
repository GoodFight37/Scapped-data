package com.nintendo.npf.sdk.vcm;

import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0083\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\bHÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014¨\u00060"}, d2 = {"Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyBundle;", "", MapperConstants.VIRTUAL_CURRENCY_FIELD_VIRTUAL_CURRENCY_NAME, "", "sku", MapperConstants.VIRTUAL_CURRENCY_FIELD_USD_PRICE, "Ljava/math/BigDecimal;", MapperConstants.VIRTUAL_CURRENCY_FIELD_AMOUNT, "", MapperConstants.VIRTUAL_CURRENCY_FIELD_EXTRA_AMOUNT, "price", MapperConstants.VIRTUAL_CURRENCY_FIELD_PRICE_CODE, "displayPrice", "title", MapperConstants.VIRTUAL_CURRENCY_FIELD_DETAIL, "customAttribute", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;IILjava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()I", "getCustomAttribute", "()Ljava/lang/String;", "getDetail", "getDisplayPrice", "getExtraAmount", "getPrice", "()Ljava/math/BigDecimal;", "getPriceCode", "getSku", "getTitle", "getUsdPrice", "getVirtualCurrencyName", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VirtualCurrencyBundle {
    private final int amount;
    private final String customAttribute;
    private final String detail;
    private final String displayPrice;
    private final int extraAmount;
    private final BigDecimal price;
    private final String priceCode;
    private final String sku;
    private final String title;
    private final BigDecimal usdPrice;
    private final String virtualCurrencyName;

    public VirtualCurrencyBundle(String virtualCurrencyName, String sku, BigDecimal usdPrice, int i, int i2, BigDecimal bigDecimal, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(virtualCurrencyName, "virtualCurrencyName");
        Intrinsics.checkNotNullParameter(sku, "sku");
        Intrinsics.checkNotNullParameter(usdPrice, "usdPrice");
        this.virtualCurrencyName = virtualCurrencyName;
        this.sku = sku;
        this.usdPrice = usdPrice;
        this.amount = i;
        this.extraAmount = i2;
        this.price = bigDecimal;
        this.priceCode = str;
        this.displayPrice = str2;
        this.title = str3;
        this.detail = str4;
        this.customAttribute = str5;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVirtualCurrencyName() {
        return this.virtualCurrencyName;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getDetail() {
        return this.detail;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getCustomAttribute() {
        return this.customAttribute;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSku() {
        return this.sku;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final BigDecimal getUsdPrice() {
        return this.usdPrice;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getExtraAmount() {
        return this.extraAmount;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final BigDecimal getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getPriceCode() {
        return this.priceCode;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDisplayPrice() {
        return this.displayPrice;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final VirtualCurrencyBundle copy(String virtualCurrencyName, String sku, BigDecimal usdPrice, int amount, int extraAmount, BigDecimal price, String priceCode, String displayPrice, String title, String detail, String customAttribute) {
        Intrinsics.checkNotNullParameter(virtualCurrencyName, "virtualCurrencyName");
        Intrinsics.checkNotNullParameter(sku, "sku");
        Intrinsics.checkNotNullParameter(usdPrice, "usdPrice");
        return new VirtualCurrencyBundle(virtualCurrencyName, sku, usdPrice, amount, extraAmount, price, priceCode, displayPrice, title, detail, customAttribute);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VirtualCurrencyBundle)) {
            return false;
        }
        VirtualCurrencyBundle virtualCurrencyBundle = (VirtualCurrencyBundle) other;
        return Intrinsics.areEqual(this.virtualCurrencyName, virtualCurrencyBundle.virtualCurrencyName) && Intrinsics.areEqual(this.sku, virtualCurrencyBundle.sku) && Intrinsics.areEqual(this.usdPrice, virtualCurrencyBundle.usdPrice) && this.amount == virtualCurrencyBundle.amount && this.extraAmount == virtualCurrencyBundle.extraAmount && Intrinsics.areEqual(this.price, virtualCurrencyBundle.price) && Intrinsics.areEqual(this.priceCode, virtualCurrencyBundle.priceCode) && Intrinsics.areEqual(this.displayPrice, virtualCurrencyBundle.displayPrice) && Intrinsics.areEqual(this.title, virtualCurrencyBundle.title) && Intrinsics.areEqual(this.detail, virtualCurrencyBundle.detail) && Intrinsics.areEqual(this.customAttribute, virtualCurrencyBundle.customAttribute);
    }

    public final int getAmount() {
        return this.amount;
    }

    public final String getCustomAttribute() {
        return this.customAttribute;
    }

    public final String getDetail() {
        return this.detail;
    }

    public final String getDisplayPrice() {
        return this.displayPrice;
    }

    public final int getExtraAmount() {
        return this.extraAmount;
    }

    public final BigDecimal getPrice() {
        return this.price;
    }

    public final String getPriceCode() {
        return this.priceCode;
    }

    public final String getSku() {
        return this.sku;
    }

    public final String getTitle() {
        return this.title;
    }

    public final BigDecimal getUsdPrice() {
        return this.usdPrice;
    }

    public final String getVirtualCurrencyName() {
        return this.virtualCurrencyName;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.virtualCurrencyName.hashCode() * 31) + this.sku.hashCode()) * 31) + this.usdPrice.hashCode()) * 31) + Integer.hashCode(this.amount)) * 31) + Integer.hashCode(this.extraAmount)) * 31;
        BigDecimal bigDecimal = this.price;
        int iHashCode2 = (iHashCode + (bigDecimal == null ? 0 : bigDecimal.hashCode())) * 31;
        String str = this.priceCode;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.displayPrice;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.detail;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.customAttribute;
        return iHashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("VirtualCurrencyBundle(virtualCurrencyName=");
        sb.append(this.virtualCurrencyName).append(", sku=").append(this.sku).append(", usdPrice=").append(this.usdPrice).append(", amount=").append(this.amount).append(", extraAmount=").append(this.extraAmount).append(", price=").append(this.price).append(", priceCode=").append(this.priceCode).append(", displayPrice=").append(this.displayPrice).append(", title=").append(this.title).append(", detail=").append(this.detail).append(", customAttribute=").append(this.customAttribute).append(')');
        return sb.toString();
    }

    public /* synthetic */ VirtualCurrencyBundle(String str, String str2, BigDecimal bigDecimal, int i, int i2, BigDecimal bigDecimal2, String str3, String str4, String str5, String str6, String str7, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, bigDecimal, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? 0 : i2, (i3 & 32) != 0 ? null : bigDecimal2, (i3 & 64) != 0 ? null : str3, (i3 & 128) != 0 ? null : str4, (i3 & 256) != 0 ? null : str5, (i3 & 512) != 0 ? null : str6, (i3 & 1024) != 0 ? null : str7);
    }
}
