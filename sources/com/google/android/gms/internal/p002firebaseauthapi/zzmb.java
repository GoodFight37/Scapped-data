package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzmb implements zzlo {
    private final zzyl zza;
    private final zzli zzb;

    static zzmb zza(zzyl zzylVar) throws GeneralSecurityException {
        int i = zzma.zza[zzylVar.ordinal()];
        if (i == 1) {
            return new zzmb(new zzli("HmacSha256"), zzyl.NIST_P256);
        }
        if (i == 2) {
            return new zzmb(new zzli("HmacSha384"), zzyl.NIST_P384);
        }
        if (i == 3) {
            return new zzmb(new zzli("HmacSha512"), zzyl.NIST_P521);
        }
        throw new GeneralSecurityException("invalid curve type: " + String.valueOf(zzylVar));
    }

    private zzmb(zzli zzliVar, zzyl zzylVar) {
        this.zzb = zzliVar;
        this.zza = zzylVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlo
    public final byte[] zza(byte[] bArr, zzlr zzlrVar) throws GeneralSecurityException {
        ECPrivateKey eCPrivateKeyZza = zzyi.zza(this.zza, zzlrVar.zza().zzb());
        zzyl zzylVar = this.zza;
        byte[] bArrZza = zzyi.zza(eCPrivateKeyZza, zzyi.zza(zzyi.zza(zzylVar), zzyk.UNCOMPRESSED, bArr));
        byte[] bArrZza2 = zzyc.zza(bArr, zzlrVar.zzb().zzb());
        byte[] bArrZza3 = zzlu.zza(zza());
        zzli zzliVar = this.zzb;
        return zzliVar.zza(null, bArrZza, "eae_prk", bArrZza2, "shared_secret", bArrZza3, zzliVar.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlo
    public final byte[] zza() throws GeneralSecurityException {
        int i = zzma.zza[this.zza.ordinal()];
        if (i == 1) {
            return zzlu.zzc;
        }
        if (i == 2) {
            return zzlu.zzd;
        }
        if (i == 3) {
            return zzlu.zze;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
