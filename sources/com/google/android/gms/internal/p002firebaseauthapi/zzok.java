package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzok {
    private static final zzok zza = new zzok();
    private final Map<String, zzcg> zzb = new HashMap();

    public static zzok zza() {
        return zza;
    }

    zzok() {
    }

    private final synchronized void zza(String str, zzcg zzcgVar) throws GeneralSecurityException {
        if (this.zzb.containsKey(str)) {
            if (this.zzb.get(str).equals(zzcgVar)) {
                return;
            }
            throw new GeneralSecurityException("Parameters object with name " + str + " already exists (" + String.valueOf(this.zzb.get(str)) + "), cannot insert " + String.valueOf(zzcgVar));
        }
        this.zzb.put(str, zzcgVar);
    }

    public final synchronized void zza(Map<String, zzcg> map) throws GeneralSecurityException {
        for (Map.Entry<String, zzcg> entry : map.entrySet()) {
            zza(entry.getKey(), entry.getValue());
        }
    }
}
