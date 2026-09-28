package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcb {
    private static final CopyOnWriteArrayList<zzcc> zza = new CopyOnWriteArrayList<>();

    public static zzcc zza(String str) throws GeneralSecurityException {
        for (zzcc zzccVar : zza) {
            if (zzccVar.zzb(str)) {
                return zzccVar;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: " + str);
    }
}
