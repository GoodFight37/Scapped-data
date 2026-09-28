package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbc {
    public static long zza(long j, long j2) {
        long j3 = j + j2;
        zzbb.zza(((j ^ j2) < 0) | ((j ^ j3) >= 0), "checkedAdd", j, j2);
        return j3;
    }

    public static long zzb(long j, long j2) {
        long j3 = j - 1;
        zzbb.zza(((1 ^ j) >= 0) | ((j ^ j3) >= 0), "checkedSubtract", j, 1L);
        return j3;
    }
}
