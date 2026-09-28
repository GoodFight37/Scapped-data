package com.google.android.gms.common;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzn extends zzm {
    private final byte[] zza;

    zzn(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.zza = bArr;
    }

    @Override // com.google.android.gms.common.zzm
    final byte[] zzf() {
        return this.zza;
    }
}
