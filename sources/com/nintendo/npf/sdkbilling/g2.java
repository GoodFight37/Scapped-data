package com.nintendo.npf.sdkbilling;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyTransactionGoogleRepository;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class g2 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j2 f953a;
    public final /* synthetic */ VirtualCurrencyTransactionGoogleRepository b;
    public final /* synthetic */ List c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g2(j2 j2Var, VirtualCurrencyTransactionGoogleRepository virtualCurrencyTransactionGoogleRepository, List list) {
        super(2);
        this.f953a = j2Var;
        this.b = virtualCurrencyTransactionGoogleRepository;
        this.c = list;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Set registeredOrderIds = (Set) obj;
        NPFError nPFError = (NPFError) obj2;
        Intrinsics.checkNotNullParameter(registeredOrderIds, "registeredOrderIds");
        if (nPFError != null) {
            this.f953a.invoke(CollectionsKt.emptyList(), nPFError);
        } else {
            this.f953a.invoke(VirtualCurrencyTransactionGoogleRepository.access$createTransactions(this.b, this.c, registeredOrderIds), null);
        }
        return Unit.INSTANCE;
    }
}
