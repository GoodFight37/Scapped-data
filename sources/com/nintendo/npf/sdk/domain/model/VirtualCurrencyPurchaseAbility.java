package com.nintendo.npf.sdk.domain.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0003\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/nintendo/npf/sdk/domain/model/VirtualCurrencyPurchaseAbility;", "", "", "isEnabled", "<init>", "(Z)V", "component1", "()Z", "copy", "(Z)Lcom/nintendo/npf/sdk/domain/model/VirtualCurrencyPurchaseAbility;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Z", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VirtualCurrencyPurchaseAbility {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isEnabled;

    public VirtualCurrencyPurchaseAbility(boolean z) {
        this.isEnabled = z;
    }

    public static /* synthetic */ VirtualCurrencyPurchaseAbility copy$default(VirtualCurrencyPurchaseAbility virtualCurrencyPurchaseAbility, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = virtualCurrencyPurchaseAbility.isEnabled;
        }
        return virtualCurrencyPurchaseAbility.copy(z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    public final VirtualCurrencyPurchaseAbility copy(boolean isEnabled) {
        return new VirtualCurrencyPurchaseAbility(isEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof VirtualCurrencyPurchaseAbility) && this.isEnabled == ((VirtualCurrencyPurchaseAbility) other).isEnabled;
    }

    public int hashCode() {
        boolean z = this.isEnabled;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public String toString() {
        return "VirtualCurrencyPurchaseAbility(isEnabled=" + this.isEnabled + ')';
    }
}
