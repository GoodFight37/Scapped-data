package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzed extends zzcp {
    private final zzeg zza;
    private final zzzo zzb;
    private final zzzn zzc;

    @Nullable
    private final Integer zzd;

    public static zzed zza(zzeg.zza zzaVar, zzzo zzzoVar, @Nullable Integer num) throws GeneralSecurityException {
        zzzn zzznVarZzb;
        if (zzaVar != zzeg.zza.zzc && num == null) {
            throw new GeneralSecurityException("For given Variant " + String.valueOf(zzaVar) + " the value of idRequirement must be non-null");
        }
        if (zzaVar == zzeg.zza.zzc && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzzoVar.zza() != 32) {
            throw new GeneralSecurityException("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zzzoVar.zza());
        }
        zzeg zzegVarZza = zzeg.zza(zzaVar);
        if (zzegVarZza.zzb() == zzeg.zza.zzc) {
            zzznVarZzb = zzor.zza;
        } else if (zzegVarZza.zzb() == zzeg.zza.zzb) {
            zzznVarZzb = zzor.zza(num.intValue());
        } else {
            if (zzegVarZza.zzb() != zzeg.zza.zza) {
                throw new IllegalStateException("Unknown Variant: " + String.valueOf(zzegVarZza.zzb()));
            }
            zzznVarZzb = zzor.zzb(num.intValue());
        }
        return new zzed(zzegVarZza, zzzoVar, zzznVarZzb, num);
    }

    public final zzeg zzb() {
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

    private zzed(zzeg zzegVar, zzzo zzzoVar, zzzn zzznVar, @Nullable Integer num) {
        this.zza = zzegVar;
        this.zzb = zzzoVar;
        this.zzc = zzznVar;
        this.zzd = num;
    }
}
