package com.nintendo.npf.sdk.core;

import com.google.api.client.http.HttpStatusCodes;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFException;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.repository.NintendoAccountRepository;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.NintendoAccount;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes2.dex */
public final class t3 implements NintendoAccountRepository {
    public static final a i = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f570a;
    private final q b;
    private final a1 c;
    private final ErrorFactory d;
    private final CoroutineScope e;
    private final CoroutineDispatcher f;
    private final t0 g;
    private final NintendoAccount h;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f571a;
        private final String b;
        private final boolean c;

        public b(String str, String str2, boolean z) {
            this.f571a = str;
            this.b = str2;
            this.c = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.f571a, bVar.f571a) && Intrinsics.areEqual(this.b, bVar.b) && this.c == bVar.c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            String str = this.f571a;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.b;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z = this.c;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        public String toString() {
            return "RequestKey(targetNintendoAccountId=" + this.f571a + ", sessionToken=" + this.b + ", triggeredByExpiration=" + this.c + ')';
        }
    }

    static final class c extends SuspendLambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f572a;
        int b;
        final /* synthetic */ b c;
        final /* synthetic */ String d;
        final /* synthetic */ t3 e;
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(b bVar, String str, t3 t3Var, String str2, Continuation continuation) {
            super(1, continuation);
            this.c = bVar;
            this.d = str;
            this.e = t3Var;
            this.f = str2;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Continuation continuation) {
            return ((c) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new c(this.c, this.d, this.e, this.f, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:31:0x008d A[Catch: NPFException -> 0x0013, TRY_LEAVE, TryCatch #1 {NPFException -> 0x0013, blocks: (B:6:0x000f, B:22:0x006a, B:24:0x0070, B:27:0x007d, B:28:0x0088, B:29:0x0089, B:31:0x008d), top: B:43:0x000f }] */
        /* JADX WARN: Code duplicated, block: B:39:0x00d2  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String strB;
            NintendoAccount nintendoAccount;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String str = (String) this.f572a;
                try {
                    ResultKt.throwOnFailure(obj);
                    nintendoAccount = (NintendoAccount) obj;
                    if (this.f != null && !Intrinsics.areEqual(nintendoAccount.getNintendoAccountId(), this.f)) {
                        throw new NPFException(NPFError.ErrorType.MISMATCHED_NA_USER, HttpStatusCodes.STATUS_CODE_CONFLICT, "Linked Nintendo Account is different from session token's Nintendo Account.");
                    }
                    if (this.f != null) {
                        this.e.c.b(nintendoAccount.sessionToken);
                        this.e.c.a(nintendoAccount.getIdToken());
                        v3.a(this.e.h, nintendoAccount);
                    }
                    return nintendoAccount;
                } catch (NPFException e) {
                    e = e;
                    strB = str;
                    NPFError error = e.getError();
                    if (strB == null) {
                        strB = "";
                    }
                    throw new r1(error, strB);
                }
            }
            ResultKt.throwOnFailure(obj);
            SDKLog.d("NintendoAccountDefaultRepository", "getNintendoAccount running with key=" + this.c.hashCode());
            strB = this.d;
            if (strB == null) {
                strB = this.e.c.b();
            }
            if (strB != null) {
                try {
                    if (strB.length() != 0) {
                        s3 s3Var = (s3) this.e.f570a.invoke();
                        this.f572a = strB;
                        this.b = 1;
                        Object objA = s3Var.a(strB, this);
                        if (objA == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = objA;
                        nintendoAccount = (NintendoAccount) obj;
                        if (this.f != null) {
                            throw new NPFException(NPFError.ErrorType.MISMATCHED_NA_USER, HttpStatusCodes.STATUS_CODE_CONFLICT, "Linked Nintendo Account is different from session token's Nintendo Account.");
                        }
                        if (this.f != null) {
                            this.e.c.b(nintendoAccount.sessionToken);
                            this.e.c.a(nintendoAccount.getIdToken());
                            v3.a(this.e.h, nintendoAccount);
                        }
                        return nintendoAccount;
                    }
                } catch (NPFException e2) {
                    e = e2;
                    NPFError error2 = e.getError();
                    if (strB == null) {
                        strB = "";
                    }
                    throw new r1(error2, strB);
                }
            }
            NPFError nPFErrorCreate_NintendoAccount_InvalidNaToken_400 = this.e.d.create_NintendoAccount_InvalidNaToken_400("invalid sessionToken error.");
            Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_NintendoAccount_InvalidNaToken_400, "errorFactory.create_Nint…lid sessionToken error.\")");
            throw h3.a(nPFErrorCreate_NintendoAccount_InvalidNaToken_400);
        }
    }

    static final class d extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f573a;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ boolean e;
        final /* synthetic */ Function2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, String str2, boolean z, Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.c = str;
            this.d = str2;
            this.e = z;
            this.f = function2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return t3.this.new d(this.c, this.d, this.e, this.f, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f573a;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    t3 t3Var = t3.this;
                    String str = this.c;
                    String str2 = this.d;
                    boolean z = this.e;
                    this.f573a = 1;
                    obj = t3Var.getNintendoAccount(str, str2, z, (Continuation) this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.f.invoke((NintendoAccount) obj, null);
            } catch (r1 e) {
                this.f.invoke(null, e);
            }
            return Unit.INSTANCE;
        }
    }

    static final class e extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f574a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        e(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return t3.this.getNintendoAccountFromSessionTokenCode(null, null, null, this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t3(Function0 nintendoAccountApiProvider, q analyticsHelper, a1 credentialsDataFacade, ErrorFactory errorFactory) {
        this(nintendoAccountApiProvider, analyticsHelper, credentialsDataFacade, errorFactory, null, null, null, 112, null);
        Intrinsics.checkNotNullParameter(nintendoAccountApiProvider, "nintendoAccountApiProvider");
        Intrinsics.checkNotNullParameter(analyticsHelper, "analyticsHelper");
        Intrinsics.checkNotNullParameter(credentialsDataFacade, "credentialsDataFacade");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
    }

    @Override // com.nintendo.npf.sdk.domain.repository.NintendoAccountRepository
    public NintendoAccount getCurrentNintendoAccount() {
        return this.h;
    }

    @Override // com.nintendo.npf.sdk.domain.repository.NintendoAccountRepository
    public Object getNintendoAccount(String str, String str2, boolean z, Continuation continuation) {
        b bVar = new b(str, str2, z);
        SDKLog.d("NintendoAccountDefaultRepository", "getNintendoAccount called with key=" + bVar.hashCode() + ", triggeredByExpiration=" + z);
        return this.g.a(bVar, new c(bVar, str2, this, str, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0085, code lost:
    
        if (r14 == r0) goto L28;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v8 */
    @Override // com.nintendo.npf.sdk.domain.repository.NintendoAccountRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getNintendoAccountFromSessionTokenCode(java.lang.String r11, java.lang.String r12, java.lang.String r13, kotlin.coroutines.Continuation r14) {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nintendo.npf.sdk.core.t3.getNintendoAccountFromSessionTokenCode(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.nintendo.npf.sdk.domain.repository.NintendoAccountRepository
    public Object getSessionToken(String str, String str2, Continuation continuation) {
        return ((s3) this.f570a.invoke()).a(str, str2, continuation);
    }

    @Override // com.nintendo.npf.sdk.domain.repository.NintendoAccountRepository
    public void sendVcmEmailToParent(NintendoAccount nintendoAccount, String applicationName, String market, String str, String str2, Function1 block) {
        Intrinsics.checkNotNullParameter(nintendoAccount, "nintendoAccount");
        Intrinsics.checkNotNullParameter(applicationName, "applicationName");
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(block, "block");
        ((s3) this.f570a.invoke()).a(nintendoAccount, applicationName, market, str, str2, block);
    }

    public t3(Function0 nintendoAccountApiProvider, q analyticsHelper, a1 credentialsDataFacade, ErrorFactory errorFactory, CoroutineScope scope, CoroutineDispatcher mainDispatcher, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(nintendoAccountApiProvider, "nintendoAccountApiProvider");
        Intrinsics.checkNotNullParameter(analyticsHelper, "analyticsHelper");
        Intrinsics.checkNotNullParameter(credentialsDataFacade, "credentialsDataFacade");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.f570a = nintendoAccountApiProvider;
        this.b = analyticsHelper;
        this.c = credentialsDataFacade;
        this.d = errorFactory;
        this.e = scope;
        this.f = mainDispatcher;
        this.g = new t0(scope, dispatcher);
        this.h = new NintendoAccount();
    }

    @Override // com.nintendo.npf.sdk.domain.repository.NintendoAccountRepository
    public void getNintendoAccount(String str, String str2, boolean z, Function2 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        BuildersKt__Builders_commonKt.launch$default(this.e, this.f, null, new d(str, str2, z, block, null), 2, null);
    }

    public /* synthetic */ t3(Function0 function0, q qVar, a1 a1Var, ErrorFactory errorFactory, CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, qVar, a1Var, errorFactory, (i2 & 16) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)) : coroutineScope, (i2 & 32) != 0 ? Dispatchers.getMain() : coroutineDispatcher, (i2 & 64) != 0 ? Dispatchers.getDefault() : coroutineDispatcher2);
    }
}
