package com.nintendo.npf.sdk.domain.repository;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFException;
import com.nintendo.npf.sdk.core.r1;
import com.nintendo.npf.sdk.user.NintendoAccount;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J1\u0010\n\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJK\u0010\n\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\u001c\u0010\u000f\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000e0\fH&¢\u0006\u0004\b\n\u0010\u0010J#\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H¦@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016JQ\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\u000e0\u001cH&¢\u0006\u0004\b\u001e\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/nintendo/npf/sdk/domain/repository/NintendoAccountRepository;", "", "Lcom/nintendo/npf/sdk/user/NintendoAccount;", "getCurrentNintendoAccount", "()Lcom/nintendo/npf/sdk/user/NintendoAccount;", "", "targetNintendoAccountId", "sessionToken", "", "triggeredByExpiration", "getNintendoAccount", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lcom/nintendo/npf/sdk/core/r1;", "", "block", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function2;)V", "sessionTokenCode", "verifier", "getSessionToken", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNintendoAccountFromSessionTokenCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nintendoAccount", "applicationName", "market", "title", "price", "Lkotlin/Function1;", "Lcom/nintendo/npf/sdk/NPFError;", "sendVcmEmailToParent", "(Lcom/nintendo/npf/sdk/user/NintendoAccount;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface NintendoAccountRepository {

    public static final class a {
        public static /* synthetic */ Object a(NintendoAccountRepository nintendoAccountRepository, String str, String str2, boolean z, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNintendoAccount");
            }
            if ((i & 4) != 0) {
                z = false;
            }
            return nintendoAccountRepository.getNintendoAccount(str, str2, z, (Continuation<? super NintendoAccount>) continuation);
        }
    }

    NintendoAccount getCurrentNintendoAccount();

    Object getNintendoAccount(String str, String str2, boolean z, Continuation<? super NintendoAccount> continuation) throws r1;

    void getNintendoAccount(String targetNintendoAccountId, String sessionToken, boolean triggeredByExpiration, Function2<? super NintendoAccount, ? super r1, Unit> block);

    Object getNintendoAccountFromSessionTokenCode(String str, String str2, String str3, Continuation<? super NintendoAccount> continuation) throws NPFException;

    Object getSessionToken(String str, String str2, Continuation<? super String> continuation) throws NPFException;

    void sendVcmEmailToParent(NintendoAccount nintendoAccount, String applicationName, String market, String title, String price, Function1<? super NPFError, Unit> block);
}
