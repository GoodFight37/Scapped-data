package com.nintendo.npf.sdk.user;

import com.nintendo.npf.sdk.core.f2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0019\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/nintendo/npf/sdk/user/TransferCode;", "Lcom/nintendo/npf/sdk/core/f2;", "", "identifier", "code", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/nintendo/npf/sdk/user/TransferCode;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getIdentifier", "b", "getCode", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TransferCode implements f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String identifier;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String code;

    public TransferCode(String identifier, String code) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(code, "code");
        this.identifier = identifier;
        this.code = code;
    }

    public static /* synthetic */ TransferCode copy$default(TransferCode transferCode, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = transferCode.identifier;
        }
        if ((i & 2) != 0) {
            str2 = transferCode.code;
        }
        return transferCode.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    public final TransferCode copy(String identifier, String code) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(code, "code");
        return new TransferCode(identifier, code);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransferCode)) {
            return false;
        }
        TransferCode transferCode = (TransferCode) other;
        return Intrinsics.areEqual(this.identifier, transferCode.identifier) && Intrinsics.areEqual(this.code, transferCode.code);
    }

    @Override // com.nintendo.npf.sdk.core.f2, com.nintendo.npf.sdk.internal.bridge.protobuf.TransferCodeOrBuilder
    public String getCode() {
        return this.code;
    }

    @Override // com.nintendo.npf.sdk.core.f2, com.nintendo.npf.sdk.internal.bridge.protobuf.TransferCodeOrBuilder
    public String getIdentifier() {
        return this.identifier;
    }

    public int hashCode() {
        return (this.identifier.hashCode() * 31) + this.code.hashCode();
    }

    public String toString() {
        return "TransferCode(identifier=" + this.identifier + ", code=" + this.code + ')';
    }
}
