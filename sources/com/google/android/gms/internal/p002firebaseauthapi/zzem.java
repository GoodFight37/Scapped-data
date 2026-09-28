package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzem {
    private static final zzbn<zzbe> zza = zznl.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", zzbe.class, zzwb.zza.SYMMETRIC, zzwx.zze());
    private static final zzoe<zzew> zzb = new zzoe() { // from class: com.google.android.gms.internal.firebase-auth-api.zzel
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoe
        public final zzbo zza(zzcg zzcgVar, Integer num) {
            return zzex.zza((zzew) zzcgVar, num);
        }
    };
    private static final zzoy<zzex, zzbe> zzc = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzeo
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzem.zza((zzex) zzboVar);
        }
    }, zzex.class, zzbe.class);

    public static /* synthetic */ zzbe zza(zzex zzexVar) {
        String strZzd = zzexVar.zzb().zzd();
        return zzhs.zza(zzej.zza(zzexVar.zzb().zzb(), zzcb.zza(strZzd).zza(strZzd)), zzexVar.zzc());
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzij.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering KMS Envelope AEAD is not supported in FIPS mode");
        }
        zzfa.zza();
        zzoc.zza().zza(zzb, zzew.class);
        zzon.zza().zza(zzc);
        zzna.zza().zza((zzbn) zza, true);
    }
}
