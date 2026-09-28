package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzhj extends zzhm {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzhm
    public final int zza() {
        return 12;
    }

    public zzhj(byte[] bArr, int i) throws InvalidKeyException {
        super(bArr, i);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzhm
    public final /* bridge */ /* synthetic */ void zza(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        super.zza(byteBuffer, bArr, bArr2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzhm
    public final /* bridge */ /* synthetic */ byte[] zza(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        return super.zza(bArr, byteBuffer);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzhm
    public final int[] zza(int[] iArr, int i) {
        if (iArr.length != 3) {
            throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length << 5)));
        }
        int[] iArr2 = new int[16];
        zzhh.zza(iArr2, this.zza);
        iArr2[12] = i;
        System.arraycopy(iArr, 0, iArr2, 13, iArr.length);
        return iArr2;
    }
}
