package com.nintendo.npf.sdkbilling;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    public static String a(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            Intrinsics.checkNotNullExpressionValue(messageDigest, "{\n            MessageDig…ance(\"SHA-256\")\n        }");
            byte[] bytes = data.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            Intrinsics.checkNotNullExpressionValue(bArrDigest, "messageDigest.digest()");
            return ArraysKt.joinToString$default(bArrDigest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) b.f933a, 30, (Object) null);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
