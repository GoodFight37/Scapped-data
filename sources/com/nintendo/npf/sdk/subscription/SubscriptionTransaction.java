package com.nintendo.npf.sdk.subscription;

import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.internal.model.ISubscriptionTransaction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/nintendo/npf/sdk/subscription/SubscriptionTransaction;", "Lcom/nintendo/npf/sdk/internal/model/ISubscriptionTransaction;", "orderId", "", "productId", MapperConstants.SUBSCRIPTION_FIELD_STATE, "Lcom/nintendo/npf/sdk/subscription/SubscriptionTransactionState;", "(Ljava/lang/String;Ljava/lang/String;Lcom/nintendo/npf/sdk/subscription/SubscriptionTransactionState;)V", "getOrderId", "()Ljava/lang/String;", "getProductId", "getState", "()Lcom/nintendo/npf/sdk/subscription/SubscriptionTransactionState;", "stateString", "getStateString", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SubscriptionTransaction implements ISubscriptionTransaction {
    private final String orderId;
    private final String productId;
    private final SubscriptionTransactionState state;
    private final String stateString;

    public SubscriptionTransaction(String str, String productId, SubscriptionTransactionState state) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(state, "state");
        this.orderId = str;
        this.productId = productId;
        this.state = state;
        this.stateString = state.name();
    }

    public static /* synthetic */ SubscriptionTransaction copy$default(SubscriptionTransaction subscriptionTransaction, String str, String str2, SubscriptionTransactionState subscriptionTransactionState, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subscriptionTransaction.orderId;
        }
        if ((i & 2) != 0) {
            str2 = subscriptionTransaction.productId;
        }
        if ((i & 4) != 0) {
            subscriptionTransactionState = subscriptionTransaction.state;
        }
        return subscriptionTransaction.copy(str, str2, subscriptionTransactionState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOrderId() {
        return this.orderId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final SubscriptionTransactionState getState() {
        return this.state;
    }

    public final SubscriptionTransaction copy(String orderId, String productId, SubscriptionTransactionState state) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(state, "state");
        return new SubscriptionTransaction(orderId, productId, state);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionTransaction)) {
            return false;
        }
        SubscriptionTransaction subscriptionTransaction = (SubscriptionTransaction) other;
        return Intrinsics.areEqual(this.orderId, subscriptionTransaction.orderId) && Intrinsics.areEqual(this.productId, subscriptionTransaction.productId) && this.state == subscriptionTransaction.state;
    }

    @Override // com.nintendo.npf.sdk.internal.model.ISubscriptionTransaction, com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionOrBuilder
    public String getOrderId() {
        return this.orderId;
    }

    @Override // com.nintendo.npf.sdk.internal.model.ISubscriptionTransaction, com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionOrBuilder
    public String getProductId() {
        return this.productId;
    }

    public final SubscriptionTransactionState getState() {
        return this.state;
    }

    @Override // com.nintendo.npf.sdk.internal.model.ISubscriptionTransaction
    public String getStateString() {
        return this.stateString;
    }

    public int hashCode() {
        String str = this.orderId;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.productId.hashCode()) * 31) + this.state.hashCode();
    }

    public String toString() {
        return "SubscriptionTransaction(orderId=" + this.orderId + ", productId=" + this.productId + ", state=" + this.state + ')';
    }
}
