package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzqk implements zzpk<zzqh, zzqh> {
    private static final zzqk zza = new zzqk();

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpk
    public final Class<zzqh> zza() {
        return zzqh.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpk
    public final Class<zzqh> zzb() {
        return zzqh.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpk
    public final /* synthetic */ zzqh zza(zzpg<zzqh> zzpgVar) throws GeneralSecurityException {
        if (zzpgVar == null) {
            throw new GeneralSecurityException("primitive set must be non-null");
        }
        if (zzpgVar.zzb() == null) {
            throw new GeneralSecurityException("no primary in primitive set");
        }
        Iterator<List<zzpi<zzqh>>> it = zzpgVar.zzd().iterator();
        while (it.hasNext()) {
            Iterator<zzpi<zzqh>> it2 = it.next().iterator();
            while (it2.hasNext()) {
                it2.next().zzd();
            }
        }
        return new zzqj(zzpgVar);
    }

    private zzqk() {
    }

    static void zzc() throws GeneralSecurityException {
        zzon.zza().zza(zza);
    }
}
