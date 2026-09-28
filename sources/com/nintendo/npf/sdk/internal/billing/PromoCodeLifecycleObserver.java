package com.nintendo.npf.sdk.internal.billing;

import android.app.Application;
import android.content.IntentFilter;
import android.os.Build;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/nintendo/npf/sdk/internal/billing/PromoCodeLifecycleObserver;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PromoCodeLifecycleObserver implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f730a;
    public final Function0 b;
    public PromoCodeReceiver c;

    public PromoCodeLifecycleObserver(Application context, Function0 eventHandlerProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(eventHandlerProvider, "eventHandlerProvider");
        this.f730a = context;
        this.b = eventHandlerProvider;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public final void onCreate(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        SDKLog.i("PromoCodeLifecycleObserver", "Calling onCreate()");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public final void onDestroy(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        SDKLog.i("PromoCodeLifecycleObserver", "Calling onDestroy()");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public final void onPause(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        SDKLog.i("PromoCodeLifecycleObserver", "Calling onPause()");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public final void onResume(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        SDKLog.i("PromoCodeLifecycleObserver", "Calling onResume()");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public final void onStart(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        SDKLog.i("PromoCodeLifecycleObserver", "Calling onStart()");
        if (BillingHelper.isMarketGoogle() && this.c == null) {
            SDKLog.d("PromoCodeLifecycleObserver", "Register broadcast receiver for PURCHASES_UPDATED");
            this.c = new PromoCodeReceiver(this.b);
            IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
            if (Build.VERSION.SDK_INT >= 34) {
                this.f730a.registerReceiver(this.c, intentFilter, 2);
            } else {
                this.f730a.registerReceiver(this.c, intentFilter);
            }
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public final void onStop(LifecycleOwner owner) {
        PromoCodeReceiver promoCodeReceiver;
        Intrinsics.checkNotNullParameter(owner, "owner");
        SDKLog.i("PromoCodeLifecycleObserver", "Calling onStop()");
        if (BillingHelper.isMarketGoogle() && (promoCodeReceiver = this.c) != null) {
            SDKLog.d("PromoCodeLifecycleObserver", "Unregister broadcast receiver for PURCHASES_UPDATED");
            this.f730a.unregisterReceiver(promoCodeReceiver);
            this.c = null;
        }
    }
}
