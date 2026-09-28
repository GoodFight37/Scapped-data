package com.nintendo.npf.sdk.internal.client.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.core.c0;
import com.nintendo.npf.sdk.core.y1;
import com.nintendo.npf.sdk.domain.repository.BaasAccountRepository;
import com.nintendo.npf.sdk.domain.repository.NintendoAccountRepository;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.NintendoAccount;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BaasAccountRepository f764a;
    private final NintendoAccountRepository b;
    private final y1 c;
    private final c0 d;
    private final CoroutineDispatcher e;

    /* JADX INFO: renamed from: com.nintendo.npf.sdk.internal.client.core.a$a, reason: collision with other inner class name */
    static final class C0044a extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f765a;
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ a d;

        /* JADX INFO: renamed from: com.nintendo.npf.sdk.internal.client.core.a$a$a, reason: collision with other inner class name */
        static final class C0045a implements c0.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Continuation f766a;

            C0045a(Continuation continuation) {
                this.f766a = continuation;
            }

            @Override // com.nintendo.npf.sdk.core.c0.a
            public final void a(BaaSUser baaSUser, String str, NPFError nPFError) {
                if (nPFError == null) {
                    Continuation continuation = this.f766a;
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m248constructorimpl(baaSUser));
                } else {
                    Continuation continuation2 = this.f766a;
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m248constructorimpl(ResultKt.createFailure(new f.a(nPFError.getErrorCode(), nPFError.getErrorMessage()))));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0044a(String str, a aVar, Continuation continuation) {
            super(2, continuation);
            this.c = str;
            this.d = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C0044a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C0044a(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                a aVar = this.d;
                this.f765a = aVar;
                this.b = 1;
                SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(this));
                aVar.d.a(null, null, null, true, new C0045a(safeContinuation));
                obj = safeContinuation.getOrThrow();
                if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(this);
                }
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            BaaSUser baaSUser = (BaaSUser) obj;
            if (Intrinsics.areEqual(this.c, this.d.c.f())) {
                return baaSUser.getAccessToken();
            }
            NintendoAccount nintendoAccount = baaSUser.getNintendoAccount();
            if (nintendoAccount != null) {
                return nintendoAccount.getAccessToken();
            }
            return null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(BaasAccountRepository baasAccountRepository, NintendoAccountRepository nintendoAccountRepository, y1 hostInformationDataFacade, c0 baasAuth) {
        this(baasAccountRepository, nintendoAccountRepository, hostInformationDataFacade, baasAuth, null, 16, null);
        Intrinsics.checkNotNullParameter(baasAccountRepository, "baasAccountRepository");
        Intrinsics.checkNotNullParameter(nintendoAccountRepository, "nintendoAccountRepository");
        Intrinsics.checkNotNullParameter(hostInformationDataFacade, "hostInformationDataFacade");
        Intrinsics.checkNotNullParameter(baasAuth, "baasAuth");
    }

    public a(BaasAccountRepository baasAccountRepository, NintendoAccountRepository nintendoAccountRepository, y1 hostInformationDataFacade, c0 baasAuth, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(baasAccountRepository, "baasAccountRepository");
        Intrinsics.checkNotNullParameter(nintendoAccountRepository, "nintendoAccountRepository");
        Intrinsics.checkNotNullParameter(hostInformationDataFacade, "hostInformationDataFacade");
        Intrinsics.checkNotNullParameter(baasAuth, "baasAuth");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.f764a = baasAccountRepository;
        this.b = nintendoAccountRepository;
        this.c = hostInformationDataFacade;
        this.d = baasAuth;
        this.e = ioDispatcher;
    }

    @Override // com.nintendo.npf.sdk.internal.client.core.f
    public boolean a(long j, long j2) {
        BaaSUser currentBaasUser = this.f764a.getCurrentBaasUser();
        NintendoAccount currentNintendoAccount = this.b.getCurrentNintendoAccount();
        if (currentBaasUser.getExpiresTime() - j < j2) {
            return true;
        }
        NintendoAccount nintendoAccount = currentBaasUser.getNintendoAccount();
        return (nintendoAccount != null ? nintendoAccount.getAccessToken() : null) != null && currentNintendoAccount.expiresTime - j < j2;
    }

    public /* synthetic */ a(BaasAccountRepository baasAccountRepository, NintendoAccountRepository nintendoAccountRepository, y1 y1Var, c0 c0Var, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(baasAccountRepository, nintendoAccountRepository, y1Var, c0Var, (i & 16) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    @Override // com.nintendo.npf.sdk.internal.client.core.f
    public Object a(String str, Continuation continuation) {
        return BuildersKt.withContext(this.e, new C0044a(str, this, null), continuation);
    }
}
