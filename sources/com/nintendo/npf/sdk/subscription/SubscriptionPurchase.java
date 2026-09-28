package com.nintendo.npf.sdk.subscription;

import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003Jc\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u0006HÆ\u0001J\u0013\u0010'\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019¨\u0006,"}, d2 = {"Lcom/nintendo/npf/sdk/subscription/SubscriptionPurchase;", "", MapperConstants.SUBSCRIPTION_FIELD_SUBSCRIPTION_ID, "", "productId", MapperConstants.SUBSCRIPTION_FIELD_STARTS_AT, "", MapperConstants.SUBSCRIPTION_FIELD_ENDS_AT, "market", "Lcom/nintendo/npf/sdk/subscription/SubscriptionMarket;", MapperConstants.SUBSCRIPTION_FIELD_IN_FREE_TRIAL_PERIOD, "", MapperConstants.SUBSCRIPTION_FIELD_REVOKED_AT, MapperConstants.SUBSCRIPTION_FIELD_AUTO_RENEWING, MapperConstants.SUBSCRIPTION_FIELD_AUTO_RENEWING_UPDATED_AT, "(Ljava/lang/String;Ljava/lang/String;JJLcom/nintendo/npf/sdk/subscription/SubscriptionMarket;ZJZJ)V", "getAutoRenewing", "()Z", "getAutoRenewingUpdatedAt", "()J", "getEndsAt", "getInFreeTrialPeriod", "getMarket", "()Lcom/nintendo/npf/sdk/subscription/SubscriptionMarket;", "getProductId", "()Ljava/lang/String;", "getRevokedAt", "getStartsAt", "getSubscriptionId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SubscriptionPurchase {
    private final boolean autoRenewing;
    private final long autoRenewingUpdatedAt;
    private final long endsAt;
    private final boolean inFreeTrialPeriod;
    private final SubscriptionMarket market;
    private final String productId;
    private final long revokedAt;
    private final long startsAt;
    private final String subscriptionId;

    public SubscriptionPurchase(String subscriptionId, String productId, long j, long j2, SubscriptionMarket market, boolean z, long j3, boolean z2, long j4) {
        Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(market, "market");
        this.subscriptionId = subscriptionId;
        this.productId = productId;
        this.startsAt = j;
        this.endsAt = j2;
        this.market = market;
        this.inFreeTrialPeriod = z;
        this.revokedAt = j3;
        this.autoRenewing = z2;
        this.autoRenewingUpdatedAt = j4;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubscriptionId() {
        return this.subscriptionId;
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
    public final SubscriptionMarket getMarket() {
        return this.market;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getInFreeTrialPeriod() {
        return this.inFreeTrialPeriod;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getRevokedAt() {
        return this.revokedAt;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getAutoRenewing() {
        return this.autoRenewing;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getAutoRenewingUpdatedAt() {
        return this.autoRenewingUpdatedAt;
    }

    public final SubscriptionPurchase copy(String subscriptionId, String productId, long startsAt, long endsAt, SubscriptionMarket market, boolean inFreeTrialPeriod, long revokedAt, boolean autoRenewing, long autoRenewingUpdatedAt) {
        Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(market, "market");
        return new SubscriptionPurchase(subscriptionId, productId, startsAt, endsAt, market, inFreeTrialPeriod, revokedAt, autoRenewing, autoRenewingUpdatedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionPurchase)) {
            return false;
        }
        SubscriptionPurchase subscriptionPurchase = (SubscriptionPurchase) other;
        return Intrinsics.areEqual(this.subscriptionId, subscriptionPurchase.subscriptionId) && Intrinsics.areEqual(this.productId, subscriptionPurchase.productId) && this.startsAt == subscriptionPurchase.startsAt && this.endsAt == subscriptionPurchase.endsAt && this.market == subscriptionPurchase.market && this.inFreeTrialPeriod == subscriptionPurchase.inFreeTrialPeriod && this.revokedAt == subscriptionPurchase.revokedAt && this.autoRenewing == subscriptionPurchase.autoRenewing && this.autoRenewingUpdatedAt == subscriptionPurchase.autoRenewingUpdatedAt;
    }

    public final boolean getAutoRenewing() {
        return this.autoRenewing;
    }

    public final long getAutoRenewingUpdatedAt() {
        return this.autoRenewingUpdatedAt;
    }

    public final long getEndsAt() {
        return this.endsAt;
    }

    public final boolean getInFreeTrialPeriod() {
        return this.inFreeTrialPeriod;
    }

    public final SubscriptionMarket getMarket() {
        return this.market;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final long getRevokedAt() {
        return this.revokedAt;
    }

    public final long getStartsAt() {
        return this.startsAt;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((this.subscriptionId.hashCode() * 31) + this.productId.hashCode()) * 31) + Long.hashCode(this.startsAt)) * 31) + Long.hashCode(this.endsAt)) * 31) + this.market.hashCode()) * 31;
        boolean z = this.inFreeTrialPeriod;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((iHashCode + r1) * 31) + Long.hashCode(this.revokedAt)) * 31;
        boolean z2 = this.autoRenewing;
        return ((iHashCode2 + (z2 ? 1 : z2)) * 31) + Long.hashCode(this.autoRenewingUpdatedAt);
    }

    public String toString() {
        return "SubscriptionPurchase(subscriptionId=" + this.subscriptionId + ", productId=" + this.productId + ", startsAt=" + this.startsAt + ", endsAt=" + this.endsAt + ", market=" + this.market + ", inFreeTrialPeriod=" + this.inFreeTrialPeriod + ", revokedAt=" + this.revokedAt + ", autoRenewing=" + this.autoRenewing + ", autoRenewingUpdatedAt=" + this.autoRenewingUpdatedAt + ')';
    }

    public /* synthetic */ SubscriptionPurchase(String str, String str2, long j, long j2, SubscriptionMarket subscriptionMarket, boolean z, long j3, boolean z2, long j4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? 0L : j, (i & 8) != 0 ? 0L : j2, subscriptionMarket, (i & 32) != 0 ? false : z, (i & 64) != 0 ? 0L : j3, (i & 128) != 0 ? false : z2, (i & 256) != 0 ? 0L : j4);
    }
}
