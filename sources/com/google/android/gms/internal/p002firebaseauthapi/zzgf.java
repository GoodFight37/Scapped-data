package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzgf {
    private static final zzzn zza;
    private static final zzou<zzdk, zzpm> zzb;
    private static final zzoq<zzpm> zzc;
    private static final zznh<zzdf, zzpn> zzd;
    private static final zznd<zzpn> zze;

    /* JADX INFO: Access modifiers changed from: private */
    public static zzdf zzb(zzpn zzpnVar, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        if (!zzpnVar.zzf().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
        }
        try {
            zzsy zzsyVarZza = zzsy.zza(zzpnVar.zzd(), zzajv.zza());
            if (zzsyVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return zzdf.zzb().zza(zzdk.zze().zzb(zzsyVarZza.zze().zzb()).zza(zzsyVarZza.zzd().zza()).zzc(16).zza(zza(zzpnVar.zzc())).zza()).zza(zzzo.zza(zzsyVarZza.zze().zzd(), zzcm.zza(zzcmVar))).zza(zzpnVar.zze()).zza();
        } catch (zzakm unused) {
            throw new GeneralSecurityException("Parsing AesEaxcKey failed");
        }
    }

    private static zzdk.zzb zza(zzxd zzxdVar) throws GeneralSecurityException {
        int i = zzgm.zza[zzxdVar.ordinal()];
        if (i == 1) {
            return zzdk.zzb.zza;
        }
        if (i == 2 || i == 3) {
            return zzdk.zzb.zzb;
        }
        if (i == 4) {
            return zzdk.zzb.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzxdVar.zza());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzdk zzb(zzpm zzpmVar) throws GeneralSecurityException {
        if (!zzpmVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: " + zzpmVar.zza().zzf());
        }
        try {
            zztb zztbVarZza = zztb.zza(zzpmVar.zza().zze(), zzajv.zza());
            return zzdk.zze().zzb(zztbVarZza.zza()).zza(zztbVarZza.zzd().zza()).zzc(16).zza(zza(zzpmVar.zza().zzd())).zza();
        } catch (zzakm e) {
            throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e);
        }
    }

    private static zzte zzb(zzdk zzdkVar) throws GeneralSecurityException {
        if (zzdkVar.zzd() != 16) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d. Currently Tink only supports aes eax keys with tag size equal to 16 bytes.", Integer.valueOf(zzdkVar.zzd())));
        }
        return (zzte) ((zzakg) zzte.zzb().zza(zzdkVar.zzb()).zze());
    }

    private static zzxd zza(zzdk.zzb zzbVar) throws GeneralSecurityException {
        if (zzdk.zzb.zza.equals(zzbVar)) {
            return zzxd.TINK;
        }
        if (zzdk.zzb.zzb.equals(zzbVar)) {
            return zzxd.CRUNCHY;
        }
        if (zzdk.zzb.zzc.equals(zzbVar)) {
            return zzxd.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzbVar));
    }

    static {
        zzzn zzznVarZzb = zzpy.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zza = zzznVarZzb;
        zzb = zzou.zza(new zzow() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgi
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzow
            public final zzpq zza(zzcg zzcgVar) {
                zzdk zzdkVar = (zzdk) zzcgVar;
                return zzpm.zzb((zzwf) ((zzakg) zzwf.zza().zza("type.googleapis.com/google.crypto.tink.AesEaxKey").zza(((zztb) ((zzakg) zztb.zzb().zza(zzgf.zzb(zzdkVar)).zza(zzdkVar.zzc()).zze())).zzj()).zza(zzgf.zza(zzdkVar.zzf())).zze()));
            }
        }, zzdk.class, zzpm.class);
        zzc = zzoq.zza(new zzos() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgh
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzos
            public final zzcg zza(zzpq zzpqVar) {
                return zzgf.zzb((zzpm) zzpqVar);
            }
        }, zzznVarZzb, zzpm.class);
        zzd = zznh.zza(new zznj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgk
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznj
            public final zzpq zza(zzbo zzboVar, zzcm zzcmVar) {
                zzdf zzdfVar = (zzdf) zzboVar;
                return zzpn.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", ((zzsy) ((zzakg) zzsy.zzb().zza(zzgf.zzb(zzdfVar.zzc())).zza(zzaiw.zza(zzdfVar.zze().zza(zzcm.zza(zzcmVar)))).zze())).zzj(), zzwb.zza.SYMMETRIC, zzgf.zza(zzdfVar.zzc().zzf()), zzdfVar.zza());
            }
        }, zzdf.class, zzpn.class);
        zze = zznd.zza(new zznf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgj
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznf
            public final zzbo zza(zzpq zzpqVar, zzcm zzcmVar) {
                return zzgf.zzb((zzpn) zzpqVar, zzcmVar);
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
