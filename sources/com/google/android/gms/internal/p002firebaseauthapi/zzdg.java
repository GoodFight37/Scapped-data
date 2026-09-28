package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzdg {
    private static final zzoy<zzdf, zzbe> zza = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdj
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzxw.zza((zzdf) zzboVar);
        }
    }, zzdf.class, zzbe.class);
    private static final zzbn<zzbe> zzb = zznl.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", zzbe.class, zzwb.zza.SYMMETRIC, zzsy.zzf());
    private static final zzoe<zzdk> zzc = new zzoe() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdi
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoe
        public final zzbo zza(zzcg zzcgVar, Integer num) {
            return zzdg.zza((zzdk) zzcgVar, num);
        }
    };

    public static /* synthetic */ zzdf zza(zzdk zzdkVar, Integer num) throws GeneralSecurityException {
        if (zzdkVar.zzc() == 24) {
            throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
        }
        return zzdf.zzb().zza(zzdkVar).zza(num).zza(zzzo.zza(zzdkVar.zzc())).zza();
    }

    static String zza() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzij.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering AES EAX is not supported in FIPS mode");
        }
        zzgf.zza();
        zzon.zza().zza(zza);
        zzok zzokVarZza = zzok.zza();
        HashMap map = new HashMap();
        map.put("AES128_EAX", zzfg.zzc);
        map.put("AES128_EAX_RAW", zzdk.zze().zza(16).zzb(16).zzc(16).zza(zzdk.zzb.zzc).zza());
        map.put("AES256_EAX", zzfg.zzd);
        map.put("AES256_EAX_RAW", zzdk.zze().zza(16).zzb(32).zzc(16).zza(zzdk.zzb.zzc).zza());
        zzokVarZza.zza(Collections.unmodifiableMap(map));
        zzoc.zza().zza(zzc, zzdk.class);
        zzna.zza().zza((zzbn) zzb, true);
    }
}
