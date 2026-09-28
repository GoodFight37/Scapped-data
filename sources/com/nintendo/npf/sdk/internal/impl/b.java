package com.nintendo.npf.sdk.internal.impl;

import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public static final boolean a(a aVar, JSONObject event) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        return aVar.a(event);
    }

    public static final Map a(a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Map all = aVar.a();
        Intrinsics.checkNotNullExpressionValue(all, "all");
        return all;
    }

    public static final void a(a aVar, Set keys) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        aVar.a(keys);
    }
}
