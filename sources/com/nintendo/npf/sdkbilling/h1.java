package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchases;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class h1 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o1 f956a;
    public final /* synthetic */ VirtualCurrencyPurchases b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1(o1 o1Var, VirtualCurrencyPurchases virtualCurrencyPurchases) {
        super(2);
        this.f956a = o1Var;
        this.b = virtualCurrencyPurchases;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        NPFError nPFError = (NPFError) obj2;
        if (nPFError != null) {
            this.f956a.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), Boolean.TRUE, nPFError);
        } else {
            this.f956a.invoke(this.b, Boolean.TRUE, nPFError);
        }
        return Unit.INSTANCE;
    }
}
