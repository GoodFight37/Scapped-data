package com.nintendo.npf.sdk;

import com.nintendo.npf.sdk.internal.model.INPFError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0002&'B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J \u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J=\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020\u0007HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0014\u0010\u000b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006("}, d2 = {"Lcom/nintendo/npf/sdk/NPFError;", "Lcom/nintendo/npf/sdk/internal/model/INPFError;", "errorType", "Lcom/nintendo/npf/sdk/NPFError$ErrorType;", "errorCode", "", "errorMessage", "", "(Lcom/nintendo/npf/sdk/NPFError$ErrorType;ILjava/lang/String;)V", "originalErrorType", "Lcom/nintendo/npf/sdk/NPFError$OriginalErrorType;", "originalErrorMessage", "(Lcom/nintendo/npf/sdk/NPFError$ErrorType;ILjava/lang/String;Lcom/nintendo/npf/sdk/NPFError$OriginalErrorType;Ljava/lang/String;)V", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "getErrorType", "()Lcom/nintendo/npf/sdk/NPFError$ErrorType;", "errorTypeString", "getErrorTypeString", "getOriginalErrorMessage", "getOriginalErrorType", "()Lcom/nintendo/npf/sdk/NPFError$OriginalErrorType;", "originalErrorTypeString", "getOriginalErrorTypeString", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "ErrorType", "OriginalErrorType", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class NPFError implements INPFError {
    private final int errorCode;
    private final String errorMessage;
    private final ErrorType errorType;
    private final String errorTypeString;
    private final String originalErrorMessage;
    private final OriginalErrorType originalErrorType;
    private final String originalErrorTypeString;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/nintendo/npf/sdk/NPFError$ErrorType;", "", "", "int", "<init>", "(Ljava/lang/String;II)V", "a", "I", "getInt", "()I", "PROCESS_CANCEL", "USER_CANCEL", "NETWORK_ERROR", "NPF_ERROR", "INVALID_NA_TOKEN", "NA_EULA_UPDATE", "INVALID_NA_USER", "MISMATCHED_NA_USER", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum ErrorType {
        PROCESS_CANCEL(-2),
        USER_CANCEL(-1),
        NETWORK_ERROR(0),
        NPF_ERROR(1),
        INVALID_NA_TOKEN(2),
        NA_EULA_UPDATE(3),
        INVALID_NA_USER(4),
        MISMATCHED_NA_USER(5);


        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int int;

        ErrorType(int i) {
            this.int = i;
        }

        public final int getInt() {
            return this.int;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/nintendo/npf/sdk/NPFError$OriginalErrorType;", "", "", "int", "<init>", "(Ljava/lang/String;II)V", "a", "I", "getInt", "()I", "NPF_SDK_ERROR", "GOOGLE_PLAY_BILLING_LIBRARY_ERROR", "STORE_KIT_ERROR", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum OriginalErrorType {
        NPF_SDK_ERROR(0),
        GOOGLE_PLAY_BILLING_LIBRARY_ERROR(1),
        STORE_KIT_ERROR(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int int;

        OriginalErrorType(int i) {
            this.int = i;
        }

        public final int getInt() {
            return this.int;
        }
    }

    public NPFError(ErrorType errorType, int i, String str, OriginalErrorType originalErrorType, String originalErrorMessage) {
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        Intrinsics.checkNotNullParameter(originalErrorType, "originalErrorType");
        Intrinsics.checkNotNullParameter(originalErrorMessage, "originalErrorMessage");
        this.errorType = errorType;
        this.errorCode = i;
        this.errorMessage = str;
        this.originalErrorType = originalErrorType;
        this.originalErrorMessage = originalErrorMessage;
        this.errorTypeString = errorType.name();
        this.originalErrorTypeString = originalErrorType.name();
    }

    public static /* synthetic */ NPFError copy$default(NPFError nPFError, ErrorType errorType, int i, String str, OriginalErrorType originalErrorType, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            errorType = nPFError.errorType;
        }
        if ((i2 & 2) != 0) {
            i = nPFError.errorCode;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str = nPFError.errorMessage;
        }
        String str3 = str;
        if ((i2 & 8) != 0) {
            originalErrorType = nPFError.originalErrorType;
        }
        OriginalErrorType originalErrorType2 = originalErrorType;
        if ((i2 & 16) != 0) {
            str2 = nPFError.originalErrorMessage;
        }
        return nPFError.copy(errorType, i3, str3, originalErrorType2, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ErrorType getErrorType() {
        return this.errorType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final OriginalErrorType getOriginalErrorType() {
        return this.originalErrorType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getOriginalErrorMessage() {
        return this.originalErrorMessage;
    }

    public final NPFError copy(ErrorType errorType, int errorCode, String errorMessage, OriginalErrorType originalErrorType, String originalErrorMessage) {
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        Intrinsics.checkNotNullParameter(originalErrorType, "originalErrorType");
        Intrinsics.checkNotNullParameter(originalErrorMessage, "originalErrorMessage");
        return new NPFError(errorType, errorCode, errorMessage, originalErrorType, originalErrorMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NPFError)) {
            return false;
        }
        NPFError nPFError = (NPFError) other;
        return this.errorType == nPFError.errorType && this.errorCode == nPFError.errorCode && Intrinsics.areEqual(this.errorMessage, nPFError.errorMessage) && this.originalErrorType == nPFError.originalErrorType && Intrinsics.areEqual(this.originalErrorMessage, nPFError.originalErrorMessage);
    }

    @Override // com.nintendo.npf.sdk.internal.model.INPFError
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override // com.nintendo.npf.sdk.internal.model.INPFError
    public String getErrorMessage() {
        return this.errorMessage;
    }

    public final ErrorType getErrorType() {
        return this.errorType;
    }

    @Override // com.nintendo.npf.sdk.internal.model.INPFError
    public String getErrorTypeString() {
        return this.errorTypeString;
    }

    @Override // com.nintendo.npf.sdk.internal.model.INPFError
    public String getOriginalErrorMessage() {
        return this.originalErrorMessage;
    }

    public final OriginalErrorType getOriginalErrorType() {
        return this.originalErrorType;
    }

    @Override // com.nintendo.npf.sdk.internal.model.INPFError
    public String getOriginalErrorTypeString() {
        return this.originalErrorTypeString;
    }

    public int hashCode() {
        int iHashCode = ((this.errorType.hashCode() * 31) + Integer.hashCode(this.errorCode)) * 31;
        String str = this.errorMessage;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.originalErrorType.hashCode()) * 31) + this.originalErrorMessage.hashCode();
    }

    public String toString() {
        return "NPFError(errorType=" + this.errorType + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", originalErrorType=" + this.originalErrorType + ", originalErrorMessage=" + this.originalErrorMessage + ')';
    }

    public final NPFError copy(ErrorType errorType) {
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        return copy(errorType, getErrorCode(), getErrorMessage(), this.originalErrorType, getOriginalErrorMessage());
    }

    public final NPFError copy(ErrorType errorType, int errorCode, String errorMessage) {
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        return copy(errorType, errorCode, errorMessage, this.originalErrorType, getOriginalErrorMessage());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NPFError(ErrorType errorType, int i, String str) {
        this(errorType, i, str, OriginalErrorType.NPF_SDK_ERROR, "");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
    }
}
