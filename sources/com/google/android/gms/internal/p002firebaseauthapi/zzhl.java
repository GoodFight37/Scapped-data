package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzhl extends zzho {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzho
    final zzhm zza(byte[] bArr, int i) throws InvalidKeyException {
        return new zzhj(bArr, i);
    }

    public zzhl(byte[] bArr) throws GeneralSecurityException {
        super(bArr);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzho
    public final /* bridge */ /* synthetic */ void zza(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        super.zza(byteBuffer, bArr, bArr2, bArr3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzho
    public final /* bridge */ /* synthetic */ byte[] zza(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return super.zza(byteBuffer, bArr, bArr2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzho
    public final /* bridge */ /* synthetic */ byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return super.zza(bArr, bArr2, bArr3);
    }
}
