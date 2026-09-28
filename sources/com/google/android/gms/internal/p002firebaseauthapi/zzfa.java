package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfa {
    private static final zzzn zza;
    private static final zzou<zzew, zzpm> zzb;
    private static final zzoq<zzpm> zzc;
    private static final zznh<zzex, zzpn> zzd;
    private static final zznd<zzpn> zze;

    /* JADX INFO: Access modifiers changed from: private */
    public static zzex zzb(zzpn zzpnVar, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        if (!zzpnVar.zzf().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseKey");
        }
        try {
            zzwx zzwxVarZza = zzwx.zza(zzpnVar.zzd(), zzajv.zza());
            if (zzwxVarZza.zza() == 0) {
                return zzex.zza(zza(zzwxVarZza.zzd(), zzpnVar.zzc()), zzpnVar.zze());
            }
            throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with version 0, got " + String.valueOf(zzwxVarZza));
        } catch (zzakm e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKey failed: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzew zzb(zzpm zzpmVar) throws GeneralSecurityException {
        if (!zzpmVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseParameters: " + zzpmVar.zza().zzf());
        }
        try {
            return zza(zzxa.zza(zzpmVar.zza().zze(), zzajv.zza()), zzpmVar.zza().zzd());
        } catch (zzakm e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    private static zzew zza(zzxa zzxaVar, zzxd zzxdVar) throws GeneralSecurityException {
        zzew.zza zzaVar;
        zzew.zzc zzcVar;
        zzcg zzcgVarZza = zzco.zza(((zzwf) ((zzakg) zzwf.zza().zza(zzxaVar.zza().zzf()).zza(zzxaVar.zza().zze()).zza(zzxd.RAW).zze())).zzk());
        if (zzcgVarZza instanceof zzdr) {
            zzaVar = zzew.zza.zza;
        } else if (zzcgVarZza instanceof zzeg) {
            zzaVar = zzew.zza.zzc;
        } else if (zzcgVarZza instanceof zzfy) {
            zzaVar = zzew.zza.zzb;
        } else if (zzcgVarZza instanceof zzdc) {
            zzaVar = zzew.zza.zzd;
        } else if (zzcgVarZza instanceof zzdk) {
            zzaVar = zzew.zza.zze;
        } else if (zzcgVarZza instanceof zzea) {
            zzaVar = zzew.zza.zzf;
        } else {
            throw new GeneralSecurityException("Unsupported DEK parameters when parsing " + String.valueOf(zzcgVarZza));
        }
        zzew.zzb zzbVar = new zzew.zzb();
        int i = zzfd.zza[zzxdVar.ordinal()];
        if (i == 1) {
            zzcVar = zzew.zzc.zza;
        } else if (i == 2) {
            zzcVar = zzew.zzc.zzb;
        } else {
            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzxdVar.zza());
        }
        return zzbVar.zza(zzcVar).zza(zzxaVar.zze()).zza((zzcr) zzcgVarZza).zza(zzaVar).zza();
    }

    private static zzxa zzb(zzew zzewVar) throws GeneralSecurityException {
        try {
            return (zzxa) ((zzakg) zzxa.zzb().zza(zzewVar.zzd()).zza(zzwf.zza(zzco.zza(zzewVar.zzb()), zzajv.zza())).zze());
        } catch (zzakm e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    private static zzxd zza(zzew.zzc zzcVar) throws GeneralSecurityException {
        if (zzew.zzc.zza.equals(zzcVar)) {
            return zzxd.TINK;
        }
        if (zzew.zzc.zzb.equals(zzcVar)) {
            return zzxd.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzcVar));
    }

    static {
        zzzn zzznVarZzb = zzpy.zzb("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zza = zzznVarZzb;
        zzb = zzou.zza(new zzow() { // from class: com.google.android.gms.internal.firebase-auth-api.zzez
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzow
            public final zzpq zza(zzcg zzcgVar) {
                zzew zzewVar = (zzew) zzcgVar;
                return zzpm.zzb((zzwf) ((zzakg) zzwf.zza().zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey").zza(zzfa.zzb(zzewVar).zzj()).zza(zzfa.zza(zzewVar.zzc())).zze()));
            }
        }, zzew.class, zzpm.class);
        zzc = zzoq.zza(new zzos() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfc
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzos
            public final zzcg zza(zzpq zzpqVar) {
                return zzfa.zzb((zzpm) zzpqVar);
            }
        }, zzznVarZzb, zzpm.class);
        zzd = zznh.zza(new zznj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfb
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznj
            public final zzpq zza(zzbo zzboVar, zzcm zzcmVar) {
                zzex zzexVar = (zzex) zzboVar;
                return zzpn.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", ((zzwx) ((zzakg) zzwx.zzb().zza(zzfa.zzb(zzexVar.zzb())).zze())).zzj(), zzwb.zza.REMOTE, zzfa.zza(zzexVar.zzb().zzc()), zzexVar.zza());
            }
        }, zzex.class, zzpn.class);
        zze = zznd.zza(new zznf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfe
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznf
            public final zzbo zza(zzpq zzpqVar, zzcm zzcmVar) {
                return zzfa.zzb((zzpn) zzpqVar, zzcmVar);
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
