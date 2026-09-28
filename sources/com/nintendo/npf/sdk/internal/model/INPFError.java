package com.nintendo.npf.sdk.internal.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0012\u0010\u000e\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/nintendo/npf/sdk/internal/model/INPFError;", "", "errorCode", "", "getErrorCode", "()I", "errorMessage", "", "getErrorMessage", "()Ljava/lang/String;", "errorTypeString", "getErrorTypeString", "originalErrorMessage", "getOriginalErrorMessage", "originalErrorTypeString", "getOriginalErrorTypeString", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface INPFError {
    int getErrorCode();

    String getErrorMessage();

    String getErrorTypeString();

    String getOriginalErrorMessage();

    String getOriginalErrorTypeString();
}
