package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzja implements zzpk<zzbk, zzbk> {
    private static final zzja zza = new zzja();
    private static final zzoy<zznn, zzbk> zzb = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zziz
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzjk.zza((zznn) zzboVar);
        }
    }, zznn.class, zzbk.class);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpk
    public final Class<zzbk> zza() {
        return zzbk.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpk
    public final Class<zzbk> zzb() {
        return zzbk.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpk
    public final /* synthetic */ zzbk zza(zzpg<zzbk> zzpgVar) throws GeneralSecurityException {
        return new zzjc(zzpgVar);
    }

    zzja() {
    }

    public static void zzc() throws GeneralSecurityException {
        zzon.zza().zza(zza);
        zzon.zza().zza(zzb);
    }
}
