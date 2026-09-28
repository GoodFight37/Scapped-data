package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjs extends zzkv {
    private final zzjq zza;

    @Nullable
    private final ECPoint zzb;

    @Nullable
    private final zzzn zzc;
    private final zzzn zzd;

    @Nullable
    private final Integer zze;

    public final zzjq zzb() {
        return this.zza;
    }

    public static zzjs zza(zzjq zzjqVar, zzzn zzznVar, @Nullable Integer num) throws GeneralSecurityException {
        if (!zzjqVar.zzd().equals(zzjq.zza.zzd)) {
            throw new GeneralSecurityException("createForCurveX25519 may only be called with parameters for curve X25519");
        }
        zzb(zzjqVar.zzg(), num);
        if (zzznVar.zza() == 32) {
            return new zzjs(zzjqVar, null, zzznVar, zza(zzjqVar.zzg(), num), num);
        }
        throw new GeneralSecurityException("Encoded public point byte length for X25519 curve must be 32");
    }

    public static zzjs zza(zzjq zzjqVar, ECPoint eCPoint, @Nullable Integer num) throws GeneralSecurityException {
        EllipticCurve curve;
        if (zzjqVar.zzd().equals(zzjq.zza.zzd)) {
            throw new GeneralSecurityException("createForNistCurve may only be called with parameters for NIST curve");
        }
        zzb(zzjqVar.zzg(), num);
        zzjq.zza zzaVarZzd = zzjqVar.zzd();
        if (zzaVarZzd == zzjq.zza.zza) {
            curve = zzmt.zza.getCurve();
        } else if (zzaVarZzd == zzjq.zza.zzb) {
            curve = zzmt.zzb.getCurve();
        } else if (zzaVarZzd == zzjq.zza.zzc) {
            curve = zzmt.zzc.getCurve();
        } else {
            throw new IllegalArgumentException("Unable to determine NIST curve type for " + String.valueOf(zzaVarZzd));
        }
        zzmt.zza(eCPoint, curve);
        return new zzjs(zzjqVar, eCPoint, null, zza(zzjqVar.zzg(), num), num);
    }

    private static zzzn zza(zzjq.zze zzeVar, @Nullable Integer num) {
        if (zzeVar == zzjq.zze.zzc) {
            return zzor.zza;
        }
        if (num == null) {
            throw new IllegalStateException("idRequirement must be non-null for EciesParameters.Variant: " + String.valueOf(zzeVar));
        }
        if (zzeVar == zzjq.zze.zzb) {
            return zzor.zza(num.intValue());
        }
        if (zzeVar == zzjq.zze.zza) {
            return zzor.zzb(num.intValue());
        }
        throw new IllegalStateException("Unknown EciesParameters.Variant: " + String.valueOf(zzeVar));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkv
    public final zzzn zzc() {
        return this.zzd;
    }

    @Nullable
    public final zzzn zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbo
    @Nullable
    public final Integer zza() {
        return this.zze;
    }

    @Nullable
    public final ECPoint zze() {
        return this.zzb;
    }

    private zzjs(zzjq zzjqVar, @Nullable ECPoint eCPoint, @Nullable zzzn zzznVar, zzzn zzznVar2, @Nullable Integer num) {
        this.zza = zzjqVar;
        this.zzb = eCPoint;
        this.zzc = zzznVar;
        this.zzd = zzznVar2;
        this.zze = num;
    }

    private static void zzb(zzjq.zze zzeVar, @Nullable Integer num) throws GeneralSecurityException {
        if (!zzeVar.equals(zzjq.zze.zzc) && num == null) {
            throw new GeneralSecurityException("'idRequirement' must be non-null for " + String.valueOf(zzeVar) + " variant.");
        }
        if (zzeVar.equals(zzjq.zze.zzc) && num != null) {
            throw new GeneralSecurityException("'idRequirement' must be null for NO_PREFIX variant.");
        }
    }
}
