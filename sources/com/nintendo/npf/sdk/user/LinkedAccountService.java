package com.nintendo.npf.sdk.user;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/nintendo/npf/sdk/user/LinkedAccountService;", "", "linkToBaasUser", "", "idToken", "", "callback", "Lcom/nintendo/npf/sdk/user/LinkToBaasUserCallback;", "switchBaasUser", "Lcom/nintendo/npf/sdk/user/SwitchBaasUserCallback;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LinkedAccountService {
    void linkToBaasUser(String idToken, LinkToBaasUserCallback callback);

    void switchBaasUser(String idToken, SwitchBaasUserCallback callback);
}
