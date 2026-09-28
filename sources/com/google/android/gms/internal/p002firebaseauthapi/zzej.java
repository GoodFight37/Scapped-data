package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzej implements zzbe {
    private static final byte[] zza = new byte[0];
    private static final Set<String> zzb;
    private final String zzc;
    private final zzcg zzd;
    private final zzbe zze;

    public static zzbe zza(zzcr zzcrVar, zzbe zzbeVar) throws GeneralSecurityException {
        try {
            return new zzej(zzwf.zza(zzco.zza(zzcrVar), zzajv.zza()), zzbeVar);
        } catch (zzakm e) {
            throw new GeneralSecurityException(e);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = Collections.unmodifiableSet(hashSet);
    }

    @Deprecated
    private zzej(zzwf zzwfVar, zzbe zzbeVar) throws GeneralSecurityException {
        if (!zzb.contains(zzwfVar.zzf())) {
            throw new IllegalArgumentException("Unsupported DEK key type: " + zzwfVar.zzf() + ". Only Tink AEAD key types are supported.");
        }
        this.zzc = zzwfVar.zzf();
        this.zzd = zzco.zza(((zzwf) ((zzakg) zzwf.zza(zzwfVar).zza(zzxd.RAW).zze())).zzk());
        this.zze = zzbeVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            int i = byteBufferWrap.getInt();
            if (i <= 0 || i > 4096 || i > bArr.length - 4) {
                throw new GeneralSecurityException("length of encrypted DEK too large");
            }
            byte[] bArr3 = new byte[i];
            byteBufferWrap.get(bArr3, 0, i);
            byte[] bArr4 = new byte[byteBufferWrap.remaining()];
            byteBufferWrap.get(bArr4, 0, byteBufferWrap.remaining());
            return ((zzbe) zzon.zza().zza(zzom.zza().zza(zzpn.zza(this.zzc, zzaiw.zza(this.zze.zza(bArr3, zza)), zzwb.zza.SYMMETRIC, zzxd.RAW, null), zzbl.zza()), zzbe.class)).zza(bArr4, bArr2);
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e) {
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzbo zzboVarZza = zzoc.zza().zza(this.zzd, (Integer) null);
        byte[] bArrZzb = this.zze.zzb(((zzpn) zzom.zza().zza(zzboVarZza, zzpn.class, zzbl.zza())).zzd().zzd(), zza);
        if (bArrZzb.length > 4096) {
            throw new GeneralSecurityException("length of encrypted DEK too large");
        }
        byte[] bArrZzb2 = ((zzbe) zzon.zza().zza(zzboVarZza, zzbe.class)).zzb(bArr, bArr2);
        return ByteBuffer.allocate(bArrZzb.length + 4 + bArrZzb2.length).putInt(bArrZzb.length).put(bArrZzb).put(bArrZzb2).array();
    }
}
