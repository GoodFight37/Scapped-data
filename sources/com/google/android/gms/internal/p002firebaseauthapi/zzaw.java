package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaw<K, V> extends zzaj<Map.Entry<K, V>> {
    private final /* synthetic */ zzat zza;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    public final boolean zze() {
        return true;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        zzw.zza(i, this.zza.zzc);
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(this.zza.zzb[i2]), Objects.requireNonNull(this.zza.zzb[i2 + 1]));
    }

    zzaw(zzat zzatVar) {
        this.zza = zzatVar;
    }
}
