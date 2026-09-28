package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzav<K> extends zzas<K> {
    private final transient zzan<K, ?> zza;
    private final transient zzaj<K> zzb;

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
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzas, com.google.android.gms.internal.p002firebaseauthapi.zzai
    public final zzaj<K> zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    /* JADX INFO: renamed from: zzd */
    public final zzba<K> iterator() {
        return (zzba) zzc().iterator();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzas, com.google.android.gms.internal.p002firebaseauthapi.zzai, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    zzav(zzan<K, ?> zzanVar, zzaj<K> zzajVar) {
        this.zza = zzanVar;
        this.zzb = zzajVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.get(obj) != null;
    }
}
