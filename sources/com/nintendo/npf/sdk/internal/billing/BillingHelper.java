package com.nintendo.npf.sdk.internal.billing;

import com.google.android.gms.internal.measurement.zzah$$ExternalSyntheticBackportWithForwarding0;
import com.nintendo.npf.sdk.core.c5;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\n \u0016*\u0004\u0018\u00010\u00040\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0018R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u001a\u0010 \u001a\u00020\u001f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/nintendo/npf/sdk/internal/billing/BillingHelper;", "", "<init>", "()V", "", "getMarket", "()Ljava/lang/String;", "market", "", "setMarket", "(Ljava/lang/String;)V", "currencyCode", "Ljava/math/BigDecimal;", "price", "createDisplayPrice", "(Ljava/lang/String;Ljava/math/BigDecimal;)Ljava/lang/String;", "userId", "packageName", "sku", MapperConstants.VIRTUAL_CURRENCY_FIELD_PRICE_CODE, "getDigest", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;)Ljava/lang/String;", "kotlin.jvm.PlatformType", "a", "Ljava/lang/String;", "TAG", "MARKET_APPLE", "MARKET_GOOGLE", "MARKET_WEB", "MARKET_MOCK", "b", "", "isMarketGoogle", "()Z", "isMarketGoogle$annotations", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BillingHelper {
    public static final String MARKET_APPLE = "APPLE";
    public static final String MARKET_GOOGLE = "GOOGLE";
    public static final String MARKET_MOCK = "MOCK";
    public static final String MARKET_WEB = "WEB";
    public static final BillingHelper INSTANCE = new BillingHelper();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final String TAG = "BillingHelper";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static String market = "GOOGLE";

    private BillingHelper() {
    }

    @JvmStatic
    public static final String createDisplayPrice(String currencyCode, BigDecimal price) {
        Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
        Intrinsics.checkNotNullParameter(price, "price");
        String str = currencyCode + price;
        try {
            Currency currency = Currency.getInstance(currencyCode);
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.getDefault());
            currencyInstance.setCurrency(currency);
            currencyInstance.setMaximumFractionDigits(currency.getDefaultFractionDigits());
            currencyInstance.setMinimumFractionDigits(currency.getDefaultFractionDigits());
            String str2 = currencyInstance.format(price);
            Intrinsics.checkNotNullExpressionValue(str2, "currencyFormat.format(price)");
            return str2;
        } catch (IllegalArgumentException e) {
            SDKLog.w(TAG, "Error creating display price: " + e);
            return str;
        }
    }

    @JvmStatic
    public static final String getDigest(String userId, String packageName, String sku, String priceCode, BigDecimal price) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(sku, "sku");
        if (priceCode == null || price == null) {
            return "";
        }
        try {
            StringBuilder sbAppend = new StringBuilder().append(userId).append(sku).append(priceCode).append(zzah$$ExternalSyntheticBackportWithForwarding0.m(price).toPlainString());
            Charset charset = Charsets.UTF_8;
            byte[] bytes = packageName.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            String string = sbAppend.append(c5.a(bytes, 600, 8, "HmacSHA1")).toString();
            SDKLog.d(TAG, "baseString : " + string);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bytes2 = string.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes2);
            byte[] hash = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            Intrinsics.checkNotNullExpressionValue(hash, "hash");
            for (byte b : hash) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            String string2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string2, "{\n            val baseSt…lder.toString()\n        }");
            return string2;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @JvmStatic
    public static final String getMarket() {
        return market;
    }

    public static final boolean isMarketGoogle() {
        return Intrinsics.areEqual(market, "GOOGLE");
    }

    @JvmStatic
    public static /* synthetic */ void isMarketGoogle$annotations() {
    }

    @JvmStatic
    public static final void setMarket(String market2) {
        Intrinsics.checkNotNullParameter(market2, "market");
        market = market2;
    }
}
