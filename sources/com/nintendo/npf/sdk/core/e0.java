package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.repository.BaasAccountRepository;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.LinkedAccount;
import com.nintendo.npf.sdk.user.NintendoAccount;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 implements BaasAccountRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a1 f434a;
    private final d0 b;
    private final ErrorFactory c;
    private final AtomicBoolean d;
    private final BaaSUser e;

    static final class a extends Lambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2 f435a;
        final /* synthetic */ e0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Function2 function2, e0 e0Var) {
            super(2);
            this.f435a = function2;
            this.b = e0Var;
        }

        public final void a(o1 o1Var, NPFError nPFError) {
            if (nPFError != null) {
                this.f435a.invoke(null, nPFError);
                return;
            }
            if (o1Var == null) {
                return;
            }
            if (o1Var instanceof o1.a) {
                o1.a aVar = (o1.a) o1Var;
                this.f435a.invoke(null, aVar.a().getErrorCode() == -1 ? aVar.a().copy(NPFError.ErrorType.PROCESS_CANCEL) : aVar.a());
            } else if (o1Var instanceof o1.b) {
                this.f435a.invoke(((o1.b) o1Var).a(), null);
            } else {
                this.f435a.invoke(null, this.b.c.create_Mapper_InvalidJson_422("Baas user is null"));
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((o1) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2 f436a;
        final /* synthetic */ e0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Function2 function2, e0 e0Var) {
            super(2);
            this.f436a = function2;
            this.b = e0Var;
        }

        public final void a(o1 o1Var, NPFError nPFError) {
            if (nPFError != null) {
                this.f436a.invoke(null, nPFError);
                return;
            }
            if (o1Var == null) {
                return;
            }
            if (o1Var instanceof o1.a) {
                o1.a aVar = (o1.a) o1Var;
                this.f436a.invoke(null, aVar.a().getErrorCode() == -1 ? aVar.a().copy(NPFError.ErrorType.PROCESS_CANCEL) : aVar.a());
            } else if (o1Var instanceof o1.b) {
                this.f436a.invoke(((o1.b) o1Var).a(), null);
            } else {
                this.f436a.invoke(null, this.b.c.create_Mapper_InvalidJson_422("Baas user is null"));
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((o1) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2 f437a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Function2 function2) {
            super(2);
            this.f437a = function2;
        }

        public final void a(o1 o1Var, NPFError nPFError) {
            if (nPFError != null) {
                this.f437a.invoke(null, nPFError);
                return;
            }
            if (o1Var == null) {
                return;
            }
            if (o1Var instanceof o1.a) {
                o1.a aVar = (o1.a) o1Var;
                this.f437a.invoke(null, aVar.a().copy(NPFError.ErrorType.NPF_ERROR, 9999, aVar.a().getErrorMessage()));
            } else if (o1Var instanceof o1.b) {
                this.f437a.invoke(((o1.b) o1Var).a(), null);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((o1) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    public e0(a1 credentialsDataFacade, d0 baasAccountApi, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(credentialsDataFacade, "credentialsDataFacade");
        Intrinsics.checkNotNullParameter(baasAccountApi, "baasAccountApi");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f434a = credentialsDataFacade;
        this.b = baasAccountApi;
        this.c = errorFactory;
        this.d = new AtomicBoolean(false);
        this.e = new BaaSUser();
    }

    @Override // com.nintendo.npf.sdk.domain.repository.BaasAccountRepository
    public void federate(String currentBaasUserId, LinkedAccount linkedAccount, String str, Function2 callback) throws JSONException {
        Intrinsics.checkNotNullParameter(currentBaasUserId, "currentBaasUserId");
        Intrinsics.checkNotNullParameter(linkedAccount, "linkedAccount");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.b.a(currentBaasUserId, linkedAccount, str, new a(callback, this));
    }

    @Override // com.nintendo.npf.sdk.domain.repository.BaasAccountRepository
    public void findLoggedInAccount(Function2 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        BaaSUser currentBaasUser = getCurrentBaasUser();
        if (h0.c(currentBaasUser)) {
            block.invoke(currentBaasUser, null);
        } else {
            block.invoke(null, this.c.create_BaasAccount_NotLoggedIn_401());
        }
    }

    @Override // com.nintendo.npf.sdk.domain.repository.BaasAccountRepository
    public BaaSUser getCurrentBaasUser() {
        return this.e;
    }

    @Override // com.nintendo.npf.sdk.domain.repository.BaasAccountRepository
    public void getUsers(BaaSUser currentBaasUser, List userIds, Function2 callback) {
        Intrinsics.checkNotNullParameter(currentBaasUser, "currentBaasUser");
        Intrinsics.checkNotNullParameter(userIds, "userIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.b.a(currentBaasUser, userIds, callback);
    }

    @Override // com.nintendo.npf.sdk.domain.repository.BaasAccountRepository
    public AtomicBoolean isRunning() {
        return this.d;
    }

    @Override // com.nintendo.npf.sdk.domain.repository.BaasAccountRepository
    public void link(BaaSUser currentBaasUser, LinkedAccount linkTarget, Function2 callback) {
        Intrinsics.checkNotNullParameter(currentBaasUser, "currentBaasUser");
        Intrinsics.checkNotNullParameter(linkTarget, "linkTarget");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.b.a(currentBaasUser, linkTarget, callback);
    }

    @Override // com.nintendo.npf.sdk.domain.repository.BaasAccountRepository
    public void login(Function2 callback) throws JSONException {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.b.a(a(), new b(callback, this));
    }

    @Override // com.nintendo.npf.sdk.domain.repository.BaasAccountRepository
    public void loginNewBaasUser(Function2 callback) throws JSONException {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.b.a(new c(callback));
    }

    @Override // com.nintendo.npf.sdk.domain.repository.BaasAccountRepository
    public void updateUser(BaaSUser user, Function2 callback) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.b.a(user, callback);
    }

    private final String a() {
        NintendoAccount nintendoAccount;
        if (h0.c(getCurrentBaasUser()) && Intrinsics.areEqual(this.f434a.c(), getCurrentBaasUser().getDeviceAccount()) && (nintendoAccount = getCurrentBaasUser().getNintendoAccount()) != null) {
            return nintendoAccount.getCountry();
        }
        return null;
    }
}
