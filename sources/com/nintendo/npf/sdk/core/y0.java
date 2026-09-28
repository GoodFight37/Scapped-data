package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class y0 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Continuation f621a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y0(Continuation continuation) {
        super(2);
        this.f621a = continuation;
    }

    public final void a(Object obj, NPFError nPFError) {
        Unit unit;
        if (nPFError != null) {
            Continuation continuation = this.f621a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m248constructorimpl(ResultKt.createFailure(new NPFException(nPFError))));
            unit = Unit.INSTANCE;
        } else if (obj != null) {
            Continuation continuation2 = this.f621a;
            Result.Companion companion2 = Result.INSTANCE;
            continuation2.resumeWith(Result.m248constructorimpl(obj));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            Continuation continuation3 = this.f621a;
            Result.Companion companion3 = Result.INSTANCE;
            continuation3.resumeWith(Result.m248constructorimpl(ResultKt.createFailure(new IllegalStateException())));
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        a(obj, (NPFError) obj2);
        return Unit.INSTANCE;
    }
}
