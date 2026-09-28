package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzga {
    private static final zzzn zza;
    private static final zzou<zzdc, zzpm> zzb;
    private static final zzoq<zzpm> zzc;
    private static final zznh<zzcx, zzpn> zzd;
    private static final zznd<zzpn> zze;

    /* JADX INFO: Access modifiers changed from: private */
    public static zzcx zzb(zzpn zzpnVar, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        if (!zzpnVar.zzf().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
        }
        try {
            zzsj zzsjVarZza = zzsj.zza(zzpnVar.zzd(), zzajv.zza());
            if (zzsjVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            if (zzsjVarZza.zzd().zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
            }
            if (zzsjVarZza.zze().zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
            }
            return zzcx.zzb().zza(zzdc.zzf().zza(zzsjVarZza.zzd().zzf().zzb()).zzb(zzsjVarZza.zze().zzf().zzb()).zzc(zzsjVarZza.zzd().zze().zza()).zzd(zzsjVarZza.zze().zze().zza()).zza(zza(zzsjVarZza.zze().zze().zzb())).zza(zza(zzpnVar.zzc())).zza()).zza(zzzo.zza(zzsjVarZza.zzd().zzf().zzd(), zzcm.zza(zzcmVar))).zzb(zzzo.zza(zzsjVarZza.zze().zzf().zzd(), zzcm.zza(zzcmVar))).zza(zzpnVar.zze()).zza();
        } catch (zzakm unused) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
        }
    }

    private static zzdc.zza zza(zzvc zzvcVar) throws GeneralSecurityException {
        int i = zzgg.zzb[zzvcVar.ordinal()];
        if (i == 1) {
            return zzdc.zza.zza;
        }
        if (i == 2) {
            return zzdc.zza.zzb;
        }
        if (i == 3) {
            return zzdc.zza.zzc;
        }
        if (i == 4) {
            return zzdc.zza.zzd;
        }
        if (i == 5) {
            return zzdc.zza.zze;
        }
        throw new GeneralSecurityException("Unable to parse HashType: " + zzvcVar.zza());
    }

    private static zzdc.zzc zza(zzxd zzxdVar) throws GeneralSecurityException {
        int i = zzgg.zza[zzxdVar.ordinal()];
        if (i == 1) {
            return zzdc.zzc.zza;
        }
        if (i == 2 || i == 3) {
            return zzdc.zzc.zzb;
        }
        if (i == 4) {
            return zzdc.zzc.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzxdVar.zza());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzdc zzb(zzpm zzpmVar) throws GeneralSecurityException {
        if (!zzpmVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: " + zzpmVar.zza().zzf());
        }
        try {
            zzsm zzsmVarZza = zzsm.zza(zzpmVar.zza().zze(), zzajv.zza());
            if (zzsmVarZza.zzd().zzb() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return zzdc.zzf().zza(zzsmVarZza.zzc().zza()).zzb(zzsmVarZza.zzd().zza()).zzc(zzsmVarZza.zzc().zze().zza()).zzd(zzsmVarZza.zzd().zzf().zza()).zza(zza(zzsmVarZza.zzd().zzf().zzb())).zza(zza(zzpmVar.zza().zzd())).zza();
        } catch (zzakm e) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e);
        }
    }

    private static zzvh zzb(zzdc zzdcVar) throws GeneralSecurityException {
        zzvc zzvcVar;
        zzvh.zza zzaVarZza = zzvh.zzc().zza(zzdcVar.zze());
        zzdc.zza zzaVarZzg = zzdcVar.zzg();
        if (zzdc.zza.zza.equals(zzaVarZzg)) {
            zzvcVar = zzvc.SHA1;
        } else if (zzdc.zza.zzb.equals(zzaVarZzg)) {
            zzvcVar = zzvc.SHA224;
        } else if (zzdc.zza.zzc.equals(zzaVarZzg)) {
            zzvcVar = zzvc.SHA256;
        } else if (zzdc.zza.zzd.equals(zzaVarZzg)) {
            zzvcVar = zzvc.SHA384;
        } else if (zzdc.zza.zze.equals(zzaVarZzg)) {
            zzvcVar = zzvc.SHA512;
        } else {
            throw new GeneralSecurityException("Unable to serialize HashType " + String.valueOf(zzaVarZzg));
        }
        return (zzvh) ((zzakg) zzaVarZza.zza(zzvcVar).zze());
    }

    private static zzxd zza(zzdc.zzc zzcVar) throws GeneralSecurityException {
        if (zzdc.zzc.zza.equals(zzcVar)) {
            return zzxd.TINK;
        }
        if (zzdc.zzc.zzb.equals(zzcVar)) {
            return zzxd.CRUNCHY;
        }
        if (zzdc.zzc.zzc.equals(zzcVar)) {
            return zzxd.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzcVar));
    }

    static {
        zzzn zzznVarZzb = zzpy.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zza = zzznVarZzb;
        zzb = zzou.zza(new zzow() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgc
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzow
            public final zzpq zza(zzcg zzcgVar) {
                zzdc zzdcVar = (zzdc) zzcgVar;
                return zzpm.zzb((zzwf) ((zzakg) zzwf.zza().zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey").zza(((zzsm) ((zzakg) zzsm.zza().zza((zzss) ((zzakg) zzss.zzb().zza((zzsv) ((zzakg) zzsv.zzb().zza(zzdcVar.zzd()).zze())).zza(zzdcVar.zzb()).zze())).zza((zzve) ((zzakg) zzve.zzc().zza(zzga.zzb(zzdcVar)).zza(zzdcVar.zzc()).zze())).zze())).zzj()).zza(zzga.zza(zzdcVar.zzh())).zze()));
            }
        }, zzdc.class, zzpm.class);
        zzc = zzoq.zza(new zzos() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgb
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzos
            public final zzcg zza(zzpq zzpqVar) {
                return zzga.zzb((zzpm) zzpqVar);
            }
        }, zzznVarZzb, zzpm.class);
        zzd = zznh.zza(new zznj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzge
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznj
            public final zzpq zza(zzbo zzboVar, zzcm zzcmVar) {
                zzcx zzcxVar = (zzcx) zzboVar;
                return zzpn.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", ((zzsj) ((zzakg) zzsj.zzb().zza((zzsp) ((zzakg) zzsp.zzb().zza((zzsv) ((zzakg) zzsv.zzb().zza(zzcxVar.zzc().zzd()).zze())).zza(zzaiw.zza(zzcxVar.zze().zza(zzcm.zza(zzcmVar)))).zze())).zza((zzvb) ((zzakg) zzvb.zzb().zza(zzga.zzb(zzcxVar.zzc())).zza(zzaiw.zza(zzcxVar.zzf().zza(zzcm.zza(zzcmVar)))).zze())).zze())).zzj(), zzwb.zza.SYMMETRIC, zzga.zza(zzcxVar.zzc().zzh()), zzcxVar.zza());
            }
        }, zzcx.class, zzpn.class);
        zze = zznd.zza(new zznf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgd
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznf
            public final zzbo zza(zzpq zzpqVar, zzcm zzcmVar) {
                return zzga.zzb((zzpn) zzpqVar, zzcmVar);
            }
        }, zzznVarZzb, zzpn.class);
    }

    public static void zza() throws GeneralSecurityException {
        zzom zzomVarZza = zzom.zza();
        zzomVarZza.zza(zzb);
        zzomVarZza.zza(zzc);
        zzomVarZza.zza(zzd);
        zzomVarZza.zza(zze);
    }
}
