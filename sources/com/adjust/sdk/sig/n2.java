package com.adjust.sdk.sig;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class n2 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f148a;

    public n2(Throwable th) {
        this.f148a = th;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof n2) && this.f148a.equals(((n2) obj).f148a);
    }

    public final int hashCode() {
        return this.f148a.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f148a + ')';
    }
}
