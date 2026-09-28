package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzkw {
    private static final byte[] zza = new byte[0];

    public static zzla zza(zzjq zzjqVar) throws GeneralSecurityException {
        zzcg zzcgVarZzb = zzjqVar.zzb();
        if (zzcgVarZzb instanceof zzdr) {
            return new zzky((zzdr) zzcgVarZzb);
        }
        if (zzcgVarZzb instanceof zzdc) {
            return new zzkz((zzdc) zzcgVarZzb);
        }
        if (zzcgVarZzb instanceof zzit) {
            return new zzlb((zzit) zzcgVarZzb);
        }
        throw new GeneralSecurityException("Unsupported DEM parameters: " + String.valueOf(zzcgVarZzb));
    }
}
