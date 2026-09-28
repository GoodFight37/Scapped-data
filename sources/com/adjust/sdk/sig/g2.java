package com.adjust.sdk.sig;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g2 {
    public static final CharSequence a(p2 p2Var, int i) {
        return p2Var.a(i) + ": " + p2Var.b(i).b();
    }

    public static final String a(final f2 f2Var) {
        return p.a(new g1(0, 1), "com.adjust.sdk.sig.755f89ae93acbe52c30f8a09(", ")", new s0() { // from class: com.adjust.sdk.sig.g2$$ExternalSyntheticLambda0
            @Override // com.adjust.sdk.sig.s0
            public final Object a(Object obj) {
                return g2.a(f2Var, ((Integer) obj).intValue());
            }
        });
    }
}
