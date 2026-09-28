package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade;
import com.nintendo.npf.sdk.domain.repository.BaasAccountRepository;
import com.nintendo.npf.sdk.domain.repository.NintendoAccountRepository;
import com.nintendo.npf.sdk.internal.model.Capabilities;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.LinkToBaasUserCallback;
import com.nintendo.npf.sdk.user.LinkedAccount;
import com.nintendo.npf.sdk.user.LinkedAccountService;
import com.nintendo.npf.sdk.user.NintendoAccount;
import com.nintendo.npf.sdk.user.SwitchBaasUserCallback;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class x2 implements LinkedAccountService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f616a;
    private final m4 b;
    private final Capabilities c;
    private final BaasAccountRepository d;
    private final NintendoAccountRepository e;
    private final y2 f;
    private final DeviceDataFacade g;
    private final a1 h;
    private final ErrorFactory i;

    static final class a extends Lambda implements Function2 {
        final /* synthetic */ LinkToBaasUserCallback b;
        final /* synthetic */ BaaSUser c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(LinkToBaasUserCallback linkToBaasUserCallback, BaaSUser baaSUser) {
            super(2);
            this.b = linkToBaasUserCallback;
            this.c = baaSUser;
        }

        public final void a(BaaSUser baaSUser, NPFError nPFError) {
            x2.this.d.isRunning().set(false);
            if (nPFError != null) {
                this.b.onComplete(nPFError);
            } else {
                if (baaSUser == null) {
                    this.b.onComplete(nPFError);
                    return;
                }
                baaSUser.setNintendoAccount$NPFSDK_release(this.c.getNintendoAccount());
                h0.a(this.c, baaSUser, false, x2.this.c.isSandbox());
                this.b.onComplete(null);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((BaaSUser) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function2 {
        final /* synthetic */ SwitchBaasUserCallback b;
        final /* synthetic */ BaaSUser c;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(SwitchBaasUserCallback switchBaasUserCallback, BaaSUser baaSUser, String str) {
            super(2);
            this.b = switchBaasUserCallback;
            this.c = baaSUser;
            this.d = str;
        }

        public final void a(p1 p1Var, NPFError nPFError) {
            x2.this.d.isRunning().set(false);
            if (nPFError != null) {
                this.b.onComplete(null, null, null, nPFError);
                return;
            }
            if (p1Var == null) {
                return;
            }
            q1.a(p1Var, x2.this.h, x2.this.c);
            BaaSUser baaSUserE = p1Var.e();
            NintendoAccount nintendoAccount = this.c.getNintendoAccount();
            if (nintendoAccount != null && baaSUserE.getLinkedAccounts$NPFSDK_release().containsKey("nintendoAccount") && Intrinsics.areEqual(((LinkedAccount) MapsKt.getValue(baaSUserE.getLinkedAccounts$NPFSDK_release(), "nintendoAccount")).getFederatedId(), nintendoAccount.getNintendoAccountId())) {
                baaSUserE.setNintendoAccount$NPFSDK_release(nintendoAccount);
            } else {
                v3.b(x2.this.e.getCurrentNintendoAccount());
                x2.this.h.b(null);
                x2.this.h.a(null);
            }
            h0.a(this.c, baaSUserE, true, x2.this.c.isSandbox());
            x2.this.g.setSessionId(p1Var.d());
            x2.this.b.b();
            this.b.onComplete(this.d, baaSUserE.getUserId(), this.c.getLinkedAccounts$NPFSDK_release().get(x2.this.f616a), null);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((p1) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    public x2(String providerId, m4 pushNotificationChannelService, Capabilities capabilities, BaasAccountRepository baasAccountRepository, NintendoAccountRepository nintendoAccountRepository, y2 linkedAccountRepository, DeviceDataFacade deviceDataFacade, a1 credentialsDataFacade, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(providerId, "providerId");
        Intrinsics.checkNotNullParameter(pushNotificationChannelService, "pushNotificationChannelService");
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        Intrinsics.checkNotNullParameter(baasAccountRepository, "baasAccountRepository");
        Intrinsics.checkNotNullParameter(nintendoAccountRepository, "nintendoAccountRepository");
        Intrinsics.checkNotNullParameter(linkedAccountRepository, "linkedAccountRepository");
        Intrinsics.checkNotNullParameter(deviceDataFacade, "deviceDataFacade");
        Intrinsics.checkNotNullParameter(credentialsDataFacade, "credentialsDataFacade");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f616a = providerId;
        this.b = pushNotificationChannelService;
        this.c = capabilities;
        this.d = baasAccountRepository;
        this.e = nintendoAccountRepository;
        this.f = linkedAccountRepository;
        this.g = deviceDataFacade;
        this.h = credentialsDataFacade;
        this.i = errorFactory;
    }

    @Override // com.nintendo.npf.sdk.user.LinkedAccountService
    public void linkToBaasUser(String str, LinkToBaasUserCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaaSUser currentBaasUser = this.d.getCurrentBaasUser();
        if (!h0.c(currentBaasUser)) {
            callback.onComplete(this.i.create_BaasAccount_NotLoggedIn_401());
            return;
        }
        if (currentBaasUser.getLinkedAccounts$NPFSDK_release().containsKey(this.f616a)) {
            callback.onComplete(this.i.create_LinkedAccount_AlreadyLinked_5403(this.f616a));
            return;
        }
        if (str == null) {
            callback.onComplete(this.i.create_LinkedAccount_InvalidIdToken_5400());
        } else if (this.d.isRunning().compareAndSet(false, true)) {
            this.f.link(currentBaasUser, new LinkedAccount(this.f616a, str), new a(callback, currentBaasUser));
        } else {
            callback.onComplete(this.i.create_ProcessCancel_Minus1("Linked Account linkToBaasUser can't run multiply"));
        }
    }

    @Override // com.nintendo.npf.sdk.user.LinkedAccountService
    public void switchBaasUser(String str, SwitchBaasUserCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaaSUser currentBaasUser = this.d.getCurrentBaasUser();
        if (!h0.c(currentBaasUser)) {
            callback.onComplete(null, null, null, this.i.create_BaasAccount_NotLoggedIn_401());
            return;
        }
        if (str == null) {
            callback.onComplete(null, null, null, this.i.create_LinkedAccount_InvalidIdToken_5400());
        } else if (!this.d.isRunning().compareAndSet(false, true)) {
            callback.onComplete(null, null, null, this.i.create_ProcessCancel_Minus1("Linked Account switchBaasUser can't run multiply"));
        } else {
            String userId = currentBaasUser.getUserId();
            this.f.a(userId, new LinkedAccount(this.f616a, str), new b(callback, currentBaasUser, userId));
        }
    }
}
