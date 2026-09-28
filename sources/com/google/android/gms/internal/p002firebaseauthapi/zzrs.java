package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzrs {
    private static final zzzn zza;
    private static final zzmv<zzxd, zzqs.zzc> zzb;
    private static final zzmv<zzvc, zzqs.zza> zzc;
    private static final zzou<zzqs, zzpm> zzd;
    private static final zzoq<zzpm> zze;
    private static final zznh<zzql, zzpn> zzf;
    private static final zznd<zzpn> zzg;

    /* JADX INFO: Access modifiers changed from: private */
    public static zzql zzb(zzpn zzpnVar, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        if (!zzpnVar.zzf().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
        try {
            zzvb zzvbVarZza = zzvb.zza(zzpnVar.zzd(), zzajv.zza());
            if (zzvbVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return zzql.zzb().zza(zzqs.zzd().zza(zzvbVarZza.zzf().zzb()).zzb(zzvbVarZza.zze().zza()).zza(zzc.zza(zzvbVarZza.zze().zzb())).zza(zzb.zza(zzpnVar.zzc())).zza()).zza(zzzo.zza(zzvbVarZza.zzf().zzd(), zzcm.zza(zzcmVar))).zza(zzpnVar.zze()).zza();
        } catch (zzakm | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing HmacKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzqs zzb(zzpm zzpmVar) throws GeneralSecurityException {
        if (!zzpmVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: " + zzpmVar.zza().zzf());
        }
        try {
            zzve zzveVarZza = zzve.zza(zzpmVar.zza().zze(), zzajv.zza());
            if (zzveVarZza.zzb() != 0) {
                throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + zzveVarZza.zzb());
            }
            return zzqs.zzd().zza(zzveVarZza.zza()).zzb(zzveVarZza.zzf().zza()).zza(zzc.zza(zzveVarZza.zzf().zzb())).zza(zzb.zza(zzpmVar.zza().zzd())).zza();
        } catch (zzakm e) {
            throw new GeneralSecurityException("Parsing HmacParameters failed: ", e);
        }
    }

    private static zzvh zzb(zzqs zzqsVar) throws GeneralSecurityException {
        return (zzvh) ((zzakg) zzvh.zzc().zza(zzqsVar.zzb()).zza((zzvc) zzc.zza(zzqsVar.zze())).zze());
    }

    static {
        zzzn zzznVarZzb = zzpy.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zza = zzznVarZzb;
        zzb = zzmv.zza().zza(zzxd.RAW, zzqs.zzc.zzd).zza(zzxd.TINK, zzqs.zzc.zza).zza(zzxd.LEGACY, zzqs.zzc.zzc).zza(zzxd.CRUNCHY, zzqs.zzc.zzb).zza();
        zzc = zzmv.zza().zza(zzvc.SHA1, zzqs.zza.zza).zza(zzvc.SHA224, zzqs.zza.zzb).zza(zzvc.SHA256, zzqs.zza.zzc).zza(zzvc.SHA384, zzqs.zza.zzd).zza(zzvc.SHA512, zzqs.zza.zze).zza();
        zzd = zzou.zza(new zzow() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrr
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzow
            public final zzpq zza(zzcg zzcgVar) {
                zzqs zzqsVar = (zzqs) zzcgVar;
                return zzpm.zzb((zzwf) ((zzakg) zzwf.zza().zza("type.googleapis.com/google.crypto.tink.HmacKey").zza(((zzve) ((zzakg) zzve.zzc().zza(zzrs.zzb(zzqsVar)).zza(zzqsVar.zzc()).zze())).zzj()).zza((zzxd) zzrs.zzb.zza(zzqsVar.zzf())).zze()));
            }
        }, zzqs.class, zzpm.class);
        zze = zzoq.zza(new zzos() { // from class: com.google.android.gms.internal.firebase-auth-api.zzru
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzos
            public final zzcg zza(zzpq zzpqVar) {
                return zzrs.zzb((zzpm) zzpqVar);
            }
        }, zzznVarZzb, zzpm.class);
        zzf = zznh.zza(new zznj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrt
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznj
            public final zzpq zza(zzbo zzboVar, zzcm zzcmVar) {
                zzql zzqlVar = (zzql) zzboVar;
                return zzpn.zza("type.googleapis.com/google.crypto.tink.HmacKey", ((zzvb) ((zzakg) zzvb.zzb().zza(zzrs.zzb(zzqlVar.zzc())).zza(zzaiw.zza(zzqlVar.zze().zza(zzcm.zza(zzcmVar)))).zze())).zzj(), zzwb.zza.SYMMETRIC, (zzxd) zzrs.zzb.zza(zzqlVar.zzc().zzf()), zzqlVar.zza());
            }
        }, zzql.class, zzpn.class);
        zzg = zznd.zza(new zznf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrw
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznf
            public final zzbo zza(zzpq zzpqVar, zzcm zzcmVar) {
                return zzrs.zzb((zzpn) zzpqVar, zzcmVar);
            }
        }, zzznVarZzb, zzpn.class);
    }

    public static void zza() throws GeneralSecurityException {
        zzom zzomVarZza = zzom.zza();
        zzomVarZza.zza(zzd);
        zzomVarZza.zza(zze);
        zzomVarZza.zza(zzf);
        zzomVarZza.zza(zzg);
    }
}
