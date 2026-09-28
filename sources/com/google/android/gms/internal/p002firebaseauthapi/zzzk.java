package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzzk implements zzbe {
    private final zzhp zza;
    private final byte[] zzb;

    public static zzbe zza(zzfv zzfvVar) throws GeneralSecurityException {
        return new zzzk(zzfvVar.zzd().zza(zzbl.zza()), zzfvVar.zzc().zzb());
    }

    private zzzk(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        this.zza = new zzhp(bArr);
        this.zzb = bArr2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return zzc(bArr, bArr2);
        }
        if (!zzpy.zza(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        return zzc(Arrays.copyOfRange(bArr, this.zzb.length, bArr.length), bArr2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 40);
        byte[] bArrZza = zzpp.zza(24);
        byteBufferAllocate.put(bArrZza);
        this.zza.zza(byteBufferAllocate, bArrZza, bArr, bArr2);
        byte[] bArrArray = byteBufferAllocate.array();
        byte[] bArr3 = this.zzb;
        return bArr3.length == 0 ? bArrArray : zzyc.zza(bArr3, bArrArray);
    }

    private final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 40) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 24);
        return this.zza.zza(ByteBuffer.wrap(bArr, 24, bArr.length - 24), bArrCopyOf, bArr2);
    }
}
