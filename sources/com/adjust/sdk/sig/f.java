package com.adjust.sdk.sig;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Iterator, s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f126a;
    public int b;

    public f(Object[] objArr) {
        this.f126a = objArr;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.f126a.length;
    }

    @Override // java.util.Iterator
    public final Object next() {
        try {
            Object[] objArr = this.f126a;
            int i = this.b;
            this.b = i + 1;
            return objArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
