package com.nintendo.npf.sdk.internal.impl.cpp;

import android.app.Activity;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.core.x4;
import com.nintendo.npf.sdk.internal.impl.NativeBridgeUtil;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.NintendoAccount;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class BaaSUserSwitchEventHandler implements BaaSUser.SwitchByNintendoAccountCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f847a;
    private long b;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final x4 f848a = x4.a.a();
    }

    public BaaSUserSwitchEventHandler() {
        this.f847a = -1L;
        this.b = -1L;
    }

    private static native void onSwitchBaaSUserCallback(long j, long j2, String str, String str2, String str3, String str4, String str5);

    public static void retryPendingSwitchByNintendoAccount2(long j, long j2, Activity activity) {
        a.f848a.getBaasUser().a(new BaaSUserSwitchEventHandler(j, j2));
    }

    public static void switchByNintendoAccount(long j, long j2, Activity activity, byte[] bArr) {
        x4 x4Var = a.f848a;
        x4Var.getBaasUser().a(x4Var.getNPFSDK().c(), activity, NintendoAccountEventHandler.parseScope(new String(bArr)), new BaaSUserSwitchEventHandler(j, j2));
    }

    public static void switchByNintendoAccount2(long j, long j2, Activity activity, byte[] bArr) {
        a.f848a.getBaasUser().a(activity, NintendoAccountEventHandler.parseScope(new String(bArr)), new BaaSUserSwitchEventHandler(j, j2));
    }

    @Override // com.nintendo.npf.sdk.user.BaaSUser.SwitchByNintendoAccountCallback
    public void onComplete(String str, String str2, NintendoAccount nintendoAccount, NPFError nPFError) {
        String string;
        String string2;
        if (nintendoAccount != null) {
            BaaSUserLinkEventHandler.c = nintendoAccount;
        }
        String string3 = null;
        try {
            string = NativeBridgeUtil.toJsonFromBaaSUser(a.f848a.getNPFSDK().c()).toString();
            if (nintendoAccount != null) {
                try {
                    string2 = NativeBridgeUtil.toJsonFromNintendoAccount(nintendoAccount).toString();
                } catch (JSONException e) {
                    e = e;
                    string2 = null;
                    e.printStackTrace();
                    onSwitchBaaSUserCallback(this.f847a, this.b, str, str2, string, string2, string3);
                }
            } else {
                string2 = null;
            }
            if (nPFError != null) {
                try {
                    string3 = NativeBridgeUtil.toJsonFromNPFError(nPFError).toString();
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                }
            }
        } catch (JSONException e3) {
            e = e3;
            string = null;
            string2 = null;
        }
        onSwitchBaaSUserCallback(this.f847a, this.b, str, str2, string, string2, string3);
    }

    public BaaSUserSwitchEventHandler(long j, long j2) {
        this.f847a = j;
        this.b = j2;
    }
}
