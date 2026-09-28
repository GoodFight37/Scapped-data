package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzmh implements zzmd {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmd
    public final zzmc zza() throws GeneralSecurityException {
        byte[] bArrZza = zzzl.zza();
        return new zzmc(bArrZza, zzzl.zza(bArrZza));
    }

    private zzmh() {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmd
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzzl.zza(bArr, bArr2);
    }
}
