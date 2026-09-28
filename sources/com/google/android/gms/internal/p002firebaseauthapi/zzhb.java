package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzhb {
    private static final zzzn zza;
    private static final zzou<zzeg, zzpm> zzb;
    private static final zzoq<zzpm> zzc;
    private static final zznh<zzed, zzpn> zzd;
    private static final zznd<zzpn> zze;

    /* JADX INFO: Access modifiers changed from: private */
    public static zzed zzb(zzpn zzpnVar, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        if (!zzpnVar.zzf().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            zztz zztzVarZza = zztz.zza(zzpnVar.zzd(), zzajv.zza());
            if (zztzVarZza.zza() == 0) {
                return zzed.zza(zza(zzpnVar.zzc()), zzzo.zza(zztzVarZza.zzd().zzd(), zzcm.zza(zzcmVar)), zzpnVar.zze());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzakm unused) {
            throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
        }
    }

    private static zzeg.zza zza(zzxd zzxdVar) throws GeneralSecurityException {
        int i = zzhi.zza[zzxdVar.ordinal()];
        if (i == 1) {
            return zzeg.zza.zza;
        }
        if (i == 2 || i == 3) {
            return zzeg.zza.zzb;
        }
        if (i == 4) {
            return zzeg.zza.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzxdVar.zza());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzeg zzb(zzpm zzpmVar) throws GeneralSecurityException {
        if (!zzpmVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseParameters: " + zzpmVar.zza().zzf());
        }
        try {
            zzuc.zza(zzpmVar.zza().zze(), zzajv.zza());
            return zzeg.zza(zza(zzpmVar.zza().zzd()));
        } catch (zzakm e) {
            throw new GeneralSecurityException("Parsing ChaCha20Poly1305Parameters failed: ", e);
        }
    }

    private static zzxd zza(zzeg.zza zzaVar) throws GeneralSecurityException {
        if (zzeg.zza.zza.equals(zzaVar)) {
            return zzxd.TINK;
        }
        if (zzeg.zza.zzb.equals(zzaVar)) {
            return zzxd.CRUNCHY;
        }
        if (zzeg.zza.zzc.equals(zzaVar)) {
            return zzxd.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzaVar));
    }

    static {
        zzzn zzznVarZzb = zzpy.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zza = zzznVarZzb;
        zzb = zzou.zza(new zzow() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhe
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzow
            public final zzpq zza(zzcg zzcgVar) {
                return zzpm.zzb((zzwf) ((zzakg) zzwf.zza().zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key").zza(zzuc.zzb().zzj()).zza(zzhb.zza(((zzeg) zzcgVar).zzb())).zze()));
            }
        }, zzeg.class, zzpm.class);
        zzc = zzoq.zza(new zzos() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhd
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzos
            public final zzcg zza(zzpq zzpqVar) {
                return zzhb.zzb((zzpm) zzpqVar);
            }
        }, zzznVarZzb, zzpm.class);
        zzd = zznh.zza(new zznj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhg
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznj
            public final zzpq zza(zzbo zzboVar, zzcm zzcmVar) {
                zzed zzedVar = (zzed) zzboVar;
                return zzpn.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", ((zztz) ((zzakg) zztz.zzb().zza(zzaiw.zza(zzedVar.zzd().zza(zzcm.zza(zzcmVar)))).zze())).zzj(), zzwb.zza.SYMMETRIC, zzhb.zza(zzedVar.zzb().zzb()), zzedVar.zza());
            }
        }, zzed.class, zzpn.class);
        zze = zznd.zza(new zznf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhf
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznf
            public final zzbo zza(zzpq zzpqVar, zzcm zzcmVar) {
                return zzhb.zzb((zzpn) zzpqVar, zzcmVar);
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
