package com.nintendo.npf.sdkbilling;

import android.text.TextUtils;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.internal.billing.GoogleBillingErrorFactory;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements GoogleBillingErrorFactory {
    @Override // com.nintendo.npf.sdk.internal.billing.GoogleBillingErrorFactory
    public final NPFError createBillingError(BillingResult billingResult) {
        NPFError.ErrorType errorType;
        int i;
        NPFError.ErrorType errorType2;
        String str;
        int i2;
        NPFError.ErrorType errorType3;
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        String debugMessage = billingResult.getDebugMessage();
        Intrinsics.checkNotNullExpressionValue(debugMessage, "billingResult.debugMessage");
        NPFError.OriginalErrorType originalErrorType = NPFError.OriginalErrorType.GOOGLE_PLAY_BILLING_LIBRARY_ERROR;
        String strA = a.a(billingResult);
        int responseCode = billingResult.getResponseCode();
        if (responseCode != 12) {
            i = 3008;
            i2 = 3000;
            switch (responseCode) {
                case -2:
                    errorType3 = NPFError.ErrorType.NPF_ERROR;
                    if (TextUtils.isEmpty(debugMessage)) {
                        debugMessage = "Feature not supported";
                    }
                    errorType2 = errorType3;
                    str = debugMessage;
                    SDKLog.e("u", str);
                    return new NPFError(errorType2, i2, str, originalErrorType, strA);
                case -1:
                    errorType = NPFError.ErrorType.NPF_ERROR;
                    i = 3025;
                    if (TextUtils.isEmpty(debugMessage)) {
                        debugMessage = "Service disconnected";
                    }
                    break;
                case 0:
                    return null;
                case 1:
                    errorType = NPFError.ErrorType.USER_CANCEL;
                    boolean zIsEmpty = TextUtils.isEmpty(debugMessage);
                    i = AuthApiStatusCodes.AUTH_TOKEN_ERROR;
                    if (zIsEmpty) {
                        debugMessage = "User canceled";
                    }
                    break;
                case 2:
                    errorType = NPFError.ErrorType.NPF_ERROR;
                    i = 3050;
                    if (TextUtils.isEmpty(debugMessage)) {
                        debugMessage = "Service unavailable";
                    }
                    break;
                case 3:
                    errorType3 = NPFError.ErrorType.NPF_ERROR;
                    if (TextUtils.isEmpty(debugMessage)) {
                        debugMessage = "Billing unavailable";
                    }
                    errorType2 = errorType3;
                    str = debugMessage;
                    SDKLog.e("u", str);
                    return new NPFError(errorType2, i2, str, originalErrorType, strA);
                case 4:
                    errorType = NPFError.ErrorType.NPF_ERROR;
                    i = 3009;
                    if (TextUtils.isEmpty(debugMessage)) {
                        debugMessage = "Item unavailable";
                    }
                    break;
                case 5:
                    errorType = NPFError.ErrorType.NPF_ERROR;
                    i = 3007;
                    if (TextUtils.isEmpty(debugMessage)) {
                        debugMessage = "Developer error";
                    }
                    break;
                case 6:
                    NPFError.ErrorType errorType4 = NPFError.ErrorType.NPF_ERROR;
                    if (TextUtils.isEmpty(debugMessage)) {
                        debugMessage = "Error";
                    }
                    str = debugMessage;
                    i2 = 3010;
                    errorType2 = errorType4;
                    SDKLog.e("u", str);
                    return new NPFError(errorType2, i2, str, originalErrorType, strA);
                case 7:
                    errorType = NPFError.ErrorType.NPF_ERROR;
                    if (TextUtils.isEmpty(debugMessage)) {
                        debugMessage = "Item already owned";
                    }
                    break;
                case 8:
                    errorType = NPFError.ErrorType.NPF_ERROR;
                    if (TextUtils.isEmpty(debugMessage)) {
                        debugMessage = "Item not owned";
                    }
                    break;
                default:
                    NPFError.ErrorType errorType5 = NPFError.ErrorType.NPF_ERROR;
                    if (TextUtils.isEmpty(debugMessage)) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        debugMessage = String.format(Locale.US, "Unknown error with code %s", Arrays.copyOf(new Object[]{Integer.valueOf(billingResult.getResponseCode())}, 1));
                        Intrinsics.checkNotNullExpressionValue(debugMessage, "format(locale, format, *args)");
                    }
                    str = debugMessage;
                    i2 = 3010;
                    errorType2 = errorType5;
                    SDKLog.e("u", str);
                    return new NPFError(errorType2, i2, str, originalErrorType, strA);
            }
        } else {
            errorType = NPFError.ErrorType.NETWORK_ERROR;
            i = 0;
            if (TextUtils.isEmpty(debugMessage)) {
                debugMessage = "Network error";
            }
        }
        errorType2 = errorType;
        str = debugMessage;
        i2 = i;
        SDKLog.e("u", str);
        return new NPFError(errorType2, i2, str, originalErrorType, strA);
    }
}
