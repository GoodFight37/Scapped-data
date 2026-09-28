package com.nintendo.npf.sdk.core;

import android.app.Activity;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.domain.repository.NintendoAccountRepository;
import com.nintendo.npf.sdk.internal.billing.BillingHelper;
import com.nintendo.npf.sdk.internal.impl.ProcessLifecycleObserver;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.BaasAccountService;
import com.nintendo.npf.sdk.user.LinkedAccountService;
import com.nintendo.npf.sdk.user.NintendoAccount;
import com.nintendo.npf.sdk.user.NintendoAccountService;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public final class i3 {
    public static final a i = new a(null);
    private static final String j = "i3";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NintendoAccountRepository f479a;
    private final u1 b;
    private final Function0 c;
    private final Function0 d;
    private final ProcessLifecycleObserver e;
    private final z2 f;
    private final CoroutineDispatcher g;
    private final CoroutineScope h;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2 f480a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Function2 function2) {
            super(2);
            this.f480a = function2;
        }

        public final void a(NintendoAccount nintendoAccount, NPFError nPFError) {
            this.f480a.invoke(nintendoAccount, nPFError);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((NintendoAccount) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    static final class c extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f481a;
        final /* synthetic */ boolean b;
        final /* synthetic */ i3 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(boolean z, i3 i3Var, Continuation continuation) {
            super(2, continuation);
            this.b = z;
            this.c = i3Var;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new c(this.b, this.c, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
        
            if (com.nintendo.npf.sdk.core.z2.a(r5, false, r4, 1, null) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.f481a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r5)
                goto L45
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                kotlin.ResultKt.throwOnFailure(r5)
                goto L34
            L1e:
                kotlin.ResultKt.throwOnFailure(r5)
                boolean r5 = r4.b
                if (r5 == 0) goto L45
                com.nintendo.npf.sdk.core.i3 r5 = r4.c
                com.nintendo.npf.sdk.core.u1 r5 = com.nintendo.npf.sdk.core.i3.a(r5)
                r4.f481a = r3
                java.lang.Object r5 = r5.a(r4)
                if (r5 != r0) goto L34
                goto L44
            L34:
                com.nintendo.npf.sdk.core.i3 r5 = r4.c
                com.nintendo.npf.sdk.core.z2 r5 = com.nintendo.npf.sdk.core.i3.b(r5)
                r4.f481a = r2
                r1 = 0
                r2 = 0
                java.lang.Object r5 = com.nintendo.npf.sdk.core.z2.a(r5, r1, r4, r3, r2)
                if (r5 != r0) goto L45
            L44:
                return r0
            L45:
                com.nintendo.npf.sdk.core.i3 r5 = r4.c
                com.nintendo.npf.sdk.internal.impl.ProcessLifecycleObserver r5 = com.nintendo.npf.sdk.core.i3.c(r5)
                boolean r0 = r4.b
                r5.a(r0)
                androidx.lifecycle.LifecycleOwner r5 = androidx.lifecycle.ProcessLifecycleOwner.get()
                androidx.lifecycle.Lifecycle r5 = r5.getLifecycle()
                com.nintendo.npf.sdk.core.i3 r0 = r4.c
                com.nintendo.npf.sdk.internal.impl.ProcessLifecycleObserver r0 = com.nintendo.npf.sdk.core.i3.c(r0)
                r5.removeObserver(r0)
                androidx.lifecycle.LifecycleOwner r5 = androidx.lifecycle.ProcessLifecycleOwner.get()
                androidx.lifecycle.Lifecycle r5 = r5.getLifecycle()
                com.nintendo.npf.sdk.core.i3 r0 = r4.c
                com.nintendo.npf.sdk.internal.impl.ProcessLifecycleObserver r0 = com.nintendo.npf.sdk.core.i3.c(r0)
                r5.addObserver(r0)
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nintendo.npf.sdk.core.i3.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    static final class d extends Lambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f482a = new d();

        d() {
            super(1);
        }

        public final void a(NPFError nPFError) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((NPFError) obj);
            return Unit.INSTANCE;
        }
    }

    static final class e extends Lambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaaSUser.AuthorizationCallback f483a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(BaaSUser.AuthorizationCallback authorizationCallback) {
            super(2);
            this.f483a = authorizationCallback;
        }

        public final void a(BaaSUser baaSUser, NPFError nPFError) {
            this.f483a.onComplete(baaSUser, nPFError);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((BaaSUser) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    static final class f extends Lambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2 f484a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(Function2 function2) {
            super(2);
            this.f484a = function2;
        }

        public final void a(NintendoAccount nintendoAccount, NPFError nPFError) {
            this.f484a.invoke(nintendoAccount, nPFError);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((NintendoAccount) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i3(NintendoAccountRepository nintendoAccountRepository, u1 googleAdvertisingIdRepository, Function0 nintendoAccountServiceProvider, Function0 baasAccountServiceProvider, ProcessLifecycleObserver processLifecycleObserver, z2 loginHandler) {
        this(nintendoAccountRepository, googleAdvertisingIdRepository, nintendoAccountServiceProvider, baasAccountServiceProvider, processLifecycleObserver, loginHandler, null, null, 192, null);
        Intrinsics.checkNotNullParameter(nintendoAccountRepository, "nintendoAccountRepository");
        Intrinsics.checkNotNullParameter(googleAdvertisingIdRepository, "googleAdvertisingIdRepository");
        Intrinsics.checkNotNullParameter(nintendoAccountServiceProvider, "nintendoAccountServiceProvider");
        Intrinsics.checkNotNullParameter(baasAccountServiceProvider, "baasAccountServiceProvider");
        Intrinsics.checkNotNullParameter(processLifecycleObserver, "processLifecycleObserver");
        Intrinsics.checkNotNullParameter(loginHandler, "loginHandler");
    }

    public final NintendoAccount d() {
        return this.f479a.getCurrentNintendoAccount();
    }

    public final String e() {
        return ((BaasAccountService) this.d.invoke()).getLanguage();
    }

    public final LinkedAccountService f() {
        LinkedAccountService linkedAppleAccountService = x4.a.a().getLinkedAppleAccountService();
        Intrinsics.checkNotNullExpressionValue(linkedAppleAccountService, "getInstance().linkedAppleAccountService");
        return linkedAppleAccountService;
    }

    public final LinkedAccountService g() {
        LinkedAccountService linkedFacebookAccountService = x4.a.a().getLinkedFacebookAccountService();
        Intrinsics.checkNotNullExpressionValue(linkedFacebookAccountService, "getInstance().linkedFacebookAccountService");
        return linkedFacebookAccountService;
    }

    public final LinkedAccountService h() {
        LinkedAccountService linkedGoogleAccountService = x4.a.a().getLinkedGoogleAccountService();
        Intrinsics.checkNotNullExpressionValue(linkedGoogleAccountService, "getInstance().linkedGoogleAccountService");
        return linkedGoogleAccountService;
    }

    public final String i() {
        return BillingHelper.getMarket();
    }

    public final String j() {
        return "https://" + x4.a.a().getCapabilities().getAccountHost() + "/term_chooser/faq";
    }

    public final String k() {
        return "https://" + x4.a.a().getCapabilities().getAccountHost() + "/term_chooser/faq";
    }

    public final String l() {
        return "https://" + x4.a.a().getCapabilities().getAccountHost();
    }

    public final int m() {
        return x4.a.a().getCapabilities().getReadTimeout();
    }

    public final int n() {
        return x4.a.a().getCapabilities().getRequestTimeout();
    }

    public final String o() {
        String sDKVersion = x4.a.a().getCapabilities().getSDKVersion();
        Intrinsics.checkNotNullExpressionValue(sDKVersion, "getInstance().capabilities.sdkVersion");
        return sDKVersion;
    }

    public final long p() {
        return f3.b();
    }

    public final long q() {
        return f3.c();
    }

    public final boolean r() {
        return x4.a.a().getCapabilities().isSandbox();
    }

    public final void s() {
        ((BaasAccountService) this.d.invoke()).resetDeviceAccount();
    }

    public i3(NintendoAccountRepository nintendoAccountRepository, u1 googleAdvertisingIdRepository, Function0 nintendoAccountServiceProvider, Function0 baasAccountServiceProvider, ProcessLifecycleObserver processLifecycleObserver, z2 loginHandler, CoroutineDispatcher mainDispatcher, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(nintendoAccountRepository, "nintendoAccountRepository");
        Intrinsics.checkNotNullParameter(googleAdvertisingIdRepository, "googleAdvertisingIdRepository");
        Intrinsics.checkNotNullParameter(nintendoAccountServiceProvider, "nintendoAccountServiceProvider");
        Intrinsics.checkNotNullParameter(baasAccountServiceProvider, "baasAccountServiceProvider");
        Intrinsics.checkNotNullParameter(processLifecycleObserver, "processLifecycleObserver");
        Intrinsics.checkNotNullParameter(loginHandler, "loginHandler");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f479a = nintendoAccountRepository;
        this.b = googleAdvertisingIdRepository;
        this.c = nintendoAccountServiceProvider;
        this.d = baasAccountServiceProvider;
        this.e = processLifecycleObserver;
        this.f = loginHandler;
        this.g = mainDispatcher;
        this.h = scope;
        String str = j;
        SDKLog.i(str, "NPFSDK.onCreate() is called");
        SDKLog.d(str, "NPFSDK version : " + o());
    }

    public final void a(NPFSDK.EventHandler eventHandler, boolean z) {
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        SDKLog.i(j, "init is called");
        x4.a.a().setEventHandler(eventHandler);
        BuildersKt__Builders_commonKt.launch$default(this.h, null, null, new c(z, this, null), 3, null);
    }

    public final void b(Activity activity, List list, Function2 callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((NintendoAccountService) this.c.invoke()).authorizeByNintendoAccount(activity, list, MapsKt.emptyMap(), new b(callback));
    }

    public final BaaSUser c() {
        return ((BaasAccountService) this.d.invoke()).getCurrentBaasUser();
    }

    public final void b(int i2) {
        x4.a.a().getCapabilities().setRequestTimeout(i2);
    }

    public final String b() {
        try {
            String string = x4.a.a().getCapabilities().toJson().toString(2);
            Intrinsics.checkNotNullExpressionValue(string, "{\n            ServiceLoc…n().toString(2)\n        }");
            return string;
        } catch (JSONException unused) {
            throw new IllegalStateException("Capabilities is invalid JSON");
        }
    }

    public final void a(boolean z, BaaSUser.AuthorizationCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((BaasAccountService) this.d.invoke()).retryBaasAuth(z, new e(callback));
    }

    public final void a(String deviceAccount, String devicePassword, BaaSUser.AuthorizationCallback callback) {
        Intrinsics.checkNotNullParameter(deviceAccount, "deviceAccount");
        Intrinsics.checkNotNullParameter(devicePassword, "devicePassword");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SDKLog.i(j, "retryBaaSAuth is called");
        x4.a.a().getNPFSDK().s();
        x4.a.a().getCredentialsDataFacade().a(deviceAccount, devicePassword);
        a(false, callback);
    }

    public final void a(Activity activity, List list, Function2 callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((NintendoAccountService) this.c.invoke()).authorizeByNintendoAccountLegacy(activity, list, callback);
    }

    public final void a(Function2 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((NintendoAccountService) this.c.invoke()).retryPendingAuthorizationByNintendoAccount(new f(callback));
    }

    public final void a(int i2) {
        x4.a.a().getCapabilities().setReadTimeout(i2);
    }

    public final void a(String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        ((BaasAccountService) this.d.invoke()).setLanguage(language, d.f482a);
    }

    public final void a() {
        f3.a();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ i3(NintendoAccountRepository nintendoAccountRepository, u1 u1Var, Function0 function0, Function0 function1, ProcessLifecycleObserver processLifecycleObserver, z2 z2Var, CoroutineDispatcher coroutineDispatcher, CoroutineScope coroutineScope, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        CoroutineDispatcher main = (i2 & 64) != 0 ? Dispatchers.getMain() : coroutineDispatcher;
        this(nintendoAccountRepository, u1Var, function0, function1, processLifecycleObserver, z2Var, main, (i2 & 128) != 0 ? CoroutineScopeKt.CoroutineScope(main) : coroutineScope);
    }
}
