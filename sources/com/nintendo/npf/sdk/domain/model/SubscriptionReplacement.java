package com.nintendo.npf.sdk.domain.model;

import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\rJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/nintendo/npf/sdk/domain/model/SubscriptionReplacement;", "", "", "productId", MapperConstants.SUBSCRIPTION_FIELD_ORIGINAL_ORDER_ID, "", MapperConstants.SUBSCRIPTION_FIELD_REPLACEMENT_MODE, "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()I", "copy", "(Ljava/lang/String;Ljava/lang/String;I)Lcom/nintendo/npf/sdk/domain/model/SubscriptionReplacement;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getProductId", "b", "getOriginalOrderId", "c", "I", "getReplacementMode", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SubscriptionReplacement {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String productId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String originalOrderId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final int replacementMode;

    public SubscriptionReplacement(String productId, String originalOrderId, int i) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(originalOrderId, "originalOrderId");
        this.productId = productId;
        this.originalOrderId = originalOrderId;
        this.replacementMode = i;
    }

    public static /* synthetic */ SubscriptionReplacement copy$default(SubscriptionReplacement subscriptionReplacement, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = subscriptionReplacement.productId;
        }
        if ((i2 & 2) != 0) {
            str2 = subscriptionReplacement.originalOrderId;
        }
        if ((i2 & 4) != 0) {
            i = subscriptionReplacement.replacementMode;
        }
        return subscriptionReplacement.copy(str, str2, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOriginalOrderId() {
        return this.originalOrderId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getReplacementMode() {
        return this.replacementMode;
    }

    public final SubscriptionReplacement copy(String productId, String originalOrderId, int replacementMode) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(originalOrderId, "originalOrderId");
        return new SubscriptionReplacement(productId, originalOrderId, replacementMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionReplacement)) {
            return false;
        }
        SubscriptionReplacement subscriptionReplacement = (SubscriptionReplacement) other;
        return Intrinsics.areEqual(this.productId, subscriptionReplacement.productId) && Intrinsics.areEqual(this.originalOrderId, subscriptionReplacement.originalOrderId) && this.replacementMode == subscriptionReplacement.replacementMode;
    }

    public final String getOriginalOrderId() {
        return this.originalOrderId;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final int getReplacementMode() {
        return this.replacementMode;
    }

    public int hashCode() {
        return (((this.productId.hashCode() * 31) + this.originalOrderId.hashCode()) * 31) + Integer.hashCode(this.replacementMode);
    }

    public String toString() {
        return "SubscriptionReplacement(productId=" + this.productId + ", originalOrderId=" + this.originalOrderId + ", replacementMode=" + this.replacementMode + ')';
    }
}
