package com.google.android.gms.internal.nearby;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzsq<E> extends zzsn<E> implements List<E>, RandomAccess {
    private static final zzsz zza = new zzso(zzsv.zza, 0);

    zzsq() {
    }

    static zzsq zzi(Object[] objArr) {
        return zzj(objArr, objArr.length);
    }

    static zzsq zzj(Object[] objArr, int i) {
        return i == 0 ? zzsv.zza : new zzsv(objArr, i);
    }

    public static zzsq zzk(Collection collection) {
        if (!(collection instanceof zzsn)) {
            Object[] array = collection.toArray();
            int length = array.length;
            zzsu.zzb(array, length);
            return zzj(array, length);
        }
        zzsq zzsqVarZzd = ((zzsn) collection).zzd();
        if (!zzsqVarZzd.zzf()) {
            return zzsqVarZzd;
        }
        Object[] array2 = zzsqVarZzd.toArray();
        return zzj(array2, array2.length);
    }

    public static zzsq zzl() {
        return zzsv.zza;
    }

    public static zzsq zzm(Object obj) {
        Object[] objArr = {obj};
        zzsu.zzb(objArr, 1);
        return zzj(objArr, 1);
    }

    public static zzsq zzn(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        zzsu.zzb(objArr, 2);
        return zzj(objArr, 2);
    }

    public static zzsq zzo(Object obj, Object obj2, Object obj3) {
        Object[] objArr = {obj, obj2, obj3};
        zzsu.zzb(objArr, 3);
        return zzj(objArr, 3);
    }

    public static zzsq zzp(Object obj, Object obj2, Object obj3, Object obj4) {
        Object[] objArr = {"..", ".", "\\", DomExceptionUtils.SEPARATOR};
        zzsu.zzb(objArr, 4);
        return zzj(objArr, 4);
    }

    public static zzsq zzq(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        Object[] objArr = {"?", "*", "\"", "|", ":", "\u0000", "\n", "\r", "\t", "\f"};
        zzsu.zzb(objArr, 10);
        return zzj(objArr, 10);
    }

    @SafeVarargs
    public static zzsq zzr(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object... objArr) {
        Object[] objArr2 = new Object[15];
        objArr2[0] = "../";
        objArr2[1] = DomExceptionUtils.SEPARATOR;
        objArr2[2] = "\\";
        objArr2[3] = "?";
        objArr2[4] = "*";
        objArr2[5] = "\"";
        objArr2[6] = "<";
        objArr2[7] = ">";
        objArr2[8] = "|";
        objArr2[9] = ":";
        objArr2[10] = "\u0000";
        objArr2[11] = "\n";
        System.arraycopy(objArr, 0, objArr2, 12, 3);
        zzsu.zzb(objArr2, 15);
        return zzj(objArr2, 15);
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
    public final boolean contains(@CheckForNull Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (zzsb.zza(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                Iterator<E> it = iterator();
                Iterator<E> it2 = list.iterator();
                while (it.hasNext()) {
                    if (it2.hasNext() && zzsb.zza(it.next(), it2.next())) {
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

    @Override // java.util.List
    public final int indexOf(@CheckForNull Object obj) {
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

    @Override // com.google.android.gms.internal.nearby.zzsn, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
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

    @Override // com.google.android.gms.internal.nearby.zzsn
    int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    @Override // com.google.android.gms.internal.nearby.zzsn
    @Deprecated
    public final zzsq zzd() {
        return this;
    }

    @Override // com.google.android.gms.internal.nearby.zzsn
    /* JADX INFO: renamed from: zze */
    public final zzsy iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public zzsq subList(int i, int i2) {
        zzsg.zzg(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        return i3 == 0 ? zzsv.zza : new zzsp(this, i, i3);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzs, reason: merged with bridge method [inline-methods] */
    public final zzsz listIterator(int i) {
        zzsg.zzb(i, size(), FirebaseAnalytics.Param.INDEX);
        return isEmpty() ? zza : new zzso(this, i);
    }
}
