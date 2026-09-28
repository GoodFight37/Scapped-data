package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.user.NintendoAccount;
import java.util.Set;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    Object a(String str, Continuation continuation);

    void a(NintendoAccount nintendoAccount, long j, v2 v2Var);

    void a(NintendoAccount nintendoAccount, Set set, long j, m1 m1Var);
}
