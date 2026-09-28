package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjt extends zzks {
    private final zzjs zza;

    @Nullable
    private final zzzm zzb;

    @Nullable
    private final zzzo zzc;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzks, com.google.android.gms.internal.p002firebaseauthapi.zzcf
    public final /* synthetic */ zzbo zzb() {
        return (zzjs) zzb();
    }

    public final zzjq zzc() {
        return this.zza.zzb();
    }

    public static zzjt zza(zzjs zzjsVar, zzzo zzzoVar) throws GeneralSecurityException {
        if (zzjsVar == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
        }
        if (zzjsVar.zzd() == null) {
            throw new GeneralSecurityException("ECIES private key for X25519 curve cannot be constructed with NIST-curve public key");
        }
        if (zzzoVar == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
        }
        byte[] bArrZza = zzzoVar.zza(zzbl.zza());
        byte[] bArrZzb = zzjsVar.zzd().zzb();
        if (bArrZza.length != 32) {
            throw new GeneralSecurityException("Private key bytes length for X25519 curve must be 32");
        }
        if (!Arrays.equals(zzzl.zza(bArrZza), bArrZzb)) {
            throw new GeneralSecurityException("Invalid private key for public key.");
        }
        return new zzjt(zzjsVar, null, zzzoVar);
    }

    public static zzjt zza(zzjs zzjsVar, zzzm zzzmVar) throws GeneralSecurityException {
        if (zzjsVar == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
        }
        if (zzjsVar.zze() == null) {
            throw new GeneralSecurityException("ECIES private key for NIST curve cannot be constructed with X25519-curve public key");
        }
        if (zzzmVar == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
        }
        BigInteger bigIntegerZza = zzzmVar.zza(zzbl.zza());
        ECPoint eCPointZze = zzjsVar.zze();
        zzjq.zza zzaVarZzd = zzjsVar.zzb().zzd();
        BigInteger order = zza(zzaVarZzd).getOrder();
        if (bigIntegerZza.signum() <= 0 || bigIntegerZza.compareTo(order) >= 0) {
            throw new GeneralSecurityException("Invalid private value");
        }
        if (!zzmt.zza(bigIntegerZza, zza(zzaVarZzd)).equals(eCPointZze)) {
            throw new GeneralSecurityException("Invalid private value");
        }
        return new zzjt(zzjsVar, zzzmVar, null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzks
    /* JADX INFO: renamed from: zzd */
    public final /* synthetic */ zzkv zzb() {
        return this.zza;
    }

    @Nullable
    public final zzzm zze() {
        return this.zzb;
    }

    @Nullable
    public final zzzo zzf() {
        return this.zzc;
    }

    private static ECParameterSpec zza(zzjq.zza zzaVar) {
        if (zzaVar == zzjq.zza.zza) {
            return zzmt.zza;
        }
        if (zzaVar == zzjq.zza.zzb) {
            return zzmt.zzb;
        }
        if (zzaVar == zzjq.zza.zzc) {
            return zzmt.zzc;
        }
        throw new IllegalArgumentException("Unable to determine NIST curve type for " + String.valueOf(zzaVar));
    }

    private zzjt(zzjs zzjsVar, @Nullable zzzm zzzmVar, @Nullable zzzo zzzoVar) {
        this.zza = zzjsVar;
        this.zzb = zzzmVar;
        this.zzc = zzzoVar;
    }
}
