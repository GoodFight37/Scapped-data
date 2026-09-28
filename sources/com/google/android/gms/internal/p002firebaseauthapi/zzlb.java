package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzlb implements zzla {
    private final zzit zza;
    private final int zzb;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzla
    public final int zza() {
        return this.zzb;
    }

    public zzlb(zzit zzitVar) {
        this.zza = zzitVar;
        this.zzb = zzitVar.zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzla
    public final byte[] zza(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        if (bArr2.length < i) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        return zzya.zza(zzio.zzb().zza(this.zza).zza(zzzo.zza(bArr, zzbl.zza())).zza()).zza(Arrays.copyOfRange(bArr2, i, bArr2.length), zzkw.zza);
    }
}
