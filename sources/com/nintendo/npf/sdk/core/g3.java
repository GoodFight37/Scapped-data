package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g3 {
    public static final boolean a(NPFError nPFError) {
        Intrinsics.checkNotNullParameter(nPFError, "<this>");
        return nPFError.getErrorType() == NPFError.ErrorType.INVALID_NA_TOKEN || nPFError.getErrorType() == NPFError.ErrorType.NA_EULA_UPDATE || nPFError.getErrorType() == NPFError.ErrorType.INVALID_NA_USER;
    }
}
