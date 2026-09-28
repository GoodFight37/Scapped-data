package com.nintendo.npf.sdk.internal.impl.cpp;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.core.x4;
import com.nintendo.npf.sdk.internal.impl.NativeBridgeUtil;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.NintendoAccount;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class BaaSUserLinkEventHandler implements BaaSUser.LinkNintendoAccountCallback {
    static NintendoAccount c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f843a;
    private long b;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final x4 f844a = x4.a.a();
    }

    public BaaSUserLinkEventHandler() {
        this.f843a = -1L;
        this.b = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit a(BaaSUser.LinkNintendoAccountCallback linkNintendoAccountCallback, NPFError nPFError) {
        linkNintendoAccountCallback.onComplete(nPFError);
        return Unit.INSTANCE;
    }

    public static void linkNintendoAccount(long j, long j2, byte[] bArr) {
        if (c == null || !new String(bArr).equals(c.getNintendoAccountId())) {
            new BaaSUserLinkEventHandler(j, j2).onComplete(new NPFError(NPFError.ErrorType.NPF_ERROR, 400, "parameter nintendoAccount is invalid"));
        } else {
            final BaaSUserLinkEventHandler baaSUserLinkEventHandler = new BaaSUserLinkEventHandler(j, j2);
            NPFSDK.getBaasAccountService().linkNintendoAccount(c, new Function1() { // from class: com.nintendo.npf.sdk.internal.impl.cpp.BaaSUserLinkEventHandler$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BaaSUserLinkEventHandler.a(baaSUserLinkEventHandler, (NPFError) obj);
                }
            });
        }
    }

    private static native void onLinkNintendoAccountCallback(long j, long j2, String str, String str2, String str3);

    @Override // com.nintendo.npf.sdk.user.BaaSUser.LinkNintendoAccountCallback
    public void onComplete(NPFError nPFError) {
        String string;
        String string2;
        BaaSUser baaSUserC = a.f844a.getNPFSDK().c();
        String string3 = null;
        try {
            string2 = NativeBridgeUtil.toJsonFromBaaSUser(baaSUserC).toString();
            try {
                string = baaSUserC.getNintendoAccount() != null ? NativeBridgeUtil.toJsonFromNintendoAccount(baaSUserC.getNintendoAccount()).toString() : null;
                if (nPFError != null) {
                    try {
                        string3 = NativeBridgeUtil.toJsonFromNPFError(nPFError).toString();
                    } catch (JSONException e) {
                        e = e;
                        e.printStackTrace();
                    }
                }
            } catch (JSONException e2) {
                e = e2;
                string = null;
            }
        } catch (JSONException e3) {
            e = e3;
            string = null;
            string2 = null;
        }
        onLinkNintendoAccountCallback(this.f843a, this.b, string2, string, string3);
    }

    public BaaSUserLinkEventHandler(long j, long j2) {
        this.f843a = j;
        this.b = j2;
    }
}
