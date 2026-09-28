package com.nintendo.npf.sdk.domain.repository;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyPurchasedSummary;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2 \u0010\n\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00030\u000bH&J:\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2 \u0010\n\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00030\u000bH&¨\u0006\u0010"}, d2 = {"Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyPurchaseSummaryRepository;", "", "find", "", "account", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "marketName", "", "timezoneOffsetInMinutes", "", "block", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyPurchasedSummary;", "Lcom/nintendo/npf/sdk/NPFError;", "findGlobal", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface VirtualCurrencyPurchaseSummaryRepository {
    void find(BaaSUser account, String marketName, int timezoneOffsetInMinutes, Function2<? super List<VirtualCurrencyPurchasedSummary>, ? super NPFError, Unit> block);

    void findGlobal(BaaSUser account, int timezoneOffsetInMinutes, Function2<? super List<VirtualCurrencyPurchasedSummary>, ? super NPFError, Unit> block);
}
