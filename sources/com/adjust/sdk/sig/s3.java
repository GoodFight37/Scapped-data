package com.adjust.sdk.sig;

import android.util.Base64;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p1 f160a;

    static {
        s0 s0Var = new s0() { // from class: com.adjust.sdk.sig.s3$$ExternalSyntheticLambda0
            @Override // com.adjust.sdk.sig.s0
            public final Object a(Object obj) {
                return s3.a((l1) obj);
            }
        };
        l1 l1Var = new l1(k1.b);
        s0Var.a(l1Var);
        f160a = new p1(new n1(l1Var.f144a, l1Var.b, l1Var.c));
    }

    public static String a(b0 b0Var) {
        p1 p1Var = f160a;
        p1Var.getClass();
        a0 a0Var = a0.f114a;
        q1 q1Var = new q1();
        try {
            new z2(new y(q1Var), p1Var, t3.OBJ, new z2[t3.g.f131a.length]).a(a0Var, b0Var);
            String string = q1Var.toString();
            q1Var.a();
            byte[] bArr = w2.f163a;
            byte[] bArrA = h3.a(string);
            int length = bArrA.length;
            for (int i = 0; i < length; i++) {
                bArrA[i] = (byte) (bArrA[i] ^ bArr[i % 19]);
            }
            return Base64.encodeToString(bArrA, 2);
        } catch (Throwable th) {
            q1Var.a();
            throw th;
        }
    }

    public static final q3 a(l1 l1Var) {
        l1Var.f144a = true;
        l1Var.b = false;
        return q3.f156a;
    }
}
