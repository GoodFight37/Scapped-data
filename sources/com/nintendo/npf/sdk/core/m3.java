package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class m3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m3 f522a = new m3();

    private m3() {
    }

    public final k3 a(l3 session, z4 sessionTokenCodeAndState, boolean z) {
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(sessionTokenCodeAndState, "sessionTokenCodeAndState");
        String strB = sessionTokenCodeAndState.b();
        if (strB == null || strB.length() == 0) {
            return new k3.c(NPFError.ErrorType.USER_CANCEL, -1, "User canceled for authorization", "NAAuth3#EmptySessionTokenCode", "Session token code is empty. uri: " + sessionTokenCodeAndState.a() + ", isRestored: " + z, z);
        }
        return !Intrinsics.areEqual(session.a(), sessionTokenCodeAndState.c()) ? new k3.c(NPFError.ErrorType.USER_CANCEL, -1, "User canceled for authorization. Authentication may have been completed in a different browser tab or window.", "NAAuth3#InvalidState", "receivedState:" + sessionTokenCodeAndState.c() + ", state:" + session.a() + ", isRestored: " + z, z) : new k3.d(session, sessionTokenCodeAndState.b(), z);
    }
}
