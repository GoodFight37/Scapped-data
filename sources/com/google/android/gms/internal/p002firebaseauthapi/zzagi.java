package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public enum zzagi {
    REFRESH_TOKEN("refresh_token"),
    AUTHORIZATION_CODE("authorization_code");

    private final String zzd;

    @Override // java.lang.Enum
    public final String toString() {
        return this.zzd;
    }

    zzagi(String str) {
        this.zzd = str;
    }
}
