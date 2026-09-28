package com.adjust.sdk.sig;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class n3 implements w1, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h0 f149a;
    public volatile Object b = p3.f153a;
    public final Object c = this;

    public n3(h0 h0Var) {
        this.f149a = h0Var;
    }

    @Override // com.adjust.sdk.sig.w1
    public final Object getValue() {
        Object objA;
        Object obj = this.b;
        p3 p3Var = p3.f153a;
        if (obj != p3Var) {
            return obj;
        }
        synchronized (this.c) {
            objA = this.b;
            if (objA == p3Var) {
                objA = this.f149a.a();
                this.b = objA;
                this.f149a = null;
            }
        }
        return objA;
    }

    public final String toString() {
        return this.b != p3.f153a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
