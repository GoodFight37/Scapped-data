package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzap {
    private final Object zza;
    private final Object zzb;
    private final Object zzc;

    final IllegalArgumentException zza() {
        return new IllegalArgumentException("Multiple entries with same key: " + String.valueOf(this.zza) + "=" + String.valueOf(this.zzb) + " and " + String.valueOf(this.zza) + "=" + String.valueOf(this.zzc));
    }

    zzap(Object obj, Object obj2, Object obj3) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = obj3;
    }
}
