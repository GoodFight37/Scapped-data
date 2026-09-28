package com.google.android.gms.internal.auth;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* JADX INFO: loaded from: classes.dex */
final class zzgf {
    private static final zzgf zza = new zzgf();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzgj zzb = new zzfp();

    private zzgf() {
    }

    public static zzgf zza() {
        return zza;
    }

    public final zzgi zzb(Class cls) {
        zzfa.zzc(cls, "messageType");
        zzgi zzgiVarZza = (zzgi) this.zzc.get(cls);
        if (zzgiVarZza == null) {
            zzgiVarZza = this.zzb.zza(cls);
            zzfa.zzc(cls, "messageType");
            zzgi zzgiVar = (zzgi) this.zzc.putIfAbsent(cls, zzgiVarZza);
            if (zzgiVar != null) {
                return zzgiVar;
            }
        }
        return zzgiVarZza;
    }
}
