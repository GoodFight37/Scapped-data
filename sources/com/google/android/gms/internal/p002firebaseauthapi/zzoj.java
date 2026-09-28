package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzoj {
    private static final zzoj zza = new zzoj();
    private static final zzoi zzb = new zzoi();
    private final AtomicReference<zzns> zzc = new AtomicReference<>();

    public final zzns zza() {
        zzns zznsVar = this.zzc.get();
        return zznsVar == null ? zzb : zznsVar;
    }

    public static zzoj zzb() {
        return zza;
    }
}
