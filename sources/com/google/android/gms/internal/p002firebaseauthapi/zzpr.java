package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzpr extends zzmz {
    private static final zzpr zza = new zzpr();

    public static zzpr zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmz
    @Nullable
    public final Class<?> zza(Class<?> cls) {
        return zzcj.zza(cls);
    }

    public static <P> P zza(zzwb zzwbVar, Class<P> cls) throws GeneralSecurityException {
        return (P) zzcj.zza(zzwbVar, cls);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmz
    public final <P> P zza(zzbo zzboVar, Class<P> cls) throws GeneralSecurityException {
        return (P) zzon.zza().zza(zzboVar, cls);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmz
    public final <B, P> P zza(zzpg<B> zzpgVar, Class<P> cls) throws GeneralSecurityException {
        return (P) zzcj.zza(zzpgVar, cls);
    }

    private zzpr() {
    }
}
