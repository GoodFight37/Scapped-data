package com.nintendo.npf.sdk.internal.bridge.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface VirtualCurrencyTransactionOrBuilder extends MessageLiteOrBuilder {
    String getOrderId();

    ByteString getOrderIdBytes();

    String getSku();

    ByteString getSkuBytes();

    VirtualCurrencyTransaction.VirtualCurrencyTransactionState getState();

    boolean hasOrderId();

    boolean hasSku();

    boolean hasState();
}
