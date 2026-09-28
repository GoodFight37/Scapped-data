package com.nintendo.npf.sdk.inquiry;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/nintendo/npf/sdk/inquiry/InquiryStatus;", "", "isHavingUnreadComments", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class InquiryStatus {
    private final boolean isHavingUnreadComments;

    public InquiryStatus() {
        this(false, 1, null);
    }

    public static /* synthetic */ InquiryStatus copy$default(InquiryStatus inquiryStatus, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = inquiryStatus.isHavingUnreadComments;
        }
        return inquiryStatus.copy(z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsHavingUnreadComments() {
        return this.isHavingUnreadComments;
    }

    public final InquiryStatus copy(boolean isHavingUnreadComments) {
        return new InquiryStatus(isHavingUnreadComments);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof InquiryStatus) && this.isHavingUnreadComments == ((InquiryStatus) other).isHavingUnreadComments;
    }

    public int hashCode() {
        boolean z = this.isHavingUnreadComments;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final boolean isHavingUnreadComments() {
        return this.isHavingUnreadComments;
    }

    public String toString() {
        return "InquiryStatus(isHavingUnreadComments=" + this.isHavingUnreadComments + ')';
    }

    public InquiryStatus(boolean z) {
        this.isHavingUnreadComments = z;
    }

    public /* synthetic */ InquiryStatus(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
