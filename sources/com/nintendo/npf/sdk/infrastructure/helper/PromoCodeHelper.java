package com.nintendo.npf.sdk.infrastructure.helper;

import com.nintendo.npf.sdk.NPFError;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/helper/PromoCodeHelper;", "Lcom/nintendo/npf/sdk/infrastructure/helper/VirtualCurrencyHelper;", "reportHelperProvider", "Lkotlin/Function0;", "Lcom/nintendo/npf/sdk/infrastructure/helper/ReportHelper;", "(Lkotlin/jvm/functions/Function0;)V", "finalizePurchaseError", "Lcom/nintendo/npf/sdk/NPFError;", "error", "Companion", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PromoCodeHelper extends VirtualCurrencyHelper {
    public static final String REPORT_EVENT_ID = "promocode_error";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromoCodeHelper(Function0<ReportHelper> reportHelperProvider) {
        super(reportHelperProvider);
        Intrinsics.checkNotNullParameter(reportHelperProvider, "reportHelperProvider");
    }

    @Override // com.nintendo.npf.sdk.infrastructure.helper.VirtualCurrencyHelper
    public NPFError finalizePurchaseError(NPFError error) {
        if (error == null) {
            return null;
        }
        return error.getErrorType() == NPFError.ErrorType.NETWORK_ERROR ? error.copy(NPFError.ErrorType.NPF_ERROR, 3053, "Purchase completed, but a subsequent network error occurred.") : error;
    }
}
