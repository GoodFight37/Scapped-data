package com.nintendo.npf.sdk.inquiry;

import com.nintendo.npf.sdk.NPFError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00030\u0005H&¨\u0006\b"}, d2 = {"Lcom/nintendo/npf/sdk/inquiry/InquiryService;", "", "check", "", "callback", "Lkotlin/Function2;", "Lcom/nintendo/npf/sdk/inquiry/InquiryStatus;", "Lcom/nintendo/npf/sdk/NPFError;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface InquiryService {
    void check(Function2<? super InquiryStatus, ? super NPFError, Unit> callback);
}
