package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchases;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class f2 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function3 f949a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f2(Function3 function3) {
        super(2);
        this.f949a = function3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        VirtualCurrencyPurchases purchases = (VirtualCurrencyPurchases) obj;
        NPFError nPFError = (NPFError) obj2;
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        if (nPFError != null) {
            this.f949a.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), Boolean.FALSE, nPFError);
        } else {
            this.f949a.invoke(purchases, Boolean.TRUE, null);
        }
        return Unit.INSTANCE;
    }
}
