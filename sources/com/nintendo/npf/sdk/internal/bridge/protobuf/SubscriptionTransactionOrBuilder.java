package com.nintendo.npf.sdk.internal.bridge.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface SubscriptionTransactionOrBuilder extends MessageLiteOrBuilder {
    String getOrderId();

    ByteString getOrderIdBytes();

    String getProductId();

    ByteString getProductIdBytes();

    SubscriptionTransaction.SubscriptionTransactionState getState();

    boolean hasOrderId();

    boolean hasProductId();

    boolean hasState();
}
