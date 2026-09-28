package com.nintendo.npf.sdk.promo;

import com.nintendo.npf.sdk.NPFError;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0005H&J,\u0010\t\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0005H&¨\u0006\n"}, d2 = {"Lcom/nintendo/npf/sdk/promo/PromoCodeService;", "", "checkPromoCodes", "", "block", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/promo/PromoCodeBundle;", "Lcom/nintendo/npf/sdk/NPFError;", "exchangePromoCodes", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PromoCodeService {
    void checkPromoCodes(Function2<? super List<PromoCodeBundle>, ? super NPFError, Unit> block);

    void exchangePromoCodes(Function2<? super List<PromoCodeBundle>, ? super NPFError, Unit> block);
}
