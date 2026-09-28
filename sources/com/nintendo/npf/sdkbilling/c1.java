package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.api.VirtualCurrencyApi;
import com.nintendo.npf.sdk.infrastructure.helper.VirtualCurrencyHelper;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyBundleGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class c1 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VirtualCurrencyBundleGoogleRepository f938a;
    public final /* synthetic */ d1 b;
    public final /* synthetic */ BaaSUser c;
    public final /* synthetic */ NPFBillingClient d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c1(VirtualCurrencyBundleGoogleRepository virtualCurrencyBundleGoogleRepository, d1 d1Var, BaaSUser baaSUser, NPFBillingClient nPFBillingClient) {
        super(1);
        this.f938a = virtualCurrencyBundleGoogleRepository;
        this.b = d1Var;
        this.c = baaSUser;
        this.d = nPFBillingClient;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        NPFError nPFError = (NPFError) obj;
        if (nPFError != null) {
            this.f938a.f717a.reportError(VirtualCurrencyHelper.REPORT_EVENT_ID, "getBundles#setup", nPFError);
            this.b.invoke(CollectionsKt.emptyList(), nPFError);
        } else {
            ((VirtualCurrencyApi) this.f938a.b.invoke()).getBundles(this.c, "GOOGLE", new b1(this.b, this.d, this.f938a));
        }
        return Unit.INSTANCE;
    }
}
