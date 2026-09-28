package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfq extends zzcp {
    private final zzft zza;
    private final zzzo zzb;
    private final zzzn zzc;

    @Nullable
    private final Integer zzd;

    public static zzfq zza(zzft zzftVar, zzzo zzzoVar, @Nullable Integer num) throws GeneralSecurityException {
        zzzn zzznVarZzb;
        if (zzftVar.zzc() != zzft.zza.zzb && num == null) {
            throw new GeneralSecurityException("For given Variant " + String.valueOf(zzftVar.zzc()) + " the value of idRequirement must be non-null");
        }
        if (zzftVar.zzc() == zzft.zza.zzb && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzzoVar.zza() != 32) {
            throw new GeneralSecurityException("XAesGcmKey key must be constructed with key of length 32 bytes, not " + zzzoVar.zza());
        }
        if (zzftVar.zzc() == zzft.zza.zzb) {
            zzznVarZzb = zzor.zza;
        } else {
            if (zzftVar.zzc() != zzft.zza.zza) {
                throw new IllegalStateException("Unknown Variant: " + String.valueOf(zzftVar.zzc()));
            }
            zzznVarZzb = zzor.zzb(num.intValue());
        }
        return new zzfq(zzftVar, zzzoVar, zzznVarZzb, num);
    }

    public final zzft zzb() {
        return this.zza;
    }

    public final zzzn zzc() {
        return this.zzc;
    }

    public final zzzo zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbo
    @Nullable
    public final Integer zza() {
        return this.zzd;
    }

    private zzfq(zzft zzftVar, zzzo zzzoVar, zzzn zzznVar, @Nullable Integer num) {
        this.zza = zzftVar;
        this.zzb = zzzoVar;
        this.zzc = zzznVar;
        this.zzd = num;
    }
}
