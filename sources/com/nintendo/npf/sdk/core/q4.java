package com.nintendo.npf.sdk.core;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q4 f549a = new q4();

    private q4() {
    }

    public static final byte[] a(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        String string = jsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.toString()");
        return StringsKt.encodeToByteArray(string);
    }

    public static final byte[] b(JSONArray jsonArray) throws Throwable {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        byte[] bArrA = v1.a(a(jsonArray));
        Intrinsics.checkNotNullExpressionValue(bArrA, "compress(toBytes(jsonArray))");
        return bArrA;
    }

    public static final byte[] a(JSONArray jsonArray) {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        String string = jsonArray.toString();
        Intrinsics.checkNotNullExpressionValue(string, "jsonArray.toString()");
        return StringsKt.encodeToByteArray(string);
    }
}
