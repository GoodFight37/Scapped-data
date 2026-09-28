package com.nintendo.npf.sdk.user;

import com.nintendo.npf.sdk.NPFError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001c\u0010\u0006\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00030\u0007H&J&\u0010\n\u001a\u00020\u00032\u001c\u0010\u0006\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00030\u0007H&J.\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\b2\u001c\u0010\u0006\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00030\u0007H&¨\u0006\u000e"}, d2 = {"Lcom/nintendo/npf/sdk/user/TransferAccountService;", "", "generateTransferCode", "", "identifier", "Lcom/nintendo/npf/sdk/user/TransferIdentifier;", "callback", "Lkotlin/Function2;", "Lcom/nintendo/npf/sdk/user/TransferCode;", "Lcom/nintendo/npf/sdk/NPFError;", "getTransferCode", "switchBaasUser", "transferCode", "Lcom/nintendo/npf/sdk/user/TransferSwitchResult;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface TransferAccountService {
    void generateTransferCode(TransferIdentifier identifier, Function2<? super TransferCode, ? super NPFError, Unit> callback);

    void getTransferCode(Function2<? super TransferCode, ? super NPFError, Unit> callback);

    void switchBaasUser(TransferCode transferCode, Function2<? super TransferSwitchResult, ? super NPFError, Unit> callback);
}
