package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzqz implements zzcd {
    private final zzpg<zzcd> zza;
    private final zznv zzb;
    private final zznv zzc;

    private zzqz(zzpg<zzcd> zzpgVar) {
        this.zza = zzpgVar;
        if (!zzpgVar.zzf()) {
            this.zzb = zzny.zza;
            this.zzc = zzny.zza;
        } else {
            zzns zznsVarZza = zzoj.zzb().zza();
            zznu zznuVarZza = zzny.zza(zzpgVar);
            this.zzb = zznsVarZza.zza(zznuVarZza, "mac", "compute");
            this.zzc = zznsVarZza.zza(zznuVarZza, "mac", "verify");
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcd
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length <= 5) {
            this.zzc.zza();
            throw new GeneralSecurityException("tag too short");
        }
        for (zzpi<zzcd> zzpiVar : this.zza.zza(Arrays.copyOf(bArr, 5))) {
            try {
                zzpiVar.zzd().zza(bArr, bArr2);
                this.zzc.zza(zzpiVar.zza(), bArr2.length);
                return;
            } catch (GeneralSecurityException unused) {
            }
        }
        for (zzpi<zzcd> zzpiVar2 : this.zza.zze()) {
            try {
                zzpiVar2.zzd().zza(bArr, bArr2);
                this.zzc.zza(zzpiVar2.zza(), bArr2.length);
                return;
            } catch (GeneralSecurityException unused2) {
            }
        }
        this.zzc.zza();
        throw new GeneralSecurityException("invalid MAC");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcd
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        try {
            byte[] bArrZza = this.zza.zzb().zzd().zza(bArr);
            this.zzb.zza(this.zza.zzb().zza(), bArr.length);
            return bArrZza;
        } catch (GeneralSecurityException e) {
            this.zzb.zza();
            throw e;
        }
    }
}
