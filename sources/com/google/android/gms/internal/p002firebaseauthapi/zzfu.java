package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfu {
    private static final zzoy<zzfv, zzbe> zza = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfx
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzfu.zza((zzfv) zzboVar);
        }
    }, zzfv.class, zzbe.class);
    private static final zzbn<zzbe> zzb = zznl.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", zzbe.class, zzwb.zza.SYMMETRIC, zzxo.zze());
    private static final zzog<zzfy> zzc = new zzog() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfw
    };
    private static final zzoe<zzfy> zzd = new zzoe() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfz
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoe
        public final zzbo zza(zzcg zzcgVar, Integer num) {
            return zzfu.zza((zzfy) zzcgVar, num);
        }
    };

    public static /* synthetic */ zzbe zza(zzfv zzfvVar) {
        return zzic.zza() ? zzic.zza(zzfvVar) : zzzk.zza(zzfvVar);
    }

    static zzfv zza(zzfy zzfyVar, @Nullable Integer num) throws GeneralSecurityException {
        return zzfv.zza(zzfyVar.zzb(), zzzo.zza(32), num);
    }

    static String zza() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzij.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering XChaCha20Poly1305 is not supported in FIPS mode");
        }
        zzib.zza();
        zzon.zza().zza(zza);
        zzok zzokVarZza = zzok.zza();
        HashMap map = new HashMap();
        map.put("XCHACHA20_POLY1305", zzfy.zza(zzfy.zza.zza));
        map.put("XCHACHA20_POLY1305_RAW", zzfy.zza(zzfy.zza.zzc));
        zzokVarZza.zza(Collections.unmodifiableMap(map));
        zzoc.zza().zza(zzd, zzfy.class);
        zzoh.zza().zza(zzc, zzfy.class);
        zzna.zza().zza((zzbn) zzb, true);
    }
}
