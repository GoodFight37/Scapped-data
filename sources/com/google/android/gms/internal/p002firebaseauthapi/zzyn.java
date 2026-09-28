package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzyn implements zzbe {
    private final zzzd zza;
    private final zzcd zzb;
    private final int zzc;
    private final byte[] zzd;

    public static zzbe zza(zzcx zzcxVar) throws GeneralSecurityException {
        return new zzyn(new zzxu(zzcxVar.zze().zza(zzbl.zza()), zzcxVar.zzc().zzd()), new zzzg(new zzze("HMAC" + String.valueOf(zzcxVar.zzc().zzg()), new SecretKeySpec(zzcxVar.zzf().zza(zzbl.zza()), "HMAC")), zzcxVar.zzc().zze()), zzcxVar.zzc().zze(), zzcxVar.zzd().zzb());
    }

    private zzyn(zzzd zzzdVar, zzcd zzcdVar, int i, byte[] bArr) {
        this.zza = zzzdVar;
        this.zzb = zzcdVar;
        this.zzc = i;
        this.zzd = bArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzc;
        byte[] bArr3 = this.zzd;
        if (length < i + bArr3.length) {
            throw new GeneralSecurityException("Decryption failed (ciphertext too short).");
        }
        if (!zzpy.zza(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, this.zzd.length, bArr.length - this.zzc);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - this.zzc, bArr.length);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        this.zzb.zza(bArrCopyOfRange2, zzyc.zza(bArr2, bArrCopyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8)));
        return this.zza.zza(bArrCopyOfRange);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArrZzb = this.zza.zzb(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return zzyc.zza(this.zzd, bArrZzb, this.zzb.zza(zzyc.zza(bArr2, bArrZzb, Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8))));
    }
}
