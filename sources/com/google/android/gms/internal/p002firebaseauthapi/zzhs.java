package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzhs implements zzbe {
    private final zzbe zza;
    private final byte[] zzb;

    public static zzbe zza(zznn zznnVar) throws GeneralSecurityException {
        byte[] bArrZzb;
        zzpn zzpnVarZza = zznnVar.zza(zzbl.zza());
        zzwb zzwbVar = (zzwb) ((zzakg) zzwb.zza().zza(zzpnVarZza.zzf()).zza(zzpnVarZza.zzd()).zza(zzpnVarZza.zza()).zze());
        zzpr.zza();
        zzbe zzbeVar = (zzbe) zzpr.zza(zzwbVar, zzbe.class);
        zzxd zzxdVarZzc = zzpnVarZza.zzc();
        int i = zzhr.zza[zzxdVarZzc.ordinal()];
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
        return new zzhs(zzbeVar, bArrZzb);
    }

    public static zzbe zza(zzbe zzbeVar, zzzn zzznVar) {
        return new zzhs(zzbeVar, zzznVar.zzb());
    }

    private zzhs(zzbe zzbeVar, byte[] bArr) {
        this.zza = zzbeVar;
        if (bArr.length != 0 && bArr.length != 5) {
            throw new IllegalArgumentException("identifier has an invalid length");
        }
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return this.zza.zza(bArr, bArr2);
        }
        if (!zzpy.zza(bArr3, bArr)) {
            throw new GeneralSecurityException("wrong prefix");
        }
        return this.zza.zza(Arrays.copyOfRange(bArr, 5, bArr.length), bArr2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return this.zza.zzb(bArr, bArr2);
        }
        return zzyc.zza(bArr3, this.zza.zzb(bArr, bArr2));
    }
}
