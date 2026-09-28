package com.nintendo.npf.sdk.core;

import android.app.Activity;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.repository.BaasAccountRepository;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.LinkedAccount;
import com.nintendo.npf.sdk.user.NintendoAccountService;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class u3 implements NintendoAccountService {
    public static final a e = new a(null);
    private static final String f = "u3";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a1 f580a;
    private final BaasAccountRepository b;
    private final ErrorFactory c;
    private final o3 d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public u3(a1 credentialsDataFacade, BaasAccountRepository baasAccountRepository, ErrorFactory errorFactory, o3 naAuthorizationHandler) {
        Intrinsics.checkNotNullParameter(credentialsDataFacade, "credentialsDataFacade");
        Intrinsics.checkNotNullParameter(baasAccountRepository, "baasAccountRepository");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        Intrinsics.checkNotNullParameter(naAuthorizationHandler, "naAuthorizationHandler");
        this.f580a = credentialsDataFacade;
        this.b = baasAccountRepository;
        this.c = errorFactory;
        this.d = naAuthorizationHandler;
    }

    @Override // com.nintendo.npf.sdk.user.NintendoAccountService
    public void authorizeByNintendoAccount(Activity activity, List list, Map optionalQuery, Function2 callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(optionalQuery, "optionalQuery");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SDKLog.i(f, "authorizeByNintendoAccount is called");
        if (!h0.c(this.b.getCurrentBaasUser())) {
            callback.invoke(null, this.c.create_BaasAccount_NotLoggedIn_401());
            return;
        }
        LinkedAccount linkedAccount = this.b.getCurrentBaasUser().getLinkedAccounts$NPFSDK_release().get("nintendoAccount");
        this.d.a(activity, q3.b.a(), list, this.f580a.d(), linkedAccount != null ? linkedAccount.getFederatedId() : null, optionalQuery, false, callback);
    }

    @Override // com.nintendo.npf.sdk.user.NintendoAccountService
    public void authorizeByNintendoAccountLegacy(Activity activity, List list, Function2 callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SDKLog.i(f, "authorizeByNintendoAccount is called");
        BaaSUser currentBaasUser = this.b.getCurrentBaasUser();
        if (!h0.c(currentBaasUser)) {
            callback.invoke(null, this.c.create_BaasAccount_NotLoggedIn_401());
            return;
        }
        LinkedAccount linkedAccount = currentBaasUser.getLinkedAccounts$NPFSDK_release().get("nintendoAccount");
        this.d.a(activity, q3.b.a(), list, this.f580a.d(), linkedAccount != null ? linkedAccount.getFederatedId() : null, callback);
    }

    @Override // com.nintendo.npf.sdk.user.NintendoAccountService
    public void authorizeBySwitchableNintendoAccount(Activity activity, List list, Map optionalQuery, Function2 callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(optionalQuery, "optionalQuery");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SDKLog.i(f, "authorizeBySwitchableNintendoAccount is called");
        if (h0.c(this.b.getCurrentBaasUser())) {
            this.d.a(activity, q3.b.b(), list, null, null, optionalQuery, false, callback);
        } else {
            callback.invoke(null, this.c.create_BaasAccount_NotLoggedIn_401());
        }
    }

    @Override // com.nintendo.npf.sdk.user.NintendoAccountService
    public void authorizeBySwitchableNintendoAccountLegacy(Activity activity, List list, Function2 callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SDKLog.i(f, "switchByNintendoAccount is called");
        if (h0.c(this.b.getCurrentBaasUser())) {
            this.d.a(activity, q3.b.b(), list, (String) null, (String) null, callback);
        } else {
            callback.invoke(null, this.c.create_BaasAccount_NotLoggedIn_401());
        }
    }

    @Override // com.nintendo.npf.sdk.user.NintendoAccountService
    public void retryPendingAuthorizationByNintendoAccount(Function2 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SDKLog.i(f, "retryPendingAuthorizationByNintendoAccount is called");
        if (h0.c(this.b.getCurrentBaasUser())) {
            this.d.a(q3.b.a(), callback);
        } else {
            callback.invoke(null, this.c.create_BaasAccount_NotLoggedIn_401());
        }
    }

    @Override // com.nintendo.npf.sdk.user.NintendoAccountService
    public void retryPendingAuthorizationBySwitchableNintendoAccount(Function2 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SDKLog.i(f, "retryPendingAuthorizationBySwitchableNintendoAccount is called");
        if (h0.c(this.b.getCurrentBaasUser())) {
            this.d.a(q3.b.b(), callback);
        } else {
            callback.invoke(null, this.c.create_BaasAccount_NotLoggedIn_401());
        }
    }
}
