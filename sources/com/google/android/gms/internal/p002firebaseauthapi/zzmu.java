package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.Enum;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmu<E extends Enum<E>, O> {
    private Map<E, O> zza;
    private Map<O, E> zzb;

    public final zzmu<E, O> zza(E e, O o) {
        this.zza.put(e, o);
        this.zzb.put(o, e);
        return this;
    }

    public final zzmv<E, O> zza() {
        return new zzmv<>(Collections.unmodifiableMap(this.zza), Collections.unmodifiableMap(this.zzb));
    }

    private zzmu() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }
}
