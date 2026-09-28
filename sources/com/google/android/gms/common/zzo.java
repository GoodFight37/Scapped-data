package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
abstract class zzo extends zzm {
    private static final WeakReference zza = new WeakReference(null);
    private WeakReference zzb;

    zzo(byte[] bArr) {
        super(bArr);
        this.zzb = zza;
    }

    protected abstract byte[] zzb();

    @Override // com.google.android.gms.common.zzm
    final byte[] zzf() {
        byte[] bArrZzb;
        synchronized (this) {
            bArrZzb = (byte[]) this.zzb.get();
            if (bArrZzb == null) {
                bArrZzb = zzb();
                this.zzb = new WeakReference(bArrZzb);
            }
        }
        return bArrZzb;
    }
}
