package com.adjust.sdk.sig;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public class a implements Iterator, s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f113a;
    public final /* synthetic */ d b;

    public a(d dVar) {
        this.b = dVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f113a < this.b.a();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        d dVar = this.b;
        int i = this.f113a;
        this.f113a = i + 1;
        return dVar.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
