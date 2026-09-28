package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzpt {
    private final Map<zzpu, zznh<?, ?>> zza;
    private final Map<zzpv, zznd<?>> zzb;
    private final Map<zzpu, zzou<?, ?>> zzc;
    private final Map<zzpv, zzoq<?>> zzd;

    public final <SerializationT extends zzpq> zzbo zza(SerializationT serializationt, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        zzpv zzpvVar = new zzpv(serializationt.getClass(), serializationt.zzb());
        if (this.zzb.containsKey(zzpvVar)) {
            return this.zzb.get(zzpvVar).zza(serializationt, zzcmVar);
        }
        throw new GeneralSecurityException("No Key Parser for requested key type " + String.valueOf(zzpvVar) + " available");
    }

    public final <SerializationT extends zzpq> zzcg zza(SerializationT serializationt) throws GeneralSecurityException {
        zzpv zzpvVar = new zzpv(serializationt.getClass(), serializationt.zzb());
        if (!this.zzd.containsKey(zzpvVar)) {
            throw new GeneralSecurityException("No Parameters Parser for requested key type " + String.valueOf(zzpvVar) + " available");
        }
        return this.zzd.get(zzpvVar).zza(serializationt);
    }

    public final <KeyT extends zzbo, SerializationT extends zzpq> SerializationT zza(KeyT keyt, Class<SerializationT> cls, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        zzpu zzpuVar = new zzpu(keyt.getClass(), cls);
        if (!this.zza.containsKey(zzpuVar)) {
            throw new GeneralSecurityException("No Key serializer for " + String.valueOf(zzpuVar) + " available");
        }
        return (SerializationT) this.zza.get(zzpuVar).zza(keyt, zzcmVar);
    }

    public final <ParametersT extends zzcg, SerializationT extends zzpq> SerializationT zza(ParametersT parameterst, Class<SerializationT> cls) throws GeneralSecurityException {
        zzpu zzpuVar = new zzpu(parameterst.getClass(), cls);
        if (!this.zzc.containsKey(zzpuVar)) {
            throw new GeneralSecurityException("No Key Format serializer for " + String.valueOf(zzpuVar) + " available");
        }
        return (SerializationT) this.zzc.get(zzpuVar).zza(parameterst);
    }

    private zzpt(zzps zzpsVar) {
        this.zza = new HashMap(zzpsVar.zza);
        this.zzb = new HashMap(zzpsVar.zzb);
        this.zzc = new HashMap(zzpsVar.zzc);
        this.zzd = new HashMap(zzpsVar.zzd);
    }

    public final <SerializationT extends zzpq> boolean zzb(SerializationT serializationt) {
        return this.zzb.containsKey(new zzpv(serializationt.getClass(), serializationt.zzb()));
    }

    public final <SerializationT extends zzpq> boolean zzc(SerializationT serializationt) {
        return this.zzd.containsKey(new zzpv(serializationt.getClass(), serializationt.zzb()));
    }
}
