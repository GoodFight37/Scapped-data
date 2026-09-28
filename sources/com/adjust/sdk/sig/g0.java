package com.adjust.sdk.sig;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 extends d implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Enum[] f131a;

    public g0(Enum[] enumArr) {
        this.f131a = enumArr;
    }

    @Override // com.adjust.sdk.sig.d
    public final int a() {
        return this.f131a.length;
    }

    @Override // com.adjust.sdk.sig.d, java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r5 = (Enum) obj;
        Enum[] enumArr = this.f131a;
        int iOrdinal = r5.ordinal();
        return ((iOrdinal < 0 || iOrdinal >= enumArr.length) ? null : enumArr[iOrdinal]) == r5;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Enum[] enumArr = this.f131a;
        int length = enumArr.length;
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException("index: " + i + ", size: " + length);
        }
        return enumArr[i];
    }

    @Override // com.adjust.sdk.sig.d, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r5 = (Enum) obj;
        int iOrdinal = r5.ordinal();
        Enum[] enumArr = this.f131a;
        if (((iOrdinal < 0 || iOrdinal >= enumArr.length) ? null : enumArr[iOrdinal]) == r5) {
            return iOrdinal;
        }
        return -1;
    }

    @Override // com.adjust.sdk.sig.d, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r5 = (Enum) obj;
        int iOrdinal = r5.ordinal();
        Enum[] enumArr = this.f131a;
        if (((iOrdinal < 0 || iOrdinal >= enumArr.length) ? null : enumArr[iOrdinal]) == r5) {
            return iOrdinal;
        }
        return -1;
    }
}
