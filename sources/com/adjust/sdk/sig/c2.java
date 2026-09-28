package com.adjust.sdk.sig;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class c2 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f121a;
    public final Integer b;

    public c2(Class cls, Integer num) {
        this.f121a = cls;
        this.b = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c2)) {
            return false;
        }
        c2 c2Var = (c2) obj;
        return i1.a(this.f121a, c2Var.f121a) && this.b.equals(c2Var.b);
    }

    public final int hashCode() {
        Object obj = this.f121a;
        return this.b.hashCode() + ((obj == null ? 0 : obj.hashCode()) * 31);
    }

    public final String toString() {
        return "(" + this.f121a + ", " + this.b + ')';
    }
}
