package com.nintendo.npf.sdkbilling;

import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements BillingClientStateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NPFBillingClient f954a;
    public final /* synthetic */ Runnable b;

    public h(NPFBillingClient nPFBillingClient, Runnable runnable) {
        this.f954a = nPFBillingClient;
        this.b = runnable;
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingServiceDisconnected() {
        SDKLog.d(NPFBillingClient.access$getTAG$cp(), "Service is disconnected");
        NPFBillingClient nPFBillingClient = this.f954a;
        nPFBillingClient.setBillingClientResult(nPFBillingClient.createBillingClientResultDisconnected());
        this.b.run();
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingSetupFinished(BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        SDKLog.d(NPFBillingClient.access$getTAG$cp(), "Setup finished. Response code: " + billingResult.getResponseCode());
        this.f954a.setBillingClientResult(billingResult);
        this.b.run();
    }
}
