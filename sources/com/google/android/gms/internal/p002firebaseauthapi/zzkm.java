package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzkm implements zzbj {
    private final zzpg<zzbj> zza;
    private final zznv zzb;

    public zzkm(zzpg<zzbj> zzpgVar) {
        this.zza = zzpgVar;
        if (zzpgVar.zzf()) {
            this.zzb = zzoj.zzb().zza().zza(zzny.zza(zzpgVar), "hybrid_decrypt", "decrypt");
        } else {
            this.zzb = zzny.zza;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbj
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 5) {
            for (zzpi<zzbj> zzpiVar : this.zza.zza(Arrays.copyOfRange(bArr, 0, 5))) {
                try {
                    byte[] bArrZza = zzpiVar.zzd().zza(bArr, bArr2);
                    this.zzb.zza(zzpiVar.zza(), bArr.length);
                    return bArrZza;
                } catch (GeneralSecurityException unused) {
                }
            }
        }
        for (zzpi<zzbj> zzpiVar2 : this.zza.zza(zzbi.zza)) {
            try {
                byte[] bArrZza2 = zzpiVar2.zzd().zza(bArr, bArr2);
                this.zzb.zza(zzpiVar2.zza(), bArr.length);
                return bArrZza2;
            } catch (GeneralSecurityException unused2) {
            }
        }
        this.zzb.zza();
        throw new GeneralSecurityException("decryption failed");
    }
}
