package com.nintendo.npf.sdk.internal.bridge.protobuf;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface VirtualCurrencyTransactionListOrBuilder extends MessageLiteOrBuilder {
    VirtualCurrencyTransaction getVirtualCurrencyTransaction(int i);

    int getVirtualCurrencyTransactionCount();

    List<VirtualCurrencyTransaction> getVirtualCurrencyTransactionList();
}
