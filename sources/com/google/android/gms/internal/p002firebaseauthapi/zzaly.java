package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaly {
    private static final zzaly zza = new zzaly();
    private final ConcurrentMap<Class<?>, zzamc<?>> zzc = new ConcurrentHashMap();
    private final zzamf zzb = new zzalb();

    public static zzaly zza() {
        return zza;
    }

    public final <T> zzamc<T> zza(Class<T> cls) {
        zzaki.zza(cls, "messageType");
        zzamc<T> zzamcVar = (zzamc) this.zzc.get(cls);
        if (zzamcVar != null) {
            return zzamcVar;
        }
        zzamc<T> zzamcVarZza = this.zzb.zza(cls);
        zzaki.zza(cls, "messageType");
        zzaki.zza(zzamcVarZza, "schema");
        zzamc<T> zzamcVar2 = (zzamc) this.zzc.putIfAbsent(cls, zzamcVarZza);
        return zzamcVar2 != null ? zzamcVar2 : zzamcVarZza;
    }

    public final <T> zzamc<T> zza(T t) {
        return zza((Class) t.getClass());
    }

    private zzaly() {
    }
}
