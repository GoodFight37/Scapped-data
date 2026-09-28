package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzna {
    private static final Logger zza = Logger.getLogger(zzna.class.getName());
    private static final zzna zzb = new zzna();
    private ConcurrentMap<String, zzbn<?>> zzc = new ConcurrentHashMap();
    private ConcurrentMap<String, Boolean> zzd = new ConcurrentHashMap();

    public final <P> zzbn<P> zza(String str, Class<P> cls) throws GeneralSecurityException {
        zzbn<P> zzbnVar = (zzbn<P>) zzc(str);
        if (zzbnVar.zza().equals(cls)) {
            return zzbnVar;
        }
        throw new GeneralSecurityException("Primitive type " + cls.getName() + " not supported by key manager of type " + String.valueOf(zzbnVar.getClass()) + ", which only supports: " + String.valueOf(zzbnVar.zza()));
    }

    private final synchronized zzbn<?> zzc(String str) throws GeneralSecurityException {
        if (!this.zzc.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type " + str);
        }
        return this.zzc.get(str);
    }

    public final zzbn<?> zza(String str) throws GeneralSecurityException {
        return zzc(str);
    }

    public static zzna zza() {
        return zzb;
    }

    private final synchronized void zza(zzbn<?> zzbnVar, boolean z, boolean z2) throws GeneralSecurityException {
        String strZzb = zzbnVar.zzb();
        if (z2 && this.zzd.containsKey(strZzb) && !this.zzd.get(strZzb).booleanValue()) {
            throw new GeneralSecurityException("New keys are already disallowed for key type " + strZzb);
        }
        zzbn<?> zzbnVar2 = this.zzc.get(strZzb);
        if (zzbnVar2 != null && !zzbnVar2.getClass().equals(zzbnVar.getClass())) {
            zza.logp(Level.WARNING, "com.google.crypto.tink.internal.KeyManagerRegistry", "insertKeyManager", "Attempted overwrite of a registered key manager for key type " + strZzb);
            throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", strZzb, zzbnVar2.getClass().getName(), zzbnVar.getClass().getName()));
        }
        this.zzc.putIfAbsent(strZzb, zzbnVar);
        this.zzd.put(strZzb, Boolean.valueOf(z2));
    }

    public final synchronized <P> void zza(zzbn<P> zzbnVar, boolean z) throws GeneralSecurityException {
        zza(zzbnVar, zzij.zza.zza, z);
    }

    public final synchronized <P> void zza(zzbn<P> zzbnVar, zzij.zza zzaVar, boolean z) throws GeneralSecurityException {
        if (!zzaVar.zza()) {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
        zza((zzbn<?>) zzbnVar, false, z);
    }

    public final boolean zzb(String str) {
        return this.zzd.get(str).booleanValue();
    }
}
