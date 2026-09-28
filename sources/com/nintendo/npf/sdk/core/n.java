package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.user.BaaSUser;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public interface n {

    public static final class a {
        public static /* synthetic */ void a(n nVar, BaaSUser baaSUser, boolean z, Function2 function2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshConfig");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            nVar.a(baaSUser, z, function2);
        }
    }

    i a();

    void a(i iVar);

    void a(BaaSUser baaSUser, boolean z, Function2 function2);

    m b();
}
