package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzh extends zzi {
    private final char zza;

    public final String toString() {
        char c = this.zza;
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c & 15);
            c = (char) (c >> 4);
        }
        return "CharMatcher.is('" + String.copyValueOf(cArr) + "')";
    }

    zzh(char c) {
        this.zza = c;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzf
    public final boolean zza(char c) {
        return c == this.zza;
    }
}
