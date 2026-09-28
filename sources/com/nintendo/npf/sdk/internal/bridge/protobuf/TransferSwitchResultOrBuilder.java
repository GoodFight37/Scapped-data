package com.nintendo.npf.sdk.internal.bridge.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface TransferSwitchResultOrBuilder extends MessageLiteOrBuilder {
    String getNewUserId();

    ByteString getNewUserIdBytes();

    String getOldUserId();

    ByteString getOldUserIdBytes();

    String getUsedTransferCode();

    ByteString getUsedTransferCodeBytes();

    String getUsedTransferId();

    ByteString getUsedTransferIdBytes();

    boolean hasNewUserId();

    boolean hasOldUserId();

    boolean hasUsedTransferCode();

    boolean hasUsedTransferId();
}
