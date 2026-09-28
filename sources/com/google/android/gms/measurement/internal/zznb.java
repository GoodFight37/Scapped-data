package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
final class zznb implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcy zzb;
    final /* synthetic */ zzny zzc;

    zznb(zzny zznyVar, zzr zzrVar, com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        this.zza = zzrVar;
        this.zzb = zzcyVar;
        this.zzc = zznyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.internal.measurement.zzcy zzcyVar;
        zzqf zzqfVarZzw;
        String strZzf = null;
        try {
            try {
                zzny zznyVar = this.zzc;
                zzio zzioVar = zznyVar.zzu;
                if (zzioVar.zzm().zzh().zzr(zzjw.ANALYTICS_STORAGE)) {
                    zzgl zzglVar = zznyVar.zzb;
                    if (zzglVar != null) {
                        zzr zzrVar = this.zza;
                        Preconditions.checkNotNull(zzrVar);
                        strZzf = zzglVar.zzf(zzrVar);
                        if (strZzf != null) {
                            zznyVar.zzu.zzq().zzac(strZzf);
                            zzioVar.zzm().zze.zzb(strZzf);
                        }
                        zznyVar.zzag();
                        zzny zznyVar2 = this.zzc;
                        zzcyVar = this.zzb;
                        zzqfVarZzw = zznyVar2.zzu.zzw();
                        zzqfVarZzw.zzZ(zzcyVar, strZzf);
                    }
                    zzioVar.zzaW().zze().zza("Failed to get app instance id");
                } else {
                    zzioVar.zzaW().zzl().zza("Analytics storage consent denied; will not get app instance id");
                    zznyVar.zzu.zzq().zzac(null);
                    zzioVar.zzm().zze.zzb(null);
                }
                zzqfVarZzw = zzioVar.zzw();
                zzcyVar = this.zzb;
            } catch (RemoteException e) {
                this.zzc.zzu.zzaW().zze().zzb("Failed to get app instance id", e);
            }
            zzqfVarZzw.zzZ(zzcyVar, strZzf);
        } catch (Throwable th) {
            zzny zznyVar3 = this.zzc;
            zznyVar3.zzu.zzw().zzZ(this.zzb, null);
            throw th;
        }
    }
}
