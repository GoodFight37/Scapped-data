package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcu implements zzpk<zzbe, zzbe> {
    private static final zzcu zza = new zzcu();
    private static final zzoy<zznn, zzbe> zzb = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzct
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzhs.zza((zznn) zzboVar);
        }
    }, zznn.class, zzbe.class);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpk
    public final Class<zzbe> zza() {
        return zzbe.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpk
    public final Class<zzbe> zzb() {
        return zzbe.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpk
    public final /* synthetic */ zzbe zza(zzpg<zzbe> zzpgVar) throws GeneralSecurityException {
        return new zzcw(zzpgVar);
    }

    zzcu() {
    }

    public static void zzc() throws GeneralSecurityException {
        zzon.zza().zza(zza);
        zzon.zza().zza(zzb);
    }
}
