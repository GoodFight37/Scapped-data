package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzai<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zza = new Object[0];

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean contains(Object obj);

    int zza(Object[] objArr, int i) {
        zzba zzbaVar = (zzba) iterator();
        while (zzbaVar.hasNext()) {
            objArr[i] = zzbaVar.next();
            i++;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public abstract zzba<E> iterator();

    abstract boolean zze();

    Object[] zzf() {
        return null;
    }

    int zza() {
        throw new UnsupportedOperationException();
    }

    int zzb() {
        throw new UnsupportedOperationException();
    }

    public zzaj<E> zzc() {
        return isEmpty() ? zzaj.zzh() : zzaj.zza(toArray());
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this, 1296);
    }

    zzai() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        zzw.zza(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] objArrZzf = zzf();
            if (objArrZzf != null) {
                return (T[]) Arrays.copyOfRange(objArrZzf, zzb(), zza(), tArr.getClass());
            }
            if (tArr.length != 0) {
                tArr = (T[]) Arrays.copyOf(tArr, 0);
            }
            tArr = (T[]) Arrays.copyOf(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }
}
