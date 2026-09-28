package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class zzgg {
    static final /* synthetic */ int[] zza;
    static final /* synthetic */ int[] zzb;

    static {
        int[] iArr = new int[zzvc.values().length];
        zzb = iArr;
        try {
            iArr[zzvc.SHA1.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zzb[zzvc.SHA224.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zzb[zzvc.SHA256.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            zzb[zzvc.SHA384.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            zzb[zzvc.SHA512.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        int[] iArr2 = new int[zzxd.values().length];
        zza = iArr2;
        try {
            iArr2[zzxd.TINK.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            zza[zzxd.CRUNCHY.ordinal()] = 2;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            zza[zzxd.LEGACY.ordinal()] = 3;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            zza[zzxd.RAW.ordinal()] = 4;
        } catch (NoSuchFieldError unused9) {
        }
    }
}
