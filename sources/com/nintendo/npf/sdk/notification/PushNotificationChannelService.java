package com.nintendo.npf.sdk.notification;

import com.nintendo.npf.sdk.NPFError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00030\u0005H&J(\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00030\nH&¨\u0006\u000b"}, d2 = {"Lcom/nintendo/npf/sdk/notification/PushNotificationChannelService;", "", "getDeviceToken", "", "callback", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/NPFError;", "registerDeviceToken", "deviceToken", "Lkotlin/Function1;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PushNotificationChannelService {
    void getDeviceToken(Function2<? super String, ? super NPFError, Unit> callback);

    void registerDeviceToken(String deviceToken, Function1<? super NPFError, Unit> callback);
}
