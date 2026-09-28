package com.adjust.sdk.sig;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class h1 implements t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h1 f134a = new h1();
    public static final k2 b = new k2("kotlin.Int", h2.f135a);

    @Override // com.adjust.sdk.sig.t1
    public final void a(z2 z2Var, Object obj) {
        int iIntValue = ((Number) obj).intValue();
        if (z2Var.f) {
            z2Var.a(String.valueOf(iIntValue));
        } else {
            z2Var.f167a.f164a.a(String.valueOf(iIntValue));
        }
    }

    @Override // com.adjust.sdk.sig.t1
    public final p2 a() {
        return b;
    }
}
