package com.nintendo.npf.sdk.internal.bridge.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface TransferCodeOrBuilder extends MessageLiteOrBuilder {
    String getCode();

    ByteString getCodeBytes();

    String getIdentifier();

    ByteString getIdentifierBytes();

    boolean hasCode();

    boolean hasIdentifier();
}
