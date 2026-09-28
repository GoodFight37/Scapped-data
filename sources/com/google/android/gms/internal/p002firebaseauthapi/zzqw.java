package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzqw {
    static {
        zzxc.zzb();
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzqx.zzc();
        zzqk.zzc();
        zzqp.zza(true);
        if (zzij.zzb()) {
            return;
        }
        zzqb.zza(true);
    }
}
