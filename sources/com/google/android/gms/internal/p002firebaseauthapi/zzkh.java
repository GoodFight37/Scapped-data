package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzkh {
    private static final zzmz zza = zzb();

    public static zzbf zza() throws GeneralSecurityException {
        if (zzij.zzb()) {
            throw new GeneralSecurityException("Cannot use non-FIPS-compliant HybridConfigurationV0 in FIPS mode");
        }
        return zza;
    }

    private static zzmz zzb() {
        try {
            zzpf zzpfVarZza = zzpc.zza();
            zzkp.zza(zzpfVarZza);
            zzpfVarZza.zza(zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkg
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
                public final Object zza(zzbo zzboVar) {
                    return zzyh.zza((zzjs) zzboVar);
                }
            }, zzjs.class, zzbm.class));
            zzpfVarZza.zza(zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkj
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
                public final Object zza(zzbo zzboVar) {
                    return zzlm.zza((zzkf) zzboVar);
                }
            }, zzkf.class, zzbm.class));
            zzkk.zza(zzpfVarZza);
            zzpfVarZza.zza(zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzki
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
                public final Object zza(zzbo zzboVar) {
                    return zzye.zza((zzjt) zzboVar);
                }
            }, zzjt.class, zzbj.class));
            zzpfVarZza.zza(zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkl
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
                public final Object zza(zzbo zzboVar) {
                    return zzln.zza((zzjx) zzboVar);
                }
            }, zzjx.class, zzbj.class));
            return zzmz.zza(zzpfVarZza.zza());
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
