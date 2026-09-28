package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class zzma {
    static final /* synthetic */ int[] zza;

    static {
        int[] iArr = new int[zzyl.values().length];
        zza = iArr;
        try {
            iArr[zzyl.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zza[zzyl.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zza[zzyl.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
