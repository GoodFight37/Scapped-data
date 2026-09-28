package com.nintendo.npf.sdkbilling;

import android.text.TextUtils;
import com.android.billingclient.api.BillingResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static final String a(BillingResult billingResult) {
        String str;
        Intrinsics.checkNotNullParameter(billingResult, "<this>");
        int responseCode = billingResult.getResponseCode();
        if (responseCode != 12) {
            switch (responseCode) {
                case -2:
                    str = "responseCode: FEATURE_NOT_SUPPORTED";
                    break;
                case -1:
                    str = "responseCode: SERVICE_DISCONNECTED";
                    break;
                case 0:
                    str = "responseCode: OK";
                    break;
                case 1:
                    str = "responseCode: USER_CANCELED";
                    break;
                case 2:
                    str = "responseCode: SERVICE_UNAVAILABLE";
                    break;
                case 3:
                    str = "responseCode: BILLING_UNAVAILABLE";
                    break;
                case 4:
                    str = "responseCode: ITEM_UNAVAILABLE";
                    break;
                case 5:
                    str = "responseCode: DEVELOPER_ERROR";
                    break;
                case 6:
                    str = "responseCode: ERROR";
                    break;
                case 7:
                    str = "responseCode: ITEM_ALREADY_OWNED";
                    break;
                case 8:
                    str = "responseCode: ITEM_NOT_OWNED";
                    break;
                default:
                    str = "Unknown responseCode: " + billingResult.getResponseCode();
                    break;
            }
        } else {
            str = "responseCode: NETWORK_ERROR";
        }
        if (TextUtils.isEmpty(billingResult.getDebugMessage())) {
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("responseCodeText");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("responseCodeText");
            str = null;
        }
        return sb.append(str).append(", debugMessage: ").append(billingResult.getDebugMessage()).toString();
    }
}
