package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzrv implements zzcd {
    private static final byte[] zza = {0};
    private final zzcd zzb;
    private final zzxd zzc;
    private final byte[] zzd;

    public static zzcd zza(zznn zznnVar) throws GeneralSecurityException {
        byte[] bArrZzb;
        zzpn zzpnVarZza = zznnVar.zza(zzbl.zza());
        zzwb zzwbVar = (zzwb) ((zzakg) zzwb.zza().zza(zzpnVarZza.zzf()).zza(zzpnVarZza.zzd()).zza(zzpnVarZza.zza()).zze());
        zzpr.zza();
        zzcd zzcdVar = (zzcd) zzpr.zza(zzwbVar, zzcd.class);
        zzxd zzxdVarZzc = zzpnVarZza.zzc();
        int i = zzry.zza[zzxdVarZzc.ordinal()];
        if (i == 1) {
            bArrZzb = zzor.zza.zzb();
        } else if (i == 2 || i == 3) {
            bArrZzb = zzor.zza(zznnVar.zza().intValue()).zzb();
        } else {
            if (i != 4) {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            bArrZzb = zzor.zzb(zznnVar.zza().intValue()).zzb();
        }
        return new zzrv(zzcdVar, zzxdVarZzc, bArrZzb);
    }

    private zzrv(zzcd zzcdVar, zzxd zzxdVar, byte[] bArr) {
        this.zzb = zzcdVar;
        this.zzc = zzxdVar;
        this.zzd = bArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcd
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 10) {
            throw new GeneralSecurityException("tag too short");
        }
        if (this.zzc.equals(zzxd.LEGACY)) {
            bArr2 = zzyc.zza(bArr2, zza);
        }
        byte[] bArr3 = new byte[0];
        if (!this.zzc.equals(zzxd.RAW)) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
            bArr = Arrays.copyOfRange(bArr, 5, bArr.length);
            bArr3 = bArrCopyOf;
        }
        if (!Arrays.equals(this.zzd, bArr3)) {
            throw new GeneralSecurityException("wrong prefix");
        }
        this.zzb.zza(bArr, bArr2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcd
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        if (this.zzc.equals(zzxd.LEGACY)) {
            bArr = zzyc.zza(bArr, zza);
        }
        return zzyc.zza(this.zzd, this.zzb.zza(bArr));
    }
}
