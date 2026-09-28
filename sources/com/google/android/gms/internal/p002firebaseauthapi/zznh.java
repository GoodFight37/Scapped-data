package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzbo;
import com.google.android.gms.internal.p002firebaseauthapi.zzpq;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zznh<KeyT extends zzbo, SerializationT extends zzpq> {
    private final Class<KeyT> zza;
    private final Class<SerializationT> zzb;

    public static <KeyT extends zzbo, SerializationT extends zzpq> zznh<KeyT, SerializationT> zza(zznj<KeyT, SerializationT> zznjVar, Class<KeyT> cls, Class<SerializationT> cls2) {
        return new zzng(cls, cls2, zznjVar);
    }

    public abstract SerializationT zza(KeyT keyt, @Nullable zzcm zzcmVar) throws GeneralSecurityException;

    public final Class<KeyT> zza() {
        return this.zza;
    }

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }

    private zznh(Class<KeyT> cls, Class<SerializationT> cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }
}
