package com.google.android.gms.internal.p002firebaseauthapi;

import com.adjust.sdk.Constants;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzcn {
    public static zzwo zza(zzwl zzwlVar) {
        zzwo.zzb zzbVarZza = zzwo.zza().zza(zzwlVar.zzb());
        for (zzwl.zza zzaVar : zzwlVar.zze()) {
            zzbVarZza.zza((zzwo.zza) ((zzakg) zzwo.zza.zza().zza(zzaVar.zzb().zzf()).zza(zzaVar.zzc()).zza(zzaVar.zzf()).zza(zzaVar.zza()).zze()));
        }
        return (zzwo) ((zzakg) zzbVarZza.zze());
    }

    static {
        Charset.forName(Constants.ENCODING);
    }

    public static void zzb(zzwl zzwlVar) throws GeneralSecurityException {
        int iZzb = zzwlVar.zzb();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzwl.zza zzaVar : zzwlVar.zze()) {
            if (zzaVar.zzc() == zzwc.ENABLED) {
                if (!zzaVar.zzg()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzaVar.zza())));
                }
                if (zzaVar.zzf() == zzxd.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzaVar.zza())));
                }
                if (zzaVar.zzc() == zzwc.UNKNOWN_STATUS) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzaVar.zza())));
                }
                if (zzaVar.zza() == iZzb) {
                    if (z) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z = true;
                }
                if (zzaVar.zzb().zzb() != zzwb.zza.ASYMMETRIC_PUBLIC) {
                    z2 = false;
                }
                i++;
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
