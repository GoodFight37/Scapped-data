package com.adjust.sdk.sig;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class k2 implements p2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f142a;
    public final j2 b;

    public k2(String str, j2 j2Var) {
        this.f142a = str;
        this.b = j2Var;
    }

    @Override // com.adjust.sdk.sig.p2
    public final String a(int i) {
        throw new IllegalStateException("Primitive descriptor " + this.f142a + " does not have elements");
    }

    @Override // com.adjust.sdk.sig.p2
    public final String b() {
        return this.f142a;
    }

    @Override // com.adjust.sdk.sig.p2
    public final t2 e() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k2)) {
            return false;
        }
        k2 k2Var = (k2) obj;
        return this.f142a.equals(k2Var.f142a) && this.b.equals(k2Var.b);
    }

    @Override // com.adjust.sdk.sig.p2
    public final int f() {
        return 0;
    }

    public final int hashCode() {
        return (this.b.toString().hashCode() * 31) + this.f142a.hashCode();
    }

    public final String toString() {
        return "PrimitiveDescriptor(" + this.f142a + ')';
    }

    @Override // com.adjust.sdk.sig.p2
    public final p2 b(int i) {
        throw new IllegalStateException("Primitive descriptor " + this.f142a + " does not have elements");
    }
}
