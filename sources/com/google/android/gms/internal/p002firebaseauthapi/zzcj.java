package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcj {
    @Deprecated
    static zzwb zza(String str, zzaiw zzaiwVar) throws GeneralSecurityException {
        zzbn<?> zzbnVarZza = zzna.zza().zza(str);
        if (zzbnVarZza instanceof zzci) {
            return ((zzci) zzbnVarZza).zzc(zzaiwVar);
        }
        throw new GeneralSecurityException("manager for key type " + str + " is not a PrivateKeyManager");
    }

    @Nullable
    public static Class<?> zza(Class<?> cls) {
        try {
            return zzon.zza().zza(cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public static <P> P zza(zzwb zzwbVar, Class<P> cls) throws GeneralSecurityException {
        String strZzf = zzwbVar.zzf();
        return zzna.zza().zza(strZzf, cls).zzb(zzwbVar.zze());
    }

    public static <B, P> P zza(zzpg<B> zzpgVar, Class<P> cls) throws GeneralSecurityException {
        return (P) zzon.zza().zza(zzpgVar, cls);
    }

    static {
        Logger.getLogger(zzcj.class.getName());
        new ConcurrentHashMap();
        HashSet hashSet = new HashSet();
        hashSet.add(zzbe.class);
        hashSet.add(zzbk.class);
        hashSet.add(zzcl.class);
        hashSet.add(zzbm.class);
        hashSet.add(zzbj.class);
        hashSet.add(zzcd.class);
        hashSet.add(zzrx.class);
        hashSet.add(zzch.class);
        hashSet.add(zzck.class);
        Collections.unmodifiableSet(hashSet);
    }

    private zzcj() {
    }
}
