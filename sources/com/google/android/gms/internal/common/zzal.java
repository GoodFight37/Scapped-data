package com.google.android.gms.internal.common;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzal extends zzag implements List, RandomAccess {
    private static final zzap zza = new zzai(zzan.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    zzal() {
    }

    static zzal zzj(Object[] objArr, int i) {
        return i == 0 ? zzan.zza : new zzan(objArr, i);
    }

    public static zzal zzl(Collection collection) {
        if (!(collection instanceof zzag)) {
            Object[] array = collection.toArray();
            int length = array.length;
            zzam.zza(array, length);
            return zzj(array, length);
        }
        zzal zzalVarZzd = ((zzag) collection).zzd();
        if (!zzalVarZzd.zzf()) {
            return zzalVarZzd;
        }
        Object[] array2 = zzalVarZzd.toArray();
        return zzj(array2, array2.length);
    }

    public static zzal zzm() {
        return zzan.zza;
    }

    public static zzal zzn(Object obj) {
        Object[] objArr = {obj};
        zzam.zza(objArr, 1);
        return zzj(objArr, 1);
    }

    public static zzal zzo(Object obj, Object obj2, Object obj3) {
        Object[] objArr = {obj, obj2, obj3};
        zzam.zza(objArr, 3);
        return zzj(objArr, 3);
    }

    public static zzal zzp(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        Object[] objArr = {obj, obj2, obj3, obj4, obj5, obj6};
        zzam.zza(objArr, 6);
        return zzj(objArr, 6);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (zzu.zza(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (it.hasNext()) {
                    if (it2.hasNext() && zzu.zza(it.next(), it2.next())) {
                    }
                }
                if (!it2.hasNext()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i = 0; i < size; i++) {
            iHashCode = (iHashCode * 31) + get(i).hashCode();
        }
        return iHashCode;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.common.zzag, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.common.zzag
    int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    @Override // com.google.android.gms.internal.common.zzag
    @Deprecated
    public final zzal zzd() {
        return this;
    }

    @Override // com.google.android.gms.internal.common.zzag
    /* JADX INFO: renamed from: zze */
    public final zzao iterator() {
        return listIterator(0);
    }

    public zzal zzh() {
        return size() <= 1 ? this : new zzaj(this);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public zzal subList(int i, int i2) {
        zzv.zzc(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        return i3 == 0 ? zzan.zza : new zzak(this, i, i3);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public final zzap listIterator(int i) {
        zzv.zzb(i, size(), FirebaseAnalytics.Param.INDEX);
        return isEmpty() ? zza : new zzai(this, i);
    }

    public static zzal zzk(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return zzl((Collection) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return zzan.zza;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return zzn(next);
        }
        zzah zzahVar = new zzah(4);
        zzahVar.zzb(next);
        zzahVar.zzc(it);
        return zzahVar.zzd();
    }
}
