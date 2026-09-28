package com.nintendo.npf.sdk.internal.impl;

import android.util.Base64;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.audit.ProfanityWord;
import com.nintendo.npf.sdk.core.h0;
import com.nintendo.npf.sdk.core.x4;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.infrastructure.mapper.SubscriptionProductMapper;
import com.nintendo.npf.sdk.infrastructure.mapper.SubscriptionPurchaseMapper;
import com.nintendo.npf.sdk.inquiry.InquiryStatus;
import com.nintendo.npf.sdk.mynintendo.MissionStatus;
import com.nintendo.npf.sdk.promo.PromoCodeBundle;
import com.nintendo.npf.sdk.subscription.SubscriptionProduct;
import com.nintendo.npf.sdk.subscription.SubscriptionPurchase;
import com.nintendo.npf.sdk.subscription.SubscriptionTransaction;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.LinkedAccount;
import com.nintendo.npf.sdk.user.Mii;
import com.nintendo.npf.sdk.user.NintendoAccount;
import com.nintendo.npf.sdk.user.OtherUser;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyBundle;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyPurchaseSummaryBySku;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyPurchasedSummary;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyTransaction;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyWallet;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NativeBridgeUtil {

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final x4 f775a = x4.a.a();
    }

    private static JSONObject a(Map map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            VirtualCurrencyPurchaseSummaryBySku virtualCurrencyPurchaseSummaryBySku = (VirtualCurrencyPurchaseSummaryBySku) entry.getValue();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("sku", virtualCurrencyPurchaseSummaryBySku.getSku());
            jSONObject2.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_COUNT, virtualCurrencyPurchaseSummaryBySku.getCount());
            jSONObject2.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_BRIDGE_PURCHASED_VC, virtualCurrencyPurchaseSummaryBySku.getPurchasedAmount());
            jSONObject2.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_BRIDGE_PURCHASED_USD, virtualCurrencyPurchaseSummaryBySku.getPurchasedUsd());
            jSONObject.put((String) entry.getKey(), jSONObject2);
        }
        return jSONObject;
    }

    public static String getMarket() {
        return NPFSDK.getMarket();
    }

    public static String getRuntimeOSVersion() {
        return "Android " + a.f775a.getCapabilities().getOSVersion();
    }

    public static String getTargetedOS() {
        return "Android";
    }

    public static int getTimeZoneOffsetMin() {
        TimeZone timeZone = new GregorianCalendar().getTimeZone();
        return ((timeZone.getRawOffset() + timeZone.getDSTSavings()) / 1000) / 60;
    }

    public static JSONObject parseJsonString(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    public static JSONObject toJSONFromMissionStatus(MissionStatus missionStatus) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("completed", missionStatus.isCompleted());
        jSONObject.put("currentSteps", missionStatus.getCurrentSteps() != null ? missionStatus.getCurrentSteps() : JSONObject.NULL);
        jSONObject.put("limited", missionStatus.getLimited());
        jSONObject.put("limitEndsAt", missionStatus.getLimitEndsAt());
        jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_DETAIL, missionStatus.getDetail());
        jSONObject.put("missionId", missionStatus.getMissionId());
        jSONObject.put("missionKey", missionStatus.getMissionKey());
        jSONObject.put("pointAmount", missionStatus.getPointAmount());
        jSONObject.put("timesCompleted", missionStatus.getTimesCompleted() != null ? missionStatus.getTimesCompleted() : JSONObject.NULL);
        jSONObject.put("title", missionStatus.getTitle());
        jSONObject.put("totalSteps", missionStatus.getTotalSteps());
        if (missionStatus.getAvailableGifts() == null) {
            jSONObject.put("availableGifts", JSONObject.NULL);
            return jSONObject;
        }
        Map<String, Long> availableGifts = missionStatus.getAvailableGifts();
        JSONObject jSONObject2 = new JSONObject();
        for (String str : availableGifts.keySet()) {
            jSONObject2.put(str, availableGifts.get(str));
        }
        jSONObject.put("availableGifts", jSONObject2);
        return jSONObject;
    }

    public static JSONObject toJsonFromBaaSUser(BaaSUser baaSUser) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("userId", baaSUser.getUserId());
        jSONObject.put("idToken", baaSUser.getIdToken() != null ? baaSUser.getIdToken() : JSONObject.NULL);
        jSONObject.put("accessToken", baaSUser.getAccessToken() != null ? baaSUser.getAccessToken() : JSONObject.NULL);
        jSONObject.put("deviceAccount", baaSUser.getDeviceAccount() != null ? baaSUser.getDeviceAccount() : JSONObject.NULL);
        jSONObject.put("devicePassword", baaSUser.getDevicePassword() != null ? baaSUser.getDevicePassword() : JSONObject.NULL);
        jSONObject.put("nickname", baaSUser.getNickname() != null ? baaSUser.getNickname() : JSONObject.NULL);
        jSONObject.put("country", baaSUser.getCountry() != null ? baaSUser.getCountry() : JSONObject.NULL);
        jSONObject.put("gender", baaSUser.getGender().toString().toLowerCase(Locale.US));
        jSONObject.put("birthdayYear", baaSUser.getBirthdayYear());
        jSONObject.put("birthdayMonth", baaSUser.getBirthdayMonth());
        jSONObject.put("birthdayDay", baaSUser.getBirthdayDay());
        jSONObject.put("hasUnreadCsComment", baaSUser.getInquiryStatus() != null ? Boolean.valueOf(baaSUser.getInquiryStatus().isHavingUnreadComments()) : JSONObject.NULL);
        jSONObject.put("personalAnalytics", baaSUser.getPersonalAnalytics());
        jSONObject.put("personalNotification", baaSUser.getPersonalNotification());
        jSONObject.put("createdAt", baaSUser.getCreatedAt());
        jSONObject.put("nintendoAccount", baaSUser.getNintendoAccount() != null ? toJsonFromNintendoAccount(baaSUser.getNintendoAccount()) : JSONObject.NULL);
        jSONObject.put("linkedAccounts", toJsonFromLinkedAccounts(h0.a(baaSUser)));
        return jSONObject;
    }

    public static JSONObject toJsonFromInquiryStatus(InquiryStatus inquiryStatus) throws JSONException {
        if (inquiryStatus == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("hasUnreadCsComment", inquiryStatus.isHavingUnreadComments());
        return jSONObject;
    }

    public static JSONObject toJsonFromLinkedAccount(LinkedAccount linkedAccount) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("providerId", linkedAccount.getProviderId());
        jSONObject.put("federatedId", linkedAccount.getFederatedId());
        return jSONObject;
    }

    public static JSONObject toJsonFromLinkedAccounts(Map<String, LinkedAccount> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, LinkedAccount> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), toJsonFromLinkedAccount(entry.getValue()));
        }
        return jSONObject;
    }

    public static JSONObject toJsonFromMii(Mii mii) throws JSONException {
        if (mii == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("imageUriTemplate", mii.getUrlTemplate());
        jSONObject.put("miiId", mii.getMiiId());
        if (mii.getCoreData() != null) {
            jSONObject.put("coreData", Base64.encodeToString(mii.getCoreData(), 2));
        } else {
            jSONObject.put("coreData", JSONObject.NULL);
        }
        if (mii.getStoreData() != null) {
            jSONObject.put("storeData", Base64.encodeToString(mii.getStoreData(), 2));
        } else {
            jSONObject.put("storeData", JSONObject.NULL);
        }
        jSONObject.put("imageOrigin", mii.getImageOrigin());
        jSONObject.put("etag", mii.getEtag());
        jSONObject.put("favoriteColor", mii.getFavoriteColor().toString().toLowerCase(Locale.US));
        return jSONObject;
    }

    public static JSONArray toJsonFromMissionStatuses(List<MissionStatus> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<MissionStatus> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(toJSONFromMissionStatus(it.next()));
        }
        return jSONArray;
    }

    public static JSONObject toJsonFromNPFError(NPFError nPFError) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorType", nPFError.getErrorType().name());
        jSONObject.put("errorCode", nPFError.getErrorCode());
        jSONObject.put("errorMessage", nPFError.getErrorMessage() != null ? nPFError.getErrorMessage() : JSONObject.NULL);
        jSONObject.put("originalErrorType", nPFError.getOriginalErrorType().name());
        jSONObject.put("originalErrorMessage", nPFError.getOriginalErrorMessage());
        return jSONObject;
    }

    public static JSONObject toJsonFromNintendoAccount(NintendoAccount nintendoAccount) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("nintendoAccountId", nintendoAccount.getNintendoAccountId());
        String string = nintendoAccount.getType().toString();
        Locale locale = Locale.US;
        jSONObject.put("type", string.toLowerCase(locale));
        jSONObject.put("nickname", nintendoAccount.getNickname() != null ? nintendoAccount.getNickname() : JSONObject.NULL);
        jSONObject.put("country", nintendoAccount.getCountry() != null ? nintendoAccount.getCountry() : JSONObject.NULL);
        jSONObject.put("region", nintendoAccount.getRegion() != null ? nintendoAccount.getRegion() : JSONObject.NULL);
        jSONObject.put("language", nintendoAccount.getLanguage() != null ? nintendoAccount.getLanguage() : JSONObject.NULL);
        jSONObject.put("timezone", nintendoAccount.getTimezone() != null ? nintendoAccount.getTimezone() : JSONObject.NULL);
        jSONObject.put("gender", nintendoAccount.getGender() != null ? nintendoAccount.getGender().toString().toLowerCase(locale) : JSONObject.NULL);
        jSONObject.put("birthdayYear", nintendoAccount.getBirthdayYear() != null ? nintendoAccount.getBirthdayYear() : JSONObject.NULL);
        jSONObject.put("birthdayMonth", nintendoAccount.getBirthdayMonth() != null ? nintendoAccount.getBirthdayMonth() : JSONObject.NULL);
        jSONObject.put("birthdayDay", nintendoAccount.getBirthdayDay() != null ? nintendoAccount.getBirthdayDay() : JSONObject.NULL);
        jSONObject.put("email", nintendoAccount.getEmail() != null ? nintendoAccount.getEmail() : JSONObject.NULL);
        jSONObject.put("nintendoNetworkId", nintendoAccount.getNintendoNetworkId() != null ? nintendoAccount.getNintendoNetworkId() : JSONObject.NULL);
        jSONObject.put("mii", nintendoAccount.getMii() != null ? toJsonFromMii(nintendoAccount.getMii()) : JSONObject.NULL);
        jSONObject.put("accessToken", nintendoAccount.getAccessToken() != null ? nintendoAccount.getAccessToken() : JSONObject.NULL);
        jSONObject.put("idToken", nintendoAccount.getIdToken() != null ? nintendoAccount.getIdToken() : JSONObject.NULL);
        return jSONObject;
    }

    public static JSONArray toJsonFromOtherUsers(List<OtherUser> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (OtherUser otherUser : list) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("userId", otherUser.getUserId());
            jSONObject.put("nickname", otherUser.getNickname() != null ? otherUser.getNickname() : JSONObject.NULL);
            jSONObject.put("nintendoAccountNickname", otherUser.getNintendoAccountNickname() != null ? otherUser.getNintendoAccountNickname() : JSONObject.NULL);
            jSONObject.put("nintendoAccountMii", otherUser.getNintendoAccountMii() != null ? toJsonFromMii(otherUser.getNintendoAccountMii()) : JSONObject.NULL);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static JSONArray toJsonFromProfanityWords(List<ProfanityWord> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (ProfanityWord profanityWord : list) {
            JSONObject jSONObject = new JSONObject();
            if (profanityWord.getDictionaryType() == ProfanityWord.ProfanityDictionaryType.NICKNAME) {
                jSONObject.put("dictionaryType", "nickname");
            } else {
                jSONObject.put("dictionaryType", "common");
            }
            jSONObject.put("language", profanityWord.getLanguage());
            jSONObject.put("text", profanityWord.getText());
            if (profanityWord.getCheckStatus() == ProfanityWord.ProfanityCheckStatus.VALID) {
                jSONObject.put("checkStatus", "valid");
            } else if (profanityWord.getCheckStatus() == ProfanityWord.ProfanityCheckStatus.INVALID) {
                jSONObject.put("checkStatus", "invalid");
            } else {
                jSONObject.put("checkStatus", "unchecked");
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static JSONArray toJsonFromPromoCodeBundle(List<PromoCodeBundle> list) throws JSONException {
        if (list == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (PromoCodeBundle promoCodeBundle : list) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sku", promoCodeBundle.getSku());
            jSONObject.put("customAttribute", promoCodeBundle.getCustomAttribute() != null ? promoCodeBundle.getCustomAttribute() : JSONObject.NULL);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static JSONArray toJsonFromSubscriptionProducts(List<SubscriptionProduct> list) {
        if (list == null) {
            return null;
        }
        SubscriptionProductMapper subscriptionProductMapper = new SubscriptionProductMapper(a.f775a.getCapabilities().isPurchaseMock());
        JSONArray jSONArray = new JSONArray();
        Iterator<SubscriptionProduct> it = list.iterator();
        while (it.hasNext()) {
            JSONObject json = subscriptionProductMapper.toJSON(it.next());
            if (json != null) {
                jSONArray.put(json);
            }
        }
        return jSONArray;
    }

    public static JSONArray toJsonFromSubscriptionPurchases(List<SubscriptionPurchase> list) {
        if (list == null) {
            return null;
        }
        SubscriptionPurchaseMapper subscriptionPurchaseMapper = new SubscriptionPurchaseMapper();
        JSONArray jSONArray = new JSONArray();
        Iterator<SubscriptionPurchase> it = list.iterator();
        while (it.hasNext()) {
            JSONObject json = subscriptionPurchaseMapper.toJSON(it.next());
            if (json != null) {
                jSONArray.put(json);
            }
        }
        return jSONArray;
    }

    public static JSONArray toJsonFromSubscriptionTransactions(List<SubscriptionTransaction> list) throws JSONException {
        if (list == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (SubscriptionTransaction subscriptionTransaction : list) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orderId", subscriptionTransaction.getOrderId() != null ? subscriptionTransaction.getOrderId() : JSONObject.NULL);
            jSONObject.put("productId", subscriptionTransaction.getProductId());
            jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_STATE, subscriptionTransaction.getState().getValue());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static JSONArray toJsonFromVCBundles(List<VirtualCurrencyBundle> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (VirtualCurrencyBundle virtualCurrencyBundle : list) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sku", virtualCurrencyBundle.getSku());
            jSONObject.put("title", virtualCurrencyBundle.getTitle());
            jSONObject.put("price", virtualCurrencyBundle.getPrice());
            jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_PRICE_CODE, virtualCurrencyBundle.getPriceCode());
            jSONObject.put("displayPrice", virtualCurrencyBundle.getDisplayPrice());
            jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_USD_PRICE, virtualCurrencyBundle.getUsdPrice());
            jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_DETAIL, virtualCurrencyBundle.getDetail());
            jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_VIRTUAL_CURRENCY_NAME, virtualCurrencyBundle.getVirtualCurrencyName());
            jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_AMOUNT, virtualCurrencyBundle.getAmount());
            jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_EXTRA_AMOUNT, virtualCurrencyBundle.getExtraAmount());
            jSONObject.put("customAttribute", virtualCurrencyBundle.getCustomAttribute() != null ? virtualCurrencyBundle.getCustomAttribute() : JSONObject.NULL);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static JSONArray toJsonFromVCPurchaseSummaries(List<VirtualCurrencyPurchasedSummary> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (VirtualCurrencyPurchasedSummary virtualCurrencyPurchasedSummary : list) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("market", virtualCurrencyPurchasedSummary.getMarket().getValue());
            jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_VIRTUAL_CURRENCY_NAME, virtualCurrencyPurchasedSummary.getVirtualCurrencyName());
            jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_BRIDGE_LIFETIME_PURCHASED_USD, virtualCurrencyPurchasedSummary.getLifeTimePurchasedUsd());
            jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_BRIDGE_LIFETIME_PURCHASED_VC, virtualCurrencyPurchasedSummary.getLifeTimePurchasedAmount());
            jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_BRIDGE_LIFETIME_PURCHASES, a(virtualCurrencyPurchasedSummary.getLifeTimePurchasesBySku()));
            jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_BRIDGE_THIS_DAY_PURCHASED_USD, virtualCurrencyPurchasedSummary.getThisDayPurchasedUsd());
            jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_BRIDGE_THIS_DAY_PURCHASED_VC, virtualCurrencyPurchasedSummary.getThisDayPurchasedAmount());
            jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_BRIDGE_THIS_DAY_PURCHASES, a(virtualCurrencyPurchasedSummary.getThisDayPurchasesBySku()));
            jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_BRIDGE_THIS_MONTH_PURCHASED_USD, virtualCurrencyPurchasedSummary.getThisMonthPurchasedUsd());
            jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_BRIDGE_THIS_MONTH_PURCHASED_VC, virtualCurrencyPurchasedSummary.getThisMonthPurchasedAmount());
            jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_BRIDGE_THIS_MONTH_PURCHASES, a(virtualCurrencyPurchasedSummary.getThisMonthPurchasesBySku()));
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static JSONArray toJsonFromVCTransactions(List<VirtualCurrencyTransaction> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (VirtualCurrencyTransaction virtualCurrencyTransaction : list) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orderId", virtualCurrencyTransaction.getOrderId() != null ? virtualCurrencyTransaction.getOrderId() : JSONObject.NULL);
            jSONObject.put("sku", virtualCurrencyTransaction.getSku());
            jSONObject.put(MapperConstants.SUBSCRIPTION_FIELD_STATE, virtualCurrencyTransaction.getState().toString());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static JSONArray toJsonFromVCWallets(Collection<VirtualCurrencyWallet> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (VirtualCurrencyWallet virtualCurrencyWallet : collection) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("market", virtualCurrencyWallet.getMarket().getValue());
            jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_VIRTUAL_CURRENCY_NAME, virtualCurrencyWallet.getVirtualCurrencyName());
            jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_BRIDGE_TOTAL_BALANCE, virtualCurrencyWallet.getTotalBalance());
            jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_BRIDGE_FREE_BALANCE, virtualCurrencyWallet.getFreeBalance());
            Map<String, Integer> paidBalance = virtualCurrencyWallet.getPaidBalance();
            JSONObject jSONObject2 = new JSONObject();
            for (String str : paidBalance.keySet()) {
                jSONObject2.put(str, paidBalance.get(str));
            }
            jSONObject.put(MapperConstants.VIRTUAL_CURRENCY_FIELD_BRIDGE_PAID_BALANCE, jSONObject2);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static JSONArray toJsonFromWordList(List<ProfanityWord> list) throws JSONException {
        if (list == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (ProfanityWord profanityWord : list) {
            JSONObject jSONObject = new JSONObject();
            if (profanityWord.getDictionaryType() == ProfanityWord.ProfanityDictionaryType.NICKNAME) {
                jSONObject.put("dictionaryType", "nickname");
            } else {
                jSONObject.put("dictionaryType", "common");
            }
            jSONObject.put("language", profanityWord.getLanguage());
            jSONObject.put("text", profanityWord.getText());
            if (profanityWord.getCheckStatus() == ProfanityWord.ProfanityCheckStatus.VALID) {
                jSONObject.put("checkStatus", "valid");
            } else if (profanityWord.getCheckStatus() == ProfanityWord.ProfanityCheckStatus.INVALID) {
                jSONObject.put("checkStatus", "invalid");
            } else {
                jSONObject.put("checkStatus", "unchecked");
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static Object toNullableJsonFromBaaSUser(BaaSUser baaSUser) throws JSONException {
        return baaSUser != null ? toJsonFromBaaSUser(baaSUser) : JSONObject.NULL;
    }

    public static Object toNullableJsonFromInquiryStatus(InquiryStatus inquiryStatus) throws JSONException {
        return inquiryStatus != null ? toJsonFromInquiryStatus(inquiryStatus) : JSONObject.NULL;
    }

    public static Object toNullableJsonFromLinkedAccount(LinkedAccount linkedAccount) throws JSONException {
        return linkedAccount != null ? toJsonFromLinkedAccount(linkedAccount) : JSONObject.NULL;
    }

    public static Object toNullableJsonFromMissionStatuses(List<MissionStatus> list) throws JSONException {
        return list != null ? toJsonFromMissionStatuses(list) : JSONObject.NULL;
    }

    public static Object toNullableJsonFromNPFError(NPFError nPFError) throws JSONException {
        return nPFError != null ? toJsonFromNPFError(nPFError) : JSONObject.NULL;
    }

    public static Object toNullableJsonFromNintendoAccount(NintendoAccount nintendoAccount) throws JSONException {
        return nintendoAccount != null ? toJsonFromNintendoAccount(nintendoAccount) : JSONObject.NULL;
    }

    public static Object toNullableJsonFromOtherUsers(List<OtherUser> list) throws JSONException {
        return list != null ? toJsonFromOtherUsers(list) : JSONObject.NULL;
    }

    public static Object toNullableJsonFromProfanityWords(List<ProfanityWord> list) throws JSONException {
        return list != null ? toJsonFromProfanityWords(list) : JSONObject.NULL;
    }

    public static Object toNullableJsonFromPromoCodeBundle(List<PromoCodeBundle> list) throws JSONException {
        return list != null ? toJsonFromPromoCodeBundle(list) : JSONObject.NULL;
    }

    public static Object toNullableJsonFromSubscriptionProducts(List<SubscriptionProduct> list) {
        return list != null ? toJsonFromSubscriptionProducts(list) : JSONObject.NULL;
    }

    public static Object toNullableJsonFromSubscriptionProductsForUnity(List<SubscriptionProduct> list) throws JSONException {
        JSONObject json;
        if (list == null) {
            return JSONObject.NULL;
        }
        SubscriptionProductMapper subscriptionProductMapper = new SubscriptionProductMapper(a.f775a.getCapabilities().isPurchaseMock());
        JSONArray jSONArray = new JSONArray();
        for (SubscriptionProduct subscriptionProduct : list) {
            if (subscriptionProduct != null && (json = subscriptionProductMapper.toJSON(subscriptionProduct)) != null) {
                json.put(MapperConstants.SUBSCRIPTION_FIELD_PRICE_AMOUNT_MICROS, Long.toString(subscriptionProduct.getPriceAmountMicros()));
                json.put(MapperConstants.SUBSCRIPTION_FIELD_INTRODUCTORY_PRICE_AMOUNT_MICROS, Long.toString(subscriptionProduct.getIntroductoryPriceAmountMicros()));
                jSONArray.put(json);
            }
        }
        return jSONArray;
    }

    public static Object toNullableJsonFromSubscriptionPurchases(List<SubscriptionPurchase> list) {
        return list != null ? toJsonFromSubscriptionPurchases(list) : JSONObject.NULL;
    }

    public static Object toNullableJsonFromVCBundles(List<VirtualCurrencyBundle> list) throws JSONException {
        return list != null ? toJsonFromVCBundles(list) : JSONObject.NULL;
    }

    public static Object toNullableJsonFromVCPurchaseSummaries(List<VirtualCurrencyPurchasedSummary> list) throws JSONException {
        return list != null ? toJsonFromVCPurchaseSummaries(list) : JSONObject.NULL;
    }

    public static Object toNullableJsonFromVCTransactions(List<VirtualCurrencyTransaction> list) throws JSONException {
        return list != null ? toJsonFromVCTransactions(list) : JSONObject.NULL;
    }

    public static Object toNullableJsonFromVCWallets(List<VirtualCurrencyWallet> list) throws JSONException {
        return list != null ? toJsonFromVCWallets(list) : JSONObject.NULL;
    }
}
