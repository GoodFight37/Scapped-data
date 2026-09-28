package com.nintendo.npf.sdk.user;

import com.nintendo.npf.sdk.NPFError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\t0\rH&J\b\u0010\u000f\u001a\u00020\tH&J.\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u001c\u0010\f\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\t0\u0013H&J\u001e\u0010\u0014\u001a\u00020\t2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\t0\rH&J&\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00072\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\t0\rH&J.\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\t0\u0013H&J&\u0010\u001a\u001a\u00020\t2\u001c\u0010\f\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\t0\u0013H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001b"}, d2 = {"Lcom/nintendo/npf/sdk/user/BaasAccountService;", "", "currentBaasUser", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "getCurrentBaasUser", "()Lcom/nintendo/npf/sdk/user/BaaSUser;", "getLanguage", "", "linkNintendoAccount", "", "nintendoAccount", "Lcom/nintendo/npf/sdk/user/NintendoAccount;", "callback", "Lkotlin/Function1;", "Lcom/nintendo/npf/sdk/NPFError;", "resetDeviceAccount", "retryBaasAuth", "avoidMultipleDeviceAccounts", "", "Lkotlin/Function2;", "save", "setLanguage", "language", "switchByNintendoAccount", "switchableNintendoAccount", "Lcom/nintendo/npf/sdk/user/SwitchResult;", "switchNewBaasUser", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface BaasAccountService {
    BaaSUser getCurrentBaasUser();

    String getLanguage();

    void linkNintendoAccount(NintendoAccount nintendoAccount, Function1<? super NPFError, Unit> callback);

    void resetDeviceAccount();

    void retryBaasAuth(boolean avoidMultipleDeviceAccounts, Function2<? super BaaSUser, ? super NPFError, Unit> callback);

    void save(Function1<? super NPFError, Unit> callback);

    void setLanguage(String language, Function1<? super NPFError, Unit> callback);

    void switchByNintendoAccount(NintendoAccount switchableNintendoAccount, Function2<? super SwitchResult, ? super NPFError, Unit> callback);

    void switchNewBaasUser(Function2<? super SwitchResult, ? super NPFError, Unit> callback);
}
