package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzpq;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzoq<SerializationT extends zzpq> {
    private final zzzn zza;
    private final Class<SerializationT> zzb;

    public static <SerializationT extends zzpq> zzoq<SerializationT> zza(zzos<SerializationT> zzosVar, zzzn zzznVar, Class<SerializationT> cls) {
        return new zzot(zzznVar, cls, zzosVar);
    }

    public abstract zzcg zza(SerializationT serializationt) throws GeneralSecurityException;

    public final zzzn zza() {
        return this.zza;
    }

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }

    private zzoq(zzzn zzznVar, Class<SerializationT> cls) {
        this.zza = zzznVar;
        this.zzb = cls;
    }
}
