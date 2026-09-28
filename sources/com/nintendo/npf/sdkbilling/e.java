package com.nintendo.npf.sdkbilling;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NPFBillingClient f944a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(NPFBillingClient nPFBillingClient, Looper looper) {
        super(looper);
        this.f944a = nPFBillingClient;
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Runnable runnable = message.getCallback();
        if (this.f944a.getBillingClient().isReady()) {
            runnable.run();
            return;
        }
        NPFBillingClient nPFBillingClient = this.f944a;
        Intrinsics.checkNotNullExpressionValue(runnable, "runnable");
        nPFBillingClient.getBillingClient().startConnection(new h(nPFBillingClient, runnable));
    }
}
