package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzgg {
    private static final Object zza = new Object();
    private final String zzb;
    private final zzge zzc;
    private final Object zzd;
    private final Object zze = new Object();
    private volatile Object zzf = null;
    private volatile Object zzg = null;

    /* synthetic */ zzgg(String str, Object obj, Object obj2, zzge zzgeVar, zzgh zzghVar) {
        this.zzb = str;
        this.zzd = obj;
        this.zzc = zzgeVar;
    }

    public final Object zza(Object obj) {
        synchronized (this.zze) {
        }
        if (obj != null) {
            return obj;
        }
        if (zzgf.zza == null) {
            return this.zzd;
        }
        synchronized (zza) {
            if (zzaf.zza()) {
                return this.zzg == null ? this.zzd : this.zzg;
            }
            try {
                for (zzgg zzggVar : zzgi.zzbs) {
                    if (zzaf.zza()) {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                    Object objZza = null;
                    try {
                        zzge zzgeVar = zzggVar.zzc;
                        if (zzgeVar != null) {
                            objZza = zzgeVar.zza();
                        }
                    } catch (IllegalStateException unused) {
                    }
                    synchronized (zza) {
                        zzggVar.zzg = objZza;
                    }
                }
            } catch (SecurityException unused2) {
            }
            zzge zzgeVar2 = this.zzc;
            if (zzgeVar2 != null) {
                try {
                    return zzgeVar2.zza();
                } catch (IllegalStateException | SecurityException unused3) {
                }
            }
            return this.zzd;
        }
    }

    public final String zzb() {
        return this.zzb;
    }
}
