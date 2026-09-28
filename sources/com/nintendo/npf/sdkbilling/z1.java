package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchases;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class z1 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e2 f1009a;
    public final /* synthetic */ VirtualCurrencyPurchases b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z1(e2 e2Var, VirtualCurrencyPurchases virtualCurrencyPurchases) {
        super(2);
        this.f1009a = e2Var;
        this.b = virtualCurrencyPurchases;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        NPFError nPFError = (NPFError) obj2;
        if (nPFError != null) {
            this.f1009a.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), nPFError);
        } else {
            this.f1009a.invoke(this.b, null);
        }
        return Unit.INSTANCE;
    }
}
