package com.nintendo.npf.sdk.internal.bridge.protobuf;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface SubscriptionTransactionListOrBuilder extends MessageLiteOrBuilder {
    SubscriptionTransaction getSubscriptionTransaction(int i);

    int getSubscriptionTransactionCount();

    List<SubscriptionTransaction> getSubscriptionTransactionList();
}
