package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcy {
    private static final zzoy<zzcx, zzbe> zza = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdb
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzyn.zza((zzcx) zzboVar);
        }
    }, zzcx.class, zzbe.class);
    private static final zzbn<zzbe> zzb = zznl.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", zzbe.class, zzwb.zza.SYMMETRIC, zzsj.zzf());
    private static final zzog<zzdc> zzc = new zzog() { // from class: com.google.android.gms.internal.firebase-auth-api.zzda
    };
    private static final zzoe<zzdc> zzd = new zzoe() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdd
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoe
        public final zzbo zza(zzcg zzcgVar, Integer num) {
            return zzcy.zza((zzdc) zzcgVar, num);
        }
    };
    private static final zzij.zza zze = zzij.zza.zzb;

    static zzcx zza(zzdc zzdcVar, @Nullable Integer num) throws GeneralSecurityException {
        if (zzdcVar.zzb() == 16 || zzdcVar.zzb() == 32) {
            return zzcx.zzb().zza(zzdcVar).zza(num).zza(zzzo.zza(zzdcVar.zzb())).zzb(zzzo.zza(zzdcVar.zzc())).zza();
        }
        throw new GeneralSecurityException("AES key size must be 16 or 32 bytes");
    }

    static String zza() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zzij.zza zzaVar = zze;
        if (!zzaVar.zza()) {
            throw new GeneralSecurityException("Can not use AES-CTR-HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzga.zza();
        zzon.zza().zza(zza);
        zzok zzokVarZza = zzok.zza();
        HashMap map = new HashMap();
        map.put("AES128_CTR_HMAC_SHA256", zzfg.zze);
        map.put("AES128_CTR_HMAC_SHA256_RAW", zzdc.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzdc.zza.zzc).zza(zzdc.zzc.zzc).zza());
        map.put("AES256_CTR_HMAC_SHA256", zzfg.zzf);
        map.put("AES256_CTR_HMAC_SHA256_RAW", zzdc.zzf().zza(32).zzb(32).zzd(32).zzc(16).zza(zzdc.zza.zzc).zza(zzdc.zzc.zzc).zza());
        zzokVarZza.zza(Collections.unmodifiableMap(map));
        zzoh.zza().zza(zzc, zzdc.class);
        zzoc.zza().zza(zzd, zzdc.class);
        zzna.zza().zza((zzbn) zzb, zzaVar, true);
    }
}
