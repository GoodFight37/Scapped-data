package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzq {
    private static volatile com.google.android.gms.common.internal.zzaf zzg;
    private static Context zzi;
    static final zzo zza = new zzg(zzm.zze("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u007f¢fú§p\u0085xb±"));
    static final zzo zzb = new zzh(zzm.zze("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014QÕÛ\u0004÷XçB\u0086<"));
    static final zzo zzc = new zzi(zzm.zze("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
    static final zzo zzd = new zzj(zzm.zze("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
    static final zzo zze = new zzk(zzm.zze("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
    static final zzo zzf = new zzl(zzm.zze("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
    private static final Object zzh = new Object();

    @Deprecated
    static zzad zza(String str, zzm zzmVar, boolean z, boolean z2) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return zzh(str, zzmVar, z, z2);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    static zzad zzb(zzaa zzaaVar) {
        zzad zzadVarZzd;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Preconditions.checkNotNull(zzi);
            try {
                zzi();
                Preconditions.checkNotNull(zzi);
                zzs zzsVarZza = zzaaVar.zza(zzi);
                try {
                    zzadVarZzd = zzg(zzaaVar.zzb() ? zzg.zze(zzsVarZza) : zzg.zzf(zzsVarZza));
                } catch (RemoteException e) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                    zzadVarZzd = zzad.zzd("module call", e);
                }
            } catch (DynamiteModule.LoadingException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                zzadVarZzd = zzad.zzd("module init: ".concat(String.valueOf(e2.getMessage())), e2);
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return zzadVarZzd;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    static /* synthetic */ String zzc(boolean z, String str, zzm zzmVar) throws Exception {
        String str2 = (z || !zzh(str, zzmVar, true, false).zza) ? "not allowed" : "debug cert rejected";
        MessageDigest messageDigestZza = AndroidUtilsLight.zza("SHA-256");
        Preconditions.checkNotNull(messageDigestZza);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str2, str, Hex.bytesToStringLowercase(messageDigestZza.digest(zzmVar.zzf())), Boolean.valueOf(z), "12451000.false");
    }

    static synchronized void zzd(Context context) {
        if (zzi != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            zzi = context.getApplicationContext();
        }
    }

    static boolean zze() {
        boolean zZzg;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                zzi();
                zZzg = zzg.zzg();
            } catch (RemoteException | DynamiteModule.LoadingException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                zZzg = false;
            }
            return zZzg;
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    static boolean zzf() {
        boolean zZzi;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                zzi();
                zZzi = zzg.zzi();
            } catch (RemoteException | DynamiteModule.LoadingException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                zZzi = false;
            }
            return zZzi;
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    private static zzad zzg(zzu zzuVar) {
        if (zzuVar.zzd()) {
            zzu zzuVarZzb = zzuVar.zzb();
            return zzad.zzf(zzuVar.zze(), zzuVar.zza(), zzuVarZzb != null ? zzg(zzuVarZzb) : null);
        }
        String strZzc = zzuVar.zzc();
        PackageManager.NameNotFoundException nameNotFoundException = zzuVar.zzf() == 4 ? new PackageManager.NameNotFoundException() : null;
        if (strZzc == null) {
            strZzc = "error checking package certificate";
        }
        return zzad.zzg(zzuVar.zze(), zzuVar.zzf(), strZzc, nameNotFoundException);
    }

    @Deprecated
    private static zzad zzh(final String str, final zzm zzmVar, final boolean z, boolean z2) {
        try {
            zzi();
            Preconditions.checkNotNull(zzi);
            try {
                return zzg.zzh(new zzw(str, zzmVar, z, z2), ObjectWrapper.wrap(zzi.getPackageManager())) ? zzad.zzb() : new zzab(new Callable() { // from class: com.google.android.gms.common.zzf
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return zzq.zzc(z, str, zzmVar);
                    }
                }, null);
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                return zzad.zzd("module call", e);
            }
        } catch (DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            return zzad.zzd("module init: ".concat(String.valueOf(e2.getMessage())), e2);
        }
    }

    private static void zzi() throws DynamiteModule.LoadingException {
        if (zzg != null) {
            return;
        }
        Preconditions.checkNotNull(zzi);
        synchronized (zzh) {
            if (zzg == null) {
                zzg = com.google.android.gms.common.internal.zzae.zzb(DynamiteModule.load(zzi, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
            }
        }
    }
}
