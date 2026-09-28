package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.TransferCode;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public interface g5 {
    Object a(BaaSUser baaSUser, String str, Continuation continuation);

    Object a(BaaSUser baaSUser, Continuation continuation);

    Object a(TransferCode transferCode, Continuation continuation);
}
