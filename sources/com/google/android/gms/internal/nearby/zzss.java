package com.google.android.gms.internal.nearby;

import com.google.common.primitives.Ints;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzss extends zzsn implements Set {

    @CheckForNull
    private transient zzsq zza;

    zzss() {
    }

    static int zzh(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            if (iMax < 1073741824) {
                return Ints.MAX_POWER_OF_TWO;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzss) && zzk() && ((zzss) obj).zzk() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    @Override // com.google.android.gms.internal.nearby.zzsn
    public zzsq zzd() {
        zzsq zzsqVar = this.zza;
        if (zzsqVar != null) {
            return zzsqVar;
        }
        zzsq zzsqVarZzi = zzi();
        this.zza = zzsqVarZzi;
        return zzsqVarZzi;
    }

    @Override // com.google.android.gms.internal.nearby.zzsn, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zze */
    public abstract zzsy iterator();

    zzsq zzi() {
        return zzsq.zzi(toArray());
    }

    boolean zzk() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzss zzl(int i, Object... objArr) {
        if (i == 0) {
            return zzsw.zza;
        }
        if (i == 1) {
            Object obj = objArr[0];
            obj.getClass();
            return new zzsx(obj);
        }
        int iZzh = zzh(i);
        Object[] objArr2 = new Object[iZzh];
        int i2 = iZzh - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj2 = objArr[i5];
            zzsu.zza(obj2, i5);
            int iHashCode = obj2.hashCode();
            int iZza = zzsk.zza(iHashCode);
            while (true) {
                int i6 = iZza & i2;
                Object obj3 = objArr2[i6];
                if (obj3 == null) {
                    objArr[i4] = obj2;
                    objArr2[i6] = obj2;
                    i3 += iHashCode;
                    i4++;
                    break;
                }
                if (obj3.equals(obj2)) {
                    break;
                }
                iZza++;
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            Object obj4 = objArr[0];
            obj4.getClass();
            return new zzsx(obj4);
        }
        if (zzh(i4) < iZzh / 2) {
            return zzl(i4, objArr);
        }
        int length = objArr.length;
        if (i4 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new zzsw(objArr, i3, objArr2, i2, i4);
    }
}
