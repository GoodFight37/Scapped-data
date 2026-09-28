package com.nintendo.npf.sdk.core;

import com.google.api.client.http.HttpStatusCodes;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade;
import com.nintendo.npf.sdk.domain.repository.BaasAccountRepository;
import com.nintendo.npf.sdk.domain.repository.NintendoAccountRepository;
import com.nintendo.npf.sdk.internal.model.Capabilities;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.BaasAccountService;
import com.nintendo.npf.sdk.user.LinkedAccount;
import com.nintendo.npf.sdk.user.NintendoAccount;
import com.nintendo.npf.sdk.user.SwitchResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 implements BaasAccountService {
    public static final a k = new a(null);
    private static final String l = "f0";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f449a;
    private final Function0 b;
    private final Function0 c;
    private final BaasAccountRepository d;
    private final z2 e;
    private final y4 f;
    private final NintendoAccountRepository g;
    private final DeviceDataFacade h;
    private final a1 i;
    private final ErrorFactory j;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function2 {
        final /* synthetic */ Function1 b;
        final /* synthetic */ NintendoAccount c;
        final /* synthetic */ BaaSUser d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Function1 function1, NintendoAccount nintendoAccount, BaaSUser baaSUser) {
            super(2);
            this.b = function1;
            this.c = nintendoAccount;
            this.d = baaSUser;
        }

        public final void a(BaaSUser baaSUser, NPFError nPFError) {
            if (nPFError != null) {
                if (nPFError.getErrorCode() == 409) {
                    f0.this.i.b(null);
                    f0.this.i.a(null);
                }
                this.b.invoke(nPFError);
                return;
            }
            f0.this.i.b(this.c.sessionToken);
            f0.this.i.a(this.c.getIdToken());
            v3.a(f0.this.g.getCurrentNintendoAccount(), this.c);
            Intrinsics.checkNotNull(baaSUser);
            baaSUser.setNintendoAccount$NPFSDK_release(f0.this.g.getCurrentNintendoAccount());
            h0.a(this.d, baaSUser, false, ((Capabilities) f0.this.b().invoke()).isSandbox());
            this.b.invoke(null);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((BaaSUser) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f451a;
        final /* synthetic */ BaaSUser b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Function1 function1, BaaSUser baaSUser) {
            super(2);
            this.f451a = function1;
            this.b = baaSUser;
        }

        public final void a(BaaSUser baaSUser, NPFError nPFError) {
            if (nPFError != null) {
                this.f451a.invoke(nPFError);
            } else {
                if (baaSUser == null) {
                    return;
                }
                h0.a(this.b, baaSUser, false, false);
                this.f451a.invoke(null);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((BaaSUser) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    static final class d extends Lambda implements Function2 {
        final /* synthetic */ Function2 b;
        final /* synthetic */ BaaSUser c;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Function2 function2, BaaSUser baaSUser, String str) {
            super(2);
            this.b = function2;
            this.c = baaSUser;
            this.d = str;
        }

        public final void a(p1 p1Var, NPFError nPFError) {
            f0.this.a().isRunning().set(false);
            if (nPFError != null) {
                this.b.invoke(null, nPFError);
                return;
            }
            if (p1Var != null) {
                q1.a(p1Var, f0.this.i, (Capabilities) f0.this.b().invoke());
                BaaSUser baaSUserE = p1Var.e();
                h0.a(this.c, baaSUserE, true, ((Capabilities) f0.this.b().invoke()).isSandbox());
                v3.b(f0.this.g.getCurrentNintendoAccount());
                f0.this.i.b(null);
                f0.this.i.a(null);
                f0.this.h.setSessionId(p1Var.d());
                ((m4) f0.this.c().invoke()).b();
                this.b.invoke(new SwitchResult(this.d, baaSUserE.getUserId()), null);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((p1) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    public f0(Function0 capabilitiesProvider, Function0 baasAuthProvider, Function0 pushNotificationChannelProvider, BaasAccountRepository baasAccountRepository, z2 loginHandler, y4 sessionEventManager, NintendoAccountRepository nintendoAccountRepository, DeviceDataFacade deviceDataFacade, a1 credentialsDataFacade, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(capabilitiesProvider, "capabilitiesProvider");
        Intrinsics.checkNotNullParameter(baasAuthProvider, "baasAuthProvider");
        Intrinsics.checkNotNullParameter(pushNotificationChannelProvider, "pushNotificationChannelProvider");
        Intrinsics.checkNotNullParameter(baasAccountRepository, "baasAccountRepository");
        Intrinsics.checkNotNullParameter(loginHandler, "loginHandler");
        Intrinsics.checkNotNullParameter(sessionEventManager, "sessionEventManager");
        Intrinsics.checkNotNullParameter(nintendoAccountRepository, "nintendoAccountRepository");
        Intrinsics.checkNotNullParameter(deviceDataFacade, "deviceDataFacade");
        Intrinsics.checkNotNullParameter(credentialsDataFacade, "credentialsDataFacade");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f449a = capabilitiesProvider;
        this.b = baasAuthProvider;
        this.c = pushNotificationChannelProvider;
        this.d = baasAccountRepository;
        this.e = loginHandler;
        this.f = sessionEventManager;
        this.g = nintendoAccountRepository;
        this.h = deviceDataFacade;
        this.i = credentialsDataFacade;
        this.j = errorFactory;
    }

    @Override // com.nintendo.npf.sdk.user.BaasAccountService
    public BaaSUser getCurrentBaasUser() {
        return this.d.getCurrentBaasUser();
    }

    @Override // com.nintendo.npf.sdk.user.BaasAccountService
    public String getLanguage() {
        return this.h.getLanguage();
    }

    @Override // com.nintendo.npf.sdk.user.BaasAccountService
    public void linkNintendoAccount(NintendoAccount nintendoAccount, Function1 callback) {
        Intrinsics.checkNotNullParameter(nintendoAccount, "nintendoAccount");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SDKLog.i(l, "linkNintendoAccount is called");
        BaaSUser currentBaasUser = this.d.getCurrentBaasUser();
        if (!h0.c(currentBaasUser)) {
            callback.invoke(this.j.create_BaasAccount_NotLoggedIn_401());
            return;
        }
        if (currentBaasUser.getNintendoAccount() != null) {
            callback.invoke(new NPFError(NPFError.ErrorType.NPF_ERROR, HttpStatusCodes.STATUS_CODE_FORBIDDEN, "Already linked with Nintendo Account"));
            return;
        }
        String idToken = nintendoAccount.getIdToken();
        if (idToken == null || idToken.length() == 0) {
            callback.invoke(new NPFError(NPFError.ErrorType.NPF_ERROR, 400, "nintendoAccount parameter is invalid"));
        } else {
            this.d.link(currentBaasUser, new LinkedAccount("nintendoAccount", idToken), new b(callback, nintendoAccount, currentBaasUser));
        }
    }

    @Override // com.nintendo.npf.sdk.user.BaasAccountService
    public void resetDeviceAccount() {
        this.i.a(null, null);
        h0.d(this.d.getCurrentBaasUser());
        v3.b(this.g.getCurrentNintendoAccount());
        this.i.b(null);
        this.i.a(null);
        ((m4) this.c.invoke()).b();
        this.f.c();
    }

    @Override // com.nintendo.npf.sdk.user.BaasAccountService
    public void retryBaasAuth(boolean z, Function2 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SDKLog.i(l, "retryBaaSAuth is called");
        this.e.a(z, callback);
    }

    @Override // com.nintendo.npf.sdk.user.BaasAccountService
    public void save(Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaaSUser currentBaasUser = this.d.getCurrentBaasUser();
        if (h0.c(currentBaasUser)) {
            this.d.updateUser(currentBaasUser, new c(callback, currentBaasUser));
        } else {
            callback.invoke(this.j.create_BaasAccount_NotLoggedIn_401());
        }
    }

    @Override // com.nintendo.npf.sdk.user.BaasAccountService
    public void setLanguage(String language, final Function1 callback) {
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (Intrinsics.areEqual(this.h.getLanguage(), language)) {
            callback.invoke(null);
        } else {
            this.h.saveLanguage(language);
            ((c0) this.b.invoke()).a(null, null, new c0.a() { // from class: com.nintendo.npf.sdk.core.f0$$ExternalSyntheticLambda0
                @Override // com.nintendo.npf.sdk.core.c0.a
                public final void a(BaaSUser baaSUser, String str, NPFError nPFError) {
                    f0.a(callback, baaSUser, str, nPFError);
                }
            });
        }
    }

    @Override // com.nintendo.npf.sdk.user.BaasAccountService
    public void switchByNintendoAccount(NintendoAccount switchableNintendoAccount, final Function2 callback) {
        Intrinsics.checkNotNullParameter(switchableNintendoAccount, "switchableNintendoAccount");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaaSUser currentBaasUser = this.d.getCurrentBaasUser();
        if (!h0.c(currentBaasUser)) {
            callback.invoke(null, this.j.create_BaasAccount_NotLoggedIn_401());
            return;
        }
        final String userId = currentBaasUser.getUserId();
        this.d.isRunning().set(true);
        ((c0) this.b.invoke()).a(switchableNintendoAccount.getIdToken(), switchableNintendoAccount.sessionToken, switchableNintendoAccount.getCountry(), false, new c0.a() { // from class: com.nintendo.npf.sdk.core.f0$$ExternalSyntheticLambda1
            @Override // com.nintendo.npf.sdk.core.c0.a
            public final void a(BaaSUser baaSUser, String str, NPFError nPFError) {
                f0.a(this.f$0, callback, userId, baaSUser, str, nPFError);
            }
        });
    }

    @Override // com.nintendo.npf.sdk.user.BaasAccountService
    public void switchNewBaasUser(Function2 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SDKLog.i(l, "switchNewBaasUser is called");
        BaaSUser currentBaasUser = this.d.getCurrentBaasUser();
        if (!h0.c(currentBaasUser)) {
            callback.invoke(null, this.j.create_BaasAccount_NotLoggedIn_401());
        } else if (!this.d.isRunning().compareAndSet(false, true)) {
            callback.invoke(null, this.j.create_ProcessCancel_Minus1("Baas Account Service switchNewBaasUser can't run multiply"));
        } else {
            this.d.loginNewBaasUser(new d(callback, currentBaasUser, currentBaasUser.getUserId()));
        }
    }

    public final BaasAccountRepository a() {
        return this.d;
    }

    public final Function0 b() {
        return this.f449a;
    }

    public final Function0 c() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function1 callback, BaaSUser baaSUser, String str, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(nPFError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(f0 this$0, Function2 callback, String oldUserId, BaaSUser baaSUser, String str, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(oldUserId, "$oldUserId");
        this$0.d.isRunning().set(false);
        if (nPFError != null) {
            callback.invoke(null, nPFError);
            return;
        }
        this$0.h.setSessionId(str);
        ((m4) this$0.c.invoke()).b();
        callback.invoke(new SwitchResult(oldUserId, baaSUser.getUserId()), null);
    }
}
