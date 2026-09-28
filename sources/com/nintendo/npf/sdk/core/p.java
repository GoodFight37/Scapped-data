package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public interface p {

    public static final class a {
        public static NPFError a(p pVar) {
            return pVar.c();
        }

        public static NPFError b(p pVar) {
            if (pVar.a().length() == 0) {
                return new NPFError(NPFError.ErrorType.NPF_ERROR, 400, "Invalid parameters");
            }
            if (Intrinsics.areEqual(pVar.a(), "NPFCOMMON") || Intrinsics.areEqual(pVar.a(), "NPFAUDIT")) {
                return new NPFError(NPFError.ErrorType.NPF_ERROR, 400, "Invalid parameters");
            }
            if (pVar.b().length() == 0) {
                return new NPFError(NPFError.ErrorType.NPF_ERROR, 400, "Invalid parameters");
            }
            return null;
        }
    }

    String a();

    String b();

    NPFError c();
}
