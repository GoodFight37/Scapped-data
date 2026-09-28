package com.nintendo.npf.sdk.core;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r2 {
    public static final boolean a(JSONObject jSONObject, String name) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return jSONObject.has(name) && !jSONObject.isNull(name);
    }
}
