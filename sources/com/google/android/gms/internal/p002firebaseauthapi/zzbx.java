package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbx {
    private final zzwl.zzb zza;

    public final synchronized zzbs zza() throws GeneralSecurityException {
        return zzbs.zza((zzwl) ((zzakg) this.zza.zze()));
    }

    public static zzbx zza(zzbs zzbsVar) {
        return new zzbx(zzbsVar.zzb().zzn());
    }

    private zzbx(zzwl.zzb zzbVar) {
        this.zza = zzbVar;
    }
}
