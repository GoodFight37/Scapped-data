package com.nintendo.npf.sdk.subscription;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/nintendo/npf/sdk/subscription/SubscriptionMarket;", "", "", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "a", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", "APPLE", "GOOGLE", "MOCK", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum SubscriptionMarket {
    APPLE("APPLE"),
    GOOGLE("GOOGLE"),
    MOCK("MOCK");


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map b;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String value;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/nintendo/npf/sdk/subscription/SubscriptionMarket$Companion;", "", "()V", "values", "", "", "Lcom/nintendo/npf/sdk/subscription/SubscriptionMarket;", "fromValue", AppMeasurementSdk.ConditionalUserProperty.NAME, "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubscriptionMarket fromValue(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return (SubscriptionMarket) SubscriptionMarket.b.get(name);
        }

        private Companion() {
        }
    }

    static {
        SubscriptionMarket[] subscriptionMarketArrValues = values();
        ArrayList arrayList = new ArrayList(subscriptionMarketArrValues.length);
        for (SubscriptionMarket subscriptionMarket : subscriptionMarketArrValues) {
            arrayList.add(TuplesKt.to(subscriptionMarket.name(), subscriptionMarket));
        }
        b = MapsKt.toMap(arrayList);
    }

    SubscriptionMarket(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
