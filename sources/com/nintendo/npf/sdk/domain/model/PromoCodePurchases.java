package com.nintendo.npf.sdk.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ \u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/nintendo/npf/sdk/domain/model/PromoCodePurchases;", "", "", "", "transactions", "<init>", "(Ljava/util/List;)V", "component1", "()Ljava/util/List;", "copy", "(Ljava/util/List;)Lcom/nintendo/npf/sdk/domain/model/PromoCodePurchases;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/util/List;", "getTransactions", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PromoCodePurchases {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List transactions;

    public PromoCodePurchases(List<String> transactions) {
        Intrinsics.checkNotNullParameter(transactions, "transactions");
        this.transactions = transactions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromoCodePurchases copy$default(PromoCodePurchases promoCodePurchases, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = promoCodePurchases.transactions;
        }
        return promoCodePurchases.copy(list);
    }

    public final List<String> component1() {
        return this.transactions;
    }

    public final PromoCodePurchases copy(List<String> transactions) {
        Intrinsics.checkNotNullParameter(transactions, "transactions");
        return new PromoCodePurchases(transactions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PromoCodePurchases) && Intrinsics.areEqual(this.transactions, ((PromoCodePurchases) other).transactions);
    }

    public final List<String> getTransactions() {
        return this.transactions;
    }

    public int hashCode() {
        return this.transactions.hashCode();
    }

    public String toString() {
        return "PromoCodePurchases(transactions=" + this.transactions + ')';
    }
}
