package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzoh {
    private static final zzoh zza = new zzoh();
    private final Map<Class<? extends zzcg>, zzog<? extends zzcg>> zzb = new HashMap();

    public static zzoh zza() {
        return zza;
    }

    public final synchronized <ParametersT extends zzcg> void zza(zzog<ParametersT> zzogVar, Class<ParametersT> cls) throws GeneralSecurityException {
        zzog<? extends zzcg> zzogVar2 = this.zzb.get(cls);
        if (zzogVar2 != null && !zzogVar2.equals(zzogVar)) {
            throw new GeneralSecurityException("Different key creator for parameters class already inserted");
        }
        this.zzb.put(cls, zzogVar);
    }
}
