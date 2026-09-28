package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzec {
    private static final zzoy<zzed, zzbe> zza = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzef
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzec.zza((zzed) zzboVar);
        }
    }, zzed.class, zzbe.class);
    private static final zzoe<zzeg> zzb = new zzoe() { // from class: com.google.android.gms.internal.firebase-auth-api.zzee
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoe
        public final zzbo zza(zzcg zzcgVar, Integer num) {
            return zzec.zza((zzeg) zzcgVar, num);
        }
    };
    private static final zzbn<zzbe> zzc = zznl.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", zzbe.class, zzwb.zza.SYMMETRIC, zztz.zze());

    public static /* synthetic */ zzbe zza(zzed zzedVar) {
        return zzgz.zzb() ? zzgz.zza(zzedVar) : zzyf.zza(zzedVar);
    }

    static zzed zza(zzeg zzegVar, @Nullable Integer num) throws GeneralSecurityException {
        return zzed.zza(zzegVar.zzb(), zzzo.zza(32), num);
    }

    static String zza() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzij.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering ChaCha20Poly1305 is not supported in FIPS mode");
        }
        zzhb.zza();
        zzon.zza().zza(zza);
        zzoc.zza().zza(zzb, zzeg.class);
        zzok zzokVarZza = zzok.zza();
        HashMap map = new HashMap();
        map.put("CHACHA20_POLY1305", zzeg.zza(zzeg.zza.zza));
        map.put("CHACHA20_POLY1305_RAW", zzeg.zza(zzeg.zza.zzc));
        zzokVarZza.zza(Collections.unmodifiableMap(map));
        zzna.zza().zza((zzbn) zzc, true);
    }
}
