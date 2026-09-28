package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzar<E> extends zzaj<E> {
    static final zzaj<Object> zza = new zzar(new Object[0], 0);
    private final transient Object[] zzb;
    private final transient int zzc;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaj, com.google.android.gms.internal.p002firebaseauthapi.zzai
    final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, i, this.zzc);
        return i + this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    final int zzb() {
        return 0;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    final boolean zze() {
        return false;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    final int zza() {
        return this.zzc;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzw.zza(i, this.zzc);
        return (E) Objects.requireNonNull(this.zzb[i]);
    }

    zzar(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    final Object[] zzf() {
        return this.zzb;
    }
}
