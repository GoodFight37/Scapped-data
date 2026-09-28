package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.user.BaaSUser;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l2 implements o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j2 f516a;

    public l2(j2 inquiryApi) {
        Intrinsics.checkNotNullParameter(inquiryApi, "inquiryApi");
        this.f516a = inquiryApi;
    }

    @Override // com.nintendo.npf.sdk.core.o2
    public void a(BaaSUser baasUser, Function2 callback) {
        Intrinsics.checkNotNullParameter(baasUser, "baasUser");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f516a.a(baasUser, callback);
    }
}
