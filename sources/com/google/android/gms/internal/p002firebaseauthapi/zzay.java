package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzay extends zzaj<Object> {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    final boolean zze() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzw.zza(i, this.zzc);
        return Objects.requireNonNull(this.zza[(i * 2) + this.zzb]);
    }

    zzay(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }
}
