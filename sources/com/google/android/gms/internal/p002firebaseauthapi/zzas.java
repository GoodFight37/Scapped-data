package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzas<E> extends zzai<E> implements Set<E> {
    private transient zzaj<E> zza;

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzax.zza(this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    public zzaj<E> zzc() {
        zzaj<E> zzajVar = this.zza;
        if (zzajVar != null) {
            return zzajVar;
        }
        zzaj<E> zzajVarZzg = zzg();
        this.zza = zzajVarZzg;
        return zzajVarZzg;
    }

    zzaj<E> zzg() {
        return zzaj.zza(toArray());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    zzas() {
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return zzax.zza(this, obj);
    }
}
