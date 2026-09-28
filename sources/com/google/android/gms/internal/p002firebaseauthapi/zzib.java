package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzib {
    private static final zzzn zza;
    private static final zzou<zzfy, zzpm> zzb;
    private static final zzoq<zzpm> zzc;
    private static final zznh<zzfv, zzpn> zzd;
    private static final zznd<zzpn> zze;

    /* JADX INFO: Access modifiers changed from: private */
    public static zzfv zzb(zzpn zzpnVar, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        if (!zzpnVar.zzf().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            zzxo zzxoVarZza = zzxo.zza(zzpnVar.zzd(), zzajv.zza());
            if (zzxoVarZza.zza() == 0) {
                return zzfv.zza(zza(zzpnVar.zzc()), zzzo.zza(zzxoVarZza.zzd().zzd(), zzcm.zza(zzcmVar)), zzpnVar.zze());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzakm unused) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
        }
    }

    private static zzfy.zza zza(zzxd zzxdVar) throws GeneralSecurityException {
        int i = zzii.zza[zzxdVar.ordinal()];
        if (i == 1) {
            return zzfy.zza.zza;
        }
        if (i == 2 || i == 3) {
            return zzfy.zza.zzb;
        }
        if (i == 4) {
            return zzfy.zza.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzxdVar.zza());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzfy zzb(zzpm zzpmVar) throws GeneralSecurityException {
        if (!zzpmVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: " + zzpmVar.zza().zzf());
        }
        try {
            if (zzxr.zza(zzpmVar.zza().zze(), zzajv.zza()).zza() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            return zzfy.zza(zza(zzpmVar.zza().zzd()));
        } catch (zzakm e) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e);
        }
    }

    private static zzxd zza(zzfy.zza zzaVar) throws GeneralSecurityException {
        if (zzfy.zza.zza.equals(zzaVar)) {
            return zzxd.TINK;
        }
        if (zzfy.zza.zzb.equals(zzaVar)) {
            return zzxd.CRUNCHY;
        }
        if (zzfy.zza.zzc.equals(zzaVar)) {
            return zzxd.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzaVar));
    }

    static {
        zzzn zzznVarZzb = zzpy.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zza = zzznVarZzb;
        zzb = zzou.zza(new zzow() { // from class: com.google.android.gms.internal.firebase-auth-api.zzie
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzow
            public final zzpq zza(zzcg zzcgVar) {
                return zzpm.zzb((zzwf) ((zzakg) zzwf.zza().zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key").zza(zzxr.zzc().zzj()).zza(zzib.zza(((zzfy) zzcgVar).zzb())).zze()));
            }
        }, zzfy.class, zzpm.class);
        zzc = zzoq.zza(new zzos() { // from class: com.google.android.gms.internal.firebase-auth-api.zzid
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzos
            public final zzcg zza(zzpq zzpqVar) {
                return zzib.zzb((zzpm) zzpqVar);
            }
        }, zzznVarZzb, zzpm.class);
        zzd = zznh.zza(new zznj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzig
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznj
            public final zzpq zza(zzbo zzboVar, zzcm zzcmVar) {
                zzfv zzfvVar = (zzfv) zzboVar;
                return zzpn.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", ((zzxo) ((zzakg) zzxo.zzb().zza(zzaiw.zza(zzfvVar.zzd().zza(zzcm.zza(zzcmVar)))).zze())).zzj(), zzwb.zza.SYMMETRIC, zzib.zza(zzfvVar.zzb().zzb()), zzfvVar.zza());
            }
        }, zzfv.class, zzpn.class);
        zze = zznd.zza(new zznf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzif
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznf
            public final zzbo zza(zzpq zzpqVar, zzcm zzcmVar) {
                return zzib.zzb((zzpn) zzpqVar, zzcmVar);
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
