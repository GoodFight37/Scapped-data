package com.adjust.sdk.sig;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a implements ListIterator {
    public final /* synthetic */ d c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d dVar, int i) {
        super(dVar);
        this.c = dVar;
        int iA = dVar.a();
        if (i < 0 || i > iA) {
            throw new IndexOutOfBoundsException("index: " + i + ", size: " + iA);
        }
        this.f113a = i;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f113a > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f113a;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        d dVar = this.c;
        int i = this.f113a - 1;
        this.f113a = i;
        return dVar.get(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f113a - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
