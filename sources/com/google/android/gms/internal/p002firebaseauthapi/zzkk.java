package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzkk implements zzpk<zzbj, zzbj> {
    private static final zzkk zza = new zzkk();
    private static final zzoy<zznn, zzbj> zzb = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkn
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzlx.zza((zznn) zzboVar);
        }
    }, zznn.class, zzbj.class);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpk
    public final Class<zzbj> zza() {
        return zzbj.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpk
    public final Class<zzbj> zzb() {
        return zzbj.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpk
    public final /* synthetic */ zzbj zza(zzpg<zzbj> zzpgVar) throws GeneralSecurityException {
        return new zzkm(zzpgVar);
    }

    zzkk() {
    }

    public static void zzc() throws GeneralSecurityException {
        zzon.zza().zza(zza);
        zzon.zza().zza(zzb);
    }

    public static void zza(zzpf zzpfVar) throws GeneralSecurityException {
        zzpfVar.zza(zza);
    }
}
