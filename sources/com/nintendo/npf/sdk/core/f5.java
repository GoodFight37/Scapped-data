package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFException;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade;
import com.nintendo.npf.sdk.domain.repository.BaasAccountRepository;
import com.nintendo.npf.sdk.domain.repository.NintendoAccountRepository;
import com.nintendo.npf.sdk.internal.model.Capabilities;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.LinkedAccount;
import com.nintendo.npf.sdk.user.NintendoAccount;
import com.nintendo.npf.sdk.user.TransferAccountService;
import com.nintendo.npf.sdk.user.TransferCode;
import com.nintendo.npf.sdk.user.TransferIdentifier;
import com.nintendo.npf.sdk.user.TransferSwitchResult;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f5 implements TransferAccountService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g5 f459a;
    private final BaasAccountRepository b;
    private final m4 c;
    private final Capabilities d;
    private final NintendoAccountRepository e;
    private final DeviceDataFacade f;
    private final a1 g;
    private final ErrorFactory h;

    static final class a extends SuspendLambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f460a;
        final /* synthetic */ TransferIdentifier c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(TransferIdentifier transferIdentifier, Continuation continuation) {
            super(1, continuation);
            this.c = transferIdentifier;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Continuation continuation) {
            return ((a) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return f5.this.new a(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f460a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            f5 f5Var = f5.this;
            String value = this.c.getValue();
            this.f460a = 1;
            Object objA = f5Var.a(value, this);
            return objA == coroutine_suspended ? coroutine_suspended : objA;
        }
    }

    static final class b extends SuspendLambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f461a;

        b(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Continuation continuation) {
            return ((b) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return f5.this.new b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f461a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            f5 f5Var = f5.this;
            this.f461a = 1;
            Object objA = f5Var.a(this);
            return objA == coroutine_suspended ? coroutine_suspended : objA;
        }
    }

    static final class c extends SuspendLambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f462a;
        final /* synthetic */ TransferCode c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(TransferCode transferCode, Continuation continuation) {
            super(1, continuation);
            this.c = transferCode;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Continuation continuation) {
            return ((c) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return f5.this.new c(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f462a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            f5 f5Var = f5.this;
            TransferCode transferCode = this.c;
            this.f462a = 1;
            Object objA = f5Var.a(transferCode, this);
            return objA == coroutine_suspended ? coroutine_suspended : objA;
        }
    }

    static final class d extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f463a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        d(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return f5.this.a((TransferCode) null, this);
        }
    }

    public f5(g5 transferAccountRepository, BaasAccountRepository baasAccountRepository, m4 pushNotificationChannelImpl, Capabilities capabilities, NintendoAccountRepository nintendoAccountRepository, DeviceDataFacade deviceDataFacade, a1 credentialsDataFacade, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(transferAccountRepository, "transferAccountRepository");
        Intrinsics.checkNotNullParameter(baasAccountRepository, "baasAccountRepository");
        Intrinsics.checkNotNullParameter(pushNotificationChannelImpl, "pushNotificationChannelImpl");
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        Intrinsics.checkNotNullParameter(nintendoAccountRepository, "nintendoAccountRepository");
        Intrinsics.checkNotNullParameter(deviceDataFacade, "deviceDataFacade");
        Intrinsics.checkNotNullParameter(credentialsDataFacade, "credentialsDataFacade");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f459a = transferAccountRepository;
        this.b = baasAccountRepository;
        this.c = pushNotificationChannelImpl;
        this.d = capabilities;
        this.e = nintendoAccountRepository;
        this.f = deviceDataFacade;
        this.g = credentialsDataFacade;
        this.h = errorFactory;
    }

    public final Object a(String str, Continuation continuation) {
        if (str.length() != 0) {
            return this.f459a.a(a(this.b), str, continuation);
        }
        throw new NPFException(new NPFError(NPFError.ErrorType.NPF_ERROR, 7400, "identifier is empty"));
    }

    @Override // com.nintendo.npf.sdk.user.TransferAccountService
    public void generateTransferCode(TransferIdentifier identifier, Function2 callback) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(callback, "callback");
        x.f611a.a(callback, new a(identifier, null));
    }

    @Override // com.nintendo.npf.sdk.user.TransferAccountService
    public void getTransferCode(Function2 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        x.f611a.a(callback, new b(null));
    }

    @Override // com.nintendo.npf.sdk.user.TransferAccountService
    public void switchBaasUser(TransferCode transferCode, Function2 callback) {
        Intrinsics.checkNotNullParameter(transferCode, "transferCode");
        Intrinsics.checkNotNullParameter(callback, "callback");
        x.f611a.a(callback, new c(transferCode, null));
    }

    public final Object a(Continuation continuation) {
        return this.f459a.a(a(this.b), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(TransferCode transferCode, Continuation continuation) throws Throwable {
        d dVar;
        f5 f5Var;
        BaaSUser baaSUser;
        TransferCode transferCode2;
        String str;
        if (continuation instanceof d) {
            dVar = (d) continuation;
            int i = dVar.g;
            if ((i & Integer.MIN_VALUE) != 0) {
                dVar.g = i - Integer.MIN_VALUE;
            } else {
                dVar = new d(continuation);
            }
        } else {
            dVar = new d(continuation);
        }
        Object obj = dVar.e;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dVar.g;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (transferCode.getIdentifier().length() != 0) {
                if (transferCode.getCode().length() != 0) {
                    BaaSUser baaSUserA = a(this.b);
                    if (this.b.isRunning().compareAndSet(false, true)) {
                        String userId = baaSUserA.getUserId();
                        try {
                            g5 g5Var = this.f459a;
                            dVar.f463a = this;
                            dVar.b = transferCode;
                            dVar.c = baaSUserA;
                            dVar.d = userId;
                            dVar.g = 1;
                            Object objA = g5Var.a(transferCode, dVar);
                            if (objA == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            baaSUser = baaSUserA;
                            obj = objA;
                            f5Var = this;
                            transferCode2 = transferCode;
                            str = userId;
                        } catch (Throwable th) {
                            th = th;
                            f5Var = this;
                            f5Var.b.isRunning().set(false);
                            throw th;
                        }
                    } else {
                        NPFError nPFErrorCreate_ProcessCancel_Minus1 = this.h.create_ProcessCancel_Minus1("Transfer Account switchBaasUser can't run multiply");
                        Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_ProcessCancel_Minus1, "errorFactory.create_Proc…ltiply\"\n                )");
                        throw new NPFException(nPFErrorCreate_ProcessCancel_Minus1);
                    }
                } else {
                    throw new NPFException(new NPFError(NPFError.ErrorType.NPF_ERROR, 7400, "code is empty"));
                }
            } else {
                throw new NPFException(new NPFError(NPFError.ErrorType.NPF_ERROR, 7400, "identifier is empty"));
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) dVar.d;
            baaSUser = (BaaSUser) dVar.c;
            transferCode2 = (TransferCode) dVar.b;
            f5Var = (f5) dVar.f463a;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
                f5Var.b.isRunning().set(false);
                throw th;
            }
        }
        p1 p1Var = (p1) obj;
        f5Var.b.isRunning().set(false);
        q1.a(p1Var, f5Var.g, f5Var.d);
        BaaSUser baaSUserE = p1Var.e();
        NintendoAccount nintendoAccount = baaSUser.getNintendoAccount();
        if (nintendoAccount != null) {
            LinkedAccount linkedAccount = baaSUserE.getLinkedAccounts$NPFSDK_release().get("nintendoAccount");
            if (Intrinsics.areEqual(linkedAccount != null ? linkedAccount.getFederatedId() : null, nintendoAccount.getNintendoAccountId())) {
                baaSUserE.setNintendoAccount$NPFSDK_release(nintendoAccount);
            } else {
                v3.b(f5Var.e.getCurrentNintendoAccount());
                f5Var.g.b(null);
                f5Var.g.a(null);
            }
        } else {
            v3.b(f5Var.e.getCurrentNintendoAccount());
            f5Var.g.b(null);
            f5Var.g.a(null);
        }
        h0.a(baaSUser, baaSUserE, true, f5Var.d.isSandbox());
        f5Var.f.setSessionId(p1Var.d());
        f5Var.c.b();
        return new TransferSwitchResult(str, baaSUserE.getUserId(), transferCode2.getIdentifier(), transferCode2.getCode());
    }

    private final BaaSUser a(BaasAccountRepository baasAccountRepository) {
        BaaSUser currentBaasUser = baasAccountRepository.getCurrentBaasUser();
        if (h0.c(currentBaasUser)) {
            return currentBaasUser;
        }
        NPFError nPFErrorCreate_BaasAccount_NotLoggedIn_401 = this.h.create_BaasAccount_NotLoggedIn_401();
        Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_BaasAccount_NotLoggedIn_401, "errorFactory.create_BaasAccount_NotLoggedIn_401()");
        throw new NPFException(nPFErrorCreate_BaasAccount_NotLoggedIn_401);
    }
}
