package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzny {
    public static final zznv zza = new zzoa();

    public static <P> zznu zza(zzpg<P> zzpgVar) {
        zzbq zzbqVar;
        zznx zznxVar = new zznx();
        zznxVar.zza(zzpgVar.zza());
        Iterator<List<zzpi<P>>> it = zzpgVar.zzd().iterator();
        while (it.hasNext()) {
            for (zzpi<P> zzpiVar : it.next()) {
                int i = zzob.zza[zzpiVar.zzb().ordinal()];
                if (i == 1) {
                    zzbqVar = zzbq.zza;
                } else if (i == 2) {
                    zzbqVar = zzbq.zzb;
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("Unknown key status");
                    }
                    zzbqVar = zzbq.zzc;
                }
                int iZza = zzpiVar.zza();
                String strZze = zzpiVar.zze();
                if (strZze.startsWith("type.googleapis.com/google.crypto.")) {
                    strZze = strZze.substring(34);
                }
                zznxVar.zza(zzbqVar, iZza, strZze, zzpiVar.zzc().name());
            }
        }
        if (zzpgVar.zzb() != null) {
            zznxVar.zza(zzpgVar.zzb().zza());
        }
        try {
            return zznxVar.zza();
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
