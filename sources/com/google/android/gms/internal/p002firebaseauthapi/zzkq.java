package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzkq {
    public static final zzwf zza;
    private static final byte[] zzb;

    @Deprecated
    private static zzwf zza(zzuw zzuwVar, zzvc zzvcVar, zzuf zzufVar, zzwf zzwfVar, zzxd zzxdVar, byte[] bArr) {
        zzuh.zza zzaVarZza = zzuh.zza();
        zzut zzutVar = (zzut) ((zzakg) zzut.zza().zza(zzuwVar).zza(zzvcVar).zza(zzaiw.zza(bArr)).zze());
        return (zzwf) ((zzakg) zzwf.zza().zza(zzjm.zza()).zza(zzxdVar).zza(((zzuh) ((zzakg) zzaVarZza.zza((zzuk) ((zzakg) zzuk.zzc().zza(zzutVar).zza((zzue) ((zzakg) zzue.zza().zza(zzwfVar).zze())).zza(zzufVar).zze())).zze())).zzj()).zze());
    }

    static {
        byte[] bArr = new byte[0];
        zzb = bArr;
        zza = zza(zzuw.NIST_P256, zzvc.SHA256, zzuf.UNCOMPRESSED, zzcs.zza, zzxd.TINK, bArr);
        zza(zzuw.NIST_P256, zzvc.SHA256, zzuf.COMPRESSED, zzcs.zza, zzxd.RAW, bArr);
        zza(zzuw.NIST_P256, zzvc.SHA256, zzuf.UNCOMPRESSED, zzcs.zzb, zzxd.TINK, bArr);
    }
}
