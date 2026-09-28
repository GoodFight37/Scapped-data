package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzajv {
    static final zzajv zza = new zzajv(true);
    private static volatile boolean zzb = false;
    private final Map<zzaju, zzakg.zzf<?, ?>> zzc;

    public static zzajv zza() {
        return zza;
    }

    public final <ContainingType extends zzaln> zzakg.zzf<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzakg.zzf) this.zzc.get(new zzaju(containingtype, i));
    }

    zzajv() {
        this.zzc = new HashMap();
    }

    private zzajv(boolean z) {
        this.zzc = Collections.emptyMap();
    }
}
