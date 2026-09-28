package com.adjust.sdk.sig;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends d implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f119a;
    public final int b;
    public final int c;

    public c(d dVar, int i, int i2) {
        this.f119a = dVar;
        this.b = i;
        int iA = dVar.a();
        if (i < 0 || i2 > iA) {
            throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2 + ", size: " + iA);
        }
        if (i > i2) {
            throw new IllegalArgumentException("fromIndex: " + i + " > toIndex: " + i2);
        }
        this.c = i2 - i;
    }

    @Override // com.adjust.sdk.sig.d
    public final int a() {
        return this.c;
    }

    @Override // java.util.List
    public final Object get(int i) {
        int i2 = this.c;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
        }
        return this.f119a.get(this.b + i);
    }

    @Override // com.adjust.sdk.sig.d, java.util.List
    public final List subList(int i, int i2) {
        int i3 = this.c;
        if (i < 0 || i2 > i3) {
            throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2 + ", size: " + i3);
        }
        if (i > i2) {
            throw new IllegalArgumentException("fromIndex: " + i + " > toIndex: " + i2);
        }
        d dVar = this.f119a;
        int i4 = this.b;
        return new c(dVar, i + i4, i4 + i2);
    }
}
