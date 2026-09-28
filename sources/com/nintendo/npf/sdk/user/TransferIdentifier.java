package com.nintendo.npf.sdk.user;

import com.nintendo.npf.sdk.core.g2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/nintendo/npf/sdk/user/TransferIdentifier;", "Lcom/nintendo/npf/sdk/core/g2;", "", "value", "<init>", "(Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "copy", "(Ljava/lang/String;)Lcom/nintendo/npf/sdk/user/TransferIdentifier;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getValue", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TransferIdentifier implements g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String value;

    public TransferIdentifier(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    public static /* synthetic */ TransferIdentifier copy$default(TransferIdentifier transferIdentifier, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = transferIdentifier.value;
        }
        return transferIdentifier.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final TransferIdentifier copy(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new TransferIdentifier(value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TransferIdentifier) && Intrinsics.areEqual(this.value, ((TransferIdentifier) other).value);
    }

    @Override // com.nintendo.npf.sdk.core.g2, com.nintendo.npf.sdk.internal.bridge.protobuf.TransferIdentifierOrBuilder
    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return "TransferIdentifier(value=" + this.value + ')';
    }
}
