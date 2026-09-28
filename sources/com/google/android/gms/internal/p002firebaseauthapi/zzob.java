package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class zzob {
    static final /* synthetic */ int[] zza;

    static {
        int[] iArr = new int[zzwc.values().length];
        zza = iArr;
        try {
            iArr[zzwc.ENABLED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zza[zzwc.DISABLED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zza[zzwc.DESTROYED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
