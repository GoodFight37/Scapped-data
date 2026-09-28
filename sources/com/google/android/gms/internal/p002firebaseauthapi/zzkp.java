package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzkp implements zzpk<zzbm, zzbm> {
    private static final zzkp zza = new zzkp();
    private static final zzoy<zznn, zzbm> zzb = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzko
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzlz.zza((zznn) zzboVar);
        }
    }, zznn.class, zzbm.class);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpk
    public final Class<zzbm> zza() {
        return zzbm.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpk
    public final Class<zzbm> zzb() {
        return zzbm.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpk
    public final /* synthetic */ zzbm zza(zzpg<zzbm> zzpgVar) throws GeneralSecurityException {
        return new zzkr(zzpgVar);
    }

    zzkp() {
    }

    public static void zzc() throws GeneralSecurityException {
        zzon.zza().zza(zza);
        zzon.zza().zza(zzb);
    }

    public static void zza(zzpf zzpfVar) throws GeneralSecurityException {
        zzpfVar.zza(zza);
    }
}
