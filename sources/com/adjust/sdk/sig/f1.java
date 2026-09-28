package com.adjust.sdk.sig;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class f1 implements Iterator, s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f128a;
    public final int b;
    public boolean c;
    public int d;

    public f1(int i, int i2, int i3) {
        this.f128a = i3;
        this.b = i2;
        boolean z = i3 <= 0 ? i >= i2 : i <= i2;
        this.c = z;
        this.d = z ? i : i2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.d;
        if (i != this.b) {
            this.d = this.f128a + i;
        } else {
            if (!this.c) {
                throw new NoSuchElementException();
            }
            this.c = false;
        }
        return Integer.valueOf(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
