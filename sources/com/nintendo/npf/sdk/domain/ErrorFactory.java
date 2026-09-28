package com.nintendo.npf.sdk.domain;

import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.google.api.client.http.HttpStatusCodes;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.core.s2;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ErrorFactory {
    public NPFError create_Analytics_DisabledUsingResettableId_6403() {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, 6403, "Resettable id is disabled");
    }

    public NPFError create_Analytics_UnavailableResettableId_6500(String str) {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, 6500, "Failed to get resettable id from server: " + str);
    }

    public NPFError create_BaasAccount_NotLoggedIn_401() {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, HttpStatusCodes.STATUS_CODE_UNAUTHORIZED, "User is not logged in");
    }

    public NPFError create_HttpClient_InvalidRequest(int i, String str) {
        if (i == 0) {
            return new NPFError(NPFError.ErrorType.NETWORK_ERROR, i, str);
        }
        NPFError.ErrorType errorType = NPFError.ErrorType.NPF_ERROR;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (s2.a(jSONObject, "code") && s2.a(jSONObject, MapperConstants.NPF_ERROR_FIELD_MESSAGE)) {
                    i = jSONObject.getInt("code");
                    str = jSONObject.getString(MapperConstants.NPF_ERROR_FIELD_MESSAGE);
                }
            } catch (JSONException unused) {
            }
        }
        return new NPFError(errorType, i, str);
    }

    public NPFError create_InvalidParameters_400() {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, 400, "Invalid parameters");
    }

    public NPFError create_LinkedAccount_AlreadyLinked_5403(String str) {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, 5403, String.format(Locale.US, "Already linked with %s", str));
    }

    public NPFError create_LinkedAccount_InvalidIdToken_5400(String str) {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, 5400, str);
    }

    public NPFError create_LinkedAccount_LinkToAnotherUser_5409(String str) {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, 5409, str);
    }

    public NPFError create_LinkedAccount_NotLinkedToAnyone_5200(String str) {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, 5200, str);
    }

    public NPFError create_Mapper_InvalidJson_422(JSONException jSONException) {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, HttpStatusCodes.STATUS_CODE_UNPROCESSABLE_ENTITY, jSONException.getMessage());
    }

    public NPFError create_NintendoAccount_AuthorizationCanceledClosedApp_Minus1() {
        return new NPFError(NPFError.ErrorType.USER_CANCEL, -1, "App is launched from authorization browser page after closing auth process");
    }

    public NPFError create_NintendoAccount_AuthorizationCantRunMultiply_Minus1() {
        return new NPFError(NPFError.ErrorType.USER_CANCEL, -1, "Nintendo authorization can't run multiply");
    }

    public NPFError create_NintendoAccount_AuthorizationRetryIllegalState() {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, HttpStatusCodes.STATUS_CODE_CONFLICT, "Illegal state was detected.");
    }

    public NPFError create_NintendoAccount_BrowserNotAvailable_403() {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, HttpStatusCodes.STATUS_CODE_FORBIDDEN, "Browser is not available.");
    }

    public NPFError create_NintendoAccount_InvalidNaToken_400(String str) {
        return new NPFError(NPFError.ErrorType.INVALID_NA_TOKEN, 400, str);
    }

    public NPFError create_NintendoAccount_NaEulaUpdate_Minus1() {
        return new NPFError(NPFError.ErrorType.NA_EULA_UPDATE, -1, "Needs to re-authorize to update EULA");
    }

    public NPFError create_NintendoAccount_NotAuthorized_4001() {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, 4001, "NintendoAccount is not authorized.");
    }

    public NPFError create_ProcessCancel_Minus1(String str) {
        return new NPFError(NPFError.ErrorType.PROCESS_CANCEL, -1, str);
    }

    public NPFError create_PromoCode_Exchanging_Minus1() {
        return new NPFError(NPFError.ErrorType.PROCESS_CANCEL, -1, "ExchangePromoCodes is already processing");
    }

    public NPFError create_PromoCode_PostPurchaseNetworkError_3053() {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, 3053, "Purchase completed, but a subsequent network error occurred.");
    }

    public NPFError create_Subscription_NoPurchaseFound_1010() {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, PointerIconCompat.TYPE_ALIAS, "No purchase found");
    }

    public NPFError create_Subscription_ProductNotAvailable_1009() {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, PointerIconCompat.TYPE_VERTICAL_TEXT, "Product details not found");
    }

    public NPFError create_UnknownError_9999(String str) {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, 9999, str);
    }

    public NPFError create_VirtualCurrency_InvalidProductInfo_0() {
        return new NPFError(NPFError.ErrorType.PROCESS_CANCEL, 0, "argument error");
    }

    public NPFError create_VirtualCurrency_MultiQuantityPurchase_2051() {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, 2051, "Multi-quantity purchase is not supported");
    }

    public NPFError create_VirtualCurrency_NoPurchaseFound_Minus1() {
        return new NPFError(NPFError.ErrorType.PROCESS_CANCEL, -1, "No purchase found");
    }

    public NPFError create_VirtualCurrency_NoPurchaseToRecoverOrRestore_404() {
        return new NPFError(NPFError.ErrorType.PROCESS_CANCEL, HttpStatusCodes.STATUS_CODE_NOT_FOUND, "No purchase to recover or restore");
    }

    public NPFError create_VirtualCurrency_PostPurchaseNetworkError_2053() {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, 2053, "Purchase completed, but a subsequent network error occurred");
    }

    public NPFError create_VirtualCurrency_ProductNotAvailable_402() {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, 402, "Requested product is not available for purchase");
    }

    public NPFError create_VirtualCurrency_PurchaseForbidden_403() {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, HttpStatusCodes.STATUS_CODE_FORBIDDEN, "The user is not allowed to purchase virtual currency");
    }

    public NPFError create_VirtualCurrency_Purchasing_Minus1() {
        return new NPFError(NPFError.ErrorType.PROCESS_CANCEL, -1, "Purchase is already processing");
    }

    public NPFError create_VirtualCurrency_Recovering_Minus1() {
        return new NPFError(NPFError.ErrorType.PROCESS_CANCEL, -1, "RecoverPurchases is already processing");
    }

    public NPFError create_VirtualCurrency_Restoring_Minus1() {
        return new NPFError(NPFError.ErrorType.PROCESS_CANCEL, -1, "RestorePurchases is already processing");
    }

    public NPFError create_VirtualCurrency_UnprocessedPurchaseFound_409() {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, HttpStatusCodes.STATUS_CODE_CONFLICT, "Unprocessed purchase found");
    }

    public NPFError create_VirtualCurrency_UnsupportedMarket_410() {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, 410, "Unsupported market");
    }

    public NPFError create_LinkedAccount_InvalidIdToken_5400() {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, 5400, "Invalid id token");
    }

    public NPFError create_Mapper_InvalidJson_422(String str) {
        return new NPFError(NPFError.ErrorType.NPF_ERROR, HttpStatusCodes.STATUS_CODE_UNPROCESSABLE_ENTITY, str);
    }
}
