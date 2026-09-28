package com.nintendo.npf.sdk.internal.billing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.DefaultLifecycleObserver;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/nintendo/npf/sdk/internal/billing/PromoCodeReceiver;", "Landroid/content/BroadcastReceiver;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PromoCodeReceiver extends BroadcastReceiver implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f731a;

    public PromoCodeReceiver(Function0 eventHandlerProvider) {
        Intrinsics.checkNotNullParameter(eventHandlerProvider, "eventHandlerProvider");
        this.f731a = eventHandlerProvider;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        SDKLog.d("PromoCodeReceiver", "PromoCodeReceiver#onReceive");
        NPFSDK.EventHandler eventHandler = (NPFSDK.EventHandler) this.f731a.invoke();
        if (eventHandler != null) {
            eventHandler.onVirtualCurrencyPurchasesUpdated();
        }
    }
}
