package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzco {
    public static zzcg zza(byte[] bArr) throws GeneralSecurityException {
        try {
            zzwf zzwfVarZza = zzwf.zza(bArr, zzajv.zza());
            zzom zzomVarZza = zzom.zza();
            zzpm zzpmVarZza = zzpm.zza(zzwfVarZza);
            return !zzomVarZza.zzc(zzpmVarZza) ? new zznp(zzpmVarZza) : zzomVarZza.zza(zzpmVarZza);
        } catch (IOException e) {
            throw new GeneralSecurityException("Failed to parse proto", e);
        }
    }

    public static byte[] zza(zzcg zzcgVar) throws GeneralSecurityException {
        if (zzcgVar instanceof zznp) {
            return ((zznp) zzcgVar).zzb().zza().zzk();
        }
        return ((zzpm) zzom.zza().zza(zzcgVar, zzpm.class)).zza().zzk();
    }
}
