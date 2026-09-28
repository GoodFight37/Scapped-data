package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjw {
    private static final zzzn zza;
    private static final zzzn zzb;
    private static final zzou<zzju, zzpm> zzc;
    private static final zzoq<zzpm> zzd;
    private static final zznh<zzkf, zzpn> zze;
    private static final zznd<zzpn> zzf;
    private static final zznh<zzjx, zzpn> zzg;
    private static final zznd<zzpn> zzh;
    private static final zzmv<zzxd, zzju.zzf> zzi;
    private static final zzmv<zzvm, zzju.zzd> zzj;
    private static final zzmv<zzvn, zzju.zze> zzk;
    private static final zzmv<zzvk, zzju.zza> zzl;

    private static zzju zza(zzxd zzxdVar, zzvs zzvsVar) throws GeneralSecurityException {
        return zzju.zzc().zza(zzi.zza(zzxdVar)).zza(zzj.zza(zzvsVar.zzc())).zza(zzk.zza(zzvsVar.zzb())).zza(zzl.zza(zzvsVar.zza())).zza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzju zzb(zzpm zzpmVar) throws GeneralSecurityException {
        if (!zzpmVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.HpkePrivateKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parseParameters: " + zzpmVar.zza().zzf());
        }
        try {
            return zza(zzpmVar.zza().zzd(), zzvp.zza(zzpmVar.zza().zze(), zzajv.zza()).zzc());
        } catch (zzakm e) {
            throw new GeneralSecurityException("Parsing HpkeParameters failed: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzjx zzc(zzpn zzpnVar, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        if (!zzpnVar.zzf().equals("type.googleapis.com/google.crypto.tink.HpkePrivateKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parsePrivateKey: " + zzpnVar.zzf());
        }
        try {
            zzvv zzvvVarZza = zzvv.zza(zzpnVar.zzd(), zzajv.zza());
            if (zzvvVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzvy zzvyVarZzd = zzvvVarZza.zzd();
            if (zzvyVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzju zzjuVarZza = zza(zzpnVar.zzc(), zzvyVarZzd.zzb());
            return zzjx.zza(zzkf.zza(zzjuVarZza, zza(zzjuVarZza.zze(), zzvyVarZzd.zzf().zzd()), zzpnVar.zze()), zzzo.zza(zzmo.zza(zzmo.zza(zzvvVarZza.zze().zzd()), zzlu.zza(zzjuVarZza.zze())), zzcm.zza(zzcmVar)));
        } catch (zzakm unused) {
            throw new GeneralSecurityException("Parsing HpkePrivateKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzkf zzd(zzpn zzpnVar, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        if (!zzpnVar.zzf().equals("type.googleapis.com/google.crypto.tink.HpkePublicKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parsePublicKey: " + zzpnVar.zzf());
        }
        try {
            zzvy zzvyVarZza = zzvy.zza(zzpnVar.zzd(), zzajv.zza());
            if (zzvyVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzju zzjuVarZza = zza(zzpnVar.zzc(), zzvyVarZza.zzb());
            return zzkf.zza(zzjuVarZza, zza(zzjuVarZza.zze(), zzvyVarZza.zzf().zzd()), zzpnVar.zze());
        } catch (zzakm unused) {
            throw new GeneralSecurityException("Parsing HpkePublicKey failed");
        }
    }

    private static zzvs zzb(zzju zzjuVar) throws GeneralSecurityException {
        return (zzvs) ((zzakg) zzvs.zzd().zza((zzvm) zzj.zza(zzjuVar.zze())).zza((zzvn) zzk.zza(zzjuVar.zzd())).zza((zzvk) zzl.zza(zzjuVar.zzb())).zze());
    }

    private static zzvy zza(zzkf zzkfVar) throws GeneralSecurityException {
        return (zzvy) ((zzakg) zzvy.zzc().zza(0).zza(zzb(zzkfVar.zzb())).zza(zzaiw.zza(zzkfVar.zzd().zzb())).zze());
    }

    private static zzzn zza(zzju.zzd zzdVar, byte[] bArr) throws GeneralSecurityException {
        return zzzn.zza(zzmo.zza(zzmo.zza(bArr), zzlu.zzb(zzdVar)));
    }

    static {
        zzzn zzznVarZzb = zzpy.zzb("type.googleapis.com/google.crypto.tink.HpkePrivateKey");
        zza = zzznVarZzb;
        zzzn zzznVarZzb2 = zzpy.zzb("type.googleapis.com/google.crypto.tink.HpkePublicKey");
        zzb = zzznVarZzb2;
        zzc = zzou.zza(new zzow() { // from class: com.google.android.gms.internal.firebase-auth-api.zzjz
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzow
            public final zzpq zza(zzcg zzcgVar) {
                zzju zzjuVar = (zzju) zzcgVar;
                return zzpm.zzb((zzwf) ((zzakg) zzwf.zza().zza("type.googleapis.com/google.crypto.tink.HpkePrivateKey").zza(((zzvp) ((zzakg) zzvp.zza().zza(zzjw.zzb(zzjuVar)).zze())).zzj()).zza((zzxd) zzjw.zzi.zza(zzjuVar.zzf())).zze()));
            }
        }, zzju.class, zzpm.class);
        zzd = zzoq.zza(new zzos() { // from class: com.google.android.gms.internal.firebase-auth-api.zzjy
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzos
            public final zzcg zza(zzpq zzpqVar) {
                return zzjw.zzb((zzpm) zzpqVar);
            }
        }, zzznVarZzb, zzpm.class);
        zze = zznh.zza(new zznj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkb
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznj
            public final zzpq zza(zzbo zzboVar, zzcm zzcmVar) {
                zzkf zzkfVar = (zzkf) zzboVar;
                return zzpn.zza("type.googleapis.com/google.crypto.tink.HpkePublicKey", zzjw.zza(zzkfVar).zzj(), zzwb.zza.ASYMMETRIC_PUBLIC, (zzxd) zzjw.zzi.zza(zzkfVar.zzb().zzf()), zzkfVar.zza());
            }
        }, zzkf.class, zzpn.class);
        zzf = zznd.zza(new zznf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzka
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznf
            public final zzbo zza(zzpq zzpqVar, zzcm zzcmVar) {
                return zzjw.zzd((zzpn) zzpqVar, zzcmVar);
            }
        }, zzznVarZzb2, zzpn.class);
        zzg = zznh.zza(new zznj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkd
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznj
            public final zzpq zza(zzbo zzboVar, zzcm zzcmVar) {
                zzjx zzjxVar = (zzjx) zzboVar;
                return zzpn.zza("type.googleapis.com/google.crypto.tink.HpkePrivateKey", ((zzvv) ((zzakg) zzvv.zzb().zza(0).zza(zzjw.zza((zzkf) ((zzkv) zzjxVar.zzb()))).zza(zzaiw.zza(zzjxVar.zze().zza(zzcm.zza(zzcmVar)))).zze())).zzj(), zzwb.zza.ASYMMETRIC_PRIVATE, (zzxd) zzjw.zzi.zza(zzjxVar.zzc().zzf()), zzjxVar.zza());
            }
        }, zzjx.class, zzpn.class);
        zzh = zznd.zza(new zznf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkc
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznf
            public final zzbo zza(zzpq zzpqVar, zzcm zzcmVar) {
                return zzjw.zzc((zzpn) zzpqVar, zzcmVar);
            }
        }, zzznVarZzb, zzpn.class);
        zzi = zzmv.zza().zza(zzxd.RAW, zzju.zzf.zzc).zza(zzxd.TINK, zzju.zzf.zza).zza(zzxd.LEGACY, zzju.zzf.zzb).zza(zzxd.CRUNCHY, zzju.zzf.zzb).zza();
        zzj = zzmv.zza().zza(zzvm.DHKEM_P256_HKDF_SHA256, zzju.zzd.zza).zza(zzvm.DHKEM_P384_HKDF_SHA384, zzju.zzd.zzb).zza(zzvm.DHKEM_P521_HKDF_SHA512, zzju.zzd.zzc).zza(zzvm.DHKEM_X25519_HKDF_SHA256, zzju.zzd.zzd).zza();
        zzk = zzmv.zza().zza(zzvn.HKDF_SHA256, zzju.zze.zza).zza(zzvn.HKDF_SHA384, zzju.zze.zzb).zza(zzvn.HKDF_SHA512, zzju.zze.zzc).zza();
        zzl = zzmv.zza().zza(zzvk.AES_128_GCM, zzju.zza.zza).zza(zzvk.AES_256_GCM, zzju.zza.zzb).zza(zzvk.CHACHA20_POLY1305, zzju.zza.zzc).zza();
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
