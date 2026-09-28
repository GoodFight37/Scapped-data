package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzzg implements zzcd {
    private static final byte[] zza = {0};
    private final zzrx zzb;
    private final int zzc;
    private final byte[] zzd;
    private final byte[] zze;

    public static zzcd zza(zzqa zzqaVar) throws GeneralSecurityException {
        return new zzzg(zzqaVar);
    }

    public static zzcd zza(zzql zzqlVar) throws GeneralSecurityException {
        return new zzzg(zzqlVar);
    }

    private zzzg(zzqa zzqaVar) throws GeneralSecurityException {
        this.zzb = new zzzc(zzqaVar.zze().zza(zzbl.zza()));
        this.zzc = zzqaVar.zzc().zzb();
        this.zzd = zzqaVar.zzd().zzb();
        if (zzqaVar.zzc().zze().equals(zzqf.zza.zzc)) {
            byte[] bArr = zza;
            this.zze = Arrays.copyOf(bArr, bArr.length);
        } else {
            this.zze = new byte[0];
        }
    }

    private zzzg(zzql zzqlVar) throws GeneralSecurityException {
        this.zzb = new zzze("HMAC" + String.valueOf(zzqlVar.zzc().zze()), new SecretKeySpec(zzqlVar.zze().zza(zzbl.zza()), "HMAC"));
        this.zzc = zzqlVar.zzc().zzb();
        this.zzd = zzqlVar.zzd().zzb();
        if (zzqlVar.zzc().zzf().equals(zzqs.zzc.zzc)) {
            byte[] bArr = zza;
            this.zze = Arrays.copyOf(bArr, bArr.length);
        } else {
            this.zze = new byte[0];
        }
    }

    public zzzg(zzrx zzrxVar, int i) throws GeneralSecurityException {
        this.zzb = zzrxVar;
        this.zzc = i;
        this.zzd = new byte[0];
        this.zze = new byte[0];
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        zzrxVar.zza(new byte[0], i);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcd
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!MessageDigest.isEqual(zza(bArr2), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcd
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = this.zze;
        if (bArr2.length > 0) {
            return zzyc.zza(this.zzd, this.zzb.zza(zzyc.zza(bArr, bArr2), this.zzc));
        }
        return zzyc.zza(this.zzd, this.zzb.zza(bArr, this.zzc));
    }
}
