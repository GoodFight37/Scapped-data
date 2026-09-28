package com.nintendo.npf.sdk.internal.impl.cpp;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.core.x4;
import com.nintendo.npf.sdk.internal.impl.NativeBridgeUtil;
import com.nintendo.npf.sdk.user.LinkToBaasUserCallback;
import com.nintendo.npf.sdk.user.LinkedAccount;
import com.nintendo.npf.sdk.user.LinkedAccountService;
import com.nintendo.npf.sdk.user.SwitchBaasUserCallback;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class LinkedAccountEventHandler {

    class a implements LinkToBaasUserCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f849a;
        final /* synthetic */ long b;

        a(long j, long j2) {
            this.f849a = j;
            this.b = j2;
        }

        @Override // com.nintendo.npf.sdk.user.LinkToBaasUserCallback
        public void onComplete(NPFError nPFError) {
            String string;
            String string2 = null;
            try {
                string = NativeBridgeUtil.toJsonFromBaaSUser(c.f851a.getNPFSDK().c()).toString();
                if (nPFError != null) {
                    try {
                        string2 = NativeBridgeUtil.toJsonFromNPFError(nPFError).toString();
                    } catch (JSONException e) {
                        e = e;
                        e.printStackTrace();
                    }
                }
            } catch (JSONException e2) {
                e = e2;
                string = null;
            }
            LinkedAccountEventHandler.onLinkToBaaSUserCallback(this.f849a, this.b, string, string2);
        }
    }

    class b implements SwitchBaasUserCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f850a;
        final /* synthetic */ long b;

        b(long j, long j2) {
            this.f850a = j;
            this.b = j2;
        }

        @Override // com.nintendo.npf.sdk.user.SwitchBaasUserCallback
        public void onComplete(String str, String str2, LinkedAccount linkedAccount, NPFError nPFError) {
            String string;
            String string2;
            String string3;
            String string4 = null;
            try {
                x4 x4Var = c.f851a;
                string = NativeBridgeUtil.toJsonFromBaaSUser(x4Var.getNPFSDK().c()).toString();
                try {
                    string2 = NativeBridgeUtil.toJsonFromNintendoAccount(x4Var.getNPFSDK().d()).toString();
                    if (linkedAccount != null) {
                        try {
                            string3 = NativeBridgeUtil.toJsonFromLinkedAccount(linkedAccount).toString();
                        } catch (JSONException e) {
                            e = e;
                            string3 = null;
                            e.printStackTrace();
                            LinkedAccountEventHandler.onSwitchBaaSUserCallback(this.f850a, this.b, str, str2, string, string2, string3, string4);
                        }
                    } else {
                        string3 = null;
                    }
                    if (nPFError != null) {
                        try {
                            string4 = NativeBridgeUtil.toJsonFromNPFError(nPFError).toString();
                        } catch (JSONException e2) {
                            e = e2;
                            e.printStackTrace();
                        }
                    }
                } catch (JSONException e3) {
                    e = e3;
                    string2 = null;
                    string3 = string2;
                    e.printStackTrace();
                    LinkedAccountEventHandler.onSwitchBaaSUserCallback(this.f850a, this.b, str, str2, string, string2, string3, string4);
                }
            } catch (JSONException e4) {
                e = e4;
                string = null;
                string2 = null;
            }
            LinkedAccountEventHandler.onSwitchBaaSUserCallback(this.f850a, this.b, str, str2, string, string2, string3, string4);
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final x4 f851a = x4.a.a();
    }

    public static void linkToBaasUser(long j, long j2, String str, String str2) {
        a(str).linkToBaasUser(str2, new a(j, j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onLinkToBaaSUserCallback(long j, long j2, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onSwitchBaaSUserCallback(long j, long j2, String str, String str2, String str3, String str4, String str5, String str6);

    public static void switchBaasUser(long j, long j2, String str, String str2) {
        a(str).switchBaasUser(str2, new b(j, j2));
    }

    private static LinkedAccountService a(String str) {
        str.getClass();
        str.hashCode();
        switch (str) {
            case "appleAccount":
                return c.f851a.getLinkedAppleAccountService();
            case "googleAccount":
                return c.f851a.getLinkedGoogleAccountService();
            case "facebookAccount":
                return c.f851a.getLinkedFacebookAccountService();
            default:
                throw new IllegalStateException("Illegal IDP from Cpp bridge");
        }
    }
}
