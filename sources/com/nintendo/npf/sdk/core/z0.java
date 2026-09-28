package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class z0 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Continuation f633a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(Continuation continuation) {
        super(1);
        this.f633a = continuation;
    }

    public final void a(NPFError nPFError) {
        Unit unit;
        if (nPFError != null) {
            Continuation continuation = this.f633a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m248constructorimpl(ResultKt.createFailure(new NPFException(nPFError))));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            Continuation continuation2 = this.f633a;
            Result.Companion companion2 = Result.INSTANCE;
            continuation2.resumeWith(Result.m248constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((NPFError) obj);
        return Unit.INSTANCE;
    }
}
