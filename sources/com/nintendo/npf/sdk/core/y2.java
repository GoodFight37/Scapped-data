package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.LinkedAccount;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public interface y2 {
    void a(String str, LinkedAccount linkedAccount, Function2 function2);

    void link(BaaSUser baaSUser, LinkedAccount linkedAccount, Function2 function2);
}
