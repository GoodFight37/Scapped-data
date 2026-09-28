package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzdx {
    private static final zzoy<zzdt, zzbe> zza = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdw
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzih.zza((zzdt) zzboVar);
        }
    }, zzdt.class, zzbe.class);
    private static final zzoe<zzea> zzb = new zzoe() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdz
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoe
        public final zzbo zza(zzcg zzcgVar, Integer num) {
            zzea zzeaVar = (zzea) zzcgVar;
            return zzdt.zzb().zza(zzeaVar).zza(num).zza(zzzo.zza(zzeaVar.zzb())).zza();
        }
    };
    private static final zzog<zzea> zzc = new zzog() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdy
    };
    private static final zzbn<zzbe> zzd = zznl.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey", zzbe.class, zzwb.zza.SYMMETRIC, zztn.zze());

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzij.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering AES GCM SIV is not supported in FIPS mode");
        }
        zzgt.zza();
        if (zza()) {
            zzon.zza().zza(zza);
            zzok zzokVarZza = zzok.zza();
            HashMap map = new HashMap();
            map.put("AES128_GCM_SIV", zzea.zzc().zza(16).zza(zzea.zzb.zza).zza());
            map.put("AES128_GCM_SIV_RAW", zzea.zzc().zza(16).zza(zzea.zzb.zzc).zza());
            map.put("AES256_GCM_SIV", zzea.zzc().zza(32).zza(zzea.zzb.zza).zza());
            map.put("AES256_GCM_SIV_RAW", zzea.zzc().zza(32).zza(zzea.zzb.zzc).zza());
            zzokVarZza.zza(Collections.unmodifiableMap(map));
            zzoh.zza().zza(zzc, zzea.class);
            zzoc.zza().zza(zzb, zzea.class);
            zzna.zza().zza((zzbn) zzd, true);
        }
    }

    private static boolean zza() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }
}
