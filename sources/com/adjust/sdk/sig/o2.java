package com.adjust.sdk.sig;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class o2 implements w1, Serializable {
    public static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(o2.class, Object.class, "b");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile h0 f152a;
    public volatile Object b = p3.f153a;

    public o2(h0 h0Var) {
        this.f152a = h0Var;
    }

    @Override // com.adjust.sdk.sig.w1
    public final Object getValue() {
        Object obj = this.b;
        p3 p3Var = p3.f153a;
        if (obj != p3Var) {
            return obj;
        }
        h0 h0Var = this.f152a;
        if (h0Var != null) {
            Object objA = h0Var.a();
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(c, this, p3Var, objA)) {
                this.f152a = null;
                return objA;
            }
        }
        return this.b;
    }

    public final String toString() {
        return this.b != p3.f153a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
