package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzzo {
    private final zzzn zza;

    public final int zza() {
        return this.zza.zza();
    }

    public static zzzo zza(byte[] bArr, zzcm zzcmVar) {
        if (zzcmVar == null) {
            throw new NullPointerException("SecretKeyAccess required");
        }
        return new zzzo(zzzn.zza(bArr));
    }

    public static zzzo zza(int i) {
        return new zzzo(zzzn.zza(zzpp.zza(i)));
    }

    private zzzo(zzzn zzznVar) {
        this.zza = zzznVar;
    }

    public final byte[] zza(zzcm zzcmVar) {
        if (zzcmVar == null) {
            throw new NullPointerException("SecretKeyAccess required");
        }
        return this.zza.zzb();
    }
}
