package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzoc {
    private static final zzoe<zznp> zza = new zzoe() { // from class: com.google.android.gms.internal.firebase-auth-api.zzof
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoe
        public final zzbo zza(zzcg zzcgVar, Integer num) {
            return zzoc.zza((zznp) zzcgVar, num);
        }
    };
    private static final zzoc zzb = zzb();
    private final Map<Class<? extends zzcg>, zzoe<? extends zzcg>> zzc = new HashMap();

    public final zzbo zza(zzcg zzcgVar, @Nullable Integer num) throws GeneralSecurityException {
        return zzb(zzcgVar, num);
    }

    private final synchronized <ParametersT extends zzcg> zzbo zzb(ParametersT parameterst, @Nullable Integer num) throws GeneralSecurityException {
        zzoe<? extends zzcg> zzoeVar;
        zzoeVar = this.zzc.get(parameterst.getClass());
        if (zzoeVar == null) {
            throw new GeneralSecurityException("Cannot create a new key for parameters " + String.valueOf(parameterst) + ": no key creator for this class was registered.");
        }
        return zzoeVar.zza(parameterst, num);
    }

    public static /* synthetic */ zznn zza(zznp zznpVar, Integer num) throws GeneralSecurityException {
        zzwf zzwfVarZza = zznpVar.zzb().zza();
        zzbn<?> zzbnVarZza = zzna.zza().zza(zzwfVarZza.zzf());
        if (!zzna.zza().zzb(zzwfVarZza.zzf())) {
            throw new GeneralSecurityException("Creating new keys is not allowed.");
        }
        zzwb zzwbVarZza = zzbnVarZza.zza(zzwfVarZza.zze());
        return new zznn(zzpn.zza(zzwbVarZza.zzf(), zzwbVarZza.zze(), zzwbVarZza.zzb(), zzwfVarZza.zzd(), num), zzbl.zza());
    }

    public static zzoc zza() {
        return zzb;
    }

    private static zzoc zzb() {
        zzoc zzocVar = new zzoc();
        try {
            zzocVar.zza(zza, zznp.class);
            return zzocVar;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("unexpected error.", e);
        }
    }

    public final synchronized <ParametersT extends zzcg> void zza(zzoe<ParametersT> zzoeVar, Class<ParametersT> cls) throws GeneralSecurityException {
        zzoe<? extends zzcg> zzoeVar2 = this.zzc.get(cls);
        if (zzoeVar2 != null && !zzoeVar2.equals(zzoeVar)) {
            throw new GeneralSecurityException("Different key creator for parameters class " + String.valueOf(cls) + " already inserted");
        }
        this.zzc.put(cls, zzoeVar);
    }
}
