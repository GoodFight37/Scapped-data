package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzei {
    private static final zzoy<zzen, zzbe> zza = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzeh
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            zzen zzenVar = (zzen) zzboVar;
            return zzhs.zza(zzcb.zza(zzenVar.zzb().zzc()).zza(zzenVar.zzb().zzc()), zzenVar.zzc());
        }
    }, zzen.class, zzbe.class);
    private static final zzbn<zzbe> zzb = zznl.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey", zzbe.class, zzwb.zza.REMOTE, zzwr.zze());
    private static final zzoe<zzep> zzc = new zzoe() { // from class: com.google.android.gms.internal.firebase-auth-api.zzek
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoe
        public final zzbo zza(zzcg zzcgVar, Integer num) {
            return zzen.zza((zzep) zzcgVar, num);
        }
    };

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzij.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering KMS AEAD is not supported in FIPS mode");
        }
        zzer.zza();
        zzon.zza().zza(zza);
        zzoc.zza().zza(zzc, zzep.class);
        zzna.zza().zza((zzbn) zzb, true);
    }
}
