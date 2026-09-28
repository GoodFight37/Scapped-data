package com.nintendo.npf.sdk.subscription;

import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b6\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BÕ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006¢\u0006\u0002\u0010\u0018J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0006HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0006HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010=\u001a\u00020\nHÆ\u0003J\u0017\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jß\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u0006HÆ\u0001J\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020\nHÖ\u0001J\t\u0010F\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001cR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001c¨\u0006G"}, d2 = {"Lcom/nintendo/npf/sdk/subscription/SubscriptionProduct;", "", MapperConstants.SUBSCRIPTION_FIELD_SUBSCRIPTION_ID, "", "productId", MapperConstants.SUBSCRIPTION_FIELD_STARTS_AT, "", MapperConstants.SUBSCRIPTION_FIELD_ENDS_AT, MapperConstants.SUBSCRIPTION_FIELD_GROUP, "level", "", MapperConstants.SUBSCRIPTION_FIELD_ATTRIBUTES, "", MapperConstants.SUBSCRIPTION_FIELD_SUBSCRIPTION_PERIOD, "freeTrialPeriod", MapperConstants.SUBSCRIPTION_FIELD_INTRODUCTORY_PRICE_PERIOD, MapperConstants.SUBSCRIPTION_FIELD_INTRODUCTORY_PRICE_CYCLES, "title", MapperConstants.SUBSCRIPTION_FIELD_DESCRIPTION, "price", MapperConstants.SUBSCRIPTION_FIELD_PRICE_CURRENCY_CODE, MapperConstants.SUBSCRIPTION_FIELD_PRICE_AMOUNT_MICROS, MapperConstants.SUBSCRIPTION_FIELD_INTRODUCTORY_PRICE, MapperConstants.SUBSCRIPTION_FIELD_INTRODUCTORY_PRICE_AMOUNT_MICROS, "(Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;ILjava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;J)V", "getAttributes", "()Ljava/util/Map;", "getDescription", "()Ljava/lang/String;", "getEndsAt", "()J", "getFreeTrialPeriod", "getGroup", "getIntroductoryPrice", "getIntroductoryPriceAmountMicros", "getIntroductoryPriceCycles", "getIntroductoryPricePeriod", "getLevel", "()I", "getPrice", "getPriceAmountMicros", "getPriceCurrencyCode", "getProductId", "getStartsAt", "getSubscriptionId", "getSubscriptionPeriod", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SubscriptionProduct {
    private final Map<String, String> attributes;
    private final String description;
    private final long endsAt;
    private final String freeTrialPeriod;
    private final String group;
    private final String introductoryPrice;
    private final long introductoryPriceAmountMicros;
    private final String introductoryPriceCycles;
    private final String introductoryPricePeriod;
    private final int level;
    private final String price;
    private final long priceAmountMicros;
    private final String priceCurrencyCode;
    private final String productId;
    private final long startsAt;
    private final String subscriptionId;
    private final String subscriptionPeriod;
    private final String title;

    public SubscriptionProduct(String subscriptionId, String productId, long j, long j2, String str, int i, Map<String, String> map, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, long j3, String str10, long j4) {
        Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
        Intrinsics.checkNotNullParameter(productId, "productId");
        this.subscriptionId = subscriptionId;
        this.productId = productId;
        this.startsAt = j;
        this.endsAt = j2;
        this.group = str;
        this.level = i;
        this.attributes = map;
        this.subscriptionPeriod = str2;
        this.freeTrialPeriod = str3;
        this.introductoryPricePeriod = str4;
        this.introductoryPriceCycles = str5;
        this.title = str6;
        this.description = str7;
        this.price = str8;
        this.priceCurrencyCode = str9;
        this.priceAmountMicros = j3;
        this.introductoryPrice = str10;
        this.introductoryPriceAmountMicros = j4;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getIntroductoryPricePeriod() {
        return this.introductoryPricePeriod;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getIntroductoryPriceCycles() {
        return this.introductoryPriceCycles;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getPriceCurrencyCode() {
        return this.priceCurrencyCode;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final long getPriceAmountMicros() {
        return this.priceAmountMicros;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getIntroductoryPrice() {
        return this.introductoryPrice;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final long getIntroductoryPriceAmountMicros() {
        return this.introductoryPriceAmountMicros;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getStartsAt() {
        return this.startsAt;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getEndsAt() {
        return this.endsAt;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getGroup() {
        return this.group;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    public final Map<String, String> component7() {
        return this.attributes;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getSubscriptionPeriod() {
        return this.subscriptionPeriod;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getFreeTrialPeriod() {
        return this.freeTrialPeriod;
    }

    public final SubscriptionProduct copy(String subscriptionId, String productId, long startsAt, long endsAt, String group, int level, Map<String, String> attributes, String subscriptionPeriod, String freeTrialPeriod, String introductoryPricePeriod, String introductoryPriceCycles, String title, String description, String price, String priceCurrencyCode, long priceAmountMicros, String introductoryPrice, long introductoryPriceAmountMicros) {
        Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
        Intrinsics.checkNotNullParameter(productId, "productId");
        return new SubscriptionProduct(subscriptionId, productId, startsAt, endsAt, group, level, attributes, subscriptionPeriod, freeTrialPeriod, introductoryPricePeriod, introductoryPriceCycles, title, description, price, priceCurrencyCode, priceAmountMicros, introductoryPrice, introductoryPriceAmountMicros);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionProduct)) {
            return false;
        }
        SubscriptionProduct subscriptionProduct = (SubscriptionProduct) other;
        return Intrinsics.areEqual(this.subscriptionId, subscriptionProduct.subscriptionId) && Intrinsics.areEqual(this.productId, subscriptionProduct.productId) && this.startsAt == subscriptionProduct.startsAt && this.endsAt == subscriptionProduct.endsAt && Intrinsics.areEqual(this.group, subscriptionProduct.group) && this.level == subscriptionProduct.level && Intrinsics.areEqual(this.attributes, subscriptionProduct.attributes) && Intrinsics.areEqual(this.subscriptionPeriod, subscriptionProduct.subscriptionPeriod) && Intrinsics.areEqual(this.freeTrialPeriod, subscriptionProduct.freeTrialPeriod) && Intrinsics.areEqual(this.introductoryPricePeriod, subscriptionProduct.introductoryPricePeriod) && Intrinsics.areEqual(this.introductoryPriceCycles, subscriptionProduct.introductoryPriceCycles) && Intrinsics.areEqual(this.title, subscriptionProduct.title) && Intrinsics.areEqual(this.description, subscriptionProduct.description) && Intrinsics.areEqual(this.price, subscriptionProduct.price) && Intrinsics.areEqual(this.priceCurrencyCode, subscriptionProduct.priceCurrencyCode) && this.priceAmountMicros == subscriptionProduct.priceAmountMicros && Intrinsics.areEqual(this.introductoryPrice, subscriptionProduct.introductoryPrice) && this.introductoryPriceAmountMicros == subscriptionProduct.introductoryPriceAmountMicros;
    }

    public final Map<String, String> getAttributes() {
        return this.attributes;
    }

    public final String getDescription() {
        return this.description;
    }

    public final long getEndsAt() {
        return this.endsAt;
    }

    public final String getFreeTrialPeriod() {
        return this.freeTrialPeriod;
    }

    public final String getGroup() {
        return this.group;
    }

    public final String getIntroductoryPrice() {
        return this.introductoryPrice;
    }

    public final long getIntroductoryPriceAmountMicros() {
        return this.introductoryPriceAmountMicros;
    }

    public final String getIntroductoryPriceCycles() {
        return this.introductoryPriceCycles;
    }

    public final String getIntroductoryPricePeriod() {
        return this.introductoryPricePeriod;
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getPrice() {
        return this.price;
    }

    public final long getPriceAmountMicros() {
        return this.priceAmountMicros;
    }

    public final String getPriceCurrencyCode() {
        return this.priceCurrencyCode;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final long getStartsAt() {
        return this.startsAt;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public final String getSubscriptionPeriod() {
        return this.subscriptionPeriod;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = ((((((this.subscriptionId.hashCode() * 31) + this.productId.hashCode()) * 31) + Long.hashCode(this.startsAt)) * 31) + Long.hashCode(this.endsAt)) * 31;
        String str = this.group;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.level)) * 31;
        Map<String, String> map = this.attributes;
        int iHashCode3 = (iHashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        String str2 = this.subscriptionPeriod;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.freeTrialPeriod;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.introductoryPricePeriod;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.introductoryPriceCycles;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.title;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.description;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.price;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.priceCurrencyCode;
        int iHashCode11 = (((iHashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31) + Long.hashCode(this.priceAmountMicros)) * 31;
        String str10 = this.introductoryPrice;
        return ((iHashCode11 + (str10 != null ? str10.hashCode() : 0)) * 31) + Long.hashCode(this.introductoryPriceAmountMicros);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SubscriptionProduct(subscriptionId=");
        sb.append(this.subscriptionId).append(", productId=").append(this.productId).append(", startsAt=").append(this.startsAt).append(", endsAt=").append(this.endsAt).append(", group=").append(this.group).append(", level=").append(this.level).append(", attributes=").append(this.attributes).append(", subscriptionPeriod=").append(this.subscriptionPeriod).append(", freeTrialPeriod=").append(this.freeTrialPeriod).append(", introductoryPricePeriod=").append(this.introductoryPricePeriod).append(", introductoryPriceCycles=").append(this.introductoryPriceCycles).append(", title=");
        sb.append(this.title).append(", description=").append(this.description).append(", price=").append(this.price).append(", priceCurrencyCode=").append(this.priceCurrencyCode).append(", priceAmountMicros=").append(this.priceAmountMicros).append(", introductoryPrice=").append(this.introductoryPrice).append(", introductoryPriceAmountMicros=").append(this.introductoryPriceAmountMicros).append(')');
        return sb.toString();
    }

    public /* synthetic */ SubscriptionProduct(String str, String str2, long j, long j2, String str3, int i, Map map, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, long j3, String str12, long j4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? 0L : j, (i2 & 8) != 0 ? 0L : j2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? 0 : i, map, (i2 & 128) != 0 ? null : str4, (i2 & 256) != 0 ? null : str5, (i2 & 512) != 0 ? null : str6, (i2 & 1024) != 0 ? null : str7, (i2 & 2048) != 0 ? null : str8, (i2 & 4096) != 0 ? null : str9, (i2 & 8192) != 0 ? null : str10, (i2 & 16384) != 0 ? null : str11, (32768 & i2) != 0 ? 0L : j3, (65536 & i2) != 0 ? null : str12, (i2 & 131072) != 0 ? 0L : j4);
    }
}
