package com.nintendo.npf.sdk.vcm;

import com.nintendo.npf.sdk.core.i2;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ0\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001b\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\rR\u001a\u0010\u001e\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\n¨\u0006 "}, d2 = {"Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyTransaction;", "Lcom/nintendo/npf/sdk/core/i2;", "", "orderId", "sku", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyTransactionState;", MapperConstants.SUBSCRIPTION_FIELD_STATE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyTransactionState;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyTransactionState;", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyTransactionState;)Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyTransaction;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getOrderId", "getSku", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyTransactionState;", "getState", "stateString", "getStateString", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VirtualCurrencyTransaction implements i2 {
    private final String orderId;
    private final String sku;
    private final VirtualCurrencyTransactionState state;
    private final String stateString;

    public VirtualCurrencyTransaction(String str, String sku, VirtualCurrencyTransactionState state) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        Intrinsics.checkNotNullParameter(state, "state");
        this.orderId = str;
        this.sku = sku;
        this.state = state;
        this.stateString = state.name();
    }

    public static /* synthetic */ VirtualCurrencyTransaction copy$default(VirtualCurrencyTransaction virtualCurrencyTransaction, String str, String str2, VirtualCurrencyTransactionState virtualCurrencyTransactionState, int i, Object obj) {
        if ((i & 1) != 0) {
            str = virtualCurrencyTransaction.orderId;
        }
        if ((i & 2) != 0) {
            str2 = virtualCurrencyTransaction.sku;
        }
        if ((i & 4) != 0) {
            virtualCurrencyTransactionState = virtualCurrencyTransaction.state;
        }
        return virtualCurrencyTransaction.copy(str, str2, virtualCurrencyTransactionState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOrderId() {
        return this.orderId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSku() {
        return this.sku;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final VirtualCurrencyTransactionState getState() {
        return this.state;
    }

    public final VirtualCurrencyTransaction copy(String orderId, String sku, VirtualCurrencyTransactionState state) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        Intrinsics.checkNotNullParameter(state, "state");
        return new VirtualCurrencyTransaction(orderId, sku, state);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VirtualCurrencyTransaction)) {
            return false;
        }
        VirtualCurrencyTransaction virtualCurrencyTransaction = (VirtualCurrencyTransaction) other;
        return Intrinsics.areEqual(this.orderId, virtualCurrencyTransaction.orderId) && Intrinsics.areEqual(this.sku, virtualCurrencyTransaction.sku) && this.state == virtualCurrencyTransaction.state;
    }

    @Override // com.nintendo.npf.sdk.core.i2, com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionOrBuilder
    public String getOrderId() {
        return this.orderId;
    }

    @Override // com.nintendo.npf.sdk.core.i2, com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionOrBuilder
    public String getSku() {
        return this.sku;
    }

    public final VirtualCurrencyTransactionState getState() {
        return this.state;
    }

    @Override // com.nintendo.npf.sdk.core.i2
    public String getStateString() {
        return this.stateString;
    }

    public int hashCode() {
        String str = this.orderId;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.sku.hashCode()) * 31) + this.state.hashCode();
    }

    public String toString() {
        return "VirtualCurrencyTransaction(orderId=" + this.orderId + ", sku=" + this.sku + ", state=" + this.state + ')';
    }
}
