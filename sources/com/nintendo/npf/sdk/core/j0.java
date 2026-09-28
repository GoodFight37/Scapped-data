package com.nintendo.npf.sdk.core;

import android.app.Activity;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.BaasAccountService;
import com.nintendo.npf.sdk.user.NintendoAccount;
import com.nintendo.npf.sdk.user.NintendoAccountService;
import com.nintendo.npf.sdk.user.SwitchResult;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 {
    public static final a d = new a(null);
    private static final String e = "j0";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ErrorFactory f489a;
    private final Function0 b;
    private final Function0 c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaaSUser.SwitchByNintendoAccountCallback f490a;
        final /* synthetic */ j0 b;

        static final class a extends Lambda implements Function2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BaaSUser.SwitchByNintendoAccountCallback f491a;
            final /* synthetic */ NintendoAccount b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(BaaSUser.SwitchByNintendoAccountCallback switchByNintendoAccountCallback, NintendoAccount nintendoAccount) {
                super(2);
                this.f491a = switchByNintendoAccountCallback;
                this.b = nintendoAccount;
            }

            public final void a(SwitchResult switchResult, NPFError nPFError) {
                if (nPFError != null) {
                    this.f491a.onComplete(null, null, this.b, nPFError);
                    return;
                }
                BaaSUser.SwitchByNintendoAccountCallback switchByNintendoAccountCallback = this.f491a;
                Intrinsics.checkNotNull(switchResult);
                switchByNintendoAccountCallback.onComplete(switchResult.getOldUserId(), switchResult.getNewUserId(), this.b, null);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((SwitchResult) obj, (NPFError) obj2);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(BaaSUser.SwitchByNintendoAccountCallback switchByNintendoAccountCallback, j0 j0Var) {
            super(2);
            this.f490a = switchByNintendoAccountCallback;
            this.b = j0Var;
        }

        public final void a(NintendoAccount nintendoAccount, NPFError nPFError) {
            if (nPFError != null) {
                this.f490a.onComplete(null, null, null, nPFError);
                return;
            }
            BaasAccountService baasAccountService = (BaasAccountService) this.b.c.invoke();
            Intrinsics.checkNotNull(nintendoAccount);
            baasAccountService.switchByNintendoAccount(nintendoAccount, new a(this.f490a, nintendoAccount));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((NintendoAccount) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaaSUser.SwitchByNintendoAccountCallback f492a;
        final /* synthetic */ j0 b;

        static final class a extends Lambda implements Function2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BaaSUser.SwitchByNintendoAccountCallback f493a;
            final /* synthetic */ NintendoAccount b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(BaaSUser.SwitchByNintendoAccountCallback switchByNintendoAccountCallback, NintendoAccount nintendoAccount) {
                super(2);
                this.f493a = switchByNintendoAccountCallback;
                this.b = nintendoAccount;
            }

            public final void a(SwitchResult switchResult, NPFError nPFError) {
                if (nPFError != null) {
                    this.f493a.onComplete(null, null, this.b, nPFError);
                    return;
                }
                BaaSUser.SwitchByNintendoAccountCallback switchByNintendoAccountCallback = this.f493a;
                Intrinsics.checkNotNull(switchResult);
                switchByNintendoAccountCallback.onComplete(switchResult.getOldUserId(), switchResult.getNewUserId(), this.b, null);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((SwitchResult) obj, (NPFError) obj2);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(BaaSUser.SwitchByNintendoAccountCallback switchByNintendoAccountCallback, j0 j0Var) {
            super(2);
            this.f492a = switchByNintendoAccountCallback;
            this.b = j0Var;
        }

        public final void a(NintendoAccount nintendoAccount, NPFError nPFError) {
            if (nPFError != null) {
                this.f492a.onComplete(null, null, null, nPFError);
                return;
            }
            BaasAccountService baasAccountService = (BaasAccountService) this.b.c.invoke();
            Intrinsics.checkNotNull(nintendoAccount);
            baasAccountService.switchByNintendoAccount(nintendoAccount, new a(this.f492a, nintendoAccount));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((NintendoAccount) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    static final class d extends Lambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaaSUser.SwitchByNintendoAccountCallback f494a;
        final /* synthetic */ j0 b;

        static final class a extends Lambda implements Function2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BaaSUser.SwitchByNintendoAccountCallback f495a;
            final /* synthetic */ NintendoAccount b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(BaaSUser.SwitchByNintendoAccountCallback switchByNintendoAccountCallback, NintendoAccount nintendoAccount) {
                super(2);
                this.f495a = switchByNintendoAccountCallback;
                this.b = nintendoAccount;
            }

            public final void a(SwitchResult switchResult, NPFError nPFError) {
                if (nPFError != null) {
                    this.f495a.onComplete(null, null, this.b, nPFError);
                    return;
                }
                BaaSUser.SwitchByNintendoAccountCallback switchByNintendoAccountCallback = this.f495a;
                Intrinsics.checkNotNull(switchResult);
                switchByNintendoAccountCallback.onComplete(switchResult.getOldUserId(), switchResult.getNewUserId(), this.b, null);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((SwitchResult) obj, (NPFError) obj2);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(BaaSUser.SwitchByNintendoAccountCallback switchByNintendoAccountCallback, j0 j0Var) {
            super(2);
            this.f494a = switchByNintendoAccountCallback;
            this.b = j0Var;
        }

        public final void a(NintendoAccount nintendoAccount, NPFError nPFError) {
            if (nPFError != null) {
                this.f494a.onComplete(null, null, null, nPFError);
                return;
            }
            BaasAccountService baasAccountService = (BaasAccountService) this.b.c.invoke();
            Intrinsics.checkNotNull(nintendoAccount);
            baasAccountService.switchByNintendoAccount(nintendoAccount, new a(this.f494a, nintendoAccount));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((NintendoAccount) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    public j0(ErrorFactory errorFactory, Function0 nintendoAccountServiceProvider, Function0 baasAccountServiceProvider) {
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        Intrinsics.checkNotNullParameter(nintendoAccountServiceProvider, "nintendoAccountServiceProvider");
        Intrinsics.checkNotNullParameter(baasAccountServiceProvider, "baasAccountServiceProvider");
        this.f489a = errorFactory;
        this.b = nintendoAccountServiceProvider;
        this.c = baasAccountServiceProvider;
    }

    public final void a(BaaSUser user, Activity activity, List list, BaaSUser.SwitchByNintendoAccountCallback callback) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SDKLog.i(e, "switchByNintendoAccount is called");
        if (h0.c(user)) {
            ((NintendoAccountService) this.b.invoke()).authorizeBySwitchableNintendoAccountLegacy(activity, list, new c(callback, this));
        } else {
            callback.onComplete(null, null, null, this.f489a.create_BaasAccount_NotLoggedIn_401());
        }
    }

    public final void a(Activity activity, List list, BaaSUser.SwitchByNintendoAccountCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((NintendoAccountService) this.b.invoke()).authorizeBySwitchableNintendoAccount(activity, list, MapsKt.emptyMap(), new d(callback, this));
    }

    public final void a(BaaSUser.SwitchByNintendoAccountCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((NintendoAccountService) this.b.invoke()).retryPendingAuthorizationBySwitchableNintendoAccount(new b(callback, this));
    }
}
