package com.nintendo.npf.sdk.analytics;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/nintendo/npf/sdk/analytics/ResettableIdType;", "", "", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "a", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "INTERNAL_ANALYSIS", "TARGET_MARKETING", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum ResettableIdType {
    INTERNAL_ANALYSIS("internalAnalysis"),
    TARGET_MARKETING("targetMarketing");


    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String value;

    ResettableIdType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
