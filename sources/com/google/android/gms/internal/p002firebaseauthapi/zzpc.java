package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzpc {
    private final Map<zzpe, zzoy<?, ?>> zza;
    private final Map<Class<?>, zzpk<?, ?>> zzb;

    public static zzpf zza() {
        return new zzpf();
    }

    public static zzpf zza(zzpc zzpcVar) {
        return new zzpf(zzpcVar);
    }

    public final Class<?> zza(Class<?> cls) throws GeneralSecurityException {
        if (!this.zzb.containsKey(cls)) {
            throw new GeneralSecurityException("No input primitive class for " + String.valueOf(cls) + " available");
        }
        return this.zzb.get(cls).zza();
    }

    public final <KeyT extends zzbo, PrimitiveT> PrimitiveT zza(KeyT keyt, Class<PrimitiveT> cls) throws GeneralSecurityException {
        zzpe zzpeVar = new zzpe(keyt.getClass(), cls);
        if (!this.zza.containsKey(zzpeVar)) {
            throw new GeneralSecurityException("No PrimitiveConstructor for " + String.valueOf(zzpeVar) + " available");
        }
        return (PrimitiveT) this.zza.get(zzpeVar).zza(keyt);
    }

    public final <InputPrimitiveT, WrapperPrimitiveT> WrapperPrimitiveT zza(zzpg<InputPrimitiveT> zzpgVar, Class<WrapperPrimitiveT> cls) throws GeneralSecurityException {
        if (!this.zzb.containsKey(cls)) {
            throw new GeneralSecurityException("No wrapper found for " + String.valueOf(cls));
        }
        zzpk<?, ?> zzpkVar = this.zzb.get(cls);
        if (!zzpgVar.zzc().equals(zzpkVar.zza()) || !zzpkVar.zza().equals(zzpgVar.zzc())) {
            throw new GeneralSecurityException("Input primitive type of the wrapper doesn't match the type of primitives in the provided PrimitiveSet");
        }
        return (WrapperPrimitiveT) zzpkVar.zza(zzpgVar);
    }

    private zzpc(zzpf zzpfVar) {
        this.zza = new HashMap(zzpfVar.zza);
        this.zzb = new HashMap(zzpfVar.zzb);
    }
}
