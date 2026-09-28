package com.nintendo.npf.sdk.internal.bridge.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface NPFErrorOrBuilder extends MessageLiteOrBuilder {
    int getErrorCode();

    String getErrorMessage();

    ByteString getErrorMessageBytes();

    NPFError.ErrorType getErrorType();

    String getOriginalErrorMessage();

    ByteString getOriginalErrorMessageBytes();

    NPFError.OriginalErrorType getOriginalErrorType();

    boolean hasErrorCode();

    boolean hasErrorMessage();

    boolean hasErrorType();

    boolean hasOriginalErrorMessage();

    boolean hasOriginalErrorType();
}
