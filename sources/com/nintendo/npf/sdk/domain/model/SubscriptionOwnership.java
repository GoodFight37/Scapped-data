package com.nintendo.npf.sdk.domain.model;

import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\tJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/nintendo/npf/sdk/domain/model/SubscriptionOwnership;", "", "", MapperConstants.SUBSCRIPTION_FIELD_OWNERSHIP_RESULT, "", MapperConstants.SUBSCRIPTION_FIELD_OWNERSHIP_ALLOWED_SINCE, "<init>", "(IJ)V", "component1", "()I", "component2", "()J", "copy", "(IJ)Lcom/nintendo/npf/sdk/domain/model/SubscriptionOwnership;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getResult", "b", "J", "getAllowedSince", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SubscriptionOwnership {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int result;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final long allowedSince;

    public SubscriptionOwnership(int i, long j) {
        this.result = i;
        this.allowedSince = j;
    }

    public static /* synthetic */ SubscriptionOwnership copy$default(SubscriptionOwnership subscriptionOwnership, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = subscriptionOwnership.result;
        }
        if ((i2 & 2) != 0) {
            j = subscriptionOwnership.allowedSince;
        }
        return subscriptionOwnership.copy(i, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getResult() {
        return this.result;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getAllowedSince() {
        return this.allowedSince;
    }

    public final SubscriptionOwnership copy(int result, long allowedSince) {
        return new SubscriptionOwnership(result, allowedSince);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionOwnership)) {
            return false;
        }
        SubscriptionOwnership subscriptionOwnership = (SubscriptionOwnership) other;
        return this.result == subscriptionOwnership.result && this.allowedSince == subscriptionOwnership.allowedSince;
    }

    public final long getAllowedSince() {
        return this.allowedSince;
    }

    public final int getResult() {
        return this.result;
    }

    public int hashCode() {
        return (Integer.hashCode(this.result) * 31) + Long.hashCode(this.allowedSince);
    }

    public String toString() {
        return "SubscriptionOwnership(result=" + this.result + ", allowedSince=" + this.allowedSince + ')';
    }
}
