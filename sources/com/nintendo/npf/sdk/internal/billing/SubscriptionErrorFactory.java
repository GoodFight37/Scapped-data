package com.nintendo.npf.sdk.internal.billing;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import com.android.billingclient.api.BillingResult;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdkbilling.a;
import com.nintendo.npf.sdkbilling.v;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/nintendo/npf/sdk/internal/billing/SubscriptionErrorFactory;", "Lcom/nintendo/npf/sdk/internal/billing/GoogleBillingErrorFactory;", "<init>", "()V", "Lcom/android/billingclient/api/BillingResult;", "billingResult", "Lcom/nintendo/npf/sdk/NPFError;", "createBillingError", "(Lcom/android/billingclient/api/BillingResult;)Lcom/nintendo/npf/sdk/NPFError;", "Companion", "com/nintendo/npf/sdkbilling/v", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SubscriptionErrorFactory implements GoogleBillingErrorFactory {
    public static final v Companion = new v();

    @Override // com.nintendo.npf.sdk.internal.billing.GoogleBillingErrorFactory
    public NPFError createBillingError(BillingResult billingResult) {
        NPFError.ErrorType errorType;
        int i;
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        String debugMessage = billingResult.getDebugMessage();
        NPFError.OriginalErrorType originalErrorType = NPFError.OriginalErrorType.GOOGLE_PLAY_BILLING_LIBRARY_ERROR;
        String strA = a.a(billingResult);
        int responseCode = billingResult.getResponseCode();
        String str = null;
        if (responseCode != 12) {
            switch (responseCode) {
                case -2:
                    errorType = NPFError.ErrorType.NPF_ERROR;
                    i = 1000;
                    if (TextUtils.isEmpty(debugMessage)) {
                        debugMessage = "Feature not supported";
                    }
                    break;
                case -1:
                    errorType = NPFError.ErrorType.NPF_ERROR;
                    boolean zIsEmpty = TextUtils.isEmpty(debugMessage);
                    i = InputDeviceCompat.SOURCE_GAMEPAD;
                    if (zIsEmpty) {
                        debugMessage = "Service disconnected";
                    }
                    break;
                case 0:
                    return null;
                case 1:
                    errorType = NPFError.ErrorType.USER_CANCEL;
                    i = 1004;
                    if (TextUtils.isEmpty(debugMessage)) {
                        debugMessage = "User canceled";
                    }
                    break;
                case 2:
                    errorType = NPFError.ErrorType.NPF_ERROR;
                    i = 1050;
                    if (TextUtils.isEmpty(debugMessage)) {
                        debugMessage = "Service unavailable";
                    }
                    break;
                case 3:
                    errorType = NPFError.ErrorType.NPF_ERROR;
                    i = 1026;
                    if (TextUtils.isEmpty(debugMessage)) {
                        debugMessage = "Billing unavailable";
                    }
                    break;
                case 4:
                    errorType = NPFError.ErrorType.NPF_ERROR;
                    boolean zIsEmpty2 = TextUtils.isEmpty(debugMessage);
                    i = PointerIconCompat.TYPE_VERTICAL_TEXT;
                    if (zIsEmpty2) {
                        debugMessage = "Item unavailable";
                    }
                    break;
                case 5:
                    errorType = NPFError.ErrorType.NPF_ERROR;
                    i = 1007;
                    if (TextUtils.isEmpty(debugMessage)) {
                        debugMessage = "Developer error";
                    }
                    break;
                case 6:
                    errorType = NPFError.ErrorType.NPF_ERROR;
                    if (TextUtils.isEmpty(debugMessage)) {
                        debugMessage = "Error";
                    }
                    i = 1010;
                    break;
                case 7:
                    errorType = NPFError.ErrorType.NPF_ERROR;
                    boolean zIsEmpty3 = TextUtils.isEmpty(debugMessage);
                    i = PointerIconCompat.TYPE_TEXT;
                    if (zIsEmpty3) {
                        debugMessage = "Item already owned";
                    }
                    break;
                case 8:
                    errorType = NPFError.ErrorType.NPF_ERROR;
                    i = 1027;
                    if (TextUtils.isEmpty(debugMessage)) {
                        debugMessage = "Item not owned";
                    }
                    break;
                default:
                    errorType = NPFError.ErrorType.NPF_ERROR;
                    if (TextUtils.isEmpty(debugMessage)) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        debugMessage = String.format(Locale.US, "Unknown error with code %s", Arrays.copyOf(new Object[]{Integer.valueOf(billingResult.getResponseCode())}, 1));
                        Intrinsics.checkNotNullExpressionValue(debugMessage, "format(locale, format, *args)");
                    }
                    i = 1010;
                    break;
            }
        } else {
            errorType = NPFError.ErrorType.NETWORK_ERROR;
            i = 0;
            if (TextUtils.isEmpty(debugMessage)) {
                debugMessage = "Network error";
            }
        }
        NPFError.ErrorType errorType2 = errorType;
        int onPurchasesUpdatedSubResponseCode = billingResult.getOnPurchasesUpdatedSubResponseCode();
        if (onPurchasesUpdatedSubResponseCode != 0) {
            if (onPurchasesUpdatedSubResponseCode == 1) {
                str = "Payment declined due to insufficient funds";
            } else if (onPurchasesUpdatedSubResponseCode == 2) {
                str = "User ineligible for purchase";
            }
        }
        if (str == null) {
            str = debugMessage;
        } else if (debugMessage != null && !StringsKt.isBlank(debugMessage)) {
            debugMessage = debugMessage + ' ' + str;
            str = debugMessage;
        }
        SDKLog.e("SubscriptionErrorFactory", "response=" + billingResult.getResponseCode() + ", subResponse=" + onPurchasesUpdatedSubResponseCode + ", message=" + str);
        return new NPFError(errorType2, i, str, originalErrorType, strA);
    }
}
