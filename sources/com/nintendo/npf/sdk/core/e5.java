package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFException;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.TransferCode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public final class e5 implements g5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d0 f444a;

    static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f445a;
        int c;

        a(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f445a = obj;
            this.c |= Integer.MIN_VALUE;
            return e5.this.a(null, null, this);
        }
    }

    static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f446a;
        int c;

        b(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f446a = obj;
            this.c |= Integer.MIN_VALUE;
            return e5.this.a((BaaSUser) null, this);
        }
    }

    static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f447a;
        int c;

        c(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f447a = obj;
            this.c |= Integer.MIN_VALUE;
            return e5.this.a((TransferCode) null, this);
        }
    }

    public e5(d0 baasAccountApi) {
        Intrinsics.checkNotNullParameter(baasAccountApi, "baasAccountApi");
        this.f444a = baasAccountApi;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.nintendo.npf.sdk.core.g5
    public Object a(BaaSUser baaSUser, String str, Continuation continuation) throws JSONException {
        a aVar;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.c;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.c = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object obj = aVar.f445a;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.c;
        try {
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            d0 d0Var = this.f444a;
            aVar.c = 1;
            Object objA = d0Var.a(baaSUser, str, aVar);
            return objA == coroutine_suspended ? coroutine_suspended : objA;
        } catch (NPFException e) {
            if (e.getErrorCode() == 400) {
                throw new NPFException(new NPFError(NPFError.ErrorType.NPF_ERROR, 7400, e.getErrorMessage()));
            }
            throw e;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.nintendo.npf.sdk.core.g5
    public Object a(BaaSUser baaSUser, Continuation continuation) {
        b bVar;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.c;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.c = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object obj = bVar.f446a;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.c;
        try {
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            d0 d0Var = this.f444a;
            bVar.c = 1;
            Object objA = d0Var.a(baaSUser, bVar);
            return objA == coroutine_suspended ? coroutine_suspended : objA;
        } catch (NPFException e) {
            int errorCode = e.getErrorCode();
            if (errorCode == 400) {
                throw new NPFException(new NPFError(NPFError.ErrorType.NPF_ERROR, 7400, e.getErrorMessage()));
            }
            if (errorCode != 404) {
                throw e;
            }
            throw new NPFException(new NPFError(NPFError.ErrorType.NPF_ERROR, 7404, e.getErrorMessage()));
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.nintendo.npf.sdk.core.g5
    public Object a(TransferCode transferCode, Continuation continuation) throws JSONException {
        c cVar;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i = cVar.c;
            if ((i & Integer.MIN_VALUE) != 0) {
                cVar.c = i - Integer.MIN_VALUE;
            } else {
                cVar = new c(continuation);
            }
        } else {
            cVar = new c(continuation);
        }
        Object objA = cVar.f447a;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = cVar.c;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objA);
                d0 d0Var = this.f444a;
                cVar.c = 1;
                objA = d0Var.a(transferCode, cVar);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objA);
            }
            o1 o1Var = (o1) objA;
            if (o1Var instanceof o1.b) {
                return ((o1.b) o1Var).a();
            }
            if (o1Var instanceof o1.a) {
                throw new NPFException(((o1.a) o1Var).a());
            }
            throw new NoWhenBranchMatchedException();
        } catch (NPFException e) {
            int errorCode = e.getErrorCode();
            if (errorCode == 400) {
                throw new NPFException(new NPFError(NPFError.ErrorType.NPF_ERROR, 7400, e.getErrorMessage()));
            }
            if (errorCode != 404) {
                throw e;
            }
            throw new NPFException(new NPFError(NPFError.ErrorType.NPF_ERROR, 7404, e.getErrorMessage()));
        }
    }
}
