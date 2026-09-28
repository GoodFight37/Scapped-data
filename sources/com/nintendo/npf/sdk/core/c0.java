package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade;
import com.nintendo.npf.sdk.domain.repository.BaasAccountRepository;
import com.nintendo.npf.sdk.domain.repository.NintendoAccountRepository;
import com.nintendo.npf.sdk.internal.model.Capabilities;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.LinkedAccount;
import com.nintendo.npf.sdk.user.NintendoAccount;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public class c0 {
    private static final String g = "c0";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Capabilities f421a;
    private final Function0 b;
    private final BaasAccountRepository c;
    private final NintendoAccountRepository d;
    private final DeviceDataFacade e;
    private final a1 f;

    public interface a {
        void a(BaaSUser baaSUser, String str, NPFError nPFError);
    }

    public c0(Capabilities capabilities, Function0 function0, BaasAccountRepository baasAccountRepository, NintendoAccountRepository nintendoAccountRepository, DeviceDataFacade deviceDataFacade, a1 a1Var) {
        this.f421a = capabilities;
        this.b = function0;
        this.c = baasAccountRepository;
        this.d = nintendoAccountRepository;
        this.e = deviceDataFacade;
        this.f = a1Var;
    }

    public void a(String str, String str2, a aVar) {
        a(str, str2, null, false, aVar);
    }

    public void a(String str, final String str2, String str3, final boolean z, final a aVar) {
        SDKLog.i(g, "executeBaaSAuth is called");
        boolean z2 = str == null;
        final BaaSUser currentBaasUser = this.c.getCurrentBaasUser();
        final boolean z3 = z2;
        Function2<? super p1, ? super NPFError, Unit> function2 = new Function2() { // from class: com.nintendo.npf.sdk.core.c0$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return this.f$0.a(z3, aVar, currentBaasUser, str2, z, (p1) obj, (NPFError) obj2);
            }
        };
        if (!z2) {
            this.c.federate(currentBaasUser.getUserId(), new LinkedAccount("nintendoAccount", str), str3, function2);
        } else {
            ((NPFSDK.EventHandler) this.b.invoke()).onBaaSAuthStart();
            this.c.login(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit a(final boolean z, final a aVar, final BaaSUser baaSUser, String str, boolean z2, final p1 p1Var, NPFError nPFError) {
        if (nPFError != null) {
            if (z) {
                ((NPFSDK.EventHandler) this.b.invoke()).onBaaSAuthError(nPFError);
            }
            aVar.a(null, null, nPFError);
            return Unit.INSTANCE;
        }
        final BaaSUser baaSUserE = p1Var.e();
        if (h0.c(baaSUser) && !baaSUserE.getUserId().equals(baaSUser.getUserId()) && z) {
            SDKLog.w(g, "Cancel user update for old response data");
            ((NPFSDK.EventHandler) this.b.invoke()).onBaaSAuthUpdate(baaSUser);
            aVar.a(baaSUser, this.e.getSessionId(), null);
            return Unit.INSTANCE;
        }
        a(p1Var);
        LinkedAccount linkedAccount = (LinkedAccount) h0.a(baaSUserE).get("nintendoAccount");
        if (linkedAccount != null) {
            this.d.getNintendoAccount(linkedAccount.getFederatedId(), str, z2, new Function2() { // from class: com.nintendo.npf.sdk.core.c0$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return this.f$0.a(baaSUser, baaSUserE, z, aVar, p1Var, (NintendoAccount) obj, (r1) obj2);
                }
            });
        } else {
            h0.a(baaSUser, baaSUserE, true, this.f421a.isSandbox());
            if (z) {
                ((NPFSDK.EventHandler) this.b.invoke()).onBaaSAuthUpdate(baaSUser);
            }
            aVar.a(baaSUser, p1Var.d(), null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit a(BaaSUser baaSUser, BaaSUser baaSUser2, boolean z, a aVar, p1 p1Var, NintendoAccount nintendoAccount, r1 r1Var) {
        NintendoAccount currentNintendoAccount = null;
        if (r1Var != null) {
            NPFError nPFErrorA = r1Var.a();
            String strB = r1Var.b();
            v3.b(this.d.getCurrentNintendoAccount());
            h0.a(baaSUser, baaSUser2, true, this.f421a.isSandbox());
            if (!strB.isEmpty() && g3.a(nPFErrorA)) {
                currentNintendoAccount = this.d.getCurrentNintendoAccount();
            }
            h0.a(baaSUser, currentNintendoAccount);
            if (z) {
                ((NPFSDK.EventHandler) this.b.invoke()).onBaaSAuthUpdate(baaSUser);
                ((NPFSDK.EventHandler) this.b.invoke()).onNintendoAccountAuthError(nPFErrorA);
            }
            aVar.a(baaSUser, p1Var.d(), nPFErrorA);
        } else {
            h0.a(baaSUser, baaSUser2, true, this.f421a.isSandbox());
            h0.a(baaSUser, this.d.getCurrentNintendoAccount());
            if (z) {
                ((NPFSDK.EventHandler) this.b.invoke()).onBaaSAuthUpdate(baaSUser);
            }
            aVar.a(baaSUser, p1Var.d(), null);
        }
        return Unit.INSTANCE;
    }

    public void a(p1 p1Var) {
        q1.a(p1Var, this.f, this.f421a);
    }
}
