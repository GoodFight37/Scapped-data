package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zznk<P> extends zznl<P> implements zzci<P> {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzci
    public final zzwb zzc(zzaiw zzaiwVar) throws GeneralSecurityException {
        Object objZza = zzom.zza().zza(zzpn.zza(this.zza, zzaiwVar, this.zzb, zzxd.RAW, null), zzbl.zza());
        if (!(objZza instanceof zzcf)) {
            throw new GeneralSecurityException("Key not private key");
        }
        zzpn zzpnVar = (zzpn) zzom.zza().zza(((zzcf) objZza).zzb(), zzpn.class, zzbl.zza());
        return (zzwb) ((zzakg) zzwb.zza().zza(zzpnVar.zzf()).zza(zzpnVar.zzd()).zza(zzpnVar.zza()).zze());
    }

    protected zznk(String str, Class<P> cls, zzalw<? extends zzaln> zzalwVar) {
        super(str, cls, zzwb.zza.ASYMMETRIC_PRIVATE, zzalwVar);
    }
}
