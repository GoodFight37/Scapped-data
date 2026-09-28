package com.nintendo.npf.sdk.user;

import android.app.Activity;
import com.nintendo.npf.sdk.NPFError;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001JT\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00030\fH&J@\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u001c\u0010\u000b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00030\fH&JT\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00030\fH&J@\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u001c\u0010\u000b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00030\fH&J&\u0010\u0012\u001a\u00020\u00032\u001c\u0010\u000b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00030\fH&J&\u0010\u0013\u001a\u00020\u00032\u001c\u0010\u000b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00030\fH&¨\u0006\u0014"}, d2 = {"Lcom/nintendo/npf/sdk/user/NintendoAccountService;", "", "authorizeByNintendoAccount", "", "activity", "Landroid/app/Activity;", "scope", "", "", "optionalQuery", "", "callback", "Lkotlin/Function2;", "Lcom/nintendo/npf/sdk/user/NintendoAccount;", "Lcom/nintendo/npf/sdk/NPFError;", "authorizeByNintendoAccountLegacy", "authorizeBySwitchableNintendoAccount", "authorizeBySwitchableNintendoAccountLegacy", "retryPendingAuthorizationByNintendoAccount", "retryPendingAuthorizationBySwitchableNintendoAccount", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface NintendoAccountService {
    void authorizeByNintendoAccount(Activity activity, List<String> scope, Map<String, String> optionalQuery, Function2<? super NintendoAccount, ? super NPFError, Unit> callback);

    void authorizeByNintendoAccountLegacy(Activity activity, List<String> scope, Function2<? super NintendoAccount, ? super NPFError, Unit> callback);

    void authorizeBySwitchableNintendoAccount(Activity activity, List<String> scope, Map<String, String> optionalQuery, Function2<? super NintendoAccount, ? super NPFError, Unit> callback);

    void authorizeBySwitchableNintendoAccountLegacy(Activity activity, List<String> scope, Function2<? super NintendoAccount, ? super NPFError, Unit> callback);

    void retryPendingAuthorizationByNintendoAccount(Function2<? super NintendoAccount, ? super NPFError, Unit> callback);

    void retryPendingAuthorizationBySwitchableNintendoAccount(Function2<? super NintendoAccount, ? super NPFError, Unit> callback);
}
