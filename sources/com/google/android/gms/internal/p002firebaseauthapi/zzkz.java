package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzkz implements zzla {
    private final zzdc zza;
    private final int zzb;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzla
    public final int zza() {
        return this.zzb;
    }

    public zzkz(zzdc zzdcVar) {
        this.zza = zzdcVar;
        this.zzb = zzdcVar.zzb() + zzdcVar.zzc();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzla
    public final byte[] zza(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        if (bArr2.length < i) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        return zzyn.zza(zzcx.zzb().zza(this.zza).zza(zzzo.zza(Arrays.copyOf(bArr, this.zza.zzb()), zzbl.zza())).zzb(zzzo.zza(Arrays.copyOfRange(bArr, this.zza.zzb(), this.zza.zzb() + this.zza.zzc()), zzbl.zza())).zza()).zza(Arrays.copyOfRange(bArr2, i, bArr2.length), zzkw.zza);
    }
}
