package com.nintendo.npf.sdk.core;

import android.text.TextUtils;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.Gender;
import com.nintendo.npf.sdk.user.NintendoAccount;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h0 {
    public static final void a(BaaSUser baaSUser, BaaSUser next, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(baaSUser, "<this>");
        Intrinsics.checkNotNullParameter(next, "next");
        baaSUser.setUserId$NPFSDK_release(next.getUserId());
        baaSUser.setNickname(next.getNickname());
        baaSUser.setCountry(next.getCountry());
        baaSUser.setGender(next.getGender());
        baaSUser.setBirthdayDay(next.getBirthdayDay());
        baaSUser.setBirthdayMonth(next.getBirthdayMonth());
        baaSUser.setBirthdayYear(next.getBirthdayYear());
        baaSUser.setPersonalAnalytics$NPFSDK_release(next.getPersonalAnalytics());
        baaSUser.setPersonalNotification$NPFSDK_release(next.getPersonalNotification());
        baaSUser.setPersonalAnalyticsUpdatedAt$NPFSDK_release(next.getPersonalAnalyticsUpdatedAt());
        baaSUser.setPersonalNotificationUpdatedAt$NPFSDK_release(next.getPersonalNotificationUpdatedAt());
        baaSUser.setInquiryStatus$NPFSDK_release(next.getInquiryStatus());
        baaSUser.setCreatedAt$NPFSDK_release(next.getCreatedAt());
        baaSUser.setLinkedAccounts$NPFSDK_release(next.getLinkedAccounts$NPFSDK_release());
        baaSUser.setNintendoAccount$NPFSDK_release(next.getNintendoAccount());
        if (z) {
            String deviceAccount = next.getDeviceAccount();
            String devicePassword = next.getDevicePassword();
            String accessToken = next.getAccessToken();
            String str = accessToken == null ? "" : accessToken;
            String idToken = next.getIdToken();
            a(baaSUser, deviceAccount, devicePassword, str, idToken == null ? "" : idToken, next.getExpiresTime(), z2);
        }
    }

    public static final boolean b(BaaSUser baaSUser) {
        Intrinsics.checkNotNullParameter(baaSUser, "<this>");
        return !TextUtils.isEmpty(baaSUser.getDeviceAccount());
    }

    public static final boolean c(BaaSUser baaSUser) {
        Intrinsics.checkNotNullParameter(baaSUser, "<this>");
        return !TextUtils.isEmpty(baaSUser.getUserId());
    }

    public static final void d(BaaSUser baaSUser) {
        Intrinsics.checkNotNullParameter(baaSUser, "<this>");
        baaSUser.setUserId$NPFSDK_release("");
        baaSUser.setIdToken$NPFSDK_release(null);
        baaSUser.setAccessToken$NPFSDK_release(null);
        baaSUser.setDeviceAccount$NPFSDK_release(null);
        baaSUser.setDevicePassword$NPFSDK_release(null);
        baaSUser.setNickname(null);
        baaSUser.setCountry(null);
        baaSUser.setGender(Gender.UNKNOWN);
        baaSUser.setBirthdayYear(0);
        baaSUser.setBirthdayMonth(0);
        baaSUser.setBirthdayDay(0);
        baaSUser.setInquiryStatus$NPFSDK_release(null);
        baaSUser.setNintendoAccount$NPFSDK_release(null);
        baaSUser.setCreatedAt$NPFSDK_release(0L);
        baaSUser.setLinkedAccounts$NPFSDK_release(new HashMap());
        baaSUser.setPersonalAnalytics$NPFSDK_release(false);
        baaSUser.setPersonalNotification$NPFSDK_release(false);
        baaSUser.setPersonalAnalyticsUpdatedAt$NPFSDK_release(0L);
        baaSUser.setPersonalNotificationUpdatedAt$NPFSDK_release(0L);
    }

    public static final void a(BaaSUser baaSUser, String str, String str2, String accessToken, String idToken, long j, boolean z) {
        Intrinsics.checkNotNullParameter(baaSUser, "<this>");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(idToken, "idToken");
        baaSUser.setDeviceAccount$NPFSDK_release(str);
        if (z) {
            baaSUser.setDevicePassword$NPFSDK_release(str2);
        }
        baaSUser.setAccessToken$NPFSDK_release(accessToken);
        baaSUser.setIdToken$NPFSDK_release(idToken);
        baaSUser.setExpiresTime$NPFSDK_release(j);
    }

    public static final Map a(BaaSUser baaSUser) {
        Intrinsics.checkNotNullParameter(baaSUser, "<this>");
        return baaSUser.getLinkedAccounts$NPFSDK_release();
    }

    public static final void a(BaaSUser baaSUser, NintendoAccount nintendoAccount) {
        Intrinsics.checkNotNullParameter(baaSUser, "<this>");
        baaSUser.setNintendoAccount$NPFSDK_release(nintendoAccount);
    }
}
