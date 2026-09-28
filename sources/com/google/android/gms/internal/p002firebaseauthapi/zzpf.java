package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzpf {
    private final Map<zzpe, zzoy<?, ?>> zza;
    private final Map<Class<?>, zzpk<?, ?>> zzb;

    public final <KeyT extends zzbo, PrimitiveT> zzpf zza(zzoy<KeyT, PrimitiveT> zzoyVar) throws GeneralSecurityException {
        if (zzoyVar == null) {
            throw new NullPointerException("primitive constructor must be non-null");
        }
        zzpe zzpeVar = new zzpe(zzoyVar.zza(), zzoyVar.zzb());
        if (this.zza.containsKey(zzpeVar)) {
            zzoy<?, ?> zzoyVar2 = this.zza.get(zzpeVar);
            if (!zzoyVar2.equals(zzoyVar) || !zzoyVar.equals(zzoyVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: " + String.valueOf(zzpeVar));
            }
        } else {
            this.zza.put(zzpeVar, zzoyVar);
        }
        return this;
    }

    public final <InputPrimitiveT, WrapperPrimitiveT> zzpf zza(zzpk<InputPrimitiveT, WrapperPrimitiveT> zzpkVar) throws GeneralSecurityException {
        if (zzpkVar == null) {
            throw new NullPointerException("wrapper must be non-null");
        }
        Class<WrapperPrimitiveT> clsZzb = zzpkVar.zzb();
        if (this.zzb.containsKey(clsZzb)) {
            zzpk<?, ?> zzpkVar2 = this.zzb.get(clsZzb);
            if (!zzpkVar2.equals(zzpkVar) || !zzpkVar.equals(zzpkVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type" + String.valueOf(clsZzb));
            }
        } else {
            this.zzb.put(clsZzb, zzpkVar);
        }
        return this;
    }

    public final zzpc zza() {
        return new zzpc(this);
    }

    private zzpf() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    private zzpf(zzpc zzpcVar) {
        this.zza = new HashMap(zzpcVar.zza);
        this.zzb = new HashMap(zzpcVar.zzb);
    }
}
