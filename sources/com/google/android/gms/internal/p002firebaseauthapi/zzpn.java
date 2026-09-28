package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzpn implements zzpq {
    private final String zza;
    private final zzzn zzb;
    private final zzaiw zzc;
    private final zzwb.zza zzd;
    private final zzxd zze;

    @Nullable
    private final Integer zzf;

    public static zzpn zza(String str, zzaiw zzaiwVar, zzwb.zza zzaVar, zzxd zzxdVar, @Nullable Integer num) throws GeneralSecurityException {
        if (zzxdVar == zzxd.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new zzpn(str, zzpy.zza(str), zzaiwVar, zzaVar, zzxdVar, num);
    }

    public final zzwb.zza zza() {
        return this.zzd;
    }

    public final zzxd zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpq
    public final zzzn zzb() {
        return this.zzb;
    }

    public final zzaiw zzd() {
        return this.zzc;
    }

    @Nullable
    public final Integer zze() {
        return this.zzf;
    }

    public final String zzf() {
        return this.zza;
    }

    private zzpn(String str, zzzn zzznVar, zzaiw zzaiwVar, zzwb.zza zzaVar, zzxd zzxdVar, @Nullable Integer num) {
        this.zza = str;
        this.zzb = zzznVar;
        this.zzc = zzaiwVar;
        this.zzd = zzaVar;
        this.zze = zzxdVar;
        this.zzf = num;
    }
}
