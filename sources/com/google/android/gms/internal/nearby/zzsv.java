package com.google.android.gms.internal.nearby;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzsv extends zzsq {
    static final zzsq zza = new zzsv(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzsv(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzsg.zza(i, this.zzc, FirebaseAnalytics.Param.INDEX);
        Object obj = this.zzb[i];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.nearby.zzsq, com.google.android.gms.internal.nearby.zzsn
    final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.nearby.zzsn
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.nearby.zzsn
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.nearby.zzsn
    final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.nearby.zzsn
    final Object[] zzg() {
        return this.zzb;
    }
}
