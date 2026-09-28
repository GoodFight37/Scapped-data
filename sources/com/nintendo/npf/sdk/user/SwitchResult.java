package com.nintendo.npf.sdk.user;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/nintendo/npf/sdk/user/SwitchResult;", "", "", "oldUserId", "newUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/nintendo/npf/sdk/user/SwitchResult;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getOldUserId", "b", "getNewUserId", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SwitchResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String oldUserId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String newUserId;

    public SwitchResult(String oldUserId, String newUserId) {
        Intrinsics.checkNotNullParameter(oldUserId, "oldUserId");
        Intrinsics.checkNotNullParameter(newUserId, "newUserId");
        this.oldUserId = oldUserId;
        this.newUserId = newUserId;
    }

    public static /* synthetic */ SwitchResult copy$default(SwitchResult switchResult, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = switchResult.oldUserId;
        }
        if ((i & 2) != 0) {
            str2 = switchResult.newUserId;
        }
        return switchResult.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOldUserId() {
        return this.oldUserId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNewUserId() {
        return this.newUserId;
    }

    public final SwitchResult copy(String oldUserId, String newUserId) {
        Intrinsics.checkNotNullParameter(oldUserId, "oldUserId");
        Intrinsics.checkNotNullParameter(newUserId, "newUserId");
        return new SwitchResult(oldUserId, newUserId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SwitchResult)) {
            return false;
        }
        SwitchResult switchResult = (SwitchResult) other;
        return Intrinsics.areEqual(this.oldUserId, switchResult.oldUserId) && Intrinsics.areEqual(this.newUserId, switchResult.newUserId);
    }

    public final String getNewUserId() {
        return this.newUserId;
    }

    public final String getOldUserId() {
        return this.oldUserId;
    }

    public int hashCode() {
        return (this.oldUserId.hashCode() * 31) + this.newUserId.hashCode();
    }

    public String toString() {
        return "SwitchResult(oldUserId=" + this.oldUserId + ", newUserId=" + this.newUserId + ')';
    }
}
