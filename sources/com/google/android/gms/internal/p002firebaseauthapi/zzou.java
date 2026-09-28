package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzcg;
import com.google.android.gms.internal.p002firebaseauthapi.zzpq;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzou<ParametersT extends zzcg, SerializationT extends zzpq> {
    private final Class<ParametersT> zza;
    private final Class<SerializationT> zzb;

    public static <ParametersT extends zzcg, SerializationT extends zzpq> zzou<ParametersT, SerializationT> zza(zzow<ParametersT, SerializationT> zzowVar, Class<ParametersT> cls, Class<SerializationT> cls2) {
        return new zzox(cls, cls2, zzowVar);
    }

    public abstract SerializationT zza(ParametersT parameterst) throws GeneralSecurityException;

    public final Class<ParametersT> zza() {
        return this.zza;
    }

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }

    private zzou(Class<ParametersT> cls, Class<SerializationT> cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }
}
