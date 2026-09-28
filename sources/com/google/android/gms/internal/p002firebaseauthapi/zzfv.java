package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfv extends zzcp {
    private final zzfy zza;
    private final zzzo zzb;
    private final zzzn zzc;

    @Nullable
    private final Integer zzd;

    public static zzfv zza(zzfy.zza zzaVar, zzzo zzzoVar, @Nullable Integer num) throws GeneralSecurityException {
        zzzn zzznVarZzb;
        if (zzaVar != zzfy.zza.zzc && num == null) {
            throw new GeneralSecurityException("For given Variant " + String.valueOf(zzaVar) + " the value of idRequirement must be non-null");
        }
        if (zzaVar == zzfy.zza.zzc && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzzoVar.zza() != 32) {
            throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zzzoVar.zza());
        }
        zzfy zzfyVarZza = zzfy.zza(zzaVar);
        if (zzfyVarZza.zzb() == zzfy.zza.zzc) {
            zzznVarZzb = zzor.zza;
        } else if (zzfyVarZza.zzb() == zzfy.zza.zzb) {
            zzznVarZzb = zzor.zza(num.intValue());
        } else {
            if (zzfyVarZza.zzb() != zzfy.zza.zza) {
                throw new IllegalStateException("Unknown Variant: " + String.valueOf(zzfyVarZza.zzb()));
            }
            zzznVarZzb = zzor.zzb(num.intValue());
        }
        return new zzfv(zzfyVarZza, zzzoVar, zzznVarZzb, num);
    }

    public final zzfy zzb() {
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

    private zzfv(zzfy zzfyVar, zzzo zzzoVar, zzzn zzznVar, @Nullable Integer num) {
        this.zza = zzfyVar;
        this.zzb = zzzoVar;
        this.zzc = zzznVar;
        this.zzd = num;
    }
}
