package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzlq {
    private static final zzoy<zzjx, zzbj> zza = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlt
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzln.zza((zzjx) zzboVar);
        }
    }, zzjx.class, zzbj.class);
    private static final zzoy<zzkf, zzbm> zzb = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzls
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzlm.zza((zzkf) zzboVar);
        }
    }, zzkf.class, zzbm.class);
    private static final zzci<zzbj> zzc = zznl.zza("type.googleapis.com/google.crypto.tink.HpkePrivateKey", zzbj.class, zzvv.zzf());
    private static final zzbn<zzbm> zzd = zznl.zza("type.googleapis.com/google.crypto.tink.HpkePublicKey", zzbm.class, zzwb.zza.ASYMMETRIC_PUBLIC, zzvy.zzg());
    private static final zzoe<zzju> zze = new zzoe() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlv
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoe
        public final zzbo zza(zzcg zzcgVar, Integer num) {
            return zzlq.zza((zzju) zzcgVar, num);
        }
    };

    public static /* synthetic */ zzjx zza(zzju zzjuVar, Integer num) throws GeneralSecurityException {
        byte[] bArr;
        zzzn zzznVarZza;
        zzzo zzzoVarZza;
        if (zzjuVar.zze().equals(zzju.zzd.zzd)) {
            byte[] bArrZza = zzzl.zza();
            zzzoVarZza = zzzo.zza(bArrZza, zzbl.zza());
            zzznVarZza = zzzn.zza(zzzl.zza(bArrZza));
        } else {
            if (!zzjuVar.zze().equals(zzju.zzd.zza) && !zzjuVar.zze().equals(zzju.zzd.zzb) && !zzjuVar.zze().equals(zzju.zzd.zzc)) {
                throw new GeneralSecurityException("Unknown KEM ID");
            }
            zzyl zzylVarZzc = zzlu.zzc(zzjuVar.zze());
            KeyPair keyPairZza = zzyi.zza(zzyi.zza(zzylVarZzc));
            zzyk zzykVar = zzyk.UNCOMPRESSED;
            ECPoint w = ((ECPublicKey) keyPairZza.getPublic()).getW();
            EllipticCurve curve = zzyi.zza(zzylVarZzc).getCurve();
            zzmt.zza(w, curve);
            int iZza = zzyi.zza(curve);
            int iOrdinal = zzykVar.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    int i = iZza + 1;
                    bArr = new byte[i];
                    byte[] bArrZza2 = zzmo.zza(w.getAffineX());
                    System.arraycopy(bArrZza2, 0, bArr, i - bArrZza2.length, bArrZza2.length);
                    bArr[0] = (byte) (w.getAffineY().testBit(0) ? 3 : 2);
                } else {
                    if (iOrdinal != 2) {
                        throw new GeneralSecurityException("invalid format:" + String.valueOf(zzykVar));
                    }
                    int i2 = iZza * 2;
                    bArr = new byte[i2];
                    byte[] bArrZza3 = zzmo.zza(w.getAffineX());
                    if (bArrZza3.length > iZza) {
                        bArrZza3 = Arrays.copyOfRange(bArrZza3, bArrZza3.length - iZza, bArrZza3.length);
                    }
                    byte[] bArrZza4 = zzmo.zza(w.getAffineY());
                    if (bArrZza4.length > iZza) {
                        bArrZza4 = Arrays.copyOfRange(bArrZza4, bArrZza4.length - iZza, bArrZza4.length);
                    }
                    System.arraycopy(bArrZza4, 0, bArr, i2 - bArrZza4.length, bArrZza4.length);
                    System.arraycopy(bArrZza3, 0, bArr, iZza - bArrZza3.length, bArrZza3.length);
                }
            } else {
                int i3 = (iZza * 2) + 1;
                bArr = new byte[i3];
                byte[] bArrZza5 = zzmo.zza(w.getAffineX());
                byte[] bArrZza6 = zzmo.zza(w.getAffineY());
                System.arraycopy(bArrZza6, 0, bArr, i3 - bArrZza6.length, bArrZza6.length);
                System.arraycopy(bArrZza5, 0, bArr, (iZza + 1) - bArrZza5.length, bArrZza5.length);
                bArr[0] = 4;
            }
            zzznVarZza = zzzn.zza(bArr);
            zzzoVarZza = zzzo.zza(zzmo.zza(((ECPrivateKey) keyPairZza.getPrivate()).getS(), zzlu.zza(zzjuVar.zze())), zzbl.zza());
        }
        return zzjx.zza(zzkf.zza(zzjuVar, zzznVarZza, num), zzzoVarZza);
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzij.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering HPKE Hybrid Encryption is not supported in FIPS mode");
        }
        zzjw.zza();
        zzok zzokVarZza = zzok.zza();
        HashMap map = new HashMap();
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zzju.zzc().zza(zzju.zzf.zza).zza(zzju.zzd.zzd).zza(zzju.zze.zza).zza(zzju.zza.zza).zza());
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzju.zzc().zza(zzju.zzf.zzc).zza(zzju.zzd.zzd).zza(zzju.zze.zza).zza(zzju.zza.zza).zza());
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzju.zzc().zza(zzju.zzf.zza).zza(zzju.zzd.zzd).zza(zzju.zze.zza).zza(zzju.zza.zzb).zza());
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzju.zzc().zza(zzju.zzf.zzc).zza(zzju.zzd.zzd).zza(zzju.zze.zza).zza(zzju.zza.zzb).zza());
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305", zzju.zzc().zza(zzju.zzf.zza).zza(zzju.zzd.zzd).zza(zzju.zze.zza).zza(zzju.zza.zzc).zza());
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305_RAW", zzju.zzc().zza(zzju.zzf.zzc).zza(zzju.zzd.zzd).zza(zzju.zze.zza).zza(zzju.zza.zzc).zza());
        map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zzju.zzc().zza(zzju.zzf.zza).zza(zzju.zzd.zza).zza(zzju.zze.zza).zza(zzju.zza.zza).zza());
        map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzju.zzc().zza(zzju.zzf.zzc).zza(zzju.zzd.zza).zza(zzju.zze.zza).zza(zzju.zza.zza).zza());
        map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzju.zzc().zza(zzju.zzf.zza).zza(zzju.zzd.zza).zza(zzju.zze.zza).zza(zzju.zza.zzb).zza());
        map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzju.zzc().zza(zzju.zzf.zzc).zza(zzju.zzd.zza).zza(zzju.zze.zza).zza(zzju.zza.zzb).zza());
        map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM", zzju.zzc().zza(zzju.zzf.zza).zza(zzju.zzd.zzb).zza(zzju.zze.zzb).zza(zzju.zza.zza).zza());
        map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM_RAW", zzju.zzc().zza(zzju.zzf.zzc).zza(zzju.zzd.zzb).zza(zzju.zze.zzb).zza(zzju.zza.zza).zza());
        map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM", zzju.zzc().zza(zzju.zzf.zza).zza(zzju.zzd.zzb).zza(zzju.zze.zzb).zza(zzju.zza.zzb).zza());
        map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM_RAW", zzju.zzc().zza(zzju.zzf.zzc).zza(zzju.zzd.zzb).zza(zzju.zze.zzb).zza(zzju.zza.zzb).zza());
        map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM", zzju.zzc().zza(zzju.zzf.zza).zza(zzju.zzd.zzc).zza(zzju.zze.zzc).zza(zzju.zza.zza).zza());
        map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM_RAW", zzju.zzc().zza(zzju.zzf.zzc).zza(zzju.zzd.zzc).zza(zzju.zze.zzc).zza(zzju.zza.zza).zza());
        map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM", zzju.zzc().zza(zzju.zzf.zza).zza(zzju.zzd.zzc).zza(zzju.zze.zzc).zza(zzju.zza.zzb).zza());
        map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM_RAW", zzju.zzc().zza(zzju.zzf.zzc).zza(zzju.zzd.zzc).zza(zzju.zze.zzc).zza(zzju.zza.zzb).zza());
        zzokVarZza.zza(Collections.unmodifiableMap(map));
        zzon.zza().zza(zza);
        zzon.zza().zza(zzb);
        zzoc.zza().zza(zze, zzju.class);
        zzna.zza().zza((zzbn) zzc, true);
        zzna.zza().zza((zzbn) zzd, false);
    }
}
