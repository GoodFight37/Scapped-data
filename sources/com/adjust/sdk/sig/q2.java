package com.adjust.sdk.sig;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class q2 implements p2, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p2 f155a;
    public final String b;
    public final Set c;

    public q2(p2 p2Var) {
        Set setC;
        this.f155a = p2Var;
        this.b = p2Var.b() + '?';
        if (p2Var instanceof i) {
            setC = ((i) p2Var).c();
        } else {
            HashSet hashSet = new HashSet(p2Var.f());
            int iF = p2Var.f();
            for (int i = 0; i < iF; i++) {
                hashSet.add(p2Var.a(i));
            }
            setC = hashSet;
        }
        this.c = setC;
    }

    @Override // com.adjust.sdk.sig.p2
    public final String a(int i) {
        return this.f155a.a(i);
    }

    @Override // com.adjust.sdk.sig.p2
    public final p2 b(int i) {
        return this.f155a.b(i);
    }

    @Override // com.adjust.sdk.sig.i
    public final Set c() {
        return this.c;
    }

    @Override // com.adjust.sdk.sig.p2
    public final boolean d() {
        return true;
    }

    @Override // com.adjust.sdk.sig.p2
    public final t2 e() {
        return this.f155a.e();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof q2) && i1.a(this.f155a, ((q2) obj).f155a);
    }

    @Override // com.adjust.sdk.sig.p2
    public final int f() {
        return this.f155a.f();
    }

    @Override // com.adjust.sdk.sig.p2
    public final List getAnnotations() {
        return this.f155a.getAnnotations();
    }

    public final int hashCode() {
        return this.f155a.hashCode() * 31;
    }

    public final String toString() {
        return new StringBuilder().append(this.f155a).append('?').toString();
    }

    @Override // com.adjust.sdk.sig.p2
    public final boolean a() {
        return this.f155a.a();
    }

    @Override // com.adjust.sdk.sig.p2
    public final String b() {
        return this.b;
    }
}
