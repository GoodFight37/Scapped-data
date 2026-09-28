package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaja extends zzajh {
    private final int zzc;
    private final int zzd;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajh, com.google.android.gms.internal.p002firebaseauthapi.zzaiw
    public final byte zza(int i) {
        int iZzb = zzb();
        if (((iZzb - (i + 1)) | i) >= 0) {
            return this.zzb[this.zzc + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + iZzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajh, com.google.android.gms.internal.p002firebaseauthapi.zzaiw
    final byte zzb(int i) {
        return this.zzb[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajh
    protected final int zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajh, com.google.android.gms.internal.p002firebaseauthapi.zzaiw
    public final int zzb() {
        return this.zzd;
    }

    zzaja(byte[] bArr, int i, int i2) {
        super(bArr);
        zza(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajh, com.google.android.gms.internal.p002firebaseauthapi.zzaiw
    protected final void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, zze(), bArr, 0, i3);
    }
}
