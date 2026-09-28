package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: Add missing generic type declarations: [KeyT, SerializationT] */
/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzng<KeyT, SerializationT> extends zznh<KeyT, SerializationT> {
    private final /* synthetic */ zznj zza;

    /* JADX WARN: Incorrect return type in method signature: (TKeyT;Lcom/google/android/gms/internal/firebase-auth-api/zzcm;)TSerializationT; */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zznh
    public final zzpq zza(zzbo zzboVar, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        return this.zza.zza(zzboVar, zzcmVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzng(Class cls, Class cls2, zznj zznjVar) {
        super(cls, cls2);
        this.zza = zznjVar;
    }
}
