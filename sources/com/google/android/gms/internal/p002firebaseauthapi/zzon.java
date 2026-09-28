package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzon {
    private static zzon zza = new zzon();
    private final AtomicReference<zzpc> zzb = new AtomicReference<>(zzpc.zza().zza());

    public static zzon zza() {
        return zza;
    }

    public final <WrapperPrimitiveT> Class<?> zza(Class<WrapperPrimitiveT> cls) throws GeneralSecurityException {
        return this.zzb.get().zza((Class<?>) cls);
    }

    public final <KeyT extends zzbo, PrimitiveT> PrimitiveT zza(KeyT keyt, Class<PrimitiveT> cls) throws GeneralSecurityException {
        return (PrimitiveT) this.zzb.get().zza(keyt, cls);
    }

    public final <InputPrimitiveT, WrapperPrimitiveT> WrapperPrimitiveT zza(zzpg<InputPrimitiveT> zzpgVar, Class<WrapperPrimitiveT> cls) throws GeneralSecurityException {
        return (WrapperPrimitiveT) this.zzb.get().zza(zzpgVar, cls);
    }

    zzon() {
    }

    public final synchronized <KeyT extends zzbo, PrimitiveT> void zza(zzoy<KeyT, PrimitiveT> zzoyVar) throws GeneralSecurityException {
        this.zzb.set(zzpc.zza(this.zzb.get()).zza(zzoyVar).zza());
    }

    public final synchronized <InputPrimitiveT, WrapperPrimitiveT> void zza(zzpk<InputPrimitiveT, WrapperPrimitiveT> zzpkVar) throws GeneralSecurityException {
        this.zzb.set(zzpc.zza(this.zzb.get()).zza(zzpkVar).zza());
    }
}
