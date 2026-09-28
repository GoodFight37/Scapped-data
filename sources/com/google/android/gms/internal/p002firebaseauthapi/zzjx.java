package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjx extends zzks {
    private final zzkf zza;
    private final zzzo zzb;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzks, com.google.android.gms.internal.p002firebaseauthapi.zzcf
    public final /* synthetic */ zzbo zzb() {
        return (zzkf) zzb();
    }

    public final zzju zzc() {
        return this.zza.zzb();
    }

    public static zzjx zza(zzkf zzkfVar, zzzo zzzoVar) throws GeneralSecurityException {
        ECParameterSpec eCParameterSpec;
        if (zzkfVar == null) {
            throw new GeneralSecurityException("HPKE private key cannot be constructed without an HPKE public key");
        }
        if (zzzoVar == null) {
            throw new GeneralSecurityException("HPKE private key cannot be constructed without secret");
        }
        zzju.zzd zzdVarZze = zzkfVar.zzb().zze();
        int iZza = zzzoVar.zza();
        String str = "Encoded private key byte length for " + String.valueOf(zzdVarZze) + " must be %d, not " + iZza;
        if (zzdVarZze == zzju.zzd.zza) {
            if (iZza != 32) {
                throw new GeneralSecurityException(String.format(str, 32));
            }
        } else if (zzdVarZze == zzju.zzd.zzb) {
            if (iZza != 48) {
                throw new GeneralSecurityException(String.format(str, 48));
            }
        } else if (zzdVarZze == zzju.zzd.zzc) {
            if (iZza != 66) {
                throw new GeneralSecurityException(String.format(str, 66));
            }
        } else {
            if (zzdVarZze != zzju.zzd.zzd) {
                throw new GeneralSecurityException("Unable to validate private key length for " + String.valueOf(zzdVarZze));
            }
            if (iZza != 32) {
                throw new GeneralSecurityException(String.format(str, 32));
            }
        }
        zzju.zzd zzdVarZze2 = zzkfVar.zzb().zze();
        byte[] bArrZzb = zzkfVar.zzd().zzb();
        byte[] bArrZza = zzzoVar.zza(zzbl.zza());
        if (zzdVarZze2 == zzju.zzd.zza || zzdVarZze2 == zzju.zzd.zzb || zzdVarZze2 == zzju.zzd.zzc) {
            if (zzdVarZze2 == zzju.zzd.zza) {
                eCParameterSpec = zzmt.zza;
            } else if (zzdVarZze2 == zzju.zzd.zzb) {
                eCParameterSpec = zzmt.zzb;
            } else if (zzdVarZze2 == zzju.zzd.zzc) {
                eCParameterSpec = zzmt.zzc;
            } else {
                throw new IllegalArgumentException("Unable to determine NIST curve params for " + String.valueOf(zzdVarZze2));
            }
            BigInteger order = eCParameterSpec.getOrder();
            BigInteger bigIntegerZza = zzmo.zza(bArrZza);
            if (bigIntegerZza.signum() <= 0 || bigIntegerZza.compareTo(order) >= 0) {
                throw new GeneralSecurityException("Invalid private key.");
            }
            if (!zzmt.zza(bigIntegerZza, eCParameterSpec).equals(zzyi.zza(eCParameterSpec.getCurve(), zzyk.UNCOMPRESSED, bArrZzb))) {
                throw new GeneralSecurityException("Invalid private key for public key.");
            }
        } else if (zzdVarZze2 == zzju.zzd.zzd) {
            if (!Arrays.equals(zzzl.zza(bArrZza), bArrZzb)) {
                throw new GeneralSecurityException("Invalid private key for public key.");
            }
        } else {
            throw new IllegalArgumentException("Unable to validate key pair for " + String.valueOf(zzdVarZze2));
        }
        return new zzjx(zzkfVar, zzzoVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzks
    /* JADX INFO: renamed from: zzd */
    public final /* synthetic */ zzkv zzb() {
        return this.zza;
    }

    public final zzzo zze() {
        return this.zzb;
    }

    private zzjx(zzkf zzkfVar, zzzo zzzoVar) {
        this.zza = zzkfVar;
        this.zzb = zzzoVar;
    }
}
