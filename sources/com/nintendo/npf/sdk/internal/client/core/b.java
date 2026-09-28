package com.nintendo.npf.sdk.internal.client.core;

import com.nintendo.npf.sdk.core.m1;
import com.nintendo.npf.sdk.core.r4;
import com.nintendo.npf.sdk.core.u2;
import com.nintendo.npf.sdk.core.v2;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public static final e a(r4 r4Var) {
        Intrinsics.checkNotNullParameter(r4Var, "<this>");
        if (r4Var instanceof v2) {
            return e.b.f772a;
        }
        if (r4Var instanceof u2) {
            return e.a.f771a;
        }
        if (r4Var instanceof m1) {
            return e.c.f773a;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void a(r4 r4Var, d.b result) {
        Intrinsics.checkNotNullParameter(r4Var, "<this>");
        Intrinsics.checkNotNullParameter(result, "result");
        Object objA = result.a();
        if (r4Var instanceof v2) {
            ((v2) r4Var).a(objA instanceof JSONObject ? (JSONObject) objA : null, null);
        } else if (r4Var instanceof u2) {
            ((u2) r4Var).a(objA instanceof JSONArray ? (JSONArray) objA : null, null);
        } else if (r4Var instanceof m1) {
            ((m1) r4Var).onComplete(null);
        }
    }

    public static final void a(r4 r4Var, d.a result) {
        Intrinsics.checkNotNullParameter(r4Var, "<this>");
        Intrinsics.checkNotNullParameter(result, "result");
        if (r4Var instanceof v2) {
            ((v2) r4Var).a(null, result.a().getError());
        } else if (r4Var instanceof u2) {
            ((u2) r4Var).a(null, result.a().getError());
        } else if (r4Var instanceof m1) {
            ((m1) r4Var).onComplete(result.a().getError());
        }
    }
}
