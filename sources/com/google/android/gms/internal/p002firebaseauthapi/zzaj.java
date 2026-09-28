package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzaj<E> extends zzai<E> implements List<E>, RandomAccess {
    private static final zzaz<Object> zza = new zzal(zzar.zza, 0);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    @Deprecated
    public final zzaj<E> zzc() {
        return this;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~((i * 31) + get(i2).hashCode()));
        }
        return i;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (this instanceof RandomAccess) {
            int size = size();
            int i = 0;
            if (obj == null) {
                while (i < size) {
                    if (get(i) == null) {
                        return i;
                    }
                    i++;
                }
            } else {
                while (i < size) {
                    if (obj.equals(get(i))) {
                        return i;
                    }
                    i++;
                }
            }
            return -1;
        }
        ListIterator<E> listIterator = listIterator();
        while (listIterator.hasNext()) {
            if (zzp.zza(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (!(this instanceof RandomAccess)) {
            ListIterator<E> listIterator = listIterator(size());
            while (listIterator.hasPrevious()) {
                if (zzp.zza(obj, listIterator.previous())) {
                    return listIterator.nextIndex();
                }
            }
            return -1;
        }
        if (obj == null) {
            for (int size = size() - 1; size >= 0; size--) {
                if (get(size) == null) {
                    return size;
                }
            }
        } else {
            for (int size2 = size() - 1; size2 >= 0; size2--) {
                if (obj.equals(get(size2))) {
                    return size2;
                }
            }
        }
        return -1;
    }

    public static <E> zzam<E> zzg() {
        return new zzam<>();
    }

    static <E> zzaj<E> zza(Object[] objArr) {
        return zzb(objArr, objArr.length);
    }

    static <E> zzaj<E> zzb(Object[] objArr, int i) {
        if (i == 0) {
            return (zzaj<E>) zzar.zza;
        }
        return new zzar(objArr, i);
    }

    private static <E> zzaj<E> zzb(Object... objArr) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (objArr[i] == null) {
                throw new NullPointerException("at index " + i);
            }
        }
        return zzb(objArr, objArr.length);
    }

    public static <E> zzaj<E> zza(Collection<? extends E> collection) {
        if (collection instanceof zzai) {
            zzaj<E> zzajVarZzc = ((zzai) collection).zzc();
            if (!zzajVarZzc.zze()) {
                return zzajVarZzc;
            }
            Object[] array = zzajVarZzc.toArray();
            return zzb(array, array.length);
        }
        return zzb(collection.toArray());
    }

    public static <E> zzaj<E> zzh() {
        return (zzaj<E>) zzar.zza;
    }

    public static <E> zzaj<E> zza(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        return zzb(e, e2, e3, e4, e5, e6, e7, e8);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public zzaj<E> subList(int i, int i2) {
        zzw.zza(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return (zzaj<E>) zzar.zza;
        }
        return new zzao(this, i, i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    /* JADX INFO: renamed from: zzd */
    public final zzba<E> iterator() {
        return (zzaz) listIterator();
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator() {
        return (zzaz) listIterator(0);
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator(int i) {
        zzw.zzb(i, size());
        if (isEmpty()) {
            return zza;
        }
        return new zzal(this, i);
    }

    zzaj() {
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == zzw.zza(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if ((this instanceof RandomAccess) && (list instanceof RandomAccess)) {
                    for (int i = 0; i < size; i++) {
                        if (zzp.zza(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                int size2 = size();
                Iterator<E> it = list.iterator();
                int i2 = 0;
                while (i2 < size2) {
                    if (it.hasNext()) {
                        E e = get(i2);
                        i2++;
                        if (zzp.zza(e, it.next())) {
                        }
                    }
                }
                if (!it.hasNext()) {
                    return true;
                }
            }
        }
        return false;
    }
}
