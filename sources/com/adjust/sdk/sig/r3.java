package com.adjust.sdk.sig;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class r3 implements w1, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h0 f158a;
    public Object b = p3.f153a;

    public r3(h0 h0Var) {
        this.f158a = h0Var;
    }

    @Override // com.adjust.sdk.sig.w1
    public final Object getValue() {
        if (this.b == p3.f153a) {
            this.b = this.f158a.a();
            this.f158a = null;
        }
        return this.b;
    }

    public final String toString() {
        return this.b != p3.f153a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
