package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzip {
    private static final zzoy<zzio, zzbk> zza = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzis
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzip.zza((zzio) zzboVar);
        }
    }, zzio.class, zzbk.class);
    private static final zzbn<zzbk> zzb = zznl.zza("type.googleapis.com/google.crypto.tink.AesSivKey", zzbk.class, zzwb.zza.SYMMETRIC, zztt.zze());
    private static final zzog<zzit> zzc = new zzog() { // from class: com.google.android.gms.internal.firebase-auth-api.zzir
    };
    private static final zzoe<zzit> zzd = new zzoe() { // from class: com.google.android.gms.internal.firebase-auth-api.zziu
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoe
        public final zzbo zza(zzcg zzcgVar, Integer num) {
            return zzip.zza((zzit) zzcgVar, num);
        }
    };

    public static /* synthetic */ zzbk zza(zzio zzioVar) throws GeneralSecurityException {
        zza(zzioVar.zzc());
        return zzya.zza(zzioVar);
    }

    static zzio zza(zzit zzitVar, @Nullable Integer num) throws GeneralSecurityException {
        zza(zzitVar);
        return zzio.zzb().zza(zzitVar).zza(num).zza(zzzo.zza(zzitVar.zzb())).zza();
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzij.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering AES SIV is not supported in FIPS mode");
        }
        zzjd.zza();
        zzon.zza().zza(zza);
        zzok zzokVarZza = zzok.zza();
        HashMap map = new HashMap();
        map.put("AES256_SIV", zzjb.zza);
        map.put("AES256_SIV_RAW", zzit.zzc().zza(64).zza(zzit.zza.zzc).zza());
        zzokVarZza.zza(Collections.unmodifiableMap(map));
        zzoh.zza().zza(zzc, zzit.class);
        zzoc.zza().zza(zzd, zzit.class);
        zzna.zza().zza((zzbn) zzb, true);
    }

    private static void zza(zzit zzitVar) throws GeneralSecurityException {
        if (zzitVar.zzb() == 64) {
            return;
        }
        throw new InvalidAlgorithmParameterException("invalid key size: " + zzitVar.zzb() + ". Valid keys must have 64 bytes.");
    }
}
