package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzrh {
    private static final zzzn zza;
    private static final zzou<zzqf, zzpm> zzb;
    private static final zzoq<zzpm> zzc;
    private static final zznh<zzqa, zzpn> zzd;
    private static final zznd<zzpn> zze;

    /* JADX INFO: Access modifiers changed from: private */
    public static zzqa zzb(zzpn zzpnVar, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        if (!zzpnVar.zzf().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseKey");
        }
        try {
            zzsa zzsaVarZza = zzsa.zza(zzpnVar.zzd(), zzajv.zza());
            if (zzsaVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return zzqa.zzb().zza(zzqf.zzd().zza(zzsaVarZza.zze().zzb()).zzb(zzsaVarZza.zzd().zza()).zza(zza(zzpnVar.zzc())).zza()).zza(zzzo.zza(zzsaVarZza.zze().zzd(), zzcm.zza(zzcmVar))).zza(zzpnVar.zze()).zza();
        } catch (zzakm | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing AesCmacKey failed");
        }
    }

    private static zzqf.zza zza(zzxd zzxdVar) throws GeneralSecurityException {
        int i = zzro.zza[zzxdVar.ordinal()];
        if (i == 1) {
            return zzqf.zza.zza;
        }
        if (i == 2) {
            return zzqf.zza.zzb;
        }
        if (i == 3) {
            return zzqf.zza.zzc;
        }
        if (i == 4) {
            return zzqf.zza.zzd;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzxdVar.zza());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzqf zzb(zzpm zzpmVar) throws GeneralSecurityException {
        if (!zzpmVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseParameters: " + zzpmVar.zza().zzf());
        }
        try {
            zzsd zzsdVarZza = zzsd.zza(zzpmVar.zza().zze(), zzajv.zza());
            return zzqf.zzd().zza(zzsdVarZza.zza()).zzb(zzsdVarZza.zzd().zza()).zza(zza(zzpmVar.zza().zzd())).zza();
        } catch (zzakm e) {
            throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e);
        }
    }

    private static zzsg zzb(zzqf zzqfVar) {
        return (zzsg) ((zzakg) zzsg.zzb().zza(zzqfVar.zzb()).zze());
    }

    private static zzxd zza(zzqf.zza zzaVar) throws GeneralSecurityException {
        if (zzqf.zza.zza.equals(zzaVar)) {
            return zzxd.TINK;
        }
        if (zzqf.zza.zzb.equals(zzaVar)) {
            return zzxd.CRUNCHY;
        }
        if (zzqf.zza.zzd.equals(zzaVar)) {
            return zzxd.RAW;
        }
        if (zzqf.zza.zzc.equals(zzaVar)) {
            return zzxd.LEGACY;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzaVar));
    }

    static {
        zzzn zzznVarZzb = zzpy.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zza = zzznVarZzb;
        zzb = zzou.zza(new zzow() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrk
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzow
            public final zzpq zza(zzcg zzcgVar) {
                zzqf zzqfVar = (zzqf) zzcgVar;
                return zzpm.zzb((zzwf) ((zzakg) zzwf.zza().zza("type.googleapis.com/google.crypto.tink.AesCmacKey").zza(((zzsd) ((zzakg) zzsd.zzb().zza(zzrh.zzb(zzqfVar)).zza(zzqfVar.zzc()).zze())).zzj()).zza(zzrh.zza(zzqfVar.zze())).zze()));
            }
        }, zzqf.class, zzpm.class);
        zzc = zzoq.zza(new zzos() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrj
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzos
            public final zzcg zza(zzpq zzpqVar) {
                return zzrh.zzb((zzpm) zzpqVar);
            }
        }, zzznVarZzb, zzpm.class);
        zzd = zznh.zza(new zznj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrm
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznj
            public final zzpq zza(zzbo zzboVar, zzcm zzcmVar) {
                zzqa zzqaVar = (zzqa) zzboVar;
                return zzpn.zza("type.googleapis.com/google.crypto.tink.AesCmacKey", ((zzsa) ((zzakg) zzsa.zzb().zza(zzrh.zzb(zzqaVar.zzc())).zza(zzaiw.zza(zzqaVar.zze().zza(zzcm.zza(zzcmVar)))).zze())).zzj(), zzwb.zza.SYMMETRIC, zzrh.zza(zzqaVar.zzc().zze()), zzqaVar.zza());
            }
        }, zzqa.class, zzpn.class);
        zze = zznd.zza(new zznf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrl
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznf
            public final zzbo zza(zzpq zzpqVar, zzcm zzcmVar) {
                return zzrh.zzb((zzpn) zzpqVar, zzcmVar);
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
