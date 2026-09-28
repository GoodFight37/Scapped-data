package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.internal.common.zzal;
import com.google.android.gms.internal.common.zzap;
import java.util.Arrays;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
public class GoogleSignatureVerifier {

    @Nullable
    private static GoogleSignatureVerifier zza;

    @Nullable
    private static volatile Set zzb;

    @Nullable
    private static volatile Set zzc;
    private final Context zzd;
    private volatile String zze;

    public GoogleSignatureVerifier(Context context) {
        this.zzd = context.getApplicationContext();
    }

    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zza == null) {
                zzq.zzd(context);
                zza = new GoogleSignatureVerifier(context);
            }
        }
        return zza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    static final boolean zza(PackageInfo packageInfo, boolean z) {
        zzal zzalVarZzm;
        if (z && packageInfo != null && ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName))) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            z = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
        }
        if (packageInfo == null) {
            return false;
        }
        try {
            zzal zzalVar = z ? zzp.zzc : zzp.zzb;
            int i = AndroidUtilsLight.zza;
            if (Build.VERSION.SDK_INT < 28) {
                byte[] byteArray = null;
                if (packageInfo.signatures != null && packageInfo.signatures.length == 1) {
                    byteArray = packageInfo.signatures[0].toByteArray();
                }
                zzalVarZzm = byteArray != null ? zzal.zzn(byteArray) : zzal.zzm();
            } else {
                com.google.android.gms.internal.common.zzv.zzd(Build.VERSION.SDK_INT >= 28);
                SigningInfo signingInfo = packageInfo.signingInfo;
                if (signingInfo == null || signingInfo.hasMultipleSigners() || signingInfo.getSigningCertificateHistory() == null) {
                    zzalVarZzm = zzal.zzm();
                } else {
                    int i2 = zzal.zzd;
                    com.google.android.gms.internal.common.zzah zzahVar = new com.google.android.gms.internal.common.zzah();
                    for (Signature signature : signingInfo.getSigningCertificateHistory()) {
                        zzahVar.zzb(signature.toByteArray());
                    }
                    zzalVarZzm = zzahVar.zzd();
                }
            }
            if (zzalVarZzm.isEmpty()) {
                throw new IllegalArgumentException("Unable to obtain package certificate history.");
            }
            zzal zzalVarZzh = zzalVarZzm.zzh();
            int size = zzalVarZzh.size();
            int i3 = 0;
            while (i3 < size) {
                byte[] bArr = (byte[]) zzalVarZzh.get(i3);
                zzap zzapVarListIterator = zzalVar.listIterator(0);
                do {
                    int i4 = i3 + 1;
                    if (!zzapVarListIterator.hasNext()) {
                        i3 = i4;
                    }
                } while (!Arrays.equals(bArr, (byte[]) zzapVarListIterator.next()));
                return true;
            }
            return false;
        } catch (IllegalArgumentException unused) {
            Log.i("GoogleSignatureVerifier", "package info is not set correctly");
            return (z ? zzb(packageInfo, zzp.zza) : zzb(packageInfo, zzp.zza[0])) != null;
        }
    }

    @Nullable
    private static zzm zzb(PackageInfo packageInfo, zzm... zzmVarArr) {
        if (packageInfo.signatures != null) {
            if (packageInfo.signatures.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            zzn zznVar = new zzn(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < zzmVarArr.length; i++) {
                if (zzmVarArr[i].equals(zznVar)) {
                    return zzmVarArr[i];
                }
            }
        }
        return null;
    }

    private final zzad zzc(@Nullable String str, boolean z, boolean z2) {
        zzad zzadVarZzc;
        if (str == null) {
            return zzad.zzc("null pkg");
        }
        if (str.equals(this.zze)) {
            return zzad.zzb();
        }
        if (zzq.zzf()) {
            zzy zzyVar = new zzy(null);
            zzyVar.zzc(str);
            zzyVar.zza(GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzd));
            zzyVar.zzb(true);
            zzadVarZzc = zzq.zzb(zzyVar.zzd());
        } else {
            try {
                PackageInfo packageInfo = this.zzd.getPackageManager().getPackageInfo(str, Build.VERSION.SDK_INT >= 28 ? 134217792 : 64);
                boolean zHonorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzd);
                if (packageInfo == null) {
                    zzadVarZzc = zzad.zzc("null pkg");
                } else if (packageInfo.signatures == null || packageInfo.signatures.length != 1) {
                    zzadVarZzc = zzad.zzc("single cert required");
                } else {
                    zzn zznVar = new zzn(packageInfo.signatures[0].toByteArray());
                    String str2 = packageInfo.packageName;
                    zzad zzadVarZza = zzq.zza(str2, zznVar, zHonorsDebugCertificates, false);
                    zzadVarZzc = (!zzadVarZza.zza || packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 2) == 0 || !zzq.zza(str2, zznVar, false, true).zza) ? zzadVarZza : zzad.zzc("debuggable release cert app rejected");
                }
            } catch (PackageManager.NameNotFoundException e) {
                return zzad.zzd("no pkg ".concat(str), e);
            }
        }
        if (zzadVarZzc.zza) {
            this.zze = str;
        }
        return zzadVarZzc;
    }

    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        if (zza(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzd)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean isPackageGoogleSigned(@Nullable String str) {
        zzad zzadVarZzc = zzc(str, false, false);
        zzadVarZzc.zze();
        return zzadVarZzc.zza;
    }

    public boolean isUidGoogleSigned(int i) {
        zzad zzadVarZzc;
        String[] packagesForUid = this.zzd.getPackageManager().getPackagesForUid(i);
        if (packagesForUid == null || (packagesForUid.length) == 0) {
            zzadVarZzc = zzad.zzc("no pkgs");
        } else {
            zzadVarZzc = null;
            for (String str : packagesForUid) {
                zzadVarZzc = zzc(str, false, false);
                if (!zzadVarZzc.zza) {
                }
            }
            Preconditions.checkNotNull(zzadVarZzc);
        }
        zzadVarZzc.zze();
        return zzadVarZzc.zza;
    }
}
