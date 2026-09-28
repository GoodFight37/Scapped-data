package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionProductGoogleRepository;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubscriptionProductGoogleRepository f930a;
    public final /* synthetic */ e0 b;
    public final /* synthetic */ Map c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(SubscriptionProductGoogleRepository subscriptionProductGoogleRepository, e0 e0Var, Map map) {
        super(2);
        this.f930a = subscriptionProductGoogleRepository;
        this.b = e0Var;
        this.c = map;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        List list = (List) obj;
        NPFError nPFError = (NPFError) obj2;
        if (nPFError != null) {
            this.f930a.f710a.reportError("getProducts/getProductDetailsList", nPFError);
            this.b.invoke(CollectionsKt.emptyList(), nPFError);
        } else {
            this.b.invoke(SubscriptionProductGoogleRepository.access$mergeProductDetails(this.f930a, this.c, list), null);
        }
        return Unit.INSTANCE;
    }
}
