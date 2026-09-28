package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzjc implements zzbk {
    private final zzpg<zzbk> zza;
    private final zznv zzb;

    public zzjc(zzpg<zzbk> zzpgVar) {
        this.zza = zzpgVar;
        if (!zzpgVar.zzf()) {
            this.zzb = zzny.zza;
            return;
        }
        zzns zznsVarZza = zzoj.zzb().zza();
        zznu zznuVarZza = zzny.zza(zzpgVar);
        zznsVarZza.zza(zznuVarZza, "daead", "encrypt");
        this.zzb = zznsVarZza.zza(zznuVarZza, "daead", "decrypt");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbk
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 5) {
            for (zzpi<zzbk> zzpiVar : this.zza.zza(Arrays.copyOf(bArr, 5))) {
                try {
                    byte[] bArrZza = zzpiVar.zzd().zza(bArr, bArr2);
                    this.zzb.zza(zzpiVar.zza(), bArr.length);
                    return bArrZza;
                } catch (GeneralSecurityException unused) {
                }
            }
        }
        for (zzpi<zzbk> zzpiVar2 : this.zza.zza(zzbi.zza)) {
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
