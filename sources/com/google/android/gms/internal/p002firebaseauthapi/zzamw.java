package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzamw extends RuntimeException {
    public final zzakm zza() {
        return new zzakm(getMessage());
    }

    public zzamw(zzaln zzalnVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }
}
