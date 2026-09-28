package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.spec.EllipticCurve;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzkf extends zzkv {
    private final zzju zza;
    private final zzzn zzb;
    private final zzzn zzc;

    @Nullable
    private final Integer zzd;

    public final zzju zzb() {
        return this.zza;
    }

    public static zzkf zza(zzju zzjuVar, zzzn zzznVar, @Nullable Integer num) throws GeneralSecurityException {
        EllipticCurve curve;
        zzzn zzznVarZzb;
        zzju.zzf zzfVarZzf = zzjuVar.zzf();
        if (!zzfVarZzf.equals(zzju.zzf.zzc) && num == null) {
            throw new GeneralSecurityException("'idRequirement' must be non-null for " + String.valueOf(zzfVarZzf) + " variant.");
        }
        if (zzfVarZzf.equals(zzju.zzf.zzc) && num != null) {
            throw new GeneralSecurityException("'idRequirement' must be null for NO_PREFIX variant.");
        }
        zzju.zzd zzdVarZze = zzjuVar.zze();
        int iZza = zzznVar.zza();
        String str = "Encoded public key byte length for " + String.valueOf(zzdVarZze) + " must be %d, not " + iZza;
        if (zzdVarZze == zzju.zzd.zza) {
            if (iZza != 65) {
                throw new GeneralSecurityException(String.format(str, 65));
            }
        } else if (zzdVarZze == zzju.zzd.zzb) {
            if (iZza != 97) {
                throw new GeneralSecurityException(String.format(str, 97));
            }
        } else if (zzdVarZze == zzju.zzd.zzc) {
            if (iZza != 133) {
                throw new GeneralSecurityException(String.format(str, 133));
            }
        } else {
            if (zzdVarZze != zzju.zzd.zzd) {
                throw new GeneralSecurityException("Unable to validate public key length for " + String.valueOf(zzdVarZze));
            }
            if (iZza != 32) {
                throw new GeneralSecurityException(String.format(str, 32));
            }
        }
        if (zzdVarZze == zzju.zzd.zza || zzdVarZze == zzju.zzd.zzb || zzdVarZze == zzju.zzd.zzc) {
            if (zzdVarZze == zzju.zzd.zza) {
                curve = zzmt.zza.getCurve();
            } else if (zzdVarZze == zzju.zzd.zzb) {
                curve = zzmt.zzb.getCurve();
            } else {
                if (zzdVarZze != zzju.zzd.zzc) {
                    throw new IllegalArgumentException("Unable to determine NIST curve type for " + String.valueOf(zzdVarZze));
                }
                curve = zzmt.zzc.getCurve();
            }
            zzmt.zza(zzyi.zza(curve, zzyk.UNCOMPRESSED, zzznVar.zzb()), curve);
        }
        zzju.zzf zzfVarZzf2 = zzjuVar.zzf();
        if (zzfVarZzf2 == zzju.zzf.zzc) {
            zzznVarZzb = zzor.zza;
        } else {
            if (num == null) {
                throw new IllegalStateException("idRequirement must be non-null for HpkeParameters.Variant " + String.valueOf(zzfVarZzf2));
            }
            if (zzfVarZzf2 == zzju.zzf.zzb) {
                zzznVarZzb = zzor.zza(num.intValue());
            } else {
                if (zzfVarZzf2 != zzju.zzf.zza) {
                    throw new IllegalStateException("Unknown HpkeParameters.Variant: " + String.valueOf(zzfVarZzf2));
                }
                zzznVarZzb = zzor.zzb(num.intValue());
            }
        }
        return new zzkf(zzjuVar, zzznVar, zzznVarZzb, num);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkv
    public final zzzn zzc() {
        return this.zzc;
    }

    public final zzzn zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbo
    @Nullable
    public final Integer zza() {
        return this.zzd;
    }

    private zzkf(zzju zzjuVar, zzzn zzznVar, zzzn zzznVar2, @Nullable Integer num) {
        this.zza = zzjuVar;
        this.zzb = zzznVar;
        this.zzc = zzznVar2;
        this.zzd = num;
    }
}
