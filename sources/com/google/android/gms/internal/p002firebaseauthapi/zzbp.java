package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbp {

    @Nullable
    private final zzcg zza;

    public static zzbp zza(zzcg zzcgVar) throws GeneralSecurityException {
        return new zzbp(zzcgVar);
    }

    public final zzcg zza() throws GeneralSecurityException {
        zzcg zzcgVar = this.zza;
        return zzcgVar != null ? zzcgVar : zzco.zza(zzb().zzk());
    }

    private final zzwf zzb() {
        try {
            zzcg zzcgVar = this.zza;
            if (zzcgVar instanceof zznp) {
                return ((zznp) zzcgVar).zzb().zza();
            }
            return ((zzpm) zzom.zza().zza(this.zza, zzpm.class)).zza();
        } catch (GeneralSecurityException e) {
            throw new zzpw("Parsing parameters failed in getProto(). You probably want to call some Tink register function for " + String.valueOf(this.zza), e);
        }
    }

    private zzbp(zzcg zzcgVar) {
        this.zza = zzcgVar;
    }
}
