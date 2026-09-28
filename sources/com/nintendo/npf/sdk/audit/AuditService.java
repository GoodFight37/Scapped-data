package com.nintendo.npf.sdk.audit;

import com.nintendo.npf.sdk.NPFError;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052$\u0010\u0007\u001a \u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH&¨\u0006\n"}, d2 = {"Lcom/nintendo/npf/sdk/audit/AuditService;", "", "checkProfanityWord", "", "profanityWords", "", "Lcom/nintendo/npf/sdk/audit/ProfanityWord;", "callback", "Lkotlin/Function2;", "Lcom/nintendo/npf/sdk/NPFError;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AuditService {
    void checkProfanityWord(List<ProfanityWord> profanityWords, Function2<? super List<ProfanityWord>, ? super NPFError, Unit> callback);
}
