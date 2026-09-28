package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzqx implements zzpk<zzcd, zzcd> {
    private static final zzqx zza = new zzqx();
    private static final zzoy<zznn, zzcd> zzb = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzra
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzrv.zza((zznn) zzboVar);
        }
    }, zznn.class, zzcd.class);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpk
    public final Class<zzcd> zza() {
        return zzcd.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpk
    public final Class<zzcd> zzb() {
        return zzcd.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpk
    public final /* synthetic */ zzcd zza(zzpg<zzcd> zzpgVar) throws GeneralSecurityException {
        return new zzqz(zzpgVar);
    }

    zzqx() {
    }

    static void zzc() throws GeneralSecurityException {
        zzon.zza().zza(zza);
        zzon.zza().zza(zzb);
    }
}
