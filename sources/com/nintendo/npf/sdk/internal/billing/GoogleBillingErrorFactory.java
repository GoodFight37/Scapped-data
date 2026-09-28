package com.nintendo.npf.sdk.internal.billing;

import com.android.billingclient.api.BillingResult;
import com.nintendo.npf.sdk.NPFError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/nintendo/npf/sdk/internal/billing/GoogleBillingErrorFactory;", "", "createBillingError", "Lcom/nintendo/npf/sdk/NPFError;", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "NPFSDKBilling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface GoogleBillingErrorFactory {
    NPFError createBillingError(BillingResult billingResult);
}
