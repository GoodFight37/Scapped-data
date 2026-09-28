package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzat<K, V> extends zzas<Map.Entry<K, V>> {
    private final transient zzan<K, V> zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    final int zza(Object[] objArr, int i) {
        return zzc().zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    final boolean zze() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzas
    final zzaj<Map.Entry<K, V>> zzg() {
        return new zzaw(this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    /* JADX INFO: renamed from: zzd */
    public final zzba<Map.Entry<K, V>> iterator() {
        return (zzba) zzc().iterator();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzas, com.google.android.gms.internal.p002firebaseauthapi.zzai, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    zzat(zzan<K, V> zzanVar, Object[] objArr, int i, int i2) {
        this.zza = zzanVar;
        this.zzb = objArr;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }
}
