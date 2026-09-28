package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzld {
    private static final zzzn zza;
    private static final zzzn zzb;
    private static final zzou<zzjq, zzpm> zzc;
    private static final zzoq<zzpm> zzd;
    private static final zznh<zzjs, zzpn> zze;
    private static final zznd<zzpn> zzf;
    private static final zznh<zzjt, zzpn> zzg;
    private static final zznd<zzpn> zzh;
    private static final zzmv<zzxd, zzjq.zze> zzi;
    private static final zzmv<zzvc, zzjq.zzd> zzj;
    private static final zzmv<zzuw, zzjq.zza> zzk;
    private static final zzmv<zzuf, zzjq.zzc> zzl;

    private static int zza(zzjq.zza zzaVar) throws GeneralSecurityException {
        if (zzjq.zza.zza.equals(zzaVar)) {
            return 33;
        }
        if (zzjq.zza.zzb.equals(zzaVar)) {
            return 49;
        }
        if (zzjq.zza.zzc.equals(zzaVar)) {
            return 67;
        }
        throw new GeneralSecurityException("Unable to serialize CurveType " + String.valueOf(zzaVar));
    }

    private static zzjq zza(zzxd zzxdVar, zzuk zzukVar) throws GeneralSecurityException {
        zzjq.zzb zzbVarZza = zzjq.zzc().zza(zzi.zza(zzxdVar)).zza(zzk.zza(zzukVar.zzf().zzd())).zza(zzj.zza(zzukVar.zzf().zze())).zza(zzco.zza(((zzwf) ((zzakg) zzwf.zza().zza(zzukVar.zzb().zzd().zzf()).zza(zzxd.RAW).zza(zzukVar.zzb().zzd().zze()).zze())).zzk())).zza(zzzn.zza(zzukVar.zzf().zzf().zzd()));
        if (!zzukVar.zzf().zzd().equals(zzuw.CURVE25519)) {
            zzbVarZza.zza(zzl.zza(zzukVar.zza()));
        } else if (!zzukVar.zza().equals(zzuf.COMPRESSED)) {
            throw new GeneralSecurityException("For CURVE25519 EcPointFormat must be compressed");
        }
        return zzbVarZza.zza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzjq zzb(zzpm zzpmVar) throws GeneralSecurityException {
        if (!zzpmVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parseParameters: " + zzpmVar.zza().zzf());
        }
        try {
            return zza(zzpmVar.zza().zzd(), zzuh.zza(zzpmVar.zza().zze(), zzajv.zza()).zzc());
        } catch (zzakm e) {
            throw new GeneralSecurityException("Parsing EciesParameters failed: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzjt zzc(zzpn zzpnVar, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        if (!zzpnVar.zzf().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parsePrivateKey: " + zzpnVar.zzf());
        }
        try {
            zzun zzunVarZza = zzun.zza(zzpnVar.zzd(), zzajv.zza());
            if (zzunVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzuq zzuqVarZzd = zzunVarZza.zzd();
            if (zzuqVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzjq zzjqVarZza = zza(zzpnVar.zzc(), zzuqVarZzd.zzb());
            if (zzjqVarZza.zzd().equals(zzjq.zza.zzd)) {
                return zzjt.zza(zzjs.zza(zzjqVarZza, zzzn.zza(zzuqVarZzd.zzf().zzd()), zzpnVar.zze()), zzzo.zza(zzunVarZza.zze().zzd(), zzcm.zza(zzcmVar)));
            }
            return zzjt.zza(zzjs.zza(zzjqVarZza, new ECPoint(zzmo.zza(zzuqVarZzd.zzf().zzd()), zzmo.zza(zzuqVarZzd.zzg().zzd())), zzpnVar.zze()), zzzm.zza(zzmo.zza(zzunVarZza.zze().zzd()), zzcm.zza(zzcmVar)));
        } catch (zzakm | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing EcdsaPrivateKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzjs zzd(zzpn zzpnVar, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        if (!zzpnVar.zzf().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parsePublicKey: " + zzpnVar.zzf());
        }
        try {
            zzuq zzuqVarZza = zzuq.zza(zzpnVar.zzd(), zzajv.zza());
            if (zzuqVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzjq zzjqVarZza = zza(zzpnVar.zzc(), zzuqVarZza.zzb());
            if (zzjqVarZza.zzd().equals(zzjq.zza.zzd)) {
                if (zzuqVarZza.zzg().zzb() != 0) {
                    throw new GeneralSecurityException("Y must be empty for X25519 points");
                }
                return zzjs.zza(zzjqVarZza, zzzn.zza(zzuqVarZza.zzf().zzd()), zzpnVar.zze());
            }
            return zzjs.zza(zzjqVarZza, new ECPoint(zzmo.zza(zzuqVarZza.zzf().zzd()), zzmo.zza(zzuqVarZza.zzg().zzd())), zzpnVar.zze());
        } catch (zzakm | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing EcdsaPublicKey failed");
        }
    }

    public static /* synthetic */ zzpn zza(zzjt zzjtVar, zzcm zzcmVar) throws GeneralSecurityException {
        zzun.zza zzaVarZza = zzun.zzb().zza(0).zza(zza((zzjs) ((zzkv) zzjtVar.zzb())));
        if (zzjtVar.zzc().zzd().equals(zzjq.zza.zzd)) {
            zzaVarZza.zza(zzaiw.zza(zzjtVar.zzf().zza(zzcm.zza(zzcmVar))));
        } else {
            zzaVarZza.zza(zzaiw.zza(zzmo.zza(zzjtVar.zze().zza(zzcm.zza(zzcmVar)), zza(zzjtVar.zzc().zzd()))));
        }
        return zzpn.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", ((zzun) ((zzakg) zzaVarZza.zze())).zzj(), zzwb.zza.ASYMMETRIC_PRIVATE, (zzxd) zzi.zza(zzjtVar.zzc().zzg()), zzjtVar.zza());
    }

    private static zzuk zzb(zzjq zzjqVar) throws GeneralSecurityException {
        zzut.zza zzaVarZza = zzut.zza().zza((zzuw) zzk.zza(zzjqVar.zzd())).zza((zzvc) zzj.zza(zzjqVar.zze()));
        if (zzjqVar.zzh() != null && zzjqVar.zzh().zza() > 0) {
            zzaVarZza.zza(zzaiw.zza(zzjqVar.zzh().zzb()));
        }
        zzut zzutVar = (zzut) ((zzakg) zzaVarZza.zze());
        try {
            zzwf zzwfVarZza = zzwf.zza(zzco.zza(zzjqVar.zzb()), zzajv.zza());
            zzue zzueVar = (zzue) ((zzakg) zzue.zza().zza((zzwf) ((zzakg) zzwf.zza().zza(zzwfVarZza.zzf()).zza(zzxd.TINK).zza(zzwfVarZza.zze()).zze())).zze());
            zzjq.zzc zzcVarZzf = zzjqVar.zzf();
            if (zzcVarZzf == null) {
                zzcVarZzf = zzjq.zzc.zza;
            }
            return (zzuk) ((zzakg) zzuk.zzc().zza(zzutVar).zza(zzueVar).zza((zzuf) zzl.zza(zzcVarZzf)).zze());
        } catch (zzakm e) {
            throw new GeneralSecurityException("Parsing EciesParameters failed: ", e);
        }
    }

    private static zzuq zza(zzjs zzjsVar) throws GeneralSecurityException {
        if (zzjsVar.zzb().zzd().equals(zzjq.zza.zzd)) {
            return (zzuq) ((zzakg) zzuq.zzc().zza(0).zza(zzb(zzjsVar.zzb())).zza(zzaiw.zza(zzjsVar.zzd().zzb())).zzb(zzaiw.zza).zze());
        }
        int iZza = zza(zzjsVar.zzb().zzd());
        ECPoint eCPointZze = zzjsVar.zze();
        if (eCPointZze == null) {
            throw new GeneralSecurityException("NistCurvePoint was null for NIST curve");
        }
        return (zzuq) ((zzakg) zzuq.zzc().zza(0).zza(zzb(zzjsVar.zzb())).zza(zzaiw.zza(zzmo.zza(eCPointZze.getAffineX(), iZza))).zzb(zzaiw.zza(zzmo.zza(eCPointZze.getAffineY(), iZza))).zze());
    }

    static {
        zzzn zzznVarZzb = zzpy.zzb("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
        zza = zzznVarZzb;
        zzzn zzznVarZzb2 = zzpy.zzb("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
        zzb = zzznVarZzb2;
        zzc = zzou.zza(new zzow() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlc
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzow
            public final zzpq zza(zzcg zzcgVar) {
                zzjq zzjqVar = (zzjq) zzcgVar;
                return zzpm.zzb((zzwf) ((zzakg) zzwf.zza().zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey").zza(((zzuh) ((zzakg) zzuh.zza().zza(zzld.zzb(zzjqVar)).zze())).zzj()).zza((zzxd) zzld.zzi.zza(zzjqVar.zzg())).zze()));
            }
        }, zzjq.class, zzpm.class);
        zzd = zzoq.zza(new zzos() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlf
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzos
            public final zzcg zza(zzpq zzpqVar) {
                return zzld.zzb((zzpm) zzpqVar);
            }
        }, zzznVarZzb, zzpm.class);
        zze = zznh.zza(new zznj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzle
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznj
            public final zzpq zza(zzbo zzboVar, zzcm zzcmVar) {
                zzjs zzjsVar = (zzjs) zzboVar;
                return zzpn.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", zzld.zza(zzjsVar).zzj(), zzwb.zza.ASYMMETRIC_PUBLIC, (zzxd) zzld.zzi.zza(zzjsVar.zzb().zzg()), zzjsVar.zza());
            }
        }, zzjs.class, zzpn.class);
        zzf = zznd.zza(new zznf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlh
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznf
            public final zzbo zza(zzpq zzpqVar, zzcm zzcmVar) {
                return zzld.zzd((zzpn) zzpqVar, zzcmVar);
            }
        }, zzznVarZzb2, zzpn.class);
        zzg = zznh.zza(new zznj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlg
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznj
            public final zzpq zza(zzbo zzboVar, zzcm zzcmVar) {
                return zzld.zza((zzjt) zzboVar, zzcmVar);
            }
        }, zzjt.class, zzpn.class);
        zzh = zznd.zza(new zznf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlj
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznf
            public final zzbo zza(zzpq zzpqVar, zzcm zzcmVar) {
                return zzld.zzc((zzpn) zzpqVar, zzcmVar);
            }
        }, zzznVarZzb, zzpn.class);
        zzi = zzmv.zza().zza(zzxd.RAW, zzjq.zze.zzc).zza(zzxd.TINK, zzjq.zze.zza).zza(zzxd.LEGACY, zzjq.zze.zzb).zza(zzxd.CRUNCHY, zzjq.zze.zzb).zza();
        zzj = zzmv.zza().zza(zzvc.SHA1, zzjq.zzd.zza).zza(zzvc.SHA224, zzjq.zzd.zzb).zza(zzvc.SHA256, zzjq.zzd.zzc).zza(zzvc.SHA384, zzjq.zzd.zzd).zza(zzvc.SHA512, zzjq.zzd.zze).zza();
        zzk = zzmv.zza().zza(zzuw.NIST_P256, zzjq.zza.zza).zza(zzuw.NIST_P384, zzjq.zza.zzb).zza(zzuw.NIST_P521, zzjq.zza.zzc).zza(zzuw.CURVE25519, zzjq.zza.zzd).zza();
        zzl = zzmv.zza().zza(zzuf.UNCOMPRESSED, zzjq.zzc.zzb).zza(zzuf.COMPRESSED, zzjq.zzc.zza).zza(zzuf.DO_NOT_USE_CRUNCHY_UNCOMPRESSED, zzjq.zzc.zzc).zza();
    }

    public static void zza() throws GeneralSecurityException {
        zzom zzomVarZza = zzom.zza();
        zzomVarZza.zza(zzc);
        zzomVarZza.zza(zzd);
        zzomVarZza.zza(zze);
        zzomVarZza.zza(zzf);
        zzomVarZza.zza(zzg);
        zzomVarZza.zza(zzh);
    }
}
