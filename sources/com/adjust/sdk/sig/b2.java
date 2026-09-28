package com.adjust.sdk.sig;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class b2 implements t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t1 f117a;
    public final q2 b;

    public b2(t1 t1Var) {
        this.f117a = t1Var;
        this.b = new q2(t1Var.a());
    }

    @Override // com.adjust.sdk.sig.t1
    public final p2 a() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && b2.class == obj.getClass() && this.f117a.equals(((b2) obj).f117a);
    }

    public final int hashCode() {
        return this.f117a.hashCode();
    }

    @Override // com.adjust.sdk.sig.t1
    public final void a(z2 z2Var, Object obj) {
        if (obj != null) {
            z2Var.a(this.f117a, obj);
        } else {
            z2Var.f167a.f164a.a("null");
        }
    }
}
