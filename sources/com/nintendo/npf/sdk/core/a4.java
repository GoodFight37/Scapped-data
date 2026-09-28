package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.repository.BaasAccountRepository;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.OtherUserService;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a4 implements OtherUserService {
    public static final a c = new a(null);
    private static final String d = "a4";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BaasAccountRepository f409a;
    private final ErrorFactory b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public a4(BaasAccountRepository baasAccountRepository, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(baasAccountRepository, "baasAccountRepository");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f409a = baasAccountRepository;
        this.b = errorFactory;
    }

    @Override // com.nintendo.npf.sdk.user.OtherUserService
    public void getAsList(List userIds, Function2 callback) {
        Intrinsics.checkNotNullParameter(userIds, "userIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SDKLog.i(d, "getAsList is called");
        BaaSUser currentBaasUser = this.f409a.getCurrentBaasUser();
        if (!h0.c(currentBaasUser)) {
            callback.invoke(null, this.b.create_BaasAccount_NotLoggedIn_401());
            return;
        }
        if (userIds.isEmpty()) {
            callback.invoke(null, new NPFError(NPFError.ErrorType.NPF_ERROR, 400, "List is null or empty"));
        } else if (userIds.size() > 100) {
            callback.invoke(null, new NPFError(NPFError.ErrorType.NPF_ERROR, 400, "List size cannot be over 100"));
        } else {
            this.f409a.getUsers(currentBaasUser, userIds, callback);
        }
    }
}
