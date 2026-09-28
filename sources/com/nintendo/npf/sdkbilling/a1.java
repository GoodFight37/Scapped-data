package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.helper.VirtualCurrencyHelper;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyBundleGoogleRepository;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class a1 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VirtualCurrencyBundleGoogleRepository f931a;
    public final /* synthetic */ d1 b;
    public final /* synthetic */ Map c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(VirtualCurrencyBundleGoogleRepository virtualCurrencyBundleGoogleRepository, d1 d1Var, Map map) {
        super(2);
        this.f931a = virtualCurrencyBundleGoogleRepository;
        this.b = d1Var;
        this.c = map;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        List list = (List) obj;
        NPFError nPFError = (NPFError) obj2;
        if (nPFError != null) {
            this.f931a.f717a.reportError(VirtualCurrencyHelper.REPORT_EVENT_ID, "getBundles#getProductDetailsList", nPFError);
            this.b.invoke(CollectionsKt.emptyList(), nPFError);
        } else {
            this.b.invoke(VirtualCurrencyBundleGoogleRepository.access$mergeProductDetails(this.f931a, this.c, list), null);
        }
        return Unit.INSTANCE;
    }
}
