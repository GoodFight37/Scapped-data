package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzakq<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzakr> zza;

    public final zzakr zza() {
        return this.zza.getValue();
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zza.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zza.getValue() == null) {
            return null;
        }
        throw new NoSuchMethodError();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof zzaln)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return this.zza.getValue().zza((zzaln) obj);
    }

    private zzakq(Map.Entry<K, zzakr> entry) {
        this.zza = entry;
    }
}
