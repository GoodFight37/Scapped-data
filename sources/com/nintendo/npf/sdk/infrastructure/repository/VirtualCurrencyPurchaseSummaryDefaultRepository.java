package com.nintendo.npf.sdk.infrastructure.repository;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.repository.VirtualCurrencyPurchaseSummaryRepository;
import com.nintendo.npf.sdk.infrastructure.api.VirtualCurrencyApi;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyPurchasedSummary;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJI\u0010\u0015\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2 \u0010\u0014\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u00130\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016JA\u0010\u0017\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2 \u0010\u0014\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u00130\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/repository/VirtualCurrencyPurchaseSummaryDefaultRepository;", "Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyPurchaseSummaryRepository;", "Lkotlin/Function0;", "Lcom/nintendo/npf/sdk/infrastructure/api/VirtualCurrencyApi;", "api", "Lcom/nintendo/npf/sdk/domain/ErrorFactory;", "errorFactory", "<init>", "(Lkotlin/jvm/functions/Function0;Lcom/nintendo/npf/sdk/domain/ErrorFactory;)V", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "account", "", "marketName", "", "timezoneOffsetInMinutes", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyPurchasedSummary;", "Lcom/nintendo/npf/sdk/NPFError;", "", "block", "find", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Ljava/lang/String;ILkotlin/jvm/functions/Function2;)V", "findGlobal", "(Lcom/nintendo/npf/sdk/user/BaaSUser;ILkotlin/jvm/functions/Function2;)V", "Companion", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrencyPurchaseSummaryDefaultRepository implements VirtualCurrencyPurchaseSummaryRepository {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String[] c = {"APPLE", "GOOGLE"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f722a;
    public final ErrorFactory b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/repository/VirtualCurrencyPurchaseSummaryDefaultRepository$Companion;", "", "", "", "SUPPORTED_MARKET_NAMES", "[Ljava/lang/String;", "getSUPPORTED_MARKET_NAMES", "()[Ljava/lang/String;", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final String[] getSUPPORTED_MARKET_NAMES() {
            return VirtualCurrencyPurchaseSummaryDefaultRepository.c;
        }
    }

    public VirtualCurrencyPurchaseSummaryDefaultRepository(Function0<VirtualCurrencyApi> api, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f722a = api;
        this.b = errorFactory;
    }

    public static String a(int i) {
        if (i == 0) {
            return "Z";
        }
        String str = i < 0 ? "-" : "+";
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        String str2 = String.format(locale, "%1$02d", Arrays.copyOf(new Object[]{Integer.valueOf(Math.abs(i) / 60)}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(locale, format, *args)");
        String str3 = String.format(locale, "%1$02d", Arrays.copyOf(new Object[]{Integer.valueOf(Math.abs(i) % 60)}, 1));
        Intrinsics.checkNotNullExpressionValue(str3, "format(locale, format, *args)");
        return str + str2 + ':' + str3;
    }

    @Override // com.nintendo.npf.sdk.domain.repository.VirtualCurrencyPurchaseSummaryRepository
    public void find(BaaSUser account, String marketName, int timezoneOffsetInMinutes, Function2<? super List<VirtualCurrencyPurchasedSummary>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(marketName, "marketName");
        Intrinsics.checkNotNullParameter(block, "block");
        for (String str : c) {
            if (StringsKt.equals(str, marketName, true)) {
                ((VirtualCurrencyApi) this.f722a.invoke()).getPurchaseSummaries(account, marketName, a(timezoneOffsetInMinutes), "transaction_histories", block);
                return;
            }
        }
        block.invoke(CollectionsKt.emptyList(), this.b.create_VirtualCurrency_UnsupportedMarket_410());
    }

    @Override // com.nintendo.npf.sdk.domain.repository.VirtualCurrencyPurchaseSummaryRepository
    public void findGlobal(BaaSUser account, int timezoneOffsetInMinutes, Function2<? super List<VirtualCurrencyPurchasedSummary>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(block, "block");
        ((VirtualCurrencyApi) this.f722a.invoke()).getGlobalPurchaseSummaries(account, a(timezoneOffsetInMinutes), "transaction_histories", block);
    }
}
