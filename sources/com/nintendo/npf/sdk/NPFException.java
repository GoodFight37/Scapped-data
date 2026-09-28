package com.nintendo.npf.sdk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B#\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0005\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0014R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/nintendo/npf/sdk/NPFException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Lcom/nintendo/npf/sdk/NPFError;", "error", "<init>", "(Lcom/nintendo/npf/sdk/NPFError;)V", "Lcom/nintendo/npf/sdk/NPFError$ErrorType;", "errorType", "", "errorCode", "", "errorMessage", "(Lcom/nintendo/npf/sdk/NPFError$ErrorType;ILjava/lang/String;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "a", "Lcom/nintendo/npf/sdk/NPFError;", "getError", "()Lcom/nintendo/npf/sdk/NPFError;", "b", "Lcom/nintendo/npf/sdk/NPFError$ErrorType;", "getErrorType", "()Lcom/nintendo/npf/sdk/NPFError$ErrorType;", "c", "I", "getErrorCode", "d", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NPFException extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final NPFError error;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final NPFError.ErrorType errorType;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final int errorCode;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final String errorMessage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NPFException(NPFError error) {
        super(error.getErrorMessage());
        Intrinsics.checkNotNullParameter(error, "error");
        this.error = error;
        this.errorType = error.getErrorType();
        this.errorCode = error.getErrorCode();
        this.errorMessage = error.getErrorMessage();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(NPFException.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.nintendo.npf.sdk.NPFException");
        NPFException nPFException = (NPFException) other;
        return this.errorCode == nPFException.errorCode && Intrinsics.areEqual(this.error, nPFException.error) && this.errorType == nPFException.errorType && Intrinsics.areEqual(this.errorMessage, nPFException.errorMessage);
    }

    public final NPFError getError() {
        return this.error;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final NPFError.ErrorType getErrorType() {
        return this.errorType;
    }

    public int hashCode() {
        int iHashCode = ((((this.errorCode * 31) + this.error.hashCode()) * 31) + this.errorType.hashCode()) * 31;
        String str = this.errorMessage;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NPFException(NPFError.ErrorType errorType, int i, String str) {
        this(new NPFError(errorType, i, str));
        Intrinsics.checkNotNullParameter(errorType, "errorType");
    }
}
