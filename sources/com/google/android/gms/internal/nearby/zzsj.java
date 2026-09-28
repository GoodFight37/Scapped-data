package com.google.android.gms.internal.nearby;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
abstract class zzsj extends zzsz {
    private final int zza;
    private int zzb;

    protected zzsj(int i, int i2) {
        zzsg.zzb(i2, i, FirebaseAnalytics.Param.INDEX);
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.zzb < this.zza;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zzb > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.zzb;
        this.zzb = i + 1;
        return zza(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzb;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.zzb - 1;
        this.zzb = i;
        return zza(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzb - 1;
    }

    protected abstract Object zza(int i);
}
