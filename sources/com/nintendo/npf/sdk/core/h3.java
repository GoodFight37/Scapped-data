package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h3 {
    public static final NPFError.ErrorType a(int i) {
        for (NPFError.ErrorType errorType : NPFError.ErrorType.values()) {
            if (errorType.getInt() == i) {
                return errorType;
            }
        }
        return null;
    }

    public static final NPFException a(NPFError nPFError) {
        Intrinsics.checkNotNullParameter(nPFError, "<this>");
        return new NPFException(nPFError);
    }
}
