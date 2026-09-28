package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzme implements zzlo {
    private final zzli zza;
    private final zzmd zzb;

    zzme(zzli zzliVar) {
        zzmd zzmhVar;
        this.zza = zzliVar;
        try {
            zzmhVar = zzmf.zzb();
        } catch (GeneralSecurityException unused) {
            zzmhVar = new zzmh();
        }
        this.zzb = zzmhVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlo
    public final byte[] zza(byte[] bArr, zzlr zzlrVar) throws GeneralSecurityException {
        byte[] bArrZza = this.zzb.zza(zzlrVar.zza().zzb(), bArr);
        byte[] bArrZza2 = zzyc.zza(bArr, zzlrVar.zzb().zzb());
        byte[] bArrZza3 = zzlu.zza(zzlu.zzb);
        zzli zzliVar = this.zza;
        return zzliVar.zza(null, bArrZza, "eae_prk", bArrZza2, "shared_secret", bArrZza3, zzliVar.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlo
    public final byte[] zza() throws GeneralSecurityException {
        if (Arrays.equals(this.zza.zzb(), zzlu.zzf)) {
            return zzlu.zzb;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
