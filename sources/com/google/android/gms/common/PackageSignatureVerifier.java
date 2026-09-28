package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
public class PackageSignatureVerifier {
    static volatile zzai zza;
    private static zzaj zzb;

    private static zzaj zza(Context context) {
        zzaj zzajVar;
        synchronized (PackageSignatureVerifier.class) {
            if (zzb == null) {
                zzb = new zzaj(context);
            }
            zzajVar = zzb;
        }
        return zzajVar;
    }

    public PackageVerificationResult queryPackageSignatureVerified(Context context, String str) {
        boolean zHonorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(context);
        zza(context);
        if (!zzq.zze()) {
            throw new zzak();
        }
        String strConcat = String.valueOf(str).concat(true != zHonorsDebugCertificates ? "-0" : "-1");
        if (zza != null && zza.zza.equals(strConcat)) {
            return zza.zzb;
        }
        zza(context);
        zzy zzyVar = new zzy(null);
        zzyVar.zzc(str);
        zzyVar.zza(zHonorsDebugCertificates);
        zzyVar.zzb(false);
        zzad zzadVarZzb = zzq.zzb(zzyVar.zzd());
        if (zzadVarZzb.zza) {
            zza = new zzai(strConcat, PackageVerificationResult.zzd(str, zzadVarZzb.zze));
            return zza.zzb;
        }
        Preconditions.checkNotNull(zzadVarZzb.zzb);
        return PackageVerificationResult.zza(str, zzadVarZzb.zzb, zzadVarZzb.zzc);
    }

    public PackageVerificationResult queryPackageSignatureVerifiedWithRetry(Context context, String str) {
        try {
            PackageVerificationResult packageVerificationResultQueryPackageSignatureVerified = queryPackageSignatureVerified(context, str);
            packageVerificationResultQueryPackageSignatureVerified.zzb();
            return packageVerificationResultQueryPackageSignatureVerified;
        } catch (SecurityException e) {
            PackageVerificationResult packageVerificationResultQueryPackageSignatureVerified2 = queryPackageSignatureVerified(context, str);
            if (!packageVerificationResultQueryPackageSignatureVerified2.zzc()) {
                return packageVerificationResultQueryPackageSignatureVerified2;
            }
            Log.e("PkgSignatureVerifier", "Got flaky result during package signature verification", e);
            return packageVerificationResultQueryPackageSignatureVerified2;
        }
    }
}
