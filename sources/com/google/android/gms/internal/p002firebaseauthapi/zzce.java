package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzce {
    public static zzbs zza(zzca zzcaVar, zzcm zzcmVar) throws GeneralSecurityException, IOException {
        if (zzcmVar != null) {
            return zzbs.zza(zzcaVar.zzb());
        }
        throw new NullPointerException("SecretKeyAccess cannot be null");
    }

    public static void zza(zzbs zzbsVar, zzbz zzbzVar, zzcm zzcmVar) throws IOException {
        if (zzcmVar == null) {
            throw new NullPointerException("SecretKeyAccess cannot be null");
        }
        zzbzVar.zza(zzbsVar.zzb());
    }
}
