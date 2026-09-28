package com.nintendo.npf.sdk.user;

import com.nintendo.npf.sdk.core.h2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\nJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\nR\u001a\u0010\u0005\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\nR\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\n¨\u0006\""}, d2 = {"Lcom/nintendo/npf/sdk/user/TransferSwitchResult;", "Lcom/nintendo/npf/sdk/core/h2;", "", "oldUserId", "newUserId", "usedTransferId", "usedTransferCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/nintendo/npf/sdk/user/TransferSwitchResult;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getOldUserId", "b", "getNewUserId", "c", "getUsedTransferId", "d", "getUsedTransferCode", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TransferSwitchResult implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String oldUserId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String newUserId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String usedTransferId;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final String usedTransferCode;

    public TransferSwitchResult(String oldUserId, String newUserId, String usedTransferId, String usedTransferCode) {
        Intrinsics.checkNotNullParameter(oldUserId, "oldUserId");
        Intrinsics.checkNotNullParameter(newUserId, "newUserId");
        Intrinsics.checkNotNullParameter(usedTransferId, "usedTransferId");
        Intrinsics.checkNotNullParameter(usedTransferCode, "usedTransferCode");
        this.oldUserId = oldUserId;
        this.newUserId = newUserId;
        this.usedTransferId = usedTransferId;
        this.usedTransferCode = usedTransferCode;
    }

    public static /* synthetic */ TransferSwitchResult copy$default(TransferSwitchResult transferSwitchResult, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = transferSwitchResult.oldUserId;
        }
        if ((i & 2) != 0) {
            str2 = transferSwitchResult.newUserId;
        }
        if ((i & 4) != 0) {
            str3 = transferSwitchResult.usedTransferId;
        }
        if ((i & 8) != 0) {
            str4 = transferSwitchResult.usedTransferCode;
        }
        return transferSwitchResult.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOldUserId() {
        return this.oldUserId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNewUserId() {
        return this.newUserId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUsedTransferId() {
        return this.usedTransferId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUsedTransferCode() {
        return this.usedTransferCode;
    }

    public final TransferSwitchResult copy(String oldUserId, String newUserId, String usedTransferId, String usedTransferCode) {
        Intrinsics.checkNotNullParameter(oldUserId, "oldUserId");
        Intrinsics.checkNotNullParameter(newUserId, "newUserId");
        Intrinsics.checkNotNullParameter(usedTransferId, "usedTransferId");
        Intrinsics.checkNotNullParameter(usedTransferCode, "usedTransferCode");
        return new TransferSwitchResult(oldUserId, newUserId, usedTransferId, usedTransferCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransferSwitchResult)) {
            return false;
        }
        TransferSwitchResult transferSwitchResult = (TransferSwitchResult) other;
        return Intrinsics.areEqual(this.oldUserId, transferSwitchResult.oldUserId) && Intrinsics.areEqual(this.newUserId, transferSwitchResult.newUserId) && Intrinsics.areEqual(this.usedTransferId, transferSwitchResult.usedTransferId) && Intrinsics.areEqual(this.usedTransferCode, transferSwitchResult.usedTransferCode);
    }

    @Override // com.nintendo.npf.sdk.core.h2, com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
    public String getNewUserId() {
        return this.newUserId;
    }

    @Override // com.nintendo.npf.sdk.core.h2, com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
    public String getOldUserId() {
        return this.oldUserId;
    }

    @Override // com.nintendo.npf.sdk.core.h2, com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
    public String getUsedTransferCode() {
        return this.usedTransferCode;
    }

    @Override // com.nintendo.npf.sdk.core.h2, com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
    public String getUsedTransferId() {
        return this.usedTransferId;
    }

    public int hashCode() {
        return (((((this.oldUserId.hashCode() * 31) + this.newUserId.hashCode()) * 31) + this.usedTransferId.hashCode()) * 31) + this.usedTransferCode.hashCode();
    }

    public String toString() {
        return "TransferSwitchResult(oldUserId=" + this.oldUserId + ", newUserId=" + this.newUserId + ", usedTransferId=" + this.usedTransferId + ", usedTransferCode=" + this.usedTransferCode + ')';
    }
}
