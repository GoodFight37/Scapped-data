package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzamj<K, V> implements Iterator<Map.Entry<K, V>> {
    private int zza;
    private Iterator<Map.Entry<K, V>> zzb;
    private final /* synthetic */ zzamh zzc;

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        if (zza().hasNext()) {
            return zza().next();
        }
        Object[] objArr = this.zzc.zza;
        int i = this.zza - 1;
        this.zza = i;
        return (zzaml) objArr[i];
    }

    private final Iterator<Map.Entry<K, V>> zza() {
        if (this.zzb == null) {
            this.zzb = this.zzc.zzf.entrySet().iterator();
        }
        return this.zzb;
    }

    private zzamj(zzamh zzamhVar) {
        this.zzc = zzamhVar;
        this.zza = zzamhVar.zzb;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zza;
        return (i > 0 && i <= this.zzc.zzb) || zza().hasNext();
    }
}
