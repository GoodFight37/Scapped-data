package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzqb {
    private static final zzoe<zzqf> zza = new zzoe() { // from class: com.google.android.gms.internal.firebase-auth-api.zzqe
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoe
        public final zzbo zza(zzcg zzcgVar, Integer num) {
            return zzqb.zza((zzqf) zzcgVar, num);
        }
    };
    private static final zzoy<zzqa, zzqh> zzb = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzqd
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzqb.zzb((zzqa) zzboVar);
        }
    }, zzqa.class, zzqh.class);
    private static final zzoy<zzqa, zzcd> zzc = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzqg
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzqb.zza((zzqa) zzboVar);
        }
    }, zzqa.class, zzcd.class);
    private static final zzbn<zzcd> zzd = zznl.zza("type.googleapis.com/google.crypto.tink.AesCmacKey", zzcd.class, zzwb.zza.SYMMETRIC, zzsa.zzf());

    public static /* synthetic */ zzcd zza(zzqa zzqaVar) throws GeneralSecurityException {
        zza(zzqaVar.zzc());
        return zzzg.zza(zzqaVar);
    }

    public static /* synthetic */ zzqa zza(zzqf zzqfVar, Integer num) throws GeneralSecurityException {
        zza(zzqfVar);
        return zzqa.zzb().zza(zzqfVar).zza(zzzo.zza(zzqfVar.zzc())).zza(num).zza();
    }

    public static /* synthetic */ zzqh zzb(zzqa zzqaVar) throws GeneralSecurityException {
        zza(zzqaVar.zzc());
        return new zzrq(zzqaVar);
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzij.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering AES CMAC is not supported in FIPS mode");
        }
        zzrh.zza();
        zzoc.zza().zza(zza, zzqf.class);
        zzon.zza().zza(zzb);
        zzon.zza().zza(zzc);
        zzok zzokVarZza = zzok.zza();
        HashMap map = new HashMap();
        map.put("AES_CMAC", zzrb.zzc);
        map.put("AES256_CMAC", zzrb.zzc);
        map.put("AES256_CMAC_RAW", zzqf.zzd().zza(32).zzb(16).zza(zzqf.zza.zzd).zza());
        zzokVarZza.zza(Collections.unmodifiableMap(map));
        zzna.zza().zza((zzbn) zzd, true);
    }

    private static void zza(zzqf zzqfVar) throws GeneralSecurityException {
        if (zzqfVar.zzc() != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }
}
