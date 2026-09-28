package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.promo.PromoCodeBundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f980a;
    public final /* synthetic */ Set b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(t tVar, Set set) {
        super(2);
        this.f980a = tVar;
        this.b = set;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        List bundles = (List) obj;
        NPFError nPFError = (NPFError) obj2;
        Intrinsics.checkNotNullParameter(bundles, "bundles");
        if (nPFError != null) {
            this.f980a.invoke(CollectionsKt.emptyList(), nPFError);
        } else if (bundles.isEmpty()) {
            this.f980a.invoke(CollectionsKt.emptyList(), null);
        } else {
            Set set = this.b;
            ArrayList arrayList = new ArrayList();
            for (Object obj3 : bundles) {
                if (set.contains(((PromoCodeBundle) obj3).getSku())) {
                    arrayList.add(obj3);
                }
            }
            this.f980a.invoke(arrayList, null);
        }
        return Unit.INSTANCE;
    }
}
