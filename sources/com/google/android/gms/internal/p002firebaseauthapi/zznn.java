package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zznn extends zzbo {
    private final zzpn zza;

    public final zzpn zza(@Nullable zzcm zzcmVar) throws GeneralSecurityException {
        zza(this.zza, zzcmVar);
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbo
    @Nullable
    public final Integer zza() {
        return this.zza.zze();
    }

    public zznn(zzpn zzpnVar, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        zza(zzpnVar, zzcmVar);
        this.zza = zzpnVar;
    }

    private static void zza(zzpn zzpnVar, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        int i = zznm.zza[zzpnVar.zza().ordinal()];
        if (i == 1 || i == 2) {
            zzcm.zza(zzcmVar);
        }
    }
}
