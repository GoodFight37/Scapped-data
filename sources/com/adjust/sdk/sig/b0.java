package com.adjust.sdk.sig;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f116a = null;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b0) && i1.a(this.f116a, ((b0) obj).f116a);
    }

    public final int hashCode() {
        Integer num = this.f116a;
        return (-933324943) + (num == null ? 0 : num.hashCode());
    }

    public final String toString() {
        return "Data(osName=android, battery=" + this.f116a + ')';
    }
}
