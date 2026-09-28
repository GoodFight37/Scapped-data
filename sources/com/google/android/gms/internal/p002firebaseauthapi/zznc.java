package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: Add missing generic type declarations: [SerializationT] */
/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zznc<SerializationT> extends zznd<SerializationT> {
    private final /* synthetic */ zznf zza;

    /* JADX WARN: Incorrect types in method signature: (TSerializationT;Lcom/google/android/gms/internal/firebase-auth-api/zzcm;)Lcom/google/android/gms/internal/firebase-auth-api/zzbo; */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zznd
    public final zzbo zza(zzpq zzpqVar, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        return this.zza.zza(zzpqVar, zzcmVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zznc(zzzn zzznVar, Class cls, zznf zznfVar) {
        super(zzznVar, cls);
        this.zza = zznfVar;
    }
}
