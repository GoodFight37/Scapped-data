package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.repository.PromoCodeBundleGoogleRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NPFBillingClient f977a;
    public final /* synthetic */ Function2 b;
    public final /* synthetic */ PromoCodeBundleGoogleRepository c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(NPFBillingClient nPFBillingClient, Function2 function2, PromoCodeBundleGoogleRepository promoCodeBundleGoogleRepository) {
        super(2);
        this.f977a = nPFBillingClient;
        this.b = function2;
        this.c = promoCodeBundleGoogleRepository;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        List list = (List) obj;
        Intrinsics.checkNotNullParameter(list, "list");
        this.f977a.teardown();
        this.b.invoke(list, (NPFError) obj2);
        this.c.g = false;
        return Unit.INSTANCE;
    }
}
