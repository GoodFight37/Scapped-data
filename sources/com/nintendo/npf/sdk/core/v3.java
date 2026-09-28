package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.Gender;
import com.nintendo.npf.sdk.user.NintendoAccount;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v3 {
    public static final void a(NintendoAccount nintendoAccount, NintendoAccount nintendoAccount2) {
        Intrinsics.checkNotNullParameter(nintendoAccount, "<this>");
        if (nintendoAccount2 != null) {
            nintendoAccount.setNintendoAccountId$NPFSDK_release(nintendoAccount2.getNintendoAccountId());
            nintendoAccount.setType$NPFSDK_release(nintendoAccount2.getType());
            nintendoAccount.setNickname$NPFSDK_release(nintendoAccount2.getNickname());
            nintendoAccount.setGender$NPFSDK_release(nintendoAccount2.getGender());
            nintendoAccount.setLanguage$NPFSDK_release(nintendoAccount2.getLanguage());
            nintendoAccount.setCountry$NPFSDK_release(nintendoAccount2.getCountry());
            nintendoAccount.setRegion$NPFSDK_release(nintendoAccount2.getRegion());
            nintendoAccount.setTimezone$NPFSDK_release(nintendoAccount2.getTimezone());
            nintendoAccount.setBirthdayYear$NPFSDK_release(nintendoAccount2.getBirthdayYear());
            nintendoAccount.setBirthdayMonth$NPFSDK_release(nintendoAccount2.getBirthdayMonth());
            nintendoAccount.setBirthdayDay$NPFSDK_release(nintendoAccount2.getBirthdayDay());
            nintendoAccount.setEmail$NPFSDK_release(nintendoAccount2.getEmail());
            nintendoAccount.setNintendoNetworkId$NPFSDK_release(nintendoAccount2.getNintendoNetworkId());
            nintendoAccount.setMii$NPFSDK_release(nintendoAccount2.getMii());
            nintendoAccount.setScreenName$NPFSDK_release(nintendoAccount2.getScreenName());
            nintendoAccount.setIdToken$NPFSDK_release(nintendoAccount2.getIdToken());
            nintendoAccount.setAccessToken$NPFSDK_release(nintendoAccount2.getAccessToken());
            nintendoAccount.expiresTime = nintendoAccount2.expiresTime;
            nintendoAccount.sessionToken = nintendoAccount2.sessionToken;
            nintendoAccount.setIconUri$NPFSDK_release(nintendoAccount2.getIconUri());
        }
        SDKLog.d("NintendoAccount", "NA expiresTime: " + nintendoAccount.expiresTime);
    }

    public static final void b(NintendoAccount nintendoAccount) {
        Intrinsics.checkNotNullParameter(nintendoAccount, "<this>");
        nintendoAccount.setNintendoAccountId$NPFSDK_release(null);
        nintendoAccount.setType$NPFSDK_release(NintendoAccount.Type.UNKNOWN);
        nintendoAccount.setNickname$NPFSDK_release(null);
        nintendoAccount.setGender$NPFSDK_release(Gender.UNKNOWN);
        nintendoAccount.setLanguage$NPFSDK_release(null);
        nintendoAccount.setCountry$NPFSDK_release(null);
        nintendoAccount.setRegion$NPFSDK_release(null);
        nintendoAccount.setTimezone$NPFSDK_release(null);
        nintendoAccount.setBirthdayYear$NPFSDK_release(0);
        nintendoAccount.setBirthdayMonth$NPFSDK_release(0);
        nintendoAccount.setBirthdayDay$NPFSDK_release(0);
        nintendoAccount.setEmail$NPFSDK_release(null);
        nintendoAccount.setNintendoNetworkId$NPFSDK_release(null);
        nintendoAccount.setMii$NPFSDK_release(null);
        nintendoAccount.setScreenName$NPFSDK_release("");
        nintendoAccount.setIdToken$NPFSDK_release(null);
        nintendoAccount.setAccessToken$NPFSDK_release(null);
        nintendoAccount.sessionToken = null;
        nintendoAccount.setIconUri$NPFSDK_release(null);
    }

    public static final boolean a(NintendoAccount nintendoAccount) {
        Intrinsics.checkNotNullParameter(nintendoAccount, "<this>");
        String nintendoAccountId = nintendoAccount.getNintendoAccountId();
        return !(nintendoAccountId == null || nintendoAccountId.length() == 0);
    }
}
