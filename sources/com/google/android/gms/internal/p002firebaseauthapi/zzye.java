package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.EllipticCurve;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzye implements zzbj {
    private final ECPrivateKey zza;
    private final zzyg zzb;
    private final String zzc;
    private final byte[] zzd;
    private final zzyk zze;
    private final zzla zzf;
    private final byte[] zzg;

    public static zzbj zza(zzjt zzjtVar) throws GeneralSecurityException {
        ECPrivateKey eCPrivateKeyZza = zzyi.zza((zzyl) zzyh.zza.zza(zzjtVar.zzc().zzd()), zzmo.zza(zzjtVar.zze().zza(zzbl.zza())));
        byte[] bArrZzb = new byte[0];
        if (zzjtVar.zzc().zzh() != null) {
            bArrZzb = zzjtVar.zzc().zzh().zzb();
        }
        return new zzye(eCPrivateKeyZza, bArrZzb, zzyh.zza(zzjtVar.zzc().zze()), (zzyk) zzyh.zzb.zza(zzjtVar.zzc().zzf()), zzkw.zza(zzjtVar.zzc()), zzjtVar.zzg().zzb());
    }

    private zzye(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzyk zzykVar, zzla zzlaVar, byte[] bArr2) {
        this.zza = eCPrivateKey;
        this.zzb = new zzyg(eCPrivateKey);
        this.zzd = bArr;
        this.zzc = str;
        this.zze = zzykVar;
        this.zzf = zzlaVar;
        this.zzg = bArr2;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0037  */
    /* JADX WARN: Code duplicated, block: B:17:0x0055  */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbj
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int i;
        int i2;
        if (!zzpy.zza(this.zzg, bArr)) {
            throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
        }
        int length = this.zzg.length;
        EllipticCurve curve = this.zza.getParams().getCurve();
        zzyk zzykVar = this.zze;
        int iZza = zzyi.zza(curve);
        int iOrdinal = zzykVar.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    throw new GeneralSecurityException("unknown EC point format");
                }
                i = iZza * 2;
            }
            i2 = i + length;
            if (bArr.length >= i2) {
                throw new GeneralSecurityException("ciphertext too short");
            }
            return this.zzf.zza(this.zzb.zza(Arrays.copyOfRange(bArr, length, i2), this.zzc, this.zzd, bArr2, this.zzf.zza(), this.zze), bArr, i2);
        }
        iZza *= 2;
        i = iZza + 1;
        i2 = i + length;
        if (bArr.length >= i2) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        return this.zzf.zza(this.zzb.zza(Arrays.copyOfRange(bArr, length, i2), this.zzc, this.zzd, bArr2, this.zzf.zza(), this.zze), bArr, i2);
    }
}
