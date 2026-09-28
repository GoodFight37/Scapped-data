package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzlm implements zzbm {
    public static zzbm zza(zzkf zzkfVar) throws GeneralSecurityException {
        zzju zzjuVarZzb = zzkfVar.zzb();
        return new zzlm(zzkfVar.zzd(), zza(zzjuVarZzb.zze()), zza(zzjuVarZzb.zzd()), zza(zzjuVarZzb.zzb()), zzkfVar.zzc());
    }

    static zzll zza(zzju.zza zzaVar) throws GeneralSecurityException {
        if (zzaVar.equals(zzju.zza.zza)) {
            return new zzku(16);
        }
        if (zzaVar.equals(zzju.zza.zzb)) {
            return new zzku(32);
        }
        if (zzaVar.equals(zzju.zza.zzc)) {
            return new zzkx();
        }
        throw new GeneralSecurityException("Unrecognized HPKE AEAD identifier");
    }

    static zzlp zza(zzju.zze zzeVar) throws GeneralSecurityException {
        if (zzeVar.equals(zzju.zze.zza)) {
            return new zzli("HmacSha256");
        }
        if (zzeVar.equals(zzju.zze.zzb)) {
            return new zzli("HmacSha384");
        }
        if (zzeVar.equals(zzju.zze.zzc)) {
            return new zzli("HmacSha512");
        }
        throw new GeneralSecurityException("Unrecognized HPKE KDF identifier");
    }

    static zzlo zza(zzju.zzd zzdVar) throws GeneralSecurityException {
        if (zzdVar.equals(zzju.zzd.zzd)) {
            return new zzme(new zzli("HmacSha256"));
        }
        if (zzdVar.equals(zzju.zzd.zza)) {
            return zzmb.zza(zzyl.NIST_P256);
        }
        if (zzdVar.equals(zzju.zzd.zzb)) {
            return zzmb.zza(zzyl.NIST_P384);
        }
        if (zzdVar.equals(zzju.zzd.zzc)) {
            return zzmb.zza(zzyl.NIST_P521);
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    private zzlm(zzzn zzznVar, zzlo zzloVar, zzlp zzlpVar, zzll zzllVar, zzzn zzznVar2) {
        zzznVar.zzb();
        zzznVar2.zzb();
    }
}
