package com.nintendo.npf.sdk.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i4 f485a = new i4();

    private i4() {
    }

    public static final h4 a(String applicationName) {
        Intrinsics.checkNotNullParameter(applicationName, "applicationName");
        return new j4(applicationName, null, 2, null);
    }
}
