package com.nintendo.npf.sdk.user;

import com.nintendo.npf.sdk.NPFError;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\"\u0010\u0007\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00030\bH&¨\u0006\u000b"}, d2 = {"Lcom/nintendo/npf/sdk/user/OtherUserService;", "", "getAsList", "", "userIds", "", "", "callback", "Lkotlin/Function2;", "Lcom/nintendo/npf/sdk/user/OtherUser;", "Lcom/nintendo/npf/sdk/NPFError;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface OtherUserService {
    void getAsList(List<String> userIds, Function2<? super List<? extends OtherUser>, ? super NPFError, Unit> callback);
}
