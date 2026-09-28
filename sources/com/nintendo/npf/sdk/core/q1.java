package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.internal.billing.BillingHelper;
import com.nintendo.npf.sdk.internal.model.Capabilities;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q1 {
    public static final void a(p1 p1Var, a1 credentialsDataFacade, Capabilities capabilities) {
        Intrinsics.checkNotNullParameter(p1Var, "<this>");
        Intrinsics.checkNotNullParameter(credentialsDataFacade, "credentialsDataFacade");
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        if (p1Var.a() != null) {
            credentialsDataFacade.a(p1Var.a().a(), p1Var.a().b());
        }
        if (capabilities.isSandbox() && capabilities.getMarketSandbox() != null) {
            String marketSandbox = capabilities.getMarketSandbox();
            Intrinsics.checkNotNullExpressionValue(marketSandbox, "capabilities.marketSandbox");
            BillingHelper.setMarket(marketSandbox);
        } else if (p1Var.c() != null) {
            BillingHelper.setMarket(p1Var.c());
        }
        if (p1Var.b() != null) {
            capabilities.updateHostConfiguration(p1Var.b());
        }
    }
}
