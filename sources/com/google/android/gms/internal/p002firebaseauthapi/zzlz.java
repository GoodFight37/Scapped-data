package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzlz implements zzbm {
    public static zzbm zza(zznn zznnVar) throws GeneralSecurityException {
        byte[] bArrZzb;
        zzpn zzpnVarZza = zznnVar.zza(zzbl.zza());
        zzbm zzbmVar = (zzbm) zzcj.zza((zzwb) ((zzakg) zzwb.zza().zza(zzpnVarZza.zzf()).zza(zzpnVarZza.zzd()).zza(zzpnVarZza.zza()).zze()), zzbm.class);
        zzxd zzxdVarZzc = zzpnVarZza.zzc();
        int i = zzly.zza[zzxdVarZzc.ordinal()];
        if (i == 1) {
            bArrZzb = zzor.zza.zzb();
        } else if (i == 2 || i == 3) {
            bArrZzb = zzor.zza(zznnVar.zza().intValue()).zzb();
        } else {
            if (i != 4) {
                throw new GeneralSecurityException("unknown output prefix type " + String.valueOf(zzxdVarZzc));
            }
            bArrZzb = zzor.zzb(zznnVar.zza().intValue()).zzb();
        }
        return new zzlz(zzbmVar, bArrZzb);
    }

    private zzlz(zzbm zzbmVar, byte[] bArr) {
    }
}
